package com.example.diplom.services;

import com.example.diplom.repositories.OrderLineRepo;
import com.example.diplom.repositories.OrderRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.ConfigurableMockMvcBuilder;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepo orderRepo;

    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");


    @Before
    public void setUp() {
        ConfigurableMockMvcBuilder<DefaultMockMvcBuilder> builder =
                MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                        .apply(documentationConfiguration(this.restDocumentation));
        this.mockMvc = builder.build();
    }

    @Test
    public void getAllOrders() {

        assertNotNull(orderRepo.findAll());
    }

    @Test
    public void getById() {
        assertNotNull(orderRepo.findById(5L));
    }

    @Test
    public void init() {
        orderService.init(3L, 3L);
        assertNotNull(orderRepo.findById(5L));
    }

    @Test
    public void create() {

        orderService.create(3L, 2L);
        assertNotNull(orderRepo.findById(6L));
    }

    @Test
    public void deleteOrder() {
        assertNotNull(orderRepo.findById(5L));
        orderService.deleteOrder(5L);
    }
}