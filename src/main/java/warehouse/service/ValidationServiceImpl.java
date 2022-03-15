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
public class ValidationServiceImpl implements ValidationService{
    @Autowired
    private TenantDAO tenantDAO;
    @Override
    public boolean isFull(Product product,int placeNumber) {
        Tenant tenant=tenantDAO.getTenant(placeNumber);
        if(tenant.getSummaryVolume()+product.getVolume()>100){
            return true;
        }
        else {
            return false;
        }
    }
}
