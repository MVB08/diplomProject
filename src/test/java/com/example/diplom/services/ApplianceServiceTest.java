package com.example.diplom.services;

import com.example.diplom.dto.ApplianceDto;
import com.example.diplom.entities.ApplianceEntity;
import com.example.diplom.repositories.ApplianceRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
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
public class ApplianceServiceTest {
    @Autowired
    ApplianceRepo applianceRepo;
    @Autowired
    ApplianceService applianceService;

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
    public void getAllAppliance() {
        assertNotNull(applianceRepo.findAll());
    }

    @Test
    public void findById() throws Exception {
        ApplianceEntity applianceEntity = new ApplianceEntity();
        applianceEntity.setId(1L);
        applianceEntity.setType("1");
        applianceEntity.setModel("1");
        applianceRepo.save(applianceEntity);
        assertNotNull(applianceRepo.findById(1L));
    }

    @Test
    public void getByModel() {
        ApplianceEntity applianceEntity = new ApplianceEntity();
        applianceEntity.setId(2L);
        applianceEntity.setType("2");
        applianceEntity.setModel("2");
        applianceRepo.save(applianceEntity);
        assertNotNull(applianceRepo.findByModel("2"));

    }

    @Test
    public void getByType() {
        ApplianceEntity applianceEntity = new ApplianceEntity();
        applianceEntity.setId(3L);
        applianceEntity.setType("3");
        applianceEntity.setModel("3");
        applianceRepo.save(applianceEntity);
        assertNotNull(applianceRepo.findByType("3"));
        assertTrue(applianceRepo.findById(3L).isPresent());
    }

    @Test
    public void initApp() {
       applianceService.initApp( "4", "4");
        assertNotNull(applianceRepo.findById(20L));



    }

    @Test
    public void create() {
        ApplianceDto applianceDto = new ApplianceDto();
        applianceDto.setModel("5");
        applianceDto.setType("5");
        applianceDto.setId(50L);
        applianceService.create(applianceDto);
        assertNotNull(applianceRepo.findById(50L));

    }

    @Test
    public void deleteAppliance() {
        ApplianceEntity applianceEntity = new ApplianceEntity();
        applianceEntity.setId(6L);
        applianceEntity.setType("6");
        applianceEntity.setModel("6");
        applianceRepo.save(applianceEntity);
        assertNotNull(applianceRepo.findByType("6"));
        assertTrue(applianceRepo.findById(6L).isPresent());
        applianceRepo.deleteById(6L);
        assertTrue(applianceRepo.findById(6L).isEmpty());
    }

    @Test
    public void updateAppliance() {
//        ApplianceEntity applianceEntity = new ApplianceEntity();
//        applianceEntity.setId(6L);
//        applianceEntity.setType("6");
//        applianceEntity.setModel("6");
//        applianceRepo.save(applianceEntity);
//        assertNotNull(applianceRepo.findByModel("6"));
//        assertTrue(applianceRepo.findById(6L).isPresent());
//        ApplianceDto applianceDto = new ApplianceDto();
//        applianceDto.setId(6L);
//        applianceDto.setModel("777");
//        applianceDto.setType("6");
//        applianceService.updateAppliance(6L,applianceDto );
//        assertTrue(applianceRepo.findById(6L).isPresent());
//        assertNotNull(applianceRepo.findByModel("777"));

    }
}