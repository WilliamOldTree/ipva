package br.com.rd.ipva.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rd.ipva.model.Ipva;
import br.com.rd.ipva.persistence.IpvaDao;


@WebServlet("/IpvaController")
public class IpvaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    IpvaDao ipvaDao;
    
    public IpvaController() {
        super();
        try {
			this.ipvaDao = new IpvaDao();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
      
    }// end Construtor

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.html").forward(request, response);
		
	}//end doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opt = request.getParameter("opt");
		
		if (opt == null) {
			
			doGet(request, response);
		}
			
			switch(opt) {
			
			case("loadForm"):
				loadForm(request, response);
			
			case("inserirIpva"):
				inserirIpva(request, response);
			
			case("deletarIpva"):
				deletarIpva(request, response);
			
			case ("atualizarIpva"):
				atualizarIpva(request, response);
			
			case ("listarIpva"):
				listarIpva(request, response);
			
			default:
				doGet(request, response);
			
			}// end switch
		
	}//end doPost

	

	private void loadForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("formIpva.html").forward(request, response);
		
	}//end loadForm

	
	
	private void inserirIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ano = request.getParameter("ano");
		
		if( ano != null) {
			if(!ano.equals("") ) {
				Ipva imposto = new Ipva(ano);
				try {
					this.ipvaDao.inserirAnoIpva(imposto);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		response.sendRedirect("IpvaController");
		
	}//end inserirIpva
	
	
	
	private void deletarIpva(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
		String idFront = request.getParameter("id");
		Integer id = Integer.parseInt(idFront);
		
		if (id != null) {
			try {
				this.ipvaDao.deletarAnoIpva(id);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("IpvaController");
		
	}//end deletarIpva
	
	
	
	private void atualizarIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idFront = request.getParameter("id");
		Integer id = Integer.parseInt(idFront);
		String ano = request.getParameter("ano");
		
		if ((id != null) && (id != null)) {
			if(!id.equals(" ")) {
				Ipva imposto = new Ipva (ano);
				imposto.setId(id);
			}//end if
		}//end if
		
		response.sendRedirect("IpvaController");
		
	}//end atualizarIpva
	
	

	private void listarIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("listaIpva", this.ipvaDao.listarAnoIpva());
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("formIpva.jsp").forward(request, response);
		
	}//end listarIpva
	

}//end IpvaController
