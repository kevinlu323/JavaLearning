package com.linkui.XML;

//import java.io.File;
import java.io.InputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLReader {
	// 配置文件名
	//private static String filename = "conf.xml";
	private static InputStream in = XMLReader.class.getClassLoader().getResourceAsStream("config/conf.xml");
	private static Config config;

	/**
	 * 从配置文件中读取参数并保存到Config类中, 很多时候程序中会多次使用到配置中的参数, 于是设置成静态方法,读取一次后就一直保存其中的参数，
	 * 不再反复读取
	 * 
	 * @return
	 */
	public static Config loadconfig() {
		if (config == null)
			config = getconfig();
		return config;
	}

	private static Config getconfig() {
		Config config = new Config();
		try {
			/*File f = new File(filename);
			if (!f.exists()) {
				System.out.println("Error : Config file doesn't exist!");
				System.exit(1);
			}*/
			if(in == null){
				System.out.println("config file is not exist!");
				System.exit(-1);
			}
			SAXReader reader = new SAXReader();
			Document doc;
			doc = reader.read(in);
			Element root = doc.getRootElement();
			Element data;
			Iterator<?> itr = root.elementIterator("VALUE");
			data = (Element) itr.next();

			config.server = data.elementText("server").trim();
			config.user = data.elementText("user").trim();
			config.pass = data.elementText("pass").trim();
			config.port = data.elementText("port").trim();
			config.dbname = data.elementText("dbname").trim();

		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
		return config;
	}
}
	