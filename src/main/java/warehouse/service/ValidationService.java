package warehouse.service;

import warehouse.entities.Product;

import java.util.List;

public interface ValidationService {
    public boolean isFull(Product product,int placeNumber);
}
