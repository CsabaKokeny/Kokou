Ext.define('Kokou.store.Sexs',{
    extends: 'Ext.data.Store',
    fields: ['code', 'label'],
    proxy: {
        type: 'ajax',
        url: 'sex/list',
        reader: {
            type: 'json',
            root: 'data'
        }
    },
    autoLoad: true
});