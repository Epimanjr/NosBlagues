/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Maxime Blaise
 */
public class BlagueAbsenteException extends Exception {

    /**
     * Constructeur de l'exception (vide)
     */
    public BlagueAbsenteException() {
        //Affichage du message
        System.out.println("Error : Blague Absente !");
    }
}
