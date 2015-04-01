package rendezvous.rt;

import rendezvous.rt.util.StormRunner;
import backtype.storm.Config;
import backtype.storm.testing.TestWordSpout;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

public class TopologyStarter {

	private static final int DEFAULT_RUNTIME_IN_SECONDS = 60;
	private static final int TOP_N = 5;

	private final TopologyBuilder builder;
	private final String topologyName;
	private final Config topologyConfig;
	private final int runtimeInSeconds;

	public TopologyStarter() throws InterruptedException {
		builder = new TopologyBuilder();
		topologyName = "slidingWindowCounts";
		topologyConfig = createTopologyConfiguration();
		runtimeInSeconds = DEFAULT_RUNTIME_IN_SECONDS;

		wireTopology();
	}

	private static Config createTopologyConfiguration() {
		Config conf = new Config();
		conf.setDebug(true);
		return conf;
	}

	private void wireTopology() throws InterruptedException {
		String spoutId = "wordGenerator";
		String parserId = "parser";
		
		builder.setSpout(spoutId, new TestWordSpout(), 5);
		builder.setBolt(parserId, new ParserBolt(), 4)
			.fieldsGrouping(spoutId, new Fields("text"));
		builder.setBolt(parserId, new NameFinderBolt(), 4)
		.fieldsGrouping(spoutId, new Fields("text"));			
	}

	public void run() throws InterruptedException {
		StormRunner.runTopologyLocally(builder.createTopology(), topologyName,
				topologyConfig, runtimeInSeconds);
	}

	public static void main(String[] args) throws Exception {
		new TopologyStarter().run();
	}
}
