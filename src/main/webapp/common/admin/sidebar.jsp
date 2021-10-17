<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try {
            ace.settings.loadState('sidebar')
        } catch (e) {
        }
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->

    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-desktop"></i>
                <span class="menu-text">
								Quản lý bài viết
							</span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
<%--                    class="dropdown-toggle"--%>
                    <a href="<c:url value="/admin-new?page=5&maxPageItem=5"/>" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách bài viết
                        <b class="arrow fa fa-angle-down"></b>
                    </a>
                </li>
                <li class="">
                    <a href="<c:url value="/admin-new"/>" class="dropdown-toggle">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Thêm mới bài viết
                        <b class="arrow fa fa-angle-down"></b>
                    </a>
                </li>

            </ul>
        </li>

        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-desktop"></i>
                <span class="menu-text">
								Quản lý tài khoản
							</span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
                    <%--                    class="dropdown-toggle"--%>
                    <a href="<c:url value="/admin-new?page=1&maxPageItem=2"/>" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách tài khoản
                        <b class="arrow fa fa-angle-down"></b>
                    </a>
                </li>
                <li class="">
                    <a href="<c:url value="/admin-new"/>" class="dropdown-toggle">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Thêm mới tài khoản
                        <b class="arrow fa fa-angle-down"></b>
                    </a>
                </li>

            </ul>
        </li>
    </ul><!-- /.nav-list -->

    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
           data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>