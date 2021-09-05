package com.example.diplom.controllers;

import com.example.diplom.entities.ApplianceEntity;
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
public class AppliancesControllerTest {

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
    public void getAllAppliance() throws Exception {

        String uri = "/appliance/getAll";
        mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());

    }

    @Test
    public void getById() throws Exception {
        String uri = "/appliance/getById/{id}";
        mockMvc.perform(get(uri, 1L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void getByModel() throws Exception {
        String uri = "/appliance/getByModel/{model}";
        mockMvc.perform(get(uri, "Bosh").contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void getByType() throws Exception {
        String uri = "/appliance/getByType/{type}";
        mockMvc.perform(get(uri, "tv").contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());
    }

    @Test
    public void createAppliance() throws Exception {

        String uri = "/appliance/create";
        ApplianceEntity applianceEntity = new ApplianceEntity();
        applianceEntity.setModel("Bosh");
        applianceEntity.setId(1L);
        applianceEntity.setType("tv");
        String content = objectMapper.writeValueAsString(applianceEntity);
        mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteAppliance() throws Exception {

        String uri = "/appliance/delete/{id}";
        mockMvc.perform(delete(uri, 10L).contentType(MediaType.APPLICATION_JSON))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());

    }

    @Test
    public void updateAppliance() throws Exception {

        String uri = "/appliance/update/{id}/{type}/{model}";
        ApplianceEntity applianceEntity = new ApplianceEntity();
        applianceEntity.setModel("Indesit");
        applianceEntity.setId(1L);
        applianceEntity.setType("tv");
        String content = objectMapper.writeValueAsString(applianceEntity);
        mockMvc.perform(put(uri, 1L,"Indesit", "tv").contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document(uri.replace("/", "\\")))
                .andExpect(status().isOk());


    }

}