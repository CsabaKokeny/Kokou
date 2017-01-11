Ext.define('Kokou.view.student.List', {
    extend: 'Kokou.view.panel.SearchGridPanel',

    initComponent: function () {
        var _this = this;
        _this.store = Ext.create('Kokou.store.Students', {
            listeners: {
                load: function (thiStore, records, successful, eOpts) {
                    for(var i=0; i<records.length; i++) {
                        var record = records[i];
                        var studentId = record.get('id');
                        if (!!_this.selected) {
                            if (!!_this.selected[studentId]) {
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
                                _this.down('#btnDeleteSelectedStudent').setDisabled(false);
                                return;
                            }
                        }
                        _this.down('#btnDeleteSelectedStudent').setDisabled(true);
                    }
                }      
            },
            {text: '学籍番号', dataIndex: 'fullCode', menuDisabled: true},
            {text: '氏名', dataIndex: 'name', menuDisabled: true},
            {text: '氏名(ハングル)', dataIndex: 'nameKr', menuDisabled: true},
            {text: 'クラス', dataIndex: 'classLabel', menuDisabled: true},
            {text: '性別', dataIndex: 'sexLabel', menuDisabled: true},
            {text: '生年月日', dataIndex: 'birth', menuDisabled: true, flex:0, xtype:'datecolumn', format:'Y/m/d'},
            {text: '本籍', dataIndex: 'nationLabel', menuDisabled: true},
            //{text: '学校', dataIndex: 'departmentLabel', menuDisabled: true},
            //{text: '入学年度', dataIndex: 'enterDate', menuDisabled: true, flex:0, xtype:'datecolumn', format:'Y/m/d'},
            //{text: '入学種別', dataIndex: 'enterDepartmentLabel', menuDisabled: true},
            //{text: '入学学年', dataIndex: 'enterLevel', menuDisabled: true, flex: 1}
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
                                       var studentId = record.get('id');
                                       Ext.Ajax.request({
                                           url: 'student2/delete',
                                           params: {
                                               "studentId" : studentId
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
        _this.listeners.itemdblclick = function (grid, record, item, index, e, eOpts) {
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
            width: 200,
            fieldLabel: '',
            labelWidth: 50,
            editable: false,
            value: '',
            listeners: {
                change: function (obj, newValue, oldValue, eOpts) {
                    if (newValue === 'H' || newValue === 'J' || newValue ==='P') {
                        if (newValue === 'H' || newValue === 'J') {
                            _this.widgetSchoolYearComboBoxForSearch.getStore().loadData([
                                { code: '', label:  '全体'},
                                { code: '1', label:  '1' },
                                { code: '2', label:  '2' },
                                { code: '3', label:  '3' }
                            ]);
                        } else if (newValue === 'P') {
                            _this.widgetSchoolYearComboBoxForSearch.getStore().loadData([
                                { code: '', label:  '全体'},
                                { code: '1', label:  '1' },
                                { code: '2', label:  '2' },
                                { code: '4', label:  '4' },
                                { code: '5', label:  '5' },
                                { code: '6', label:  '6' }
                            ]);
                        }
                        _this.widgetClassNameComboBoxForSearch.getStore().loadData([
                            { code: '', label:  '全体'},
                            { code: 'A', label:  'A' },
                            { code: 'B', label:  'B' },
                            { code: 'C', label:  'C' },
                            { code: 'D', label:  'D' }
                        ]);
                    } else if (newValue === 'E') {
                        _this.widgetSchoolYearComboBoxForSearch.getStore().loadData([
                            { code: '', label:  '全体'},
                            { code: '장미반', label:  '장미반'},
                            { code: '무궁화반', label:  '무궁화반'},
                            { code: '진달래반', label:  '진달래반'},
                            { code: '개나리반', label:  '개나리반'}
                        ]);
                        _this.widgetClassNameComboBoxForSearch.getStore().loadData([
                            { code: '', label:  '全体'}
                        ]);
                    }
                    
                }
            }
        });
        _this.widgetSchoolYearComboBoxForSearch = Ext.create('Ext.form.field.ComboBox',{
            displayField: 'label',
            valueField: 'code',
            width:200,
            editable: false,
            value: '',
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                data: [
                    { code: '', label:'全体' }
                ]
            })
        });
        _this.widgetClassNameComboBoxForSearch = Ext.create('Ext.form.field.ComboBox',{
            displayField: 'label',
            valueField: 'code',
            width:200,
            editable: false,
            value: '',
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                data: [
                    { code: '', label:'全体' }
                ]
            })
        });
        children.push(_this.widgetSchoolKindComboBoxForSearch);
        children.push(_this.widgetSchoolYearComboBoxForSearch);
        children.push(_this.widgetClassNameComboBoxForSearch);
        children.push(Ext.create('Ext.button.Button', {
            text: '検索',
            handler: function () {
                var url = '';
                url += 'student2/list?schoolKind='+ _this.widgetSchoolKindComboBoxForSearch.getValue();
                url += '&schoolYear='+_this.widgetSchoolYearComboBoxForSearch.getValue();
                url += '&className='+_this.widgetClassNameComboBoxForSearch.getValue();
                _this.getStore().getProxy().url= url;
                _this.getStore().loadPage(1);
            }
        }));
        children.push('->');
        children.push(Ext.create('Ext.button.Button', {
            id: 'btnDeleteSelectedStudent',
            disabled: true,
            iconCls: 'icon-remove',
            text: '削除',
            handler: function () {
                var studentIds = [];
                if (!!_this.selected) {
                    for (var i in _this.selected) {
                        if (!!_this.selected[i]) {
                            studentIds.push(i);
                        }
                    }
                }
                if (studentIds.length<=0) return;
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
                                url: 'student2/delete',
                                params: {
                                    "studentId" : studentIds
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
        var _this = this;
        if (!!record) {
            var studentId = record.get("id");
            var wnd = Ext.create('Kokou.view.student.Edit', {
                activeRecord: record,
                autoShow: false,
                isCreate: false,
                parent: _this
            });
            wnd.loadStudent(studentId, function() {
                wnd.show();
            });
        }
    },
    
    showDetailWindow: function (record) {
        var _this = this;
        if (!!record) {
            var studentId = record.get("id");
            var wnd = Ext.create('Kokou.view.student.Detail', {
                activeRecord: record,
                autoShow: false,
                parent: _this
            });
            wnd.loadStudent(studentId, function() {
                wnd.show();
            });
        }
    },
    showAddWindow: function() {
        var _this = this;
        var wnd = Ext.create('Kokou.view.student.Edit',{
            autoShow: false,
            isCreate: true,
            parent: _this
         });
         wnd.show();
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