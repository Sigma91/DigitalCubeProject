package glavni;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.xml.sax.SAXException;

import metode.XmlMetode;
import model.Sport;

public class TestKlasa {

	public static void main(String[] args) {
		
		List<Sport> listaSportova = new ArrayList<Sport>();
		
		try {
			listaSportova = XmlMetode.parseSportsXML();
			for(Sport s: listaSportova) {
				System.out.println(s.getId() + " " + s.getName());
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
		
		SessionFactory factory = new Configuration()
				 .configure()
				 .buildSessionFactory();

Session sesija = factory.openSession();
sesija.beginTransaction();

try{
	listaSportova = XmlMetode.parseSportsXML();
 for(Sport s: listaSportova) {
	  sesija.save(s);
  }
}catch (Exception e) {
sesija.getTransaction().rollback();
}

sesija.close();



 }
}


