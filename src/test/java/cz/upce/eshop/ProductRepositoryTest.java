package cz.upce.eshop;

import cz.upce.eshop.entity.Product;
import cz.upce.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Test
    void saveProductTest() {

        saveProduct();


    }
    @Test
    void findProductByNameContains(){
        saveProduct();
        Product p =  productRepository.findProductByNameContains("First");
    }



    @Test
    void findProductsByIdBetween(){
        saveProduct();
        List<Product> productByIdBetween = productRepository.findProductByIdBetween(5L, 7L);
    }


    private void saveProduct() {
        Product product = new Product();
        product.setName("FirstProduct");
        productRepository.save(product);
    }

}
