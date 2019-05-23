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
 * 添加学生
 * @author admin
 *
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//因为从request获取，可能有中文，所以要先设置编码方式防止乱码
			request.setCharacterEncoding("UTF-8");
			
			//从request获取学生信息
			String sname = (String) request.getParameter("sname");
			String gender = (String) request.getParameter("gender");
			String phone = (String) request.getParameter("phone");
			String birthday = (String) request.getParameter("birthday");
//			String hobby = (String) request.getParameter("hobby");
			String info = (String) request.getParameter("info");
			
			//有多个爱好但是这个获取只能获取一个，所以用
				String[] h = request.getParameterValues("hobby"); //返回的是一个字符串数组
				//把数组转换为字符串
				String hobby = Arrays.toString(h);
				//再用字符串切一下
				hobby = hobby.substring(1, hobby.length()-1);
			
			//将String类型的birthday转换为日期类型
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			//创建学生对象
			Student student = new Student(sname, gender, phone, date, hobby, info);
			
			//添加到数据库
			StudentService service = new StudentServiceImpl();
			service.insert(student);
			
			//跳转到查询的servlet
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
