package org.openlake.springbootjpa.repo;

import org.openlake.springbootjpa.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends CrudRepository<User, String> {
//    1.
    List<User> findByName(String name);         //Query DSL(Domain Specific Language)
    //findBy{vaiable_name}OrderBy{variable_name}Desc -> important

//    2.
    @Query("from User where name= :idek")
    List<User> find(@Param("idek") String name);
}
