package co.simplon.alt3cda.configurateurdevehicule.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import co.simplon.alt3cda.configurateurdevehicule.service.InitDatabase;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode =  ClassMode.BEFORE_EACH_TEST_METHOD)
public class AllVehicleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private InitDatabase initDatabase;

  @Test
  void testGetAllVehicles() throws Exception {
    initDatabase.init();
    mockMvc.perform(MockMvcRequestBuilders.get("/api/"))
                      .andExpect(MockMvcResultMatchers.status().isOk())
                      .andExpect(MockMvcResultMatchers.jsonPath("$.[*]").exists())
                      .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty());
  }

  @Test
  void testGetAllVehicles_When_NoVehicleInDatabase() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.get("/api/"))
                      .andExpect(MockMvcResultMatchers.status().isNoContent());
  }

}
