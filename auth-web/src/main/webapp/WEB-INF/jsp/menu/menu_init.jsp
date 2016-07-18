<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>菜单信息</title>
    </head>
    <body>
        <table id="list"></table>
        <div id="toolbar">
            <input class="easyui-textbox" type="text" id="name" data-options="prompt:'菜单名'" size="30" />
            所属系统<input class="easyui-combobox" id="systemId" style="width:90px;"/>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="doAdd();">新增</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="doEdit()">编辑</a>
        </div>
        <div id="a" class="easyui-window" title="新增菜单" data-options="closed:true," style="top:100px;width:350px;height:350px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    <form id="f" class="easyui-form">
                        <table cellpadding="5">
                            <tr>
                                <td>名称:</td>
                                <td><input class="easyui-textbox" type="text" name="name" data-options="required:true"/></td>
                            </tr>
                            <tr>
                                <td>备注:</td>
                                <td><input class="easyui-textbox" type="text" name="remark"/></td>
                            </tr>
                            <tr>
                                <td>URL:</td>
                                <td><input class="easyui-textbox" type="text" name="url"/></td>
                            </tr>
                            <tr>
                                <td>系统:</td>
                                <td><input class="easyui-combobox" type="text" id="aSystemId" name="systemId"/></td>
                            </tr>
                            <tr>
                                <td>父菜单:</td>
                                <td><input class="easyui-combobox" type="text" id="aPId" name="parentId"/></td>
                            </tr>
                            <tr>
                                <td>类型:</td>
                                <td><input class="easyui-combobox" type="text" id="aLevel" name="level"/></td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="submitForm($('#f'), '../menu/add_menu', $('#a'));" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#a'));clearForm($('#f'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        <div id="e" class="easyui-window" title="编辑菜单" data-options="closed:true," style="width:350px;height:360px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    <form id="ef" class="easyui-form">
                        <table cellpadding="5">
                            <input type="hidden" name="id"/>
                            <tr>
                                <td>名称:</td>
                                <td><input class="easyui-textbox" type="text" name="name" data-options="required:true"/></td>
                            </tr>
                            <tr>
                                <td>备注:</td>
                                <td><input class="easyui-textbox" type="text" name="remark"/></td>
                            </tr>
                            <tr>
                                <td>URL:</td>
                                <td><input class="easyui-textbox" type="text" name="url"/></td>
                            </tr>
                            <tr>
                                <td>系统:</td>
                                <td><input class="easyui-combobox" type="text" id="eSystemId" name="systemId"/></td>
                            </tr>
                            <tr>
                                <td>父菜单:</td>
                                <td><input class="easyui-combobox" type="text" id="ePId" name="parentId"/></td>
                            </tr>
                            <tr>
                                <td>类型:</td>
                                <td><input class="easyui-combobox" type="text" id="eLevel" name="level"/></td>
                            </tr>
                            <tr>
                                <td>状态:</td>
                                <td><input class="easyui-combobox" type="text" id="eStatus" name="status"/></td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="submitForm($('#ef'), '../menu/edit_menu', $('#e'));" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#e'));clearForm($('#ef'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/menu/menu_model.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/menu/menu_action.js"></script>
