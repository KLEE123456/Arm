<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String editUrl = basePath + "" ;
%>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="/pages/plugins/include_javascript_head.jsp" /> 
<script type="text/javascript" src="js/pages/emp/emp_edit.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			document.getElementById("sex${emp.sex}").checked="checked";
			document.getElementById("d${emp.did}").selected="selected";
			document.getElementById("l${emp.lid}").selected="selected";
			document.getElementById("a${emp.aflag}").selected="selected";
		});
		$(function () {
			$("#btnEdit").click(function () {
				var val=$("#photo").val();
				if (val==''){
					$("#photoMsg").text("请选择文件!");
					return;
				}
				$("#myform").submit();
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
							<h3 class="box-title"><strong>修改雇员信息</strong></h3>
						</div>
						<!-- /.box-header -->
						<div class="">
							<form class="form-horizontal" action="${pageContext.request.contextPath}/emp/editEmp.action" id="myform" method="post" enctype="multipart/form-data">
								<fieldset>
									<div class="form-group" id="eidDiv">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="eid">雇员编号：</label>
										<div class="col-md-5">
											<!-- 定义表单输入组件 -->
											<input type="text" id="eid" name="eid" class="form-control"
												placeholder="请输入雇员编号" value="${emp.eid}" readonly="readonly">
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="eidMsg"></div>
									</div>
									<div class="form-group" id="nameDiv">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="name">雇员姓名：</label>
										<div class="col-md-5">
											<!-- 定义表单输入组件 -->
											<input type="text" id="name" name="name" class="form-control"
												placeholder="请输入雇员姓名" value="${emp.name}">
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="nameMsg"></div>
									</div>
									<div class="form-group" id="sexDiv">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="sex女">雇员性别：</label>
										<div class="col-md-5">
											<div class="radio-inline">
												<label><input type="radio" name="sex" id="sex男" value="男" checked>男</label>
											</div>
											<div class="radio-inline">
												<label><input type="radio" name="sex" id="sex女" value="女">女</label>
											</div>
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="sexMsg"></div>
									</div>

									<div class="form-group" id="dept.did">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="dept.did">所属部门：</label>
										<div class="col-md-5">
											<select id="dept.did" name="did" class="form-control">
												<option value="1" id="d1">管理部</option>
												<option value="2" id="d2">人事部</option>
												<option value="3" id="d3">行政部</option>
												<option value="4" id="d4" selected>市场部</option>
												<option value="5" id="d5">财务部</option>
											</select>
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="level.lidMsg"></div>
									</div>
									<div class="form-group" id="dept.did">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="dept.did">特殊标记：</label>
										<div class="col-md-5">
											<select id="aflag" name="aflag" class="form-control">
												<option value="2" id="a2">普通管理员</option>
												<option value="0" id="a0" selected>普通雇员</option>
											</select>
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="level.lidMsg"></div>
									</div>
									<div class="form-group" id="passwordDiv">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="password" >登录密码：</label>
										<div class="col-md-5">
											<!-- 定义表单输入组件 -->
											<input type="password" id="password" name="password" class="form-control"
												placeholder="请输入登录密码" value="${emp.password}">
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="passwordMsg"></div>
									</div>
									<div class="form-group" id="phoneDiv">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="phone">联系电话：</label>
										<div class="col-md-5">
											<!-- 定义表单输入组件 -->
											<input type="text" id="phone" name="phone" class="form-control"
												placeholder="请输入联系电话" value="${emp.phone}">
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="phoneMsg"></div>
									</div>
									<div class="form-group" id="level.lid">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="level.lid">员工级别：</label>
										<div class="col-md-5">
											<select id="level.lid" name="lid" class="form-control">
												<option value="1" id="l1">实习生</option>
												<option value="2" id="l2" selected>普通员工</option>
												<option value="3" id="l3">部门主管</option>
												<option value="4" id="l4">部门经理</option>
												<option value="5" id="l5">总监</option>
												<option value="6" id="l6">副总裁</option>
												<option value="7" id="l7">总裁</option>
											</select>
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="level.lidMsg"></div>
									</div>
									<div class="form-group" id="salaryDiv">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="salary">基本工资：</label>
										<div class="col-md-5">
											<!-- 定义表单输入组件 -->
											<input type="text" id="salary" name="salary" class="form-control"
												placeholder="请输入基本工资" value="${emp.salary}">
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="salaryMsg"></div>
									</div>
									<div class="form-group" id="photoDiv">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="photo">雇员照片：</label>
										<div class="col-md-5">
											<!-- 定义表单输入组件 -->
											<input type="file" id="photo"  name="uploadfile" class="form-control"
												placeholder="请上传员工照片" multiple="multiple">
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="photoMsg" style="color: red"></div>
									</div>
									<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
									<div class="form-group" id="notice.noteDiv">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="note">备注信息：</label>
										<div class="col-md-5">
											<!-- 定义表单输入组件 -->
											<textarea id="note" name="note" class="form-control" placeholder="请输入公告信息" rows="10">${emp.note}</textarea>
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="noteMsg">${errorMsg}</div>
									</div>
									<div class="form-group">
										<div class="col-md-5 col-md-offset-3">
											<button type="button" class="btn btn-primary" id="btnEdit">编辑</button>
											<button type="reset" class="btn btn-warning">重置</button>
										</div>
									</div>
								</fieldset>
							</form>
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
