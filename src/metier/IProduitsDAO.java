package metier;

import java.util.List;

public interface IProduitsDAO {
	
	public Produit save(Produit p);
	public List<Produit> produitsParMC(String mc);
	public Produit update(Produit p);
	public void deleteProduit(Long id);
	public  List<Produit> listeProduit();
	public Produit getProduit(Long id );

}
