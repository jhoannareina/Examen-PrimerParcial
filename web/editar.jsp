<%@page import="com.parcial.modelo.Estudiante"%>
<%
    Estudiante item = (Estudiante) request.getAttribute("miEstudiante");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
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
        
        <h1 style="color:palevioletred;" align="center"><%=(item.getId()==0)?"Registro":"Editar"%> Calificaciones</h1>
        
        <form action="Controlador" method="post">
            <input type="hidden" name="id" value="<%=item.getId()%>"/>
            
          <div align="center">  
            <table border="1">
                    <tr>
                        <td style="color:green;">Nombre del estudiante:</td>
                        <td><input type="text" name="nombre" value="<%=item.getNombre()%>"/></td>
                    </tr>
                    <tr>
                        <td style="color:green;">Primer parcial (sobre 30 pts):</td>
                        <td><input type="text" name="primerparcial" value="<%=item.getPrimerparcial()%>"/></td>
                    </tr>
                    <tr>
                        <td style="color:green;">Segundo parcial (sobre 30 pts):</td>
                        <td><input type="text" name="segundoparcial" value="<%=item.getSegundoparcial()%>"/></td>
                    </tr>
                    <tr>
                        <td style="color:green;">Examen final (sobre 40 pts):</td>
                        <td><input type="text" name="tercerparcial" value="<%=item.getTercerparcial()%>"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Enviar"/></td>
                    </tr>
            </table>
         </div>
        </form>
        
        
    </body>
</html>
