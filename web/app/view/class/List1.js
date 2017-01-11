Ext.define('Kokou.view.class.List', {
    extend: 'Kokou.view.panel.SearchGridPanel',
    store: 'Classes',

    initComponent: function () {
        this.columns = [
            {text: 'クラス人', dataIndex: 'name', menuDisabled: true},
            {text: 'クラス人(ハングル）', dataIndex: 'namekr', menuDisabled: true},
            {text: '種別', dataIndex: 'departmentLabel', menuDisabled: true},
            {text: '学　年', dataIndex: 'level', menuDisabled: true},
            {text: '&nbsp;', dataIndex: '', menuDisabled: true,flex:1}
        ];
        if (!this.listeners) {
            this.listeners = {
                scope: this
            };
        }
        this.listeners.itemdblclick = this.edit;
        this.callParent(arguments);
    },
    
    edit: function (grid, record) {
        if (!!record) {
            var classId = record.get("classId");
            var url = 'class/detail?classId='+classId;
            var detailStore = Ext.create('Ext.data.Store',{
                model: 'Kokou.model.Class',    
                proxy: {
                    type: 'ajax',
                    url: url,
                    reader: {
                        type:'json',
                        root:'data',
                        successProperty:'success'
                    }
                }
            });
            var wnd = Ext.create('Kokou.view.class.Edit', {
                activeRecord: record,
                autoShow: false,
                isCreate: false,
                parent: this
            });
            detailStore.load(function(records, operation, success){ 
                wnd.down('form').loadRecord(detailStore.getAt(0));
                wnd.show();
            });
        } else {
           var wnd = Ext.create('Kokou.view.class.Edit',{
               autoShow: false,
               isCreate: true,
               parent: this
            });
            wnd.show();
        }
    },
    dockedItems: [
        {
            dock: 'top',
            xtype: 'toolbar',
            scope: this,
            items: [
                {
                    width: 400,
                    fieldLabel: '',
                    labelWidth: 50,
                    xtype: 'textfield',
                    store: this.store
                },
                {
                    xtype: 'button',
                    text: '検索'
                },
                '->',
                {
                    iconCls: 'icon-add',
                    text: '追加',
                    handler: function () {
                        this.up().up().edit();
                    }
                }
            ]
        },
    ]
});