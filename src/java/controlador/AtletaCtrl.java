package controlador;

import negocio.Atleta;
import bd.AtletaBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AtletaCtrl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {         
            String nombre = request.getParameter("nombre");
            String genero = request.getParameter("genero");
            String cedula = request.getParameter("cedula");
            String accion = request.getParameter("accion");            
            String[] disciplinas = request.getParameterValues("disciplinas");            
            HttpSession sesion = request.getSession();
            Atleta atleta = new Atleta();
            if(accion.equals("Guardar")){
                atleta = new Atleta(nombre,genero,Integer.parseInt(cedula));
                AtletaBD.mgr.save(atleta, true);
                for(int i = 0; i<disciplinas.length; i++)
                {
                    String disciplina = disciplinas[i];
                    AtletaBD.mgr.saveDisciplinas(cedula, disciplina);
                }                        
                sesion.setAttribute("atleta", atleta);
                sesion.setAttribute("mensaje", "Registro guardado con exito");
                request.getRequestDispatcher("mostrar.jsp").forward(request, response);
            }else if(accion.equals("Consultar")){
                cedula = request.getParameter("cedula");
                atleta = AtletaBD.mgr.getAtleta(Integer.parseInt(cedula));
                sesion.setAttribute("atleta", atleta);
                sesion.setAttribute("mensaje", "");
                request.getRequestDispatcher("consultar.jsp").forward(request, response);
            }else if(accion.equals("Modificar")){
                atleta = (Atleta) sesion.getAttribute("atleta");
                cedula = request.getParameter("cedula");
                nombre = request.getParameter("nombre");
                genero = request.getParameter("genero");
                atleta.setCedula(Integer.parseInt(cedula));
                atleta.setNombre(nombre);
                atleta.setGenero(genero);
                AtletaBD.mgr.save(atleta, false);
                sesion.setAttribute("atleta", atleta);
                sesion.setAttribute("mensaje", "Registro modificado con exito");
                request.getRequestDispatcher("mostrar.jsp").forward(request, response);
            }else if(accion.equals("Eliminar")){
                atleta = (Atleta) sesion.getAttribute("atleta");
                AtletaBD.mgr.delete(atleta);
                sesion.setAttribute("atleta", atleta);
                sesion.setAttribute("mensaje", "Registro eliminado con exito");
                request.getRequestDispatcher("mostrar.jsp").forward(request, response);
                
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String nombre = request.getParameter("nombre");
//            String genero = request.getParameter("genero");
//            String cedula = request.getParameter("cedula");
//            PrintWriter out = response.getWriter();
//            out.println("<h1>el nombre es"  + nombre + "</h1>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
