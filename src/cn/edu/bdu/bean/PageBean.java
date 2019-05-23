package cn.edu.bdu.bean;

import java.util.List;

/**
 * ����ҳ���װ��bean
 * @author admin
 * @param <T>
 *
 */
public class PageBean<T> {
	/*
	 * ���Ӧ���е��ֶ�
	 * 1.��ǰҳ�� 		currentPage
	 * 2.��ҳ��   		totalPage
	 * 3.ÿҳ�ļ�¼�� 	pageSize
	 * 4.�ܼ�¼�� 		totalSize
	 * 5.ѧ������		List<T> student //Ϊʲô�÷��� ��Ϊ��һ����ѧ����ҳ�����滹�����н�ʦ��ҳ����ʱ��ֱ�Ӱѽ�ʦ��beanд��ȥ���ɣ������Էǳ���
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
