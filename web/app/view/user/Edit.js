Ext.define('Kokou.view.user.Edit', {
	extend:  'Ext.window.Window',
	alias: 'widget.useredit',
	
	title: 'Edit User',
	layout: 'fit',
	autoShow: true,
	modal: true,
	initComponent: function () {
		this.items = [
			{
				xtype: 'form',
				id: 'from1',
				frame: true,
				collapsible: false,
				bodyPadding: '10,20',
				defaults: {
					anchor: '50%'
				},
				items: [
					{
						xtype: 'textfield',
						name: 'name',
						fieldLabel: '氏　名'
					},
				]
			}
		];
		this.buttons = [
			{
				text: 'Save',
				action: 'save',
			},
			{
				text: 'Cancel',
				scope: this,
				handler: this.close
			}
		];
		this.callParent(arguments);
	}
});