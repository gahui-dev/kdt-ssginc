package com.jsp.util;

import javax.servlet.http.HttpSession;

public interface AuthentificationUtil {
	public static final String SESS_USER_AUTH = "SESS_USER_AUTH";
	public static final String SESS_USER_NAME = "SESS_USER_NAME";
	public static final String SESS_USER_ID = "SESS_USER_ID";
	public static final String SESS_MSG = "SESS_MSG";
	public static final String SESS_MSG_SUCCESS = "환영합니다. %s 님";
	public static final String SESS_MSG_FAIL = "인증된 사용자가 아닙니다.";

	public static boolean verifyAuthentification(HttpSession session) {
		boolean result = false;

		// NULL일 경우 예외 처리 필요
		try {
			if ((boolean) session.getAttribute(SESS_USER_AUTH)) {
				result = true;
				session.setAttribute(SESS_MSG, SESS_MSG_SUCCESS);
			} else {
				throw new NullPointerException();
			}
		} catch (NullPointerException npe) {
			session.setAttribute(SESS_USER_AUTH, false);
			session.setAttribute(SESS_MSG, SESS_MSG_FAIL);
		}

		return result;

	}

	public static void removeAuthentification(HttpSession session) {
		session.removeAttribute(AuthentificationUtil.SESS_USER_NAME);
		session.removeAttribute(AuthentificationUtil.SESS_USER_ID);
		session.removeAttribute(AuthentificationUtil.SESS_USER_AUTH);
		session.removeAttribute(AuthentificationUtil.SESS_MSG);
	}
}
