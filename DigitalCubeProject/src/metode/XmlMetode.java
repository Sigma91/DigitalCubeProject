package metode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Sport;

public class XmlMetode {
	
	   public static List<Sport> parseSportsXML() throws ParserConfigurationException, SAXException, IOException
	   {
	      //Initialize a list of sports
	      List<Sport> sports = new ArrayList<Sport>();
	      Sport sport = null;
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document document = builder.parse(new File("sports.xml"));
	      document.getDocumentElement().normalize();
	      NodeList nList = document.getElementsByTagName("sport");
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	            Element eElement = (Element) node;
	            //Create new Sport Object
	            sport = new Sport();
	            sport.setId(eElement.getAttribute("id"));
	            sport.setName(eElement.getAttribute("name"));
	             
	            //Add Sport to list
	            sports.add(sport);
	         }
	      }
	      return sports;
	   }

}
