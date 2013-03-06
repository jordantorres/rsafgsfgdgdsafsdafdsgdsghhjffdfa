function redireccionaReporteAlumnos(){
    var grado=document.getElementById('frmConsultaAlumno:cboGrado_input').value;
    var seccion=document.getElementById('frmConsultaAlumno:cboSeccion_input').value;
    if(grado!='' && seccion!=''){
        document.getElementById('grado').value=grado;
        document.getElementById('seccion').value=seccion;
        document.getElementById('frmReporte').submit();
        return false;
    }else{
        alert('Por favor, elija Grado y Sección.');
        return false;
    }
}

function redireccionaReporteCredencialesAlumnos (){
    var grado=document.getElementById('frmConsultaAlumno:cboGrado_input').value;
    var seccion=document.getElementById('frmConsultaAlumno:cboSeccion_input').value;
    if(grado!='' && seccion!=''){
        document.getElementById('grado').value=grado;
        document.getElementById('seccion').value=seccion;
        document.getElementById('frmReporte').submit();
        return false;
    }else{
        alert('Por favor, elija Grado y Sección.');
        return false;
    }
}

function redireccionaReporteNotas(){
    var alumno=document.getElementById('frmConsultaNotas:cboAlumno_input').value;
    if(alumno!=''){
        document.getElementById('alumno').value=alumno;
        document.getElementById('frmReporteNotas').submit();
        return false;
    }else{
        alert('Por favor, elija Grado, Sección y Alumno.');
        return false;
    }
}

function redireccionaReporteLibreta(){
    //    var alumno=document.getElementById('frmConsultaNotas:cboAlumno_input').value;
    if(document.getElementById('alumno').value != ''){
        document.getElementById('alumno');
        document.getElementById('frmReporteLibreta').submit();
        return false;
    }else{
        alert('Por favor, Vuelva Intentarlo.');
        return false;
    }
}
