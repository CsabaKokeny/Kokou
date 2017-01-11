Ext.define('Kokou.view.student.StudentContactList', {
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
        for(var i=0;i<count;i++) {
            model = store.getAt(i);
            data += '<contact>';
            data += this.toXml('name', model.get('name'));
            data += this.toXml('phone', model.get('phone'));
            data += this.toXml('relation', model.get('relation'));
            data += '</contact>';
        }
        return data;
    },
    initComponent: function () {
        var _this = this;
        this.store = Ext.create('Kokou.store.Contact', {});
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
                editor: this.relationEditor
            }
        ];
        this.plugins = [Ext.create('Ext.grid.plugin.RowEditing',{
            clicksToMoveEditor: 2,
            autoCancel: true,
            scope: this,
            listeners: {
                scope: this,
                beforeedit: function (editor, context, eOpts) {
                    var combo = _this.relationEditor;
                    var data = _this.getSelectionModel().getSelection();
                    var _adding = !!_this.rowEditing.adding;
                    _this.down('#btnRemoveContact').setDisabled(true);
                    if (!!data[0] && !!data[0].get) {
                        combo.setValue(data[0].get('relation'));
                    }
                },
                edit: function (editor, context, eOpts) {
                    var combo = _this.relationEditor;
                    var data = _this.getSelectionModel().getSelection();
                    var _adding = !!_this.rowEditing.adding;
                    _this.rowEditing.adding = false;
                    _this.down('#btnRemoveContact').setDisabled(false);
                    data[0].set('relation', combo.getValue());
                    data[0].set('relationLabel', combo.getDisplayValue());
                },
                canceledit: function (editor, context, eOpts) {
                    var _adding = !!_this.rowEditing.adding;
                    _this.rowEditing.adding = false;
                    _this.down('#btnRemoveContact').setDisabled(false);
                    if (_adding) {
                        _this.store.removeAt(_this.store.getCount()-1);
                    }
                }
            }
        })];
        _this.rowEditing = _this.plugins[0];
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
            id: 'btnAddContact',
            iconCls: 'icon-add',
            text: '追加',
            handler: function() {
                var _this = this.up().up();
                if (!!_this.rowEditing.editing) {
                    _this.rowEditing.completeEdit();
                }
                if (!_this.rowEditing.editing) {
                    var r = Ext.create('Kokou.model.Contact',{});
                    _this.store.add(r);
                    _this.rowEditing.adding = true;
                    _this.rowEditing.startEdit(_this.store.getCount()-1, 0);
                }
            }
        },
        {
            id: 'btnRemoveContact',
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