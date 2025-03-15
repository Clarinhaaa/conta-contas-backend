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

import br.com.projetofinal.api.dao.ContaDao;
import br.com.projetofinal.api.model.ContaModel;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaDao conDao;

    @GetMapping("/getAll")
    public List<ContaModel> getAll() {
        List<ContaModel> listCon = conDao.getAll();
        return listCon;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaModel> getById(@PathVariable int id) {
        ContaModel con = conDao.getById(id);
        if (con != null) {
            return new ResponseEntity<ContaModel>(con, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/save")
    public ResponseEntity<ContaModel> save(@RequestBody ContaModel con) {
        conDao.insert(con);
        return new ResponseEntity<ContaModel>(con, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaModel> update(@PathVariable int id, @RequestBody ContaModel con) {
        con.setIdConta(id);
        conDao.update(con);
        return new ResponseEntity<ContaModel>(con, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ContaModel> delete(@PathVariable int id) {
        ContaModel con = conDao.getById(id);
        if (con != null) {
            conDao.delete(con);
            return new ResponseEntity<ContaModel>(con, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
