Ext.define('Kokou.view.student.StudentFamilyList_Detail', {
    extend: 'Ext.grid.Panel',
    loadData: function (data) {
        if (data !== null && data !== undefined) {
            if (!!!data.push) {
                data = [data];
            }
        }else{
            data = [];
        }
        this.getStore().loadData(data, false);
        
        
    },
    
    initComponent: function () {
        var _this= this;
        this.store = Ext.create('Kokou.store.Family', {});
        this.columns = [
            {
                text: '本人', 
                dataIndex: 'relationLabel', 
                menuDisabled: true,
                editor: this.relationEditor
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
                flex: 1,
                editor: {
                    xtype:'checkbox'
                }
            },
            {
                text: '備考',
                dataIndex: 'note',
                menuDisabled: true,
                editor: {
                    
                }
            }
        ];
        this.callParent(arguments);
    }
  }) ;