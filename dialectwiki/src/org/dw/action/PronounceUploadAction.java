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
    
    int data;
    int word;
    int city;
    inputStream.read(IntB);
    
    word = IntB[3] & 0xFF;
    word |= ((IntB[2] << 8) & 0xFF00);
    word |= ((IntB[1] << 16) & 0xFF0000);
    word |= ((IntB[0] << 24) & 0xFF000000);
    
    System.out.println(word);
        
    inputStream.read(IntB);

    city = IntB[3] & 0xFF;
    city |= ((IntB[2] << 8) & 0xFF00);
    city |= ((IntB[1] << 16) & 0xFF0000);
    city |= ((IntB[0] << 24) & 0xFF000000);

    System.out.println(city);
    File f1 = new File("C://1.mp3");  // 输出文件流地址待定

    fo = new FileOutputStream(f1);
    //开始写文件
    while ((data = inputStream.read(bytes)) != -1) {
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
