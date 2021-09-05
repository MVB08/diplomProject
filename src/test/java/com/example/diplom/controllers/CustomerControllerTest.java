package com.example.diplom.controllers;

import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.entities.CustomerEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.ConfigurableMockMvcBuilder;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerControllerTest {

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
    public void getAllCustomers() throws Exception {
        String uri = "/customer/getAll";
        mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception {
        String uri = "/customer/getById/{id}";
        mockMvc.perform(get(uri, 1L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void getByName() throws Exception {
        String uri = "/customer/getByName/{name}";
        mockMvc.perform(get(uri, "Pavel").contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void getByPhone() throws Exception {
        String uri = "/customer/getByPhone/{phone}";
        mockMvc.perform(get(uri, 89112343434L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void createCustomer() throws Exception {
        String uri = "/customer/create";
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(7L);
        customerEntity.setName("Leha");
        customerEntity.setPhoneNumber(899988888766L);
        String content = objectMapper.writeValueAsString(customerEntity);
        mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCustomer() throws Exception {
        String uri = "/customer/delete/{id}";
        mockMvc.perform(delete(uri, 3L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomer() throws Exception {
        String uri = "/customer/update/{id}/{name}/{phoneNumber}";
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(1L);
        customerEntity.setName("Leha");
        customerEntity.setPhoneNumber(89998887766L);
        String content = objectMapper.writeValueAsString(customerEntity);
        mockMvc.perform(put(uri, 1L, "Leha", 111L).contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());

    }

    }