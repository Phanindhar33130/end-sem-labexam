package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Device device = new Device();
        device.setBrand("Generic");
        device.setModel("Model-X");
        device.setPrice(500.00);
        session.save(device);

        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 15");
        smartphone.setPrice(1200.00);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution("48 MP");
        session.save(smartphone);

        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S9");
        tablet.setPrice(800.00);
        tablet.setScreenSize("11 inches");
        tablet.setBatteryLife("12 hours");
        session.save(tablet);

        transaction.commit();
        session.close();

        System.out.println("Records inserted successfully!");
    }
}
