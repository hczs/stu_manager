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

import cn.edu.bdu.bean.Student;
import cn.edu.bdu.service.StudentService;
import cn.edu.bdu.service.impl.StudentServiceImpl;

/**
 * ���������Ա��ѯѧ��
 * @author admin
 *
 */
@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//�ȴ������������������
			request.setCharacterEncoding("UTF-8");
			
			//��ȡname and gender
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			
			//service ��ѯname gender
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.searchStudent(sname, gender);
//			System.out.println("list:"+list);
			
			//�洢����
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			
			//��ת��list.jsp
			response.sendRedirect("list.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
