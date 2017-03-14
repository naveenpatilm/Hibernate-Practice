package org.naveen.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.naveen.tutorial.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		user.setAddress("First user's address");
		user.setJoinedDate(new Date());
		user.setDescription("First user's description");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Second User");
		user2.setAddress("Second user's address");
		user2.setJoinedDate(new Date());
		user2.setDescription("Second user's description");
		
		SessionFactory sessionFactory = 
				new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		
		System.out.println("user name is " + user.getUserName());
		

	}

}
