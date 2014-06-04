/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.Myeclone.controler;


import br.ufrn.Myeclone.Exceptions.ServiceException;
import br.ufrn.Myeclone.GUI.Alerta;
import br.ufrn.Myeclone.controler.Service.AtividadesService;
import br.ufrn.Myeclone.model.Atividade;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class VerificarTarefas extends Thread{
    
   private  AtividadesService atService = new AtividadesService();
   private List<Atividade> atividades;
   private Time antes, agora;
   
   private Alerta alerta;
           
   private Time getHoraAnterior(Time agora, int tempoantes){
       Time t = new Time(System.currentTimeMillis());
       
       if( (agora.getMinutes() - tempoantes ) > 0){
           t.setMinutes(agora.getMinutes() - tempoantes);
           t.setHours(agora.getHours());
       }else{
          t.setMinutes(60 + (agora.getMinutes() - tempoantes));
          t.setHours(agora.getHours() - 1);
       }
       
       
       return t;
   }
    
   @Override
   public void run(){
       
         
       for(;;){
           
           try {
               agora = new Time(System.currentTimeMillis());
               antes = getHoraAnterior(agora, 30);
               
               atividades = atService.listByHora(antes, agora);
               
               for(Atividade at: atividades){
 
                   
                   alerta = new Alerta(at.getAtividade(), at.getDescricao());
                   alerta.setVisible(true);
                   
                   try {
                       this.sleep(5000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(VerificarTarefas.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                    alerta.dispose();  
               }
               
           } catch (ServiceException ex) {
               Logger.getLogger(VerificarTarefas.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           System.out.println("Nao achei uma tarefa "+antes.getHours()+":"+antes.getMinutes() +"   "+
          agora.getHours()+":"+agora.getMinutes() );
           
           try {
               Thread.sleep(5 * 60 * 1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(VerificarTarefas.class.getName()).log(Level.SEVERE, null, ex);
           }
        
           
       }
       
       
      
       
   }
    
    
}
