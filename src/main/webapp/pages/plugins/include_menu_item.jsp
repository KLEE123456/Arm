<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page isELIgnored="false" %>
<style type="text/css">
	a{
		transition:none;
	}
</style>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/${userMsg.photo}" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${userMsg.name}</p>
			</div> 
		</div>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><i class="fa fa-slack"></i> 行政资源管理系统</li>
			<li class="treeview"><a href="<%=basePath%>pages/index.jsp"> <i
					class="fa fa-folder-open"></i> <span>权限管理</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="${pageContext.request.contextPath}/emp/findEmp.action?pageNum=1" ><i class="fa fa-circle-o"></i>
							管理员列表</a></li>
					<li><a href="${pageContext.request.contextPath}/emp/findEid.action"><i class="fa fa-circle-o"></i>
							增加管理员</a></li>
				</ul></li>
			<li class="treeview"><a href="<%=basePath%>pages/index.jsp"> <i class="fa  fa-folder-open"></i>
					<span>人事管理</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="${pageContext.request.contextPath}/dep/findDeps.action"><i
							class="fa fa-circle-o"></i> 部门列表</a></li>
					<li><a href="${pageContext.request.contextPath}/emp/findEid.action?method=emp"><i
							class="fa fa-circle-o"></i> 增加员工</a></li>
					<li><a href="${pageContext.request.contextPath}/emp/findEmps.action?pageNum=1"><i
							class="fa fa-circle-o"></i> 员工列表</a></li>
				</ul></li>
			<li class="treeview"><a href="<%=basePath%>pages/index.jsp"> <i class="fa  fa-folder-open"></i>
					<span>办公用品</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="${pageContext.request.contextPath}/res/findResType.action"><i
							class="fa fa-circle-o"></i> 用品分类</a></li>
					<li><a href="${pageContext.request.contextPath}/res/findRes.action?pageNum=1&method=res"><i
							class="fa fa-circle-o"></i> 办公用品列表</a></li>
					<li><a href="pages/res/res_emp_list.jsp"><i
							class="fa fa-circle-o"></i> 领取记录</a></li>
					<li><a href="pages/res/res_preget.jsp"><i
							class="fa fa-circle-o"></i> 待领清单</a></li>
					<li><a href="${pageContext.request.contextPath}/details/findDetail.action"><i
							class="fa fa-circle-o"></i> 待购清单</a></li>
					<li><a href="pages/purchase/purchase_list.jsp"><i
							class="fa fa-circle-o"></i> 购入申请</a></li>
					<li><a href="pages/purchase/purchase_apply.jsp"><i
							class="fa fa-circle-o"></i> 我的申请</a></li>
					<li><a href="pages/res/res_audit.jsp"><i
							class="fa fa-circle-o"></i> 领取审批</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>