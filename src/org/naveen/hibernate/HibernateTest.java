package org.naveen.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.naveen.tutorial.dto.Address;
import org.naveen.tutorial.dto.FourWheeler;
import org.naveen.tutorial.dto.TwoWheeler;
import org.naveen.tutorial.dto.UserDetails;
import org.naveen.tutorial.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("tp car");
		
		Vehicle car = new FourWheeler();
		car.setVehicleName("santro");
		
		Vehicle bike = new TwoWheeler();
		bike.setVehicleName("pulsor");
		
		user.setUserName("First User");
		Address addr1 = new Address();
		addr1.setCity("Belgaum");
		addr1.setState("karnataka");
		addr1.setStreet("uday school road");
		addr1.setPincode("590016");
		user.setHomeAddress(addr1);

		Address addr2 = new Address();
		addr2.setCity("Belgaum");
		addr2.setState("karnataka");
		addr2.setStreet("khade bazar");
		addr2.setPincode("590022");
		user.setOfficeAddress(addr2);
		user.setJoinedDate(new Date());
		user.setDescription("First user's description");
		user.getAddressSet().add(addr1);
		user.getAddressSet().add(addr2);

		user.getVehicleList().add(car);
		user.getVehicleList().add(bike);
		user.getVehicleList().add(vehicle);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(car);
		session.save(bike);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();

	}

}
