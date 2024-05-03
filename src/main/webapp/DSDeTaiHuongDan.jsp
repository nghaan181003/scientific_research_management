<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Danh sách đề tài hướng dẫn</title>
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
		<jsp:include page="header.jsp"></jsp:include>
		<!-- Sidebar -->
		<jsp:include page="GiaoVienSideBar.jsp"></jsp:include>
		<!-- End Sidebar -->
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="row">
						<div class="col-12 card mt-4 p-3">
							<div class="form-group">
								<div class="text-center fw-bold">
									<h3 class="fw-bold" for="danh-sach-thanh-vien">Danh sách
										đề tài hướng dẫn</h3>
								</div>

								<div class="row">
									<div class="card col-12">
										<table
											class="table mb-0 align-middle text-center table-fixed px-lg-2 flex-wrap">
											<thead class="bg-primary text-white py-0">
												<tr>
													<th>STT</th>
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Trạng thái</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:set var="stt" scope="session" value="${0}" />
												<c:forEach var="detai" items="${listDeTai}">
													<c:set var="stt" scope="session" value="${stt+1}" />
													<tr class="member-row">
														<td>${stt}</td>
														<td>${detai.getMaDT()}</td>
														<td>${detai.getTenDeTai()}</td>
														<td>${detai.getTrangThai()}</td>

														<td width = 250px;><c:choose>
																<c:when test="${detai.getMaTT() == 2}">
																	<a class="nav-link"
																		href="DeTai?action=ketquanghiemthu&MaDT=<c:out value="${detai.getMaDT()}" />">Xem
																		Kết Quả</a>
																</c:when>
																<c:when test="${detai.getMaTT() == 3}">
																	<a class="nav-link"
																		href="DeTai?action=ChiTiet&MaDT=${detai.getMaDT()}">Xem
																		Chi Tiết</a>
																	<a class="nav-link"
																		href="upload?action=showbaocao&MaDT=${detai.getMaDT()}">Báo
																		Cáo</a>
																</c:when>
																<c:when test="${detai.getMaTT() == 1}">
																	<a class="nav-link"
																		href="DeTai?action=ChiTiet&MaDT=${detai.getMaDT()}">Xem
																		Chi Tiết</a>
																</c:when>
																<c:otherwise>
																	<a /></a>
																</c:otherwise>

															</c:choose></td>

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
