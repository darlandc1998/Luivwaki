package app.controllers;

import app.daos.UsuarioDao;
import app.models.Usuario;
import app.utils.HibernateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @RequestMapping(name = "/usuario", method = RequestMethod.GET)
    public ResponseEntity getUsuario(@RequestParam(value = "id") Integer id) {
        try {
            return ResponseEntity.ok(new UsuarioDao(HibernateUtil.getSessionFactory()).findOne(id));
        } finally {
            HibernateUtil.closeSessionFactory();
        }

    }

    @RequestMapping(name = "/usuario", method = RequestMethod.POST)
    public ResponseEntity saveUsuario(@RequestBody Usuario usuario) {
        try {
            new UsuarioDao(HibernateUtil.getSessionFactory()).create(usuario);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.closeSessionFactory();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @RequestMapping(name = "/usuario", method = RequestMethod.PUT)
    public ResponseEntity updateUsuario(@RequestBody Usuario usuario) {
        System.out.println("Atualizou usuario = " + usuario.toString());
        return null;
    }

}
