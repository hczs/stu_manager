package cn.edu.bdu.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.bdu.bean.Student;

/**
 * ��������ѧ��������ݲ���
 * @author admin
 *
 */
public interface StudentDao {
	
	int PAGE_SIZE = 5;
	
	/**
	 * ���ݵ�ǰҳ��ѯѧ������
	 * @param currentPage ��ǰҳ���ֵ
	 * @return ����ѧ������
	 * @throws SQLException
	 */
	List<Student> findStudentByPage(int currentPage) throws SQLException ;
	
	/**
	 * ��ѯ����ѧ��
	 * @return	List<Student>
	 */
	List<Student> findAll() throws SQLException ;
	
	/**
	 * ��ѯ�ܵļ�¼��
	 * @return
	 * @throws SQLException
	 */
	int findTotalSize() throws SQLException;

	
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
