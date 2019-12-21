package com.star.springboot.service.impl;

import com.star.springboot.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @ClassName MailServiceImpl
 * @Description 邮件服务实现类
 * @Author Administrator
 * @Date 2019/11/29 10:22
 * @Version 1.0
 */
@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String from;

	@Async
	@Override
	public void sendAttachMail(String to, String subject, String content, String filePath) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper=new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content);
			FileSystemResource file=new FileSystemResource(new File(filePath));
			String fileName=filePath.substring(filePath.lastIndexOf(File.separator));
			//添加多个附件可以使用多条
			//helper.addAttachment(fileName,file);
			helper.addAttachment(fileName,file);
			mailSender.send(message);
			System.out.println("带附件的邮件发送成功");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("发送带附件的邮件失败");
		}
	}

	@Override
	public void sendSimpleMessage(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setSubject(subject);
		message.setTo(to);
		message.setText(content);
		mailSender.send(message);
	}
}
