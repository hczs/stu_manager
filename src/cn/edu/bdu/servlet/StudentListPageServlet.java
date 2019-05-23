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
 * 分页显示学生信息
 * @author admin
 *
 */
@WebServlet("/StudentListPageServlet")
public class StudentListPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//首先获取currentPage
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			//然后根据currentPage的值来显示页面信息
			StudentService service = new StudentServiceImpl();
			PageBean page = service.findStudentByPage(currentPage);
			
			//存储信息
			HttpSession session = request.getSession();
			session.setAttribute("page", page);
			//跳转页面
			response.sendRedirect("list_page.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
