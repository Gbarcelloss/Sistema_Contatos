package br.com.cotiinformatica.messages;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class EmailMessage {

	//atributos
	private static final String ACCOUNT = "cotiaulajava@outlook.com";
	private static final String PASSWORD = "@Admin123456";
	private static final String SMTP = "smtp-mail.outlook.com";
	private static final Integer PORT = 587;
	
	//método para realizar o envio do email
	public static void sendMessage(final String to, final String subject, final String body) throws Exception {
		
		//Informações da conta que fará o envio dos emails
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setUsername(ACCOUNT);
		senderImpl.setPassword(PASSWORD);
		senderImpl.setHost(SMTP);
		senderImpl.setPort(PORT);
		
		//Configurações para envio do email
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.transport.protocol", "smtp");
		senderImpl.setJavaMailProperties(properties);
		
		//Montando o conteúdo do email..
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
				helper.setFrom(ACCOUNT); //remetente da mensagem
				helper.setTo(to); //destinatário da mensagem
				helper.setSubject(subject); //assunto da mensagem
				helper.setText(body); //corpo da mensagem
			}
		};
		
		//enviando o email..
		senderImpl.send(messagePreparator);
	}
}
