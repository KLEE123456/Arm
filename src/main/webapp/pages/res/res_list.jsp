<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="/pages/plugins/include_javascript_head.jsp" />
<script type="text/javascript" src="js/pages/res/res_list.js"></script>
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
							<h3 class="box-title"><strong>办公用品列表</strong></h3>
						</div>
						<jsp:include page="/pages/plugins/split_page_plugin_search.jsp"/>
						<!-- /.box-header -->
						<div class="box-body table-responsive no-padding">
							<table class="table table-hover">
								<tr>
									<th>名称</th>
									<th>购入时间</th>
									<th>库存量</th>
									<th>状态</th>
									<th>是否需要返还</th>
									<th>操作</th>
								</tr>
								<c:choose>
									<c:when test="${resList.size()==0}">
										<tr>
											<td colspan="6">
												<font color="red">没有办公用品!</font>
											</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${resList}" var="res" varStatus="status">
											<tr>
												<td><img src="${pageContext.request.contextPath}/${res.photo}" class="img" style="width:30px;"> ${res.title}</td>
												<td>${res.indate}</td>
												<td>${res.amount}</td>
												<td>可领取</td>
												<td>返还</td>
												<td>
													<button class="btn btn-primary btn-xs">加入领取清单</button>
													<a class="btn btn-warning btn-xs" href="pages/res/res_append.jsp">追加</a>
												</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>

							</table>
						</div>
						<!-- /.box-body -->
						<span style="margin-left: 38%">
							当前页第${pageInfo.pageNum}页,总页数${pageInfo.pages}页,总记录条数${pageInfo.total}条
						</span>
						<div style="margin-left: 38%">
							<ul class="pagination">
								<li><a href="${pageContext.request.contextPath}/res/findRes.action?pageNum=1">首页</a></li>
								<li><a href="${pageContext.request.contextPath}/res/findRes.action?pageNum=${pageInfo.prePage}">上一页</a></li>
								<li><a href="${pageContext.request.contextPath}/res/findRes.action?pageNum=${pageInfo.nextPage}">下一页</a></li>
								<li><a href="${pageContext.request.contextPath}/res/findRes.action?pageNum=${pageInfo.pages}">尾页</a></li>
							</ul>
						</div>
					</div>
					<!-- /.box -->
				</div>
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
