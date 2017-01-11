Ext.define('Kokou.form.field.teacher.ResidenceComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    fieldLabel: '本籍（国籍）',
    store: Ext.create('Kokou.store.TeacherResidence')
});