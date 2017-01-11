Ext.define('Kokou.store.Contact',{
    extends: 'Ext.data.Store',
    model: 'Kokou.model.Contact',
    data: [],
    proxy: {
        type: 'memory'
    },
    autoLoad: true
});