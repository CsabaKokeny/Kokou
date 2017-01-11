Ext.define('Kokou.form.field.StudentCodeEditor', {
    extend: 'Ext.form.FieldContainer',
    border: 0,
    frame: false,
    layout: {
        type: 'hbox'
    },
    fieldLabel: '学籍番号',
    initComponent: function () {
        var _this = this;
        this.prefixWidget = Ext.create('Ext.form.field.Display', {
            parent: _this,
        });
        this.noWidget = Ext.create('Kokou.view.form.field.CodeSpinner', {
            parent: _this,
            readOnly: !!this.readOnly
        });
        this.items = [
            this.prefixWidget,
            this.noWidget
        ];
        this.callParent(arguments);
    },
    getPrefixField: function () {
        return this.prefixWidget;
    },
    setPrefixField: function (prefixField) {
        this.prefixWidget = prefixField;
        return this;
    },
    getNoField: function () {
        return this.noWidget;
    },
    setNoField: function (noField) {
        this.noWidget = noField;
        return this;
    },
    getPrefix: function () {
        var val = this.getPrefixField().getValue();
        if (val === null || val === undefined) {
            val = '';
        }
        return val;
    },
    setPrefix: function (val){
        this.getPrefixField().setValue(val);
        return this;
    },
    getNo: function () {
        var val = this.getNoField().getValue();
        if (val === null || val === undefined) {
            val = '';
        }
        return val;
    },
    setNo: function (val) {
        if (typeof val === 'string') {
            for (var i = 0; i< val.length;i++) {
                if (isNaN(val[i])) {
                    val = '';
                    break;
                }
            }
        }
        var nVal = parseInt(val);
        if (isNaN(nVal)) {
            val = '';
        } else {
            if (nVal < 1) {
                val = '999';
            } else if (nVal < 10) {
                val = '00' + nVal;
            } else if (nVal < 100) {
                val = '0' + nVal;
            }
            if (val.length > 3) {
                val = val.substring(0,3);
            }
        }
        this.getNoField().setValue(val);
        return this;
    },
    getValue: function () {
        var val = "";
        var val1 = this.getPrefixField().getValue();
        if (val1 !== null && val1 !== undefined) {
            val += val1;
        }
        val1 = this.getNoField().getValue();
        if (val1 !== null && val1 !== undefined) {
            val += val1;
        }
        return val;
    }
});