$(function () {
    $('#list').datagrid({
        loader: listLoader,
        title: '菜单列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        columns: colModel,
        toolbar: '#toolbar'
    });
    $('#aPId').combobox({
        loader: aParentMenuLoader,
        mode: 'remote',
        valueField: 'value',
        textField: 'text',
        panelHeight: 'auto',
        selectOnNavigation: false,
        hasDownArrow: false
    });
    $('#ePId').combobox({
        loader: eParentMenuLoader,
        mode: 'remote',
        valueField: 'value',
        textField: 'text',
        panelHeight: 'auto',
        selectOnNavigation: false,
        hasDownArrow: false
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
    page_list('../menu/page/list', params, success, error);
}

function doAdd() {
    $('#aSystemId').combobox('reload');
    openWindow($('#a'));
    $.getJSON('../kv/hint?module=7&defaultValue=1', function(json) {
        $('#aLevel').combobox({
            data : json.dataList,
            valueField: 'value',
            textField: 'text',
            panelHeight:'auto'
        });
    });
}

function aParentMenuLoader(param, success, error) {
    if (!param.q) {
        return false;
    }
    var data = {
        module: 6,
        key: param.q,
        system_id: $('#aSystemId').combobox('getValue')
    };
    $.ajax({
        url: '../kv/fuzzy',
        dataType: 'json',
        data: data,
        success: function(json) {
            success(json.dataList);
        },
        error: function() {
            error.apply(this, arguments);
        }
    });
}

function eParentMenuLoader(param, success, error) {
    if (!param.q) {
        return false;
    }
    var data = {
        module: 6,
        key: param.q,
        system_id: $('#eSystemId').combobox('getValue')
    };
    $.ajax({
        url: '../kv/fuzzy',
        dataType: 'json',
        data: data,
        success: function(json) {
            success(json.dataList);
        },
        error: function() {
            error.apply(this, arguments);
        }
    });
}

function doEdit() {
    var row = $('#list').datagrid('getSelected');
    if (row) {
        openWindow($('#e'));
        $('#ef').form('load', {
            id: row.id,
            name: row.name,
            remark: row.remark,
            url: row.url
        });
        $('#ePId').combobox('setValue', row.parentId);
        $('#ePId').combobox('setText', row.parentName);
        $('#eStatus').combobox('select', row.status);
        $('#eSystemId').combobox('reload');
        $('#eSystemId').combobox('select', row.systemId);
        $.getJSON('../kv/hint?module=7&defaultValue=' + row.level, function(json) {
            $('#eLevel').combobox({
                data : json.dataList,
                valueField: 'value',
                textField: 'text',
                panelHeight:'auto'
            });
        });
    } else {
        $.messager.alert('温馨提示', '请选择菜单信息!');
    }
}