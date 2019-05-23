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
 * ��ȡ����ѧ��id
 * @author admin
 *
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//��ȡ��ѧ��id
			int sid = Integer.parseInt(request.getParameter("sid"));
			
			//����id�ҵ�ѧ����Ϣ
			StudentService service = new StudentServiceImpl();
			Student stu = service.findStudentById(sid);
			
			//����Ϣ�洢��session�У�Ȼ����ת
			HttpSession session = request.getSession();
			session.setAttribute("stu", stu);
			
			//��ת��edit.jsp
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
