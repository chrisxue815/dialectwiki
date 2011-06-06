package org.dw.action;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class VerificationCodeAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  
  private static int WIDTH = 60;
  private static int HEIGHT = 25;

  public String execute()
  {
    try
    {
      HttpServletRequest request = ServletActionContext.getRequest();
      HttpServletResponse response = ServletActionContext.getResponse();
      
      HttpSession session = request.getSession();
      
      response.setContentType("image/jpeg");
      ServletOutputStream sos = response.getOutputStream();
      
      // 设置浏览器不要缓存此图片
      response.setHeader("Pragma", "No-cache");
      response.setHeader("Cache-Control", "no-cache");
      response.setDateHeader("Expires", 0);
      
      // 创建内存图象并获得其图形上下文
      BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
          BufferedImage.TYPE_INT_RGB);
      Graphics g = image.getGraphics();
      
      // 产生随机的认证码
      char[] rands = generateCheckCode();
      
      // 产生图像
      drawBackground(g);
      drawRands(g, rands);
      
      // 结束图像 的绘制 过程， 完成图像
      g.dispose();
      
      // 将图像输出到客户端
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ImageIO.write(image, "JPEG", bos);
      byte[] buf = bos.toByteArray();
      response.setContentLength(buf.length);
      
      // 下面的语句也可写成： bos.writeTo(sos);
      sos.write(buf);
      bos.close();
      sos.close();
      
      // 将当前验证码存入到 Session 中
      session.setAttribute("vcode", new String(rands));
      
      // 直接使用下面的代码将有问题， Session 对象必须在提交响应前获得
      // request.getSession().setAttribute("check_code",new String(rands));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    
    return SUCCESS;
  }

  /**
   * 定义验证码的字符表
   * 
   * @return
   */
  private char[] generateCheckCode()
  {
    String chars = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] rands = new char[4];
    for (int i = 0; i < 4; i++)
    {
      int rand = (int) (Math.random() * 61);
      rands[i] = chars.charAt(rand);
    }
    return rands;
  }

  /**
   * 画出随机数值
   * 
   * @param
   * @param rands
   */
  private void drawRands(Graphics g, char[] rands)
  {
    g.setColor(Color.BLUE);
    g.setFont(new Font(null, Font.PLAIN | Font.PLAIN, 18));
    g.drawString("" + rands[0], 1, 17);
    g.drawString("" + rands[1], 16, 15);
    g.drawString("" + rands[2], 31, 18);
    g.drawString("" + rands[3], 46, 16);
    // System.out.println(rands);
  }

  /**
   * 画图片背景
   * 
   * @param g
   */
  private void drawBackground(Graphics g)
  {
    g.setColor(new Color(0xDCDCDC));
    g.fillRect(0, 0, WIDTH, HEIGHT);
    // 随机产生 120 个干扰点
    for (int i = 0; i < 120; i++)
    {
      int x = (int) (Math.random() * WIDTH);
      int y = (int) (Math.random() * HEIGHT);
      int red = (int) (Math.random() * 255);
      int green = (int) (Math.random() * 255);
      int blue = (int) (Math.random() * 255);
      g.setColor(new Color(red, green, blue));
      g.drawOval(x, y, 1, 0);
    }
  }

  /**
   * 验证用户输入的验证码
   * 
   * @param request
   * @param response
   * @return
   */
  public boolean checkLook(HttpServletRequest request,
      HttpServletResponse response, String check)
  {
    response.setContentType("text/html;charset=GB2312");
    try
    {
      HttpSession session = request.getSession(false);
      check = check.toLowerCase(); // 把用户输入的验证码转换成小写
      if (session == null)
        return false;
      String savedCode = (String) session.getAttribute("check_code");
      savedCode = savedCode.toLowerCase(); // 把存到session里的值转换成小写
      if (savedCode == null)
        return false;
      if (!savedCode.equals(check))
        return false;
    } catch (Exception e)
    {
      e.printStackTrace();
    }
    return true;
  }
}
