Ext.define('Kokou.view.print.highschool.NameListTabPanel', {
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
            {
                title: '出席簿用',
                closable: false,
                layout: 'hbox',
            },
            {
                title: '黒手帳用A', // Just only name within the selected classes
                closable: false
            },
            {
                title: '黒手帳用D', // Just only name within the selected classes
                closable: false
            },
            {
                title: '住所録',
                closable: false
            },
            {
                title: '文理科目選択',
                closable: false
            },
            {
                title: '入学時資料',
                closable: false
            },
            {
                title: 'ﾁｪｯｸｼｰﾄ',
                closable: false
            }
        ];
        this.callParent(arguments);
    }
});
