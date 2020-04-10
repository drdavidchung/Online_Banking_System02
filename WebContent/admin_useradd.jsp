<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用戶管理</a><span class="crumb-step">&gt;</span><span>新增用戶</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/MonkeyShop/manage/admin_douseradd" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120"><i class="require-red">*</i>分类：</th>
                            <td>
                                <select name="colId" id="catid" class="required">
                                    <option value="">请选择</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>用戶名: </th>
                                <td>
                                    <input class="common-text required" id="title" name="userName" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>用戶姓名: </th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>登錄密碼: </th>
                                <td>
                                    <input class="common-text required" id="title" name="password" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>確認密碼: </th>
                                <td>
                                    <input class="common-text required" id="title" name="rePassword" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>性別: </th>
                                <td>
                                    <input type="radio" name="sex" value="T" Checked="checked">男
                                     <input type="radio" name="sex" value="I">女
                                </td>
                            </tr>
                           
                            <tr>
                                <th>出生日期：</th>
                                <td><input class="common-text" name="birthday" size="50" value="" type="text"></td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>電子郵箱: </th>
                                <td>
                                    <input class="common-text required" id="title" name="email" size="50" value="" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>手機號碼: </th>
                                <td>
                                    <input class="common-text required" id="title" name="mobile" size="50" value="" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>送貨地址: </th>
                                <td>
                                    <input class="common-text required" id="title" name="address" size="50" value="" type="text">
                                </td>
                            </tr>
                
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>
 		<!--/main-->
</div>
</body>
</html>