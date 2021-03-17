package cz.upce.eshop.repository;

import cz.upce.eshop.entity.EshopOrder;
import cz.upce.eshop.entity.StateEnum;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<EshopOrder,Long> {

    @EntityGraph(attributePaths = {"orderHasProduct"})
    EshopOrder findEshopOrdersByIdBetween(long start, long finish);

    @EntityGraph(attributePaths = {"orderHasProduct"})
    EshopOrder findEshopOrdersByState(StateEnum stateEnum);


}
