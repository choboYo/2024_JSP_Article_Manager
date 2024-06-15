package com.koreaIT.jsp.am;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.koreaIT.jsp.am.config.Config;
import com.koreaIT.jsp.am.util.DBUtil;
import com.koreaIT.jsp.am.util.SecSql;
import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/doLogin")
public class MemberDoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8;");
		
		Connection connection = null;

		try {
			Class.forName(Config.getDBDriverName());
			connection = DriverManager.getConnection(Config.getDBUrl(), Config.getDBUsr(), Config.getDBPW());
			
			
			SecSql sql = new SecSql();
			sql.append("SELECT * FROM `member`");
			
			Map<String, Object> memberMap = DBUtil.selectRow(connection, sql);
			
			
			HttpSession session = request.getSession();
			for(Member member : memberMap) {
			if(memberMap.get("loginId") != request.getParameter("loginId")) {
				response.getWriter().append(String.format("%s은(는) 없는 아이디 입니다.", memberMap.get("loginId")));
				return;
				} 
			}
			
			if(memberMap.get("loginId") == request.getParameter("loginId")) {
				response.getWriter().append(String.format("%s님은 로그인 되었습니다.", request.getParameter("loginId")));
			}
			
				 session.setAttribute("loginId", request.getParameter("loginId"));
				 session.setAttribute("loginPw", request.getParameter("loginPW"));
			
			// request에 있는 session을 꺼내오고 -> session에서 setAttribute를 하고
			// 꺼낼 때는 getAttribute를 하면된다.
			
//			for(String key : memberMap) {
//				if(member == null) {
//					response.getWriter().append(String.format(LEGACY_DO_HEAD, null));
//				}
//			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}