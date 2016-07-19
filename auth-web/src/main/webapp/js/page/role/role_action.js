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

    $('#aSystemId').combobox({
        loader: aSystemIdListLoader,
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto'
    });

    $('#eSystemId').combobox({
        loader: eSystemIdListLoader,
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto'
    });

    $('#eStatus').combobox({
        data : [
            {
                "text":"可用",
                "value":1
            },
            {
                "text":"禁用",
                "value":2
            }
        ],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto'
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

function doAdd() {
    $('#aSystemId').combobox('reload');
    openWindow($('#a'));
}

function doASearchMenu(value) {
    var data = {
        systemId : $('#aSystemId').combobox('getValue'),
        roleId : 0
    };
    $.getJSON('../menu/list_role_menu', data, function(json) {
        if (success(json)) {
            $('#att').tree('loadData', json.dataList);
        }
    });
    openWindow($('#ad'));
}

function doEdit() {
    var row = $('#list').datagrid('getSelected');
    if (row) {
        $('#ef').form('load', {
            id: row.id,
            name: row.name
        });
        $('#eStatus').combobox('select', row.status);
        $('#eSystemId').combobox('reload');
        $('#eSystemId').combobox('select', row.systemId);
        openWindow($('#e'));
    } else {
        $.messager.alert('温馨提示', '请选择角色信息!');
    }
}

function doESearchMenu(value) {
    var data = {
        systemId : $('#eSystemId').combobox('getValue'),
        roleId : $('#eRoleId').val()
    };
    $.getJSON('../menu/list_role_menu', data, function(json) {
        if (success(json)) {
            $('#ett').tree('loadData', json.dataList);
        }
    });
    openWindow($('#ed'));
}

function aSubmitMenus() {
    var rows = $('#att').tree('getChecked', ['checked', 'indeterminate']);
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
    var rows = $('#ett').tree('getChecked', ['checked', 'indeterminate']);
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
