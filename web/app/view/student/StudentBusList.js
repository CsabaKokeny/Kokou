Ext.define('Kokou.view.student.StudentBusList', {
    extend: 'Ext.grid.Panel',
    readOnly: true,
    setReadOnly: function (value) {
        this.readOnly = !!value;
        if (this.readOnoy) {
            if (!!this.rowEditing) {
                this.rowEditing.disable();
            }
        } else {
            if (!!this.rowEditing) {
                this.rowEditing.enable();
            }
        }
    },
    getReadOnly: function() {
        return !!(this.readOnly);
    },
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
    toXml: function (tag, value) {
        if (value === null || value === undefined) return '';
        return '<'+tag+'>'+value+'</'+tag+'>';
    },
    getXmlData: function () {
        var store = this.getStore();
        var count = store.getCount();
        var marshaller = Ext.create('Kokou.xml.Marshaller',{});
        var model;
        var data = '';
        data += '<attending>';
        data += marshaller.marshall({tag:'duration', data:this.getDuration()});
        for(var i=0;i<count;i++) {
            model = store.getAt(i);
            data += '<transport>';
            data += marshaller.marshall({tag:'sector', data:model.get('sector')});
            data += marshaller.marshall({tag:'startStation', data:model.get('startStation')});
            data += marshaller.marshall({tag:'endStation', data:model.get('endStation')});
            data += marshaller.marshall({tag:'type', data:model.get('type')});
            data += '</transport>';
        }
        data += '</attending>';
        return data;
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
        this.plugins = [Ext.create('Ext.grid.plugin.RowEditing',{
            clicksToMoveEditor: 2,
            autoCancel: false,
            scope: this,
            listeners: {
                scope: this,
                beforeedit: function (editor, context, eOpts) {
                    _this.down('#btnRemoveBus').setDisabled(true);
                },
                edit: function (editor, context, eOpts) {
                    _this.rowEditing.adding = false;
                },
                canceledit: function (eidtor, context, eOpts) {
                    var _adding = !!_this.rowEditing.adding;
                    _this.rowEditing.adding = false;
                    _this.down('#btnRemoveBus').setDisabled(false);
                    if (_adding) {
                        _this.store.removeAt(_this.store.getCount()-1);
                    }   
                }
            }
        })];
        _this.rowEditing = this.plugins[0];
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
        {
            xtype:'textfield',
            id:'txtBusDuration',
            fieldLabel: '所要時間（分）'
        },
        '->',
        {
            id: 'btnAddBus',
            iconCls: 'icon-add',
            text: '追加',
            handler: function() {
                var _this = this.up().up();
                if (!!_this.rowEditing.editing) {
                    _this.rowEditing.completeEdit();
                }
                if (!_this.rowEditing.editing) {
                    var r = Ext.create('Kokou.model.Transport',{});
                    _this.store.add(r);
                    _this.rowEditing.adding = true;
                    _this.rowEditing.startEdit(_this.store.getCount()-1, 0);
                }
            }
        },
        {
            id: 'btnRemoveBus',
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