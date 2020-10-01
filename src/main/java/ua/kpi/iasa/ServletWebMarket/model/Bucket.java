package ua.kpi.iasa.ServletWebMarket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bucket")
public class Bucket implements Serializable {
    @Id
    private UUID id;
    @ManyToMany(targetEntity = Product.class)
    private List<Product> products;

    public Bucket() {
    }

    public Bucket(UUID id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
