Ext.define('Kokou.store.TeacherResidence', {
    extend: 'Ext.data.Store',
    fields: ['code', 'label'],
    data: [
        {code:'在日', label:'在日'},
        {code:'ダブル', label:'ダブル'},
        {code:'駐日（公）', label:'駐日（公）'},
        {code:'駐日（非）', label:'駐日（非）'},
        {code:'日本', label:'日本'},
        {code:'その他', label:'その他'}
    ]
});