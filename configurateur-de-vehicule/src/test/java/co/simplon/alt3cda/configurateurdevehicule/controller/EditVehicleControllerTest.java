package co.simplon.alt3cda.configurateurdevehicule.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import co.simplon.alt3cda.configurateurdevehicule.service.InitDatabase;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode =  ClassMode.BEFORE_EACH_TEST_METHOD)
public class EditVehicleControllerTest {
  
  @Autowired
  InitDatabase initDatabase;

  @Autowired
  MockMvc mockMvc;

  String jsonVehicle = """
    {
      \"model\": \"306\",
      \"color\": \"black\",
      \"price\": 3000.0,
      \"purshasePrice\": 4000.0,
      \"purshaseDate\": \"2022-05-19\",
      \"description\": null,
      \"kilometers\": 86000,
      \"launchDate\": \"2022-05-19\",
      \"power\": 100,
      \"door\": 5,
      \"gearBox\": \"MANUAL\",
      \"carType\": \"SEDAN\",
      \"vehiculeType\": \"CAR\",
      \"cylinder\": null,
      \"motoType\": null,
      \"bikeType\": null,
      \"chainrings\": null,
      \"antitheft\": null
    }""";

  @Test
  void testDeleteOne() throws Exception {
    initDatabase.init();
    mockMvc.perform(MockMvcRequestBuilders.delete("/1"))
                      .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void testDeleteOneNoPresent() throws Exception {
    
    mockMvc.perform(MockMvcRequestBuilders.delete("/1"))
                      .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  void testGetOne() throws Exception {
    initDatabase.init();
    mockMvc.perform(MockMvcRequestBuilders.get("/1"))
                      .andExpect(MockMvcResultMatchers.status().isOk())
                      .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
  }

  @Test
  void TestGetOneNoPresent() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/1"))
    .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  void testSave() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.put("/")
                        .content(jsonVehicle)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                      .andExpect(MockMvcResultMatchers.status().isCreated());
    
                      
                      
  }
}
