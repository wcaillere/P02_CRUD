package com.example.p02_crud.repository;

import com.example.p02_crud.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
L'interface JPARepository contient un certain nombre de méthodes, et on peut
en rajouter d'autres si besoin.
 */

public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query (value = "select * from teachers where firstname like concat('%', :keyword, '%') or lastname" +
            " like concat('%', :keyword, '%')", nativeQuery = true)
    List<Teacher> findAllByKeyword(String keyword);
}
