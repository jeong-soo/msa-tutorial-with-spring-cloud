package dev.jsoo.userservice.repository;

import dev.jsoo.userservice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findById(String id);
    UserEntity findByEmail(String email);
}
