requirejs.config({
    // 配置模块的根路经
    baseUrl: jsBasePath,
    // 映射不放于 baseUrl下的模块名
    paths: {

    }
});


define('helper', ['jquery'], function ($) {
   return {
       trim: function (str) {
           return $.trim(str);
       }
   };
});



