Ext.define('Kokou.view.teacher.detail.BusList', {
    extend: 'Kokou.grid.RowEditPanel',
    readOnly:true,
    _this: this,
    widgets: {
        attending: {
            duration: Ext.create('Ext.form.field.Text',{
                fieldLabel: '所要時間（分）',
                labelWidth: 110,
                readOnly: true
            }),
            totalCost: Ext.create('Ext.form.field.Text',{
                fieldLabel: '１ヶ月合計金額（１ヶ月基準）',
                labelWidth:190,
                width:240,
                readOnly: true
            }),
            driverCard: {
                has: Ext.create('Ext.form.field.Checkbox', {
                    fieldLabel: '運転免（有・無）',
                    labelWidth: 110,
                    readOnly: true
                }),
                kind: Ext.create('Ext.form.field.Text', {
                    fieldLabel: '種類',
                    labelWidth:110,
                    readOnly: true
                })
            },
            transport: null
        }
    },
    initComponent: function () {
        var _this = this;
        _this.widgets.attending.transport = function () {
            return _this.getStore();
        };
        _this.store = Ext.create('Kokou.store.TeacherTransport', {});
        _this.columns = [
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
                text: '金額',
                dataIndex: 'cost',
                menuDisabled: true,
                editor: {}
            }
        ];
        _this.tbar = [
            _this.widgets.attending.totalCost,
            {
                xtype: 'fieldcontainer',
                items: [
                    _this.widgets.attending.duration,
                    _this.widgets.attending.driverCard.has,
                    _this.widgets.attending.driverCard.kind
                ]
            }
        ];
        _this.callParent(arguments);
    }
}) ;