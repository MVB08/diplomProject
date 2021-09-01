package com.example.diplom.controllers;

import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.entities.OrderEntity;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderControllerTest {

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
    public void getAllOrders() throws Exception {
        String uri = "/order/getAll";
        mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception {
        String uri = "/order/getById/{id}";
        mockMvc.perform(get(uri, 1L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void createOrder() throws Exception {
        String uri = "/order/create/{customerId}/{workerId}";
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(5L);
        String content = objectMapper.writeValueAsString(orderEntity);
        mockMvc.perform(post(uri, 1L, 2L).contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());

    }

//    @Test
//    public void deleteOrder() throws Exception {
//        String uri = "/order/delete/{id}";
//        mockMvc.perform(delete(uri, 1L).contentType(MediaType.APPLICATION_JSON))
//                .andDo(document(uri.replace("/", "\\")))
//                .andExpect(status().isOk());
//    }

    @Test
    public void updateCustomer() throws Exception {
        String uri = "/order/update/{customerId}/{workerId}";
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(1L);
        String content = objectMapper.writeValueAsString(orderEntity);
        mockMvc.perform(put(uri, 2L, 2L).contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());

    }
}