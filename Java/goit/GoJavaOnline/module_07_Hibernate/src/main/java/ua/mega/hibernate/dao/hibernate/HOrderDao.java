package ua.mega.hibernate.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.mega.hibernate.model.Orders;
import ua.mega.hibernate.dao.OrderDao;

import java.util.List;

public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Orders order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Orders> findAllOrders() {
      return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Orders").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
