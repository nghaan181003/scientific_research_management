<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ page import="Model.User" %>
			<!DOCTYPE html>
			<html lang="en">

			<head>
				<meta charset='utf-8'>
				<meta http-equiv='X-UA-Compatible' content='IE=edge'>
				<title>Đính kèm tài liệu</title>
				<meta name='viewport' content='width=device-width, initial-scale=1'>
				<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
					integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
					crossorigin="anonymous" referrerpolicy="no-referrer" />
				<!-- Fonts and icons -->
				<script src="assets/js/plugin/webfont/webfont.min.js"></script>
				<script>
					WebFont.load({
						google: {
							families: ["Lato:300,400,700,900"]
						},
						custom: {
							families: ["Flaticon", "Font Awesome 5 Solid",
								"Font Awesome 5 Regular", "Font Awesome 5 Brands",
								"simple-line-icons",],
							urls: ["assets/css/fonts.min.css"],
						},
						active: function () {
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
									<div class="card p-5" style="margin: auto; width: 700px;">
										<h2 class="text-center fw-bold">Upload tài liệu</h2>
										<div class="p-lg-5">
											<form action="upload?action=uploadfile" method="post" enctype="multipart/form-data">
												<div class="row">
												
												<label class="col-3" for="TenDT">Tên đề tài:</label>
												
													<div class="col-8 text-wrap">${deTai.getTenDeTai()}</div>
												</div>
												
												<input type="hidden" id="MaDT" name="MaDT" value="${deTai.getMaDT()}">
												<input class="mt-5" type="file" id="FileDT" name="FileDT">
												<br><br>
												<div style="flex-flow: row;">
													<input type="submit" style="    position: relative;
												left: 210px;
											" class="btn btn-primary mt-5" value="Submit">
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
				<script src="assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
				<!-- jQuery Scrollbar -->
				<script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
				<!-- Datatables -->
				<script src="assets/js/plugin/datatables/datatables.min.js"></script>
				<!-- Atlantis JS -->
				<script src="assets/js/atlantis.min.js"></script>
			</body>

			</html>