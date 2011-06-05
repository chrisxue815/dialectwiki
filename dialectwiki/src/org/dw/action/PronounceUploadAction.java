package org.dw.action;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dw.model.Pronunciation;
import org.dw.service.PronunciationService;
import org.dw.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.opensymphony.xwork2.ActionSupport;

public class PronounceUploadAction extends ActionSupport {

	private static final long serialVersionUID = 7565136657043722828L;
	
	private HttpServletRequest request;
	
	private PronunciationService pronunciationService;
	
	public PronunciationService getPronunciationService() {
		return pronunciationService;
	}
	public void setPronunciationService(PronunciationService pronunciationService) {
		this.pronunciationService = pronunciationService;
	}
	
	public String execute(){
		
		System.out.println("invoked");
		InputStream inputStream;
		FileOutputStream fo;
		try {

			File f1 = null;
			
			request = ServletActionContext.getRequest();
			
			inputStream = request.getInputStream();

			byte[] bytes = new byte[1024];
			byte[] IntB = new byte[4];

			int data;
			int word;
			int city;
			
			inputStream.read(IntB);

			word = ByteToInt(IntB);

			inputStream.read(IntB);

			city = ByteToInt(IntB);
			
			String path = request.getSession().getServletContext().getRealPath("/");
			
			String prUrl = "pron/";
			
			//****
			
			f1 = new File(prUrl);
			
			if(!f1.exists())
			{
				f1.mkdir();
				System.out.println("mkdir");
			}
			else System.out.println("exist");
			//*****/
			
			SimpleDateFormat sdf   =   new   SimpleDateFormat( "yyyyMM");
			Date date = new Date();
			
			prUrl += sdf.format(date) + "/";
			
			f1 = new File(prUrl);
			
			if(!f1.exists())
			{
				f1.mkdir();
				System.out.println("mkdir");
			}
			else System.out.println("exist");
			
			int random = 0;
			
			do{
			random = new Random().nextInt(900000000)+ 100000000;
			
			prUrl += random+".mp3";
			
			System.out.println(prUrl);
			
			f1 = new File(prUrl); // 输出文件流地址待定

			}while(f1.exists());
			
			fo = new FileOutputStream(f1);
			// 开始写文件
			
			while ((data = inputStream.read(bytes)) != -1) {
				fo.write(bytes, 0, data);
			}
			System.out.println("Action invoked1");
			inputStream.close();

			System.out.println("Action invoked2");
			fo.close();

			System.out.println("Action invoked3");
			pronunciationService.save(word, city, prUrl, date);
			
			System.out.println("Action invoked4");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	private int ByteToInt(byte temp[])
	{
		int a;
		a = temp[3] & 0xFF;
		a |= ((temp[2] << 8) & 0xFF00);
		a |= ((temp[1] << 16) & 0xFF0000);
		a |= ((temp[0] << 24) & 0xFF000000);
		return a;
	}

}
