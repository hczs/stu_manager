package cn.edu.bdu.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.edu.bdu.bean.PageBean;
import cn.edu.bdu.bean.Student;
import cn.edu.bdu.dao.StudentDao;
import cn.edu.bdu.dao.impl.StudentDaoImpl;
import cn.edu.bdu.service.StudentService;

/**
 * ����ѧ��ҵ��ʵ��
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
		//��������з�װPageBean
		
		int pageSize = StudentDao.PAGE_SIZE;
		//�ȶ���
		PageBean<Student> page= new PageBean<Student>();
		
		//���ȸ���򵥵� ��ǰҳ���ֵ
		page.setCurrentPage(currentPage);
		
		//ÿҳ�ļ�¼��
		page.setPageSize(pageSize);
		
		//ѧ������
		StudentDao dao = new StudentDaoImpl();
		List<Student> studentList = dao.findStudentByPage(currentPage);
		page.setStudent(studentList);
		
		//�ҵ��ܼ�¼��                                       ��������ҳ���ͺ�Ū��
		int totalSize = dao.findTotalSize();
		page.setTotalSize(totalSize);
		
		//��ҳ��
		int totalPage = totalSize % pageSize == 0 ? totalSize/pageSize : totalSize/pageSize+1;
		page.setTotalPage(totalPage);
		
		return page;
	}

}
