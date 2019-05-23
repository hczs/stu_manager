package cn.edu.bdu.bean;

import java.util.List;

/**
 * 这是页面封装的bean
 * @author admin
 * @param <T>
 *
 */
public class PageBean<T> {
	/*
	 * 这个应该有的字段
	 * 1.当前页面 		currentPage
	 * 2.总页数   		totalPage
	 * 3.每页的记录数 	pageSize
	 * 4.总记录数 		totalSize
	 * 5.学生集合		List<T> student //为什么用泛型 因为不一定是学生分页，后面还可能有教师分页，到时候直接把教师的bean写进去即可，可用性非常大
	 */
	private int currentPage;
	private int totalPage;
	private int pageSize;
	private int totalSize;
	private List<T> student;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getStudent() {
		return student;
	}
	public void setStudent(List<T> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", totalPage=" + totalPage + ", pageSize=" + pageSize
				+ ", totalSize=" + totalSize + ", student=" + student + "]";
	}
	
	
}
