package com.example.p02_crud.converter;

/*
Je dois créer une classe utilitaire contenant des méthodes capables de transférer les données
d'une entité vers une classe DTO et inversement
 */

import com.example.p02_crud.Dto.DTOTeacher;
import com.example.p02_crud.entity.Teacher;
import org.springframework.stereotype.Component;

// @Component est une annotation de niveau classe qui sera trouvée par Spring au moment du lancement de l'appli.
//
@Component
public class Converter {
    public DTOTeacher TeacherToDto(Teacher teacher) {
        DTOTeacher dtoT = new DTOTeacher();

        dtoT.setId(teacher.getId());
        dtoT.setFirstname(teacher.getFirstname());
        dtoT.setLastname(teacher.getLastname());
        dtoT.setSalary(teacher.getSalary());
        dtoT.setUrlPhoto(teacher.getUrlPhoto());
        return dtoT;
    }

    public Teacher DtoToTeacher (DTOTeacher dtoT) {
        Teacher teacher = new Teacher();

        teacher.setId(dtoT.getId());
        teacher.setFirstname(dtoT.getFirstname());
        teacher.setLastname(dtoT.getLastname());
        teacher.setSalary(dtoT.getSalary());
        teacher.setUrlPhoto(dtoT.getUrlPhoto());
        return teacher;
    }
}
