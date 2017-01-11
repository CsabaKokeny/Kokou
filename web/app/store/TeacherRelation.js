Ext.define('Kokou.store.TeacherRelation', {
    extend: 'Ext.data.Store',
    fields: ['code', 'label'],
    data: [
        {code:'父', label:'父'},
        {code:'母', label:'母'},
        {code:'妻', label:'妻'},
        {code:'兄弟', label:'兄弟'},
        {code:'兄', label:'兄'},
        {code:'弟', label:'弟'},
        {code:'姉', label:'姉'},
        {code:'妹', label:'妹'},
        {code:'親戚', label:'親戚'},
        {code:'その他', label:'その他'}
    ]
});