package com.javarush.repository;

import com.javarush.entity.Address;
import com.javarush.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AddressRepository {
    private final SessionFactory sessionFactory;

    public Optional<Address> findByStreetAndNumber(String street, String streetNumber) {

        Session currentSession = sessionFactory.getCurrentSession();
        org.hibernate.query.Query query = currentSession.createQuery("SELECT a FROM Address a where a.street = :street AND a.streetNumber = :streetNumber", Address.class);
        query.setParameter("street", street);
        query.setParameter("streetNumber", streetNumber);
        return query.uniqueResultOptional();
    }

    @Transactional
    public void create(Address address) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(address);
    }

    @Transactional
    public List<Address> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession
                .createQuery("select a from Address a")
                .getResultList();
    }

    @Transactional
    public void update(Address address) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(address);
    }

    @Transactional
    public void delete(Address address) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(address);//TODO re-write to using SQL
    }

    @Transactional
    public Optional<Address> findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.byId(Address.class).loadOptional(id);
    }
}
