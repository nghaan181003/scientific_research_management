<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Model.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Nghiệm thu đề tài</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	<%
	User user = (User) session.getAttribute("user");
	%>
	<div class="wrapper">
		<!-- Header -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- Sidebar -->
		<jsp:include page="QuanLySideBar.jsp"></jsp:include>
		<!-- End Sidebar -->
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="row">
						<div class="container">
							<div class="card p-5">
								<div class="row text-center">
									<div class="col-12 mb-4">
										<h1 class="fw-bold">Nghiệm thu đề tài</h1>
									</div>
								</div>
								<form
									action="DeTai?action=nghiemthudetai&MaDT=<c:out
														value="${detai.getMaDT()}" />"
									method="post">
									<div class="row">
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ten-de-tai">Tên đề tài:</label>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label for="ten-de-tai"><c:out
														value="${detai.getTenDeTai()}" /></label>
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
												<label><c:out value="${detai.getMaNhom()}" /></label>
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
												<label for="ngay-het-han"><c:out
														value="${detai.getMoTa()}" /></label>
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
												<label for="ngay-het-han"><c:out
														value="${detai.getTenGiaoVien()}" /></label>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-12 card mt-4 p-3">
											<div class="form-group">
												<div class="text-center fw-bold">
													<h3 class="fw-bold py-2" for="danh-sach-thanh-vien">Danh
														sách thành viên</h3>
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
																<c:forEach var="thanhvien" items="${listThanhVien}">
																	<c:set var="stt" scope="session" value="${stt+1}" />
																	<tr>
																		<td><c:out value="${stt}" /></td>

																		<td><c:out value="${thanhvien.getTenDangNhap()}" />
																		</td>

																		<td><c:out value="${thanhvien.getHoTen()}" /></td>

																		<td><c:out value="${thanhvien.getSoDT()}" /></td>

																		<td><c:choose>
																				<c:when
																					test="${thanhvien.getTenDangNhap() == thanhvien.getMaTrgNhom()}">
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
									<div class="card row">
										<div class="col-12 p-2">
											<fieldset style="border: solid 1px black" class="px-4">
										<legend style="width: 150px; font-size: 18px;">Tài
											liệu đính kèm</legend>
										<div class="card row">
											<div class="col-8">
												<c:forEach var="a" items="${tailieu}">
													<div class="row">
														<div class="attach-file col-10 px-4 py-2"
															style="line-height: 14px;">
															<a
																href="download?fid=${a.getMaFile()}&dt=${a.getMaDeTai()}"
																class="p-2 text-center row"> <i class="fa fa-file-pdf-o col-2"
																style="font-size: 18px; color: red; display: block;"></i>
																
																<div class="col-4">${a.getTenFile()}</div>
														
															</a>
														</div>
														
													</div>
												</c:forEach>
											</div>
										</div>
									</fieldset>
										</div>
									</div>

									<div class="row mt-4">
										<div class="col-sm-3">
											<div class="form-group">
												<h4 class="fw-bold" for="ngay-het-han">Tiêu chí nghiệm
													thu</h4>
											</div>
										</div>
									</div>
									<c:set var="i" scope="session" value="${0}" />
									<c:forEach var="tieuchi" items="${listTieuChi}">
										<c:set var="i" scope="session" value="${i+1}" />
										<div class="row mt-4">
											<div class="col-sm-3">
												<div class="form-group">
													<label><c:out value="${tieuchi.getTenTC()}" /></label>
												</div>
											</div>
											<div class="col-9">
												<textarea style="resize: none;" class="form-control"
													name="NhanXet<c:out value = "${i}"/>" rows="3" cols="80"
													required></textarea>
											</div>
										</div>
									</c:forEach>


									<div class="row pt-4">
										<div class="form-group col-2 mx-3">
											<label>Kết quả</label>
										</div>
										<div class="col-9">
											<div class="row">
												<div class="col-3 pt-2">
													<input type="radio" name="KetQua" value="Dat"> <label>Đạt</label>
												</div>
												<div class="col-3 pt-2">
													<input type="radio" name="KetQua" value="Khong Dat">
													<label>Không đạt</label>
												</div>

											</div>
										</div>
									</div>
									<div class="row mt-4">
										<div class="col-sm-6">
											<button type="button" class="btn btn-primary">Hủy</button>
											<button type="submit" class="btn btn-primary  mx-3">Hoàn
												tất</button>
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
	<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script
		src="assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
	<!-- jQuery Scrollbar -->
	<script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<!-- Datatables -->
	<script src="assets/js/plugin/datatables/datatables.min.js"></script>
	<!-- Atlantis JS -->
	<script src="assets/js/atlantis.min.js"></script>
</body>
</html>
