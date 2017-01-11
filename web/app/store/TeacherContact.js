Ext.define('Kokou.store.TeacherContact',{
    extends: 'Ext.data.Store',
    model: 'Kokou.model.TeacherContact',
    data: [],
    proxy: {
        type: 'memory'
    },
    autoLoad: true
});