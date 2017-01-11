Ext.define('Kokou.grid.RowEditPanel',{
    extend: 'Ext.grid.Panel',
    userConfig: {},
    marshaller: Ext.create('Kokou.xml.Marshaller'),
    unmarshaller: Ext.create('Kokou.json.Unmarshaller'),
    
    widgets:{},
    
    getMarshaller: function () {
        if (this.marshaller === null || this.marshaller === undefined) {
            this.marshaller = Ext.create('Kokou.xml.Marshaller');
        }
        return this.marshaller;
    },
    
    setMarshaller: function (marshaller) {
        this.marshaller = marshaller;
    },
    
    getFieldFactory: function () {
        if (this.fieldFactory === null || this.fieldFactory === undefined) {
            var userConfig = this.userConfig;
            if (userConfig === null || userConfig === undefined) userConfig = {};
            this.fieldFactory =Ext.create('Kokou.view.base.FieldFactory', userConfig);
        }
        return this.fieldFactory;
    },
    
    setFieldFactory: function (value) {
        this.fieldFactory = value;
    },
    
    getUnmarshaller: function () {
        if (this.unmarshaller === null || this.unmarshaller === undefined) {
            this.unmarshaller = Ext.create('Kokou.json.Unmarshaller');
        }
        return this.unmarshaller;
    },
    
    setUnmarshaller: function (unmarshaller) {
        this.unmarshaller = unmarshaller;
    },
    
    getRowEditing: function () {
        var _this = this;
        if (this.rowEditing === null || this.rowEditing === undefined || this.rowEditing === true) {
            this.rowEditing = Ext.create('Ext.grid.plugin.RowEditing',{
                clicksToMoveEditor: 2,
                autoCancel: false,
                scope: this,
                listeners: {
                    scope: this,
                    beforeedit: function (editor, context, eOpts) {
                        if (!!_this.onRowBeforeEdit && typeof _this.onRowBeforeEdit === 'function') {
                            _this.onRowBeforeEdit(editor, context, eOpts);
                        }
                    },
                    edit: function (editor, context, eOpts) {
                        if (!!_this.onRowEdit && typeof _this.onRowEdit === 'function') {
                            _this.onRowEdit(editor, context, eOpts);
                        }
                    },
                    canceledit: function (editor, context, eOpts) {
                        if (!!_this.onRowCancelEdit && typeof _this.onRowCancelEdit === 'function') {
                            _this.onRowCancelEdit(editor, context, eOpts);
                        }
                    }
                }
            });
        }
        return this.rowEditing;
    },
    
    getXmlData: function(widgets) {
        if (!!!widgets) {
            if ( !!this.widgets) {
                return this.getMarshaller().marshall(this.widgets);
            } else {
                return '';
            }
        } else {
            return this.getMarshaller().marshall(widgets);
        }
    },
    
    loadData: function (data) {
        this.getUnmarshaller().unmarshall(this.widgets, data);
    },
    
    loadStoreData: function (data) {
        if (data === null || data === undefined) data = {};
        if (data !== null && data !== undefined) {
            if (!!!data.push) {
                data = [data];
            }
        }else{
            data = [];
        }
        this.getStore().loadData(data, false);
    },
    
    getAddButton: function () {
        var _this = this;
        if (this.addButton === null || this.addButton === undefined) {
            this.addButton = Ext.create('Ext.button.Button', {
                iconCls: 'icon-add',
                text: '追加',
                disabled: !!this.readOnly,
                handler: function() {
                    if(!!_this.onAddRow && typeof _this.onAddRow === 'function') {
                        if (!!!_this.readOnly) {
                            _this.onAddRow();
                        }
                    }
                }
            });
        }
        return this.addButton;
    },
    
    setAddButton: function (button) {
        this.addButton = button;
    },
    
    getRemoveButton: function () {
        var _this = this;
        if (this.removeButton === null || this.removeButton === undefined) {
            this.removeButton = Ext.create('Ext.button.Button', {
                iconCls: 'icon-remove',
                text: '削除',
                disabled: !!this.readOnly,
                handler: function() {
                    if(!!_this.onRemoveRow && typeof _this.onRemoveRow === 'function' ) {
                        if (!!!_this.readOnly) {
                            _this.onRemoveRow();
                        }
                    }
                }
            });
        }
        return this.removeButton;
    },
    
    setRemoveButton: function (button) {
        this.removeButton = button;
    },
    
    initComponent: function () {
        var _this = this;
        var rowEditing = this.getRowEditing();
        if (!!!this.readOnly && !!rowEditing) {
            if (!!!this.plugins) {
                this.plugins = [];
            }
            if (this.plugins.length <= 0) {
                this.plugins.push(this.getRowEditing());
            }
        }
        if (!!!this.listeners) {
            this.listeners = {};
        }
        if (!!!this.listeners['itemdblclick']) {
            this.listeners['itemdblclick'] = function (obj, record, item, index, e, eOpts) {
                if (!!_this.onItemDblClick && typeof _this.onItemDblClick === 'function') {
                    _this.onItemDblClick(obj, record, item, index, e, eOpts);
                }
            };
        }
        if (!!!this.tbar) {
            this.tbar = [];
        }
        var addButton = this.getAddButton();
        var removeButton = this.getRemoveButton();
        if (!!addButton || !!removeButton) {
            this.tbar.push('->');
            if (!!addButton) {
                this.tbar.push(this.getAddButton());
            }
            if (!!removeButton) {
                this.tbar.push(this.getRemoveButton());
            }
        }
        this.callParent(arguments);
    },
    onRowBeforeEdit: function (eidtor, context, eOpts) {
        var removeButton = this.getRemoveButton();
        if (!!removeButton) {
            removeButton.setDisabled(true);
        }
    },
    onRowEdit: function (eidtor, context, eOpts) {
        var rowEditing = this.getRowEditing();
        if (!!rowEditing) {
            this.rowEditing.adding = false;
        }
        var removeButton = this.getRemoveButton();
        if (!!removeButton) {
            removeButton.setDisabled(false);
        }
    },
    onRowCancelEdit: function (editor, context, eOpts) {
        var rowEditing = this.getRowEditing();
        if (!!rowEditing) {
            var adding = !!rowEditing.adding;
            var store = this.getStore();
            var removeButton = this.getRemoveButton();
            rowEditing.adding = false;
            if (!!removeButton) {
                removeButton.setDisabled(false);
            }
            if (adding && !!store && store.getCount()>0) {
                store.removeAt(store.getCount()-1);
            }
        }
    },
    onItemDblClick: function (obj, record, item, index, e, eOpts) {
        var rowEditing = this.rowEditing;
        if (!!rowEditing) {
            var adding = !!rowEditing.adding;
            var store = this.getStore();
            rowEditing.adding = false;
            if (adding && !!store && store.getCount()>0) {
                store.removeAt(store.getCount()-1);
            }
        }
    },
    onAddRow: function () {
        var rowEditing = this.getRowEditing();
        if (!!rowEditing) {
            if (!!rowEditing.editing) {
                rowEditing.completeEdit();
            }
            if (!rowEditing.editing) {
                var store = this.getStore();
                if (!!store) {
                    if (!!!this.getNewRow) {
                        if (!!this.getNewRecord) {
                            this.getNewRow = this.getNewRecord;
                        } else if (this.newRecord) {
                            this.getNewRow = this.newRecord;
                        } else if (this.newRow) {
                            this.getNewRow = this.newRow;
                        }
                    }
                    if (!!this.getNewRow) {
                        var newRow = this.getNewRow();
                        if (!!newRow) {
                            store.add(newRow);
                            rowEditing.adding = true;
                            rowEditing.startEdit(store.getCount()-1,0);
                        }
                    }
                }
            }
        }
    },
    onRemoveRow: function() {
        var sm = this.getSelectionModel();
        var rowEditing = this.getRowEditing();
        if (!!rowEditing) {
            rowEditing.cancelEdit();
            var store = this.getStore();
            if (!!store) {
                store.remove(sm.getSelection());
                if (store.getCount()>0) {
                    sm.select(0);
                }
            }
        }
    }
});
