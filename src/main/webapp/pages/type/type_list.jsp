<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="/pages/plugins/include_javascript_head.jsp" />
<script type="text/javascript" src="js/pages/type/type_list.js"></script>
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
							<h3 class="box-title"><strong>办公用品分类列表</strong></h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body table-responsive no-padding">
							<table class="table table-hover">
								<tr>
									<th>栏目名称</th>
									<th>操作</th>
								</tr>
								<c:choose>
									<c:when test="${resTypeList.size()==0}">
										<tr align="center">
											<td><font color="red">办公用品类别不存在!</font></td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${resTypeList}" var="resType" varStatus="status">
											<tr>
												<td><input type="text" name="title-1" id="title-1" value="${resType.title}" class="form-control"></td>
												<td><button class="btn btn-info" id="editBtn-1"><span class="fa fa-pencil-square"></span> 修改</button>
													<a href="pages/type/subtype_list.jsp" class="btn btn-warning"><span class="fa fa-list-alt"></span> 查看子栏目</a></td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>
							<jsp:include page="/pages/plugins/include_alert.jsp"/>  
						</div>
						<!-- /.box-body -->
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
