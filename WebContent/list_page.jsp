<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
<script type="text/javascript">
	function doDelete(sid) {
		var flag = confirm();
		if(flag){
			location.href="DeleteServlet?sid="+sid;
		}
	}
</script>
</head>
<body>
<form action="SearchStudentServlet" method="post">
	<table border="1" width="800">
		<tr>
			<td colspan="8">
				按姓名查询：<input type="text" name="sname" />&nbsp;&nbsp;&nbsp;
				按性别查询：<select name="gender">
							<option value="">请选择
							<option value="男">男
							<option value="女">女
						</select>
						&nbsp;&nbsp;&nbsp;
				<input type="submit" value="查询">
				&nbsp;&nbsp;&nbsp;
				
				<a href="add.jsp">添加</a>&nbsp;&nbsp;&nbsp;
				<a href="index.jsp">回到首页</a>
			
			</td>
		</tr>
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.student }" var="stu">
			<tr align="center">
				<td>${stu.sid }</td>
				<td>${stu.sname }</td>
				<td>${stu.gender }</td>
				<td>${stu.phone }</td>
				<td>${stu.birthday }</td>
				<td>${stu.hobby }</td>
				<td>${stu.info }</td>
				<td><a href="EditServlet?sid=${stu.sid }">更新</a> <a href="#" onclick="doDelete(${stu.sid})">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				第${page.currentPage }/${page.totalPage }&nbsp;&nbsp;&nbsp;
				每页显示${page.pageSize }条&nbsp;&nbsp;&nbsp;
				总记录数${page.totalSize }&nbsp;&nbsp;&nbsp;
				<a href="StudentListPageServlet?currentPage=1">[首页]</a>&nbsp;&nbsp;&nbsp;
				<c:if test="${page.currentPage != 1 }">
					<a href="StudentListPageServlet?currentPage=${page.currentPage-1 }">上一页</a>&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:forEach begin="1" end="${page.totalPage }" var="i">
					&nbsp;&nbsp;&nbsp;
					<c:if test="${page.currentPage == i}">${i }</c:if>
					<c:if test="${page.currentPage != i}"><a href="StudentListPageServlet?currentPage=${i }">${i }</a></c:if>
				</c:forEach>&nbsp;&nbsp;&nbsp;
				<c:if test="${page.currentPage != page.totalPage }">
					<a href="StudentListPageServlet?currentPage=${page.currentPage+1 }">下一页</a>&nbsp;&nbsp;&nbsp;
				</c:if>
				<a href="StudentListPageServlet?currentPage=${page.totalPage }">[尾页]</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>