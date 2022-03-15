package warehouse.ProductDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import warehouse.entities.Product;
import warehouse.entities.Tenant;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductDAOImpl implements ProductDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product> getAllProducts(int placeNumber) {
        Session session=sessionFactory.getCurrentSession();
        List<Product> productList=session.createSQLQuery("select * from my_db.products where place_number="+placeNumber).addEntity(Product.class).list();
        return productList;
    }


    @Override
    public void saveProduct(Product product,int placeNumber) {
        Session session=sessionFactory.getCurrentSession();
        Tenant tenant=session.get(Tenant.class,placeNumber);
        if(tenant.getProduct()==null){
            tenant.setProduct(new ArrayList<>());
        }
        tenant.getProduct().add(product);
        product.setTenant(tenant);
        tenant.setSummaryVolume(tenant.getSummaryVolume()+product.getVolume());
        session.saveOrUpdate(product);
    }

    @Override
    public void deleteProduct(int id,int placeNumber) {
        Session session=sessionFactory.getCurrentSession();
        Tenant tenant=session.get(Tenant.class,placeNumber);
        Product product=session.get(Product.class,id);
        tenant.setSummaryVolume(tenant.getSummaryVolume()-product.getVolume());
        Query<Product> query= session.createQuery("delete from Product where id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }
}
