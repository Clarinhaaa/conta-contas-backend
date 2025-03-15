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

import br.com.projetofinal.api.dao.CategoriaDao;
import br.com.projetofinal.api.model.CategoriaModel;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaDao catDao;

    @GetMapping("/getAll")
    public List<CategoriaModel> getAll() {
        List<CategoriaModel> listCat = catDao.getAll();
        return listCat;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> getById(@PathVariable int id) {
        CategoriaModel cat = catDao.getById(id);
        if (cat != null) {
            return new ResponseEntity<CategoriaModel>(cat, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/save")
    public ResponseEntity<CategoriaModel> save(@RequestBody CategoriaModel cat) {
        catDao.insert(cat);
        return new ResponseEntity<CategoriaModel>(cat, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> update(@PathVariable int id, @RequestBody CategoriaModel cat) {
        cat.setIdCategoria(id);
        catDao.update(cat);
        return new ResponseEntity<CategoriaModel>(cat, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaModel> delete(@PathVariable int id) {
        CategoriaModel cat = catDao.getById(id);
        if (cat != null) {
            catDao.delete(cat);
            return new ResponseEntity<CategoriaModel>(cat, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
