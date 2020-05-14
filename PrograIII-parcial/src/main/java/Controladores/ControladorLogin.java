package Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;

import DAOS.LoginDao;
import DAOS.MostrarDao;
import model.Usuario;


/**
 * Servlet implementation class ControladorLogin
 */
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   String abrir = request.getParameter("btn1");
	    if(abrir!=null) {
	    	if(abrir.equals("Eliminar")) {
		    HttpSession abrirr =(HttpSession) request.getSession();	
		   abrirr.invalidate();
		   response.sendRedirect("Mostrar.jsp");
		    }
	    }else {
	    	String usu = request.getParameter("usuario");
		    String con = request.getParameter("contra");
		    Usuario u = new Usuario();
			  LoginDao d = new LoginDao();
			  u.setNombre(usu);
			  u.setContrasenia(con);	  
try {
	int verri = d.Login(u).size();
	if (verri==1) {
		HttpSession s = request.getSession(true);
		s.setAttribute("usuario", usu);
		response.sendRedirect("Mostrar.jsp");
     }else {
		System.out.println("Error");
	}
} catch (Exception e) {
	System.out.println("Error" + e);
}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MostrarDao dd = new MostrarDao();
		Gson json = new Gson();
		try {
			response.getWriter().append(json.toJson(dd.mostrar()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
