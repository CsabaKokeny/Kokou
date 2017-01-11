Ext.define('Kokou.form.field.SchoolKindComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    fieldLabel: '学　校',
    store: Ext.create('Ext.data.Store', {
        fields: ['code', 'label'],
        proxy: {
            type: 'ajax',
            url: 'department/list',
            reader:  {
                type: 'json',
                root: 'data'
            }
        },
        autoLoad: true
    })
});