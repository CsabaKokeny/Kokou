Ext.define('Kokou.view.teacher.detail.RewardPunishmentList', {
    extend: 'Kokou.grid.RowEditPanel',
    readOnly: true,
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
            },
            {
                text: '内容',
                dataIndex: 'content',
                menuDisabled: true,
                flex:1,
            }
        ];
        this.callParent(arguments);
    }
  }) ;