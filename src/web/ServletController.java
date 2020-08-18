package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.IProduitsDAO;
import metier.Produit;
import metier.ProduitDaoImpl;
@WebServlet(name="cs" ,urlPatterns=("*.php"))
public class ServletController extends HttpServlet {
	
	private IProduitsDAO metier;
	
	@Override
	public void init() throws ServletException {
	metier = new ProduitDaoImpl();
	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		if(path.equals("/index.php")){
			request.getRequestDispatcher("produits.jsp").forward(request,response);
		}
		else if(path.equals("/chercher.php")){
		String motCle= request.getParameter("motCle");
		ProduitsModel model = new ProduitsModel();
		model.setMotCle(motCle);
		List<Produit> produits=metier.produitsParMC("%" +motCle+ "%");
		model.setProduits(produits);
		request.setAttribute("model", model);
	request.getRequestDispatcher("produits.jsp").forward(request,response);
		
		} else if (path.equals("/saisie.php")){
			request.setAttribute("produit", new Produit());
			request.getRequestDispatcher("saisieProduit.jsp").forward(request,response);
		}  
		else if (path.equals("/saveProduit.php") && (request.getMethod().equals("POST"))){
			
			//Produit p = new Produit();
			String des = request.getParameter("designation");
			int prix= Integer.parseInt(request.getParameter("prix"));
			int qte=Integer.parseInt(request.getParameter("quantite"));
		Produit p=metier.save(new Produit( des,prix,qte));
		request.setAttribute("produit", p);
		request.getRequestDispatcher("Confirmation.jsp").forward(request,response);
		} 
		else if(path.equals("/Supprimer.php")){
			Long id=Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
			//request.getRequestDispatcher("produits.jsp").forward(request,response);
		     response.sendRedirect("chercher.php?motCle=");
		
		}
		else if(path.equals("/Edit.php")){
			Long id=Long.parseLong(request.getParameter("id"));
			Produit p =metier.getProduit(id);
		 request.setAttribute("produit", p);
			request.getRequestDispatcher("EditProduit.jsp").forward(request,response);
		}
		else if (path.equals("/updateProduit.php") && (request.getMethod().equals("POST"))){
			Long id=Long.parseLong(request.getParameter("id"));
			//Produit p = new Produit();
			String des = request.getParameter("designation");
			int prix= Integer.parseInt(request.getParameter("prix"));
			int qte=Integer.parseInt(request.getParameter("quantite"));
			Produit p = new Produit(des,prix,qte);
			p.setId(id);
			metier.update(p);
		request.setAttribute("produit", p);
		request.getRequestDispatcher("Confirmation.jsp").forward(request,response);
		} 
		else  {
		
			response.sendError(response.SC_NOT_FOUND);
		}
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doGet(request, response);
	}
}
