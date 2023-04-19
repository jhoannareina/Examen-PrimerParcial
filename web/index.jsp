<%@page import="java.util.ArrayList"%>
<%@page import="com.parcial.modelo.Estudiante"%>
<%
    ArrayList<Estudiante> lista = (ArrayList<Estudiante>) session.getAttribute("listae");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Notas</title>
    </head>
    <body>
        
        
        <div align="center">
        <table border="1" cellspacing="0">
            <tr >
                <td ><h2 style="color:lightpink;" align="center"> PRIMER PARCIAL TEM-742</h2>
                <h3 style="color:plum;" >Nombre:Jhoanna Reina Mamani Espinoza</h3>
                <h3 style="color:plum">Carnet:9922636</h3>
                
                </td>
            </tr>
        </table>
        </div>
        <br>
        <br>
        <h1 style="color:palevioletred;" align="center">Registro de Calificaciones</h1> 
        
        <h3><a href="Controlador?op=nuevo" style="color:blue;">Nuevo  <br></a></h3>
        <br>
        
    <div align="center">
        <table border="1" cellspacing="0">
            <tr>
                <th style="color:palevioletred;">Id</th>
                <th style="color:palevioletred;">Nombre</th>
                <th style="color:palevioletred;">P1(30)</th>
                <th style="color:palevioletred;">P2(30)</th>
                <th style="color:palevioletred;">EF(40)</th>
                <th style="color:palevioletred;">Nota</th>
                <th style="color:green;"></th>
                <th style="color:red;"></th>
            </tr>
            <%
                if (lista != null) {
                    for (Estudiante item : lista) {
            %>
            <tr>
                <td><%= item.getId()%></td>
                <td><%= item.getNombre()%></td>
                <td><%= item.getPrimerparcial()%></td>
                <td><%= item.getSegundoparcial()%></td>
                <td><%= item.getTercerparcial()%></td>
                <td><%= item.getNota()%></td>
                <td><a href="Controlador?op=editar&id=<%= item.getId()%>">Editar</a></td>
                <td><a href="Controlador?op=eliminar&id=<%= item.getId()%>">Eliminar</a></td>
            </tr>
            <%
                    }
                }
            %>
        
    </table>
</div>
        
        
    </body>
</html>
