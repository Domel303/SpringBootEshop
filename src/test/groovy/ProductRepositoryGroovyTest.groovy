package cz.upce.eshop;

import cz.upce.eshop.datafactory.ProductTestDataFactory;
import cz.upce.eshop.entity.Product;
import cz.upce.eshop.repository.ProductRepository
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@SpringBootTest
@Import(ProductTestDataFactory.class)
class ProductRepositoryGroovyTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTestDataFactory productTestDataFactory;
    @Test
    void saveProductTest() {
        Product testProduct = new Product(name: "MyProduct" )
        productTestDataFactory.saveProduct(testProduct);
        def readFromDb = productRepository.findById(testProduct.getId().get);
        Assertions.assertThat((readFromDb.getName()).isEaqualTo("MyProduct"));


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
