<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Domotica</title>
    
        <!-- Bootstrap framework -->
            <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />
            <link rel="stylesheet" href="../bootstrap/css/bootstrap-responsive.min.css" />
        <!-- gebo blue theme-->
            <link rel="stylesheet" href="../css/blue.css" id="link_theme" />
        <!-- breadcrumbs-->
            <link rel="stylesheet" href="../lib/jBreadcrumbs/css/BreadCrumb.css" />
        <!-- tooltips-->
            <link rel="stylesheet" href="../lib/qtip2/jquery.qtip.min.css" />
        <!-- notifications -->
            <link rel="stylesheet" href="../lib/sticky/sticky.css" />    
        <!-- splashy icons -->
            <link rel="stylesheet" href="../img/splashy/splashy.css" />
        <!-- enhanced select -->
            <link rel="stylesheet" href="../lib/chosen/chosen.css" />
	   <!-- colorbox -->
            <link rel="stylesheet" href="../lib/colorbox/colorbox.css" />
        <!-- flags -->	
          <link rel="stylesheet" href="../img/flags/flags.css" />	
        <!-- main styles -->
            <link rel="stylesheet" href="../css/style.css" />
			
            <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=PT+Sans" />
	
        <!-- Favicon -->
            <link rel="shortcut icon" href="favicon.ico" />
		
        <!--[if lte IE 8]>
            <link rel="stylesheet" href="css/ie.css" />
            <script src="js/ie/html5.js"></script>
			<script src="js/ie/respond.min.js"></script>
        <![endif]-->
        <!--Este es para la tabla de los focos -->
		  <link rel="stylesheet" type="text/css" href="../tmp/css/zice.style.css"/>
       
                    <script src="../js/jquery.min.js"></script>
            <script src="../js/jquery-migrate.min.js"></script>
			<!-- smart resize event -->
			<script src="../js/jquery.debouncedresize.min.js"></script>
			<!-- hidden elements width/height -->
			<script src="../js/jquery.actual.min.js"></script>
			<!-- js cookie plugin -->
			<script src="../js/jquery_cookie.min.js"></script>
			<!-- main bootstrap js -->
			<script src="../bootstrap/js/bootstrap.min.js"></script>
               <!-- bootstrap plugins -->
			<script src="../js/bootstrap.plugins.min.js"></script>
			<!-- tooltips -->
			<script src="../lib/qtip2/jquery.qtip.min.js"></script>
			<!-- jBreadcrumbs -->
			<script src="../lib/jBreadcrumbs/js/jquery.jBreadCrumb.1.1.min.js"></script>
			<!-- fix for ios orientation change -->
			<script src="../js/ios-orientationchange-fix.js"></script>
			<!-- scrollbar -->
			<script src="../lib/antiscroll/antiscroll.js"></script>
			<script src="../lib/antiscroll/jquery-mousewheel.js"></script>

			<!-- lightbox -->
            <script src="../lib/colorbox/jquery.colorbox.min.js"></script>
			<!-- mobile nav -->
			<script src="../js/selectNav.js"></script>
            <!-- common functions -->
			<script src="../js/gebo_common.js"></script>
			
			<!-- bootstrap plugins -->
			<script src="../js/bootstrap.plugins.min.js"></script>
			<!-- autosize textareas -->
			<script src="../js/forms/jquery.autosize.min.js"></script>
			<!-- enhanced select -->
			<script src="../lib/chosen/chosen.jquery.min.js"></script>
			<!-- user profile functions -->
			<script src="../js/gebo_user_profile.js"></script>           
                  
                
                        
                        
		<script>
			//* hide all elements & show preloader
			document.documentElement.className += 'js';
		</script>
    </head>
    <body>
		<div id="loading_layer" style="display:none"><img src="../img/ajax_loader.gif" alt="" /></div>
		<div class="style_switcher">
			<div class="sepH_c">
				<p>Colors:</p>
				<div class="clearfix">
					<a href="javascript:void(0)" class="style_item jQclr blue_theme style_active" title="blue">blue</a>
					<a href="javascript:void(0)" class="style_item jQclr dark_theme" title="dark">dark</a>
					<a href="javascript:void(0)" class="style_item jQclr green_theme" title="green">green</a>
					<a href="javascript:void(0)" class="style_item jQclr brown_theme" title="brown">brown</a>
					<a href="javascript:void(0)" class="style_item jQclr eastern_blue_theme" title="eastern_blue">eastern blue</a>
					<a href="javascript:void(0)" class="style_item jQclr tamarillo_theme" title="tamarillo">tamarillo</a>
				</div>
			</div>
			<div class="sepH_c">
				<p>Backgrounds:</p>
				<div class="clearfix">
					<span class="style_item jQptrn style_active ptrn_def" title=""></span>
					<span class="ssw_ptrn_a style_item jQptrn" title="ptrn_a"></span>
					<span class="ssw_ptrn_b style_item jQptrn" title="ptrn_b"></span>
					<span class="ssw_ptrn_c style_item jQptrn" title="ptrn_c"></span>
					<span class="ssw_ptrn_d style_item jQptrn" title="ptrn_d"></span>
					<span class="ssw_ptrn_e style_item jQptrn" title="ptrn_e"></span>
				</div>
			</div>
			<div class="sepH_c">
				<p>Layout:</p>
				<div class="clearfix">
					<label class="radio inline"><input type="radio" name="ssw_layout" id="ssw_layout_fluid" value="" checked /> Fluid</label>
					<label class="radio inline"><input type="radio" name="ssw_layout" id="ssw_layout_fixed" value="gebo-fixed" /> Fixed</label>
				</div>
			</div>
			<div class="sepH_c">
				<p>Sidebar position:</p>
				<div class="clearfix">
					<label class="radio inline"><input type="radio" name="ssw_sidebar" id="ssw_sidebar_left" value="" checked /> Left</label>
					<label class="radio inline"><input type="radio" name="ssw_sidebar" id="ssw_sidebar_right" value="sidebar_right" /> Right</label>
				</div>
			</div>
			<div class="sepH_c">
				<p>Show top menu on:</p>
				<div class="clearfix">
					<label class="radio inline"><input type="radio" name="ssw_menu" id="ssw_menu_click" value="" checked /> Click</label>
					<label class="radio inline"><input type="radio" name="ssw_menu" id="ssw_menu_hover" value="menu_hover" /> Hover</label>
				</div>
			</div>
			
			<div class="gh_button-group">
				<a href="#" id="showCss" class="btn btn-primary btn-mini">Show CSS</a>
				<a href="#" id="resetDefault" class="btn btn-mini">Reset</a>
			</div>
			<div class="hide">
				<ul id="ssw_styles">
					<li class="small ssw_mbColor sepH_a" style="display:none">body {<span class="ssw_mColor sepH_a" style="display:none"> color: #<span></span>;</span> <span class="ssw_bColor" style="display:none">background-color: #<span></span> </span>}</li>
					<li class="small ssw_lColor sepH_a" style="display:none">a { color: #<span></span> }</li>
				</ul>
			</div>
		</div>
		
		<div id="maincontainer" class="clearfix">
		  <!-- header -->
             <!-- header -->
            <header>
                <div class="navbar navbar-fixed-top">
                    <div class="navbar-inner">
                        <div class="container-fluid">
                            <a class="brand" href="dashboard.html"><i class="icon-home icon-white"></i> Domotica </a>
                            <ul class="nav user_menu pull-right">
								<li class="divider-vertical hidden-phone hidden-tablet"></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle nav_condensed" data-toggle="dropdown"><i class="flag-es"></i> <b class="caret"></b></a>
                                    <ul class="dropdown-menu">										
										<li><a href="javascript:void(0)"><i class="flag-es"></i> Español</a></li>
                                                  <li><a href="javascript:void(0)"><i class="flag-en"></i> English</a></li>
                                    </ul>
                                </li>
                                <li class="divider-vertical hidden-phone hidden-tablet"></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="../img/user_avatar.png" alt="" class="user_avatar" /> Usuario <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
										<li><a href="user_profile.html">My Profile</a></li>
										<li class="divider"></li>
										<li><a href="login.html">Log Out</a></li>
                                    </ul>
                                </li>
                            </ul>
							<ul class="nav" id="mobile-nav">
							<li class="dropdown">
                                    <a data-toggle="dropdown" class="dropdown-toggle" href="#"><i class="icon-wrench icon-white"></i> Plugins <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="charts.html">Charts</a></li>
                                        <li><a href="calendar.html">Calendar</a></li>                                     
                                    </ul>
                                   </li>
								<li>
									<a href="documentation.html"><i class="icon-book icon-white"></i> Help</a>
								</li>
							</ul>
                        </div>
                    </div>
                </div>
            </header>
            
            <!-- main content -->
                      <decorator:body />
            
			<!-- sidebar -->
            <a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r" title="Hide Sidebar">Sidebar switch</a>
            <div class="sidebar">				
				<div class="antiScroll">
					<div class="antiscroll-inner">
						<div class="antiscroll-content">					
							<div class="sidebar_inner">
								<form action="search_page.html" class="input-append" method="post" >
									<input autocomplete="off" name="query" class="search_query input-medium" size="16" type="text" placeholder="Search..." /><button type="submit" class="btn"><i class="icon-search"></i></button>
								</form>
								<div id="side_accordion" class="accordion">
									
									<div class="accordion-group">
										<div class="accordion-heading">
											<a href="#collapseOne" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
												<i class="icon-folder-close"></i> Dispositivos
											</a>
										</div>
										<div class="accordion-body collapse" id="collapseOne">
											<div class="accordion-inner">
												<ul class="nav nav-list">
													<li><a href="../dispositivos/dispositivoXBee.jsp">XBee</a></li>
													<li><a href="../dispositivos/dispositivoLuces.jsp">Luces</a></li>
                                                                                                        <li><a href="../dispositivos/dispositivoTomacorrientes.jsp">Tomacorrientes</a></li>
                                                                                                        <li><a href="javascript:void(0)">Otros</a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="accordion-group">
										<div class="accordion-heading">
											<a href="#collapseFour" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
												<i class="icon-cog"></i> Configuration
											</a>
										</div>
										<div class="accordion-body collapse" id="collapseFour">
											<div class="accordion-inner">
												<ul class="nav nav-list">
													<li class="nav-header">People</li>
													<li class="active"><a href="javascript:void(0)">Account Manager</a></li>
                                                                 <li><a href="javascript:void(0)">Role</a></li>
													<li class="nav-header">System</li>
													<li><a href="javascript:void(0)">Site information</a></li>
													<li><a href="javascript:void(0)">Actions</a></li>
                                                                 <li><a href="javascript:void(0)">Devices</a></li>
													<li class="divider"></li>
													<li><a href="javascript:void(0)">Help</a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="accordion-group">
										<div class="accordion-heading">
											<a href="#collapseFive" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
												<i class="icon-leaf"></i> Reports
											</a>
										</div>
										<div class="accordion-body collapse" id="collapseFive">
											<div class="accordion-inner">
												<ul class="nav nav-list">
													<li class="active"><a href="javascript:void(0)">Enery Consumed</a></li>
													<li><a href="javascript:void(0)">Energy Saved</a></li>
                                                                 <li><a href="javascript:void(0)">Energy by Devices</a></li>
													<li><a href="javascript:void(0)">Users Activities</a></li>
                                                                 <li><a href="javascript:void(0)">Raised Events</a></li>
                                                                 <li class="divider"></li>
													<li><a href="javascript:void(0)">Errors</a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
								
								<div class="push"></div>
							</div>							   						
						</div>
					</div>
				</div>			
             </div>
			

			
			<script>
				$(document).ready(function() {
					//* show all elements & remove preloader
					setTimeout('$("html").removeClass("js")',1000);
				});
			</script>
		
		</div>
	</body>
</html>


