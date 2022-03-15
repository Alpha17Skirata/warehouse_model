package warehouse.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import warehouse.ProductDAO.ProductDAO;
import warehouse.entities.Product;
import warehouse.entities.Tenant;

import java.util.List;


public interface WarehouseService {
    public List<Tenant> getAllTenants();
    public void addTenant(Tenant tenant);
    public List<Product> getAllProducts(Tenant tenant);
    public void addProduct(Product product,int placeNumber);
    public Tenant getTenant(int placeNumber);
    public void deleteTenant(int placeNumber);
    public void deleteProduct(int id,int placeNumber);
}
