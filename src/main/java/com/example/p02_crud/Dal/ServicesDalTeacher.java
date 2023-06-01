package com.example.p02_crud.Dal;

import com.example.p02_crud.Dto.DTOTeacher;
import com.example.p02_crud.converter.Converter;
import com.example.p02_crud.entity.Teacher;
import com.example.p02_crud.repository.ITeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // L'annotation @Service est utilisée avec les classes qui fournissent des fonctionnalités métiers
@Transactional // Assurer la gestion des transactions
public class ServicesDalTeacher implements IServicesDalTeacher {

    @Autowired
    private ITeacherRepository teacherRepository;

    @Autowired
    private Converter converter;

    @Override
    public List<DTOTeacher> TeachersList() {
        List<DTOTeacher> dtoTeachers = new ArrayList<>();

        List<Teacher> teachers = teacherRepository.findAll();

        teachers.forEach(t -> dtoTeachers.add(converter.TeacherToDto(t)));

        return dtoTeachers;
    }
}
