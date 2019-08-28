package com.projet.liste;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListeAFaireService {
	
	private static List<ListeAFaire> liste = new ArrayList<ListeAFaire>();
	private static int totalListeId = 3;
	
	
	//on cree 3 taches par defaut
	static {
		liste.add(new ListeAFaire(1, "Mes élèves", "Apprendre J2EE", new Date(), false));
		liste.add(new ListeAFaire(2, "Mes élèves", "Continuer à regarder les videos", new Date(), false));
		liste.add(new ListeAFaire(3, "Mes élèves", "Commenter le cours", new Date(), false));
	}
	
//	recuperer une liste en fonction de l'utilisateur
	
	public List<ListeAFaire> recupererListe(String utilisateur){
		List<ListeAFaire> l = new ArrayList<ListeAFaire>();
		for(ListeAFaire list : liste) {
			if(list.getUtilisateur().equals(utilisateur)) {
				l.add(list);
			}
		}
		return l;
	}
	
	// ajouter une tache dans notre liste
	
	public void ajouterListe(String utilisateur, String description , Date date, Boolean estEffectuée) {
		liste.add(new ListeAFaire(++totalListeId, utilisateur, description, date, estEffectuée));
	}
	
	//supprimer une tache en fonction de l Id 
	public void supprimerListe( int id) {
		Iterator<ListeAFaire> it = liste.iterator();
		while (it.hasNext()) {
			ListeAFaire list = it.next();
			if (list.getId() == id) {
				it.remove();
			}
			
		}
	}

}
