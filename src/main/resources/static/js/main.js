window.onload = loadHome;

function loadHome() {
    $("#content").load("home"); //"home" est l'url mappée sur une méthode du controller
}

function loadAddTeacher() {
    $("#content").load("addTeacher");
}

function loadList() {
    $("#content").load("listTeacher");
}

function loadDetails(idTeacher) {
    $("#content").load("teacherDetails/" + idTeacher);
}

function deleteTeacher(idTeacher) {
    if (confirm("Voulez-vous vraiment supprimer ce formateur ?")) {
        $("#content").load("deleteTeacher/" + idTeacher);
    }
}

function modifyTeacher(idTeacher) {
    $("#content").load("modifyTeacher/" + idTeacher);
}