Ext.define('Kokou.view.print.HighschoolTabPanel', {
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
            this._prefix = 'frmHighSchool';
        }
        this._count ++ ;
        var name = this._prefix+(this._count);
        content += '<iframe width="100%" height="100" style="" src="print/panel?report='+report+'&type='+type+'&frameName='+name+'&schoolKind=H"></iframe>';
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
                title: '名単',//Children's detail infomation List
                closable: false,
                html: this.makeContent('highschool/list_of_name__double')
            },
            {
                title: '授業料台帳',//Children's detail infomation List
                closable: false,
                html: this.makeContent('highschool/list_of_fee')
            },
            {
                title: '住所録', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('highschool/list_of_detail')
            }
        ];
        this.callParent(arguments);
    }
});
