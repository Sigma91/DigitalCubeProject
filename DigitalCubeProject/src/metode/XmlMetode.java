package metode;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Category;
import model.Competitor;
import model.Events;
import model.Sport;
import model.Tournament;

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
	   
	   public static Category parseCategoryXML(String xmlFajl) throws ParserConfigurationException, SAXException, IOException
	   {
	 
	      Category category = new Category();
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document document = builder.parse(new File(xmlFajl));
	      document.getDocumentElement().normalize();
	      	 NodeList nList = document.getElementsByTagName("category");
		         Node node = nList.item(0);
		         if (node.getNodeType() == Node.ELEMENT_NODE)
		         {
		            Element eElement = (Element) node;
		            category.setId(eElement.getAttribute("id"));
		         }
	         /*Nije nam potrebno jer se vuce automatski iz baze
	          * NodeList pList = document.getElementsByTagName("sport");
		         Node node1 = pList.item(0);
		         if (node1.getNodeType() == Node.ELEMENT_NODE)
		         {
		            Element eElement = (Element) node1;
		            category.setId_sport(eElement.getAttribute("id"));
		         }*/
		     NodeList qList = document.getElementsByTagName("venue");
		         Node node2 = qList.item(0);
		         if (node2.getNodeType() == Node.ELEMENT_NODE)
		         {
		            Element eElement = (Element) node2;
		            category.setName(eElement.getAttribute("country_name"));
		         }
	         

	      return category;
	   }
	   
	   public static List<Competitor> parseCompetitorsXML(String xmlFile) throws ParserConfigurationException, SAXException, IOException
	   {
	      //Initialize a list of competitors
	      List<Competitor> competitors = new ArrayList<Competitor>();
	      Competitor competitor = null;
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document document = builder.parse(new File(xmlFile));
	      document.getDocumentElement().normalize();
	      NodeList nList = document.getElementsByTagName("competitor");
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	            Element eElement = (Element) node;
	            
	            //Create new Competitor Object
	            competitor = new Competitor();
	            competitor.setId(eElement.getAttribute("id"));
	            competitor.setName(eElement.getAttribute("name"));
	            competitor.setCountry_code(eElement.getAttribute("country_code"));
	            competitor.setShort_name(eElement.getAttribute("short_name"));
	            //Add competitor to list
	            competitors.add(competitor);
	         }
	      }
	      return competitors;
	   }
	   
	   public static Competitor dajMiGostujucegTakmicara(String xmlFile) throws ParserConfigurationException, SAXException, IOException
	   {
	     
	      Competitor competitor = null;
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document document = builder.parse(new File(xmlFile));
	      document.getDocumentElement().normalize();
	      NodeList nList = document.getElementsByTagName("competitor");
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	            Element eElement = (Element) node;
	            
	            if(eElement.getAttribute("qualifier").equals("away")) {
		            //Create new Competitor Object
		            competitor = new Competitor();
		            competitor.setId(eElement.getAttribute("id"));
		            competitor.setName(eElement.getAttribute("name"));
		            competitor.setCountry_code(eElement.getAttribute("country_code"));
	            }
	         }
	      }
	      return competitor;
	   }
	   
	   public static Competitor dajMiDomacegTakmicara(String xmlFile) throws ParserConfigurationException, SAXException, IOException
	   {
	     
	      Competitor competitor = null;
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document document = builder.parse(new File(xmlFile));
	      document.getDocumentElement().normalize();
	      NodeList nList = document.getElementsByTagName("competitor");
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	            Element eElement = (Element) node;
	            
	            if(eElement.getAttribute("qualifier").equals("home")) {
		            //Create new Competitor Object
		            competitor = new Competitor();
		            competitor.setId(eElement.getAttribute("id"));
		            competitor.setName(eElement.getAttribute("name"));
		            competitor.setCountry_code(eElement.getAttribute("country_code"));
	            }
	         }
	      }
	      return competitor;
	   }
	   public static Tournament parseTournamentXML(String xmlFajl) throws ParserConfigurationException, SAXException, IOException
	   {
	 
	      Tournament tournament = new Tournament();
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document document = builder.parse(new File(xmlFajl));
	      document.getDocumentElement().normalize();
	      	 NodeList nList = document.getElementsByTagName("tournament");
		         Node node = nList.item(0);
		         if (node.getNodeType() == Node.ELEMENT_NODE)
		         {
		            Element eElement = (Element) node;
		            tournament.setId(eElement.getAttribute("id"));
		         }
	         /*Nije nam potrebno jer se vuce automatski iz baze
	          * NodeList pList = document.getElementsByTagName("category");
		         Node node1 = pList.item(0);
		         if (node1.getNodeType() == Node.ELEMENT_NODE)
		         {
		            Element eElement = (Element) node1;
		            tournament.setId_category(eElement.getAttribute("id"));
		         }*/
		     NodeList qList = document.getElementsByTagName("tournament");
		         Node node2 = qList.item(0);
		         if (node2.getNodeType() == Node.ELEMENT_NODE)
		         {
		            Element eElement = (Element) node2;
		            tournament.setName(eElement.getAttribute("name"));
		         }
	         

	      return tournament;
	   }
	   public static Events parseEventsXML(String xmlFajl) throws ParserConfigurationException, SAXException, IOException, ParseException
	   {
	 
	      Events event = new Events();
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document document = builder.parse(new File(xmlFajl));
	      document.getDocumentElement().normalize();
	      	 NodeList nList = document.getElementsByTagName("fixture");
		         Node node = nList.item(0);
		         if (node.getNodeType() == Node.ELEMENT_NODE)
		         {
		            Element eElement = (Element) node;
		            event.setId(eElement.getAttribute("id"));
		         }
	         NodeList pList = document.getElementsByTagName("fixture");
		         Node node1 = pList.item(0);
		         if (node1.getNodeType() == Node.ELEMENT_NODE)
		         {
		            Element eElement = (Element) node1;
		            event.setUtc_scheduled(eElement.getAttribute("scheduled"));
		            
		            
		            /*String input = "2017-09-23T13:15:00+00:00" ;
		            java.sql.Timestamp ts = java.sql.Timestamp.valueOf( input ) ;	*/            		            
		                
		         }
		     
	         

	      return event;
	   }
	   
	   

}
