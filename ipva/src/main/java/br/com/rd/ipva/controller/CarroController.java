package br.com.rd.ipva.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rd.ipva.model.Carros;
import br.com.rd.ipva.persistence.CarrosDao;


@WebServlet("/CarroController")
public class CarroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    CarrosDao carrosDao;
    
    
    public CarroController() {
       super();
    	try {
		this.carrosDao = new CarrosDao();
	
       } catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
       }
    
    }//end Construtor
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.html").forward(request, response);;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opt = request.getParameter("opt");
		if (opt == null) {
			
			doGet(request, response);
		}
		
		switch(opt) {
		
		case("loadForm"):
			loadForm(request, response);
		
		case ("inserir"): 
			inserirCarros(request, response);
		
		case ("deletar"):
			deletarCarros(request, response);
		
		case("atualizar"):
			atualizarCarros(request, response);
		
		case("listar"):
			listarCarros(request, response);
		
		default:
			doGet(request, response);
		
		}//end  Switch
		
	}//end post
	
	
	
	private void loadForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.getRequestDispatcher("formCarro.html").forward(request, response);
	
	}//end loadForm
	
	
	
	private void inserirCarros (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String model = request.getParameter("modelo");
		String ano = request.getParameter("ano");
		if((model != null) && (ano != null)) {
			if(!model.equals(" ")) {
				Carros carro = new Carros (model, ano);
				try {
					this.carrosDao.inserirCarro(carro);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
			
		}
		
		response.sendRedirect("CarroController");
		
	}//end inserir
	
	
	
	private void deletarCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idFront = request.getParameter("id");
		Integer id = Integer.parseInt(idFront);
		if( id != null) {
			try {
				this.carrosDao.deletarCarro(0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("CarroController");
	
	}//end deletar
	
	
	
	private void atualizarCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idFront = request.getParameter("id");
		Integer id = Integer.parseInt(idFront);
		String model = request.getParameter("modelo");
		String ano = request.getParameter("ano");
		if((id != null) && (model != null) && (ano != null)) {
			if ( !id.equals(" ") ){
					Carros carro = new Carros(model, ano);
					carro.setId(id);		
					try {
						this.carrosDao.atualizarCarro(carro);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
		response.sendRedirect("Carro.Controller");
		
	}//end atualizar
	
	
	
	private void listarCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			request.setAttribute("listaCarros", this.carrosDao.listarCarro());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("formCarro.jsp").forward(request, response);
		
	}//end listarCarros
	
	
	
}//end CarroController
