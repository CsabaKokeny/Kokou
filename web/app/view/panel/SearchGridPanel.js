Ext.define('Kokou.view.panel.SearchGridPanel', {
	extend: 'Ext.grid.Panel',
	loadMask: true,
	frame: true,
	
	initComponent: function () {
            this.callParent(arguments);
	},
	selModel: {
            mode: 'SINGLE'
	}
});