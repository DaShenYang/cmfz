<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">

	<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				$("#captchaImage").prop("src","${pageContext.request.contextPath}/sys/getVerify?"+Math.random());
			});
			

		});
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/admin/login" method="post" >
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${pageContext.request.contextPath}/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text"  name="name" class="text" value="${param.name}" maxlength="20" id="name"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" class="text" value="${param.password}" maxlength="20" id="password" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="code" name="code" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/sys/getVerify" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<c:if test="${msg!=null}"><font color="red">${msg}</font></c:if>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick=""><input type="submit" class="loginButton" value="登录" id="sub">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>