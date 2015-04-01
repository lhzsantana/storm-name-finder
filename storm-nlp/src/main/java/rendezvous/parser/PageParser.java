package rendezvous.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
 
public class PageParser {
	
	private Elements links;

	private String text;
	
	public Elements getLinks() {
		return links;
	}

	public String getText() {
		return text;
	}
	
	public void parse(String html){
		Document doc = Jsoup.parse(html);

        links = doc.select("a[href]");
				
		text = doc.text();
	}

}
