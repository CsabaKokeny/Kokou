Ext.define('Kokou.form.field.teacher.PhoneTypeComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    fieldLabel: '関係',
    store: Ext.create('Kokou.store.TeacherPhoneType')
});