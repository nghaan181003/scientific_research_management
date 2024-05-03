<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="Model.User" %>
<!DOCTYPE html>
<html lang="en" style="font-family: 'Open Sans', sans-serif;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Đề xuất đề tài</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Fonts and icons -->
<script src="assets/js/plugin/webfont/webfont.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap"
	rel="stylesheet">
<!-- CSS Files -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="assets/css/atlantis.min.css" />
</head>
<body>
	<% User user = (User) session.getAttribute("user"); %>
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<!-- Sidebar -->
		<jsp:include page="GiaoVienSideBar.jsp"></jsp:include>
		<!-- End Sidebar -->
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="row">
						<div class="container">
							<div class="card p-5">
								<div class="row p-2 text-center">
									<h1 class="col-12 text-center fw-bold">Đề xuất đề tài</h1>
								</div>
								<form class="mt-2" action="DeTai?action=themdexuat"
									method="post">
									<div class="row">
										<div class="col-3">
											<div class="form-group">
												<label for="ten-de-tai">Tên đề tài:</label>
											</div>
										</div>
										<div class="col-9">
											<div class="form-group">
												<input type="text" size="85" class="p-2" name="TenDeTai"
													placeholder="Nhập tên đề tài"
													style="resize: none; padding: 10px; font-family: -apple-system, BlinkMacSystemFont,"
													Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple
													ColorEmoji","SegoeUIEmoji","SegoeUISymbol","NotoColorEmoji"">
											</div>
										</div>

									</div>
									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label>Lĩnh vực</label>
											</div>
										</div>

										<c:forEach var="linhvuc" items="${listLinhVuc}">
											<div class="col-sm-3">
												<div class="form-group">
													<input type="radio" name="MaLV"
														value=<c:out
															value="${linhvuc.getMaLV()}" />>
														<label
														class="ml-2"><c:out
															value="${linhvuc.getTenLinhVuc()}" /></label>
												</div>
											</div>
										</c:forEach>
									</div>



									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han">Mô tả đề tài</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<textarea name="MoTa" required id="" cols="85" rows="5"
													style="resize: none; padding: 10px; font-family: -apple-system, BlinkMacSystemFont,"
													Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple
													ColorEmoji","SegoeUIEmoji","SegoeUISymbol","NotoColorEmoji""></textarea>
											</div>
										</div>
									</div>

									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han">Kinh phí dự trù</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<input type="text" class="p-2" size="30" name="KinhPhi"
													placeholder="Nhập kinh phí dự trù">
											</div>
										</div>
										<div class="form-group">
											<label for="ngay-het-han" style="margin: 10px 30px;">vnđ</label>
										</div>
									</div>
							</div>


							<div class="row mt-4">
								<div class="col-sm-6">
									<button type="button" class="btn btn-primary">Hủy</button>
									<button type="submit" class="btn btn-primary  mx-3"
										data-toggle="modal" data-target="#exampleModal">Gửi</button>
								</div>
							</div>
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="icon">
						<i class="fas fa-check-circle bg-success"></i>
					</div>
					Đăng ký đề tài thành công. Vui lòng chờ duyệt.
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>

				</div>
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

	<script src="assets/js/proposal-topic.js"></script>
</body>
</html>


