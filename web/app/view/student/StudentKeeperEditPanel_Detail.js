Ext.define('Kokou.view.student.StudentKeeperEditPanel_Detail',{
    extend: 'Ext.panel.Panel',
    title: '■【保護者情報】',
    layout:'column',
    bodyStyle: 'padding:10px 50px',
    height: 273,
    tag:'keeper',
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
                border: 0,
                columnWidth: 0.5,
                layout: 'form',
                items:[
                    _this.factory.createText({id:'txtKeeperName',name: 'keeperName', fieldLabel: '氏名', tag:'name', readOnly:true}),  
                    _this.factory.createText({id:'txtKeeperNameKr',name: 'keeperNameKr', fieldLabel: 'ハングル名', tag:'nameKr', readOnly:true}),
                    _this.factory.createText({id:'txtKeeperJob',name: 'keeperJob', fieldLabel: '職業', tag:'job', readOnly:true}),
                    _this.factory.createDate({id:'dtKeeperBirth', name: 'keeperBirth',fieldLabel: '生年月日（西暦）', tag:'birth', readOnly:true}),
                    _this.factory.createText({id:'txtKeeperAddress', name: 'keeperAddress', fieldLabel: '現住所', tag:'address', readOnly:true}),
                    _this.factory.createText({id:'txtKeeperPhone', name: 'keeperPhone', fieldLabel: 'ＴＥＬ', tag:'phone', readOnly:true}),
                    _this.factory.createText({id:'txtKeeperFax',name: 'keeperFax', fieldLabel: 'ＦＡＸ', tag:'fax', readOnly:true}),
                    _this.factory.createNationComboBox({id:'cbxKeeperNation', name: 'keeperNation', fieldLabel: '本籍', tag:'nation', readOnly:true})
                ]
            },
            {
                xtype: 'fieldset',
                border: 0,
                columnWidth: 0.5,
                layout: 'form',
                items:[
                    _this.factory.createText({id:'txtKeeperNameNick',name: 'keeperNameNick', fieldLabel: '通称名', tag:'nameNick', readOnly:true}),
                    _this.factory.createRelationTypeComboBox({id:'cbxKeeperRelation', name: 'keeperRelation', fieldLabel: '生徒との関係', tag:'relation', readOnly:true}),
                    _this.factory.createSexComboBox({id:'cbxKeeperSex', name: 'keeperSex', fieldLabel: '性別', tag:'sex', readOnly:true}),
                    {html:'<div style="height:24px;">&nbsp;</div>'},
                    _this.factory.createText({id:'txtKeeperAddress2', name: 'keeperAddress2', fieldLabel: '変更住所', tag:'address2', readOnly:true}),
                    _this.factory.createPhoneTypeComboBox({id:'cbxKeeperPhoneType', name: 'keeperPhoneType', fieldLabel: 'ＴＥＬ種別', tag: 'phoneType', readOnly:true}),
                    _this.factory.createText({id:'txtKeeperMail', name: 'keeperEmail', fieldLabel: 'メールアドレス', tag:'mail', readOnly:true}),
                    {html:'<div style="height:24px;">&nbsp;</div>'}
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
    
    loadData : function (data) {
        var _this = this;
        if (data === null || data === undefined) data = {};
        _this.setData('#txtKeeperName', data.name);
        _this.setData('#txtKeeperNameKr', data.nameKr);
        _this.setData('#txtKeeperNameNick', data.nameNick);
        _this.setData('#cbxKeeperSex', data.sex);
        _this.setData('#cbxKeeperRelation', data.relation);
        _this.setData('#txtKeeperJob', data.job);
        _this.setData('#dtKeeperBirth', data.birth);
        _this.setData('#txtKeeperAddress', data.address);
        _this.setData('#txtKeeperAddress2', data.address2);
        _this.setData('#txtKeeperPhone', data.phone);
        _this.setData('#cbxKeeperPhoneType', data.phoneType);
        _this.setData('#txtKeeperFax', data.fax);
        _this.setData('#txtKeeperMail', data.mail);
        _this.setData('#cbxKeeperNation', data.nation);        
        return _this;
    }
});
