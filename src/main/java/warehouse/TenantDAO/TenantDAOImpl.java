package warehouse.TenantDAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import warehouse.entities.Product;
import warehouse.entities.Tenant;

import java.util.List;

@Repository
public class TenantDAOImpl implements TenantDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Tenant> getAllTenants() {
        Session session=sessionFactory.getCurrentSession();
        List<Tenant> tenantList=session.createQuery("from Tenant",Tenant.class)
                .getResultList();
        return tenantList;
    }

    @Override
    public Tenant getTenant(int placeNumber) {
        Session session= sessionFactory.getCurrentSession();
        Tenant tenant=session.get(Tenant.class,placeNumber);
        return tenant;
    }

    @Override
    public void addTenant(Tenant tenant) {
    Session session=sessionFactory.getCurrentSession();
    session.saveOrUpdate(tenant);
    }

    @Override
    public void deleteTenant(int placeNumber) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(session.get(Tenant.class,placeNumber));
    }

}
