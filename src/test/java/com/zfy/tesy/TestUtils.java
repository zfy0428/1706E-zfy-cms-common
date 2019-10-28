package com.zfy.tesy;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import Utils.StringUtils;

public class TestUtils {
	
	@Test
	public void testUnitrem() throws UnsupportedEncodingException{
		String s = " aaaaaaaBBBBBBBBBB ";
		String term = StringUtils.toUniqueTerm(s);
		System.out.println(term);
	}

}
