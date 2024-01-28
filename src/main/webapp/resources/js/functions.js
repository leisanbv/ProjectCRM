function deleteStudents(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите хотя бы одного студента!!!")
        return;
    }

    // 1-2-5-7 - string
    var ids = ""
    for(var i = 0; i < checkedCheckboxs.length; i++){
        ids = ids + checkedCheckboxs[i].value + " ";
    }

    document.getElementById("deleteStudentHidden").value = ids;
    document.getElementById('deleteStudentForm').submit();
}

function modifyStudents(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите студента!!!")
        return;
    }

    if(checkedCheckboxs.length > 1){
        alert("Выберите только одного студента!!!")
        return;
    }

    document.getElementById("modifyStudentHidden").value = checkedCheckboxs[0].value;
    document.getElementById('modifyStudentForm').submit();
}

function studentProgress(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите студента!!!")
        return;
    }

    if(checkedCheckboxs.length > 1){
        alert("Выберите только одного студента!!!")
        return;
    }

    document.getElementById("studentProgressHidden").value = checkedCheckboxs[0].value;
    document.getElementById('studentProgressForm').submit();
}

function deleteDisciplines(){
    var checkedCheckboxDc = document.querySelectorAll('input[name=idDiscipline]:checked')
    if(checkedCheckboxDc.length == 0){
        alert("Выберите хотя бы одну дисциплину!!!")
        return;
    }

    // 1-2-5-7 - string
    var idsDs = ""
    for(var i = 0; i < checkedCheckboxDc.length; i++){
        idsDs = idsDs + checkedCheckboxDc[i].value + " ";
    }

    document.getElementById("deleteDisciplineHidden").value = idsDs;
    document.getElementById('deleteDisciplineForm').submit();
}

function modifyDisciplines(){
    var checkedCheckboxDc = document.querySelectorAll('input[name=idDiscipline]:checked')
    if(checkedCheckboxDc.length == 0){
        alert("Выберите дисциплину!!!")
        return;
    }

    if(checkedCheckboxDc.length > 1){
        alert("Выберите только одну дисциплину!!!")
        return;
    }

    document.getElementById("modifyDisciplineHidden").value = checkedCheckboxDc[0].value;
    document.getElementById('modifyDisciplineForm').submit();
}

