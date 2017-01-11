Ext.define('Kokou.data.Saver', {
    saveStudentInXml: function (data, funcSuccess, funcFailure) {
        Ext.Ajax.request({
            url: 'student2/save',
            params: data,
            method: 'PUT',
            success: function (response, opts) {
                var result;
                eval('result='+response.responseText);
                if (result.success === true || result.success === 'true') {
                    if (!!funcSuccess) {
                        funcSuccess(result);
                    }
                } else {
                    if (!!funcFailure) {
                        funcFailure(result);
                    }
                }
            },
            failure: function (response, opts) {
                var result = {};
                if (!!response) {
                    if (!!response.responseText) {
                        eval ('result='+response.responseText);
                    }
                }
                funcFailure(result);
            }
        });
    },
    saveTeacherInXml: function (data, funcSuccess, funcFailure) {
        Ext.Ajax.request({
            url: 'teacher2/save',
            params: data,
            method: 'PUT',
            success: function (response, opts) {
                var result;
                eval('result='+response.responseText);
                if (result.success === true || result.success === 'true') {
                    if (!!funcSuccess) {
                        funcSuccess(result);
                    }
                } else {
                    if (!!funcFailure) {
                        funcFailure(result);
                    }
                }
            },
            failure: function (response, opts) {
                var result = {};
                if (!!response) {
                    if (!!response.responseText) {
                        eval ('result='+response.responseText);
                    }
                }
                funcFailure(result);
            }
        });
    }
});