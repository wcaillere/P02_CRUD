package com.example.p02_crud.Dto;

/*
DTO = Data Transfer Object. Classe pour manipuler les données entre les entités
gérées par la session, les controllers et les vues
 */

public class DTOTeacher {

    private Integer id;
    private String firstname;
    private String lastname;
    private Double salary;
    private String urlPhoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    @Override
    public String toString() {
        return "DTOTeacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", urlPhoto='" + urlPhoto + '\'' +
                '}';
    }
}
