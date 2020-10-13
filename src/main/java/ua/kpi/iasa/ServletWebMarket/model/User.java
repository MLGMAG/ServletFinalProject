package ua.kpi.iasa.ServletWebMarket.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user", schema = "web_market")
public class User implements Serializable {
    @Id
    private UUID id;
    @Column
    @Length(min = 8)
    @NotBlank
    private String username;
    @Column
    @Length(min = 8)
    @NotBlank
    private String password;
    @Transient
    private String confirmPassword;
    @Column(name = "first_name")
    @NotEmpty
    @NotBlank
    private String firstName;
    @Column(name = "last_name")
    @NotEmpty
    @NotBlank
    private String lastName;
    @OneToMany(targetEntity = Order.class, mappedBy = "user")
    private List<Order> orders;
    @Column()
    private BigDecimal balance;
    @OneToMany(targetEntity = Product.class, mappedBy = "user")
    private List<Product> products;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", schema = "web_market", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> role;
    @Column
    private boolean blocked;

    public User() {
    }

    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.confirmPassword = user.confirmPassword;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.orders = user.orders;
        this.balance = user.balance;
        this.products = user.products;
        this.role = user.role;
        this.blocked = user.blocked;
    }

    public User(UUID id, String username, String password, String confirmPassword, String firstName, String lastName, List<Order> orders, BigDecimal balance, List<Product> products, Set<Role> role, boolean blocked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
        this.balance = balance;
        this.products = products;
        this.role = role;
        this.blocked = blocked;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
