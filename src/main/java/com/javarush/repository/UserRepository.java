package com.javarush.repository;

import com.javarush.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User book = session.byId(User.class).load(id);
        session.delete(book);
    }

    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    public void update(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(user);
    }

    public Optional<User> getById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return Optional.ofNullable(currentSession.get(User.class, id));
    }

    public List<User> getByFirstOrLastName(String firstName, String lastName) {
        Session currentSession = sessionFactory.getCurrentSession();
        org.hibernate.query.Query query = currentSession.createQuery("SELECT u FROM User u where u.firstName = :firstName OR u.lastName = :lastName", User.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    public Optional<User> getByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        org.hibernate.query.Query query = currentSession.createQuery("SELECT u FROM User u where u.email = :email", User.class);
        query.setParameter("email", email);
        return query.uniqueResultOptional();
    }
}
