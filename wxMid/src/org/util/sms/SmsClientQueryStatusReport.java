package org.util.sms;

import java.net.URLEncoder;


/**
 * <p>
 * <date>2012-03-01</date><br/>
 * <span>软维提供的JAVA接口信息（短信，彩信）调用API</span><br/>
 * <span>----------查询状�?�报�?--只允许查取一�?-------------</span>
 * </p>
 *
 * @author LIP
 * @version 1.0.1
 */
public class SmsClientQueryStatusReport {

	/**
	 * <p>
	 * <date>2012-03-01</date><br/>
	 * <span>状�?�报告获取方�?1--必须传入必填内容</span><br/>
	 * <p>
	 * 其一：发送方式，默认为POST<br/>
	 * 其二：发送内容编码方式，默认为UTF-8
	 * </p>
	 * <br/>
	 * </p>
	 * 
	 * @param url
	 *            ：必�?--发�?�连接地�?URL--比如>http://118.145.30.35/statusApi.aspx
	 * @param userid
	 *            ：必�?--用户ID，为数字
	 * @param account
	 *            ：必�?--用户帐号
	 * @param password
	 *            ：必�?--用户密码
	 * @return 返回状�?�报�?
	 */
	public static String queryStatusReport(String url, String userid,
			String account, String password) {

		try {
			StringBuffer sendParam = new StringBuffer();
			sendParam.append("action=query");
			sendParam.append("&userid=").append(userid);
			sendParam.append("&account=").append(
					URLEncoder.encode(account, "UTF-8"));
			sendParam.append("&password=").append(
					URLEncoder.encode(password, "UTF-8"));

			return SmsClientAccessTool.getInstance().doAccessHTTPPost(url,
					sendParam.toString(), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "未发送，异常-->" + e.getMessage();
		}
	}
}
