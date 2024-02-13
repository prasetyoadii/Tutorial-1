package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(createdProduct);
    }

    @Test
    void testFindAllProducts() {
        
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        Product product2 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd7");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
   

        when(productRepository.create(product1)).thenReturn(product1);
        when(productRepository.create(product2)).thenReturn(product2);

        List<Product> productList = List.of(product1, product2);

        productService.create(product1);
        productService.create(product2);

        when(productRepository.findAll()).thenReturn(productList.iterator());

        Iterator<Product> foundProducts = productService.findAll().iterator();

        assertTrue(foundProducts.hasNext());

        for (Product product : productList) {
            Product savedProduct = foundProducts.next();
            assertEquals(product, savedProduct);
        }

        verify(productRepository, times(1)).findAll();
    
    }

    @Test
    void testFindProductById() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        String productId = product.getProductId();

        when(productRepository.findProductId(productId)).thenReturn(product);

        Product foundProduct = productService.findById(productId);

        assertEquals(product, foundProduct);
        verify(productRepository, times(1)).findProductId(productId);
    }

    @Test
    void testEditProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.edit(product)).thenReturn(product);

        Product editedProduct = productService.editProduct(product);

        assertNotNull(editedProduct);
        assertEquals(product, editedProduct);
        verify(productRepository, times(1)).edit(product);
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        String productId = product.getProductId();
        when(productRepository.delete(productId)).thenReturn(product);

        Product deletedProduct = productService.deleteProduct(productId);

        assertEquals(product, deletedProduct);
        verify(productRepository, times(1)).delete(productId);
    }
}