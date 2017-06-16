package io.zipcoder.crudapp;

import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Success;
import com.sun.net.httpserver.Authenticator.Failure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
  public ResponseEntity putPerson(@RequestBody Person person) {
    if (isValid(person)) {
      if (hasId(person)) {
        Person db = repository.findOne(person.getId());
        db.setName(person.getName());
        db.setAge(person.getAge());
        repository.save(db);
      } else {
        repository.save(person);
      }
      return new ResponseEntity<Success>(HttpStatus.OK);
    }
    return new ResponseEntity<Failure>(HttpStatus.BAD_REQUEST);
  }

  @RequestMapping(value = "/", method = RequestMethod.DELETE)
  public ResponseEntity deletePerson(@RequestBody Person person) {
    if (hasId(person)) {
      repository.delete(person.getId());
      return new ResponseEntity<Success>(HttpStatus.OK);
    }
    return new ResponseEntity<Failure>(HttpStatus.BAD_REQUEST);
  }

  private boolean isValid(Person person) {
    if (person.getName() == null || person.getName() == null) return false;
    return true;
  }

  private boolean hasId(Person person) {
    return person.getId()!= null;
  }


}
