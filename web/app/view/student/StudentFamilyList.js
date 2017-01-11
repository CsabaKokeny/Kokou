Ext.define('Kokou.view.student.StudentFamilyList', {
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
    toXml: function (tag, value) {
        if (value === null || value === undefined) return '';
        return '<'+tag+'>'+value+'</'+tag+'>';
    },
    getXmlData: function () {
        var store = this.getStore();
        var count = store.getCount();
        var model;
        var data = '';
        var marshaller = Ext.create('Kokou.xml.Marshaller',{});
        for(var i=0;i<count;i++) {
            model = store.getAt(i);
            data += '<family>';
            data += this.toXml('relation', model.get('relation'));
            data += this.toXml('name', model.get('name'));
            data += marshaller.marshall({tag:'birth', data:model.get('birth')});
            data += this.toXml('address', model.get('address'));
            data += this.toXml('with', model.get('with'));
            data += this.toXml('note', model.get('note'));
            data += '</family>';
        }
        return data;
    },
    initComponent: function () {
        var _this= this;
        this.store = Ext.create('Kokou.store.Family', {});
        this.relationEditor =  Ext.create('Ext.form.field.ComboBox',{
            queryMode: 'local',
            displayField: 'label',
            valueField: 'code',
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                proxy: {
                    type: 'ajax',
                    url: 'relation_type/list',
                    reader:  {
                        type: 'json',
                        root: 'data'
                    }
                },
                autoLoad: true
            })
        });
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
        this.plugins = [Ext.create('Ext.grid.plugin.RowEditing',{
            clicksToMoveEditor: 1,
            autoCancel: false,
            scope: this,
            listeners: {
                scope: this,
                beforeedit: function (editor, context, eOpts) {
                    var combo = _this.relationEditor;
                    var data = _this.getSelectionModel().getSelection();
                    var _adding = !!_this.rowEditing.adding;
                    _this.down('#btnRemoveFamily').setDisabled(true);
                    if (!!data[0] && !!data[0].get) {
                        combo.setValue(data[0].get('relation'));
                    }
                },
                edit: function (editor, context, eOpts) {
                    var combo = _this.relationEditor;
                    var data = _this.getSelectionModel().getSelection();
                    var _adding = !!_this.rowEditing.adding;
                    _this.rowEditing.adding = false;
                    _this.down('#btnRemoveFamily').setDisabled(false);
                    data[0].set('relation', combo.getValue());
                    data[0].set('relationLabel', combo.getDisplayValue());
                },
                canceledit: function (editor, context, eOpts) {
                    var _adding = !!_this.rowEditing.adding;
                    _this.rowEditing.adding = false;
                    _this.down('#btnRemoveFamily').setDisabled(false);
                    if (_adding) {
                        _this.store.removeAt(_this.store.getCount()-1);
                    }
                }
            }
        })];
        this.rowEditing = this.plugins[0];
        _this.listeners = {
            itemdblclick: function (thisObj, record, item, index, e, eOpts) {
                var _adding = !!_this.rowEditing.adding;
                _this.rowEditing.adding = false;
                if (_adding) {
                    _this.store.removeAt(_this.store.getCount()-1);
                }
            }
        };
        this.callParent(arguments);
    },
    tbar: [
        '->',
        {
            id: 'btnAddFamily',
            iconCls: 'icon-add',
            text: '追加',
            handler: function() {
                var _this = this.up().up();
                if (!!_this.rowEditing.editing) {
                    _this.rowEditing.completeEdit();
                }
                if (!_this.rowEditing.editing) {
                    var r = Ext.create('Kokou.model.Family',{});
                    _this.store.add(r);
                    _this.rowEditing.adding = true;
                    _this.rowEditing.startEdit(_this.store.getCount()-1, 0);
                }
            }
        },
        {
            id: 'btnRemoveFamily',
            iconCls: 'icon-remove',
            text: '削除',
            handler: function() {
                var _this = this.up().up();
                var sm = _this.getSelectionModel();
                _this.rowEditing.cancelEdit();
                _this.store.remove(sm.getSelection());
                if (_this.store.getCount()>0) {
                    sm.select(0);
                }
            }
        }
    ]
  }) ;