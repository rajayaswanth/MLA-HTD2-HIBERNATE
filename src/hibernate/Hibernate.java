package hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernate {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("pom.xml").buildSessionFactory();    
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();

		Hibernate h = new Hibernate();
		//add person - 1
//		h.addPerson(s, "Yaswanth", "AP");

		//update
//		h.updatePerson(s, 9L, "Yaswanth", "A.P");

		//delete
//		h.deletePerson(s, 9L);

		tx.commit();

		//get
		h.getAllPersons(s);

		s.close();
		factory.close();
	}

	/*
	 * Add new person to the table
	 */
	public String addPerson(Session s, String name, String address) {
		Person person=new Person();
		person.setName(name);
		person.setAddress(address);
		s.save(person);
		return "added successfully";
	}


	/*
	 * Delete a person in the table using person id
	 */
	public String updatePerson(Session s, Long id, String name, String address) {
		Person person=new Person();
		person.setId(id);
		person.setName(name);
		person.setAddress(address);
		s.update(person);
		return "updated successfully";
	}


	/*
	 * Delete a person from the table using person id
	 */
	public String deletePerson(Session s, Long id) {
		Person person=new Person();
		person.setId(id);
		s.delete(person);
		return "deleted successfully";
	}

	/*
	 * Get all persons data from the person table
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public String getAllPersons(Session s) {
		Criteria empCriteria = s.createCriteria(Person.class);
		List<Person> empList = empCriteria.list();
		for(Person e: empList) {
			System.out.println(e.getName() + " " + e.getAddress());
		}
		return "fetched data successfully";
	}

}
