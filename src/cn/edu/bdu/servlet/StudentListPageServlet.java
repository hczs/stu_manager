package cn.edu.bdu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bdu.bean.PageBean;
import cn.edu.bdu.bean.Student;
import cn.edu.bdu.service.StudentService;
import cn.edu.bdu.service.impl.StudentServiceImpl;

/**
 * ��ҳ��ʾѧ����Ϣ
 * @author admin
 *
 */
@WebServlet("/StudentListPageServlet")
public class StudentListPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//���Ȼ�ȡcurrentPage
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			//Ȼ�����currentPage��ֵ����ʾҳ����Ϣ
			StudentService service = new StudentServiceImpl();
			PageBean page = service.findStudentByPage(currentPage);
			
			//�洢��Ϣ
			HttpSession session = request.getSession();
			session.setAttribute("page", page);
			//��תҳ��
			response.sendRedirect("list_page.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
