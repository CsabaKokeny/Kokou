Ext.define('Kokou.store.Family',{
    extends: 'Ext.data.Store',
    model: 'Kokou.model.Family',
    data: [],
    proxy: {
        type: 'memory'
    },
    autoLoad: true
});