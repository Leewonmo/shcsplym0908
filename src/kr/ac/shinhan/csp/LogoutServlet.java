package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp,
			Object Httpsession) throws IOException {

		HttpSession session = req.getSession();
		session.invalidate();

		
		Cookie[] cookieList = req.getCookies();

		for (Cookie cookie : cookieList)

		{

			if (cookie.getName().equals("logid"))

			{

				cookie.setValue(null);
				cookie.setMaxAge(0);
				resp.addCookie(cookie);

			}

		}

		resp.sendRedirect("/login.html");

	}

}