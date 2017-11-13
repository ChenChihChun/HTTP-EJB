package jcs.mail;

import java.util.Map;


/**
 * 電子線上申請作業寄信內容<br>
 * Created on 2014年05月30日<br>
 * 
 */


public class MailSenderByEJB
{
  public void mailSenderByEJB(String suitnam, String caseno, String puno, String psnnam, String psntel, String psnaddress, String psnphone, String psnmail, String agtnam, String agttel, String agtaddress, String agtphone, String agtmail, String replaceword, String apply1, String apply2, String key,Map<String, String> dataMap)
  {
	  String port = dataMap.get("port");
	  int port_=25;
	  if(!port.equals("")){
		  port_=Integer.parseInt(port);
	  }
	  
	  String server = dataMap.get("server");
	  String user = dataMap.get("user");
	  String password = dataMap.get("password");
	  String receivers = dataMap.get("receivers");
	  String sender = dataMap.get("sender");
	  String starttls = dataMap.get("starttls");
	  String auth = dataMap.get("auth");
	  String type =dataMap.get("type"); //申請類別

      Send send = new Send(port_, server, starttls, auth, user,  password, receivers, sender);

    StringBuffer htmlcontent = new StringBuffer();
    
    if(type.equals("1")){//閱覽卷宗

      htmlcontent.append("訴願人姓名：" + suitnam + "<br>" + 
      "案號：" + caseno + "<br>" + 
      "原處分書文號：" + puno + "<br>" + 
      "申請人姓名：" + psnnam + "<br>" + 
      "申請人聯絡電話：" + psntel + "<br>" + 
      "申請人通訊地址：" + psnaddress + "<br>" + 
      "申請人手機：" + psnphone + "<br>" + 
      "申請人電子郵件：" + psnmail + "<br>" + 
      "代理人姓名：" + agtnam + "<br>" + 
      "代理人聯絡電話：" + agttel + "<br>" + 
      "代理人通訊地址：" + agtaddress + "<br>" + 
      "代理人手機：" + agtphone + "<br>" + 
      "代理人電子郵件：" + agtmail + "<br>" + 
      "是否提委任書(Y/N)：" + replaceword + "<br>" + 
      "申請事項：" + (apply1.equals("Y") ? "訴願卷內文書 " : "") + (apply2.equals("Y") ? "原行政處分機關據以處分資料" : "") + "<br>" + 
      "收信確認：<a style=\"color:red;\" href=\"http://aadmz.epa.gov.tw/EA/verify.do?SHA=" + key + "\">接收此申請案件並回覆民眾</a>");

    	send.buildHtmlContentData("經濟部訴願會線上申請閱覽卷宗內部通知信", htmlcontent.toString());
    }else if(type.equals("2")){//陳述意見

       htmlcontent.append("訴願人姓名：" + suitnam + "<br>" + 
      "案號：" + caseno + "<br>" + 
      "原處分書文號：" + puno + "<br>" + 
      "申請人姓名：" + psnnam + "<br>" + 
      "申請人聯絡電話：" + psntel + "<br>" + 
      "申請人通訊地址：" + psnaddress + "<br>" + 
      "申請人手機：" + psnphone + "<br>" + 
      "申請人電子郵件：" + psnmail + "<br>" + 
      "代理人姓名：" + agtnam + "<br>" + 
      "代理人聯絡電話：" + agttel + "<br>" + 
      "代理人通訊地址：" + agtaddress + "<br>" + 
      "代理人手機：" + agtphone + "<br>" + 
      "代理人電子郵件：" + agtmail + "<br>" + 
      "是否提委任書(Y/N)：" + replaceword + "<br>" + 
      "申請事項：" + (apply1.equals("Y") ? "訴願卷內文書 " : "") + (apply2.equals("Y") ? "原行政處分機關據以處分資料" : "") );
      send.buildHtmlContentData("經濟部訴願會線上申請陳述意見內部通知信", htmlcontent.toString());
      
    }else if(type.equals("3")){//言詞辯論
    	  htmlcontent.append("訴願人姓名：" + suitnam + "<br>" + 
	      "案號：" + caseno + "<br>" + 
	      "原處分書文號：" + puno + "<br>" + 
	      "申請人姓名：" + psnnam + "<br>" + 
	      "申請人聯絡電話：" + psntel + "<br>" + 
	      "申請人通訊地址：" + psnaddress + "<br>" + 
	      "申請人手機：" + psnphone + "<br>" + 
	      "申請人電子郵件：" + psnmail + "<br>" + 
	      "代理人姓名：" + agtnam + "<br>" + 
	      "代理人聯絡電話：" + agttel + "<br>" + 
	      "代理人通訊地址：" + agtaddress + "<br>" + 
	      "代理人手機：" + agtphone + "<br>" + 
	      "代理人電子郵件：" + agtmail + "<br>" + 
	      "是否提委任書(Y/N)：" + replaceword + "<br>" + 
	      "申請事項：" + (apply1.equals("Y") ? "訴願卷內文書 " : "") + (apply2.equals("Y") ? "原行政處分機關據以處分資料" : "") );
	      send.buildHtmlContentData("經濟部訴願會線上申請言詞辯論內部通知信", htmlcontent.toString());
    		      
    }
    try {
      send.SendAction();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}