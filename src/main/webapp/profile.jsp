<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="Model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Thông tin cá nhân</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />

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
<link rel="stylesheet" href="assets/css/ThongBao.css" />
</head>
<body>
	<% User user = (User) session.getAttribute("user"); %>
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
         <div class="container-fluid" style="padding-top:90px;">
				<!--  Row 1 -->
				<div class="row">
					<section>
						<div class="container py-5 card" style=" margin-left: 270px">
							<div class="row">
								<div class="col-lg-4">
									<div class="card mb-4">
										<div class="card-body text-center">
											<img
												src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
												alt="avatar" class="rounded-circle img-fluid"
												style="width: 150px;">
											<h5 class="my-3"><%=user.getHoTen()%></h5>

										</div>
									</div>
									<div class="card mb-4">
										<div class="card-body">
											<div style="text-align: center">
												<h5 class="my-3">Thông tin khóa học</h5>
											</div>
											<hr>

											<div class="row">
												<div class="col-sm-6">
													<p class="mb-0">Khoa</p>
												</div>
												<div class="col-sm-6">
													<p class="text-muted mb-0"><%=user.getTenKhoa()%></p>
												</div>
											</div>
											<hr>

						
										</div>
									</div>
								</div>
								<div class="col-lg-8">
									<div class="card mb-4">
										<div class="card-body">
											<div style="text-align: center">
												<h5 class="my-3">Thông tin sinh viên</h5>
											</div>
											<div class="row">
												<div class="col-sm-5">
													<p class="mb-0">Mã số sinh viên</p>
												</div>
												<div class="col-sm-7">
													<p class="text-muted mb-0"><%=user.getTenDangNhap()%></p>
												</div>
											</div>
											<hr>

											<div class="row">
												<div class="col-sm-5">
													<p class="mb-0">Họ và tên</p>
												</div>
												<div class="col-sm-7">
													<p class="text-muted mb-0"><%=user.getHoTen()%></p>
												</div>
											</div>
											<hr>

											<div class="row">
												<div class="col-sm-5">
													<p class="mb-0">Ngày sinh</p>
												</div>
												<div class="col-sm-7">
													<p class="text-muted mb-0"><%=user.getNgaySinh()%></p>
												</div>
											</div>
											<hr>

											<div class="row">
												<div class="col-sm-5">
													<p class="mb-0">Giới tính</p>
												</div>
												<div class="col-sm-7">
													<p class="text-muted mb-0"><%=user.getGioiTinh()%></p>
												</div>
											</div>
											<hr>

											<div class="row">
												<div class="col-sm-5">
													<p class="mb-0">Số CCCD</p>
												</div>
												<div class="col-sm-7">
													<p class="text-muted mb-0"><%=user.getSoCCCD()%></p>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="card mb-4 mb-md-0">
												<div class="card-body">
													<div style="text-align: center">
														<h5 class="my-3">Thông tin liên hệ</h5>
													</div>
													<div class="row">
														<div class="col-sm-6">
															<p class="mb-0">Số điện thoại</p>
														</div>
														<div class="col-sm-6">
															<p class="text-muted mb-0"><%=user.getSoDT()%></p>
														</div>
													</div>
													<hr>

													<div class="row">
														<div class="col-sm-6">
															<p class="mb-0">Email</p>
														</div>
														<div class="col-sm-6">
															<p class="text-muted mb-0"><%=user.getEmail()%></p>
														</div>
													</div>
													<hr>

													<div class="row">
														<div class="col-sm-6">
															<p class="mb-0">Địa chỉ</p>
														</div>
														<div class="col-sm-6">
															<p class="text-muted mb-0"><%=user.getDiaChi()%></p>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="card mb-4 mb-md-0">
												<div class="card-body">
													<div style="text-align: center">
														<h5 class="my-3">Thông tin tài khoản ngân hàng</h5>
													</div>
													<div class="row">
														<div class="col-sm-6">
															<p class="mb-0">Số tài khoản</p>
														</div>
														<div class="col-sm-6">
															<p class="text-muted mb-0"><%=user.getSoTK()%></p>
														</div>
													</div>
													<hr>

													<div class="row">
														<div class="col-sm-6">
															<p class="mb-0">Tên ngân hàng</p>
														</div>
														<div class="col-sm-6">
															<p class="text-muted mb-0"><%=user.getTenNH()%></p>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>
	</div>
	<!--   Core JS Files   -->
	<script src="assets/js/core/jquery.3.2.1.min.js"></script>
	<script src="assets/js/core/popper.min.js"></script>
	<script src="assets/js/core/bootstrap.min.js"></script>
	<!-- jQuery UI -->
	<script
		src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script
		src="assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
	<!-- jQuery Scrollbar -->
	<script
		src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<!-- Datatables -->
	<script src="assets/js/plugin/datatables/datatables.min.js"></script>
	<!-- Atlantis JS -->
	<script src="assets/js/atlantis.min.js"></script>
	<!-- Atlantis DEMO methods, don't include it in your project! -->
	<script src="assets/js/setting-demo2.js"></script>
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

							$("#addRowButton")
									.click(
											function() {
												$("#add-row")
														.dataTable()
														.fnAddData(
																[
																		$(
																				"#addName")
																				.val(),
																		$(
																				"#addPosition")
																				.val(),
																		$(
																				"#addOffice")
																				.val(),
																		action, ]);
												$("#addRowModal").modal("hide");
											});
						});
	</script>

</body>
</html>
