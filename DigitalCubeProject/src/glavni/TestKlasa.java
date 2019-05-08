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

List<Competitor> listaTakmicara = new ArrayList<Competitor>();
		
		try {
			listaTakmicara = XmlMetode.parseCompetitorsXML("event-11427861.xml");
			for(Competitor co: listaTakmicara) {
				System.out.println(co.getName() + " " + co.getShort_name() + " " + co.getCountry_code());
			
			}
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
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		Competitor comp = new Competitor();
		Competitor comp2 = new Competitor();
		try {
			competitors = XmlMetode.parseCompetitorsXML("event-11427861.xml");
			for(Competitor c: competitors) {
				System.out.println(c.getId() +  " " + c.getName() + " " +c.getCountry_code());
			}
			
			comp = XmlMetode.dajMiGostujucegTakmicara("event-11427861.xml");
			System.out.println("Gost: " + comp.getId() +  " " + comp.getName() + " " +comp.getCountry_code());
			
			comp2 = XmlMetode.dajMiDomacegTakmicara("event-11427861.xml");
			System.out.println("Domacin: " + comp2.getId() +  " " + comp2.getName() + " " +comp2.getCountry_code());
			
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
		
		
		//HIBERNATE 
		
		SessionFactory factory = new Configuration()
				 .configure()
				 .buildSessionFactory();

	Session sesija = factory.openSession();
	sesija.beginTransaction();

	try{
		listaTakmicara = XmlMetode.parseCompetitorsXML("event-11427861.xml");
		for(Competitor co: listaTakmicara) {
			sesija.save(co);			
		}		
		System.out.println("Uspesan unos");
		}catch (Exception e) {
	sesija.getTransaction().rollback();
	System.out.println("Ne uspesan unos");
	}
	sesija.close();
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


