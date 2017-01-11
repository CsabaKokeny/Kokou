Ext.define('Kokou.store.TeacherSchoolResult', {
    extend: 'Ext.data.Store',
    fields: ['code', 'label'],
    data: [
        {code:'中退', label:'中退'},
        {code:'卒', label:'卒'}
    ]
});