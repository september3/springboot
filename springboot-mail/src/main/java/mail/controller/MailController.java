package mail.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author sunlele
 * @className MailController
 * @date 2019/4/13 11:31
 **/
@RestController
@Slf4j
public class MailController {


    /**
     *  发送者
     */
    @Value("${mail.fromMail.sender}")
    private String sender;

    /**
     * 接受者
     */
    @Value("${mail.fromMail.receiver}")
    private String receiver;

    @Resource
    private JavaMailSender javaMailSender;

    /**
     * @Description 简单文本邮件
     * @method 发送文本邮件
     * @return  String
     */
    @RequestMapping("/sendMail")
    public String sendSimppleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);
        // 标题
        message.setSubject("sunlele-简单文本邮件测试");
        // 内容
        message.setText("世界，你好！--->文本邮件");
        try {
            javaMailSender.send(message);
            log.info("文本邮件发送成功！");
            return "success";
        } catch (Exception e) {
            log.error("文本邮件发送异常！", e);
            return "failure";
        }
    }

    /**
     * HTML邮件测试
     * @return
     */
    @RequestMapping("/sendHtmlMain")
    public String sendHtmlEmail(){
        String content = "<html><body><h3>hello world ! --->Html邮件</h3></body></html>";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("sunlele-Html邮件测试");
            helper.setText(content, true);

            javaMailSender.send(message);
            log.info("Html邮件发送成功！");
            return "success";
        } catch ( MessagingException e) {
            log.error("Html邮件发送异常！", e);
            return "failure";
        }
    }

    /**
     * 发送带附件的邮件
     * @return String
     */
    @RequestMapping("/sendFilesMail")
    public String sendFilesMail() {
        String filePath = "F:\\IDEA0\\b.txt";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("一起去玩");
            helper.setText("好的", true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            javaMailSender.send(message);
            log.info("附件邮件发送成功！");
            return "success";
        } catch (MessagingException e) {
            log.error("附件邮件发送异常！", e);
            return "failure";
        }
    }

    /**
     * 发送带图片的邮件
     * 待解决问题：发送图片邮件图片不显示
     * @return String
     */
    @RequestMapping("/sendImageMail")
    public String sendInlineResourceMail() {
        String id = "sunlele";
        // cid:内嵌资源
        String content = "<html><body>图片：<img src=\'cid:" + id + "\'></body></html>";
        String imgPath = "F:\\IDEA0\\z2.jpg";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("要一起吗");
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(imgPath));
            helper.addInline(id, res);

            javaMailSender.send(message);
            log.info("图片邮件发送成功！");
            return "success";
        } catch (MessagingException e) {
            log.error("图片邮件发送异常！", e);
            return "failure";
        }

    }


}
