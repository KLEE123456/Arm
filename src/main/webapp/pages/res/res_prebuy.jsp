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
<script type="text/javascript" src="js/pages/res/res_prebuy.js"></script>
	<script type="text/javascript">
		$(function () {
			$("#rmBtn").click(function () {
				var rids=$("input[name='did']:checked");
				var ridArray=new Array();
				for (var i=0;i<rids.length;i++){
					ridArray.push(rids[i].value);
				}
				location.href='${pageContext.request.contextPath}/details/delDetals.action?ridArray='+ridArray;
			})
		})
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
							<h3 class="box-title"><strong>待购商品</strong>
								<a href="pages/res/res_add.jsp" class="btn btn-success btn-xs">购买办公用品</a></h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body table-responsive no-padding">
							<table class="table table-hover">
								<tr>
									<th class="text-center">
										<input type="checkbox" id="selectAll">
									</th>
									<th class="text-center"><strong>商品名称</strong></th>
									<th class="text-center"><strong>商品单价</strong></th>
									<th class="text-center"><strong>购买数量</strong></th>
									<th class="text-center"><strong>操作</strong></th>
								</tr>
									<c:choose>
										<c:when test="${detailsList.size()==0}">
											<tr align="center">
												<td colspan="4">
													<span style="color: red">
														没有待购商品!
													</span>
												</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${detailsList}" varStatus="status" var="detail">
												<tr>
													<td class="text-center">
														<input type="checkbox" id="did" name="did" value="${detail.did}">
													</td>
													<td class="text-center"><a><img src="${pageContext.request.contextPath}/${detail.photo}" class="img" style="width:30px;">${detail.title}</a>
													</td>
													<td class="text-center"><span id="price-1">${detail.price}</span></td>
													<td class="text-center">
														<button class="btn btn-primary" id="sub-1">-</button>
														<input type="text" id="amount-1" name="amount-1" class="shopcar-form-control" size="4" maxlength="4" value="20">
														<button class="btn btn-primary" id="add-1">+</button>
													</td>
													<td class="text-center"><a href="pages/res/res_edit.jsp?rid=1" class="btn btn-warning">编辑</a></td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
							</table>
							<div class="text-right">
								总价￥<span id="allPrice" class="text-danger h2"></span>
							</div>
							<div>
								<button class="btn btn-info" id="editBtn">修改数量</button>
								<button class="btn btn-warning" id="rmBtn">移出清单</button>
								<a href="pages/purchase/purchase_add.jsp" class="btn btn-danger" id="rmBtn">提交申请</a>
							</div>
						</div>
						<!-- /.box-body -->
						<jsp:include page="/pages/plugins/include_alert.jsp"/>
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
