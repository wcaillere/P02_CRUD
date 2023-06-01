package com.example.p02_crud.controller;

import com.example.p02_crud.Dal.IServicesDalTeacher;
import com.example.p02_crud.Dto.DTOTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IServicesDalTeacher st;

    @GetMapping("/")
    public String Index() {
        return "index";
    }

    @GetMapping("/home")
    public String Home() {
        return "fragments/home";
    }

    @GetMapping("/addTeacher")
    public String AddTeacher() {
        return "fragments/addTeacher";
    }

    @GetMapping("/listTeacher")
    public String listTeacher(Model model) {
        // Récupérer les données à afficher
        List<DTOTeacher> teachers = st.TeachersList();
        model.addAttribute("teachersList", teachers);

        return "fragments/listTeacher";
    }
}
