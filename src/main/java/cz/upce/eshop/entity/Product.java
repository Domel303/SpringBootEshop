package cz.upce.eshop.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Column()
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private Set<OrderHasProduct> productInOrder;

    @OneToMany(mappedBy = "id")
    private Set<ProductHasCategory> productInCategory;

    public String getName() {
        return name;
    }

    public Set<OrderHasProduct> getProductInOrder() {
        return productInOrder;
    }

    public void setProductInOrder(Set<OrderHasProduct> productInOrder) {
        this.productInOrder = productInOrder;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
