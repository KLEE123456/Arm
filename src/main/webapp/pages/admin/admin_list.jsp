<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="/WEB-INF/c.tld" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="/pages/plugins/include_javascript_head.jsp" />
<script type="text/javascript" src="js/pages/dept/dept_list.js"></script>
<script type="text/javascript">
	function  delAdm(eid,pageNum) {
		if (confirm("你确定要删除"+eid+"号管理员吗?")){
			location.href='${pageContext.request.contextPath}/emp/delAdm.action?eid='+eid+'&pageNum='+pageNum;
		}
	}

</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/include_menu_item.jsp" />
		<div class="content-wrapper">
			<!-- 此处编写需要显示的页面 -->
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title"><strong>管理员列表</strong></h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body table-responsive no-padding">
							<table class="table table-hover">
								<tr>
									<th>管理员编号</th>
									<th>姓名</th>
									<th>联系电话</th>
									<th>性别</th>
									<th>基本工资</th>
									<th>操作</th>
								</tr>
								<c:choose>
									<c:when test="${empList.size()==0}">
										<tr align="center">
											<td colspan="6">
												<font color="red">不存在管理员信息!</font>
											</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${empList}" var="emp" varStatus="status">
											<tr>
												<td>${emp.eid}</td>
												<td>${emp.name}</td>
												<td>${emp.phone}</td>
												<td>${emp.sex}</td>
												<td>${emp.salary}</td>
												<td>
													<a class="btn btn-warning btn-xs" href="${pageContext.request.contextPath}/emp/XREmp.action?eid=${emp.eid}&method=admEdit&pageNum=${pageInfo.pageNum}">编辑</a>
													<a class="btn btn-warning btn-xs" href="javascript:void(0)" onclick="delAdm('${emp.eid}','${pageInfo.pageNum}')">删除</a>
												</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>

						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
			</div>
			<div style="margin-left: 36%">
				<font style="align:center">当前页是第${pageInfo.pageNum}页，总共${pageInfo.pages}页，总记录数${pageInfo.total}条</font>
			</div>
			<div style="margin-left: 35%">
				<ul class="pagination">
					<li><a href="${pageContext.request.contextPath}/emp/findEmp.action?pageNum=1" rel="external">首页</a></li>
					<li><a href="${pageContext.request.contextPath}/emp/findEmp.action?pageNum=${pageInfo.prePage}" >上一页</a></li>
					<li><a href="${pageContext.request.contextPath}/emp/findEmp.action?pageNum=${pageInfo.nextPage}" >下一页</a></li>
					<li><a href="${pageContext.request.contextPath}/emp/findEmp.action?pageNum=${pageInfo.pages}" >尾页</a></li>
				</ul>
			</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/include_javascript_foot.jsp" />
</body>
</html>
