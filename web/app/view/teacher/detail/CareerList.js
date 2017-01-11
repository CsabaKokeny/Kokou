Ext.define('Kokou.view.teacher.detail.CareerList', {
    extend: 'Kokou.grid.RowEditPanel',
    readOnly: true,
    getNewRow: function () {
        return Ext.create('Kokou.model.TeacherCareer',{});
    },
    initComponent: function () {
        var _this= this;
        this.widgets={
            "career": function () {
                return _this.getStore();
            }
        };
        this.store = Ext.create('Kokou.store.TeacherCareer');
        this.columns = [
            {
                text: '勤務先', 
                dataIndex: 'place', 
                menuDisabled: true,
                flex:1,
                
            },
            {
                text: '入職年度',
                dataIndex: 'enterDate',
                menuDisabled: true,
                xtype:'datecolumn',
                format:'Y/m/d',
                
            },
            {
                text: '退職年度',
                dataIndex: 'retireDate',
                menuDisabled: true,
                xtype:'datecolumn',
                format:'Y/m/d',
                
            },
            {
                text: '業種別',
                dataIndex: 'job',
                menuDisabled: true,
            }
        ];
        
        this.callParent(arguments);
    }
  }) ;