<%-- 
    Document   : index
    Created on : 1/11/2016, 04:10:19 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script type="text/jscript" src="Validar.js" >
        </script>
    </head>
    <body>
        <h1>Atleta </h1>
        <br>
        <form name="form1" action="AtletaCtrl" onsubmit="return validarForma(this);">
            <table >
                <caption>
                	Formulario Registro de Atleta
                </caption>
                <tr>
                    <td>C&eacute;dula:</td> 
                    <td><input type="number" name="cedula"></td>
                </tr>
                <tr>
                    <td>Nombre: </td>
                    <td><input type="text" name="nombre" value="Escribir nombre"></td>
                </tr>
                <tr>
                    <td>G&eacute;nero:</td>
                    <td>
                        <select name="Genero" class="default">
                            <option value="" selected>Seleccionar</option>
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino" >Femenino</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
			Disciplinas de Inter&eacute;s (*)
                    </td>
                    <td>
                        Atletismo 100 mts<input type="checkbox" name="disciplinas" value="100 mts">
                        &nbsp;&nbsp;&nbsp;
                        Atletismo 200 mts<input type="checkbox" name="disciplinas" value="200 mts">
                        &nbsp;&nbsp;&nbsp;
                        Atletismo 500 mts<input type="checkbox" name="disciplinas" value="500 mts">
		    </td>
		</tr>
                <tr>
                    <td><input type="reset" value="Limpiar" name="accion">
                        <input type="submit" value="Guardar" name="accion"></td>
                    <td><input type="submit" value="Consultar" name="accion"></td>
                </tr>
            </table>
        </form>
        
        <br>
    </body>
</html>
