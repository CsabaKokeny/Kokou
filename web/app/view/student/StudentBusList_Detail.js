Ext.define('Kokou.view.student.StudentBusList_Detail', {
    extend: 'Ext.grid.Panel',
    loadData: function (data) {
        if (data === null || data === undefined) data = {};
        this.loadTransport(data.transport);
        this.setDuration(data.duration);
    },
    loadTransport: function (data) {
        if (data !== null && data !== undefined) {
            if (!!!data.push) {
                data = [data];
            }
        }else{
            data = [];
        }
        this.getStore().loadData(data, false);
    },
    setDuration: function (value) {
        if (value === null || value === undefined) value = '';
        this.down('#txtBusDuration').setValue(value);
        return this;
    },
    getDuration: function () {
        return this.down('#txtBusDuration').getValue();
    },
    initComponent: function () {
        var _this = this;
        this.store = Ext.create('Kokou.store.Transport', {});
        this.columns = [
            {
                text: '区間', 
                dataIndex: 'sector', 
                menuDisabled: true,
                editor: {
                    //xtype: 'combobox',
                    allowBlank:false
                }
            },
            {
                text: '駅&nbsp;&nbsp;～</span>',
                dataIndex: 'startStation',
                menuDisabled: true,
                editor: {
                    allowBlank:true
                }
            },
            {
                text: '駅',
                dataIndex: 'endStation',
                menuDisabled: true,
                editor: {
                    allowBlank:true
                }
            },
            {
                text: '利用交通手段',
                dataIndex: 'type',
                menuDisabled: true,
                editor: {
                   // xtype: 'combobox'
                }
            }
        ];
        this.callParent(arguments);
    },
    tbar: [
        {
            xtype:'textfield',
            id:'txtBusDuration',
            fieldLabel: '所要時間（分）'
        },
    ]
  }) ;