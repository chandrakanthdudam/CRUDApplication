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
  private String name;
  private Integer age;

  public Person() {}

  public Person(String theirName, Integer theirAge) {
    name = theirName;
    age = theirAge;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public boolean isValid() {
    if (name == null || age == null) return false;
    return true;
  }

  @Override
  public String toString() {
    return String.format(
            "Person[id=%d, name=%s, age=%d]",
            id, name, age);
  }


}



