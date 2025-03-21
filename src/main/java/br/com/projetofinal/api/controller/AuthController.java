package br.com.projetofinal.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.api.dao.AuthDao;
import br.com.projetofinal.api.dto.LoginDto;
import br.com.projetofinal.api.dto.UsuarioDto;
import br.com.projetofinal.api.model.UsuarioModel;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthDao authDao;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        UsuarioModel loggedUsu = authDao.getByEmailAndSenha(loginDto.getEmail(), loginDto.getSenha());

        if (loggedUsu != null) {
            UsuarioDto usuDto = UsuarioDto.converter(loggedUsu);
            return new ResponseEntity<>(usuDto, HttpStatus.OK);
        }

        return new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
    }

}
