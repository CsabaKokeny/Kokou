Ext.define('Kokou.view.teacher.detail.FamilyList', {
    extend: 'Kokou.view.teacher.edit.RowEditPanelWithEditors',
    readOnly: true,
    getNewRow: function () {
        return Ext.create('Kokou.model.TeacherFamilyMember');
    },
    initComponent: function () {
        var _this= this;
        this.store = Ext.create('Kokou.store.TeacherFamilyMember', {
            
        });
        this.widgets = {
            "familyInformation": {
                "numberOfDependent": Ext.create('Ext.form.field.Text',{
                    fieldLabel: '扶養家族数',
                    labelWidth:190,
                    width:240,
                    readOnly: true,
                }),
                "family": function () {
                    return _this.getStore();
                }
            }
        };
        this.columns = [
            {
                text: '本人', 
                dataIndex: 'relation', 
                menuDisabled: true,
                
            },
            {
                text: '氏名',
                dataIndex: 'name',
                menuDisabled: true,
                
            },
            {
                text: '生年月日',
                dataIndex: 'birth',
                xtype:'datecolumn',
                menuDisabled: true,
                format: 'Y/m/d',
                
            },
            {
                text: '職業又は在学校名・学年',
                dataIndex: 'address',
                menuDisabled: true,
                
            },
            {
                text: '同居別',
                dataIndex: 'with',
                menuDisabled: true,
                xtype: 'checkcolumn',
                flex: 1,
                readOnly: true
            },
            {
                text: '備考',
                dataIndex: 'note',
                menuDisabled: true,
            }
        ];
        this.tbar = [];
        this.tbar.push(this.widgets.familyInformation.numberOfDependent);
        this.callParent(arguments);
    }
  }) ;