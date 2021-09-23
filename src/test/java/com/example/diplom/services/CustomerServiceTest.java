package com.example.diplom.services;

import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.dto.CustomerDto;
import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.exceptions.PrivateException;
import com.example.diplom.repositories.CustomerRepo;
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

import java.util.Optional;

import static org.junit.Assert.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CustomerService customerService;


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
    public void getAllCustomers() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("Luda");
        customerEntity.setPhoneNumber("89998887788");
        customerRepo.save(customerEntity);
        assertNotNull(customerRepo.findAll());
    }

    @Test
    public void getByPhone() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("Anna");
        customerEntity.setPhoneNumber("89998887766");
        customerRepo.save(customerEntity);
        assertNotNull(customerRepo.findByPhoneNumber("89998887766"));
    }

    @Test
    public void init() {
        customerService.init( "4", "777");
        assertNotNull(customerRepo.findById(20L));
    }


    @Test
    public void findById() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("Uliana");
        customerEntity.setPhoneNumber("89998887755");
        customerRepo.save(customerEntity);
        assertNotNull(customerRepo.findById(1L));
    }

    @Test
    public void getByName() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("Anna");
        customerEntity.setPhoneNumber("89998887733");
        customerRepo.save(customerEntity);
        assertNotNull(customerRepo.findByName("Anna"));
    }

    @Test
    public void create() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Ivan");
        customerDto.setPhoneNumber("888");
        customerService.create(customerDto);
        assertNotNull(customerRepo.findById(1L));
    }

    @Test
    public void updateCustomer() {
        assertTrue(customerRepo.findById(1L).isPresent());
        customerService.updateCustomer(1L,"Ilia", "999" );
        assertTrue(customerRepo.findById(1L).isPresent());
        assertNotNull(customerRepo.findByName("Ilia"));
    }
}