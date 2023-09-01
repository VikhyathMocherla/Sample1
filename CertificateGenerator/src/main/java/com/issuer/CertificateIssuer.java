package com.issuer;

public class CertificateIssuer {

	private String COMMON_NAME; 
	private String ORGANIZATION;
	private String ORGANIZATIONAL_UNIT;
	private String COUNTRY; 
	private String LOCALITY; 
	private String STATE; 
	private String E_MAIL_ADDRESS;
	
	public String getCOMMON_NAME() {
		return COMMON_NAME;
	}
	public void setCOMMON_NAME(String cOMMON_NAME) {
		COMMON_NAME = cOMMON_NAME;
	}
	public String getORGANIZATION() {
		return ORGANIZATION;
	}
	public void setORGANIZATION(String oRGANIZATION) {
		ORGANIZATION = oRGANIZATION;
	}
	public String getORGANIZATIONAL_UNIT() {
		return ORGANIZATIONAL_UNIT;
	}
	public void setORGANIZATIONAL_UNIT(String oRGANIZATIONAL_UNIT) {
		ORGANIZATIONAL_UNIT = oRGANIZATIONAL_UNIT;
	}
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	public String getLOCALITY() {
		return LOCALITY;
	}
	public void setLOCALITY(String lOCALITY) {
		LOCALITY = lOCALITY;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getE_MAIL_ADDRESS() {
		return E_MAIL_ADDRESS;
	}
	public void setE_MAIL_ADDRESS(String e_MAIL_ADDRESS) {
		E_MAIL_ADDRESS = e_MAIL_ADDRESS;
	}
	public CertificateIssuer(String cOMMON_NAME, String oRGANIZATION, String oRGANIZATIONAL_UNIT, String cOUNTRY,
			String lOCALITY, String sTATE, String e_MAIL_ADDRESS) {
		super();
		COMMON_NAME = cOMMON_NAME;
		ORGANIZATION = oRGANIZATION;
		ORGANIZATIONAL_UNIT = oRGANIZATIONAL_UNIT;
		COUNTRY = cOUNTRY;
		LOCALITY = lOCALITY;
		STATE = sTATE;
		E_MAIL_ADDRESS = e_MAIL_ADDRESS;
	}
	public CertificateIssuer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CertificateIssuer [COMMON_NAME=" + COMMON_NAME + ", ORGANIZATION=" + ORGANIZATION
				+ ", ORGANIZATIONAL_UNIT=" + ORGANIZATIONAL_UNIT + ", COUNTRY=" + COUNTRY + ", LOCALITY=" + LOCALITY
				+ ", STATE=" + STATE + ", E_MAIL_ADDRESS=" + E_MAIL_ADDRESS + "]";
	}
	
	
}
