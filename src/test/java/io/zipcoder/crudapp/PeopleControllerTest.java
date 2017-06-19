package io.zipcoder.crudapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.assertEquals;


/**
 * Created by aaronlong on 6/16/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PeopleController.class)
@ContextConfiguration(classes = { WebConfig.class })
public class PeopleControllerTest {

  private MockMvc mvc;

  @MockBean
  PersonRepository repository;

  @InjectMocks
  private PeopleController peopleController;

  @Before
  public void setupMock() {
    MockitoAnnotations.initMocks(this);
    mvc = MockMvcBuilders.standaloneSetup((PeopleController.class)).build();
  }

  @Test
  public void exampleTest() throws Exception {
    this.mvc.perform(get("/person/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("[]")));
  }
}
