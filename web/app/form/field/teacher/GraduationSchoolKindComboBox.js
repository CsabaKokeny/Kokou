Ext.define('Kokou.form.field.teacher.GraduationSchoolKindComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    fieldLabel: '最終学歴',
    store: Ext.create('Kokou.store.TeacherGraduationSchoolKind')
});