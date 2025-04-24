package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Step 1: Create SessionFactory (only once)
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // Step 2: Create Session
        Session session = factory.openSession();

        try {
            // Step 3: Begin Transaction
            session.beginTransaction();

            // Step 4: Create Employee object
            Employee emp = new Employee();
            emp.setId(1);
            emp.setName("Ram");
            emp.setDepartment("Engineering");

            // Step 5: Save to DB
            session.save(emp);

            // Step 6: Commit
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}

