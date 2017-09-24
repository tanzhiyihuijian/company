requirejs.config({
    // 映射不放于 baseUrl下的模块名
    paths: {
        'helper': '../helper'
    }
});

require(['helper'], function (helper) {
    let str = helper.trim('    and        ');
    console.log(str);
});


