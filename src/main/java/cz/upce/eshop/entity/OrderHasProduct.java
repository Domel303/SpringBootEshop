package cz.upce.eshop.entity;

import javax.persistence.*;

@Entity
public class OrderHasProduct {
    @ManyToOne
    private Product product;
    @ManyToOne
    private EshopOrder eshopOrder;

    private int amount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public EshopOrder getEshopOrder() {
        return eshopOrder;
    }

    public void setEshopOrder(EshopOrder eshopOrder) {
        this.eshopOrder = eshopOrder;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public EshopOrder getOrder() {
        return eshopOrder;
    }

    public void setOrder(EshopOrder eshopOrder) {
        this.eshopOrder = eshopOrder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
