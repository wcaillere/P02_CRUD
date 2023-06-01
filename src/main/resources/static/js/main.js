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