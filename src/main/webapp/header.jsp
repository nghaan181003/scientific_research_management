<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.User"%>
<%
User user = (User) session.getAttribute("user");
%>
<div class="main-header">
	<!-- Logo Header -->
	<div class="logo-header" data-background-color="blue"
		style="background: #09274e !important;">
		<a href="index.html" class="logo"> <img src="assets/img/logo.svg"
			alt="navbar brand" class="navbar-brand" />
		</a>
		<button class="navbar-toggler sidenav-toggler ml-auto" type="button"
			data-toggle="collapse" data-target="collapse" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"> <i class="icon-menu"></i>
			</span>
		</button>
		<button class="topbar-toggler more">
			<i class="icon-options-vertical"></i>
		</button>
		<div class="nav-toggle">
			<button class="btn btn-toggle toggle-sidebar">
				<i class="icon-menu"></i>
			</button>
		</div>
	</div>
	<!-- End Logo Header -->

	<!-- Navbar Header -->
	<nav class="navbar navbar-header navbar-expand-lg"
		data-background-color="blue2" style="background: #09274e !important;">
		<div class="container-fluid">
			<div class="collapse" id="search-nav"></div>
			<ul class="navbar-nav topbar-nav ml-md-auto align-items-center">
				<h5 style="margin-right: 10px; margin-top: 10px;" class="text-white">
					Xin chào,
					<%=user.getHoTen()%></h5>
				<li class="nav-item dropdown hidden-caret"><a
					class="dropdown-toggle profile-pic" data-toggle="dropdown" href="#"
					aria-expanded="false">
						<div class="avatar-sm">
							<img src="assets/img/profile.jpg" alt="..."
								class="avatar-img rounded-circle" />
						</div>
				</a>
					<ul class="dropdown-menu dropdown-user animated fadeIn">
						<div class="dropdown-user-scroll scrollbar-outer">
							<li>

								<div class="user-box">
									<div class="avatar-lg">

										<img src="assets/img/profile.jpg" alt="image profile"
											class="avatar-img rounded" />
									</div>
									<div class="u-text">
										<h4><%=user.getTenLoaiND()%></h4>
										<p class="text-muted"><%=user.getHoTen()%></p>
										<div class="row">
											<div class="col-sm-6">
												<a href="profile.jsp"
													class="btn btn-xs btn-secondary btn-sm">View Profile</a>
											</div>
											<div class="col-sm-6">
												<a href="login.jsp" class="btn btn-xs btn-secondary btn-sm"
													style="background: #ffffff !important; color: #6861ce">Đăng
													xuất</a>
											</div>
										</div>


									</div>
								</div>
							</li>
						</div>
					</ul></li>
			</ul>
		</div>
	</nav>
	<!-- End Navbar -->
</div>
