package io.zipcoder.crudapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by aaronlong on 6/15/17.
 */
@Entity
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String firstName;
  private String lastName;
  private String gender;

  @Override
  public String toString() {
    return String.format(
            "Person[id=%d, firstName=%s, lastName=%s, gender=%s]",
            id, firstName, lastName, gender);
  }


}



