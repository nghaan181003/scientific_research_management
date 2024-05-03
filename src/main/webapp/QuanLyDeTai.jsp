<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
response.setContentType("text/html");
response.setCharacterEncoding("UTF-8");
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset='utf-8'>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Quản lý đề tài</title>
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
		<jsp:include page="QuanLySideBar.jsp"></jsp:include>
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="d-flex align-items-center">
										<h4 class="card-title">Danh sách đề tài</h4>

										<!-- Nút Thêm -->
										<button class="btn btn-primary btn-round ml-auto"
											data-toggle="modal" data-target="#addRowModal">
											<i class="fa fa-plus"></i> Thêm đề tài
										</button>
									</div>
									<div class="row">
										<select id="MaTT"
											class="form-control form-control-sm col-3 mt-3"
											onchange="window.location.href=this.value">
											<option value="DeTai?action=TatCa&id=0">Tất cả</option>
											<c:forEach var="tt" items="${listTT}">
												<option value="DeTai?action=TatCa&id=${tt.getMaTT()}">${tt.getTrangThai()}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="card-body">
									<!-- Modal -->
									<div class="modal fade" id="addRowModal" tabindex="-1"
										role="dialog" aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header no-bd">
													<h5 class="modal-title">Thêm đề tài</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<form action="DeTai?action=them" method="post"
														accept-charset="utf-8">
														<div class="row">
															<div class="col-sm-12">
																<div class="form-group form-group-default">
																	<label>Tên đề tài</label> <input type="text"
																		class="form-control" placeholder="Nhập tên đề tài"
																		name="TenDeTai" />
																	<!-- <input name="TenDeTai" class="col" type="text" /> -->
																</div>
															</div>

															<div class="col-sm-12">
																<div class="form-group form-group-default">
																	<label>Mô tả</label>

																	<textarea class="form-control"
																		name="MoTa" rows="3" placeholder="Nhập mô tả" required></textarea>
																	<!-- <input name="TenDeTai" class="col" type="text" /> -->
																</div>
															</div>

															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Lĩnh vực</label> <select name="MaLV"
																		class="form-control form-control-sm">
																		<c:forEach var="r" items="${listLV}">
																			<option value="${r.getMaLV()}">${r.getTenLinhVuc()}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															
															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Kinh phí</label> <input type="text"
																		class="form-control" placeholder="Nhập kinh phí"
																		name="KinhPhi" />
																	<!-- <input name="TenDeTai" class="col" type="text" /> -->
																</div>
															</div>
															
															<div class="col-md-6">
																<div class="form-group form-group-default">
																	<label>Tên giảng viên</label> <select name="MaGV"
																		class="form-control form-control-sm" id="idMaGV">
																		<c:forEach var="fac" items="${listGVs}">
																			<option value="${fac.getTenDangNhap()}">${fac.getHoTen()}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-sm-6">
																<div class="form-group form-group-default">
																	<label>Mã giảng viên</label> <input id="idTenGV"
																		type="text" class="form-control" disabled />
																</div>
															</div>
														</div>
														<button type="submit" id="addRowButton"
															class="btn btn-primary" onclick="clickme()">Add</button>
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
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Lĩnh vực</th>
													<th>GV hướng dẫn</th>
													<th>Trạng thái</th>
													<th></th>
								
												</tr>
											</thead>
											<tbody>
												<c:forEach var="d" items="${listDeTai}">
													<tr>
														<td>${d.getMaDT()}</td>
														<td>${d.getTenDeTai()}</td>
														<td>${d.getLinhVuc()}</td>
														<td>${d.getTenGiaoVien()}</td>
														<td>${d.getTrangThai()}</td>
														<td><a type="button" data-toggle="tooltip" title=""
															class="btn btn-link btn-primary"
															href="upload?action=showupload&MaDT=${d.getMaDT()}">Đề cương</a> <a
															type="button" data-toggle="tooltip" title=""
															class="btn btn-link btn-primary"
															<%-- href="tailieu?MaDT=${d.getMaDT()}" --%>
															href="DeTai?action=ChiTiet&MaDT=${d.getMaDT()}">Xem</a></td>

												
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
	<script>
		var e = document.getElementById("idMaGV");
		var value = e.options[e.selectedIndex].value;// get selected option value
		var i = document.getElementById("idTenGV");
		i.value = value;
		e.onchange = function() {
			value = e.options[e.selectedIndex].value;// get selected option value
			i = document.getElementById("idTenGV");
			i.value = value;
		}
	</script>
</body>
</html>
