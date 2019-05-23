package cn.edu.bdu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bdu.bean.Student;
import cn.edu.bdu.service.StudentService;
import cn.edu.bdu.service.impl.StudentServiceImpl;

/**
 * 获取单个学生id
 * @author admin
 *
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//获取此学生id
			int sid = Integer.parseInt(request.getParameter("sid"));
			
			//根据id找到学生信息
			StudentService service = new StudentServiceImpl();
			Student stu = service.findStudentById(sid);
			
			//将信息存储到session中，然后跳转
			HttpSession session = request.getSession();
			session.setAttribute("stu", stu);
			
			//跳转到edit.jsp
			response.sendRedirect("edit.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
