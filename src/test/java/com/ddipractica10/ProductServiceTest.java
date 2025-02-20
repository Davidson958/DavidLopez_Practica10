package com.ddipractica10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void testAddValidProduct() {
        Product product = new Product("Producto A", 10, 99.99);
        assertTrue(productService.addProduct(product));
        assertEquals(1, productService.getProducts().size());
    }

    @Test
    public void testAddInvalidProduct() {
        Product product = new Product("", -5, -10.0);
        assertFalse(productService.addProduct(product));
        assertEquals(0, productService.getProducts().size());
    }

    @Test
    public void testEditProduct() {
        Product product = new Product("Producto B", 5, 50.0);
        productService.addProduct(product);
        Product updatedProduct = new Product("Producto B Modificado", 8, 55.0);
        assertTrue(productService.editProduct(0, updatedProduct));
        assertEquals("Producto B Modificado", productService.getProducts().get(0).getName());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product("Producto C", 3, 30.0);
        productService.addProduct(product);
        assertTrue(productService.deleteProduct(0));
        assertEquals(0, productService.getProducts().size());
    }

    @Test
    public void testEditProductWithInvalidIndex() {
        Product product = new Product("Producto D", 2, 20.0);
        productService.addProduct(product);
        Product updatedProduct = new Product("Producto D Modificado", 4, 25.0);
        assertFalse(productService.editProduct(5, updatedProduct));
    }
}
