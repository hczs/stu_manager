package cn.edu.bdu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.bdu.service.StudentService;
import cn.edu.bdu.service.impl.StudentServiceImpl;

/**
 * ���servletִ��ɾ������
 * @author admin
 *
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//��ȡ���
			int sid = Integer.parseInt(request.getParameter("sid"));
			
			//ִ��ɾ��
			StudentService service = new StudentServiceImpl();
			service.delete(sid);
			
			//��תҳ��
			response.sendRedirect("StudentListServlet");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
