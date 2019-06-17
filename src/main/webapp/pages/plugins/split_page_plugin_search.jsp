<%@ page pageEncoding="UTF-8"%>
<%--
	实现数据搜索条的控制
<jsp:include page="split_page_plugin_search.jsp"/>
--%>
<%
	request.setCharacterEncoding("UTF-8") ;
	String url = (String)request.getAttribute("url") ;
	String columnData = (String)request.getAttribute("columnData") ;
	String keyWord = (String)request.getAttribute("keyWord") ;
	String column = (String)request.getAttribute("column") ;
%>
<script type="text/javascript">
	$(function () {
		$("#checkBtn").click(function () {
			var val=$("#kw").val();
			if (val==''){
				alert('请输入查询的内容!');
				return 0;
			}
			$("#splitSearchForm").submit();
		})
	})
</script>
<div class="row">
	<form action="${pageContext.request.contextPath}/res/findRes.action?pageNum=1" method="post" class="form-group"
		id="splitSearchForm">
		<fieldset>
			<div class="form-group">
				<div class="col-md-2">&nbsp;</div>
				<%
					if (columnData != null) {
				%>
					<div class="col-md-3">
						<select id="col" name="col" class="form-control">
				<%
							String result [] = columnData.split("\\|") ;
							for (int x = 0 ; x < result.length ; x ++) {
								String temp[] = result[x].split(":") ;
				%>
								<option value="<%=temp[1]%>" <%=column.equals(temp[1])?"selected":""%>><%=temp[0]%></option>
				<%
							}
				%>
						</select>
					</div>
				<%
					}
				%>
				<div class="col-md-5">
					<input type="text" name="resName" id="kw" class="form-control input-sm"
						 placeholder="请输入检索关键字" value="${resNames}">
				</div>
				<div class="col-md-2">
					<button type="button" class="btn btn-primary" id="checkBtn">检索</button>
					<input type="hidden" name="${paramName}" value="${paramValue}">
					<input type="hidden" name="cp" value="1">
				</div>
			</div>
		</fieldset>
	</form>
</div>
<div class="row">
	<div class="col-md-7 col-md-push-5"> 
		<p class="text-info">满足查询条件的数据量：${allRecorders}</p>
	</div>
</div>