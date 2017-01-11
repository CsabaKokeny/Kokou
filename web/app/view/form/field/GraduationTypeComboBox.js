Ext.define('Kokou.view.form.field.GraduationTypeComboBox', {
    extend: 'Kokou.view.form.field.ComboBox', 
    store: Ext.create('Ext.data.Store', {
        fields: ['code', 'label'],
        data: [
            {code:'中退', label:'中退'},
            {code:'卒', label:'卒'}
        ]
    })
});