Ext.define('Kokou.store.Teachers', {
    extend: 'Ext.data.Store',
    model: 'Kokou.model.Teacher',
    pageSize: 25,
    autoLoad: {start: 0, limit:25},
    proxy: {
        type: 'ajax',
        url: 'teacher2/list',
        reader: {
            type:'json',
            root:'data',
            successProperty:'success',
            totalProperty:'total'
        }
    }
});