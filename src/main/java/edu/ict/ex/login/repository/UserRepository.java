package edu.ict.ex.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ict.ex.login.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

    boolean existsByUserId(String userId);

    UserEntity findByUserId(String userId);
    
}
