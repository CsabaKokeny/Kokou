Ext.define('Kokou.view.form.field.RelationTypeComboBox', {
    extend: 'Kokou.view.form.field.ComboBox', 
    fieldLabel: '関係',
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
    })
});