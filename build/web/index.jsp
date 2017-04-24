<%-- 
    Document   : index
    Created on : 1/11/2016, 06:57:49 PM
    Author     : sala10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Atleta</h1>
        <br>
        <form name="form1" action="AtletaCtrl">
            <table>
                <caption>
                    Formulario Registro Atleta
                </caption>
                <tr>
                    <td>C&eacute;dula</td>
                    <td><input type="number" name="cedula"/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td>G&eacute;nero</td>
                    <td>
                        <select name="genero" class="default">
                            <option value="" selected>Seleccionar</option>
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar" name="accion"/></td>
                    <td><input type="submit" value="Guardar" name="accion"/></td>
                    <td><input type="submit" value="Consultar" name="accion"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
