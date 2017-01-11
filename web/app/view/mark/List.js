Ext.define('Kokou.view.mark.List', {
	extend: 'Kokou.view.panel.SearchGridPanel',
	store: 'Marks',
	
	initComponent: function () {
		this.columns = [
			{text: '&nbsp;', dataIndex: '', menuDisabled: true,flex:1}
		];
		if (!this.listeners) {
			this.listeners = {
				scope: this
			};
		}
		this.listeners.itemdblclick = this.edit;
		this.callParent(arguments);
	},
	edit: function (grid, record) {
		var view = Ext.create('Kokou.view.mark.Edit');
		view.down('form').loadRecord(record);
	},
	dockedItems: [
		{
			dock: 'top',
			xtype: 'toolbar',
			items: [
				{
					width: 400,
					fieldLabel: '',
					labelWidth: 50,
					xtype: 'textfield',
					store: this.store
				},
				{
					xtype: 'button',
					text: '検索',
				},
				'->',
				{
					iconCls: 'icon-add',
					text: '追加',
					scope: this,
					handler: this.onAddClick
				},
			]
		},
		{
			dock: 'bottom',
			xtype: 'toolbar',
			ui: 'footer',
			items: ['->',
				{
                    text: '印刷',
                    disabled: false,
                    scope: this,
                }
			]
		}
	]
});