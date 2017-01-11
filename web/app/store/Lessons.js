Ext.define('Kokou.store.Lessons', {
    extend: 'Ext.data.Store',
    model: 'Kokou.model.Lesson',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: 'lesson/list',
        reader: {
            type:'json',
            root:'data',
            successProperty:'success'
        }
    }
});