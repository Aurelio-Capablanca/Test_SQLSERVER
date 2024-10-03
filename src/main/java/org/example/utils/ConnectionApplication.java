package org.example.utils;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionApplication {

  @Getter
  private static final SessionFactory sessionFactory;

  static {
    try {
      sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    } catch (Throwable ex) {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static void shutdown() {
    if (sessionFactory != null) {
      sessionFactory.close();
      System.out.println("SessionFactory closed.");
    }
  }

}
