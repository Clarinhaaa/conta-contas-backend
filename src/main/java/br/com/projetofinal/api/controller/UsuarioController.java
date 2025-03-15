package br.com.projetofinal.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.api.dao.UsuarioDao;
import br.com.projetofinal.api.model.UsuarioModel;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioDao usuDao;

    @GetMapping("/getAll")
    public List<UsuarioModel> getAll() {
        List<UsuarioModel> listUsu = usuDao.getAll();
        return listUsu;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> getById(@PathVariable int id) {
        UsuarioModel usu = usuDao.getById(id);
        if (usu != null) {
            return new ResponseEntity<UsuarioModel>(usu, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<UsuarioModel> save(@RequestBody UsuarioModel usu) {
        usuDao.insert(usu);
        return new ResponseEntity<UsuarioModel>(usu, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> update(@PathVariable int id, @RequestBody UsuarioModel usu) {
        usu.setIdUsuario(id);
        usuDao.update(usu);
        return new ResponseEntity<UsuarioModel>(usu, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioModel> delete(@PathVariable int id) {
        UsuarioModel usu = usuDao.getById(id);
        if (usu != null) {
            usuDao.delete(usu);
            return new ResponseEntity<UsuarioModel>(usu, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
