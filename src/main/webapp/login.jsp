<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>

<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='screen'
	href='assets/css/login.css'>
<title>Quản lý đề tài nghiên cứu khoa học</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
	<div class="form-container container" id="container" style ="width: 900px; margin:auto;">
		<div class="Left">
		<div class="image"
			style="display: block; width: 500px; 
			height: 500px;  
			background-size: cover;
			background-image: url('https://img.freepik.com/vecteurs-libre/concept-scientifique-microscope-personnes-travaillant_23-2148527560.jpg?w=1480&t=st=1694345058~exp=1694345658~hmac=5757645110deb2c840cff891de30cc86c1c213ae31d6f12cd1b8abae0db48471'); 
			background-repeat: no-repeat;">
		</div>
		</div>
		<div class="form-container sign-in-container" style="left: 520px;width:  350px !important;">
			<form action="login" method='post'>
				<h1>Đăng nhập</h1>
				<input type="text" placeholder="Tên đăng nhập" name="username" /> <input
					type="password" placeholder="Mật khẩu" name="password" />
				<button style ="background-color: #09274e !important;" type = 'submit'>Đăng nhập</button>
			</form>
		</div>
	</div>
	

</body>
</html>