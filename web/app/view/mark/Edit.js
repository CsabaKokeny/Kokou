Ext.define('Kokou.view.mark.Edit', {
	extend:  'Ext.window.Window',
	title: '&nbsp;',
	layout: 'border',
	autoShow: true,
	modal: true,
	width: 500,
	height: 600,
	initComponent: function () {
		this.items = [
			{
				xtype: 'form',
				id: 'frmMarkEdit',
				region: 'north',
				frame: true,
				collapsible: false,
				bodyPadding: '10,20',
				defaults: {
					anchor: '80%'
				},
				items: [
					{
						xtype: 'textfield',
						labelWidth: 150,
						name: 'student-no',
						fieldLabel: '学　籍　番　号'
					},
					{
						xtype: 'textfield',
						labelWidth: 150,
						name: 'name',
						fieldLabel: '氏　名'
					},
					{
						xtype: 'textfield',
						labelWidth: 150,
						name: 'name-kr',
						fieldLabel: '氏　名（朝鮮語）'
					},
					{
						xtype: 'textfield',
						labelWidth: 150,
						name: 'name-en',
						fieldLabel: '氏　名（英語）'
					},
					{
						xtype: 'textfield',
						labelWidth: 150,
						name: 'birthday',
						fieldLabel: '生　年　月　日'
					},
					{
						xtype: 'textfield',
						labelWidth: 150,
						name: 'sex',
						fieldLabel: '性　別'
					},
					{
						xtype: 'textfield',
						labelWidth: 150,
						name: 'nation',
						fieldLabel: '国　籍'
					},
					{
						xtype: 'textfield',
						labelWidth: 150,
						name: 'income-date',
						fieldLabel: '入　学　年　度'
					},
					{
						xtype: 'textfield',
						labelWidth: 150,
						name: 'income-school',
						fieldLabel: '入学種別'
					},
					{
						xtype: 'textfield',
						labelWidth: 150,
						name: 'income-level',
						fieldLabel: '学　年'
					}
				]
			},
			{
				xtype: 'tabpanel',
				region: 'south',
				margin: (2,2,2,2),
				items: [
					{
						title: '保護者情報',
						html:'',
						height: 175
					},
					{
						title: '入学前の経歴',
						html:'',
						height: 175
					},
					{
						title: '家族構成',
						html:'',
						height: 175
					}
				]
			}
		];
		this.buttons = [
			{
				text: '保管',
				action: 'save',
			},
			{
				text: '閉じる',
				scope: this,
				handler: this.close
			}
		];
		this.callParent(arguments);
	}
});