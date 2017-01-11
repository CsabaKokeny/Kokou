Ext.define('Kokou.form.field.RelationTypeComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    fieldLabel: '関係',
    /*
    store: Ext.create('Ext.data.Store', {
        fields: ['code', 'label'],
        proxy: {
            type: 'ajax',
            url: 'relation_type/list',
            reader:  {
                type: 'json',
                root: 'data'
            }
        },
        autoLoad: true
    })*/
    store: Ext.create('Ext.data.Store', {
        fields: ['code', 'label'],
        data: [
            {code:'f', label:'父'},
            {code:'m', label:'母'},
            {code:'br', label:'兄弟'},
            {code:'ebr', label:'兄'},
            {code:'ybr', label:'弟'},
            {code:'esis', label:'姉'},
            {code:'ysis', label:'妹'},
            {code:'r', label:'親戚'},
            {code:'o', label:'その他'}
        ]
    })
});