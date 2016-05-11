package org.pojo;

import java.util.Date;

/**
 * 网页授权信息
 *
 * @author liufeng
 * @date 2013-11-09
 */
public class WeixinOauth2Token {
	// 网页授权接口调用凭证
	private String accessToken;
	// 凭证有效时长
	private int expiresIn;
	// 用于刷新凭证
	private String refreshToken;
	// 用户标识
	private String openId;
	// 用户授权作用域
	private String scope;
        
        private String unionId;
        
        private Date getDate;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public Date getGetDate() {
        return getDate;
    }
}
