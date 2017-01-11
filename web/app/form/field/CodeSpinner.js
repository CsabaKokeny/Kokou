Ext.define('Kokou.form.field.CodeSpinner', {
    extend: 'Ext.form.field.Spinner',
    flex:1,
    allowBlank: false,
    maxLength: 3,
    minLength: 3,
    validator : function (value) {
        if (value === null || value === undefined || value === '') {
            return "This field is required!";
        }
        var nValue = parseInt(value);
        if (isNaN(nValue)) {
            return "This field should be between 001 and 999!";
        }
        if (nValue < 1 || nValue >999) {
            return "This field should be between 001 and 999!";
        }
        if (value.length < 3 || value.length > 3) {
            return "This field should be between 001 and 999!";
        }
        for (var i = 0; i< value.length;i++) {
            if (isNaN(value[i])) {
                return "This field should be between 001 and 999!";
            }
        }
        return true;
    },
    onSpinUp: function() {
        var me = this;
        if (!me.readOnly) {
            var val = parseInt(me.getValue());
            if (isNaN(val)) val = 0;
            val ++;
            if (val > 999) val = 1;
            else if (val < 1) val = 999;
            if (val < 10) val = "00"+val;
            else if (val < 100) val = "0"+val;
            me.setValue(val);
        }
    },
    onSpinDown: function () {
        var me = this;
        if (!me.readOnly) {
            var val = parseInt(me.getValue());
            if (isNaN(val)) val = 1000;
            val -- ;
            if (val > 999) val = 1;
            else if (val < 1) val = 999;
            if (val < 10) val = "00"+val;
            else if (val < 100) val = "0"+val;
            me.setValue(val);
        }
    }
});
