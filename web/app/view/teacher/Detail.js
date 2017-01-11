Ext.define('Kokou.view.teacher.Detail', {
    extend:  'Kokou.view.base.Window',
    title: '教職員基本台帳',
    layout: {
        type: 'anchor'
    },
    autoShow: true,
    modal: true,
    width: 800,
    userConfig: {
        labelWidth: 120
    },
    initComponent: function () {
        var _this = this;
        _this.factory = Ext.create('Kokou.view.base.FieldFactory', {
            userConfig: _this.userConfig
        });
        _this.widgets = {
           "mainEditPanel": _this.createMainEditPanel(),
           "careerPanel": _this.createCareerPanel(),
           "familyPanel": _this.createFamilyPanel(),
           "cardInfoEditPanel": _this.createCardInfoEditPanel(),
           "contactPanel": _this.createContactPanel(),
           "busPanel": _this.createBusPanel(),
           "rewardPunishmentPanel": _this.createRewardPunishmentPanel()
        };
        this.items = [
            {
                xtype: 'form',
                layout: {
                    type: 'anchor'
                },
                frame: true,
                collapsible: false,
                bodyPadding: '10,20',
                defaults: {
                    anchor: '100%'
                },
                items: [
                    {
                        xtype: 'tabpanel',
                        layout: 'fit',
                        border:1,
                        items: [
                            _this.widgets.mainEditPanel,
                            _this.widgets.careerPanel,
                            _this.widgets.familyPanel,
                            _this.widgets.cardInfoEditPanel,
                            _this.widgets.contactPanel,
                            _this.widgets.busPanel,
                            _this.widgets.rewardPunishmentPanel
                        ]
                    }
                ]
            }
        ];
        this.buttons = [];
        this.buttons.push(Ext.create('Ext.button.Button', {
            text: '編集',
            scope: this,
            handler: function () {
               _this.parent.showEditWindow(_this.activeRecord);
               _this.close();
            }
        }));
        this.buttons.push(Ext.create('Ext.button.Button', {
            text: '閉じる',
            scope: this,
            handler: this.close 
        }));
        this.addEvents('save');
        this.callParent(arguments);
    },
    createMainEditPanel: function () {
        return this.mainEditPanel = Ext.create('Kokou.view.teacher.detail.MainEditPanel', {
            userConfig: this.userConfig,
            height: 470
        });
    },
    createCardInfoEditPanel: function () {
        return Ext.create('Kokou.view.teacher.detail.CardInfoEditPanel', {
            height: 470,
            userConfig: this.userConfig,
            readOnly:true
        });
    },
    createCareerPanel: function () {
        return Ext.create('Kokou.view.teacher.detail.CareerList',{
            closable: false,
            title: '■【入職前の経歴】',
            width: '100%',
            height: 470
        });
    },
    createFamilyPanel: function () {
        return Ext.create('Kokou.view.teacher.detail.FamilyList',{
            closable: false,
            title: '■【家族構成（本人から見た入職時の続柄）】',
            width: '100%',
            height: 470
        });
    },
    createContactPanel: function () {
        return Ext.create('Kokou.view.teacher.detail.ContactList',{
            closable: false,
            title: '■【緊急時の連絡（保護者以外）】',
            width: '100%',
            height: 470
        });
    },
    createBusPanel: function () {
        return Ext.create('Kokou.view.teacher.detail.BusList',{
            closable: false,
            title: '■【通勤方法】',
            width: '100%',
            height: 470
        });
    },
    createRewardPunishmentPanel: function () {
        return Ext.create('Kokou.view.teacher.detail.RewardPunishmentList',{
            closable: false,
            title: '■【賞罰】',
            width: '100%',
            height: 470
        });
    },
    
    loadTeacher: function(teacherId, callback) {
        this.teacherId = teacherId;
        Ext.Ajax.request({
            url: 'teacher2/detail?teacherId='+teacherId,
            method: 'GET',
            scope: this,
            success: function (response, opts) {
                var data;
                eval('data='+response.responseText);
                this.loadData(data.data);
                callback();
            },
            failure: function (response, opts) {
            }
            
        });
    },
    
    loadData: function(data) {
        var _this = this;
        if (data === null || data === undefined) data = {};
        _this.widgets.mainEditPanel.loadData(data);
        _this.widgets.careerPanel.loadData(data);
        _this.widgets.familyPanel.loadData(data);
        _this.widgets.cardInfoEditPanel.loadData(data);
        _this.widgets.contactPanel.loadData(data);
        _this.widgets.busPanel.loadData(data);
        _this.widgets.rewardPunishmentPanel.loadData(data);
    },
    getXmlData: function () {
        var _this=this;
        var data = '';
        data += '<?xml version="1.0" encoding="utf-8"?>';
        data += '<request>';
        data += '<teacher>';
        if (!!this.teacherId) {
            data += '<id>'+this.teacherId+'</id>';
        }
        data += _this.widgets.mainEditPanel.getXmlData();
        data += _this.widgets.careerPanel.getXmlData();
        data += _this.widgets.familyPanel.getXmlData();
        data += _this.widgets.cardInfoEditPanel.getXmlData();
        data += _this.widgets.contactPanel.getXmlData();
        data += _this.widgets.busPanel.getXmlData();
        data += _this.widgets.rewardPunishmentPanel.getXmlData();
        data += '</teacher>';
        data += '</request>';
        return data;
        
    },
    save: function (data) {
        var saver = new Ext.create('Kokou.data.Saver',{});
        var _this = this;
        saver.saveTeacherInXml(data,
            function (result){
                Ext.Msg.alert("","登録されました.");
                _this.teacherId = result.teacher.id;
                if (!_this.isCreate) {
                    if (!!_this.activeRecord) {
                        _this.activeRecord.set('name', result.teacher.name);
                        _this.activeRecord.set('nameKr', result.teacher.nameKr);
                        _this.activeRecord.set('sex', result.teacher.sex);
                        _this.activeRecord.set('birth', result.teacher.birth);
                        _this.activeRecord.set('enterDate', result.teacher.enterDate);
                        _this.activeRecord.set('enterKind', result.teacher.enterKind);
                        _this.activeRecord.set('currentPosition', result.teacher.positionInformation.currentPosition);
                    }
                } else {
                    _this.parent.store.insert(0, result.teacher);
                    _this.activeRecord = _this.parent.store.getAt(0);
                    _this.isCreate = false;
                }
                _this.getEl().unmask();
            },
            function (result) {
                Ext.Msg.alert("",result.message);
                _this.getEl().unmask();
            }
        );
    },
    onSaveBtnClick : function() {
        var form = this.down('form');
        if (form.isValid()) {
            this.getEl().mask();
            var formDataInXml = this.getXmlData();
            this.save(formDataInXml);
        }
    }
});