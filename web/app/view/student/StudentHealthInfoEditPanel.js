Ext.define('Kokou.view.student.StudentHealthInfoEditPanel', {
    extend: 'Ext.panel.Panel',
    title: '■【健康情報】',
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
                title: 'アレルギー',
                items:[
                    _this.factory.createCheckbox({id:'chkHasAllergy', name: 'hasAllergy', fieldLabel: '有・無', tag:'has'})  ,
                    _this.factory.createText({id:'txtAllergyName', name: 'allergyName', fieldLabel: 'アレルゲン名', tag:'name'}),
                    {html:'&nbsp;'}
                ]
            },
            {
                xtype: 'fieldset',
                border: 1,
                columnWidth: 0.5,
                layout: 'form',
                title: 'その他',
                items:[
                    _this.factory.createText({id:'txtHealthImportant', name: 'healthImportant', fieldLabel: 'その他注意事項', tag:'important'}),
                    {html:'<div style="height:20px;">&nbsp;</div>'},
                    {html:'&nbsp;'}
                ]
            }
        ];
        _this.callParent(arguments);
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
        if (data.allergy === null || data.allergy === undefined) data.allergy = {};
        _this.setData('#chkHasAllergy', data.allergy.has);
        _this.setData('#txtAllergyName', data.allergy.name);
        _this.setData('#txtHealthImportant', data.important);
        return _this;
    },
    getXmlData : function () {
        var _this = this;
        var marshaller = new Ext.create('Kokou.xml.Marshaller');
        var content = '<health>';
        content += '<allergy>';
        content += marshaller.marshall(_this.down('#chkHasAllergy'));
        content += marshaller.marshall(_this.down('#txtAllergyName'));
        content += '</allergy>';
        content += marshaller.marshall(_this.down('#txtHealthImportant'));
        content += '</health>';
        return content;
    }
});