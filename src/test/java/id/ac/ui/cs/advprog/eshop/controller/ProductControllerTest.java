package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;
    Model model = mock(Model.class);
    

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProductPage() {
        String result = productController.createProductPage(model);
        assertEquals("createProduct", result);
    }

    @Test
    void testCreateProductPost() {
        Product product = new Product();
        String expectedViewName = "redirect:list";
        String actualViewName = productController.createProductPost(product, model);
        assertEquals(expectedViewName, actualViewName);
        verify(productService, times(1)).create(product);
    }

    @Test
    void testProductListPage() {
        Mockito.when(productService.findAll()).thenReturn(null);
        String result = productController.productListPage(model);
        assertEquals("productList", result);
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        String productId = product.getProductId();
        String expectedViewName = "redirect:../list";
        String actualViewName = productController.deleteProduct(productId,model);
        assertEquals(expectedViewName, actualViewName);
        verify(productService, times(1)).deleteProduct(productId);
    }

    @Test
    void testEditProductPage() {
        Product product = new Product();
        String productId = product.getProductId();
        when(productService.findById(productId)).thenReturn(product);

        String expectedViewName = "editProduct";
        String actualViewName = productController.editProductPage(productId, model);
        assertEquals(expectedViewName, actualViewName);
        verify(model, times(1)).addAttribute("product", product);
    }

    @Test
    void testEditProductPost() {
        Product product = new Product();
        String expectedViewName = "redirect:list";
        String actualViewName = productController.editProductPost(product,model);
        assertEquals(expectedViewName, actualViewName);
        verify(productService, times(1)).editProduct(product);
    }
}