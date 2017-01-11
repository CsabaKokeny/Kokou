Ext.define('Kokou.view.form.field.PhoneTypeComboBox', {
    extend: 'Kokou.view.form.field.ComboBox', 
    fieldLabel: 'ＴＥＬ種別',
    store: Ext.create('Ext.data.Store', {
        fields: ['code', 'label'],
        proxy: {
            type: 'ajax',
            url: 'phone_type/list',
            reader:  {
                type: 'json',
                root: 'data'
            }
        },
        autoLoad: true
    })
});