package com.javarush.repository;

import com.javarush.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserAddressRepository {

    private final SessionFactory sessionFactory;

    public List<User> getUsersByCity(String city) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("SELECT distinct u from User u JOIN FETCH u.address a where a.city = :city", User.class)
                .setParameter("city", city)
                .getResultList();

    }

    public List<User> getUsersByStreet(String street) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("SELECT DISTINCT u from User u JOIN FETCH u.address a where a.street = :street")
                .setParameter("street", street)
                .getResultList();
    }

    public List<User> getUsersByCityAndStreet(String city, String street) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT DISTINCT u FROM User u JOIN FETCH u.address a WHERE a.city = :city AND a.street = :street")
                .setParameter("city", city)
                .setParameter("street", street)
                .getResultList();
    }

}
