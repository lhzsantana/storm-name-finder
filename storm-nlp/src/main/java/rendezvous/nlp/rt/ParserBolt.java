package rendezvous.nlp.rt;

import java.util.Map;

import rendezvous.nlp.parser.PageParser;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class ParserBolt  extends BaseRichBolt {

	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		// TODO Auto-generated method stub

	}

	public void execute(Tuple input) {
		PageParser parser = new PageParser();
		parser.parse(input.getString(0));
		
		

	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub

	}
}
