package ua.kpi.iasa.ServletWebMarket.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product", schema = "web_market")
public class Product implements Serializable {
    @Id
    private UUID id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal price;
    @CreationTimestamp
    private Date addingDate;
    @Column
    @Enumerated(EnumType.STRING)
    private Color color;
    @Column
    private double size;
    @ManyToMany(targetEntity = Order.class)
    private List<Order> orderList;
    @ManyToOne(targetEntity = User.class)
    private User user;

    public Product() {
    }

    public Product(UUID id, String name, String description, BigDecimal price, Date addingDate, Color color, double size, List<Order> orderList, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.addingDate = addingDate;
        this.color = color;
        this.size = size;
        this.orderList = orderList;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
