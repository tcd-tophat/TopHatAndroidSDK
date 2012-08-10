package org.tophat.android;

public class Constants {
	/**
	 * This is the id of the data stream.
	 */
	private int DATA_STREAM;
	
	/**
	 * This is the reconnection delay to the server in milliseconds.
	 */
	private int RECONNECTION_DELAY;
	
	/**
	 * 
	 */
	private String FACEBOOK_APP_ID;
	
	private String USER_AGENT;
	
	private String APP_VERSION;
	
	/**
	 * The API URL requires a trailing slash
	 */
	private String API_URL;
	
	/**
	 * @return the dATA_STREAM
	 */
	public int getDATA_STREAM() {
		return DATA_STREAM;
	}

	/**
	 * @param dATA_STREAM the dATA_STREAM to set
	 */
	public void setDATA_STREAM(int dataStream) {
		DATA_STREAM = dataStream;
	}

	/**
	 * @return the rECONNECTION_DELAY
	 */
	public int getRECONNECTION_DELAY() {
		return RECONNECTION_DELAY;
	}

	/**
	 * @param rECONNECTION_DELAY the rECONNECTION_DELAY to set
	 */
	public void setRECONNECTION_DELAY(int reconDelay) {
		RECONNECTION_DELAY = reconDelay;
	}

	/**
	 * @return the fACEBOOK_APP_ID
	 */
	public String getFACEBOOK_APP_ID() {
		return FACEBOOK_APP_ID;
	}

	/**
	 * @param fACEBOOK_APP_ID the fACEBOOK_APP_ID to set
	 */
	public void setFACEBOOK_APP_ID(String fbId) {
		FACEBOOK_APP_ID = fbId;
	}

	/**
	 * @return the uSER_AGENT
	 */
	public String getUSER_AGENT() {
		return USER_AGENT;
	}

	/**
	 * @param uSER_AGENT the uSER_AGENT to set
	 */
	public void setUSER_AGENT(String userAgent) {
		USER_AGENT = userAgent;
	}

	/**
	 * @return the aPP_VERSION
	 */
	public String getAPP_VERSION() {
		return APP_VERSION;
	}

	/**
	 * @param aPP_VERSION the aPP_VERSION to set
	 */
	public void setAPP_VERSION(String appVersion) {
		APP_VERSION = appVersion;
	}

	/**
	 * @return the aPI_URL
	 */
	public String getAPI_URL() {
		return API_URL;
	}

	/**
	 * @param aPI_URL the aPI_URL to set
	 */
	public void setAPI_URL(String apiUrl) {
		API_URL = apiUrl;
	}

	/**
	 * @return the sIGNIN_ACTIVITY
	 */
	public int getSIGNIN_ACTIVITY() {
		return SIGNIN_ACTIVITY;
	}

	/**
	 * @param sIGNIN_ACTIVITY the sIGNIN_ACTIVITY to set
	 */
	public void setSIGNIN_ACTIVITY(int signAct) {
		SIGNIN_ACTIVITY = signAct;
	}

	/**
	 * @return the mENU_ACTIVITY
	 */
	public int getMENU_ACTIVITY() {
		return MENU_ACTIVITY;
	}

	/**
	 * @param mENU_ACTIVITY the mENU_ACTIVITY to set
	 */
	public void setMENU_ACTIVITY(int menuAct) {
		MENU_ACTIVITY = menuAct;
	}

	/**
	 * @return the tRUST_UNSIGNED_SSL_CERTS
	 */
	public boolean isTRUST_UNSIGNED_SSL_CERTS() {
		return TRUST_UNSIGNED_SSL_CERTS;
	}

	/**
	 * @param tRUST_UNSIGNED_SSL_CERTS the tRUST_UNSIGNED_SSL_CERTS to set
	 */
	public void setTRUST_UNSIGNED_SSL_CERTS(boolean trust) {
		TRUST_UNSIGNED_SSL_CERTS = trust;
	}

	private int SIGNIN_ACTIVITY;
	
	private int MENU_ACTIVITY;

	private boolean TRUST_UNSIGNED_SSL_CERTS;
}
