Ext.define('Kokou.view.panel.FeedPanel',  {
	extend: 'Ext.panel.Panel',
	animCollapse: true,
	layout: 'fit',
	title: '&nbsp;',
	initComponent: function () {
		Ext.apply(this, {
			items: this.createView()
		});
		this.addEvents(
			'feedselect'
		);
		this.callParent(arguments);
	},
	
	createView: function () {
		
		this.view = Ext.create('widget.dataview', {
			autoScroll: true,
			store: 'Feeds',
			selModel: {
				mode: 'SINGLE',
				listeners: {
					scope: this,
					selectionchange: this.onSelectionChange
				}
			},
			listeners: {
				scope: this,
				viewready: this.onViewReady
			},
			trackOver: true,
			cls: 'feed-list',
			itemSelector: '.feed-list-item',
			overItemCls: 'feed-list-item-hover',
			tpl: '<tpl for="."><div class="feed-list-item">{title}</div></tpl>'
		});
		return this.view;
	},
	
	onViewReady: function () {
		this.view.getSelectionModel().select(this.view.store.getAt(2));
	},
		
	onSelectionChange: function() {
		var selected = this.getSelectedItem();
		if (selected) {
			this.loadFeed(selected);
		}
	},
	
	loadFeed: function (rec) {
		if (rec) {
			this.fireEvent('feedselect', this, rec.get('title'),  rec.get('url'));
		}
	},
		
	getSelectedItem: function () {
		return this.view.getSelectionModel().getSelection()[0] || false;
	},
	
	onDestory: function () {
		this.callParent(arguments);
	}
});