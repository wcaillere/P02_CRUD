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
import java.util.Optional;

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

    @Override
    public DTOTeacher addTeacher(DTOTeacher dtoTeacher) {
        Teacher teacher = converter.DtoToTeacher(dtoTeacher);

        // Sauvegarde de l'entité
        teacherRepository.save(teacher);

        return dtoTeacher;
    }

    @Override
    public DTOTeacher getDetails(String id) {
        DTOTeacher dtoTeacher = null;
        // findById retourne un optional
        Optional<Teacher> teacher = teacherRepository.findById(Integer.parseInt(id));

        // Il faut tester la présence de l'objet
        if (teacher.isPresent()) {
            dtoTeacher = converter.TeacherToDto(teacher.get());
        }

        return dtoTeacher;
    }

    @Override
    public void deleteTeacher(String id) {
        DTOTeacher dtoTeacher = getDetails(id);

        if (dtoTeacher != null) {
            Teacher teacher = converter.DtoToTeacher(dtoTeacher);

            teacherRepository.delete(teacher);
        } else {
            System.out.println("pas de teacher à supprimé avec cet id");
        }
    }
}
