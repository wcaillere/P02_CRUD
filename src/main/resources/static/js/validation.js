function validateTeacher() {
    let validated = true;

    let lastname = document.getElementById('lastname').value;
    let errorLastname = document.getElementById('idErrorLastname');

    let firstname = document.getElementById('firstname').value;
    let errorFirstname = document.getElementById('idErrorFirstname');

    let salary = document.getElementById('salary').value;
    let numericSalary = Number(salary);
    let errorSalary = document.getElementById('idErrorSalary');

    let urlPhoto = document.getElementById('urlPhoto').value;
    let errorUrlPhoto = document.getElementById('idErrorUrlPhoto');

    if (lastname === "" || lastname.length > 40) {
        errorLastname.style.visibility = 'visible';
        validated = false;
    } else {
        errorLastname.style.visibility = 'hidden';
    }

    if (firstname === "" || firstname.length > 40) {
        errorFirstname.style.visibility = 'visible';
        validated = false;
    } else {
        errorFirstname.style.visibility = 'hidden';
    }

    if (salary === "" || numericSalary < 100 || numericSalary > 1000) {
        errorSalary.style.visibility = 'visible';
        validated = false;
    } else {
        errorSalary.style.visibility = 'hidden';
    }

    if (urlPhoto === "" || urlPhoto.length > 255) {
        errorUrlPhoto.style.visibility = 'visible';
        validated = false;
    } else {
        errorUrlPhoto.style.visibility = 'hidden';
    }

    return validated;
}

function validerNumerique(e, ctrl) {
    let regex = /^\d{0,4}(\.\d{0,2})?$/g

    // Tester avec cette expression régulière le dernier caractère saisi
    // return regex.test(e.key);

    // Tester la globalité, la saisie avant la frappe du dernier caractère
    let txt = ctrl.value + e.key;

    return regex.test(txt);
}