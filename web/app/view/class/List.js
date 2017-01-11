Ext.define('Kokou.view.class.List', {
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
        _this.rowEditing = Ext.create('Ext.grid.plugin.RowEditing',{
            clicksToMoveEditor: 2,
            autoCancel: false,
            scope: this,
            listeners: {
                scope: this,
                beforeedit: function (editor, context, eOpts) {
                    var data = _this.getSelectionModel().getSelection();
                    if (!!data[0] && !!data[0].get) {
                        _this.schoolYearCellEditor.loadData(data[0].get('enterSchoolKind'));
                        _this.classNameCellEditor.loadData(data[0].get('enterSchoolKind'));
                        _this.schoolYearCellEditor.setValue(data[0].get('schoolYear'));
                        _this.classNameCellEditor.setValue(data[0].get('className'));
                    }
                },
                edit: function (editor, context, eOpts) {
                    var data = _this.getSelectionModel().getSelection();
                    var schoolYear = _this.schoolYearCellEditor.getValue();
                    var className = _this.classNameCellEditor.getValue();
                    var studentId =  data[0].get('id');
                    data[0].set('schoolYear',schoolYear);
                    data[0].set('className',className);
                    Ext.Ajax.request ({
                        url: 'student2/save?func=class&schoolYear='+schoolYear+'&className='+className+'&studentId='+studentId,
                        success: function (response) {}
                    });
                },
                canceledit: function (editor, context, eOpts) {
                }
            }
         });
        _this.plugins = [];
        _this.plugins.push(_this.rowEditing);
        
        _this.schoolYearCellEditor=Ext.create('Kokou.form.field.ComboBox', {
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                editable: false,
                data : []
            }),
            loadData: function (schoolKind) {
                if (schoolKind === 'H' || schoolKind === 'J') {
                    this.getStore().loadData([
                        {code:'1', label:'1'},
                        {code:'2', label:'2'},
                        {code:'3', label:'3'}
                    ]);
                } else if (schoolKind === 'P') {
                    this.getStore().loadData([
                        {code:'1', label:'1'},
                        {code:'2', label:'2'},
                        {code:'3', label:'3'},
                        {code:'4', label:'4'},
                        {code:'5', label:'5'},
                        {code:'6', label:'6'},
                    ]);
                } else if (schoolKind === 'E') {
                    this.getStore().loadData([
                        {code:'장미반', label:'장미반'},
                        {code:'무궁화반', label:'무궁화반'},
                        {code:'진달래반', label:'진달래반'},
                        {code:'개나리반', label:'개나리반'}
                        
                    ]);
                }
            }
        });
        _this.classNameCellEditor = Ext.create('Kokou.form.field.ComboBox',{
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                editable: false,
                data : []
            }),
            loadData: function (schoolKind) {
                if (schoolKind === 'H' || schoolKind === 'J' || schoolKind === 'P') {
                    this.getStore().loadData([
                        {code:'A', label:'A'},
                        {code:'B', label:'B'},
                        {code:'C', label:'C'},
                        {code:'D', label:'D'}
                    ]);
                    this.setDisabled(false);
                } else if (schoolKind === 'E') {
                    this.getStore().loadData([]);
                    this.setDisabled(true);
                    this.setValue('');
                }
            }
        });
        
        _this.columns = [
            {text: '学籍番号', dataIndex: 'fullCode', menuDisabled: true},
            {text: '氏名', dataIndex: 'name', menuDisabled: true},
            {text: '氏名(ハングル)', dataIndex: 'nameKr', menuDisabled: true},
            {text: 'クラス', dataIndex: 'classLabel', menuDisabled: true},
            {text: '性別', dataIndex: 'sexLabel', menuDisabled: true},
            {text: '生年月日', dataIndex: 'birth', menuDisabled: true, flex:0, xtype:'datecolumn', format:'Y/m/d'},
            {text: '本籍', dataIndex: 'nationLabel', menuDisabled: true},
            {text: '年生', dataIndex: 'schoolYear', menuDisabled: true, editor: _this.schoolYearCellEditor},
            {text: 'クラス', dataIndex: 'className', menuDisabled: true, editor: _this.classNameCellEditor}
        ];
        if (!_this.listeners) {
            _this.listeners = {
                scope: _this
            };
        }
        _this.listeners.itemdblclick = function (grid, record, item, index, e, eOpts) {
            
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
        _this.widgetEnterYearForSearch = Ext.create('Ext.form.field.Text', {
            width: 200
        });
        _this.widgetEnterSchoolKindComboBoxForSearch = Ext.create('Kokou.view.form.field.SchoolKindComboBox',{
            width: 200,
            fieldLabel: '',
            labelWidth: 50,
            editable: false,
            value: '',
            listeners: {
                change: function (obj, newValue, oldValue, eOpts) {
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
                    { code: '0', label:'全体' }
                ]
            })
        });
        children.push(_this.widgetEnterYearForSearch);
        children.push(_this.widgetEnterSchoolKindComboBoxForSearch);
        children.push(Ext.create('Ext.button.Button', {
            text: '検索',
            handler: function () {
                var param = '';
                param += 'enterYear=' + _this.widgetEnterYearForSearch.getValue();
                param += '&enterSchoolKind='+ _this.widgetEnterSchoolKindComboBoxForSearch.getValue();
                _this.getStore().getProxy().url = 'student2/list?'+param;
                _this.getStore().loadPage(1);
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
    }
});