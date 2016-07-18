var colModel = [[
    {
        field: 'ck',
        checkbox: true,
        singleSelect: true
    },
    {
        field: 'id',
        title: 'ID',
        width: '5%'
    },
    {
        field: 'name',
        title: '用户名',
        width: '8%'
    },
    {
        field: 'roleName',
        title: '角色',
        width: '8%'
    },
    {
        field: 'systemName',
        title: '所属系统',
        width: '8%'
    },
    {
        field: 'email',
        title: '邮箱',
        width: '20%'
    },
    {
        field: 'phone',
        title: '手机号',
        width: '20%'
    },
    {
        field: 'sex',
        title: '性别',
        width: '5%',
        formatter: function (value, row, index) {
            if (value == '1') {
                return '男';
            } else if (value == '2') {
                return '女';
            } else {
                return value;
            }
        }
    },
    {
        field: 'status',
        title: '状态',
        width: '5%',
        formatter: function (value, row, index) {
            if (value == '1') {
                return '可用';
            } else if (value == '2') {
                return '禁用';
            } else {
                return value;
            }
        }
    },
    {
        field: 'createName',
        title: '创建人',
        width: '8%'
    },
    {
        field: 'createTime',
        title: '创建时间',
        width: '15%'
    }
]];