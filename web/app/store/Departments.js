Ext.define('Kokou.store.Departments',{
    extends: 'Ext.data.Store',
    fields: ['code', 'label'],
    proxy: {
        type: 'ajax',
        url: 'department/list',
        reader: {
            type: 'json',
            root: 'data'
        }
    },
    autoLoad: true
});