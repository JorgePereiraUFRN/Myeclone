package br.ufrn.Myeclone.apifb;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author augusto
 */
public class TokenException extends Exception{
    public String getMessage(){
        return "Permissão Negada";
    }
}
