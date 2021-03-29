package cz.upce.eshop;

import cz.upce.eshop.entity.Product;
import cz.upce.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@SpringBootTest
@Import(ProductTestDataFactory.class)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTestDataFactory productTestDataFactory;
    @Test
    void saveProductTest() {

        productTestDataFactory.saveProduct();


    }
    @Test
    void findProductByNameContains(){
        productTestDataFactory.saveProduct();
        Product p =  productRepository.findProductByNameContains("First");
    }



    @Test
    void findProductsByIdBetween(){
        productTestDataFactory.saveProduct();
        List<Product> productByIdBetween = productRepository.findProductByIdBetween(5L, 7L);
    }



}
