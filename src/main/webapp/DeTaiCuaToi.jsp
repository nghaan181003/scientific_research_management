<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Đề tài của tôi</title>
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
<link rel="stylesheet" href="assets/css/ThongBao.css" />
</head>
<body>
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<!-- Sidebar -->
		<jsp:include page="SinhVienSideBar.jsp"></jsp:include>
		<!-- End Sidebar -->

		<!-- Danh sach de tai -->
		<div class="col-lg-8 d-flex align-items-stretch"
			style="margin-left: 300px">
			<div class="card w-100" style="margin-top: 50px">
				<div class="card-body p-4">
					<h3 style="text-align: center"
						class="card-title fw-semibold mb-4 mt-5" style="margin-top: 200px">Đề
						tài của tôi</h3>
					<div class="table-responsive" color:white">
						<table class="table text-nowrap mb-0 align-middle">
							<thead class="text-dark fs-4">
								<tr>
									<th class="border-bottom-0">
										<h6 class="fw-semibold mb-0">STT</h6>
									</th>
									<th class="border-bottom-0">
										<h6 class="fw-semibold mb-0">Mã đề tài</h6>
									</th>
									<th class="border-bottom-0">
										<h6 class="fw-semibold mb-0">Tên đề tài</h6>
									</th>
									<th class="border-bottom-0">
										<h6 class="fw-semibold mb-0">Trạng thái</h6>
									</th>
									<th class="border-bottom-0"></th>
								</tr>
							</thead>
							<tbody>
								<c:set var="stt" scope="session" value="${0}" />
								<c:forEach var="deTai" items="${listDeTai}">
									<c:set var="stt" scope="session" value="${stt+1}" />
									<tr>
										<td><c:out value="${stt}" /></td>

										<td><c:out value="${deTai.getMaDT()}" /></td>

										<td><c:out value="${deTai.getTenDeTai()}" /></td>

										<td><c:out value="${deTai.getTrangThai()}" /></td>

										<td><c:choose>
												<c:when test="${deTai.getMaTT() == 2}">
													<a
														href="DeTai?action=ketquanghiemthu&MaDT=<c:out value="${deTai.getMaDT()}" />">Xem Kết Quả</a>
												</c:when>
												<c:when test="${deTai.getMaTT() == 3}">
													<a
														href="DeTai?action=ChiTiet&MaDT=<c:out value="${deTai.getMaDT()}" />">Xem Chi Tiết</a>
												</c:when>
												<c:otherwise>
													<a/></a>
												</c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
								<!-- } -->
							</tbody>
						</table>
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
