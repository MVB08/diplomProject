package com.example.diplom.services;

import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.entities.OrderEntity;
import com.example.diplom.entities.OrderLine;
import com.example.diplom.repositories.OrderLineRepo;
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
public class OrderLineServiceTest {

    @Autowired
    OrderLineService orderLineService;
    @Autowired
    OrderLineRepo orderLineRepo;

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
    public void init() {
        orderLineService.init(3L, 8L);
        assertNotNull(orderLineRepo.findById(7L));

    }

    @Test
    public void getAllOrderLines() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(8L);
        ApplianceEntity applianceEntity = new ApplianceEntity();
        applianceEntity.setType("TV");
        applianceEntity.setModel("Boch");
        OrderLine orderLine = new OrderLine();
        orderLine.setOrderEntity(orderEntity);
        orderLine.setApplianceEntity(applianceEntity);
        assertNotNull(orderLineRepo.findAll());
    }

    @Test
    public void getById() {
        assertNotNull(orderLineRepo.findById(5L));
    }

    @Test
    public void create() {
        orderLineService.create(3L, 7L);
        assertNotNull(orderLineRepo.findById(8L));
    }

    @Test
    public void deleteOrderLine() {
        assertTrue(orderLineRepo.findById(7L).isPresent());
        orderLineService.deleteOrderLine(7L);


    }
}