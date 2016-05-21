package crud;
import entity.User;

import javax.persistence.*;
import  javax.ejb.Stateless;
import java.util.List;


/**
 * Created by Julia on 20.05.2016.
 */
@Stateless
public class UserService {

    @PersistenceContext
    public EntityManager em = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public User add(User user){
        em.getTransaction().begin();
        User userFromDB = em.merge(user);
        em.getTransaction().commit();
        return user;
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public User get(int id){
        return em.find(User.class, id);
    }

    public void update(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public User getByLogin(String login){
        /*TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.login =:login", User.class);
        query.setParameter("login", login);
        List<User> userList = (List<User>) query.getResultList();*/
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        List<User> userList = namedQuery.getResultList();

        if(userList == null || userList.size() == 0){
            return null;
        }

        User requiredUser = null;
        for(User user: userList){
            if(user.getLogin().equals(login)){
                requiredUser = user;
                break;
            }
        }
        return requiredUser;
    }
}
