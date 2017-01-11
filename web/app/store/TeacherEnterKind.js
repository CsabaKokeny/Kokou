Ext.define('Kokou.store.TeacherEnterKind', {
    extend: 'Ext.data.Store',
    fields: ['code', 'label'],
    data: [
        {code:'理事', label:'理事'},
        {code:'専任教員', label:'専任教員'},
        {code:'常勤講師', label:'常勤講師'},
        {code:'非常勤講師師', label:'非常勤講師師'},
        {code:'事務職', label:'事務職'},
        {code:'技能職', label:'技能職'},
        {code:'パート職員', label:'パート職員'},
        {code:'その他', label:'その他'}
    ]
});