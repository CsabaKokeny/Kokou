Ext.define('Kokou.store.TeacherGraduationSchoolKind', {
    extend: 'Ext.data.Store',
    fields: ['code', 'label'],
    data: [
        {code:'中', label:'中'},
        {code:'高', label:'高'},
        {code:'大', label:'大'},
        {code:'院', label:'院'}
    ]
});


