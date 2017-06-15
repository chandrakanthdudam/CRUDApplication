package io.zipcoder.crudapp;

import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Success;
import com.sun.net.httpserver.Authenticator.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aaronlong on 6/15/17.
 */
@RestController
@RequestMapping("/person")
public class PeopleController {

  @Autowired
  private PersonRepository repository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Person> getPeople() {
    List<Person> people = new ArrayList<>();
    repository.findAll().forEach(people::add);
    return people;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Person getPerson(@PathVariable Integer id) {
    return repository.findOne(id);
  }

  @RequestMapping(value = "/", method = RequestMethod.PUT)
  public ResponseEntity putPerson() {
    return new ResponseEntity<Success>(HttpStatus.OK);
  }
}
