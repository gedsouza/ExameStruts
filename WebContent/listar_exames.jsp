<!-- - var navbarShadow = true-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Exames</title>
<link rel="apple-touch-icon"
	href="app-assets/images/ico/apple-icon-120.png">
<link rel="shortcut icon" type="image/x-icon"
	href="app-assets/images/ico/favicon.ico">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css" href="app-assets/css/vendors.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/extensions/unslider.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/weather-icons/climacons.min.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/meteocons/style.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/vendors/css/charts/morris.css">
<!-- END VENDOR CSS-->
<!-- BEGIN STACK CSS-->
<link rel="stylesheet" type="text/css" href="app-assets/css/app.css">
<!-- END STACK CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/menu/menu-types/vertical-menu.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/colors/palette-gradient.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/fonts/simple-line-icons/style.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/core/colors/palette-gradient.css">
<link rel="stylesheet" type="text/css"
	href="app-assets/css/pages/timeline.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css"
	href="../../../assets/css/style.css">
<!-- END Custom CSS-->
</head>
<body
	class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar"
	data-open="click" data-menu="vertical-menu" data-col="2-columns">
	<!-- fixed-top-->
	<s:form novalidate="true" theme="simple">
		<nav
			class="header-navbar navbar-expand-md navbar navbar-with-menu fixed-top navbar-semi-light bg-gradient-x-grey-blue">
		<div class="navbar-wrapper">
			<div class="navbar-header">
				<ul class="nav navbar-nav flex-row">
					<li class="nav-item mobile-menu d-md-none mr-auto"><a
						class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i
							class="ft-menu font-large-1"></i></a></li>
							<img class="brand-logo" alt="stack admin logo"
							src="app-assets/images/gallery/doutora.png" style="display: block; margin: 0 auto; margin-top: 10px">
					<li class="nav-item d-md-none"><a
						class="nav-link open-navbar-container" data-toggle="collapse"
						data-target="#navbar-mobile"><i class="fa fa-ellipsis-v"></i></a>
					</li>
				</ul>
			</div>
		</div>
		</nav>
		<!-- ////////////////////////////////////////////////////////////////////////////-->
		<div 
			class="main-menu menu-fixed menu-light menu-accordion menu-shadow"
			data-scroll-to-active="true">
			<div class="main-menu-content">
				<ul class="navigation navigation-main" id="main-menu-navigation"
					data-menu="menu-navigation">
					<li class=" navigation-header"><span>Menu</span><i
						class=" ft-minus" data-toggle="tooltip" data-placement="right"
						data-original-title="General"></i></li>
					<li class=" nav-item"><a href="index.html"><i
							class="ft-activity"></i><span class="menu-title" data-i18n="">Exames</span></a>
						<ul class="menu-content">
							<li class="active"><a class="menu-item"
								href="listaExames">Consulta</a></li>
							<li><a class="menu-item" href="adiciona_exame.jsp">Inclusao</a>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="app-content content">
			<div class="content-wrapper">
				<div class="content-header row"></div>
				<div class="content-body">
					<!--Recent Orders & Monthly Salse -->
					<div class="row match-height">
						<div class="col-xl-16 col-lg-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" style="text-align: center;">Lista de Exames</h4>
									<a class="heading-elements-toggle"><i
										class="fa fa-ellipsis-v font-medium-3"></i></a>
									<div class="heading-elements">
										<ul class="list-inline mb-0">
											<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
											<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
										</ul>
									</div>
								</div>
								<div class="card-content">
									<div class="table-responsive">
										<table id="recent-orders"
											class="table table-hover mb-0 ps-container ps-theme-default">
											<thead>
												<tr>
												    <th>Excluir</th>
												    <th>Editar</th>
													<th>Nome</th>
													<th>CPF</th>
													<th>Telefone</th>
													<th>Endereço</th>
													<th>Email</th>
													<th>Exame</th>
													<th>Data</th>
												</tr>
											</thead>
											<tbody>
												<s:iterator value="exames">
												<tr>
													<s:form novalidate="true" theme="simple"
														action="listaExames" namespace="/Exames">
														<td><s:url id="deleteURL" action="excluirExames">
															<s:param name="id" value="%{id}"></s:param>
															</s:url>
								                		<s:a href="%{deleteURL}" class="confirmation"><img class="confirmacao" src="app-assets/images/delete.png" align="middle" alt="Excluir" style="margin-top: 7px"></s:a> </td>
								                		<td><s:url id="atualizaURL" action="buscarExame">
																<s:param name="id" value="%{id}"></s:param>
															</s:url>
								                		<s:a href="%{atualizaURL}"><img src="app-assets/images/edit.jpeg" align="middle" alt="Editar"></s:a> </td>
														<td><s:property value="nome" /></td>
														<td><s:property value="cpf" /></td>
														<td><s:property value="telefone" /></td>
														<td><s:property value="endereco" /></td>
														<td><s:property value="email" /></td>
														<td><s:property value="tpExame" /></td>
														<td><s:property value="data" /></td>
													</s:form>
												</tr>
											</s:iterator>          
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
		
		<script type="text/javascript">
		    var elems = document.getElementsByClassName('confirmacao');
		    var confirmIt = function (e) {
		        if (!confirm('Deseja realmente excluir este registro?')) e.preventDefault();
		    };
		    for (var i = 0, l = elems.length; i < l; i++) {
		        elems[i].addEventListener('click', confirmIt, false);
		    }
		    
		
		</script>
		<!-- BEGIN VENDOR JS-->
		<script src="app-assets/vendors/js/vendors.min.js"
			type="text/javascript"></script>
		<!-- BEGIN VENDOR JS-->
		 <script src="app-assets/js/jquery.js" type="text/javascript"></script> 
		<!-- BEGIN PAGE VENDOR JS-->
		<script src="app-assets/vendors/js/charts/raphael-min.js"
			type="text/javascript"></script>
		<script src="app-assets/vendors/js/charts/morris.min.js"
			type="text/javascript"></script>
		<script src="app-assets/vendors/js/extensions/unslider-min.js"
			type="text/javascript"></script>
		<script src="app-assets/vendors/js/timeline/horizontal-timeline.js"
			type="text/javascript"></script>
		<!-- END PAGE VENDOR JS-->
		<!-- BEGIN STACK JS-->
		<script src="app-assets/js/core/app-menu.js" type="text/javascript"></script>
		<script src="app-assets/js/core/app.js" type="text/javascript"></script>
		<script src="app-assets/js/scripts/customizer.js"
			type="text/javascript"></script>
		<!-- END STACK JS-->
		<!-- BEGIN PAGE LEVEL JS-->
		<script src="app-assets/js/scripts/pages/dashboard-ecommerce.js"
			type="text/javascript"></script>
		<!-- END PAGE LEVEL JS-->
	</s:form>
</body>
</html>