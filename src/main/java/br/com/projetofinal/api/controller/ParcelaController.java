package br.com.projetofinal.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.api.dao.ParcelaDao;
import br.com.projetofinal.api.model.ParcelaModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/parcela")
public class ParcelaController {
    @Autowired
    private ParcelaDao parDao;

    @GetMapping("/getAll")
    public List<ParcelaModel> getAll() {
        List<ParcelaModel> listPar = parDao.getAll();
        return listPar;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParcelaModel> getById(@PathVariable int id) {
        ParcelaModel par = parDao.getById(id);
        if (par != null) {
            return new ResponseEntity<ParcelaModel>(par, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/save")
    public ResponseEntity<ParcelaModel> save(@RequestBody ParcelaModel par) {
        parDao.insert(par);
        return new ResponseEntity<ParcelaModel>(par, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParcelaModel> update(@PathVariable int id, @RequestBody ParcelaModel par) {
        par.setIdParcela(id);
        parDao.update(par);
        return new ResponseEntity<ParcelaModel>(par, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ParcelaModel> delete(@PathVariable int id) {
        ParcelaModel par = parDao.getById(id);
        if (par != null) {
            parDao.delete(par);
            return new ResponseEntity<ParcelaModel>(par, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
