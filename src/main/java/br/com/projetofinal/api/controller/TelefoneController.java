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

import br.com.projetofinal.api.dao.TelefoneDao;
import br.com.projetofinal.api.model.TelefoneModel;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {
    @Autowired
    private TelefoneDao telDao;
    
    @GetMapping("/getAll")
    public List<TelefoneModel> getAll() {
        List<TelefoneModel> listTel = telDao.getAll();
        return listTel;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneModel> getById(@PathVariable int id) {
        TelefoneModel tel = telDao.getById(id);
        if (tel != null) {
            return new ResponseEntity<TelefoneModel>(tel, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/save")
    public ResponseEntity<TelefoneModel> save(@RequestBody TelefoneModel tel) {
        telDao.insert(tel);
        return new ResponseEntity<TelefoneModel>(tel, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneModel> update(@PathVariable int id, @RequestBody TelefoneModel tel) {
        tel.setIdTelefone(id);
        telDao.update(tel);
        return new ResponseEntity<TelefoneModel>(tel, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<TelefoneModel> delete(@PathVariable int id) {
        TelefoneModel tel = telDao.getById(id);
        if (tel != null) {
            telDao.delete(tel);
            return new ResponseEntity<TelefoneModel>(tel, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
