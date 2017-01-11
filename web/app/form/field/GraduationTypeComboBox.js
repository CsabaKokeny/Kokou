Ext.define('Kokou.form.field.GraduationTypeComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    store: Ext.create('Ext.data.Store', {
        fields: ['code', 'label'],
        data: [
            {code:'中退', label:'中退'},
            {code:'卒', label:'卒'}
        ]
    })
});