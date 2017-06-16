package io.zipcoder.crudapp;


import javax.persistence.*;

/**
 * Created by aaronlong on 6/15/17.
 */
@Entity
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "AGE")
  private Integer age;


  public Person() {}

  public Person(String theirName, Integer theirAge) {
    name = theirName;
    age = theirAge;
  }

  public Integer getId() {
    return id;
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

  @Override
  public String toString() {
    return String.format(
            "Person[id=%d, name=%s, age=%d]",
            id, name, age);
  }


}



