Ext.define('Kokou.store.Classes', {
    extend: 'Ext.data.Store',
    model: 'Kokou.model.Class',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: 'class/list',
        reader: {
            type:'json',
            root:'data',
            successProperty:'success'
        }
    }
});