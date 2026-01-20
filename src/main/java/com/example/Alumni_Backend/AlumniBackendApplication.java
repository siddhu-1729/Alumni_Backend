package com.example.Alumni_Backend;

import com.example.Alumni_Backend.models.Role;
import com.example.Alumni_Backend.models.User;
import com.example.Alumni_Backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class AlumniBackendApplication implements CommandLineRunner {
	@Autowired
	UserRepo userRepo;
	public static void main(String[] args) {

		SpringApplication.run(AlumniBackendApplication.class, args);
	}

    @Override
	public void run(String... args) throws Exception {
		List<User> admin = userRepo.findByRole(Role.ADMIN);
		if (admin == null) {

			User user= new User();

			user.setUsername("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setWorkingcompany("SRKR Engineering College(Autonomous)");
			userRepo.save(user);
		}
	}

}
