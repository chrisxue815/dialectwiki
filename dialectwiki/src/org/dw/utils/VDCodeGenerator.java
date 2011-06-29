package org.dw.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class VDCodeGenerator
{
  private ByteArrayInputStream image;// 图像
  private String str;// 验证码

  private VDCodeGenerator()
  {
    init();
  }

  public static VDCodeGenerator getInstance()
  {
    return new VDCodeGenerator();
  }

  public ByteArrayInputStream getImage()
  {
    return image;
  }

  public String getStr()
  {
    return str;
  }

  private void init()
  {
    int width = 100;
    int height = 30;

    // 在内存中创建图片对象
    BufferedImage image = new BufferedImage(width, height,
        BufferedImage.TYPE_INT_RGB);

    // 获取图片上下文
    Graphics g = image.getGraphics();

    // 随机数生成类
    Random random = new Random();

    // 颜色填充器颜色设置
    g.setColor(getRandColor(200, 250));
    g.fillRect(0, 0, width, height);

    // 设置字体
    g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
    g.setColor(getRandColor(160, 200));
    for (int i = 0; i < 155; i++)
    {
      int x = random.nextInt(width);
      int y = random.nextInt(height);
      int xl = random.nextInt(12);
      int yl = random.nextInt(12);
      g.drawLine(x, y, x + xl, y + yl);
    }

    // 取随机产生的认证码(6位数字)
    String sRand = "";
    for (int i = 0; i < 6; i++)
    {
      String rand = String.valueOf(random.nextInt(10));
      sRand += rand;
      // 将认证码显示到图象中
      g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110),
          20 + random.nextInt(110)));
      // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
      g.drawString(rand, 13 * i + 6, 16);
    }

    this.str = sRand;

    g.dispose();

    ByteArrayInputStream input = null;
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    try
    {
      ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
      ImageIO.write(image, "JPEG", imageOut);
      imageOut.close();
      input = new ByteArrayInputStream(output.toByteArray());

    } catch (Exception e)
    {
      System.out.println("验证码图片产生出现错误：" + e.toString());
    }

    this.image = input;// 赋值图片
  }

  private Color getRandColor(int fc, int bc)
  {
    Random random = new Random();
    if (fc > 255)
      fc = 255;
    if (bc > 255)
      bc = 255;
    int r = fc + random.nextInt(bc - fc);
    int g = fc + random.nextInt(bc - fc);
    int b = fc + random.nextInt(bc - fc);
    return new Color(r, g, b);
  }

}
