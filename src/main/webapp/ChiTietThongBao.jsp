<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Chi tiết thông báo</title>
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
	<div class="wrapper">
		<div class="main-header">
			<!-- Logo Header -->
				<!-- Sidebar -->
				<!-- End Sidebar -->			
   			<div class="container-fluid">
				<!--  Row 1 -->
				<div class="row">
					<div class="col-lg-12" style=" height: 800px;">
						<div class="card w-90">
						<div class="row p-5 text-center">
										<div class="col-sm-6">
											<p class="mb-0 fw-bolder">TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT</p>
											<p class="mb-0 fw-bolder">THÀNH PHỐ HỒ CHÍ MINH</p>
										</div>
										<div class="col-sm-6 ">
											<p class="text-muted mb-0 fw-bolder">CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</p>
											<p class="text-muted mb-0 fw-bolder">Độc lập - Tự do - Hạnh phúc</p>
										</div>
									</div>
									
									<div >
										
										<h2 style="text-align: center; font-weight: bold; font-size: 30px"><c:out value="${thongBao.getTieuDe()}" /></h2>
									</div>
								
									<div style="margin-left: 150px; margin-right:100px">
										<p style=" margin-left: 10px; margin-top: 40px; font-size: 17px">Nội dung thông báo:</p>
										<h6 style=" margin-left: 50px"><c:out value="${thongBao.getNoiDung()}" /></h6>
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
