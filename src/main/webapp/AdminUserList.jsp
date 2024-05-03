<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="Model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Quản lý người dùng</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
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
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<!-- Sidebar -->
		<jsp:include page="AdminSideBar.jsp"></jsp:include>
		<!-- End Sidebar -->
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="d-flex align-items-center">
										<h4 class="card-title">Danh sách người dùng hệ thống</h4>
										<!-- Nút Thêm -->
										<button class="btn btn-primary btn-round ml-auto"
											data-toggle="modal" data-target="#addRowModal">
											<i class="fa fa-plus"></i> Thêm người dùng
										</button>
									</div>
								</div>
								<div class="card-body">
									<!-- Modal -->
									<div class="modal fade" id="addRowModal" tabindex="-1"
										role="dialog" aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header no-bd">
													<h5 class="modal-title" style="margin-left: 170px;">Thêm người dùng</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<form action="NguoiDung?action=Them" method="post"
														accept-charset="UTF-8">
														<div class="row">
															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Tên đăng nhập</label> <input id="addId"
																		type="text" class="form-control"
																		placeholder="Nhập tên đăng nhập" name="newUserName" />
																</div>
															</div>

															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Mật khẩu</label> <input id="addPassword"
																		type="text" class="form-control"
																		placeholder="Nhập mật khẩu" name="newPassword" />
																</div>
															</div>

															<div class="col-sm-12">
																<div class="form-group form-group-default">
																	<label>Họ và tên</label> <input id="addName"
																		type="text" class="form-control"
																		placeholder="Nhập họ tên" name="newName" required />
																</div>
															</div>

															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Giới tính</label> <input id="addGioiTinh"
																		type="text" class="form-control"
																		placeholder="Nhập giới tính" name="newGioiTinh" />
																</div>
															</div>

															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Số CCCD</label> <input id="addSoCCCD"
																		type="text" class="form-control"
																		placeholder="Nhập Số CCCD" name="newSoCCCD" required />
																</div>
															</div>

															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Số điện thoại:</label> <input id="addSoDT"
																		type="text" class="form-control"
																		placeholder="Nhập số điện thoại" name="newSoDT" />
																</div>
															</div>

															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Ngày Sinh:</label> <input class="form-control"
																		placeholder="Chọn ngày sinh" type="text"
																		id="newNgaySinh" name="newNgaySinh" width="100">
																</div>
															</div>

															<div class="col-sm-12">
																<div class="form-group form-group-default">
																	<label>Email</label> <input id="addEmail" type="text"
																		class="form-control" placeholder="Nhập email"
																		name="newEmail" />
																</div>
															</div>

															<div class="col-sm-12">
																<div class="form-group form-group-default">
																	<label>Địa chỉ</label> <input id="addDiaChi"
																		type="text" class="form-control"
																		placeholder="Nhập địa chỉ" name="newDiaChi" />
																</div>
															</div>

															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Tên ngân hàng</label> <input id="addTenNH"
																		type="text" class="form-control"
																		placeholder="Nhập ngân hàng" name="newTenNH" />
																</div>
															</div>
															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Số tài khoản</label> <input id="addSoTK"
																		type="text" class="form-control"
																		placeholder="Nhập STK" name="newSoTK" />
																</div>
															</div>
															<div class="col-md-6 pr-0">
																<div class="form-group form-group-default">
																	<label>Vai trò</label> <select name="newRole"
																		class="form-control form-control-sm">
																		<c:forEach var="r" items="${listRoles}">
																			<option value="${r.getMaLoaiND()}">${r.getTenLoaiND()}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group form-group-default">
																	<label>Khoa</label> <select name="newFac"
																		class="form-control form-control-sm">
																		<c:forEach var="fac" items="${listFacs}">
																			<option value="${fac.getId()}">${fac.getTenKhoa()}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
														</div>
														<button type="submit" id="addRowButton"
															class="btn btn-primary">Add</button>
													</form>
												</div>
											</div>
										</div>
									</div>
											<!--End Modal  -->

									<div class="table-responsive">
										<table id="add-row" 
											class="display table table-striped table-hover">
											<thead>
												<tr>
													<th>Tên đăng nhập</th>
													<th>Họ và Tên</th>
													<th>Mật khẩu</th>
													<th>Loại ND</th>
													
													<th style="width: 10%">Hành động</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="User" items="${listUser}">
													<tr>
														<td>${User.tenDangNhap}</td>
														<td>${User.hoTen}</td>
														<td>${User.matKhau}</td>
														<td>${User.tenLoaiND}</td>
														
														<td>
															<a href="NguoiDung?action=ChinhSua&TenDangNhap=${User.tenDangNhap}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
															
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
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
		function clickme() {
			var text = document.getElementById("newRole");
			var value = text.value;
			alert(text.value);
		}
	</script>
	
	<script>
		$(document).ready(function() {
			$('#newNgaySinh').datepicker({
				format : 'dd/mm/yyyy', // Định dạng ngày tháng năm
				autoclose : true
			});
		});
	</script>
	
</body>
</html>
