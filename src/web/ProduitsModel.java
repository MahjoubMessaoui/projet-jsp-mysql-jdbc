package web;

import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProduitsModel {
	
	private String motCle;
	private List<Produit> produits = new ArrayList<Produit>();
	private String action="";   //attribut pour savoir l action a invoquer
	private String saveORediter="save";
	private Produit produit = new Produit();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	
	
	
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getSaveORediter() {
		return saveORediter;
	}
	public void setSaveORediter(String saveORediter) {
		this.saveORediter = saveORediter;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	 
	
	
}
