/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transparenciavacina2;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author willi
 */
public class VacinaBean {

    public void persistir(Vacina vacina){
        EntityManagerFactory fx = Persistence.createEntityManagerFactory("vacina");
        
        EntityManager em = fx.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(vacina);
        et.commit();

        em.close();
        fx.close();
    }
    
    public List<Vacina> getListaVacina(){
        List<Vacina> vacinas;
        EntityManagerFactory fx = Persistence.createEntityManagerFactory("vacina");
        EntityManager em = fx.createEntityManager();
        
        Query q;
        q = em.createQuery("select v from Vacina v", Vacina.class);
        vacinas = q.getResultList();
        return vacinas;
    }
}
