Ext.define('Kokou.form.field.ClassComboBox', {
    extend: 'Kokou.form.field.ComboBox', 
    queryMode: 'remote',
    queryParam: 'query',
    schoolKind: '',
    fieldLabel: 'ク ラ ス',
    store: Ext.create('Ext.data.Store', {
        fields: ['code', 'label'],
        proxy: {
            type: 'ajax',
            url: 'nation/list',
            reader:  {
                type: 'json',
                root: 'data'
            }
        },
        autoLoad: true
    }),
    
    getSchoolKind : function () {
        return this.schoolKind;
    },
    setSchoolKind : function (value) {
        this.schoolKind = value;
        this.query = 'schoolKind='+value;
    }
});