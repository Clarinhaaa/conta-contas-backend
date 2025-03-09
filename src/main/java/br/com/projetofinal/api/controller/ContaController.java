package br.com.projetofinal.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.api.dao.ContaDao;
import br.com.projetofinal.api.model.ContaModel;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private ContaDao conDao = new ContaDao();
    
    @GetMapping("/getAll")
    public List<ContaModel> getAll() {
        List<ContaModel> listaCon = conDao.getAll();
        return listaCon;
    }
    
}
