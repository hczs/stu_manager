package cn.edu.bdu.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.bdu.bean.Student;

/**
 * 这个是针对学生表的数据操作
 * @author admin
 *
 */
public interface StudentDao {
	
	int PAGE_SIZE = 5;
	
	/**
	 * 根据当前页查询学生数据
	 * @param currentPage 当前页面的值
	 * @return 返回学生集合
	 * @throws SQLException
	 */
	List<Student> findStudentByPage(int currentPage) throws SQLException ;
	
	/**
	 * 查询所有学生
	 * @return	List<Student>
	 */
	List<Student> findAll() throws SQLException ;
	
	/**
	 * 查询总的记录数
	 * @return
	 * @throws SQLException
	 */
	int findTotalSize() throws SQLException;

	
	/**
	 * 通过id查找学生信息
	 * @param sid 学生id
	 * @return  返回学生信息
	 * @throws SQLException
	 */
	Student findStudentById(int sid) throws SQLException ;
	
	/**
	 * 根据姓名性别进行查询学生信息
	 * @param sname 姓名	
	 * @param gender 性别
	 * @return  返回学生集合
	 * @throws SQLException
	 */
	List<Student> searchStudent(String sname, String gender ) throws SQLException ;
	
	/**
	 * 添加学生
	 * @param student  学生对象
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException ;
	
	/**
	 * 删除学生
	 * @param sid 学生编号
	 * @throws SQLException
	 */
	void delete(int sid) throws SQLException ;
	
	/**
	 * 更新学生信息
	 * @param student 学生信息
	 * @throws SQLException
	 */
	void update(Student student) throws SQLException ;
	

}
