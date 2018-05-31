// 获取当前年月日
function loadDateTime() {
    var dateTime = new Date();
    var hh = dateTime.getHours();
    var mm = dateTime.getMinutes();
    var ss = dateTime.getSeconds();
    var yy = dateTime.getFullYear();
    var MM = dateTime.getMonth() + 1;
    var dd = dateTime.getDate();
    var week = dateTime.getDay();
    var days = "日一二三四五六 ";
    $("#today").text("今天是：" + yy + "年" + MM + "月" + dd + "日" + "  " + "星期" + days[week]);
}

// 获取url后面的参数： getUrlParam("pid")
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return decodeURI(r[2]); //用decodeURI来解码。所以如果参数名是中文，那么存的时候要用encodeURI()
    return null;
}

// 添加cookie：setCookie('性别', '男', 10);
function setCookie(key, value, t) {
    var oDate = new Date();
    oDate.setDate(oDate.getDate() + t); // 存t天
    // oDate.setHours(oDate.getHours() + t); // 存t小时
    document.cookie = key + '=' + encodeURI(value) + ';expires=' + oDate.toUTCString();
}

// 获取cookie：getCookie('性别')
function getCookie(key) {
    var arr1 = document.cookie.split('; ');
    for (var i = 0; i < arr1.length; i++) {
        var arr2 = arr1[i].split('=');
        if (arr2[0] == key) {
            return decodeURI(arr2[1]);
        }
    }
}

// 删除cookie：removeCookie('性别');
function removeCookie(key) {
    setCookie(key, '', -1); //将expires设置为前一天，来立刻删除cookie
}


// 绑定全选 全选按钮#select-all 被控制.select-all
function selectAll() {
    var btn = $('#select-all');
    var btns = $('.select-all');
    btn.click(function() {
        btns.prop('checked', btn.prop('checked'));
    });
    btns.click(function() {
        btn.prop('checked', true);
        btns.each(function(index, el) {
            if ($(el).prop('checked') === false) {
                btn.prop('checked', false);
            }
        });
    });
}

// --------------------- 工具函数 ---------------------
// 包括所有初始化操作
var basePath;
getBasePath();
// 获取basePath
function getBasePath() {
    var loc = (window.location + '').split('/');
    basePath = loc[0] + '//' + loc[2] + '/' + loc[3] + '/';
}
// 把后台传回来的数据，格式化成select控件需要的格式
function formatData_Input_Select(data, textName, valName) {
    var resList = [];
    for (var i = 0; i < data.length; i++) {
        resList.push({
            "text": data[i][textName],
            "val": data[i][valName]
        });
    }
    return resList;
}
// 处理空数据
function filter_NullData(data) {
    $.each(data, function(key, val) {
        if (val === undefined || val === null) {
            data[key] = "";
        }
    });
}
// 初始化日期控件
function initDatePick() {
    // 开始日期默认当天     
    $('.initCurDate').val(function() {
        var today = new Date();
        var h = today.getFullYear();
        var m = today.getMonth() +
            1;
        var d = today.getDate();
        m = m < 10 ? "0" + m : m;
        d = d < 10 ? "0" + d : d;
        return h + "-" + m + "-" + d;
    });
    //保证： 开始日期 <= 预计完成日期
    $("#startTime1").bind("click focus", function() {
        WdatePicker({
            maxDate: '#F{$dp.$D(\'endTime1\')}',
            dateFmt: "yyyy-MM-dd"
        });
    });
    $("#endTime1").bind("click focus", function() {
        WdatePicker({
            minDate: '#F{$dp.$D(\'startTime1\')}',
            dateFmt: "yyyy-MM-dd"
        });
    });
}