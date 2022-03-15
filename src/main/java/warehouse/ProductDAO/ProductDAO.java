package warehouse.ProductDAO;

import warehouse.entities.Product;
import warehouse.entities.Tenant;

import java.util.List;

public interface ProductDAO {
    public List<Product> getAllProducts(int placeNumber);
    public void saveProduct(Product product,int placeNumber);
    public void deleteProduct(int id,int placeNumber);
}
