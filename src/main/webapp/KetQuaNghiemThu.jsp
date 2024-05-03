<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="Model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Kết quả nghiệm thu</title>
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
	
		<!-- End Sidebar -->
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="row">
						<div class="container">
							<div class="card p-5">
								<div class="row text-center">
									<div class="col-12 mb-4">
										<h1 class="fw-bold">Kết quả nghiệm thu</h1>
									</div>
								</div>
								<form
									action="DeTai?action=detaicuatoi"
									method="post">
									<div class="row">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ten-de-tai">Tên đề tài:</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ten-de-tai"> <c:out
														value="${ketQuaNT.getTenDeTai()}" />
												</label>
											</div>
										</div>

									</div>

									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han">Mô tả đề tài</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han"> <c:out
														value="${ketQuaNT.getMoTa()}" />
												</label>
											</div>
										</div>
									</div>
									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label>Nhóm thực hiện</label>
											</div>
										</div>

										<div class="col-sm-3">
											<div class="form-group">
												<label> <c:out value="${ketQuaNT.getMaNhom()}" />
												</label>
											</div>
										</div>


									</div>

									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han">Giảng viên hướng dẫn</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han"> <c:out
														value="${ketQuaNT.getTenGV()}" />
												</label>
											</div>
										</div>
									</div>

									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ngay-het-han">Nhận xét theo tiêu chí</label>
											</div>
										</div>
									</div>


									<c:set var="i" scope="session" value="${0}" />
									<c:forEach var="tieuchi" items="${lstKetQuaNT}">
										<c:set var="i" scope="session" value="${i+1}" />
										<div class="row mt-4">
											<div class="col-sm-3">
												<div class="form-group">
													<label> <c:out value="${tieuchi.getTenTC()}" />
													</label>
												</div>
											</div>
											<div class="col-9">
												<label> <c:out value="${tieuchi.getNhanXet()}" />
												</label>
											</div>
										</div>
									</c:forEach>

									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="">Kết quả nghiệm thu</label>
											</div>
										</div>
										<div class="col-sm-3">
												<label for=""><c:out
														value="${ketQuaNT.getKetQua()}" />
												</label>
										</div>
									</div>

									<div class="row mt-4">
										<div class="col-sm-6">
											
											<button type="submit" class="btn btn-primary  mx-3">Xong</button>
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
</body>
</html>
