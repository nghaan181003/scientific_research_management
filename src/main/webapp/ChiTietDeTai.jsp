<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Chi tiết đề tài</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- Fonts and icons -->
<script src="assets/js/plugin/webfont/webfont.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
	WebFont.load({
		google : {
			families : [ "Lato:300,400,700,900" ],
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
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="row">
						<div class="container">
							<div class="card p-5">
								<form action="/action_page.php" method="post">
									<div class="row">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ten-de-tai">Tên đề tài:</label>
											</div>
										</div>
										<div class="col-sm-9">
											<div class="form-group text-wrap">
												<c:out value="${deTai.getTenDeTai()}" />
											</div>
										</div>
										<%-- 	<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-dang-ky">Ngày đăng ký:</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-dang-ky"><c:out
														value="${deTai.StringGetDot()}" /></label>
											</div>
										</div> --%>
									</div>
									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label>Nhóm thực hiện</label>
											</div>
										</div>

										<div class="col-sm-3">
											<div class="form-group">
												<c:out value="${deTai.getMaNhom()}" />
											</div>
										</div>


									</div>

									<div class="row mt-4">


										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han">Kinh phí dự trù:</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<c:out value="${deTai.getKinhPhi()}" />
											</div>
										</div>
									</div>

									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han">Giáo viên hướng dẫn:</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han"><c:out
														value="${deTai.getTenGiaoVien()}" /></label>
											</div>
										</div>
									</div>
									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han">Mô tả đề tài</label>
											</div>
										</div>
										<div class="col-sm-9 text-wrap px-4"
											style="text-align: justify;">
											<c:out value="${deTai.getMoTa()}" />

										</div>
									</div>

									<div class="row">
										<div class="col-12 card mt-4 p-3">
											<div class="form-group">
												<div class="text-center fw-bold">
													<h3 class="fw-bold py-2" for="danh-sach-thanh-vien">
														Danh sách thành viên</h3>
												</div>
												<div class="row">
													<div class="card col-12">
														<table
															class="table text-nowrap mb-0 align-middle table-fixed">
															<thead class="bg-primary text-white">
																<tr>
																	<th>STT</th>
																	<th>Mã sinh viên</th>
																	<th>Tên sinh viên</th>
																	<th>Số điện thoại</th>
																	<th>Ghi chú</th>
																</tr>
															</thead>
															<tbody>
																<c:set var="stt" scope="session" value="${0}" />
																<c:forEach var="deTai" items="${listChiTietDeTai}">
																	<c:set var="stt" scope="session" value="${stt+1}" />
																	<tr>
																		<td><c:out value="${stt}" /></td>

																		<td><c:out value="${deTai.getTenDangNhap()}" />
																		</td>

																		<td><c:out value="${deTai.getHoTen()}" /></td>

																		<td><c:out value="${deTai.getSoDT()}" /></td>

																		<td><c:choose>
																				<c:when
																					test="${deTai.getMaTV() == deTai.getMaTrgNhom()}">
																					<input type="radio" name="ghichu" value="ghichu"
																						checked />
																				</c:when>
																				<c:otherwise>
																					<input type="radio" name="ghichu" value="ghichu"
																						disabled />
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

									<fieldset style="border: solid 1px black" class="p-4">
										<legend style="width: 150px; font-size: 18px;">Tài
											liệu đính kèm</legend>
										<div class="card row">
											<div class="col-8">
												<c:forEach var="a" items="${tailieu}">
													<div class="row">
														<div class="attach-file col-1 py-0"
															style="line-height: 14px;">
															<a
																href="download?fid=${a.getMaFile()}&dt=${a.getMaDeTai()}"
																class="p-4 text-center"> <i class="fa fa-file-pdf-o"
																style="font-size: 18px; color: red; display: block;"></i>
															</a>
														</div>
														<div class="col-10" style="padding: 12px;">
															<label>${a.getTenFile()}</label>
														</div>
													</div>
												</c:forEach>



											</div>
										</div>
									</fieldset>
								</form>
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

	<script src="./approval-topic.js"></script>
</body>
</html>
