package cz.upce.eshop.repository;

import cz.upce.eshop.entity.Category;
import cz.upce.eshop.entity.Product;
import cz.upce.eshop.entity.ProductHasCategory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductHasCategoryRepository extends JpaRepository<ProductHasCategory,Long> {


}
