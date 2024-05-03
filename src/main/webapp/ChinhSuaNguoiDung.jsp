<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Chỉnh sửa người dùng</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
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
<link rel="stylesheet" href="assets/css/datetime.css" />
</head>
<body>
	<div class="wrapper">
		<div class="main-header">
			<!-- Logo Header -->
			<div class="logo-header" data-background-color="blue">
				<a href="index.html" class="logo"> <img
					src="assets/img/logo.svg" alt="navbar brand" class="navbar-brand" />
				</a>
				<button class="navbar-toggler sidenav-toggler ml-auto" type="button"
					data-toggle="collapse" data-target="collapse" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"> <i class="icon-menu"></i>
					</span>
				</button>
				<button class="topbar-toggler more">
					<i class="icon-options-vertical"></i>
				</button>
				<div class="nav-toggle">
					<button class="btn btn-toggle toggle-sidebar">
						<i class="icon-menu"></i>
					</button>
				</div>
			</div>
			<!-- End Logo Header -->

			<!-- Navbar Header -->
			<nav class="navbar navbar-header navbar-expand-lg"
				data-background-color="blue2">
				<div class="container-fluid">
					<div class="collapse" id="search-nav"></div>
					<ul class="navbar-nav topbar-nav ml-md-auto align-items-center">
						<li class="nav-item dropdown hidden-caret"><a
							class="dropdown-toggle profile-pic" data-toggle="dropdown"
							href="#" aria-expanded="false">
								<div class="avatar-sm">
									<img src="assets/img/profile.jpg" alt="..."
										class="avatar-img rounded-circle" />
								</div>
						</a>
							<ul class="dropdown-menu dropdown-user animated fadeIn">
								<div class="dropdown-user-scroll scrollbar-outer">
									<li>
										<div class="user-box">
											<div class="avatar-lg">
												<img src="assets/img/profile.jpg" alt="image profile"
													class="avatar-img rounded" />
											</div>
											<div class="u-text">
												<h4>Hizrian</h4>
												<p class="text-muted">hello@example.com</p>
												<a href="profile.jsp"
													class="btn btn-xs btn-secondary btn-sm">View Profile</a>
											</div>
										</div>
									</li>
								</div>
							</ul></li>
					</ul>
				</div>
			</nav>
			<!-- End Navbar -->
		</div>
		<!-- Sidebar -->
		<jsp:include page="AdminSideBar.jsp"></jsp:include>
		<!-- End Sidebar -->

		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<form action="NguoiDung?action=CapNhat" method="post" style="margin-top: 50px" >
					<h2 style ="text-align: center" > CẬP NHẬT THÔNG TIN</h2>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group form-group-default">
									<label>Tên đăng nhập</label> <input type="text"
										value="<c:out value='${user.tenDangNhap}' />"
										class="form-control" name="TenDangNhap" required="required"
										readonly="readonly">
								</div>
							</div>

							<div class="col-sm-6">
								<div class="form-group form-group-default">
									<label>Mật khẩu</label> <input type="text"
										value="<c:out value='${user.matKhau}' />" class="form-control"
										name="MatKhau" required="required">
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group form-group-default">
									<label>Họ và tên</label> <input type="text"
										value="<c:out value='${user.hoTen}' />" class="form-control"
										name="HoTen" required="required">
								</div>
							</div>

							<div class="col-sm-6">
								<div class="form-group form-group-default">
									<label>Giới tính</label> <input type="text"
										value="<c:out value='${user.gioiTinh}' />"
										class="form-control" name="GioiTinh" required="required">
								</div>
							</div>

							<div class="col-sm-6">
								<div class="form-group form-group-default">
									<label>Số CCCD</label> <input type="text"
										value="<c:out value='${user.soCCCD}' />" class="form-control"
										name="SoCCCD" required="required">
								</div>
							</div>

							<div class="col-sm-6">
								<div class="form-group form-group-default">
									<label>Số điện thoại:</label> <input type="text"
										value="<c:out value='${user.soDT}' />" class="form-control"
										name="SoDT" required="required">
								</div>
							</div>

							<div class="col-sm-6">
								<div class="form-group form-group-default">
									<label>Ngày Sinh:</label> <input class="form-control"
										value="<c:out value='${user.ngaySinh}' />" type="date"
										id="newNgaySinh" name="newNgaySinh" width="100">
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group form-group-default">
									<label>Email</label> <input type="text"
										value="<c:out value='${user.email}' />" class="form-control"
										name="Email" required="required">
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group form-group-default">
									<label>Địa chỉ</label> <input type="text"
										value="<c:out value='${user.diaChi}' />" class="form-control"
										name="DiaChi" required="required">
								</div>
							</div>

							<div class="col-sm-6">
								<div class="form-group form-group-default">
									<label>Tên ngân hàng</label> <input type="text"
										value="<c:out value='${user.tenNH}' />" class="form-control"
										name="TenNH" required="required">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group form-group-default">
									<label>Số tài khoản</label> <input type="text"
										value="<c:out value='${user.soTK}' />" class="form-control"
										name="SoTK" required="required">
								</div>
							</div>
							<div class="col-md-6 pr-0">
								<div class="form-group form-group-default">
									<label>Loại người dùng</label> <input type="text"
										value="<c:out value='${user.tenLoaiND}' />" class="form-control"
										name="LoaiND" required="required" readonly="readonly" >
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group form-group-default">
									<label>Khoa</label> <input type="text"
										value="<c:out value='${user.tenKhoa}' />" class="form-control"
										name="Khoa" required="required">
								</div>
							</div>

						</div>
						<div style="text-align: center">
						<button type="submit" class="btn btn-outline-primary">Save</button>
						</div>
				</div>

				
				</form>
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
	<!-- Atlantis DEMO methods, don't include it in your project! -->
	<script src="assets/js/setting-demo2.js"></script>
	<script src="assets/js/datetime.js"></script>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

	<!-- Bao gồm DateTimePicker CSS và JS -->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>


	<script>
		$(document)
				.ready(
						function() {
							$("#basic-datatables").DataTable({});

							$("#multi-filter-select")
									.DataTable(
											{
												pageLength : 5,
												initComplete : function() {
													this
															.api()
															.columns()
															.every(
																	function() {
																		var column = this;
																		var select = $(
																				'<select class="form-control"><option value=""></option></select>')
																				.appendTo(
																						$(
																								column
																										.footer())
																								.empty())
																				.on(
																						"change",
																						function() {
																							var val = $.fn.dataTable.util
																									.escapeRegex($(
																											this)
																											.val());

																							column
																									.search(
																											val ? "^"
																													+ val
																													+ "$"
																													: "",
																											true,
																											false)
																									.draw();
																						});

																		column
																				.data()
																				.unique()
																				.sort()
																				.each(
																						function(
																								d,
																								j) {
																							select
																									.append('<option value="' + d + '">'
																											+ d
																											+ "</option>");
																						});
																	});
												},
											});

							// Add Row
							$("#add-row").DataTable({
								pageLength : 5,
							});

							var action = '<td> <div class="form-button-action"> <button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-primary btn-lg" data-original-title="Edit Task"> <i class="fa fa-edit"></i> </button> <button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-danger" data-original-title="Remove"> <i class="fa fa-times"></i> </button> </div> </td>';
						});
	</script>

	<script>
		$(document).ready(function() {
			$('#newNgaySinh').datepicker({
				format : 'mm/dd/yyyy', // Định dạng ngày tháng năm
				autoclose : true
			});
		});
	</script>

	<script>
		function clickme() {
			var text = document.getElementById("newNgaySinh");
			var value = text.value;
			alert(text.value);
		}
	</script>
</body>
</html>
