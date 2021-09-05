package com.example.diplom.controllers;

import com.example.diplom.entities.CustomerEntity;
import com.example.diplom.entities.WorkerEntity;
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
public class WorkerControllerTest {

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
    public void getAllWorkers() throws Exception {
        String uri = "/worker/getAll";
        mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception {
        String uri = "/worker/getById/{id}";
        mockMvc.perform(get(uri, 1L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void getByName() throws Exception {
        String uri = "/worker/getByName/{name}";
        mockMvc.perform(get(uri, "Anna").contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void getByPhone() throws Exception {
        String uri = "/worker/getByPhone/{phone}";
        mockMvc.perform(get(uri, 89037727272L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void createWorker() throws Exception {
        String uri = "/worker/create";
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setId(4L);
        workerEntity.setName("Leha");
        workerEntity.setPhoneNumber(8988888766L);
        workerEntity.setPosition("Seller");
        String content = objectMapper.writeValueAsString(workerEntity);
        mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteWorker() throws Exception {
        String uri = "/worker/delete/{id}";
        mockMvc.perform(delete(uri, 3L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void updateWorker() throws Exception {
//        String uri = "/worker/update/{id}";
//        CustomerEntity customerEntity = new CustomerEntity();
//        customerEntity.setId(1L);
//        customerEntity.setName("Leha");
//        customerEntity.setPhoneNumber(899983333L);
//        String content = objectMapper.writeValueAsString(customerEntity);
//        mockMvc.perform(put(uri, 1L).contentType(MediaType.APPLICATION_JSON).content(content))
//                .andDo(document(uri.replace("/", "\\")))
//                .andExpect(status().isOk());
    }
}