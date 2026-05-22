package com.example.demo.repository;

import com.example.demo.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Long> {

    @Override
    Optional<UserTask> findById(Long aLong);

    @Override
    List<UserTask> findAll();

}
