Ext.define('Kokou.controller.Users', {
	extend: 'Ext.app.Controller',
	views: [
		'user.List',
		'user.Edit'
	],
	stores: [
		'Users'
	],
	models: [
		'User'
	],
	init: function () {
		this.control({
			'viewport > userlist': {
				itemdblclick: this.editUser
			},
			'useredit button[action=save]': {
				click: this.updateUser
			}
		});
	},
	editUser : function (grid, record) {
		console.log('Double clicked on ' + record.get('name'));
		var view = Ext.widget('useredit');
		view.down('form').loadRecord(record);
	},
	updateUser: function (button) {
		var win = button.up('window');
		var form = win.down('form');
		var record = form.getRecord();
		var values = form.getValues();
		record.set(values);
		win.close();
		
		this.getUsersStore().sync();
	}
});