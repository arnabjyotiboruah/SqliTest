package com.sql.pdf.generate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.context.annotation.Bean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sql.pdf.domain.Details;



public class ReadXml{
	
	
	public static Details readData() throws ParserConfigurationException, SAXException, IOException {

	    
		//Create a new document builder for the configuration.xml file
		
		String path = new File("src/main/resources/configuration.xml").getAbsolutePath();                                                        
		File file = new File(path);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("info");
		

//		Get the details from xml tag to the details class variables.
		
		Details details = new Details();
		if(nodeList.item(0).getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) nodeList.item(0);
			details.setDate(new Date());
			details.setHeaderImage(getTagValue("headerImage",element));
			details.setFooter(getTagValue("footer",element));
		}
		
		return details;
		
		
	}
//      Creating nodelist to insert elements from xml tag.
	private static String getTagValue(String tag, Element element) {
		NodeList nodelist = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodelist.item(0);
		return node.getNodeValue();
	}
}
