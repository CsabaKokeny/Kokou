Ext.define('Kokou.store.TeacherCareer',{
    extends: 'Ext.data.Store',
    model: 'Kokou.model.TeacherCareer',
    data: [],
    proxy: {
        type: 'memory'
    },
    autoLoad: true
});