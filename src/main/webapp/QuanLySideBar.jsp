<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="sidebar sidebar-style-2">
	<div class="sidebar-wrapper scrollbar scrollbar-inner">
		<div class="sidebar-content">
			<ul class="nav nav-primary">
				<li class="nav-item active"><a data-toggle="collapse"
					href="#tables" style="background: #09274e !important;"> 
					<i class="fa-solid fa-list-ul"></i>
						<p>Quản lý đề tài</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="tables">
						<ul class="nav nav-collapse">
							<li><a href="DeTai?action=TatCa&id=0"> <span
									class="sub-item">Danh sách đề tài</span>
							</a></li>
							<li><a href="DK?action=list"> <span class="sub-item">Mở
										đợt đăng ký</span>
							</a></li>
							<li><a href="DeTai?action=dsduyetdetai"> <span
									class="sub-item">Duyệt đề tài</span>
							</a></li>
							<li><a href="DeTai?action=danhsachnghiemthudetai"> <span
									class="sub-item ">Nghiệm thu đề tài</span>
							</a></li>
						</ul>
					</div></li>
			</ul>
		</div>
	</div>
</div>