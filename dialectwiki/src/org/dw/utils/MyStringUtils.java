package org.dw.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyStringUtils {
	public static String replaceBlank(String str) {
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);
		str = m.replaceAll("");
		return str;
	}

	public static boolean checkUserName(String str) {//错误返回true
		int flag = 1;
		for (int i = 0; i < str.length() && flag == 1; i++) {
			flag = 0;
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				flag = 1;
			}
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				flag = 1;
			}
			if (str.charAt(i) == '_') {
				flag = 1;
			}
		}
		if(flag==1)
		return false;
		else return true;
	}

	public static boolean checkUserPass(String str) {//错误返回true
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 32 || str.charAt(i) > 126)
			{
				System.out.println((int)str.charAt(i));
				return true;
			}
		}
		return false;
	}
}
