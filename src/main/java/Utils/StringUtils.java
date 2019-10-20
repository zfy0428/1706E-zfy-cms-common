package Utils;

import java.io.UnsupportedEncodingException;
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
	 */
	public static char cs[] = new char[36] ;
	// ��ʼ������
	static {
		int index=0;
		for (char i = 'a'; i <='z' ; i++) {
			cs[(int)index ++]=i;
		}
		
		for (char i = '0'; i <='9' ; i++) {
			cs[(int)index ++]=i;
		}
		
	}
	
	
	
	/**
	 * �ٷֱȼ���
	 * @Title: percent 
	 * @Description: TODO
	 * @param num
	 * @param total
	 * @return
	 * @return: String
	 */
	public static String percent(Integer num,Integer total ) {
		// ����һ����ֵ��ʽ������   
		NumberFormat numberFormat = NumberFormat.getInstance(); 
		// ���þ�ȷ��С�����0λ   
		numberFormat.setMaximumFractionDigits(0); 
		String result = numberFormat.format((float)num/(float)total*100);
		return result;
	}
	
	public static void main(String[] args) {
		/*String str = randomChar(10);
		System.out.println("10��������ַ��� " + str);
		
		
		String s = StringUtils.randomCharAndNumber(20);
		System.out.println("s is " + s);
		
		System.out.println("��չ���ǣ�"  + StringUtils.getFileSuffix("��־��-1706E-���μƻ�.xlsx"));
		
		System.out.println(" reg 234 " + StringUtils.isNumber("234") );

		System.out.println(" reg 2a34 " + StringUtils.isNumber("2a34") );
		System.out.println(" reg kong  " + StringUtils.isNumber("") );
		
		
		System.out.println(" is email  ? zhuzh@qq.com " + StringUtils.isEmail("zhuzh@qq.com"));
		System.out.println(" is email ? zhuzg@qq.c1n  " + StringUtils.isEmail("zhuzg@qq.c1n") );
		
		System.out.println(" type2 is email  ? zhuzh@qq.com " + StringUtils.isEmail2("zhuzh@qq.com"));
		System.out.println(" type2   email ? zhuzg@qq.c1n  " + StringUtils.isEmail2("zhuzg@qq.c1n") );
		*/
		
		String str = "����\r\n����";
		String dst = toHtml(str);
		System.out.println("dst is " + dst);
		
		
		
	}
	
	
	
	/**
	 * �ж�Դ�ַ����Ƿ�Ϊ�գ�������Ҳ��ûֵ��
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		
		//return (str==null|| "".equals(str.trim()));
		return (str==null || 0== str.trim().length());
	}
	
	/**
	 * �ж�Դ�ַ����Ƿ���ֵ��������Ҳ��ûֵ��
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
	 * ������ɳ���Ϊn���ַ��������а�����ĸ������
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
	 * ��ȡһ���ļ����Ƶ���չ��
	 * ���磺 mytest/mynewFile.txt return .txt
	 * @param fileName
	 * @return
	 */
	public static String getFileSuffix(String fileName) {
		
		//return ".txt";
		int dotIndex = fileName.lastIndexOf('.');
		if(dotIndex==-1)
			return "";
		
		return fileName.substring(fileName.lastIndexOf('.')-1);
		
	}
	
	/**
	 * �ж��Ƿ�Ϊ�ַ���
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		
		String reg = "[0-9]+";
		return str.matches(reg);
	}
	
	/**
	 * ��֤����
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
	 * У��һ���ַ����Ƿ�Ϊ��ȷ�ĵ绰����
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
	 * (1)����Html��<p>��ǩ�������ı��Ļ��С�
(2)Windowsϵͳ���з��ǡ�\r\n��,Linuxϵͳ�ǡ�\n�������Ҫ��\n\r�滻��һ��\n��
(3)�ٽ�\n��β�������ı���<p></p>��ǩ�������� ����\n����      <p>����</p><p>����</p>
(4)�����������\r�ַ�Ҫʹ��<br/>��ǩ�滻��
	 * @param src
	 * @return
	 */
	public static String toHtml(String src) {
		//Windowsϵͳ���з��ǡ�\r\n��,Linuxϵͳ�ǡ�\n�������Ҫ��\n\r�滻��һ��\n��
		String dst = src.replaceAll("\r\n", "\n");
		
		//�ٽ�\n��β�������ı���<p></p>��ǩ�������� ����\n����      <p>����</p><p>����</p>
		dst=dst.replaceAll("\n", "</p><p>");
		dst="<p>" + dst + "</p>";
		//�����������\r�ַ�Ҫʹ��<br/>��ǩ�滻��
		dst=dst.replaceAll("\r", "<br/>");
		return dst;
	}
	
	
	// ����һ����������//GB2312���ļ���
		public static String randomChineseString() {
			String str = null;
			int highPos, lowPos;
			Random random = new Random();
			highPos = (176 + Math.abs(random.nextInt(39)));// ���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������
			random = new Random();
			lowPos = 161 + Math.abs(random.nextInt(94));// λ�룬0xA0��ͷ����Χ��1~94��
			byte[] bArr = new byte[2];
			bArr[0] = (new Integer(highPos)).byteValue();
			bArr[1] = (new Integer(lowPos)).byteValue();
			try {
				str = new String(bArr, "GB2312"); // ��λ����ϳɺ���
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return str;

		}

		// ����3�����ز���length�����ĺ����ַ������ַ���������GB2312(�൱�����ļ���)��Χ�ڣ����硰��ѽ����(5��)
		public static String randomChineseString(int length) {
			String str = "";
			for (int i = 0; i < length; i++) {
				str += randomChineseString();
			}

			return str;
		}

		// ����4������������������������ʵ�տ�ͷ���ټ����ڡ��������ټ��ա����ʹ��1-2���������(8��)���ڲ�����randomChineseString()����(3��)������ʾ��������ѽ��������ŷ����Ϊ��
		public static String generateChineseName() {

			String[] surname = { "��", "Ǯ", "��", "��", "��", "��", "֣", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "ʩ", "��", "��", "��", "��", "��", "��", "κ", "��", "��", "��", "л", "��", "��", "��", "ˮ", "�",
					"��", "��", "��", "��", "��", "��", "��", "��", "��", "³", "Τ", "��", "��", "��", "��", "��", "��", "��", "��", "Ԭ", "��",
					"ۺ", "��", "ʷ", "��", "��", "��", "�", "Ѧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "ʱ", "��", "Ƥ", "��", "��", "��", "��", "��", "Ԫ", "��", "��", "��", "ƽ", "��", "��", "��", "��", "��", "Ҧ", "��",
					"տ", "��", "��", "ë", "��", "��", "��", "��", "��", "�", "��", "��", "��", "��", "̸", "��", "é", "��", "��", "��", "��",
					"��", "��", "ף", "��", "��", "��", "��", "��", "��", "ϯ", "��", "��", "ǿ", "��", "·", "¦", "Σ", "��", "ͯ", "��", "��",
					"÷", "ʢ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "֧", "��", "��",
					"��", "¬", "Ī", "��", "��", "��", "��", "��", "��", "Ӧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "ʯ", "��", "��", "ť", "��", "��", "��", "��", "��", "��", "½", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɽ", "��",
					"��", "��", "�", "��", "ȫ", "ۭ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "ղ", "��", "��", "Ҷ", "��", "˾", "��", "۬", "��", "��", "��", "ӡ", "��", "��", "��", "��", "ۢ",
					"��", "��", "��", "��", "��", "��", "׿", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "˫", "��", "ݷ", "��",
					"��", "̷", "��", "��", "��", "��", "��", "��", "��", "Ƚ", "��", "۪", "Ӻ", "ȴ", "�", "ɣ", "��", "�", "ţ", "��", "ͨ",
					"��", "��", "��", "��", "��", "��", "ũ", "��", "��", "ׯ", "��", "��", "��", "��", "��", "Ľ", "��", "��", "ϰ", "��", "��",
					"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "»", "��", "��", "ŷ", "�", "��", "��", "ε", "Խ", "��", "¡", "ʦ", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɳ", "ؿ", "��", "��", "��", "��", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "ۣ", "��", "Ȩ", "��", "��", "��", "��", "��", "��", "��", "��", "˧", "��", "��", "��", "�C", "��",
					"��", "��", "��", "��", "��", "��", "��", "��", "۳", "Ϳ", "��", "��", "Ĳ", "��", "٦", "��", "��", "ī", "��", "��", "��",
					"��", "��", "��", "١", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "չ", "��", "̴", "��", "��", "��", "��",
					"˴", "¥", "��", "ð", "��", "ֿ", "��", "��", "��", "��", "ԭ", "��", "��", "��", "��", "��", "�", "��", "��", "��", "�",
					"��", "��", "��", "��", "��", "��", "��", "ľ", "��", "��", "ۨ", "��", "ö", "��", "��", "�", "��", "��", "��", "��", "��",
					"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "�G", "��ٹ", "˾��", "�Ϲ�", "ŷ��",
					"�ĺ�", "���", "����", "����", "����", "�ʸ�", "����", "ξ��", "����", "�̨", "��ұ", "����", "���", "����", "����", "̫��", "����",
					"����", "����", "��ԯ", "���", "����", "����", "����", "Ľ��", "����", "����", "˾ͽ", "˾��", "أ��", "˾��", "����", "����", "�ӳ�",
					"���", "��ľ", "����", "����", "���", "����", "����", "����", "�ذ�", "�й�", "�׸�", "����", "�θ�", "����", "����", "΢��", "����",
					"����", "����", "����", "�Ϲ�", "����", "����", "����", "̫ʷ", "�ٳ�", "����", "��ͻ", "����", "����", "����", "��ĸ", "˾��", "����",
					"Ӻ��", "����", "����", "����", "��®", "����", "�Ϲ�", "����", "����" };
			// �����ȡ����
			String name1 = surname[RandomUtil.random(0, surname.length - 1)];
			// �����ȡ1-2������
			String name2 = randomChineseString(RandomUtil.random(1, 2));
			return name1 + name2;
		}
	
	

}

