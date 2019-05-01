package glavni;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.xml.sax.SAXException;

import metode.XmlMetode;
import model.Category;
import model.Competitor;
import model.Events;
import model.Sport;
import model.Tournament;

public class TestKlasa {

	public static void main(String[] args) throws ParseException {
		
Competitor c = new Competitor();
		
		try {
			c = XmlMetode.parseCompetitorXML("event-11427861.xml");
			System.out.println(c.getId() +  " " + c.getName() + " " + c.getShort_name() + " " + c.getCountry_code());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
Tournament t = new Tournament();
		
		try {
			t = XmlMetode.parseTournamentXML("event-11427861.xml");
			System.out.println(t.getId() +  " " + t.getName());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
Events ev = new Events();
		
		try {
			ev = XmlMetode.parseEventsXML("event-11427861.xml");
			System.out.println(ev.getId() +  " " + ev.getUtc_scheduled());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
Category cat = new Category();
		
		try {
			cat = XmlMetode.parseCategoryXML("event-11427861.xml");
			System.out.println(cat.getId() +  " " + cat.getName());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*SessionFactory factory = new Configuration()
				 .configure()
				 .buildSessionFactory();

Session sesija = factory.openSession();
sesija.beginTransaction();

try{
	c = XmlMetode.parseSportsXML();
 for(Sport s: c) {
	  sesija.save(s);
  }
}catch (Exception e) {
sesija.getTransaction().rollback();
}

sesija.close();*/



 }
}


