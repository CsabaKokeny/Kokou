Ext.define('Kokou.view.teacher.edit.RewardPunishmentList', {
    extend: 'Kokou.grid.RowEditPanel',
    getNewRow: function () {
        return Ext.create('Kokou.model.TeacherRewardPunishment');
    },
    initComponent: function () {
        var _this= this;
        this.widgets={
            "rewardPunishment": function () {
                return _this.getStore();
            }
        },
        this.store = Ext.create('Kokou.store.TeacherRewardPunishment');
        this.columns = [
            {
                text: '年月日', 
                dataIndex: 'date',
                menuDisabled: true,
                xtype:'datecolumn',
                format:'Y/m/d',
                editor: {
                    xtype: 'datefield',
                    format:'Y/m/d'
                }
            },
            {
                text: '内容',
                dataIndex: 'content',
                menuDisabled: true,
                flex:1,
                editor: {
                }
            }
        ];
        this.callParent(arguments);
    }
  }) ;