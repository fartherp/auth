$(function () {
    $('#list').datagrid({
        loader: listLoader,
        title: '用户列表',
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
    $('#aSex').combobox({
        data : [
            {
                "text":"男",
                "value":1,
                "selected":true
            },
            {
                "text":"女",
                "value":2
            }
        ],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto'
    });
    $('#aSystemId').combobox({
        loader: aSystemIdListLoader,
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto',
        onChange: function (newValue) {
            $('#aRoleId').combobox(['clear', 'reload']);
        }
    });
    $('#aRoleId').combobox({
        loader : aRoleIdLoader,
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto'
    });

    $('#eSex').combobox({
        data : [
            {
                "text":"男",
                "value":1
            },
            {
                "text":"女",
                "value":2
            }
        ],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto'
    });
    $('#eSystemId').combobox({
        loader: eSystemIdListLoader,
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto',
        onChange: function (newValue) {
            $('#eRoleId').combobox(['clear', 'reload']);
        }
    });
    $('#eRoleId').combobox({
        loader : eRoleIdLoader,
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
    page_list('../user/page/list', params, success, error);
}

function aRoleIdLoader(param, success, error) {
    var aSystemId = $('#aSystemId').combobox('getValue');
    $.getJSON('../kv/hint?module=2&system_id=' + aSystemId, function(json) {
        success(json.dataList);
    });
}

function eRoleIdLoader(param, success, error) {
    var aSystemId = $('#eSystemId').combobox('getValue');
    $.getJSON('../kv/hint?module=2&system_id=' + aSystemId, function(json) {
        success(json.dataList);
    });
}

function doAdd() {
    $('#aSystemId').combobox('reload');
    $('#aRoleId').combobox('reload');
    openWindow($('#a'));
}

function doEdit() {
    var row = $('#list').datagrid('getSelected');
    if (row) {
        $('#ef').form('load', {
            id: row.id,
            name: row.name,
            email: row.email,
            phone: row.phone
        });
        $('#eSex').combobox('select', row.sex);
        $('#eStatus').combobox('select', row.status);
        $('#eSystemId').combobox('reload');
        $('#eSystemId').combobox('select', row.systemId);
        $('#eRoleId').combobox('reload');
        $('#eRoleId').combobox('select', row.roleId);
        openWindow($('#e'));
    } else {
        $.messager.alert('温馨提示', '请选择用户信息!');
    }
}