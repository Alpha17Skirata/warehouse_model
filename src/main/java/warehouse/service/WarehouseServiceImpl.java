package warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import warehouse.ProductDAO.ProductDAO;
import warehouse.TenantDAO.TenantDAO;
import warehouse.entities.Product;
import warehouse.entities.Tenant;

import java.util.List;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService{

    @Autowired
    private TenantDAO tenantDAO;
    @Autowired
    private ProductDAO productDAO;


    @Override
    public List<Tenant> getAllTenants() {
        List<Tenant> tenantList=tenantDAO.getAllTenants();
        return tenantList;
    }

    @Override
    public void addTenant(Tenant tenant) {
        tenantDAO.addTenant(tenant);
    }

    @Override
    public List<Product> getAllProducts(Tenant tenant) {
        tenant.setProduct(productDAO.getAllProducts(tenant.getPlaceNumber()));
        return tenant.getProduct();
    }

    @Override
    public void addProduct(Product product,int placeNumber) {
        productDAO.saveProduct(product,placeNumber);

    }

    @Override
    public Tenant getTenant(int placeNumber) {
        Tenant tenant=tenantDAO.getTenant(placeNumber);
        return tenant;
    }

    @Override
    public void deleteTenant(int placeNumber) {
    tenantDAO.deleteTenant(placeNumber);
    }

    @Override
    public void deleteProduct(int id,int placeNumber) {
        productDAO.deleteProduct(id,placeNumber);
    }

}
