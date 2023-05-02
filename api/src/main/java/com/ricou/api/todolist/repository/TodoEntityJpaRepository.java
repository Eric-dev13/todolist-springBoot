package com.ricou.api.todolist.repository;

import com.ricou.api.todolist.Model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoEntityJpaRepository extends JpaRepository<TodoEntity, Long> {

}