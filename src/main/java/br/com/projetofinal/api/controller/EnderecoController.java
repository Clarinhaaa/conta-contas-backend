package br.com.projetofinal.api.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.api.dao.EnderecoDao;
import br.com.projetofinal.api.model.EnderecoModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoDao endDao;

    @GetMapping("/getAll")
    public List<EnderecoModel> getAll() {
        List<EnderecoModel> listEnd = endDao.getAll();
        return listEnd;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel> getById(@PathVariable int id) {
        EnderecoModel end = endDao.getById(id);
        if (end != null) {
            return new ResponseEntity<EnderecoModel>(end, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<EnderecoModel> save(@RequestBody EnderecoModel end) {
        endDao.insert(end);
        return new ResponseEntity<EnderecoModel>(end, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoModel> update(@PathVariable int id, @RequestBody EnderecoModel end) {
        end.setIdEndereco(id);
        endDao.update(end);
        return new ResponseEntity<EnderecoModel>(end, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnderecoModel> delete(@PathVariable int id) {
        EnderecoModel end = endDao.getById(id);
        if (end != null) {
            endDao.delete(end);
            return new ResponseEntity<EnderecoModel>(end, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
