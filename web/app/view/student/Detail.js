Ext.define('Kokou.view.student.Detail', {
    extend:  'Kokou.view.base.Window',
    title: '学生基本台帳',
    layout: {
        type: 'anchor'
    },
    autoShow: true,
    modal: true,
    width: 800,
    height: 700,
    userConfig: {
        labelWidth: 120
    },
    initComponent: function () {
        var _this = this;
        _this.factory = Ext.create('Kokou.view.base.FieldFactory', {
            userConfig: _this.userConfig
        });
        this.items = [
            {
                xtype: 'form',
                id: 'frmStudentEdit',
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
                    _this.createMainEditPanel(),
                    {
                        xtype: 'tabpanel',
                        layout: 'fit',
                        border:1,
                        items: [
                            _this.createKeeperEditPanel(),
                            _this.createCareerPanel(),
                            _this.createFamilyPanel(),
                            _this.createCardInfoEditPanel(),
                            _this.createContactPanel(),
                            _this.createBusPanel(),
                            _this.createHealthInfoEditPanel()
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
        return this.mainEditPanel = Ext.create('Kokou.view.student.StudentMainEditPanel_Detail', {
            id:'widgetMainEditPanel',
            userConfig: this.userConfig
        });
    },
    createKeeperEditPanel: function () {
        return Ext.create('Kokou.view.student.StudentKeeperEditPanel_Detail', {
            id:'widgetKeeperEditPanel',
            userConfig: this.userConfig
        });
    },
    createCardInfoEditPanel: function () {
        return Ext.create('Kokou.view.student.StudentCardInfoEditPanel_Detail', {
            id:'widgetCardInfoEditPanel',
            userConfig: this.userConfig
        });
    },
    createCareerPanel: function () {
        return Ext.create('Kokou.view.student.StudentCareerList_Detail',{
            id: 'widgetCareerList',
            closable: false,
            //title: '■【入学前の経歴】',
            title: '■【学事履歴】',
            width: '100%',
            height: 273
        });
    },
    createFamilyPanel: function () {
        return Ext.create('Kokou.view.student.StudentFamilyList_Detail',{
            id: 'widgetFamilyList',
            closable: false,
            title: '■【家族構成（本人から見た入学時の続柄）】',
            width: '100%',
            height: 273
        });
    },
    createContactPanel: function () {
        return Ext.create('Kokou.view.student.StudentContactList_Detail',{
            id: 'widgetContactList',
            closable: false,
            title: '■【緊急時の連絡（保護者以外）】',
            width: '100%',
            height: 273
        });
    },
    createBusPanel: function () {
        return Ext.create('Kokou.view.student.StudentBusList_Detail',{
            id: 'widgetBusList',
            closable: false,
            title: '■【通学方法】',
            width: '100%',
            height: 273
        });
    },
    createHealthInfoEditPanel: function () {
        return Ext.create('Kokou.view.student.StudentHealthInfoEditPanel_Detail', {
            id:'widgetHealthInfoEditPanel',
            userConfig: this.userConfig
        });
    },
    
    loadStudent: function(studentId, callback) {
        this.studentId = studentId;
        Ext.Ajax.request({
            url: 'student2/detail?studentId='+studentId,
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
    loadData: function(data) {
        var form = this.down('form');
        if (data === null || data === undefined) data = {};
        form.down('#widgetMainEditPanel').loadData(data);
        form.down('#widgetKeeperEditPanel').loadData(data.keeper);
        form.down('#widgetCardInfoEditPanel').loadData(data);
        form.down('#widgetHealthInfoEditPanel').loadData(data.health);
        form.down('#widgetBusList').loadData(data.attending);
        form.down('#widgetCareerList').loadData(data.career);
        form.down('#widgetFamilyList').loadData(data.family);
        form.down('#widgetContactList').loadData(data.contact);
        
    }
});