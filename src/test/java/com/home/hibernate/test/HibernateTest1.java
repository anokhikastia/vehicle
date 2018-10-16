package com.home.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.home.hibernate.entity.Vehicle;

public class HibernateTest1 {

    private static SessionFactory sessionFactory = null;

    @BeforeClass
    public static void setUp() throws Exception {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    @AfterClass
    public static void tearDown() throws Exception {
        sessionFactory.close();
    }

    @Test
    public void persistVehicle() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Vehicle vehicle1 = new Vehicle(1, 1998, "Good", "BMW");
        Vehicle vehicle2 = new Vehicle(2, 2003, "Bad", "Maruti");
        session.save(vehicle1);
        session.save(vehicle2);
        session.persist(vehicle1);
        session.persist(vehicle2);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void getAndSetID() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Vehicle vehicle1 = new Vehicle(1, 1998, "Good", "BMW");
        assertEquals(1, vehicle1.getID());
        vehicle1.setID(3);
        assertEquals(3, vehicle1.getID());

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void getAndSetYear() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Vehicle vehicle1 = new Vehicle(1, 1998, "Good", "BMW");
        assertEquals(1998, vehicle1.getYear());
        vehicle1.setYear(1990);
        assertEquals(1990, vehicle1.getYear());
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void getAndSetModel() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Vehicle vehicle1 = new Vehicle(1, 1998, "Good", "BMW");
        assertEquals("BMW", vehicle1.getModel());
        vehicle1.setModel("Mercedez");
        assertEquals("Mercedez", vehicle1.getModel());
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void getAndSetMake() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Vehicle vehicle1 = new Vehicle(1, 1998, "Good", "BMW");
        assertEquals("Good", vehicle1.getMake());
        vehicle1.setModel("Horrible");
        assertEquals("Horrible", vehicle1.getMake());
        session.getTransaction().commit();
        session.close();
    }

}
