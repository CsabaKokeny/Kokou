Ext.define('Kokou.view.user.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.userlist',
	
	title: 'All Users',
	
	store: 'Users',
	
	initComponent: function () {
		this.columns = [
			{text: 'Name', dataIndex: 'name', menuDisabled: true},
			{text: 'Email', dataIndex: 'email', menuDisabled: true, flex:1}
		];
		if (!this.listeners) {
			this.listeners = {
				scope: this
			};
		}
		this.listeners.itemdblclick = this.edit;
		this.callParent(arguments);
	},
	edit: function () {
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
		}
	]
});