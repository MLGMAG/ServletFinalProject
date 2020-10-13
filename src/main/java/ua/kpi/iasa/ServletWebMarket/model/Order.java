package ua.kpi.iasa.ServletWebMarket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order", schema = "web_market")
public class Order implements Serializable {
    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column
    private LocalDate addingDate;
    @ManyToMany(targetEntity = Product.class)
    private List<Product> products;

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
