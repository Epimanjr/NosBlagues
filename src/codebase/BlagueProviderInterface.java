/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codebase;

import blague.Blague;
import java.rmi.Remote;
import java.util.HashMap;

/**
 *
 * @author Maxime Blaise
 */
public interface BlagueProviderInterface extends Remote {
    
    /**
     * HashMap qui à chaque nom associe un objet Blague
     */
    HashMap<String, Blague> listeBlagues = new HashMap<String, Blague>();
    
    /**
     * Méthode abstraite qui retourne toutes les blagues, juste le nom.
     * 
     * @return 
     */
    public String[] getAllNames();
    
    /**
     * Méthode abstraite qui retourne un objet Blague à partir du nom.
     * 
     * @param nom
     * @return 
     */
    public Blague getBlague(String nom);
}
    
