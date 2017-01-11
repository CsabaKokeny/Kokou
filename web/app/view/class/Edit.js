Ext.define('Kokou.view.class.Edit', {
    extend:  'Kokou.view.base.Window',
    //extend:'Ext.window.Window',
    title: '&nbsp;',
    layout: 'border',
    autoShow: true,
    modal: true,
    width: 500,
    height: 245,
    initComponent: function () {
        this.items = [
            {
                xtype: 'form',
                id: 'frmClassEdit',
                region: 'north',
                frame: true,
                collapsible: false,
                bodyPadding: '10,20',
                defaults: {
                    anchor: '80%'
                },
                items: [
                    this.createHiddenfield({id:'txtClassId', name:'classId'}),
                    this.createDepartmentCombobox({id:'cbxDepartment',name:'department', fieldLabel:'種別'}),
                    this.createLevelNumberfield({id:'txtLevel', name:'level', fieldLabel:'学年'}),
                    this.createTextfield({id:'txtName', name:'name', fieldLabel:'クラス人'}),
                    this.createTextfield({id:'txtNamekr', name:'namekr', fieldLabel:'クラス人（ハングル）'}),
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
            Ext.getCmp('txtClassId').setValue(action.result.classId);
            Ext.Msg.alert("","登録されました.");
            var form = this.down("form");
            if (!this.isCreate) {
                if (this.activeRecord !== null) {
                    form.updateRecord(this.activeRecord);
                    var combo = Ext.getCmp('cbxDepartment');
                    this.activeRecord.set('departmentLabel', combo.findRecordByValue(combo.getValue()).get("label"));
                }
            } else {
                var values = form.getValues();
                var combo = Ext.getCmp('cbxDepartment');
                values['departmentLabel']=combo.findRecordByValue(combo.getValue()).get("label");
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
                url: 'class/save',
                scope: this,
                success: this.onSaveSuccess,
                failure: this.onSaveFailure
            });
        }
    }
});