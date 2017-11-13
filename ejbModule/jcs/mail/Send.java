package jcs.mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
//import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 * 電子線上申請作業寄信功能<br>
 * Created on 2014年05月30日<br>
 * 
 */
public class Send
{
  private int port = 25;
  private String server = "";
  private String starttls = "";
  private String auth = "";
  private String user = "";
  private String password = "";
  private String receivers = "";
  private String contentData = "";
  private String sender = "";
  private String receivers2 = "god@epa.gov.tw";
  private String subject = "";

  public Send(int port, String server, String starttls, String auth, String user, String password, String receivers, String sender)
  {
    this.port = port;
    this.server = server;
    this.starttls = starttls;//是否啟用TTLS，加密用(例:公司用的hinet、經濟部信箱不用，google信箱)
    this.auth = auth;       //是否透過帳號密碼認證(POP3)
    this.user = user;       //寄信者帳號
    this.password = password; //寄信密碼
    this.receivers = receivers; //收信者帳號
    this.sender = sender;   //寄信者名稱顯示
  }

//  public void setSendProperties(int port, String server, String starttls, String auth, String user, String password)
//  {
//    setSendProperties(port, server, starttls, auth, user, password, "", "", ExceptionHandler.Errorlevel.warring, "");
//  }
//
//  public void setSendProperties(int port, String server, String starttls, String auth, String user, String password, String receivers, String sender, ExceptionHandler.Errorlevel errorLevel, String mainMessage)
//  {
//    if (port != 0) {
//      this.port = port;
//    }
//    if (server.length() > 0) {
//      this.server = server;
//    }
//    if (starttls.length() > 0) {
//      this.starttls = starttls;
//    }
//    if (auth.length() > 0) {
//      this.auth = auth;
//    }
//    if (user.length() > 0) {
//      this.user = user;
//    }
//    if (password.length() > 0) {
//      this.password = password;
//    }
//    if (receivers.length() > 0) {
//      this.receivers = receivers;
//    }
//    if (sender.length() > 0) {
//      this.sender = sender;
//    }
//    this.errorLevel = errorLevel;
//    this.mainMessage = mainMessage;
//  }
//
//  public void setSendProperties(String receivers, String sender, ExceptionHandler.Errorlevel errorLevel, String mainMessage)
//  {
//    setSendProperties(0, "", "", "", "", "", receivers, sender, errorLevel, mainMessage);
//  }
//
//  public void setSendProperties(String mainMessage, ExceptionHandler.Errorlevel errorLevel)
//  {
//    setSendProperties(0, "", "", "", "", "", "", "", errorLevel, mainMessage);
//  }

  public void SendAction()
    throws Exception
  {
    SendActionThread thread = new SendActionThread();
    thread.run();
  }

  private void sendAction(String receiver, Session session) throws MessagingException {
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(this.sender));

    String[] toEmails = receiver.split(";");
    for (int i = 0; i < toEmails.length; i++) {
      message.addRecipient(Message.RecipientType.TO, 
        new InternetAddress(toEmails[i]));
    }

    message.setSubject(this.subject);

    MimeBodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setContent(this.contentData, "text/html; charset=UTF-8");
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);

    message.setContent(multipart);
    Transport.send(message);
  }

//  private String getTheme() {
//    switch ($SWITCH_TABLE$jcs$exception$ExceptionHandler$Errorlevel()[this.errorLevel.ordinal()]) {
//    default:
//      return "【NOTICE】錯誤內容" + this.mainMessage;
//    case 2:
//      return "【WARRING】錯誤內容" + this.mainMessage;
//    case 3:
//      return "【ERROR】錯誤內容" + this.mainMessage;
//    case 4:
//    }return "FATAL】錯誤內容" + this.mainMessage;
//  }
  public void buildHtmlContentData(String subject,String content){
	  this.subject=subject;
	  this.contentData=content;
  }
