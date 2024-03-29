package org.descentmanager.controller;

import java.util.LinkedHashMap;

import org.descentmanager.model.Usuario;
import org.descentmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private UsuarioRepository usuarioRepository;

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
//        return new ModelAndView("login", "error", error);
//    }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
    public Usuario login(@RequestBody LinkedHashMap<String, Object> body) {
		String username = (String) body.get("username");
		Usuario usuario = usuarioRepository.findByAlias(username);
        return usuario;
    }
}