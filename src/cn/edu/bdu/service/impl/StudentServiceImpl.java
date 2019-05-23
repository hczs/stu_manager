package cn.edu.bdu.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.edu.bdu.bean.PageBean;
import cn.edu.bdu.bean.Student;
import cn.edu.bdu.dao.StudentDao;
import cn.edu.bdu.dao.impl.StudentDaoImpl;
import cn.edu.bdu.service.StudentService;

/**
 * 这是学生业务实现
 * @author admin
 *
 */
public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);
	}

	@Override
	public void delete(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.update(student);
	}

	@Override
	public List<Student> searchStudent(String sname, String gender) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.searchStudent(sname, gender);
	}

	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		//在这里进行封装PageBean
		
		int pageSize = StudentDao.PAGE_SIZE;
		//先定义
		PageBean<Student> page= new PageBean<Student>();
		
		//首先搞最简单的 当前页面的值
		page.setCurrentPage(currentPage);
		
		//每页的记录数
		page.setPageSize(pageSize);
		
		//学生集合
		StudentDao dao = new StudentDaoImpl();
		List<Student> studentList = dao.findStudentByPage(currentPage);
		page.setStudent(studentList);
		
		//找到总记录数                                       到后面总页数就好弄了
		int totalSize = dao.findTotalSize();
		page.setTotalSize(totalSize);
		
		//总页数
		int totalPage = totalSize % pageSize == 0 ? totalSize/pageSize : totalSize/pageSize+1;
		page.setTotalPage(totalPage);
		
		return page;
	}

}
