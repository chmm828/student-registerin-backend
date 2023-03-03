package com.server.utils;

import com.server.vo.MailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.Arrays;

/**
 * @author ： 
 * @date ：Created in  2022/11/14 12:55
 * @description：发song邮箱工具类
 * @modified By：
 */
@Slf4j
@Component
public class MailUtil {
    @Autowired
    private JavaMailSender mailSender;

    //发件人
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送邮件
     * @param mailVo 发送的内容
     * @return
     */
    public String sendMail(MailVo mailVo){
        try {
            if(mailVo.isHtml()){
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
                mimeMessageHelper.setFrom(from);
                mimeMessageHelper.setTo(mailVo.getReceivers());
                mimeMessageHelper.setSubject(mailVo.getSubject());
                mimeMessageHelper.setText(mailVo.getContent(),true);
                mailSender.send(mimeMessage);
                log.info("HTML发送成功！收件人--{}---", Arrays.asList(mailVo.getReceivers()));
            }else {
                //创建邮件对象
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                //发件人
                simpleMailMessage.setFrom(from);
                //收件人
                simpleMailMessage.setTo(mailVo.getReceivers());
                //邮件的主题
                simpleMailMessage.setSubject(mailVo.getSubject());
                //邮件内容
                simpleMailMessage.setText(mailVo.getContent());
                mailSender.send(simpleMailMessage);
                log.info("普通邮件发送成功！收件人--{}---",Arrays.asList(mailVo.getReceivers()));
            }
            return "邮件发送成功";
        }catch (Exception e){
            log.error("邮件发送失败--->{}",e.getMessage());
            return "邮件发送失败";
        }
    }
}
