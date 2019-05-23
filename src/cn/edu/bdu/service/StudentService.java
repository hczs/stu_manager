package cn.edu.bdu.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.bdu.bean.PageBean;
import cn.edu.bdu.bean.Student;

/**
 * ����ѧ��ҵ����淶
 * @author admin
 *
 */
public interface StudentService {
	
	/**
	 * ���ݵ�ǰҳ��ѯѧ������
	 * @param currentPage ��ǰҳ���ֵ
	 * @return PageBean
	 * @throws SQLException
	 */
	PageBean findStudentByPage(int currentPage) throws SQLException ;

	/**
	 * ��ѯ����ѧ��
	 * @return	List<Student>
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * ͨ��id����ѧ����Ϣ
	 * @param sid ѧ��id
	 * @return  ����ѧ����Ϣ
	 * @throws SQLException
	 */
	Student findStudentById(int sid) throws SQLException ;
	
	/**
	 * ���������Ա���в�ѯѧ����Ϣ
	 * @param sname ����	
	 * @param gender �Ա�
	 * @return  ����ѧ������
	 * @throws SQLException
	 */
	List<Student> searchStudent(String sname, String gender ) throws SQLException ;
	
	/**
	 * ���ѧ��
	 * @param student  ѧ������
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException ;
	
	/**
	 * ɾ��ѧ��
	 * @param sid ѧ�����
	 * @throws SQLException
	 */
	void delete(int sid) throws SQLException ;
	
	/**
	 * ����ѧ����Ϣ
	 * @param student ѧ����Ϣ
	 * @throws SQLException
	 */
	void update(Student student) throws SQLException ;
}
