package com.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;

/**
 * 转换字符串的编码
 */
public class ConverStr {

 
	public static void main(String[] args) throws UnsupportedEncodingException {
		/*ConverStr test = new ConverStr();
		 //"%B1%B1%BE%A9%B6%A6%CC%A9%D6%C7%D4%B4%BF%C6%BC%BC%D3%D0%CF%DE%B9%AB%CB%BE"; 
	 */
		/*String str ="空气化工产品(陕西)有限公司";
		String s = java.net.URLEncoder.encode(str,"gb2312");
		System.out.println(s);*/
		String str ="包头市欧宏商贸有限公 ";
		System.out.println(ConverStr.toEncodewhitCode(str,ConverStr.UTF_8));
		//System.out.println(URLDecoder.decode("http://wenshu.court.gov.cn/List/List?sorttype=1&conditions=searchWord+++2016-03-10+TO+2016-03-11+上传日期:2016-03-10+TO+2016-03-11&conditions=searchWord++法院名称+滦县人民法院+法院名称:滦县人民法院",ConverStr.UTF_8).replace(" ", "+"));
	}
	static public String filterOffUtf8Mb4(String text) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes("utf-8");
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        int i = 0;
        while (i < bytes.length) {
            short b = bytes[i];
            if (b > 0) {
                buffer.put(bytes[i++]);
                continue;
            }
            b += 256;
            if ((b ^ 0xC0) >> 4 == 0) {
                buffer.put(bytes, i, 2);
                i += 2;
            }
            else if ((b ^ 0xE0) >> 4 == 0) {
                buffer.put(bytes, i, 3);
                i += 3;
            }
            else if ((b ^ 0xF0) >> 4 == 0) {
                i += 4;
            }
        }
        buffer.flip();
        return new String(buffer.array(), "utf-8");
    }
	public static String encodeStr(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String encodeStrGbk(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String encodeStrwithgb2312(String str) {
		try {
			return new String(str.getBytes("GB2312"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String encodeAjax(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String toEncodewhitCode(String s,String code){
		 String result=s;
		 try {
			 result= URLEncoder.encode(s, code);
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		 return result;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static String toUtf8String(String s) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = String.valueOf(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		// System.out.println(sb.toString());
		return sb.toString();
	}

	// �?E4%BD%A0转换为汉�?
	public static String unescape(String s) {
		StringBuffer sbuf = new StringBuffer();
		int l = s.length();
		int ch = -1;
		int b, sumb = 0;
		for (int i = 0, more = -1; i < l; i++) {
			/* Get next byte b from URL segment s */
			switch (ch = s.charAt(i)) {
			case '%':
				ch = s.charAt(++i);
				int hb = (Character.isDigit((char) ch) ? ch - '0'
						: 10 + Character.toLowerCase((char) ch) - 'a') & 0xF;
				ch = s.charAt(++i);
				int lb = (Character.isDigit((char) ch) ? ch - '0'
						: 10 + Character.toLowerCase((char) ch) - 'a') & 0xF;
				b = (hb << 4) | lb;
				break;
			case '+':
				b = ' ';
				break;
			default:
				b = ch;
			}
			/* Decode byte b as UTF-8, sumb collects incomplete chars */
			if ((b & 0xc0) == 0x80) { // 10xxxxxx (continuation byte)
				sumb = (sumb << 6) | (b & 0x3f); // Add 6 bits to sumb
				if (--more == 0)
					sbuf.append((char) sumb); // Add char to sbuf
			} else if ((b & 0x80) == 0x00) { // 0xxxxxxx (yields 7 bits)
				sbuf.append((char) b); // Store in sbuf
			} else if ((b & 0xe0) == 0xc0) { // 110xxxxx (yields 5 bits)
				sumb = b & 0x1f;
				more = 1; // Expect 1 more byte
			} else if ((b & 0xf0) == 0xe0) { // 1110xxxx (yields 4 bits)
				sumb = b & 0x0f;
				more = 2; // Expect 2 more bytes
			} else if ((b & 0xf8) == 0xf0) { // 11110xxx (yields 3 bits)
				sumb = b & 0x07;
				more = 3; // Expect 3 more bytes
			} else if ((b & 0xfc) == 0xf8) { // 111110xx (yields 2 bits)
				sumb = b & 0x03;
				more = 4; // Expect 4 more bytes
			} else /* if ((b & 0xfe) == 0xfc) */{ // 1111110x (yields 1 bit)
				sumb = b & 0x01;
				more = 5; // Expect 5 more bytes
			}
			/* We don't test if the UTF-8 encoding is well-formed */
		}
		return sbuf.toString();
	}

	/** 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁�?*/
	public static final String US_ASCII = "US-ASCII";

	/** ISO 拉丁字母�?No.1，也叫作 ISO-LATIN-1 */
	public static final String ISO_8859_1 = "ISO-8859-1";

	/** 8 �?UCS 转换格式 */
	public static final String UTF_8 = "UTF-8";

	/** 16 �?UCS 转换格式，Big Endian（最低地�?��放高位字节）字节顺序 */
	public static final String UTF_16BE = "UTF-16BE";

	/** 16 �?UCS 转换格式，Little-endian（最高地�?��放低位字节）字节顺序 */
	public static final String UTF_16LE = "UTF-16LE";

	/** 16 �?UCS 转换格式，字节顺序由可�?的字节顺序标记来标识 */
	public static final String UTF_16 = "UTF-16";

	/** 中文超大字符�?*/
	public static final String GBK = "GBK";

	/** GB2312 */
	public static final String GB2312 = "GB2312";

	/**
	 * 将字符编码转换成US-ASCII�?
	 */
	public String toASCII(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, US_ASCII);
	}

	/**
	 * 将字符编码转换成ISO-8859-1�?
	 */
	public String toISO_8859_1(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, ISO_8859_1);
	}

	/**
	 * 将字符编码转换成UTF-8�?
	 */
	public String toUTF_8(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_8);
	}

	/**
	 * 将字符编码转换成UTF-16BE�?
	 */
	public String toUTF_16BE(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16BE);
	}

	/**
	 * 将字符编码转换成UTF-16LE�?
	 */
	public String toUTF_16LE(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16LE);
	}

	/**
	 * 将字符编码转换成UTF-16�?
	 */
	public String toUTF_16(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16);
	}

	/**
	 * 将字符编码转换成GBK�?
	 */
	public String toGBK(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, GBK);
	}

	/**
	 * 字符串编码转换的实现方法
	 * 
	 * @param str
	 *            待转换编码的字符�?
	 * @param newCharset
	 *            目标编码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String changeCharset(String str, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			// 用默认字符编码解码字符串�?
			byte[] bs = str.getBytes();
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}

	/**
	 * 字符串编码转换的实现方法
	 * 
	 * @param str
	 *            待转换编码的字符�?
	 * @param oldCharset
	 *            原编�?
	 * @param newCharset
	 *            目标编码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String changeCharset(String str, String oldCharset, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			// 用旧的字符编码解码字符串。解码可能会出现异常�?
			byte[] bs = str.getBytes(oldCharset);
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}

	/**
	 * 将字符串转成unicode
	 * 
	 * @param str
	 *            待转字符�?
	 * @return unicode字符�?
	 */
	public static String tounicode(String str) {
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			sb.append("\\u");
			j = (c >>> 8); // 取出�?�?
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
			j = (c & 0xFF); // 取出�?�?
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);

		}
		return (new String(sb));
	}

	/**
	 * 将unicode 字符�?
	 * 
	 * @param str
	 *            待转字符�?
	 * @return 普�?字符�?
	 */
	public static String revert(String str) {
		str = (str == null ? "" : str);
		if (str.indexOf("\\u") == -1)// 如果不是unicode码则原样返回
			return str;

		StringBuffer sb = new StringBuffer(1000);

		for (int i = 0; i < str.length() - 4;) {
			String strTemp = str.substring(i, i + 6);
			String value = strTemp.substring(2);
			int c = 0;
			for (int j = 0; j < value.length(); j++) {
				char tempChar = value.charAt(j);
				int t = 0;
				switch (tempChar) {
				case 'a':
					t = 10;
					break;
				case 'b':
					t = 11;
					break;
				case 'c':
					t = 12;
					break;
				case 'd':
					t = 13;
					break;
				case 'e':
					t = 14;
					break;
				case 'f':
					t = 15;
					break;
				default:
					t = tempChar - 48;
					break;
				}

				c += t * ((int) Math.pow(16, (value.length() - j - 1)));
			}
			sb.append((char) c);
			i = i + 6;
		}
		return sb.toString();
	}
}
