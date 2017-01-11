Ext.define('Kokou.store.Transport',{
    extends: 'Ext.data.Store',
    model: 'Kokou.model.Transport',
    data: [],
    proxy: {
        type: 'memory'
    },
    autoLoad: true
});