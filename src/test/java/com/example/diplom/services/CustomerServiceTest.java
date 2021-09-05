package com.example.diplom.services;

import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.dto.CustomerDto;
import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.CustomerEntity;
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
        assertNotNull(customerRepo.findAll());
    }

    @Test
    public void getByPhone() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(1L);
        customerEntity.setName("Anna");
        customerEntity.setPhoneNumber(89998887766L);
        customerRepo.save(customerEntity);
        assertNotNull(customerRepo.findByPhoneNumber(89998887766L));
    }

    @Test
    public void init() {
        customerService.init(20L, "4", 777L);
        assertNotNull(customerRepo.findById(20L));
    }

    @Test
    public void findById() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(1L);
        customerEntity.setName("Anna");
        customerEntity.setPhoneNumber(89998887766L);
        customerRepo.save(customerEntity);
        assertNotNull(customerRepo.findById(1L));
    }

    @Test
    public void getByName() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(1L);
        customerEntity.setName("Anna");
        customerEntity.setPhoneNumber(89998887766L);
        customerRepo.save(customerEntity);
        assertNotNull(customerRepo.findByName("Anna"));
    }

    @Test
    public void create() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(2L);
        customerDto.setName("Ivan");
        customerDto.setPhoneNumber(888L);
        customerService.create(customerDto);
        assertNotNull(customerRepo.findById(2L));
    }

    @Test
    public void deleteCustomer() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(622L);
        customerEntity.setName("Leha");
        customerEntity.setPhoneNumber(111L);
        customerRepo.save(customerEntity);
        assertNotNull(customerRepo.findById(622L));
        customerRepo.delete(customerEntity);
        assertTrue(customerRepo.findById(622L).isEmpty());
    }

    @Test
    public void updateCustomer() {
//        CustomerEntity customerEntity = new CustomerEntity();
//        customerEntity.setId(5L);
//        customerEntity.setName("Geka");
//        customerEntity.setPhoneNumber(111L);
//        customerRepo.save(customerEntity);
////        assertNotNull(customerRepo.findByPhoneNumber(111L));
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setId(5L);
//        customerDto.setName("Evgeniy");
//        customerDto.setPhoneNumber(112L);
//        customerService.updateCustomer(5L,customerDto );
//        assertTrue(customerRepo.findById(5L).isPresent());
//        assertNotNull(customerRepo.findByName("Evgeniy"));
    }
}