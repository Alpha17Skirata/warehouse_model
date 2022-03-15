package warehouse.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import warehouse.entities.Product;

import java.util.List;

@Component
public class TransferForm {
    private int placeNumber;

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public TransferForm() {
    }
}
