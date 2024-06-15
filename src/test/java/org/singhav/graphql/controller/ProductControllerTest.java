package org.singhav.graphql.controller;

import org.junit.jupiter.api.Test;
import org.singhav.graphql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@GraphQlTest(ProductController.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldFetchAllProducts() {
        assertNotNull(graphQlTester);
    }
}