package Utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Utils {
	
	/**
	 * ����
	 */
	private static String  saltString = "mmcro";
	
	/**
	 * ��������м���
	 * @param pwd
	 * @return
	 */
	public static String md5(String pwd) {
		//��������м���
		return DigestUtils.md5Hex( pwd + saltString);
	}
	
	/**
	 * 
	 * @param pwd
	 * @param salt
	 * @return
	 */
	public static String md5(String pwd,String salt) {
		//��������м���
		return DigestUtils.md5Hex( pwd + salt);
	}
}