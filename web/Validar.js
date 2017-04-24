function validarForma(forma)
{    
    var cedula =  forma.cedula;
    if(cedula.value==="" || cedula.value>9999999 || cedula.value<100)
    {
        alert("Escriba una cedula apropiada");
        cedula.focus();
        cedula.select();
        return false;		
    }                
    var disciplinas = forma.disciplinas;
    var checkDisciplinas = false;
    for(i=0;i<disciplinas.length;i++)
    {
        if(disciplinas[i].checked)
        {
            checkDisciplinas=true;
        }
    }
    if(!checkDisciplinas)
    {
        alert("Seleccione una Disciplina");
        return false;                
    }
}
