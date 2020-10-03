package com.user.controller;

import com.user.error.ErrorResponse;
import com.user.error.ObjectError;
import com.user.model.User;
import com.user.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * Controller do CRUD de usuário
 * @author eduardo.gewehr
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    /**
     * Cria um usuário
     * @param user
     * @return
     */
    @PutMapping(consumes = "application/json", value = "/create")
	public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
    	
    	if(user != null && user.getDocument() != null && getUserService().existsByDocument(user.getDocument())){
    		List<ObjectError> errors = new ArrayList<>();
    		errors.add(new ObjectError("Usuário com documento informado já existe", "document", user.getDocument()));
    		return new ResponseEntity<ErrorResponse>(new ErrorResponse("Requisição possui campos inválidos", 400, "Bad Request", "user", errors), HttpStatus.BAD_REQUEST);
    	}
 
    	User newUser = getUserService().createUser(user);
    	
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);	
	}

    /**
     * Retorna todos os usuários cadastrados
     * @return
     */
    @GetMapping
	public ResponseEntity<List<?>> getAllUsers() {
		return ResponseEntity.ok().body(getUserService().getAllUsers());
	}

    /**
     * Retorna um usuário a partir de um documento
     * @param document
     * @return
     */
	@GetMapping("/{document}")
	public ResponseEntity<?> getUserByDocument(@PathVariable String document) {

		if(getUserService().existsByDocument(document)){
			return ResponseEntity.ok().body(getUserService().getUserByDocument(document));
		}else{
			List<ObjectError> errors = new ArrayList<>();
    		errors.add(new ObjectError("Usuário não encontrado", "document", document));
    		return new ResponseEntity<ErrorResponse>(new ErrorResponse("Requisição possui campos inválidos", 400, "Bad Request", "user", errors), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Deleta um usuário a partir de um documento
	 * @param document
	 * @return 
	 */
	@DeleteMapping("/delete/{document}")
	public ResponseEntity<?> deleteUser(@PathVariable String document) {
    	
		if(getUserService().existsByDocument(document)){
			getUserService().deleteUserByDocument(document);
			return ResponseEntity.ok().build();
		}else{
			List<ObjectError> errors = new ArrayList<>();
    		errors.add(new ObjectError("Usuário não encontrado", "document", document));
    		return new ResponseEntity<ErrorResponse>(new ErrorResponse("Requisição possui campos inválidos", 400, "Bad Request", "user", errors), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Atualiza um usuário
	 * @param user
	 * @return
	 */
	@PostMapping(consumes = "application/json", value = "/update")
	public ResponseEntity<?> updateUser(@RequestBody @Valid User user) {
    	
		if(user != null && user.getDocument() != null && !getUserService().existsByDocument(user.getDocument())){
    		List<ObjectError> errors = new ArrayList<>();
    		errors.add(new ObjectError("Usuário com documento informado não existe", "document", user.getDocument()));
    		return new ResponseEntity<ErrorResponse>(new ErrorResponse("Requisição possui campos inválidos", 400, "Bad Request", "user", errors), HttpStatus.BAD_REQUEST);
    	}
 
    	User newUser = getUserService().updateUser(user);
    	
		return new ResponseEntity<User>(newUser, HttpStatus.OK);	
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
