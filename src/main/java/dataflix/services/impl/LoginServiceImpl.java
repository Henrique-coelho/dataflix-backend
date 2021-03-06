package dataflix.services.impl;

import dataflix.entities.Usuario;
import dataflix.exceptions.ServiceException;
import dataflix.repositories.UsuarioRepository;
import dataflix.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<Usuario> validateLogin(String usuario, String senha) {
        try  {
            var entity = usuarioRepository.validateLogin(usuario, senha);
            return new ResponseEntity<Usuario>(entity, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(null, e.getHttpStatus());
        }

    }

}
