Ext.define('Kokou.view.form.field.NationComboBox', {
    extend: 'Kokou.view.form.field.ComboBox', 
    fieldLabel: '国　籍',
    store: Ext.create('Ext.data.Store', {
        fields: ['code', 'label'],
        proxy: {
            type: 'ajax',
            url: 'nation/list',
            reader:  {
                type: 'json',
                root: 'data'
            }
        },
        autoLoad: true
    })
});