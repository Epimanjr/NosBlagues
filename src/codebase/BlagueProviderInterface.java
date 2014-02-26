/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codebase;

import blague.Blague;
import exception.BlagueAbsenteException;
import java.rmi.Remote;
import java.rmi.RemoteException;
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
     * @throws java.rmi.RemoteException 
     */
    public String[] getAllNames() throws RemoteException;
    
    /**
     * Méthode abstraite qui retourne un objet Blague à partir du nom.
     * 
     * @param nom
     * @return 
     * @throws exception.BlagueAbsenteException 
     * @throws java.rmi.RemoteException 
     */
    public Blague getBlague(String nom) throws BlagueAbsenteException, RemoteException;
}
    
