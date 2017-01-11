Ext.define('Kokou.view.base.Window', {
    extend:  'Ext.window.Window',
    autoShow: true,
    modal: true,
    
    userConfig: {
        labelWidth: 150
    },
    createNumberfield: function (config) {
        var default_config = {
            labelWidth: this.userConfig.labelWidth
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = Ext.create('Ext.form.field.Number', default_config);
        return item;
    },
    createTextfield: function (config) {
        var default_config = {
            labelWidth: this.userConfig.labelWidth
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = Ext.create('Ext.form.field.Text', default_config);
        return item;
    },
    createCheckboxfield: function (config) {
        var default_config = {
            labelWidth: this.userConfig.labelWidth
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = Ext.create('Ext.form.field.Checkbox', default_config);
        return item;
    },
    createHiddenfield: function(config) {
        var default_config = {
            labelWidth: this.userConfig.labelWidth
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = Ext.create('Ext.form.field.Hidden',default_config);
        return item;
    },
    createCombobox: function (config) {
        var default_config = {
            labelWidth: this.userConfig.labelWidth,
            queryMode: 'local',
            displayField: 'label',
            valueField: 'code'
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = Ext.create('Ext.form.field.ComboBox', default_config); 
        return item;
    },
    createDatefield: function (config) {
        var default_config = {
            labelWidth: this.userConfig.labelWidth,
            value: new Date(),
            format: 'Y/m/d'
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = Ext.create('Ext.form.field.Date', default_config);
        return item;
    },
    createSexCombobox: function (config) {
        var default_config = {
            fieldLabel: '性　別',
            value: 'm',
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                proxy: {
                    type: 'ajax',
                    url: 'sex/list',
                    reader:  {
                        type: 'json',
                        root: 'data'
                    }
                },
                autoLoad: true
            })
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = this.createCombobox(default_config);
        return item;
    },
    createPhoneTypeCombobox: function (config) {
        var default_config = {
            fieldLabel: 'ＴＥＬ種別',
            value: 'MOB',
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                proxy: {
                    type: 'ajax',
                    url: 'phone_type/list',
                    reader:  {
                        type: 'json',
                        root: 'data'
                    }
                },
                autoLoad: true
            })
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = this.createCombobox(default_config);
        return item;
    },
    createNationCombobox: function (config) {
        var default_config = {
            fieldLabel: '国　籍',
            value: 'JP',
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
            })
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = this.createCombobox(default_config);
        return item;
    },
    createRelationTypeCombobox: function (config) {
        var default_config = {
            fieldLabel: '関係',
            value: 'f',
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                proxy: {
                    type: 'ajax',
                    url: 'relation_type/list',
                    reader:  {
                        type: 'json',
                        root: 'data'
                    }
                },
                autoLoad: true
            })
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = this.createCombobox(default_config);
        return item;
    },
    createDepartmentCombobox: function (config) {
        var default_config = {
            fieldLabel: '学　校',
            value: 'h',
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                proxy: {
                    type: 'ajax',
                    url: 'department/list',
                    reader:  {
                        type: 'json',
                        root: 'data'
                    }
                },
                autoLoad: true
            })
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = this.createCombobox(default_config);
        return item;
    },
    
    createClassCombobox: function (config, departmentCode) {
        var default_config = {
            fieldLabel: 'ク ラ ス',
            value: '',
            store: Ext.create('Ext.data.Store', {
                fields: ['code', 'label'],
                proxy: {
                    type: 'ajax',
                    url: 'class/list1'+(!!departmentCode?"?departmentCode"+departmentCode:''),
                    reader:  {
                        type: 'json',
                        root: 'data'
                    }
                },
                autoLoad: true
            })
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = this.createCombobox(default_config);
        return item;
    },
    
    createLevelNumberfield: function (config) {
        var default_config = {
            maxValue: 3,
            minValue: 1
        };
        for(var i in config) {
            default_config[i] = config[i];
        }
        var item = this.createNumberfield(default_config);
        return item;
    },
    
    initComponent: function () {
        this.callParent(arguments);
    },
    
    getDisplayValue : function (c) {
        if (!c) return '';
        if (typeof(c) === 'string') {
            c = Ext.getCmp(c);
            if (!c) return '';
        }
        if (!!c.getDisplayValue) {
            return c.getDisplayValue();
        }
        else if (!!c.findRecordByValue) {
            var r = c.findRecordByValue(c.getValue());
            if (!!r) {
                return r.get("label");
            }
        } else if (!!c.getValue) {
            return c.getValue();
        }
        return '';
    }
});