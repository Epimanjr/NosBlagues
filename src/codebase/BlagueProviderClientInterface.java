/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codebase;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Maxime Blaise
 */
public interface BlagueProviderClientInterface extends Remote {
    
    public void afficheUneBlague(BlagueProviderInterface proxy) throws RemoteException;
}
