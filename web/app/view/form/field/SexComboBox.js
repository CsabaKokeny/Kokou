Ext.define('Kokou.view.form.field.SexComboBox', {
    extend: 'Kokou.view.form.field.ComboBox', 
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