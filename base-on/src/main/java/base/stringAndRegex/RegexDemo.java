package base.stringAndRegex;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String中使用正则表达式验证当前字符串是否满足格式要求。
 * boolean matches(String regex)
 * 若当前字符串满足给定的正则表达式表示的格式，则返回true.
 *
 */
public class RegexDemo {
	public static void main(String[] args) {
		/*
		 * 邮箱的正则表达式:
		 * 
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\.[a-zA-Z]+)+           
		 * 
		 */
		String str = "fan_cq@tarena.com.cn";
		/*
		 * "\\."在java中就表示 "\."
		 * "\." 在正则表达式中就表示一个 "."
		 */
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";
		
		boolean tf = str.matches(regex);
		System.out.println("是邮箱?"+tf);
	}

	@Test//将当前字符串中满足给定的正则表达式的部分替换为给定的字符串。
	public void testReplace() {
		String str = "gfd123avs546asda678fdg78dsf";
		/*
		 * 将数字部分替换为"#NUMBER#"
		 */
		str = str.replaceAll("[0-9]+", "#NUMBER#");
		System.out.println(str);
	}

	@Test//和谐用语
	public void test() {
		String regex = "(wqnmlgb|yssb|fgbnbb|cao|mb|djb)";
		String message = "wqnmlgb!你个djb!cao!";

		message = message.replaceAll(regex, "*****");
		System.out.println(message);
	}

	@Test
	public void testRegex(){
		StringBuffer context = new StringBuffer();
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><transferQryRsp><ret>000000</ret><memo>交易成功</memo><count>1</count><trans><fuTraceNo>450000886364</fuTraceNo><fuTraceDt>20190531</fuTraceDt><destMerchantCd>0002900F0345179</destMerchantCd><origSrcOrderNo>20190531095249229817</origSrcOrderNo><orgSrcOrderDt>20190531</orgSrcOrderDt><amt>100000</amt><txnSt>1</txnSt><srcModuleCd>API</srcModuleCd></trans><mac>fb08d5a87f58a3250a065e1ee858874c</mac></transferQryRsp>";

		String regex = "<trans>(.*?)</trans>";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(xml);
		//匹配的有多个

		int i = 0;
		while (m.find()) {
			context.append(m.group(i++));
		}

		System.out.println(context);
	}

	@Test
	public void testRegex2(){
		StringBuffer context = new StringBuffer();
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><transferQryRsp><ret>000000</ret><memo>交易成功</memo><count>3</count><trans><fuTraceNo>450000887015</fuTraceNo><fuTraceDt>20190531</fuTraceDt><destMerchantCd>0002900F0345179</destMerchantCd><origSrcOrderNo>20190531153132832962</origSrcOrderNo><orgSrcOrderDt>20190531</orgSrcOrderDt><amt>100000</amt><txnSt>1</txnSt><srcModuleCd>API</srcModuleCd></trans><trans><fuTraceNo>450000887014</fuTraceNo><fuTraceDt>20190531</fuTraceDt><destMerchantCd>0002900F0345179</destMerchantCd><origSrcOrderNo>20190531153101643988</origSrcOrderNo><orgSrcOrderDt>20190531</orgSrcOrderDt><amt>100000</amt><txnSt>1</txnSt><srcModuleCd>API</srcModuleCd></trans><trans><fuTraceNo>450000886364</fuTraceNo><fuTraceDt>20190531</fuTraceDt><destMerchantCd>0002900F0345179</destMerchantCd><origSrcOrderNo>20190531095249229817</origSrcOrderNo><orgSrcOrderDt>20190531</orgSrcOrderDt><amt>100000</amt><txnSt>1</txnSt><srcModuleCd>API</srcModuleCd></trans><mac>88c0ade1effa423c542cee5ce10fc537</mac></transferQryRsp>";

		String regex = "<trans>(.*?)</trans>";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(xml);
		//匹配的有多个

		while (m.find()) {
			String x = m.group();
			System.out.println(x);
			context.append(x);
		}

		System.out.println(context);
	}
}






