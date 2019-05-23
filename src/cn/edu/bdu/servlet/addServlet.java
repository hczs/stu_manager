package cn.edu.bdu.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.bdu.bean.Student;
import cn.edu.bdu.service.StudentService;
import cn.edu.bdu.service.impl.StudentServiceImpl;

/**
 * ���ѧ��
 * @author admin
 *
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//��Ϊ��request��ȡ�����������ģ�����Ҫ�����ñ��뷽ʽ��ֹ����
			request.setCharacterEncoding("UTF-8");
			
			//��request��ȡѧ����Ϣ
			String sname = (String) request.getParameter("sname");
			String gender = (String) request.getParameter("gender");
			String phone = (String) request.getParameter("phone");
			String birthday = (String) request.getParameter("birthday");
//			String hobby = (String) request.getParameter("hobby");
			String info = (String) request.getParameter("info");
			
			//�ж�����õ��������ȡֻ�ܻ�ȡһ����������
				String[] h = request.getParameterValues("hobby"); //���ص���һ���ַ�������
				//������ת��Ϊ�ַ���
				String hobby = Arrays.toString(h);
				//�����ַ�����һ��
				hobby = hobby.substring(1, hobby.length()-1);
			
			//��String���͵�birthdayת��Ϊ��������
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			//����ѧ������
			Student student = new Student(sname, gender, phone, date, hobby, info);
			
			//��ӵ����ݿ�
			StudentService service = new StudentServiceImpl();
			service.insert(student);
			
			//��ת����ѯ��servlet
//			request.getRequestDispatcher("StudentListServlet").forward(request, response);
			
			response.sendRedirect("StudentListServlet");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
