Ext.define('Kokou.view.student.StudentCareerList', {
    extend: 'Ext.grid.Panel',
    rowEditing:null,
    loadData: function (data) {
        if (data !== null && data !== undefined) {
            if (!!!data.push) {
                data = [data];
            }
        }else{
            data = [];
        }
        this.getStore().loadData(data, false);
        return this;
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
            data += '<career>';
            data += marshaller.marshall({ tag:'schoolName', data:model.get("schoolName")});
            data += marshaller.marshall({ tag:'schoolState', data:model.get("schoolState")});
            data += marshaller.marshall({ tag:'preSchoolName', data:model.get("preSchoolName")});
            data += marshaller.marshall({ tag:'enterDate', data:model.get("enterDate")});
            data += marshaller.marshall({ tag:'admitDate', data:model.get("admitDate")});
            data += marshaller.marshall({ tag:'explusionDate', data:model.get("explusionDate")});
            data += '</career>';
        }
        return data;
    },
    initComponent: function () {
        var _this= this;
        this.store = Ext.create('Ext.data.Store', {
            fields:[
                'schoolName',
                'schoolState',
                'schoolStateLabel',
                'preSchoolName',
                {name:'enterDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
                {name:'admitDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
                {name:'explusionDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'}
            ],            
            data: [],
            proxy: {
                type: 'memory'
            }
        });
        this.stateTypeEditor =  Ext.create('Ext.form.field.ComboBox',{
            queryMode: 'local',
            displayField: 'label',
            valueField: 'code',
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                proxy: {
                    type: 'ajax',
                    url: 'school_state_type/list',
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
                text: '学校名', 
                dataIndex: 'schoolName', 
                menuDisabled: true,
                flex:1,
                editor: {
                    allowBlank:false
                }
            },
            {
                text: '種別',
                dataIndex: 'schoolStateLabel',
                menuDisabled: true,
                editor: this.stateTypeEditor
            },
            {
                text: '入学年月日',
                dataIndex: 'enterDate',
                menuDisabled: true,
                xtype:'datecolumn',
                format:'Y/m/d',
                editor: {
                    xtype: 'datefield',
                    format:'Y/m/d'
                }
            },
            {
                text: '転出先の学校名',
                dataIndex: 'preSchoolName',
                menuDisabled: true,
                editor: {
                }
            },
            {
                text: '転学年月日',
                dataIndex: 'admitDate',
                menuDisabled: true,
                xtype:'datecolumn',
                format:'Y/m/d',
                editor: {
                    xtype: 'datefield',
                    format:'Y/m/d'
                }
            },
            {
                text: '卒業年月日',
                dataIndex: 'explusionDate',
                menuDisabled: true,
                xtype:'datecolumn',
                format:'Y/m/d',
                editor: {
                    xtype: 'datefield',
                    format:'Y/m/d'
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
                    var combo = _this.stateTypeEditor;
                    var data = _this.getSelectionModel().getSelection();
                    var _adding = !!_this.rowEditing.adding;
                    _this.down('#btnRemoveCareer').setDisabled(true);
                    if (!!data[0] && !!data[0].get) {
                        combo.setValue(data[0].get('schoolState'));
                    }
                },
                edit: function (editor, context, eOpts) {
                    var combo = _this.stateTypeEditor;
                    var data = _this.getSelectionModel().getSelection();
                    var _adding = !!_this.rowEditing.adding;
                    _this.rowEditing.adding = false;
                    _this.down('#btnRemoveCareer').setDisabled(false);
                    data[0].set('schoolState', combo.getValue());
                    data[0].set('schoolStateLabel', combo.getDisplayValue());
                },
                canceledit: function (editor, context, eOpts) {
                    var _adding = !!_this.rowEditing.adding;
                    _this.rowEditing.adding = false;
                    _this.down('#btnRemoveCareer').setDisabled(false);
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
            id: 'btnAddCareer',
            iconCls: 'icon-add',
            text: '追加',
            handler: function() {
                var _this = this.up().up();
                if (!!_this.rowEditing.editing) {
                    _this.rowEditing.completeEdit();
                }
                if (!_this.rowEditing.editing) {
                    var r = Ext.create('Kokou.model.Career',{});
                    _this.store.add(r);
                    _this.rowEditing.adding = true;
                    _this.rowEditing.startEdit(_this.store.getCount()-1, 0);
                }
            }
        },
        {
            id: 'btnRemoveCareer',
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