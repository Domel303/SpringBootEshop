package cz.upce.eshop.repository;

import cz.upce.eshop.entity.Category;
import cz.upce.eshop.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @EntityGraph(attributePaths = {"productHasCategory"})
    Category findCategoryByNameContains(String contains);

    @EntityGraph(attributePaths = {"productHasCategory"})
    Category findCategoryByGenderContains(String contains);

    @EntityGraph(attributePaths = {"productHasCategory"})
    Category findCategoryBySeason(String season);




}
