package com.converter;

import org.springframework.core.convert.converter.Converter;

public class TrimConverter implements Converter<String, String> {

	@Override
	public String convert(String source) {
		try {
			if (null != source) {
				source = source.trim();
				if (!"".equals(source)) {
					return source;
				}
			}
		} catch (Exception e) {
			System.out.println("TrimConverter出错。");
		}
		return null;
	}

}
