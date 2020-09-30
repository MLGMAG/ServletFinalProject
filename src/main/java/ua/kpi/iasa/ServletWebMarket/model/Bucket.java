package ua.kpi.iasa.ServletWebMarket.model;

import java.util.List;
import java.util.UUID;

public class Bucket {
    private UUID id;
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
