<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>用户注册</title>
</head>
<body>
  <h2>新用户注册</h2><hr>
    <form action="/lab06/register" method="POST">
	<table>
		<tr>
			<td align="right">用户名:</td>
			<td><input type="text" name="username" value="马大哈"></td>
		</tr>
		<tr>
			<td align="right">密码:</td>
			<td><input type="password" name="password" value="123456"></td>
		</tr>

		<tr>
			<td align="right">电子邮箱:</td>
			<td><input type="text" name="email" value="mahaha@zsc.com"></td>
		</tr>
		<tr>
			<td align="right">手机号码:</td>
			<td><input type="text" name="cellphone" value="1354999890"></td>
		</tr>

		<tr>
			<td align="right">居住地:</td>
			<td><select name="place">
					<option value="北京">北京</option>
					<option value="上海">上海</option>
					<option value="深圳">深圳</option>
					<option value="广州">广州</option>
					<option value="中山">中山</option>
			</select></td>
		</tr>
		<tr>
			<td align="right">备注:</td>
			<td><textarea cols="80" rows="7"
						  name="comment">马大哈是一个好学上进的好青年,他的弟弟是马尔哈,他的哥哥是大马哈.
			</textarea></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="提交"></td>
		</tr>
	</table>
	
	</form>
</body>

</html>