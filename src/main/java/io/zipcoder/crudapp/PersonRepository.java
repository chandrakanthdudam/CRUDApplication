package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by aaronlong on 6/15/17.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
