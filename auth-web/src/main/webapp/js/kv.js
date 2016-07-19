function aSystemIdListLoader(param, success, error) {
    $.getJSON("../kv/hint?module=5&defaultValue=1", function (json) {
        success(json.dataList);
    });
}

function eSystemIdListLoader(param, success, error) {
    $.getJSON("../kv/hint?module=5", function (json) {
        success(json.dataList);
    });
}