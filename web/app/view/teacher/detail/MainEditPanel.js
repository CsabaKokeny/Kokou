Ext.define('Kokou.view.teacher.detail.MainEditPanel',{
    extend: 'Kokou.panel.EditPanel',
    border: 0,
    layout:'anchor',
    frame: false,
    collapsible: false,
    bodyPadding: '10,20',
    title: '教職員情報',
    readOnly: true,
    defaults: {
        anchor: '100%'
    },
    userConfig: {
        labelWidth: 120
    },
    
    initComponent: function () {
        var _this = this;
        var factory = this.getFieldFactory();
        this.widgets = {
            "enterDate": factory.createEnterDate({columnWidth:0.4, labelWidth: 70, fieldLabel: '入職年度', readOnly: true,}),
            "enterKind":Ext.create('Kokou.form.field.teacher.EnterKindComboBox',{columnWidth:0.4, labelWidth: 70, readOnly: true,}),
            "name": factory.createText({fieldLabel: '氏名', labelWidth:50, readOnly: true,}),
            "nameKr": factory.createText({fieldLabel: 'ハングル名', labelWidth:70, readOnly: true,}),
            "nameNick": factory.createText({fieldLabel: '通称名',labelWidth:60, readOnly: true,}),
            "sex": Ext.create('Kokou.form.field.teacher.SexComboBox', {labelWidth:50, readOnly: true,}),
            "birth": factory.createDate({fieldLabel: '生年月日', labelWidth:60,readOnly: true,}),
            "address": factory.createText({fieldLabel: '現住所', labelWidth:50,readOnly: true,}),
            "address2": factory.createText({fieldLabel: '変更住所', labelWidth:60,readOnly: true,}),
            "phone": factory.createText({fieldLabel: 'ＴＥＬ', labelWidth:50,readOnly: true,}),
            "fax": factory.createText({fieldLabel: 'ＦＡＸ', labelWidth:60,readOnly: true,}),
            "mobile": factory.createText({fieldLabel: '携帯番号', labelWidth:60,readOnly: true,}),
            "nation": Ext.create('Kokou.form.field.teacher.ResidenceComboBox', {labelWidth:50, fieldLabel:'本籍',readOnly: true}),
            "positionInformation": {
                "take": {
                    "content": factory.createText({labelWidth: 50, fieldLabel:'就任',readOnly: true}),
                    "date": factory.createDate({labelWidth: 70, fieldLabel:'年月日',readOnly: true})
                },
                "retire": {
                    "content": factory.createText({labelWidth: 50, fieldLabel:'退任',readOnly: true}),
                    "date": factory.createDate({labelWidth: 70, fieldLabel:'年月日',readOnly: true})
                },
                "change": {
                    "content": factory.createText({labelWidth: 50, fieldLabel:'離任',readOnly: true}),
                    "date":factory.createDate({labelWidth: 70, fieldLabel:'年月日',readOnly: true})
                },
                "currentPosition": factory.createText({labelWidth: 70, fieldLabel:'現役職', fit:1,readOnly: true})
            },
            "lastGraduation": {
                "schoolKind":Ext.create('Kokou.form.field.teacher.GraduationSchoolKindComboBox', {
                    fieldLabel: '最終学歴',
                    labelWidth: 60,readOnly: true
                }),
                "schoolName":factory.createText({fieldLabel: '大学名', labelWidth:60,readOnly: true}),
                "schoolDepartment": factory.createText({fieldLabel: '学部', labelWidth:60,readOnly: true}),
                "schoolSubject": factory.createText({fieldLabel: '学科', labelWidth: 50,readOnly: true}),
                "schoolResult": Ext.create('Kokou.form.field.teacher.SchoolResultComboBox', {
                    width:'50%',
                    fit: 2
                    ,readOnly: true
                }),
                "teacherScholar": factory.createText({fieldLabel: '', labelWidth:0,readOnly: true}),
            }
        };
        _this.items = [
            { html:'<div style="height:22px;"></div>' },
            {
                xtype: 'fieldset',
                border:0,
                layout: 'column',
                items: [
                    _this.widgets.enterDate,
                    {columnWidth:0.2, html:'&nbsp;'},
                    _this.widgets.enterKind
                ]
            },
            {
                xtype: 'fieldset',
                layout: 'column',
                border: 1,
                title: '役職履歴',
                items: [
                    {
                        xtype: 'fieldset',
                        columnWidth:0.7,
                        layout: 'form',
                        border: 0,
                        items : [
                            _this.widgets.positionInformation.take.content,
                            _this.widgets.positionInformation.retire.content,
                            _this.widgets.positionInformation.change.content
                        ]
                    },
                    {
                        xtype: 'fieldset',
                        columnWidth:0.3,
                        layout: 'form',
                        border: 0,
                        items : [
                            _this.widgets.positionInformation.take.date,
                            _this.widgets.positionInformation.retire.date,
                            _this.widgets.positionInformation.change.date
                        ]
                    }
                ]
            },
            {
                 xtype: 'fieldset',
                 layout: 'form',
                 border: 0,
                 items:[
                     _this.widgets.positionInformation.currentPosition
                 ]
            },
            {
                xtype:'fieldset',
                layout: 'column',
                border: 1,
                title:'■【教職員情報】',
                items: [
                    {
                        xtype: 'fieldset',
                        columnWidth: 0.3,
                        layout:'form',
                        border: 0,
                        items: [
                            _this.widgets.name,
                            _this.widgets.sex,
                            _this.widgets.address,
                            _this.widgets.phone,
                            _this.widgets.nation,
                            _this.widgets.lastGraduation.schoolKind,
                            _this.widgets.lastGraduation.schoolSubject
                        ]
                    },
                    {
                        xtype: 'fieldset',
                        columnWidth: 0.35,

                        layout:'form',
                        border:0,
                        items: [
                            _this.widgets.nameKr,
                            _this.widgets.birth,
                            _this.widgets.address2,
                            _this.widgets.fax,
                            {html:'<div style="height:22px;">&nbsp;</div>'},
                            _this.widgets.lastGraduation.schoolName,
                            {
                                xtype:'fieldcontainer',
                                layout: 'hbox',
                                items: [
                                    _this.widgets.lastGraduation.schoolResult,
                                    Ext.create('Ext.form.field.Display', {
                                        value:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;教員免許種類:',
                                        fit: 1,
                                        align: 'right',
                                        width: '50%'
                                    })
                                    
                                ]
                            }
                        ]
                    },
                    {
                        xtype: 'fieldset',
                        columnWidth: 0.35,

                        layout:'form',
                        border:0,
                        items: [
                            _this.widgets.nameNick,
                            {html:'<div style="height:22px;">&nbsp;</div>'},
                            {html:'<div style="height:22px;">&nbsp;</div>'},
                            _this.widgets.mobile,
                            {html:'<div style="height:22px;">&nbsp;</div>'},
                            _this.widgets.lastGraduation.schoolDepartment,
                            _this.widgets.lastGraduation.teacherScholar
                        ]
                    }
                ]
            }
        ];
        this.callParent(arguments);
    }
});