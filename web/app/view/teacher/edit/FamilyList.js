Ext.define('Kokou.view.teacher.edit.FamilyList', {
    extend: 'Kokou.view.teacher.edit.RowEditPanelWithEditors',
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
                    width:240
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
                editor: this.getRelationEditor()
            },
            {
                text: '氏名',
                dataIndex: 'name',
                menuDisabled: true,
                editor: {
                    allowBlank:false
                }
            },
            {
                text: '生年月日',
                dataIndex: 'birth',
                xtype:'datecolumn',
                menuDisabled: true,
                format: 'Y/m/d',
                editor: {
                    xtype: 'datefield',
                    format: 'Y/m/d'
                }
            },
            {
                text: '職業又は在学校名・学年',
                dataIndex: 'address',
                menuDisabled: true,
                editor: {
                    
                }
            },
            {
                text: '同居別',
                dataIndex: 'with',
                menuDisabled: true,
                xtype: 'checkcolumn',
                flex: 1
            },
            {
                text: '備考',
                dataIndex: 'note',
                menuDisabled: true,
                editor: {
                    
                }
            }
        ];
        this.tbar = [];
        this.tbar.push(this.widgets.familyInformation.numberOfDependent);
        this.callParent(arguments);
    }
  }) ;