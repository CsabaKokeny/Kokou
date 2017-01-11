Ext.define('Kokou.view.print.MiddleschoolTabPanel', {
    extend: 'Ext.tab.Panel',
    activeTab: 0,
    layout: 'fit',
    defaults: {
        autoScroll: true,
        bodyPadding: 0
    },
    makeContent: function (report, type, callback) {
        if (!!!type) {
            type = 'docx';
        }
        var content = '';
        if (!this._count) {
            this._count = 0;
        }
        if (!this._prefix) {
            this._prefix = 'frmMiddleSchool';
        }
        this._count ++ ;
        var name = this._prefix+(this._count);
        content += '<iframe width="100%" height="100" style="" src="print/panel?report='+report+'&type='+type+'&frameName='+name+'&schoolKind=J"></iframe>';
        content += '<iframe name="'+name+'" margin="100" border="0" width="100%" height="100%" style="background-color:gray;float:bottom;top:100px;"';
        content += '"></iframe>';
        content += '<iframe style="display:none" name="'+name+'_down"></iframe>'
        return content;
    },
    initComponent: function () {
        this.addEvents([
                'tabselect'
        ]);
        this.items = [
            {
                title: '個人懇談予定表',//Children's detail infomation List
                closable: false,
                html: this.makeContent('middleschool/list_of_consultant__nodata')
            },
            {
                title: '名札',//Children's detail infomation List
                closable: false,
                html: this.makeContent('middleschool/name_tag_big')
            },
            {
                title: '出席',//Children's detail infomation List
                closable: false,
                html: this.makeContent('middleschool/list_of_name__double')
            },
            {
                title: '放課後学習出席',//Children's detail infomation List
                closable: false,
                html: this.makeContent('middleschool/afterschool')
            },
            {
                title: '納入',//Children's detail infomation List
                closable: false,
                html: this.makeContent('middleschool/list_of_fee')
            },
            {
                title: '出欠挨拶',//Children's detail infomation List
                closable: false,
                html: this.makeContent('middleschool/visit_present_absent_report')
            }
        ];

        this.callParent(arguments);
    }
});
