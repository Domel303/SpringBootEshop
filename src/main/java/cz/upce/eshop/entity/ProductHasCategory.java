package cz.upce.eshop.entity;

import javax.persistence.*;

@Entity
public class ProductHasCategory {
    @ManyToOne
    private Product product;
    @ManyToOne
    private Category category;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
