package com.app.services;

import org.springframework.stereotype.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

@Transactional
@Service
public class EmailService {

		public boolean sendEmail(String subject, String message ,String to) {
		
		
		String from ="kajalghule111@gmail.com";
		//Variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("kajalghule111@gmail.com", "ehuwytjeowtvkdhy");
				/*
				 * https://myaccount.google.com/security  --> on 2-Step Verification
					https://myaccount.google.com/apppasswords?rapt=AEjHL4OAT_Qfef6ZgIrMpLzNMx1nBpVg2gz8OvuehfvVRIEF5febixFhdu8WZwxHCc7veBvOIpFrJ4e6mLv-yfCkLQJshJXHdRNgE8gvqVK9-tnwNp2sdu0---> set name ang get like this rznmxmabdppvrbwe 
				 * */
			}
				
		});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		m.setText(message);
		
		//send 
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
		
		return true;
		
		}catch (Exception e) {
			System.out.println("Email sending failed:");
			e.printStackTrace();
			return false;
		}
	}
}

