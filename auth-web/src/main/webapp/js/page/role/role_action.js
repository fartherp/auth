$(function () {
    $('#list').datagrid({
        loader: listLoader,
        title: '角色列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        columns: colModel,
        toolbar: '#toolbar'
    });
    $.getJSON('../kv/hint?module=5', function(json) {
        var data = [{
            text: "全部",
            value: 0
        }];
        $.each(json.dataList, function() {
            data.push(this);
        });
        $('#systemId').combobox({
            data : data,
            valueField: 'value',
            textField: 'text',
            panelHeight:'auto'
        });
    });
});

function listLoader(param, success, error) {
    var params = {
        name: $("#name").val(),
        systemId: $('#systemId').combobox('getValue'),
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../role/page/list', params, success, error);
}

function doSearch() {
    $('#list').datagrid('reload');
}

function submitForm(f, url, w) {
    if (!f.form("validate")) {
        return;
    }
    f.form('submit', {
        url: url,
        success: function(result) {
            if (successJsonToObject(result)) {
                f.form('clear');
                closeWindow(w);
                $('#list').datagrid('reload');
            }
        }
    });
}

function doAdd() {
    openWindow($('#a'));
    $.getJSON('../kv/hint?module=5&defaultValue=1', function(json) {
        $('#aSystemId').combobox({
            data : json.dataList,
            valueField: 'value',
            textField: 'text',
            panelHeight:'auto'
        });
    });
}

function doASearchMenu(value) {
    openWindow($('#ad'));
    $('#ad_no_choice_list').datagrid({
        loader: noAChoiceListLoader,
        title: '未选择权限列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: colMenuModel
    });
}

function noAChoiceListLoader(param, success, error) {
    var params = {
        systemId: $('#aSystemId').combobox('getValue'),
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../menu/page/list_role_menu', params, success, error);
}

function doEdit() {
    var row = $('#list').datagrid('getSelected');
    if (row) {
        openWindow($('#e'));
        $('#ef').form('load', {
            id: row.id,
            name: row.name
        });
        $.getJSON('../kv/hint?module=5&defaultValue=' + row.systemId, function(json) {
            $('#eSystemId').combobox({
                data : json.dataList,
                valueField: 'value',
                textField: 'text',
                panelHeight:'auto'
            });
        });
        $.getJSON('../kv/hint?module=4&defaultValue=' + row.status, function(json) {
            $('#eStatus').combobox({
                data : json.dataList,
                valueField: 'value',
                textField: 'text',
                panelHeight:'auto'
            });
        });
    } else {
        $.messager.alert('温馨提示', '请选择角色信息!');
    }
}

function doESearchMenu(value) {
    openWindow($('#ed'));
    $('#ed_choice_list').datagrid({
        loader: eChoiceListLoader,
        title: '已选择权限列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: colMenuModel
    });
    $('#ed_no_choice_list').datagrid({
        loader: noEChoiceListLoader,
        title: '未选择权限列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: colMenuModel
    });
}

function eChoiceListLoader(param, success, error) {
    var params = {
        roleId: $('#eRoleId').val(),
        no: 1,
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../menu/page/list_role_menu', params, success, error);
}

function noEChoiceListLoader(param, success, error) {
    var params = {
        roleId: $('#eRoleId').val(),
        systemId: $('#eSystemId').combobox('getValue'),
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../menu/page/list_role_menu', params, success, error);
}

function aSubmitMenus() {
    var rows = $('#ad_no_choice_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要添加权限!');
        return;
    }
    var menus = [];
    for (var i = 0; i < rows.length; i++) {
        menus.push(rows[i].id);
    }
    $('#aMenuIds').searchbox('setValue', menus);
    closeWindow($('#ad'));
}

function eSubmitMenus() {
    var rows = $('#ed_no_choice_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要添加权限!');
        return;
    }
    var menus = [];
    for (var i = 0; i < rows.length; i++) {
        menus.push(rows[i].id);
    }
    $('#eMenuIds').searchbox('setValue', menus);
    closeWindow($('#ed'));
}

function eRemoveMenus() {
    var rows = $('#ed_choice_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要移除权限!');
        return;
    }
    var menus = [];
    for (var i = 0; i < rows.length; i++) {
        menus.push(rows[i].id);
    }
    var data = {
        id: $('#eRoleId').val(),
        menuIds: menus.toString()
    };
    $.ajax({
        url: '../role/remove_menus',
        dataType: 'json',
        data: data,
        success: function(json) {
            $('#ed_choice_list').datagrid('reload');
            $('#ed_no_choice_list').datagrid('reload');
            $('#list').datagrid('reload');
        },
        error: function() {
            error.apply(this, arguments);
        }
    });
}