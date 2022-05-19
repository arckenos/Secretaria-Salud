/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import entidades.exceptions.IllegalOrphanException;
import entidades.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arcke
 */
public class TrabajadorSaludJpaController implements Serializable {

    public TrabajadorSaludJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TrabajadorSalud trabajadorSalud) {
        if (trabajadorSalud.getCitasCollection() == null) {
            trabajadorSalud.setCitasCollection(new ArrayList<Citas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Citas> attachedCitasCollection = new ArrayList<Citas>();
            for (Citas citasCollectionCitasToAttach : trabajadorSalud.getCitasCollection()) {
                citasCollectionCitasToAttach = em.getReference(citasCollectionCitasToAttach.getClass(), citasCollectionCitasToAttach.getIdCitas());
                attachedCitasCollection.add(citasCollectionCitasToAttach);
            }
            trabajadorSalud.setCitasCollection(attachedCitasCollection);
            em.persist(trabajadorSalud);
            for (Citas citasCollectionCitas : trabajadorSalud.getCitasCollection()) {
                TrabajadorSalud oldIdTrabajadorSaludOfCitasCollectionCitas = citasCollectionCitas.getIdTrabajadorSalud();
                citasCollectionCitas.setIdTrabajadorSalud(trabajadorSalud);
                citasCollectionCitas = em.merge(citasCollectionCitas);
                if (oldIdTrabajadorSaludOfCitasCollectionCitas != null) {
                    oldIdTrabajadorSaludOfCitasCollectionCitas.getCitasCollection().remove(citasCollectionCitas);
                    oldIdTrabajadorSaludOfCitasCollectionCitas = em.merge(oldIdTrabajadorSaludOfCitasCollectionCitas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TrabajadorSalud trabajadorSalud) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TrabajadorSalud persistentTrabajadorSalud = em.find(TrabajadorSalud.class, trabajadorSalud.getIdTrabajadorSalud());
            Collection<Citas> citasCollectionOld = persistentTrabajadorSalud.getCitasCollection();
            Collection<Citas> citasCollectionNew = trabajadorSalud.getCitasCollection();
            List<String> illegalOrphanMessages = null;
            for (Citas citasCollectionOldCitas : citasCollectionOld) {
                if (!citasCollectionNew.contains(citasCollectionOldCitas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Citas " + citasCollectionOldCitas + " since its idTrabajadorSalud field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Citas> attachedCitasCollectionNew = new ArrayList<Citas>();
            for (Citas citasCollectionNewCitasToAttach : citasCollectionNew) {
                citasCollectionNewCitasToAttach = em.getReference(citasCollectionNewCitasToAttach.getClass(), citasCollectionNewCitasToAttach.getIdCitas());
                attachedCitasCollectionNew.add(citasCollectionNewCitasToAttach);
            }
            citasCollectionNew = attachedCitasCollectionNew;
            trabajadorSalud.setCitasCollection(citasCollectionNew);
            trabajadorSalud = em.merge(trabajadorSalud);
            for (Citas citasCollectionNewCitas : citasCollectionNew) {
                if (!citasCollectionOld.contains(citasCollectionNewCitas)) {
                    TrabajadorSalud oldIdTrabajadorSaludOfCitasCollectionNewCitas = citasCollectionNewCitas.getIdTrabajadorSalud();
                    citasCollectionNewCitas.setIdTrabajadorSalud(trabajadorSalud);
                    citasCollectionNewCitas = em.merge(citasCollectionNewCitas);
                    if (oldIdTrabajadorSaludOfCitasCollectionNewCitas != null && !oldIdTrabajadorSaludOfCitasCollectionNewCitas.equals(trabajadorSalud)) {
                        oldIdTrabajadorSaludOfCitasCollectionNewCitas.getCitasCollection().remove(citasCollectionNewCitas);
                        oldIdTrabajadorSaludOfCitasCollectionNewCitas = em.merge(oldIdTrabajadorSaludOfCitasCollectionNewCitas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trabajadorSalud.getIdTrabajadorSalud();
                if (findTrabajadorSalud(id) == null) {
                    throw new NonexistentEntityException("The trabajadorSalud with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TrabajadorSalud trabajadorSalud;
            try {
                trabajadorSalud = em.getReference(TrabajadorSalud.class, id);
                trabajadorSalud.getIdTrabajadorSalud();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trabajadorSalud with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Citas> citasCollectionOrphanCheck = trabajadorSalud.getCitasCollection();
            for (Citas citasCollectionOrphanCheckCitas : citasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TrabajadorSalud (" + trabajadorSalud + ") cannot be destroyed since the Citas " + citasCollectionOrphanCheckCitas + " in its citasCollection field has a non-nullable idTrabajadorSalud field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(trabajadorSalud);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TrabajadorSalud> findTrabajadorSaludEntities() {
        return findTrabajadorSaludEntities(true, -1, -1);
    }

    public List<TrabajadorSalud> findTrabajadorSaludEntities(int maxResults, int firstResult) {
        return findTrabajadorSaludEntities(false, maxResults, firstResult);
    }

    private List<TrabajadorSalud> findTrabajadorSaludEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrabajadorSalud.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TrabajadorSalud findTrabajadorSalud(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrabajadorSalud.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrabajadorSaludCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrabajadorSalud> rt = cq.from(TrabajadorSalud.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
