/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.pecuaria.teste;

import br.edu.ifsul.cc.lpoo.pecuaria.modelo.Raca;
import br.edu.ifsul.cc.lpoo.pecuaria.modelo.dao.PersistenciaJPA;
import java.util.Collection;
import org.junit.Test;

/**
 *
 * @author 20212PF.CC0020
 */
public class TestPersistenciaJPA {

    /*  
    @Test
    public void testConexaoJPA(){
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if(jpa.conexaoAberta()){
            System.out.println("conectou no BD via jpa ...");
            jpa.fecharConexao();
        }else{
            System.out.println("nao conectou no BD ...");
                        
        }
    }

    @Test
    public void GerarRacas() throws Exception {
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            System.out.println("testInsercaoRacaJPA: conectou no BD via jpa...");

            Raca r = new Raca();
            r.setNome("Raca de teste!!!");

            jpa.persist(r);
            System.out.println("Raca id: " + r.getId());

            jpa.fecharConexao();
        } else {
            System.out.println("testInsercaoRacaJPA: não conectou no BD...");
        }

    }
    @Test
    public void AlteraRaca() throws Exception {
        PersistenciaJPA jpa = new PersistenciaJPA();

        if (jpa.conexaoAberta()) {

            System.out.println("Conectou ao BD via JPA!");

            Raca r = (Raca) jpa.find(Raca.class, Integer.valueOf(1));
            if (r != null) {
                    r.setNome("Nome Alterado");
                    jpa.persist(r);
            } else {
                System.out.println(" Não encotrou a raca=1 no BD...");
            }

            jpa.fecharConexao();
        } else {
            System.out.println("testInsercaoRacaJPA: não conectou no BD...");
        }
    
    @Test
    public void RemoveRaca() throws Exception {
        PersistenciaJPA jpa = new PersistenciaJPA();

        if (jpa.conexaoAberta()) {

            System.out.println("Conectou ao BD via JPA!");

            Raca r = (Raca) jpa.find(Raca.class, Integer.valueOf(1));
            if (r != null) {
                jpa.remover(r);
                System.out.println("Raca Removida id: " + r.getId());
            } else {
                System.out.println(" Não encotrou a raca=1 no BD...");
            }

            jpa.fecharConexao();
        } else {
            System.out.println("testInsercaoRacaJPA: não conectou no BD...");
        }
    }
       }*/
    @Test
    public void ListarRaca() throws Exception {
        PersistenciaJPA jpa = new PersistenciaJPA();

        if (jpa.conexaoAberta()) {
            System.out.println("Conectou ao BD via JPA!");

            Collection<Raca> test = jpa.listRacas();
            if (!test.isEmpty()) {

                System.out.println("Lista de Racas");
                for (Raca r : test) {
                    System.out.println("Raca encontrada - id: " + r.getId());
                    r.setNome("Nome alterado");
                    jpa.persist(r);//update
                    System.out.println("Raca alterada - "+r.getNome());
                    jpa.remover(r);//delete
                    System.out.println("Raca removida - "+r.getId());
                }
            } else {
                //System.out.println("Lista de raças está vazia");
                Raca r = new Raca();
                r.setNome("teste 1");
                jpa.persist(r);//insert
                r = new Raca();
                r.setNome("teste 2");
                jpa.persist(r);
            }
        } else {
            System.out.println("não conectou no BD...");
        }
    }

}
