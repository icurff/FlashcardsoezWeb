package com.icurff.flashcardsoez.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icurff.flashcardsoez.model.User;
import com.icurff.flashcardsoez.repository.MyRepo;

@Service
public class MyService {
	@Autowired
	MyRepo myRepository;

	public void saveUser(User user) throws Exception {
		Optional<User> existingUserByEmail = myRepository.findByEmail(user.getEmail());
		Optional<User> existingUserByUsername = myRepository.findByUsername(user.getUsername());

		if (existingUserByEmail.isPresent() || existingUserByUsername.isPresent()) {
			throw new Exception("Email or Username already exists");
		}

		// hash password and save
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		myRepository.save(user);
	}

}
