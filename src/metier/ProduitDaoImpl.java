package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements IProduitsDAO {

	@Override
	public Produit save(Produit p) {
		 Connection conn = SingletonConnection.getConnection();
		 try{
			 PreparedStatement ps = conn.prepareStatement("insert into produits ( designation,prix,quantite) values(?,?,?)");
			 
			ps.setString(1, p.getDesignation());
			ps.setInt(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			PreparedStatement ps2 =conn.prepareStatement("select  MAX(id) AS MAX_ID from produits" );
			ResultSet rs =ps2.executeQuery();
			if(rs.next()){
				p.setId( rs.getLong("MAX_ID"));
			}
			ps.close();
		 }  catch(Exception e){
				e.printStackTrace();
			}
		return p;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		List<Produit> prods= new ArrayList<Produit>();
		
			Connection conn =SingletonConnection.getConnection();
			try{
				PreparedStatement ps = conn.prepareStatement("Select * from produits where designation like ?");
				ps.setString(1, mc);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Produit p = new Produit();
					p.setId(rs.getLong("id"));
				   p.setDesignation(rs.getString("designation"));
					 p.setPrix(rs.getInt("prix"));
					 p.setQuantite(rs.getInt("quantite"));
					 prods.add(p);
				}
		}  catch(Exception e){
			e.printStackTrace();
		}
		return prods;
	}


	@Override
	public Produit update(Produit p) {
		Connection conn =SingletonConnection.getConnection();
		//le block try catch est obligatoire pour une requette
				try {
					
					PreparedStatement pr = conn.prepareStatement("UPDATE produits set designation = ? , prix= ? , quantite= ? where id=?");
					  
					pr.setString(1, p.getDesignation());
					pr.setInt(2, p.getPrix());
					pr.setInt(3, p.getQuantite());
					 pr.setLong(4, p.getId());
					
					pr.executeUpdate();  // pour la requette update , on fait executeUpdate et non pas executeQuery
					
					 pr.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return p;
	}


	@Override
	public void deleteProduit(Long id) {
		//le block try catch est obligatoire pour une requette
				try {
					
					java.sql.PreparedStatement pr = SingletonConnection.getConnection().prepareStatement("DELETE FROM produits WHERE id= ?");
					  
					pr.setLong(1,id); 
					
					pr.executeUpdate();  //NB:  execute Update et non pas executeQuery 
					
					pr.close(); // fermeture de PreparedStatement
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			 
	}

	@Override
	public List<Produit> listeProduit() {
		ArrayList<Produit> prods = new ArrayList<Produit>(); // cree une
																// instance de
																// la liste des
																// produits

		// le block try catch est obligatoire pour une requette
		try {

			java.sql.PreparedStatement pr = SingletonConnection.getConnection()
					.prepareStatement("SELECT * FROM  produits");

			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				// 1 : il faut instancier un produit (qui correspond a la table
				// produit) --> puis faire les setter de ces attributs
				Produit p = new Produit();
				// 2 : donner les valeurs aux attributs du produit instancier
				p.setId(rs.getLong("id"));
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getInt("prix"));
				p.setQuantite(rs.getInt("quantite"));
				// 3 : ajouter le produit a la liste des produits
				prods.add(p);

			}

			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public Produit getProduit(Long id) {
Produit produit=new Produit();
		
		
		//le block try catch est obligatoire pour une requette
				try {
					
					PreparedStatement pr = SingletonConnection.getConnection().prepareStatement("SELECT * FROM  produits WHERE id = ?");
					 
					pr.setLong(1 ,id); // on a une seule '?'
					
					ResultSet rs = pr.executeQuery();  //on aura un produit ou aucun produit trouver
					
					if (rs.next()) {
						 
						// donner les valeurs aux attributs du produit instancier
						produit.setId(rs.getLong("id"));
						produit.setDesignation(rs.getString("designation"));
						produit.setPrix(rs.getInt("prix"));
						produit.setQuantite(rs.getInt("quantite"));
						  
					}
					
					pr.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		return produit;
	}

 
}

