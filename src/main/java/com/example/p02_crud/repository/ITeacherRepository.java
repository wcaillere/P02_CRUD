package com.example.p02_crud.repository;

import com.example.p02_crud.entity.Teacher;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

/*
L'interface JPARepository contient un certain nombre de méthodes, et on peut
en rajouter d'autres si besoin.
 */

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query(value = "select * from teachers where firstname like concat('%', :keyword, '%') or lastname" +
            " like concat('%', :keyword, '%')", nativeQuery = true)
    List<Teacher> findAllByKeyword(String keyword);

}
