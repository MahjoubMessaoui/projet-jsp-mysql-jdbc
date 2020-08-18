package metier;

import java.util.List;

public class TestMetier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		 //1 ere etape : instancier le metier
		IProduitsDAO  metier = new ProduitDaoImpl(); //noter bien cette instance (polymorphisme)
	
		Produit p1 =new Produit(); 
		
	 
		p1.setDesignation("DESignation2");
		p1.setPrix(500);
		p1.setQuantite(12);
		 
		
		Produit p11 =new Produit(); 
 
		p11.setDesignation("fff");
		p11.setPrix(500);
		p11.setQuantite(12);
		
		
		
Produit p2 =new Produit(); 
		 
p2.setDesignation("DES2");
		p2.setPrix(600);
		p2.setQuantite(16);
		
		
	// 	metier.save(p1);  
	 //	metier.save(p11); 
	//	metier.deleteProduit(p1.getReference());
		
	 	
	 	/*	metier.updateProduit(p2); 
		
		Produit p3= metier.getProduit("REF1");
	 System.out.println(""+p3.getReference()+"" + p3.getDesignation()+"");
	 */
	 
	 
	// ICatalogueMetier  metier = new CatalogueMetierImpl(); //noter bien cette instance (polymorphisme)
		
	//	IProduitsDAO  metier = new ProduitDaoImpl(); //noter bien cette instance (polymorphisme)
	List<Produit> prods=metier.listeProduit();
	
	for( Produit p:prods) {
		
		 System.out.println("\n REF:"+p.getPrix()+"\n designation :" + p.getDesignation()+"");
			
		
	}
	String motcle="h";
List<Produit> lp=metier.produitsParMC("%" +motcle+ "%"); 
for(Produit p: lp ){
	System.out.println("la liste avec le nom h est" + p.getDesignation());
}
	}
	}


