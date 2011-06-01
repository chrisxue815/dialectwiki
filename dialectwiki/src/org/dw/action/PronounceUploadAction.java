package org.dw.action;

import java.io.*;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class PronounceUploadAction extends ActionSupport {

	private static final long serialVersionUID = 7565136657043722828L;
	
	public String execute()
	{
		System.out.println("com");
		InputStream inputStream;
		try {
			inputStream = ServletActionContext.getRequest().getInputStream();
		
		FileOutputStream fo;

		byte[] bytes = new byte[1024];
		byte[] IntB = new byte[4];
		
		inputStream.read(IntB);		//读取第一个字节流长度 第一个是word的ID字节流 内部为数字
		int data;
		
		data = IntB[3] & 0xFF;
		data |= ((IntB[2] << 8) & 0xFF00);
		data |= ((IntB[1] << 16) & 0xFF0000);
		data |= ((IntB[0] << 24) & 0xFF000000);
		
		byte[] word = new byte[data];
		inputStream.read(word);		//读取第一个字节流

		String strWord = new String(word);
		System.out.println(strWord);
				
		inputStream.read(IntB);		//读取第二个字节流的长度 第一个是city名字的字节流 内部为数字

		data = IntB[3] & 0xFF;
		data |= ((IntB[2] << 8) & 0xFF00);
		data |= ((IntB[1] << 16) & 0xFF0000);
		data |= ((IntB[0] << 24) & 0xFF000000);

		data *=3;			//如果是汉字,字节流要长度*3 
		
		byte[] city = new byte[data];	
		inputStream.read(city);		//读取第二个字节流

		String strCity = new String(city,0,data,"UTF-8");	//将CITY字节流转换为字符串
		
		System.out.println(strWord +" "+ strCity);


		File f1 = new File("C://1.mp3");//输出文件流 地址待定

		fo = new FileOutputStream(f1);
		//开始写文件
		while ((data = inputStream.read(bytes)) != -1) {
			System.out.println("asdf");
			fo.write(bytes, 0, data);
		}
		inputStream.close();
		
		fo.close();
		System.out.println("Action invoked");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
