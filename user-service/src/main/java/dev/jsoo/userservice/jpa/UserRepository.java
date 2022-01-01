package dev.jsoo.userservice.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findById(String id);
}
