package org.dw.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyStringUtils {
	public static String replaceBlank(String str)
	{
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);
		str = m.replaceAll("");
		return str;
	}
}
