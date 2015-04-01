package rendezvous.rt;

import java.util.Map;

import rendezvous.nlp.NameFinder;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

public class NameFinderBolt  extends BaseRichBolt {

	private static final long serialVersionUID = 1L;

	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		// TODO Auto-generated method stub

	}

	public void execute(Tuple input) {
		
		NameFinder nameFinder = new NameFinder();
		nameFinder.find(input.getString(0));

	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("links"));
		declarer.declare(new Fields("names"));
	}
}
