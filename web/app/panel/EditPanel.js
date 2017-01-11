Ext.define('Kokou.panel.EditPanel',{
    extend: 'Ext.panel.Panel',
    userConfig: {},
    marshaller: Ext.create('Kokou.xml.Marshaller'),
    unmarshaller: Ext.create('Kokou.json.Unmarshaller'),
    
    widgets:{},
    
    getMarshaller: function () {
        if (this.marshaller === null || this.marshaller === undefined) {
            this.marshaller = Ext.create('Kokou.xml.Marshaller');
        }
        return this.marshaller;
    },
    
    setMarshaller: function (marshaller) {
        this.marshaller = marshaller;
    },
    
    getFieldFactory: function () {
        if (this.fieldFactory === null || this.fieldFactory === undefined) {
            var userConfig = this.userConfig;
            if (userConfig === null || userConfig === undefined) userConfig = {};
            this.fieldFactory =Ext.create('Kokou.view.base.FieldFactory', userConfig);
        }
        return this.fieldFactory;
    },
    
    setFieldFactory: function (value) {
        this.fieldFactory = value;
    },
    
    getUnmarshaller: function () {
        if (this.unmarshaller === null || this.unmarshaller === undefined) {
            this.unmarshaller = Ext.create('Kokou.json.Unmarshaller');
        }
        return this.unmarshaller;
    },
    
    setUnmarshaller: function (unmarshaller) {
        this.unmarshaller = unmarshaller;
    },
    
    getXmlData: function(widgets) {
        if (!!!widgets) {
            if ( !!this.widgets) {
                return this.getMarshaller().marshall(this.widgets);
            } else {
                return '';
            }
        } else {
            return this.getMarshaller().marshall(widgets);
        }
    },
    
    loadData: function (data) {
        this.getUnmarshaller().unmarshall(this.widgets, data);
    },
    
    initComponent: function () {
        var _this = this;
        this.callParent(arguments);
    }
});
