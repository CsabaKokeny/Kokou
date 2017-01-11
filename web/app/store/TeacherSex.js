Ext.define('Kokou.store.TeacherSex', {
    extend: 'Ext.data.Store',
    fields: ['code', 'label'],
    data: [
        {code:'男', label:'男'},
        {code:'女', label:'女'}
    ]
});