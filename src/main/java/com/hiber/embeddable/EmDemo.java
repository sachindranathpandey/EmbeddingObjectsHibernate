package com.hiber.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1=new Student();
		student1.setId(1);
		student1.setName("Sachindra");
		student1.setCity("Lucknow");
		
		Certificate certificate1=new Certificate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("2 Months");
		
		student1.setCertificate(certificate1);
		
		Student student2=new Student();
		student2.setId(2);
		student2.setName("Neha");
		student2.setCity("Delhi");
		
		Certificate certificate2=new Certificate();
		certificate2.setCourse("Reacts");
		certificate2.setDuration("3 Months");
		
		student2.setCertificate(certificate2);
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Object save
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
