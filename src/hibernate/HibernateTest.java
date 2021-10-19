package hibernate;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class HibernateTest {
	
	Hibernate h = new Hibernate();
	static SessionFactory factory;
	static Session s;
	static Transaction tx;
	
	@BeforeAll
	public static void setup() throws HibernateException {
		factory=new Configuration().configure("pom.xml").buildSessionFactory();    
		s=factory.openSession();
		tx=s.beginTransaction();
	}
	
	@AfterAll
	public static void tearDown() throws SQLException {
		s.close();
		factory.close();
	}
	
	@AfterEach
	public void tearDownEach() throws SQLException {
		tx.commit();
	}
	
	@Test
	void test() {
		assertTrue(true);
	}
	
	@Test
	void addPersonTest() {
		String response = h.addPerson(s, "Test-1", "AP");
		assertEquals("added successfully", response);
	}
	
	@Test
	void updatePersonTest() {
		String response = h.updatePerson(s, 12L, "Test-1", "A.P");
		assertEquals("updated successfully", response);
	}
	
	@Test
	void deletePersonTest() {
		String response = h.deletePerson(s, 12L);
		assertEquals("deleted successfully", response);
	}
	
	@Test
	void getAllPersonsTest() {
		String response = h.getAllPersons(s);
		assertEquals("fetched data successfully", response);
	}

}
