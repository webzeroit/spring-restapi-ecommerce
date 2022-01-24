package com.ecommerce.services.email;

import com.ecommerce.domain.Product;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendConfirmationEmail(Product obj);

    void sendEmail(SimpleMailMessage msg);

    void sendConfirmationEmailHtml(Product obj);

    void sendEmailHtml(MimeMessage msg);

    void sendNewPassword(String email, String newPassword);
}
