package cz.upce.eshop;

import cz.upce.eshop.entity.Category;
import cz.upce.eshop.entity.Product;
import cz.upce.eshop.repository.CategoryRepository;
import cz.upce.eshop.repository.ProductRepository;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void saveCategoryTest() {

        Category category = new Category();
        category.setName("Obleceni");
        category.setSeason("Letni");
        category.setGender("Panske");
        categoryRepository.save(category);
    }

    @Test
    void findCategoryByNameContains(){
        Category category = new Category();
        category.setName("Triko habana");
        category.setSeason("Letni");
        category.setGender("Panske");
        categoryRepository.save(category);
        Category c = categoryRepository.findCategoryByNameContains("Triko");
    }

    @Test
    void findCategoryByGenderContains(){
        Category category = new Category();
        category.setName("Triko habana");
        category.setSeason("Letni");
        category.setGender("Panske");
        categoryRepository.save(category);
        Category c = categoryRepository.findCategoryByGenderContains("P");
    }

    @Test
    void findCategoryBySeason(){
        Category category = new Category();
        category.setName("Triko habana");
        category.setSeason("Letni");
        category.setGender("Panske");
        categoryRepository.save(category);
        Category c = categoryRepository.findCategoryBySeason("Letni");

    }

   

}
