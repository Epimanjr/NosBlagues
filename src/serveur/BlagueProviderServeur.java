/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import blague.Blague;
import codebase.BlagueProviderInterface;
import exception.BlagueAbsenteException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author Maxime Blaise
 */
public class BlagueProviderServeur implements BlagueProviderInterface {

    /**
     * Méthode abstraite qui retourne toutes les blagues, juste le nom.
     *
     * @return
     */
    @Override
    public String[] getAllNames() {
        //Création du tableau résultat
        String[] res = new String[listeBlagues.size()];

        //Initialisation iterateur
        Set cles = listeBlagues.keySet();
        Iterator it = cles.iterator();
        int iterateurRes = 0;
        
        //Parcourt de la hashmap
        while (it.hasNext()) {
            //Récupère la clé
            String cle = (String) it.next(); 
            
            //Ajout de la clé au tableau
            res[iterateurRes] = cle;
            iterateurRes++;
        }

        return res;
    }

    /**
     * Méthode abstraite qui retourne un objet Blague à partir du nom.
     *
     * @param nom
     * @return
     */
    @Override
    public Blague getBlague(String nom) throws BlagueAbsenteException {
        
        //On vérifie si la clé existe dans la hashmap
        if(listeBlagues.containsKey(nom)) {
            //On récupère la valeur
            Blague blague = listeBlagues.get(nom);
            return blague;
        } else {
            //On lève l'exception
            throw new BlagueAbsenteException();
        }
     
        
    }
    
    
    /**
     * Méthode principale, qui créer le serveur.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        try {
            
            //Création de l'objet
            BlagueProviderServeur serveur = new BlagueProviderServeur();
            
            //Export
            Registry r = LocateRegistry.getRegistry();
            BlagueProviderInterface di = (BlagueProviderInterface)UnicastRemoteObject.exportObject(serveur, 0);     
            r.rebind("BlagueProviderServeur", di);
            
        } catch (RemoteException ex) {
            Logger.getLogger(BlagueProviderServeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
