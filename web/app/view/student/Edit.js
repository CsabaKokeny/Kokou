Ext.define('Kokou.view.student.Edit', {
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
            text: '保管',
            scope: this,
            handler: function () {
                _this.onSaveBtnClick();
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
        return this.mainEditPanel = Ext.create('Kokou.view.student.StudentMainEditPanel', {
            id:'widgetMainEditPanel',
            userConfig: this.userConfig
        });
    },
    createKeeperEditPanel: function () {
        return Ext.create('Kokou.view.student.StudentKeeperEditPanel', {
            id:'widgetKeeperEditPanel',
            userConfig: this.userConfig
        });
    },
    createCardInfoEditPanel: function () {
        return Ext.create('Kokou.view.student.StudentCardInfoEditPanel', {
            id:'widgetCardInfoEditPanel',
            userConfig: this.userConfig
        });
    },
    createCareerPanel: function () {
        return Ext.create('Kokou.view.student.StudentCareerList',{
            id: 'widgetCareerList',
            closable: false,
            //title: '■【入学前の経歴】',
            title: '■【学事履歴】',
            width: '100%',
            height: 273
        });
    },
    createFamilyPanel: function () {
        return Ext.create('Kokou.view.student.StudentFamilyList',{
            id: 'widgetFamilyList',
            closable: false,
            title: '■【家族構成（本人から見た入学時の続柄）】',
            width: '100%',
            height: 273
        });
    },
    createContactPanel: function () {
        return Ext.create('Kokou.view.student.StudentContactList',{
            id: 'widgetContactList',
            closable: false,
            title: '■【緊急時の連絡（保護者以外）】',
            width: '100%',
            height: 273
        });
    },
    createBusPanel: function () {
        return Ext.create('Kokou.view.student.StudentBusList',{
            id: 'widgetBusList',
            closable: false,
            title: '■【通学方法】',
            width: '100%',
            height: 273
        });
    },
    createHealthInfoEditPanel: function () {
        return Ext.create('Kokou.view.student.StudentHealthInfoEditPanel', {
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
        
    },
    getXmlData: function () {
        var form = this.down('form');
        var data = '';
        data += '<?xml version="1.0" encoding="utf-8"?>';
        data += '<request>';
        data += '<student>';
        if (!!this.studentId) {
            data += '<id>'+this.studentId+'</id>';
        }
        data += form.down('#widgetMainEditPanel').getXmlData();
        data += form.down('#widgetKeeperEditPanel').getXmlData();
        data += form.down('#widgetCareerList').getXmlData();
        data += form.down('#widgetFamilyList').getXmlData();
        data += form.down('#widgetContactList').getXmlData();
        data += form.down('#widgetBusList').getXmlData();
        data += form.down('#widgetCardInfoEditPanel').getXmlData();
        data += form.down('#widgetHealthInfoEditPanel').getXmlData();
        alert(data);
        data += '</student>';
        data += '</request>';
        return data;
        
    },
    save: function (data) {
        var saver = new Ext.create('Kokou.data.Saver',{});
        var _this = this;
        saver.saveStudentInXml(data,
            function (result){
                Ext.Msg.alert("","登録されました.");
                _this.studentId = result.student.id;
                if (!_this.isCreate) {
                    if (!!_this.activeRecord) {
                        _this.activeRecord.set('name', result.student.name);
                        _this.activeRecord.set('nameKr', result.student.nameKr);
                        _this.activeRecord.set('sex', result.student.sex);
                        _this.activeRecord.set('sexLabel', result.student.sexLabel);
                        _this.activeRecord.set('birth', result.student.birth);
                        _this.activeRecord.set('nation', result.student.nation);
                        _this.activeRecord.set('nationLabel', result.student.nationLabel);
                        _this.activeRecord.set('classLabel', result.student.classLabel);
                        _this.activeRecord.set('fullCode', result.student.fullCode);
                    }
                } else {
                    _this.parent.store.insert(0, result.student);
                    _this.activeRecord = _this.parent.store.getAt(0);
                    _this.isCreate = false;
                }
                _this.getEl().unmask();
            },
            function (result) {
                Ext.Msg.alert("",result.message);
                _this.getEl().unmask();
                if (parseInt(result.errorNo) === 100) {
                    _this.mainEditPanel.studentCodeEditor.getNoField().setActiveError('&nbsp;');
                }
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