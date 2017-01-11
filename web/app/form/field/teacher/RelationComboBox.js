Ext.define('Kokou.form.field.teacher.RelationComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    fieldLabel: '関係',
    store: Ext.create('Kokou.store.TeacherRelation')
});