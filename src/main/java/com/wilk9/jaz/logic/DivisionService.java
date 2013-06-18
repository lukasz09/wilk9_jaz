
package com.wilk9.jaz.logic;

import com.wilk9.jaz.domain.Division;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Named("dzialService")
public class DivisionService {
    
    @PersistenceContext(unitName = "division_PU")
    private EntityManager em;
    
    public List<Division> getDivisions() {
        return em.createQuery("select d from Division d").getResultList();
    }
    
    public void remove(Division d) {
        d = em.merge(d);
        em.remove(d);
    }
 
    public void merge(Division d) {
        em.merge(d);
    }
}
