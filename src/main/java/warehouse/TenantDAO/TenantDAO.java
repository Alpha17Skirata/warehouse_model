package warehouse.TenantDAO;

import warehouse.entities.Product;
import warehouse.entities.Tenant;

import java.util.List;

public interface TenantDAO {
    public List<Tenant> getAllTenants();
    public Tenant getTenant(int placeNumber);
    public void addTenant(Tenant tenant);
    public void deleteTenant(int placeNumber);
}
