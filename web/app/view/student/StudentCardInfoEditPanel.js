Ext.define('Kokou.view.student.StudentCardInfoEditPanel',{
    extend: 'Ext.panel.Panel',
    title: '■【各種番号】',
    layout:'column',
    bodyStyle: 'padding:30px 50px',
    height: 273,
    userConfig: {
        labelWidth: 120
    },
    initComponent: function () {
        var _this = this;
        _this.factory = Ext.create('Kokou.view.base.FieldFactory', {
            userConfig: _this.userConfig
        });
        _this.items = [
            {
                xtype: 'fieldset',
                border: 1,
                columnWidth: 0.5,
                layout: 'form',
                title: '旅券',
                items:[
                    _this.factory.createCheckbox({id:'chkHasPassport', name: 'hasPassport', fieldLabel: '有・無', tag:'has'})  ,
                    _this.factory.createText({id:'txtPassportNo', name: 'passportNo', fieldLabel: '旅券番号', tag:'no'}),
                    {html:'&nbsp;'}
                ]
            },
            {
                xtype: 'fieldset',
                border: 1,
                columnWidth: 0.5,
                layout: 'form',
                title: '日本国籍以外の生徒',
                items:[
                    _this.factory.createText({id:'txtForeignerNo', name: 'foreignerNo', fieldLabel: '外国人登録番号', tag:'no'}),
                    {html:'<div style="height:20px;">&nbsp;</div>'},
                    {html:'&nbsp;'}
                ]
            }
        ];
        this.callParent(arguments);
    },
    setData: function (selector, value) {
        if (value === null || value === undefined) {
            value = '';
        }
        var _this = this;
        var _widget = _this.down(selector);
        if (_widget === null || _widget === undefined) return _this;
        _widget.setValue(value);
        return _this;
    },
    loadData: function (data) {
        var _this = this;
        if (data === null || data === undefined) data = {};
        if (data.passport === null || data.passport === undefined) data.passport = {};
        if (data.foreigner === null || data.foreigner === undefined) data.foreigner = {};
        _this.setData('#chkHasPassport', data.passport.has);
        _this.setData('#txtPassportNo', data.passport.no);
        _this.setData('#txtForeignerNo', data.foreigner.no);
        return _this;
    },
    getXmlData : function () {
        var _this = this;
        var marshaller = new Ext.create('Kokou.xml.Marshaller');
        var content = '';
        content += '<passport>';
        content += marshaller.marshall(_this.down('#chkHasPassport'));
        content += marshaller.marshall(_this.down('#txtPassportNo'));
        content += '</passport>';
        content += '<foreigner>';
        content += marshaller.marshall(_this.down('#txtForeignerNo'));
        content += '</foreigner>';
        return content;
    }
});