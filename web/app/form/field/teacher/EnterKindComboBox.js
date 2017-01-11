Ext.define('Kokou.form.field.teacher.EnterKindComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    fieldLabel: '入職種別',
    store: Ext.create('Kokou.store.TeacherEnterKind')
});