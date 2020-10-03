package com.user.service;

import com.user.model.User;
import com.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

/**
 * Service do CRUD de usuário
 * @author eduardo.gewehr
 *
 */
@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
	
    public User createUser(User user) {
        return getUserRepository().save(user);
    }

    public List<User> getAllUsers() {
        return getUserRepository().findAll(Sort.by(Sort.Direction.ASC, "document"));
    }

    public void deleteUser(String id) {
    	getUserRepository().deleteById(id);
    }
    
    public void deleteUserByDocument(String id) {
    	getUserRepository().deleteByDocument(id);
    }

    public User getUserById(String id) {
        return getUserRepository().findById(id).get();
    }
    
    public User getUserByDocument(String document) {
        return getUserRepository().findByDocument(document);
    }
    
    public boolean existsByDocument(String document) {
        return getUserRepository().existsByDocument(document);
    }

    public User updateUser(User user) {
        return getUserRepository().save(user);
    }
    
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
