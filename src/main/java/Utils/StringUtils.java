package Utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author zhuzg
 *
 */
public class StringUtils {
	/**
	 * 
	 */
	public static char cs[] = new char[36] ;
	// 初始化数组
	static {
		int index=0;
		for (char i = 'a'; i <='z' ; i++) {
			cs[(int)index ++]=i;
		}

		for (char i = '0'; i <='9' ; i++) {
			cs[(int)index ++]=i;
		}

	}





	public static void main(String[] args) {
		String str = randomChar(10);
		System.out.println("10个随机的字符是 " + str);


		String s = StringUtils.randomCharAndNumber(20);
		System.out.println("s is " + s);

		System.out.println("扩展名是："  + StringUtils.getFileSuffix("朱志广-1706E-补课计划.xlsx"));

		System.out.println(" reg 234 " + StringUtils.isNumber("234") );

		System.out.println(" reg 2a34 " + StringUtils.isNumber("2a34") );
		System.out.println(" reg kong  " + StringUtils.isNumber("") );


		System.out.println(" is email  ? zhuzh@qq.com " + StringUtils.isEmail("zhuzh@qq.com"));
		System.out.println(" is email ? zhuzg@qq.c1n  " + StringUtils.isEmail("zhuzg@qq.c1n") );

		System.out.println(" type2 is email  ? zhuzh@qq.com " + StringUtils.isEmail2("zhuzh@qq.com"));
		System.out.println(" type2   email ? zhuzg@qq.c1n  " + StringUtils.isEmail2("zhuzg@qq.c1n") );



	}



	/**
	 * 判断源字符串是否为空，空引号也算没值；
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {

		//return (str==null|| "".equals(str.trim()));
		return (str==null || 0== str.trim().length());
	}

	/**
	 * 判断源字符串是否有值，空引号也算没值；
	 * @param str
	 * @return
	 */
	public static boolean hasText(String str) {
		//return !(str==null || 0== str.trim().length());
		return str!=null && 0 < str.trim().length();   

	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public static String randomChar(int n) {
		Random random = new Random();
		String str = "";
		for (int i = 0; i < n; i++) {
			char c = (char)('a' + 	random.nextInt(26));// a - z
			str += c;
		}
		return str;

	}

	/**
	 * 随机生成长度为n的字符串，其中包含字母和数字
	 * @param n
	 * @return
	 */
	public static String randomCharAndNumber(int n) {

		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < n; i++) {
			sb.append(cs[random.nextInt(36)]);
		}
		return sb.toString();

	}

	/**
	 * 获取一个文件名称的扩展名
	 * 例如： mytest/mynewFile.txt return .txt
	 * @param fileName
	 * @return
	 */
	public static String getFileSuffix(String fileName) {

		//return ".txt";
		int dotIndex = fileName.lastIndexOf('.');
		if(dotIndex==-1)
			return "";

		return fileName.substring(fileName.lastIndexOf('.'));

	}

	/**
	 * 判断是否为字符串
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {

		String reg = "[0-9]+";
		return str.matches(reg);
	}

	/**
	 * 验证代码
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		String reg = "^[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[a-z]{2,3}";
		return str.matches(reg);

	}

	public static boolean isEmail2(String str) {

		String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"; 
		Pattern p = Pattern.compile(regEx1);
		Matcher m = p.matcher(str);
		return m.find();

	}

	/**
	 * 校验一个字符串是否为正确的电话号码
	 * @param mobile
	 * @return
	 */
	public  static boolean isMobile(String mobile) {

		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		boolean isMatch = m.matches();
		return isMatch;
	}


	/**
	 * (1)利用Html的<p>标签来保留文本的换行。
(2)Windows系统换行符是“\r\n”,Linux系统是“\n”，因此要将\n\r替换成一个\n。
(3)再将\n结尾的这行文本用<p></p>标签包起来。 张三\n李四      <p>张三</p><p>李四</p>
(4)如果遇到单个\r字符要使用<br/>标签替换。
	 * @param src
	 * @return
	 */
	public static String toHtml(String src) {
		//Windows系统换行符是“\r\n”,Linux系统是“\n”，因此要将\n\r替换成一个\n。
		String dst = src.replaceAll("\r\n", "\n");

		//再将\n结尾的这行文本用<p></p>标签包起来。 张三\n李四      <p>张三</p><p>李四</p>
		dst=dst.replaceAll("\n", "</p><p>");
		dst="<p>" + dst + "</p>";
		//如果遇到单个\r字符要使用<br/>标签替换。
		dst=dst.replaceAll("\r", "<br/>");
		return dst;
	}





}
