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
import br.com.projetofinal.api.dao.ParcelaDao;
import br.com.projetofinal.api.dto.ParcelaDto;
import br.com.projetofinal.api.model.ParcelaModel;


@RestController
@RequestMapping("/parcela")
public class ParcelaController {
    @Autowired
    private ParcelaDao parDao;
    @Autowired
    private ContaDao conDao;

    @GetMapping("/getAll")
    public List<ParcelaDto> getAll() {
        List<ParcelaModel> listPar = parDao.getAll();
        List<ParcelaDto> listDto = ParcelaDto.converterLista(listPar);
        return listDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParcelaDto> getById(@PathVariable int id) {
        ParcelaModel par = parDao.getById(id);
        if (par != null) {
            ParcelaDto parDto = ParcelaDto.converter(par);
            return new ResponseEntity<ParcelaDto>(parDto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByConta/{idCon}")
    public List<ParcelaDto> getByConta(@PathVariable int idCon) {
        List<ParcelaModel> listPar = parDao.getByConta(idCon);
        List<ParcelaDto> listDto = ParcelaDto.converterLista(listPar);
        return listDto;
    }
    
    
    @PostMapping("/save")
    public ResponseEntity<ParcelaDto> save(@RequestBody ParcelaDto par) {
        ParcelaModel savedPar = new ParcelaModel();
        savedPar.setIdParcela(par.getIdParcela());
        savedPar.setDataVencimentoParcela(par.getDataVencimentoParcela());
        savedPar.setNumeroParcela(par.getNumeroParcela());
        savedPar.setValorParcela(par.getValorParcela());
        savedPar.setStatusParcela(par.getStatusParcela());
        savedPar.setContaParcela(conDao.getById(par.getIdConta()));
        parDao.insert(savedPar);

        ParcelaDto parDto = ParcelaDto.converter(savedPar);
        return new ResponseEntity<ParcelaDto>(parDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParcelaDto> update(@PathVariable int id, @RequestBody ParcelaDto par) {
        ParcelaModel updatedPar = new ParcelaModel();
        updatedPar.setIdParcela(par.getIdParcela());
        updatedPar.setDataVencimentoParcela(par.getDataVencimentoParcela());
        updatedPar.setNumeroParcela(par.getNumeroParcela());
        updatedPar.setValorParcela(par.getValorParcela());
        updatedPar.setStatusParcela(par.getStatusParcela());
        updatedPar.setContaParcela(conDao.getById(par.getIdConta()));

        parDao.update(updatedPar);
        ParcelaDto parDto = ParcelaDto.converter(updatedPar);
        return new ResponseEntity<ParcelaDto>(parDto, HttpStatus.OK);
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
