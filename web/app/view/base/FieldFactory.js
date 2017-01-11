Ext.define('Kokou.view.base.FieldFactory',{
    userConfig: {
        labelWidth: 150
    },
    createField: function (type, config) {
        var default_config = {
            labelWidth: this.userConfig.labelWidth
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = Ext.create(type, config);
        return item;
    },
    
    createNumber: function (config) {
        return this.createField('Ext.form.field.Number', config);
    },
    createSpinner: function (config) {
        return this.createField('Ext.form.field.Spinner', config);
    },
    createText: function (config) {
        return this.createField('Ext.form.field.Text', config);
    },
    createCheckbox: function (config) {
        return this.createField('Ext.form.field.Checkbox', config);
    },
    createHidden: function(config) {
        return this.createField('Ext.form.field.Hidden', config);
    },
    createComboBox: function (config) {
        return this.createField('Kokou.view.form.field.ComboBox', config);
    },
    createDate: function (config) {
        return this.createField('Kokou.view.form.field.Date', config);
    },
    createEnterDate: function(config) {
        return this.createField('Kokou.view.form.field.EnterDate', config);
    },
    createSexComboBox: function (config) {
        return this.createField('Kokou.view.form.field.SexComboBox', config);
    },
    createPhoneTypeComboBox: function (config) {
        return this.createField('Kokou.view.form.field.PhoneTypeComboBox', config);
    },
    createNationComboBox: function (config) {
        return this.createField('Kokou.view.form.field.NationComboBox', config);
    },
    createRelationTypeComboBox: function (config) {
        return this.createField('Kokou.view.form.field.RelationTypeComboBox', config);
    },
    createSchoolKindComboBox: function (config) {
        return this.createField('Kokou.view.form.field.SchoolKindComboBox', config);
    },
    
    createClassComboBox: function (config) {
        return this.createField('Kokou.view.form.field.ClassComboBox', config);
    },  
    createSchoolYearNumber: function (config) {
        return this.createField('Kokou.view.form.field.SchoolYearSpinner', config);
    },
    createCodeSpinner: function (config) {
        var item = Ext.create('Kokou.view.form.field.CodeSpinner',config);
        return item;
    }
});