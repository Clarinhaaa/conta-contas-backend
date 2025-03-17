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

import br.com.projetofinal.api.dao.EnderecoDao;
import br.com.projetofinal.api.dao.TelefoneDao;
import br.com.projetofinal.api.dao.UsuarioDao;
import br.com.projetofinal.api.dto.UsuarioDto;
import br.com.projetofinal.api.model.UsuarioModel;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioDao usuDao;
    @Autowired
    private EnderecoDao endDao;
    @Autowired
    private TelefoneDao telDao;

    @GetMapping("/getAll")
    public List<UsuarioDto> getAll() {
        List<UsuarioModel> listUsu = usuDao.getAll();
        List<UsuarioDto> listDto = UsuarioDto.converterLista(listUsu);
        return listDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable int id) {
        UsuarioModel usu = usuDao.getById(id);
        if (usu != null) {
            UsuarioDto usuDto = UsuarioDto.converter(usu);
            return new ResponseEntity<UsuarioDto>(usuDto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<UsuarioDto> save(@RequestBody UsuarioDto usu) {
        UsuarioModel savedUsu = new UsuarioModel();
        savedUsu.setIdUsuario(usu.getIdUsuario());
        savedUsu.setNomeUsuario(usu.getNomeUsuario());
        savedUsu.setCpfUsuario(usu.getCpfUsuario());
        savedUsu.setEmailUsuario(usu.getEmailUsuario());
        savedUsu.setSenhaUsuario(usu.getSenhaUsuario());
        savedUsu.setEnderecoUsuario(endDao.getById(usu.getIdEndereco()));
        savedUsu.setTelefoneUsuario(telDao.getById(usu.getIdTelefone()));
        
        usuDao.insert(savedUsu);
        UsuarioDto usuDto = UsuarioDto.converter(savedUsu);
        return new ResponseEntity<UsuarioDto>(usuDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable int id, @RequestBody UsuarioDto usu) {
        UsuarioModel updatedUsu = new UsuarioModel();
        updatedUsu.setIdUsuario(usu.getIdUsuario());
        updatedUsu.setNomeUsuario(usu.getNomeUsuario());
        updatedUsu.setCpfUsuario(usu.getCpfUsuario());
        updatedUsu.setEmailUsuario(usu.getEmailUsuario());
        updatedUsu.setSenhaUsuario(usu.getSenhaUsuario());
        updatedUsu.setEnderecoUsuario(endDao.getById(usu.getIdEndereco()));
        updatedUsu.setTelefoneUsuario(telDao.getById(usu.getIdTelefone()));

        usuDao.update(updatedUsu);
        UsuarioDto usuDto = UsuarioDto.converter(updatedUsu);
        return new ResponseEntity<UsuarioDto>(usuDto, HttpStatus.OK);
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
