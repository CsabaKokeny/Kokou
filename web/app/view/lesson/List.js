Ext.define('Kokou.view.lesson.List', {
    extend: 'Kokou.view.panel.SearchGridPanel',
    store: 'Lessons',
    initComponent: function () {
        var _this = this;
        this.columns = [
                {text: '課目名', dataIndex: 'name', menuDisabled: true},
                {text: '課目名(ハングル)', dataIndex: 'namekr', menuDisabled: true},
                {text: '種別', dataIndex: 'departmentLabel', menuDisabled: true},
                {text: '学年', dataIndex: 'level', menuDisabled: true},
                {text: '&nbsp;', dataIndex: '', menuDisabled: true,flex:1}
        ];
        if (!this.listeners) {
                this.listeners = {
                        scope: this
                };
        }
        this.listeners.itemdblclick = this.edit;
        this.dockedItems = [
            {
                dock: 'top',
                xtype: 'toolbar',
                items: [
                    {
                        width: 400,
                        fieldLabel: '',
                        labelWidth: 50,
                        xtype: 'textfield',
                        store: _this.store
                    },
                    {
                        xtype: 'button',
                        text: '検索'
                    },
                    '->',
                    {
                        iconCls: 'icon-add',
                        text: '追加',
                        scope: _this,
                        handler: function () {
                            _this.edit();
                        }
                    }
                ]
            },
        ];
        this.callParent(arguments);
    },
    edit: function (grid, record) {
        if (!!record) {
            var lessonId = record.get("lessonId");
            var url = 'lesson/detail?lessonId='+lessonId;
            var detailStore = Ext.create('Ext.data.Store',{
                model: 'Kokou.model.Lesson',    
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
            var wnd = Ext.create('Kokou.view.lesson.Edit', {
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
           var wnd = Ext.create('Kokou.view.lesson.Edit',{
               autoShow: false,
               isCreate: true,
               parent: this
            });
            wnd.show();
        }
    }
});