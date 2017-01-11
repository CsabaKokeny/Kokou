Ext.define('Kokou.form.field.SexComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    fieldLabel: '性　別',
    store: Ext.create('Ext.data.Store', {
        fields: ['code', 'label'],
        proxy: {
            type: 'ajax',
            url: 'sex/list',
            reader:  {
                type: 'json',
                root: 'data'
            }
        },
        autoLoad: true
    })
});