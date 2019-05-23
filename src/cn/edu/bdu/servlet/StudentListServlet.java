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
 * �����ѯҳ����Ϣ��Ȼ����ʾ��list.jspҳ����
 * @author admin
 *
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			//1.��ѯ���������е�ѧ��
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.findAll();
			//2.�Ȱ����ݴ浽��������
//			request.setAttribute("list", list); //������ ��Χ ��������һ������
			HttpSession session = request.getSession();   //��Χ һ�λỰ  �����������Ӧ
			session.setAttribute("list", list);
			//3.��תҳ��  
//			request.getRequestDispatcher("list.jsp").forward(request, response);
			//�ض���ķ�ʽ��ת
			response.sendRedirect("list.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
