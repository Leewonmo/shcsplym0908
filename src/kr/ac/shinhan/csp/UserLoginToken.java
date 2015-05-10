package kr.ac.shinhan.csp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class UserLoginToken {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	
	private Long key; 

	@Persistent
	protected String token;

	@Persistent
	private String userAccount;

	@Persistent
	private String expireDate;


	@Persistent
	public boolean chk_info1;

	public boolean isChkinfo1() {
		return chk_info1;
	}

	public void setChk_info1(boolean chk_info1) {
		this.chk_info1 = chk_info1;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	
	public UserLoginToken(String token, String userAccount,String expireDate, String email, boolean chk_info1)
	{
		super();
		this.token = token;
		this.userAccount =userAccount;
		this.expireDate=expireDate;
		this.chk_info1=chk_info1;
	}


}
