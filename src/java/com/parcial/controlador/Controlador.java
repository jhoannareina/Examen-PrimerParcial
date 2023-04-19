package com.parcial.controlador;
import com.parcial.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession sesion = request.getSession();
            
            if(sesion.getAttribute("listae")==null){
                ArrayList<Estudiante> listaux = new ArrayList<Estudiante>();
                sesion.setAttribute("listae", listaux);
            }
            ArrayList<Estudiante> lista = (ArrayList<Estudiante>)sesion.getAttribute("listae");
            
            String op = request.getParameter("op");
            String opcion =(op!=null)?request.getParameter("op"):"view";
            
            Estudiante obj1 = new Estudiante();
            int id, pos;
            
            switch(opcion){
            case "nuevo"://insertar nuevo registro
                request.setAttribute("miEstudiante", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                
            case "editar"://modificar registro
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request,id);
                obj1 = lista.get(pos);
                request.setAttribute("miEstudiante",obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                
            case "eliminar"://eliminar registro
                pos = buscarIndice(request,Integer.parseInt(request.getParameter("id")));
                lista.remove(pos);
                sesion.setAttribute("listae", lista);
                response.sendRedirect("index.jsp");
                break;
            
            case "view":
                response.sendRedirect("index.jsp");
        }
            
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession sesion = request.getSession();
            ArrayList<Estudiante> lista = (ArrayList<Estudiante>)sesion.getAttribute("listae");
            Estudiante obj1 = new Estudiante();
            
                obj1.setId(Integer.parseInt(request.getParameter("id")));
                obj1.setNombre(request.getParameter("nombre"));
                obj1.setPrimerparcial(Integer.parseInt(request.getParameter("primerparcial")));
                obj1.setSegundoparcial(Integer.parseInt(request.getParameter("segundoparcial")));
                obj1.setTercerparcial(Integer.parseInt(request.getParameter("tercerparcial")));
            
                int idn = obj1.getId();
                
                if(idn==0){
                    int ultID;
                        ultID = ultimoId(request);
                        obj1.setId(ultID);
                        lista.add(obj1);
                        }else{
                        lista.set(buscarIndice(request,idn), obj1);
                        
                    sesion.setAttribute("listae", lista);
                    response.sendRedirect("index.jsp");                   
        }
    }
        private int ultimoId(HttpServletRequest request){
            HttpSession sesion = request.getSession();
            ArrayList<Estudiante>lista = (ArrayList<Estudiante>)sesion.getAttribute("listae");
        
            int idaux = 0;
        
            for(Estudiante item : lista){
                idaux = item.getId();
            }
            return idaux+1;
            }
        
            private int buscarIndice(HttpServletRequest request, int id) {
                HttpSession sesion = request.getSession();
                ArrayList<Estudiante> lista = (ArrayList<Estudiante>)sesion.getAttribute("listae");
        
                int i=0;
                if(lista.size()>0){
                    while(i<lista.size()){
                        if(lista.get(i).getId()==id){
                            break;
                    }else{
                        i++;
                    }
                    }
                }
                return i;       
    }
                
    }   
