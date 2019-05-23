package cn.edu.bdu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import cn.edu.bdu.bean.Student;
import cn.edu.bdu.service.StudentService;
import cn.edu.bdu.service.impl.StudentServiceImpl;

/**
 * 负责查询页面信息，然后显示到list.jsp页面上
 * @author admin
 *
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			//1.查询出来了所有的学生
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.findAll();
			//2.先把数据存到作用域中
//			request.setAttribute("list", list); //作用域 范围 ：仅限于一次请求
			HttpSession session = request.getSession();   //范围 一次会话  多次请求与响应
			session.setAttribute("list", list);
			//3.跳转页面  
//			request.getRequestDispatcher("list.jsp").forward(request, response);
			//重定向的方式跳转
			response.sendRedirect("list.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
