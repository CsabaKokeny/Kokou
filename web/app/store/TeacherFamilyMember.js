Ext.define('Kokou.store.TeacherFamilyMember',{
    extends: 'Ext.data.Store',
    model: 'Kokou.model.TeacherFamilyMember',
    data: [],
    proxy: {
        type: 'memory'
    },
    autoLoad: true
});