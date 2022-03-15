package warehouse.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
@Component
@Entity
@Table(name = "tenants")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="place_number")
    private int placeNumber;
    @Column(name="number")
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{2}-\\d{2}", message = "number pattern is \"XXX-XXX-XX-XX\"")
    private String number;
    @Column(name="name")
    @NotBlank(message = "name is required field")
    private String name;
    @Column(name="surname")
    @NotBlank(message = "surname is required field")
    private String surname;
    @Column(name="summary_volume")
    private int summaryVolume;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenant")
    private List<Product> products;

    public int getSummaryVolume() {
        return summaryVolume;
    }

    public void setSummaryVolume(int summaryVolume) {
        this.summaryVolume = summaryVolume;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> product) {
        this.products = product;
    }

    public Tenant() {
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
