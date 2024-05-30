package org.example.springrest;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {

}
