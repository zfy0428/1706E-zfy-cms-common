package Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.NumberFormat;
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
	 * @param str
	 * @return  
	 */
	public static  boolean isEmpty(String str) {
		
		return (null==str||"".equals(str.trim()));
	}
	
	
	/**
	 * �Ƿ���ֵ
	�ж�Դ�ַ����Ƿ���ֵ�������źͿո�Ҳ��ûֵ
	 * @param str
	 * @return
	 */
	public static boolean hasText1(String str) {
		
		// ��������д������
		//return !(null ==str || "".equals(str.trim()));
		return (null !=str && !"".equals(str.trim()));
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str) {
		String pattern = "^(136|135|137)\\d{8}$";
		return str.matches(pattern);
	}
	
	/**
	 *  
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		
		String pattern = "^\\w+@\\w+\\.[a-zA-Z]{2,3}$";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(str);
		return matcher.matches();
	}
	
	/**
	 * ��֤ȫΪ��ĸ
	 * @param str
	 * @return
	 */
	public static boolean isLetter(String str) {
		String pattern = "^[a-zA-Z]+$";
		return str.matches(pattern);
	}
	
	/**
	 * 
	 * ��ȡnλ���Ӣ���ַ���
	 * @param n
	 * @return
	 */
	public String randomLetterStr(int n) {
		
		if(n<=0)
			return "";
		Random random = new Random();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			char letter = (char)('A' + random.nextInt(26));
			sb.append(letter);
		}		
		return sb.toString();
	}
	
	/**
	 * ��ȡnλ���Ӣ�ĺ������ַ���
	 * @param n
	 * @return
	 */
	public String randomStr(int n) {
		
		char chars[]= {'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N'};
		
		// ������������
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			// ����õ�һ���±꣬�����±�����鵱�л�ȡֵ��ƴ�ӵ��ַ�����
			
			// �����ȡһ���±�
			int index = random.nextInt(chars.length);
			char c = chars[index];
			sb.append(c);//���ƴ��
			
			/*sb.append( chars[random.nextInt(chars.length)]
					);*/
			
		}
		return sb.toString();
		
	}
	
	//��ȡn����������ַ���
	public static String getRandonCnStr(int n) {
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(getOneCn());
		}
		return sb.toString();
		
	} 
	
	/**
	 * �����ȡһ�������ַ�
	 * @return
	 */
	private static String getOneCn(){
		
		String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("����");
        }

        return str;
	}
	
	/*
	* �������ܣ������������ַ�����ȡһ��ֵ�����ں�����url��ַ����ȡIDֵ��
	* �����ڡ�http://news.cnstock.com/news,yw-201908-4413224.htm���ѡ�4413224����ȡ������
	*/
	public static String getPlaceholderValue(String src, String regex){
		//TODO ʵ�ִ���
        Pattern pattern = Pattern.compile(regex);// ƥ���ģʽ  
        Matcher m = pattern.matcher(src);  
        boolean find = m.find();
        if(find) {
        	String group = m.group(0);
        	 return group.substring(1,group.lastIndexOf('.'));
        }
        return "";
	}
	
	//���Թ��߰���isNumber()��
	/**
	 * 
	 * @param src
	 * @return
	 */
	public static boolean isNumber(String src) {
		//String regix="[0-9]{1,}(\\.?|[0-9]*)";
		String regix="[0-9]{1,}\\.?[0-9]*";
		return src.matches(regix);
		
		
	}
	
	public static boolean isUrl(String str) {
		 //ת��ΪСд
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https��http��ftp��rtsp��mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp��user@  
               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP��ʽ��URL- ���磺199.194.52.184  
                 + "|" // ����IP��DOMAIN��������
                 + "([0-9a-z_!~*'()-]+\\.)*" // ����- www.  
                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // ��������  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // �˿ں����Ϊ65535,5λ��
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        return  str.matches(regex);
	}
	
	/**
	 * ���Թ��߰���hasText()���÷����ǹ���String�����ո���ж��Ƿ���ֵ��
	 * ������иù��ܷ�����������������������۷֡����û�и÷������������ڱ�д�÷���
	 * @param src
	 * @return
	 */
	public static boolean hasText(String src) {
		String string = src.replaceAll("\\s", "");
		return (!"".equals(string));
	}
	
	/*
	* ����������Ψһ��ǩ���������裺
	* 1��ȫ�����Сд��
	* 2��������ߵĿո񣬰��м����еĿո��滻�ɡ�-����
	* 3��ʹ��URLEncoder.encode()����
	* ��󷵻ش���Ľ����
	* ������Spring MVC�������Ϊ��spring-mvc������Spring Mvc�������ҲΪ��spring-mvc��
	*/
	public static String toUniqueTerm(String term) throws UnsupportedEncodingException{
	//TODO ʵ�ִ���
		term=term.toLowerCase();	// 1��ȫ�����Сд��
		term=term.trim();//������ߵĿո�
		term = term.replaceAll(" ", "-");//���м����еĿո��滻�ɡ�-����
		return URLEncoder.encode(term,"UTF-8");//��ʹ��URLEncoder.encode()����
		
	}
	
	
	/*�������ܣ����ַ���ת����html�ı������������\n�����л�������Ҫ����һ���ı�ʹ��<p></p>��ǩ
	 * @ContextConfiguration("classpath:spring.xml")
	*@RunWith(SpringRunner.class)
	* �����������������\n\r��������һ������\n�������ֻ����һ����\r�����滻��<br/>��ǩ��
	* ʹ�ó�������ҳ�ı��򴫵���̨���ַ����Ϳ��ܾͻ�س����С�*/
	public static String toHtml1(String src){
		String[] strings = src.split("\\\n");
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			sb.append("<p>").append(string).append("</p>");
		}
		return sb.toString();
	}
	
	
	/**
	 * ��⺬��\n\r ת����\n
	 * \r ת��<br>
	 * @param str
	 * @return
	 */
	public static String toHtml(String str) {
		String replaceAll = str.replaceAll("\\\n\r", "\n");
		String replaceAll2 = replaceAll.replaceAll("\\\r", "<br/>");
		/* System.out.println(replaceAll2); */
		String[] split = replaceAll2.split("\\\n");
		StringBuilder sb = new StringBuilder();
		for (String string : split) {
			sb.append("<p>").append(string).append("</p>\n");
		}
		return sb.toString();	
	}
	
}

