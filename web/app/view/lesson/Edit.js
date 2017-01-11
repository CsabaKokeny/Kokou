Ext.define('Kokou.view.lesson.Edit', {
    extend:  'Kokou.view.base.Window',
    title: '&nbsp;',
    autoShow: true,
    modal: true,
    width: 600,
    initComponent: function () {
        this.items = [
            {
                xtype: 'form',
                id: 'frmLessonEdit',
                region: 'north',
                frame: true,
                collapsible: false,
                bodyPadding: '10,20',
                defaults: {
                    anchor: '80%'
                },
                items: [
                    this.createHiddenfield({id:'txtLessonId', name:'lessonId'}),
                    this.createTextfield({name: 'name', fieldLabel: '課目名'}),
                    this.createTextfield({name: 'namekr', fieldLabel: '課目名（ハングル）'}),
                    this.createTextfield({name: 'nameen', fieldLabel: '課目名（英語）'}),
                    this.createDepartmentCombobox({id:'cbxDepartment', name: 'department',fieldLabel: '種別'}),
                    this.createLevelNumberfield({name: 'level', fieldLabel: '学年'}),
                    {
                        xtype: 'textarea',
                        labelWidth: 150,
                        name: 'description',
                        fieldLabel: '説明'
                    }
                ]
            }
        ];
        this.buttons = [];
        this.buttons.push(Ext.create('Ext.button.Button', {
            text: '保管',
            scope: this,
            handler: this.onSaveBtnClick
        }));
        this.buttons.push(Ext.create('Ext.button.Button', {
            text: '閉じる',
            scope: this,
            handler: this.close 
        }));
        this.addEvents('save');
        this.callParent(arguments);
    },
    onSaveSuccess: function (obj, action) {
        if (parseInt(action.result.error) === 0) {
            Ext.getCmp('txtLessonId').setValue(action.result.lessonId);
            Ext.Msg.alert("","登録されました.");
            var form = this.down("form");
            if (!this.isCreate) {
                if (this.activeRecord !== null) {
                    form.updateRecord(this.activeRecord);
                    this.activeRecord.set('departmentLabel', this.getDisplayValue('cbxDepartment'));
                }
            } else {
                var values = form.getValues();
                values['enterDepartmentLabel']=this.getDisplayValue('cbxDepartment');
                this.parent.store.insert(0, values);
                this.isCreate = false;
            }
        } else {
            Ext.Msg.alert("","失敗しました.");
        }
        this.getEl().unmask();
    },
    onSaveFailure: function () {
        Ext.Msg.alert("","失敗しました.");
        this.getEl().unmask();
    },
    onSaveBtnClick : function() {
        var form = this.down('form');
        if (form.isValid()) {
            this.getEl().mask();
            form.submit({
                url: 'lesson/save',
                scope: this,
                success: this.onSaveSuccess,
                failure: this.onSaveFailure
            });
        }
    }
});