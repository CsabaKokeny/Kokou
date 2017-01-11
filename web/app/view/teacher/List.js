Ext.define('Kokou.view.teacher.List', {
    extend: 'Kokou.view.panel.SearchGridPanel',

    initComponent: function () {
        var _this = this;
        _this.store = Ext.create('Kokou.store.Teachers', {
            listeners: {
                load: function (thiStore, records, successful, eOpts) {
                    for(var i=0; i<records.length; i++) {
                        var record = records[i];
                        var teacherId = record.get('id');
                        if (!!_this.selected) {
                            if (!!_this.selected[teacherId]) {
                                record.set('selected', true);
                            }
                        }
                    }
                }
            }
        });
        
        _this.initDockComponents();
        _this.columns = [
            {
                menuDisabled: true,
                sortable: false,
                xtype: 'checkcolumn',
                dataIndex: 'selected',
                width: 50,
                listeners: {
                    dblclick: function () {
                        return false;
                    },
                    checkchange: function (thisColumn, rowIndex, checked, eOpts) {
                        if (!_this.selected) {
                            _this.selected=[];
                        }
                        var record = _this.getStore().getAt(rowIndex);
                        _this.selected[record.get('id')] = checked;
                        if (!checked) {
                            _this.selected.pop(record.get('id'));
                        }
                        for (var i in _this.selected) {
                            if (_this.selected[i] === true) {
                                _this.down('#btnDeleteSelectedTeacher').setDisabled(false);
                                return;
                            }
                        }
                        _this.down('#btnDeleteSelectedTeacher').setDisabled(true);
                    }
                }      
            },
            {text: '入職年度', dataIndex: 'enterDate', menuDisabled: true},
            {text: '入職種別', dataIndex: 'enterKind', menuDisabled: true},
            {text: '現役職', dataIndex: 'currentPosition', menuDisabled: true},
            {text: '氏名', dataIndex: 'name', menuDisabled: true},
            {text: '氏名(ハングル)', dataIndex: 'nameKr', menuDisabled: true},
            
            {text: '性別', dataIndex: 'sex', menuDisabled: true},
            {text: '生年月日', dataIndex: 'birth', menuDisabled: true, flex:0, xtype:'datecolumn', format:'Y/m/d'},
            {
                menuDisabled: true,
                sortable: false,
                xtype: 'actioncolumn',
                width: 50,
                items: [ {
                        icon: 'resources/icons/fam/delete.gif',
                        handler: function(grid, rowIndex, colIndex) {
                           var record = _this.getStore().getAt(rowIndex);
                           Ext.MessageBox.show({
                               title: '削除',
                               msg: '削除しますか?',
                               width: 300,
                               buttons: Ext.Msg.OKCANCEL,
                               buttonText: {
                                   ok: 'はい',
                                   cancel: 'いや'
                               },
                               icon: Ext.MessageBox.QUESTION,
                               closeable: true,
                               defaultFocus: 'cancel',
                               modal: true,
                               fn: function (buttonId, text, opt) {
                                   if (buttonId === 'ok') {
                                       var teacherId = record.get('id');
                                       Ext.Ajax.request({
                                           url: 'teacher2/delete',
                                           params: {
                                               "teacherId" : teacherId
                                           },
                                           success: function () {
                                                _this.getStore().reload();
                                           }
                                       });
                                   }
                               }
                           });
                        }
                    }
                ]
            }
        ];
        if (!_this.listeners) {
            _this.listeners = {
                scope: _this
            };
        }
        _this.listeners.itemdblclick = function(grid, record, item, index, e, eOpts) {
            _this.edit(grid, record, item, index, e, eOpts);
        };
        _this.bbar = Ext.create('Ext.PagingToolbar', {
            store: _this.getStore(),
            displayInfo: true,
            displayMsg: "Displaying topics {0} - {1} of {2}",
            emptyMsg: "No topics",
            items:[]
        });
        _this.callParent(arguments);
    },
    
    initDockComponents: function () {
        var _this = this;
        _this.dockedItems = [
            _this.createTopDockComponent()
        ];
    },
    
    createTopDockComponent: function () {
        var _this = this;
        var children = [];
        _this.widgetSchoolKindComboBoxForSearch = Ext.create('Kokou.view.form.field.SchoolKindComboBox',{
            width: 400,
            fieldLabel: '',
            labelWidth: 50
        });
        children.push('->');
        children.push(Ext.create('Ext.button.Button', {
            id: 'btnDeleteSelectedTeacher',
            disabled: true,
            iconCls: 'icon-remove',
            text: '削除',
            handler: function () {
                var teacherIds = [];
                if (!!_this.selected) {
                    for (var i in _this.selected) {
                        if (!!_this.selected[i]) {
                            teacherIds.push(i);
                        }
                    }
                }
                if (teacherIds.length<=0) return;
                Ext.MessageBox.show({
                    title: '削除',
                    msg: '選択された　学生たちを　削除しますか?',
                    width: 300,
                    buttons: Ext.Msg.OKCANCEL,
                    buttonText: {
                        ok: 'はい',
                        cancel: 'いや'
                    },
                    icon: Ext.MessageBox.QUESTION,
                    closeable: true,
                    defaultFocus: 'cancel',
                    modal: true,
                    fn: function (buttonId, text, opt) {
                        if (buttonId === 'ok') {
                            _this.selected=[];
                            Ext.Ajax.request({
                                url: 'teacher2/delete',
                                params: {
                                    "teacherId" : teacherIds
                                },
                                success: function () {
                                     _this.getStore().reload();
                                }
                            });
                        }
                    }
                })
            }
        }));
        children.push(Ext.create('Ext.button.Button', {
            iconCls: 'icon-add',
            text: '追加',
            handler: function () {
                _this.edit();
            }
        }));
        var dockItem = Ext.create('Ext.toolbar.Toolbar',{
            dock: 'top',
            items: children
        });
        return dockItem;
    },
    
    createBottomDockComponent: function () {
        var _this = this;
        var children = [];
        children.push('->');
        children.push({
            text: '印刷',
            disabled: false,
            scope: _this
        });
        var dockItem = Ext.create('Ext.toolbar.Toolbar',{
            dock: 'bottom',
            ui: 'footer',
            items: children
        });
        return dockItem;
    },
   
    showEditWindow: function (record) {
        var _this=this;
        var teacherId = record.get("id");
        var wnd = Ext.create('Kokou.view.teacher.Edit', {
            activeRecord: record,
            autoShow: false,
            isCreate: false,
            parent: _this
        });
        wnd.loadTeacher(teacherId, function() {
            wnd.show();
        });
    },
    showAddWindow: function () {
        var _this = this;
        var wnd = Ext.create('Kokou.view.teacher.Edit',{
            autoShow: false,
            isCreate: true,
            parent: _this
         });
         wnd.show();
    },
    showDetailWindow: function (record) {
        var _this=this;
        var teacherId = record.get("id");
        var wnd = Ext.create('Kokou.view.teacher.Detail', {
            activeRecord: record,
            autoShow: false,
            isCreate: false,
            parent: _this
        });
        wnd.loadTeacher(teacherId, function() {
            wnd.show();
        });
    },
    
    edit: function (grid, record, item, index, e, eOpts) {
        var _this = this;
        if (!!record) {
            _this.showDetailWindow(record);
        } else {
            _this.showAddWindow();
        }
    }
});