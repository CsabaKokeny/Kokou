Ext.define('Kokou.view.teacher.edit.CardInfoEditPanel',{
    extend: 'Kokou.panel.EditPanel',
    title: '■【各種番号】',
    layout:'column',
    bodyStyle: 'padding:30px 50px',
    userConfig: {
        labelWidth: 120
    },
    initComponent: function () {
        var factory = this.getFieldFactory();
        this.widgets = {
            passport: {
                has: factory.createCheckbox({fieldLabel:'有・無'}),
                no: factory.createText({fieldLabel: '旅券番号'})
            }
        };
        this.items = [
            {
                xtype: 'fieldset',
                border: 1,
                columnWidth: 1,
                layout: 'form',
                title: '旅券',
                items: []
            }
        ];
        this.items[0].items.push(this.widgets.passport.has);
        this.items[0].items.push(this.widgets.passport.no);
        this.callParent(arguments);
    }
});