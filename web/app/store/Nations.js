Ext.define('Kokou.store.Nations',{
    extends: 'Ext.data.Store',
    fields: ['code', 'label'],
    proxy: {
        type: 'ajax',
        url: 'nation/list',
        reader: {
            type: 'json',
            root: 'data'
        }
    },
    autoLoad: true
});