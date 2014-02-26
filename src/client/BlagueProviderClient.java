/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import blague.Blague;
import codebase.BlagueProviderInterface;
import exception.BlagueAbsenteException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxime Blaise
 */
public class BlagueProviderClient implements Remote {

    /**
     * Méthode principale du client
     *
     * @param args
     */
    public static void main(String[] args) {
        try {

            //Création de l'objet
            BlagueProviderClient client = new BlagueProviderClient();

            //Lookup
            //contact avec le rmiregistry de host
            Registry registry = LocateRegistry.getRegistry();
            // recuperation de la reference distante
            BlagueProviderInterface proxy = (BlagueProviderInterface) registry.lookup("BlagueProviderServeur");

            //Export
            BlagueProviderClient ri = (BlagueProviderClient) UnicastRemoteObject.exportObject(client, 0);
            Registry r = LocateRegistry.getRegistry();
            r.rebind("Client", ri);

            //Affichage d'une blague
            client.afficheUneBlague(proxy);

        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(BlagueProviderClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afficheUneBlague(BlagueProviderInterface proxy) {

        try {
            //On récupère toutes les blagues
            String[] toutesLesBlagues = proxy.getAllNames();

            if (toutesLesBlagues.length == 0) {
                //Liste vide
                System.out.println("La liste de blagues est malheureusement vide :-(");
            } else {
                
                //On en prend une au pif
                int nombreDeBlagues = toutesLesBlagues.length;
                int nombreAleatoire = (int) (Math.random() * nombreDeBlagues);

                String maBlagueString = toutesLesBlagues[nombreAleatoire];
                //Création de l'objet blague
                Blague maBlague = proxy.getBlague(maBlagueString);

                //Affichage
                System.out.println(maBlague);
            }

            
        } catch (RemoteException | BlagueAbsenteException ex) {
            Logger.getLogger(BlagueProviderClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
