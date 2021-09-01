package com.example.diplom.controllers;

import com.example.diplom.entities.OrderEntity;
import com.example.diplom.entities.OrderLine;
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
public class OrderLineControllerTest {

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
    public void getAllOrderLines() throws Exception {
        String uri = "/orderLine/getAll";
        mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void getByLine() throws Exception {
        String uri = "/orderLine/getByLine/{numberOfLine}";
        mockMvc.perform(get(uri, 1L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void createOrderLine() throws Exception {
        String uri = "/orderLine/create/{orderId}/{applianceId}";
        OrderLine orderLine = new OrderLine();
        orderLine.setNumberOfLine(10L);
        String content = objectMapper.writeValueAsString(orderLine);
        mockMvc.perform(post(uri, 1L, 8L).contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteOrderLine() throws Exception{
        String uri = "/orderLine/delete/{numberOfLine}";
        mockMvc.perform(delete(uri, 3L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void updateOrderLine() throws Exception {
        String uri = "/orderLine/update/{orderId}/{applianceId}";
        OrderLine orderLine = new OrderLine();
        orderLine.setNumberOfLine(1L);
        String content = objectMapper.writeValueAsString(orderLine);
        mockMvc.perform(put(uri, 3L, 8L).contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }
}