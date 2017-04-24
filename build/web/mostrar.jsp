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
                    <td><input type="number" name="cedula" value="${atleta.cedula}"/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${atleta.nombre}"/></td>
                </tr>
                <tr>
                    <td>G&eacute;nero</td>
                    <td><input type="text" name="genero" value="${atleta.genero}"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Regresar" name="accion"/></td>
                </tr>
            </table>
        </form>
        <h2>${mensaje}</h2>

    </body>
</html>
