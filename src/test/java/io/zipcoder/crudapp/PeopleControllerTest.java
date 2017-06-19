package io.zipcoder.crudapp;

import java.util.List;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.*;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Created by aaronlong on 6/16/17.
 */
@RunWith(SpringRunner.class)
public class PeopleControllerTest {

  private MockMvc mvc;

  @MockBean
  private PersonRepository repository;

  @InjectMocks
  private PeopleController controller;

  @Before
  public void init() {
    // Read Up On
    MockitoAnnotations.initMocks(this);
    mvc = MockMvcBuilders.standaloneSetup(controller)
                      .build();
  }

  private String objectToString(List<Person> p) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.writeValueAsString(p);
    } catch (JsonProcessingException e)  {
      System.out.println(e);
      return null;
    }
  }

  @Test
  public void exampleTest() throws Exception {
    List<Person> users = Arrays.asList(
            new Person( "Daenerys Targaryen", 2),
            new Person( "John Snow", 2));

    when(repository.findAll()).thenReturn(users);
    String expected = objectToString(users);
    this.mvc.perform(get("/person/"))
                 .andExpect(status().isOk())
                 .andExpect(content().json(expected));
  }
}
