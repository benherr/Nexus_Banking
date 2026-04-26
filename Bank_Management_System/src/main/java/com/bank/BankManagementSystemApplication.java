package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.bank.entity.AdminDetails;
import com.bank.repository.AdminRepository;

@SpringBootApplication
public class BankManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankManagementSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedAdmin(AdminRepository adminRepository) {
		return args -> {
			if (adminRepository.findByAdminEmailid("admin@gmail.com") == null) {
				AdminDetails admin = new AdminDetails();
				admin.setAdminId(1);
				admin.setAdminEmailid("admin@gmail.com");
				admin.setAdminPin("1234");
				adminRepository.save(admin);
				System.out.println("Admin user seeded successfully!");
			}
		};
	}
}
