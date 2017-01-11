Ext.define('Kokou.view.form.field.Date', {
    extend: 'Ext.form.field.Date',
    value: new Date(),
    format: 'Y/m/d',
    toString: function () {
        var val = this.getValue();
        var year = val.getFullYear();
        var month = val.getMonth() + 1;
        var date = val.getDate();
        var str = "" + year;
        if (month < 10) str += "0";
        str += month;
        if (date < 10) str += "0";
        str += date;
        return str;
    }
});