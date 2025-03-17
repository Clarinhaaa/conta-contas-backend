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
import br.com.projetofinal.api.dao.ContaDao;
import br.com.projetofinal.api.dao.UsuarioDao;
import br.com.projetofinal.api.dto.ContaDto;
import br.com.projetofinal.api.model.ContaModel;


@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaDao conDao;
    @Autowired
    private UsuarioDao usuDao;
    @Autowired
    private CategoriaDao catDao;

    @GetMapping("/getAll")
    public List<ContaDto> getAll() {
        List<ContaModel> listCon = conDao.getAll();
        List<ContaDto> listDto = ContaDto.converterLista(listCon);
        return listDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDto> getById(@PathVariable int id) {
        ContaModel con = conDao.getById(id);
        if (con != null) {
            ContaDto conDto = ContaDto.converter(con);
            return new ResponseEntity<ContaDto>(conDto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByUsuario/{idUsu}")
    public List<ContaDto> getByUsuario(@PathVariable int idUsu) {
        List<ContaModel> listCon = conDao.getByUsuario(idUsu);
        List<ContaDto> listDto = ContaDto.converterLista(listCon);
        return listDto;
    }
    
    @PostMapping("/save")
    public ResponseEntity<ContaDto> save(@RequestBody ContaDto con) {
        ContaModel savedCon = new ContaModel();
        savedCon.setIdConta(con.getIdConta());
        savedCon.setDescricaoConta(con.getDescricaoConta());
        savedCon.setValorConta(con.getValorConta());
        savedCon.setDataVencimentoConta(con.getDataVencimentoConta());
        savedCon.setDataPagamentoConta(con.getDataPagamentoConta());
        savedCon.setTipoConta(con.getTipoConta());
        savedCon.setStatusConta(con.isStatusConta());
        savedCon.setUsuarioConta(usuDao.getById(con.getIdUsuario()));
        savedCon.setCategoriaConta(catDao.getById(con.getIdCategoria()));
        
        conDao.insert(savedCon);
        ContaDto conDto = ContaDto.converter(savedCon);
        return new ResponseEntity<ContaDto>(conDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaDto> update(@PathVariable int id, @RequestBody ContaDto con) {
        ContaModel updatedCon = new ContaModel();
        updatedCon.setIdConta(con.getIdConta());
        updatedCon.setDescricaoConta(con.getDescricaoConta());
        updatedCon.setValorConta(con.getValorConta());
        updatedCon.setDataVencimentoConta(con.getDataVencimentoConta());
        updatedCon.setDataPagamentoConta(con.getDataPagamentoConta());
        updatedCon.setTipoConta(con.getTipoConta());
        updatedCon.setStatusConta(con.isStatusConta());
        updatedCon.setUsuarioConta(usuDao.getById(con.getIdUsuario()));
        updatedCon.setCategoriaConta(catDao.getById(con.getIdCategoria()));

        conDao.update(updatedCon);
        ContaDto conDto = ContaDto.converter(updatedCon);
        return new ResponseEntity<ContaDto>(conDto, HttpStatus.OK);
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
