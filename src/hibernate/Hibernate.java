package hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernate {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("pom.xml").buildSessionFactory();    
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
//        Person person=new Person();
        
        //add person - 1
//        person.setName("Yaswanth");
//        person.setAddress("Andhra Pradesh");
//        s.save(person);
        
        //update
//        person.setId(7L);
//        person.setName("Yaswanth");
//        person.setAddress("Andhra Pradesh");
//        s.update(person);
        
        //delete
//        person.setId(7L);
//        s.delete(person);
        
        
        tx.commit();
        
        //get
        Criteria empCriteria = s.createCriteria(Person.class);
        List<Person> empList = empCriteria.list();
        for(Person e: empList) {
            System.out.println(e.getName() + " " + e.getAddress());
        }
        
        s.close();
        factory.close();
	}

}
