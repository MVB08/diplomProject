package com.example.diplom.exceptions;

import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.repositories.CustomerRepo;
import com.example.diplom.repositories.OrderRepo;
import com.example.diplom.services.CustomerService;
import com.example.diplom.services.OrderService;
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
public class PrivateExceptionTest {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepo customerRepo;

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


    @Test(expected = PrivateException.class)
    public void findById() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("Uliana");
        customerEntity.setPhoneNumber("21312123");
        customerRepo.save(customerEntity);
        assertNotNull(customerService.findById(0L));
    }


}