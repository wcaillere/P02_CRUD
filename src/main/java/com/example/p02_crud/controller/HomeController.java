package com.example.p02_crud.controller;

import com.example.p02_crud.Dal.IServicesDalTeacher;
import com.example.p02_crud.Dto.DTOTeacher;
import com.example.p02_crud.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public String AddTeacher(Model model) {
        DTOTeacher dtoteacher = new DTOTeacher();
        model.addAttribute("teacher", dtoteacher);

        return "fragments/addTeacher";
    }

    @GetMapping("/listTeacher")
    public String ListTeacher(Model model) {
        // Récupérer les données à afficher
        List<DTOTeacher> teachers = st.TeachersList();
        model.addAttribute("teachersList", teachers);

        return "fragments/listTeacher";
    }

    @PostMapping("/addTeacher")
    public String SaveTeacher(@ModelAttribute("teacher") DTOTeacher testdto, @RequestParam("test") String teacher) {
        DTOTeacher dtoTeacher = new DTOTeacher();
        System.out.println(testdto);

        List<Map<String, String>> params = Arrays.stream(teacher.split("&")).map(i -> Map.of(i.split("=")[0], i.split("=")[1])).toList();
        System.out.println(params);

        for (Map<String, String> map : params) {
            Map.Entry<String, String> entry = map.entrySet().stream().findFirst().orElse(null);
            switch (entry.getKey()) {
                case "lastname":
                    dtoTeacher.setLastname(entry.getValue());
                    break;
                case "firstname":
                    dtoTeacher.setFirstname(entry.getValue());
                    break;
                case "salary":
                    dtoTeacher.setSalary(Double.parseDouble(entry.getValue()));
                    break;
                case "urlPhoto":
                    dtoTeacher.setUrlPhoto(entry.getValue().replaceAll("%3A", ":").replaceAll("%2F", "/"));
                    break;
            }
        }

        System.out.println(dtoTeacher);
        st.addTeacher(dtoTeacher);

        return "fragments/saveConfirm";
    }

    @GetMapping("/teacherDetails/{id}")
    public String TeacherDetails(@PathVariable("id") String id, Model model) {

        model.addAttribute("teacher", st.getDetails(id));
        return "fragments/teacherDetails";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String DeleteTeacher(@PathVariable("id") String id) {
        st.deleteTeacher(id);

        return "redirect:/listTeacher";
    }

    @GetMapping("/modifyTeacher/{id}")
    public String ModifiyTeacher(@PathVariable("id") String id, Model model) {

        model.addAttribute("teacher", st.getDetails(id));
        return "fragments/modifyTeacher";
    }

    @PostMapping("/modifyTeacher")
    public String SaveModifiedTeacher(@ModelAttribute("teacher") DTOTeacher teacher, Model model) {

        System.out.println(teacher);
        st.modifyTeacher(teacher);

        return "redirect:/";
    }
}
