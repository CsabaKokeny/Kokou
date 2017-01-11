Ext.define('Kokou.view.student.StudentContactList_Detail', {
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
        var _this = this;
        this.store = Ext.create('Kokou.store.Contact', {});
        this.columns = [
            {
                text: '連絡先氏名', 
                dataIndex: 'name', 
                menuDisabled: true,
                editor: {
                    allowBlank:false
                }
            },
            {
                text: '電話番号',
                dataIndex: 'phone',
                menuDisabled: true,
                editor: {
                    allowBlank:false
                }
            },
            {
                text: '本人との関係',
                dataIndex: 'relationLabel',
                menuDisabled: true,
            }
        ];
        this.callParent(arguments);
    }
  }) ;