//  public void buildHtmlContentData(String userid, String userName, String ip, String deptid, String deptName, String updatedate, String updatetime, String pid, String errorMsg)
//  {
//    StringBuilder html = new StringBuilder();
//    html.append("<table border=\"1\" style=\"width:100%\"><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("帳號").append("</td>");
//    html.append("<td style=\"width:25%\">").append(userid).append("</td>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("姓名").append("</td>");
//    html.append("<td style=\"width:25%\">").append(userName).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("單位代碼").append("</td>");
//    html.append("<td style=\"width:25%\">").append(deptid).append("</td>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("單位名稱").append("</td>");
//    html.append("<td style=\"width:25%\">").append(deptName).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("發生日期").append("</td>");
//    html.append("<td style=\"width:25%\">").append(updatedate).append("</td>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("發生時間").append("</td>");
//    html.append("<td style=\"width:25%\">").append(updatetime).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("SERVER").append("</td>");
//    html.append("<td style=\"width:25%\">").append(ip).append("</td>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("錯誤代碼").append("</td>");
//    html.append("<td style=\"width:25%\">").append(pid).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" colspan=\"4\">").append("以下為錯誤內容").append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td colspan=\"4\">").append(errorMsg.replace("\n", "<br/>")).append("</td>");
//    html.append("</tr></table>");
//    this.contentData = html.toString();
//  }

//  public void buildODCSHtmlContentData(String userid, String userName, String ip, String deptid, String deptName, String updatedate, String updatetime, String pid, String errorMsg, String other)
//  {
//    StringBuilder html = new StringBuilder();
//    html.append("<table border=\"1\" style=\"width:100%\"><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("帳號").append("</td>");
//    html.append("<td style=\"width:25%\">").append(userid).append("</td>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("姓名").append("</td>");
//    html.append("<td style=\"width:25%\">").append(userName).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("單位代碼").append("</td>");
//    html.append("<td style=\"width:25%\">").append(deptid).append("</td>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("單位名稱").append("</td>");
//    html.append("<td style=\"width:25%\">").append(deptName).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("發生日期").append("</td>");
//    html.append("<td style=\"width:25%\">").append(updatedate).append("</td>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("發生時間").append("</td>");
//    html.append("<td style=\"width:25%\">").append(updatetime).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("SERVER").append("</td>");
//    html.append("<td style=\"width:25%\">").append(ip).append("</td>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("錯誤代碼").append("</td>");
//    html.append("<td style=\"width:25%\">").append(pid).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("其他可用訊息").append("</td>");
//    html.append("<td style=\"width:75%\" colspan=\"3\">").append(other).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" colspan=\"4\">").append("以下為錯誤內容").append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td colspan=\"4\">").append(errorMsg.replace("\n", "<br/>")).append("</td>");
//    html.append("</tr></table>");
//    this.contentData = html.toString();
//  }

//  public void buildViewerHtmlContentData(String other, String pid, String ip, String updatedate, String updatetime, String errorMsg)
//  {
//    StringBuilder html = new StringBuilder();
//    html.append("<table border=\"1\" style=\"width:100%\"><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("其他可用訊息").append("</td>");
//    html.append("<td style=\"width:75%\" colspan=\"3\">").append(other).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("發生日期").append("</td>");
//    html.append("<td style=\"width:25%\">").append(updatedate).append("</td>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("發生時間").append("</td>");
//    html.append("<td style=\"width:25%\">").append(updatetime).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("SERVER").append("</td>");
//    html.append("<td style=\"width:25%\">").append(ip).append("</td>");
//    html.append("<td bgcolor=\"#CCFF33\" style=\"width:25%\">").append("錯誤代碼").append("</td>");
//    html.append("<td style=\"width:25%\">").append(pid).append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td bgcolor=\"#CCFF33\" colspan=\"4\">").append("以下為錯誤內容").append("</td>");
//    html.append("</tr><tr>");
//    html.append("<td colspan=\"4\">").append(errorMsg.replace("\n", "<br/>")).append("</td>");
//    html.append("</tr></table>");
//    this.contentData = html.toString();
//  }

  private class SendActionThread extends Thread
  {
    private SendActionThread()
    {
    }

    public void run() {
      final String username = Send.this.user;
      final String password = Send.this.password;

      Properties props = new Properties();
      props.put("mail.smtp.auth", Send.this.auth);
      props.put("mail.smtp.starttls.enable", Send.this.starttls);
      props.put("mail.smtp.host", Send.this.server);
      props.put("mail.smtp.port", Integer.valueOf(Send.this.port));

      Session session = Session.getInstance(
        props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(username, password);
        }
      });
      try
      {
        Send.this.sendAction(Send.this.receivers, session);
      } catch (MessagingException e) {
        if (e.getMessage().toLowerCase().contains("unable to relay"))
          try
          {
//         
            Send.this.sendAction(Send.this.receivers2, session);
          } catch (MessagingException ex) {
            ex.printStackTrace();
          }
        else
          e.printStackTrace();
      }
    }
  }
}