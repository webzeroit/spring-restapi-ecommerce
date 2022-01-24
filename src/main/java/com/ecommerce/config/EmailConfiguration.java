package com.ecommerce.config;

import com.ecommerce.services.email.EmailService;
import com.ecommerce.services.email.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfiguration {

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
