Ext.define('Kokou.view.print.TabPanel', {
    extend: 'Ext.tab.Panel',
    activeTab: 0,
    layout: 'fit',
    defaults: {
        autoScroll: true,
        bodyPadding: 0
    },
    initComponent: function () {
        this.addEvents([
                'tabselect'
        ]);
        this.items = [
            this.createPreschoolPanel(),
            this.createPrimaryschoolPanel(),
            this.createMiddleschoolPanel(),
            this.createHighschoolPanel()
        ];
        this.callParent(arguments);
    },
    createPreschoolPanel: function () {
        return Ext.create('Kokou.view.print.PreschoolTabPanel',{
            title: '幼稚園',
            closable: false,
            layout: 'hbox'
        });
    },
    createPrimaryschoolPanel: function () {
        return Ext.create('Kokou.view.print.PrimaryschoolTabPanel',{
            title: '小学校',
            closable: false,
            layout: 'hbox',
            _prefix: 'framePrimarySchoolPreview'
        });
            
    },
    createMiddleschoolPanel: function () {
        return Ext.create('Kokou.view.print.MiddleschoolTabPanel',{
            title: '中学校',
            closable: false,
            layout: 'hbox',
            _prefix: 'frameMiddleSchoolPreview'
        });
    },
    createHighschoolPanel: function () {
        return Ext.create('Kokou.view.print.HighschoolTabPanel',{
            title: '高校',
            closable: false,
            layout: 'hbox',
            _prefix: 'frameHighSchoolPreview'
        });
    }
});
