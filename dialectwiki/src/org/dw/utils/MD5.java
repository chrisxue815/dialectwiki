package org.dw.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class MD5
{
  //static final String SALT = "hitchimpdw";
  
  static Md5PasswordEncoder encoder = new Md5PasswordEncoder();

  public static String toMD5(String source)
  {
    return encoder.encodePassword(source, null);
  }
}
