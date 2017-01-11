Ext.define('Kokou.store.Students', {
    extend: 'Ext.data.Store',
    model: 'Kokou.model.Student',
    pageSize: 25,
    autoLoad: {start: 0, limit:25},
    proxy: {
        type: 'ajax',
        url: 'student2/list',
        reader: {
            type:'json',
            root:'data',
            successProperty:'success',
            totalProperty:'total'
        }
    }
});