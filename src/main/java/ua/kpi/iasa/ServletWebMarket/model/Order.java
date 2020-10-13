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
    @ManyToOne(targetEntity = User.class)
    private User user;
    @ManyToMany(targetEntity = Product.class)
    private List<Product> products;

    public Order(UUID id, Status status, LocalDate addingDate, User user, List<Product> products) {
        this.id = id;
        this.status = status;
        this.addingDate = addingDate;
        this.user = user;
        this.products = products;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
