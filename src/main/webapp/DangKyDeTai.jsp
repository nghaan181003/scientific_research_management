<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Đăng Ký Đề Tài</title>
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
	<div class="wrapper">
		<!-- Header -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- Sidebar -->
		<jsp:include page="SinhVienSideBar.jsp"></jsp:include>
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="row">

						<div class="container">

							<div class="card p-5">
								<div class="row p-2 text-center">
									<h1 class="col-12 text-center fw-bold">Đăng ký đề tài</h1>
								</div>
								<form class="mt-2"
									action="DeTai?action=dangkydetai&MaDT=<c:out value="${MaDT}" />"
									method="post">
									<div class="row">
										<div class="col-12 card mt-4 p-3">
											<div class="form-group">
												<div class="text-center fw-bold">
													<h3 class="fw-bold" for="danh-sach-thanh-vien">Danh
														sách thành viên</h3>
												</div>
												<div class="row">
													<div class="card col-12">
														<table
															class="  table mb-0 align-middle text-center table-fixed px-lg-2">
															<thead class=" py-0">
																<tr>
																	<th>STT</th>
																	<th>Mã số sinh viên</th>
																	<!-- <th>Tên sinh viên</th>
																	<th>Số điện thoại</th>
																	<th>E-mail</th> -->
																	<th>Nhóm trưởng</th>
																</tr>
															</thead>
															<tbody>
																<tr class="member-row">
																	<td>1</td>
																	<td><input class="input-border-bottom p-1"
																		id="input1" name="mssv1" size="10"
																		oninput="checkMSSV()"></td>
																	<!-- <td><input class="input-border-bottom p-1"
																		size="25"></td>
																	<td><input class="input-border-bottom p-1"
																		size="15"></td>
																	<td><input class="input-border-bottom p-1"></td> -->
																	<td><input type="radio" onclick="setMaNT()"
																		name="MaTrgNhom" id="1" value=""></td>
																</tr>

															</tbody>
														</table>
													</div>
												</div>
												<div class="row mt-2 align-items-end">
													<button type="button" class="btn btn-outline-primary ml-4 "
														onclick="addRow()">Thêm thành viên</button>
													<button type="button" class="btn btn-outline-danger ml-4  "
														onclick="deleteLastRow()">Xóa thành viên</button>
												</div>
											</div>
										</div>
									</div>
									<div class="row mt-4">
										<div class="col-sm-6">
											<button type="button" class="btn btn-primary">Hủy</button>
											<button type="submit" class="btn btn-primary  mx-3">Đăng
												ký</button>
										</div>
									</div>
								</form>



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
		
	
	<script src="dk.js"></script>
</body>
</html>
