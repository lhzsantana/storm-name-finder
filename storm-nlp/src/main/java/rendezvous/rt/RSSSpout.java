package rendezvous.rt;

import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Values;

public class RSSSpout implements IRichSpout {

	SpoutOutputCollector _collector;
	Integer msgID = 0;

	public void ack(Object arg0) {
		// TODO Auto-generated method stub

	}

	public void activate() {
		// TODO Auto-generated method stub

	}

	public void close() {
		// TODO Auto-generated method stub

	}

	public void deactivate() {
		// TODO Auto-generated method stub

	}

	public void fail(Object arg0) {
		// TODO Auto-generated method stub

	}

	public void nextTuple() {
		Random _rand = new Random();
		String[] sentences = new String[] { "There two things benefit",
				" from Storms reliability capabilities",
				"Specifying a link in the",
				" tuple tree is " + "called anchoring",
				" Anchoring is done at ",
				"the same time you emit a " + "new tuple" };

		String message = sentences[_rand.nextInt(sentences.length)];
		_collector.emit(new Values(message), msgID);
		System.out.println(msgID + " " + message);

		msgID++;

	}

	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector arg2) {
		// TODO Auto-generated method stub

	}

	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub

	}

	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
