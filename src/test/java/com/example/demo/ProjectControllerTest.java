//package com.example.demo;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.StatusResultMatchers;
//
//import javax.validation.constraints.AssertTrue;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@AutoConfigureMockMvc
//@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//public class ProjectControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
////    @Test
//    public void createProjectTest() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/project").contentType(MediaType.APPLICATION_JSON)
//                .requestAttr("name","blubb")
//                .requestAttr("description","hello")
//        ).andExpect(status().is(200)).andReturn();
//
//        System.out.println(result);
//        Assert.assertTrue("test successful",true);
//        System.out.println("Test");
//
//    }
//
//}
