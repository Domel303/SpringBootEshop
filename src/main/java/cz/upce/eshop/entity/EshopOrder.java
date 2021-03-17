package cz.upce.eshop.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EshopOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StateEnum state;

    @OneToMany(mappedBy = "id")
    private Set<OrderHasProduct> ordersProducts;


    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
