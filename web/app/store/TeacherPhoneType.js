Ext.define('Kokou.store.TeacherPhoneType', {
    extend: 'Ext.data.Store',
    fields: ['code', 'label'],
    data: [
        {code:'自宅', label:'自宅'},
        {code:'MOBILE', label:'MOBILE'},
        {code:'職場', label:'職場'}
    ]
});