package org.naveen.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.naveen.tutorial.dto.Address;
import org.naveen.tutorial.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		Address addr1 = new Address();
		addr1.setCity("Belgaum");
		addr1.setState("karnataka");
		addr1.setStreet("uday school road");
		addr1.setPincode("590016");
		user.setAddress(addr1);
		user.setJoinedDate(new Date());
		user.setDescription("First user's description");
		
		SessionFactory sessionFactory = 
				new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		
		System.out.println("user name is " + user.getUserName());
		

	}

}
