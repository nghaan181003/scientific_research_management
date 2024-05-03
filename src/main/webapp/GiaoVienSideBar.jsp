<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Sidebar -->
<div class="sidebar sidebar-style-2">
	<div class="sidebar-wrapper scrollbar scrollbar-inner">
		<div class="sidebar-content">
			<ul class="nav nav-primary">
				<li class="nav-item active"><a data-toggle="collapse"
					href="#dashboard" class="collapsed" aria-expanded="false"
					style="background: #09274e !important;"> <i class="fas fa-home"></i>
						<p>Dashboard</p>
				</a></li>

				<ul class="nav nav-primary">
					<li class="nav-item"><a data-toggle="collapse" href="#tables">
							<i class="fa-solid fa-bell"></i>
							<p>Thông báo</p> <span class="caret"></span>
					</a>
						<div class="collapse" id="tables">
							<ul>
								<li><a href="ThongBao?action=danhsach"> <span
										class="sub-item">Xem thông báo</span>
								</a></li>
								<li><a href="ThongBao?action=tao"> <span
										class="sub-item">Tạo thông báo</span>
								</a></li>
							</ul>
						</div></li>
				</ul>

				<li class="nav-item"><a href="DeTai?action=dexuat"> <i
						class="fa-solid fa-feather"></i>
						<p>Đề xuất đề tài</p>
				</a></li>

				<li class="nav-item"><a href="DeTai?action=huongdan"> <i
						class="fa-solid fa-list"></i>
						<p>Đề tài hướng dẫn</p>
				</a></li>
			</ul>


		</div>
	</div>
</div>
<!-- End Sidebar -->