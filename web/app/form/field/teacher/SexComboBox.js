Ext.define('Kokou.form.field.teacher.SexComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    fieldLabel: '性　別',
    store: Ext.create('Kokou.store.TeacherSex')
});