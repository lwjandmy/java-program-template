
import org.junit.Test;
import org.apache.commons.io.IOUtils;
import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AppTest {

	public void log(Object obj) {
		System.out.println(obj);
	}

	@Test
	public void test() throws Exception {
		String html = IOUtils.toString(this.getClass().getResourceAsStream("/web.html"), "UTF-8");
			
		Document doc = Jsoup.parse(html);
		
		Elements list = doc.select(".index_zb_main");
		
		for (Element main : list) {
			Elements title = main.select(".index_intro");
			
			Elements href = main.select(".index_img a");
			
			Elements time = main.select(".index_time span");
			
			log(String.format("%s\t%s\t%s", time.text(), title.text(), href.attr("href")));
		}
		
		
	}

}