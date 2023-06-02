package com.example.p02_crud.Dal;

import com.example.p02_crud.Dto.DTOTeacher;

import java.util.List;

public interface IServicesDalTeacher {

    List<DTOTeacher> TeachersList();

    DTOTeacher addTeacher(DTOTeacher dtoTeacher);

    DTOTeacher getDetails(String id);

    void deleteTeacher(String id);

    DTOTeacher modifyTeacher(DTOTeacher dtoTeacher);
}
