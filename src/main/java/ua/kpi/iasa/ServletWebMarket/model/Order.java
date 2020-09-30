package ua.kpi.iasa.ServletWebMarket.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private List<Product> products;
    private Status status;
    private LocalDate addingDate;

    public Order(UUID id, List<Product> products, Status status, LocalDate addingDate) {
        this.id = id;
        this.products = products;
        this.status = status;
        this.addingDate = addingDate;
    }

    public Order() {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(LocalDate addingDate) {
        this.addingDate = addingDate;
    }
}
