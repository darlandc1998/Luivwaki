package app.daos;

import app.models.Usuario;
import org.hibernate.SessionFactory;


public class UsuarioDao extends GenericDAO<Usuario>{
 
    public UsuarioDao(SessionFactory sessionFactory) {
        super(sessionFactory, Usuario.class);
    }
 
    
}
