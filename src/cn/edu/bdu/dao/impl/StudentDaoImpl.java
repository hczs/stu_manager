package cn.edu.bdu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.bdu.bean.Student;
import cn.edu.bdu.dao.StudentDao;
import cn.edu.bdu.util.JDBCUtil02;
import cn.edu.bdu.util.TestUtil;

/**
 * 这是StudentDao的实现，针对前面做出的规范进行具体的实现
 * @author admin
 *
 */
public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu";
		List<Student> list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "insert into stu values(null, ?, ?, ?, ?, ?, ?)";
		queryRunner.update(sql, 
			student.getSname(),
			student.getGender(),
			student.getPhone(),
			student.getBirthday(),
			student.getHobby(),
			student.getInfo()
				);
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
		queryRunner.update("delete from stu where sid=?",sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu where sid=?";
		Student student = queryRunner.query(sql, new BeanHandler<Student>(Student.class),sid);
		return student;
	}

	@Override
	public void update(Student student) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?";
		queryRunner.update(sql, 
			student.getSname(),
			student.getGender(),
			student.getPhone(),
			student.getBirthday(),
			student.getHobby(),
			student.getInfo(),
			student.getSid()
				);
		
	}

	@Override
	public List<Student> searchStudent(String sname, String gender) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
		
		//把？的值存入集合中 因为不确定有几个？
		List<String> list = new ArrayList<String>();
		
		String sql = "select * from stu where 1=1";
		
		//如果姓名不为空
		if(!TestUtil.isEmpty(sname)){
			sql = sql + " and sname like ?";
			list.add("%"+sname+"%");
		}
		
		//如果性别不为空
		if(!TestUtil.isEmpty(gender)){
			sql = sql + " and gender=?";
			list.add(gender);
		}
		//因为query最后一个参数可以为数组，不能是集合 所以将集合转换为数组。
		return queryRunner.query(sql, new BeanListHandler<Student>(Student.class),list.toArray());
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
		//limit 是每页的数据多少条 offset是从多少条之后显示
		/*
		 * 假设一页显示5条数据 则
		 * 第一页 5 0
		 * 第二页 5 5
		 * 第三页 5 10
		 */
		String sql = "select * from stu limit ? offset ?";
		List<Student> list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
		return list;
	}

	@Override
	public int findTotalSize() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select count(*) from stu";
		//ScalarHandler 将单个值封装 例如select count(*) 我们得转成Long类型的
		Long result = (Long) queryRunner.query(sql,new ScalarHandler());
		return result.intValue();
	}

}
