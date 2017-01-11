Ext.define('Kokou.view.layout.Borders', {
	extend: 'Ext.container.Viewport',
	alias: 'widget.layoutborders',
	layout: {
		type: 'border',
		padding: 5
	},
	defaults: {
		split: true
	},
	initComponent: function () {
		Ext.apply(this, {
			items: [
				this.createNorthPanel(),
				this.createWestPanel(),
				this.createCenterPanel()
			]
		});
		this.callParent(arguments);
	//	this.onFeedSelect(null,null,'showTeacherManager');
	},
	onFeedSelect: function (feed, title, url) {
		if (!!this.centerPanel[url]) {
			this.centerPanel[url]();
			this.currentURL = url;
		}
	},
	onTabSelect: function (tabpanel, newCard) {
	},
	createNorthPanel: function () {
		this.northPanel = Ext.create('Ext.Panel', {
			region: 'north',
			collapsible: true,
			title: '',
			height: 100,
			minHeight: 50,
			html: '<div style="padding-left:20px;padding-top:10px;font-size:20pt;width:100%;height:100%;background-color:transparent;"><b>建国幼・小・中・高等学校</b></div>',
			afterrender: function () {
				this.callParent();
			}
		});
		return this.northPanel;
	},
	createWestPanel: function () {
		this.westPanel = Ext.create('Kokou.view.panel.FeedPanel',{
			region: 'west',
			collapsible: true,
			width: '15%',
			minWidth: 100,
			minHeight: 140,
			listeners: {
				scope: this,
				feedselect: this.onFeedSelect
			}
		});
		
		return this.westPanel;	
	},
	createCenterPanel: function () {
		this.centerPanel = Ext.create('Kokou.view.panel.TabPanel', {
			region: 'center',
			minHeight: 80,
			listeners: {
				scope: this,
				tabselect: this.onTabSelect
			}
			/*items: [
				cw = Ext.create('Ext.Window', {
					xtype: 'window',
					closable: false,
					minimizable: true,
					title: 'Constrained Window',
					height: 200,
					width: 400,
					constrain: true,
					html: 'I am in a Container',
					itemId: 'center-window',
					minimize: function() {
						this.floatParent.down('button#toggleCw').toggle();
					}
				})
			]*/
		});
		return this.centerPanel;
	}
});