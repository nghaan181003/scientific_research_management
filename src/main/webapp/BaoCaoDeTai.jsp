<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Model.User"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Báo cáo đề tài</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Fonts and icons -->
<script src="assets/js/plugin/webfont/webfont.min.js"></script>
<script>
	WebFont.load({
		google : {
			families : [ "Lato:300,400,700,900" ]
		},
		custom : {
			families : [ "Flaticon", "Font Awesome 5 Solid",
					"Font Awesome 5 Regular", "Font Awesome 5 Brands",
					"simple-line-icons", ],
			urls : [ "assets/css/fonts.min.css" ],
		},
		active : function() {
			sessionStorage.fonts = true;
		},
	});
</script>
<!-- CSS Files -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="assets/css/atlantis.min.css" />
</head>

<body>
	<%
	User user = (User) session.getAttribute("user");
	%>
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<!-- Sidebar -->
		<jsp:include page="GiaoVienSideBar.jsp"></jsp:include>
		<!-- End Sidebar -->
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="row">
						<div class="col-2"></div>
						<div class="col-8 card mt-4 p-3">
							<form action="upload?action=baocao" method="post" enctype="multipart/form-data"
								method="post">
								<div class="form-group">
									<div class="text-center fw-bold">
										<h2 class="fw-bold" for="danh-sach-thanh-vien">Báo cáo đề
											tài</h2>
									</div>
									<input type="hidden" id="MaDT" name="MaDT"
										value="${deTai.getMaDT()}"> <input type="hidden"
										id="MaTT" name="MaTT" value="${deTai.getMaTT()}">
									<div class="card p-4">
										<div class="row">
											<div class="col-2">
												<label style="line-height: 35px; margin-top: 6px;"
													for="text" class="form-label">Tên báo cáo:</label>
											</div>

											<div class="col-10">
												<input type="text" class="form-control" name="TenBC">
											</div>
										</div>

										<div class="row">
											<div class="col-2">
												<label style="line-height: 30px; margin-top: 13px;"
													for="email" class="form-label">Mô tả:</label>

											</div>

											<div class="col-10">
												<input style="margin-top: 10px" type="text"
													class="form-control" name="MotaBC" required>
											</div>
										</div>
										<div class="row">
											<div class="col-2">
												<label for="attachment"
													style="line-height: 30px; margin-top: 13px;"
													class="form-label">Tải file:</label>
											</div>
											<div class="col-10">
												<input style="margin-top: 10px" type="file"
													class="form-control col-10" id="FileDT" name="FileDT"
													accept="*">
											</div>
										</div>

										<div class="row">
											<div class="col-4"></div>
											<div class="col-2" style="padding-left: 60px;">
												<input type="submit" class="btn btn-primary m-4"
													value="Báo cáo"></input>
											</div>

										</div>
									</div>


								</div>
							</form>

						</div>

					</div>


				</div>
			</div>
		</div>
	</div>
	<!--   Core JS Files   -->
	<script src="assets/js/core/jquery.3.2.1.min.js"></script>
	<script src="assets/js/core/popper.min.js"></script>
	<script src="assets/js/core/bootstrap.min.js"></script>
	<!-- jQuery UI -->
	<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script
		src="assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
	<!-- jQuery Scrollbar -->
	<script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<!-- Datatables -->
	<script src="assets/js/plugin/datatables/datatables.min.js"></script>
	<!-- Atlantis JS -->
	<script src="assets/js/atlantis.min.js"></script>
</body>

</html>