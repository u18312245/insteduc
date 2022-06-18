
function Login() {
    document.defecto.action = 'Administracion';
    document.defecto.metodo.value = 'Login';
    document.defecto.submit();
}
function Logout() {
    document.defecto.action = 'Administracion';
    document.defecto.metodo.value = 'Logout';
    document.defecto.submit();
}
function pag_cursos() {
    document.defecto.action = 'Administracion';
    document.defecto.metodo.value = 'pag_cursos';
    document.defecto.submit();
}
function pag_grados() {
    document.defecto.action = 'Administracion';
    document.defecto.metodo.value = 'pag_grados';
    document.defecto.submit();
}
function pag_ciclo() {
    document.defecto.action = 'Administracion';
    document.defecto.metodo.value = 'pag_ciclo';
    document.defecto.submit();
}
function pag_perfil() {
    document.defecto.action = 'Administracion';
    document.defecto.metodo.value = 'pag_perfil';
    document.defecto.submit();
}
function pag_cargo() {
    document.defecto.action = 'Administracion';
    document.defecto.metodo.value = 'pag_cargo';
    document.defecto.submit();
}
function pag_curso_cometencia() {
    document.defecto.action = 'Administracion';
    document.defecto.metodo.value = 'pag_curso_cometencia';
    document.defecto.submit();
}
function pag_adm() {
    document.defecto.action = 'Administracion';
    document.defecto.metodo.value = 'pag_adm';
    document.defecto.submit();
}
function DeleteCurso() {
    var a = document.lista.idcurso.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a un Curso");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'EliminarCurso';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function DeleteGrado() {
    var a = document.lista.idgrado.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a un Grado");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'EliminarGrado';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function DeleteCiclo() {
    var a = document.lista.idciclo.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a un Ciclo");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'EliminarCiclo';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function DeletePerfil() {
    var a = document.lista.idperfil.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a un Perfil");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'EliminarPerfil';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function DeleteCargo() {
    var a = document.lista.idcargo.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a un Cargo");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'EliminarCargo';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function DeleteCursoCompetencia() {
    var a = document.lista.idcompetencia.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a una competencia");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'EliminarCursoCompetencia';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function ModificarCurso() {
    var a = document.lista.idcurso.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a un Curso");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'pag_actualizarcurso';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function ModificarGrado() {
    var a = document.lista.idgrado.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a un Grado");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'pag_actualizargrado';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function ModificarCiclo() {
    var a = document.lista.idciclo.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a un Ciclo");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'pag_actualizarciclo';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function ModificarPerfil() {
    var a = document.lista.idperfil.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a un Perfil");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'pag_actualizarperfil';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function ModificarCargo() {
    var a = document.lista.idcargo.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a un Cargo");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'pag_actualizarcargo';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}
function ModificarCursoCompetenica() {
    var a = document.lista.idcompetencia.value;
    if (a.length == 0) {
        window.alert("Por favor seleccionar a una Competencia");
    } else {
        document.defecto.action = 'Administracion';
        document.defecto.metodo.value = 'pag_actualizarcursocompetencia';
        document.defecto.idmod.value = a;
        document.defecto.submit();
    }

}