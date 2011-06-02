package org.dw.action;

import java.io.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PronounceUploadAction extends ActionSupport {

	private static final long serialVersionUID = 7565136657043722828L;
	
	private HttpServletRequest request;
	public String execute(){
		
		InputStream inputStream;
		FileOutputStream fo;
		try {
			request = ServletActionContext.getRequest();
			
			inputStream = request.getInputStream();

			byte[] bytes = new byte[1024];
			byte[] IntB = new byte[4];

			int data;
			int word;
			int city;
			
			inputStream.read(IntB);

			word = ByteToInt(IntB);

			System.out.println(word);

			inputStream.read(IntB);

			city = ByteToInt(IntB);

			System.out.println(city);
			
			File f1 = new File("C://1.mp3"); // 输出文件流地址待定

			fo = new FileOutputStream(f1);
			// 开始写文件
			while ((data = inputStream.read(bytes)) != -1) {
				fo.write(bytes, 0, data);
			}
			inputStream.close();

			fo.close();
			System.out.println("Action invoked");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return ERROR;
		}
		return ERROR;
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
