package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		HttpSession session = req.getSession();

		String id = req.getParameter("id");
		String password = req.getParameter("password");

		session.setAttribute("id", id);
		boolean check = false;
		boolean success = false;

		MyPersistenceManager.getManager();

		Query qry = MyPersistenceManager.getManager().newQuery(
				UserAccount.class);

		qry.setFilter("userID == idParam");
		qry.declareParameters("String idParam");

		List<UserAccount> userAccount = (List<UserAccount>) qry.execute(id);

		if (userAccount.size() == 0) {
			success = false;
		}

		else if (userAccount.get(0).getPassword().equals(password)) {
			success = true;
		}

		else {
			success = false;
		}

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");

		if (success) {

			req.getSession(false);

			if (session == null) {
				resp.getWriter().println("fail");
			} else {

				Cookie cookie = new Cookie("logid", req.getParameter(id));

				cookie.setMaxAge(20 * 60 * 24 * 60);

				resp.addCookie(cookie);

				resp.getWriter().println("<a href='index.html'>go to main</a>");
			}

			resp.getWriter().println("</body>");
			resp.getWriter().println("</html>");

		}

		
		
		Cookie[] cookies = req.getCookies();
		if (check==true) {
			if (cookies != null) {
				UUID.randomUUID().toString();
				for (Cookie c : cookies) {

					if (c.getName().equals("logid"))
						id = c.getValue();
				}
			}

			else {

				resp.sendRedirect("login.html");
													
			}
		}

	}

}
