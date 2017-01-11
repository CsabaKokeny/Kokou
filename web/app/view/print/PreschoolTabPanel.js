Ext.define('Kokou.view.print.PreschoolTabPanel', {
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
            this._prefix = 'frmPreschool';
        }
        this._count ++ ;
        var name = this._prefix+(this._count);
        content += '<iframe width="100%" height="100" style="" src="print/panel?report='+report+'&type='+type+'&frameName='+name+'&schoolKind=E"></iframe>';
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
                title: '詳細名簿',//Children's detail infomation List
                closable: false,
                html: this.makeContent('preschool/list_of_detail')
            },
            {
                title: 'チェック表',//Children's detail infomation List
                closable: false,
                html: this.makeContent('preschool/list_of_name_on_b5')
            },
            {
                title: '作品展名札1', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('preschool/list_of_korean_name_tag_for_work_with_4cols')
            },
            {
                title: '作品展名札２', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('preschool/list_of_korean_name_tag_for_work_with_3cols')
            },
            {
                title: '作品展名札立体', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('preschool/list_of_korean_name_tag_for_work_with_3d')
            },
            {
                title: '名札', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('preschool/list_of_name_tag')
            },
            {
                title: 'アルバム', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_album', 'rtf')
            },
            {
                title: '卒業証書', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_diploma')
            },
            {
                title: '給食食数表', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_meal_support')
            },
            {
                title: '保育料表', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_nurture_cost')
            },
            {
                title: '保護者証', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_keeper_IDCard')
            },
            {
                title: '誕生日', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_birthday')
            },
            {
                title: '誕生', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_birth')
            },
            {
                title: '駐在', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_residence')
            },
            {
                title: '入学式名札', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_name_card_for_entrance')
            },
            {
                title: 'バス早見表', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_busno')
            },
            {
                title: 'クラス名簿１', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/roll_of_class_with_PTAEmployee')
            },
            {
                title: 'クラス名簿2', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/roll_of_class_without_PTAEmployee')
            },
            {
                title: '調査提出資料', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_research_data')
            },
            {
                title: '出席', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_presence')
            },
            {
                title: '出席表', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_presence_in_term')
            },
            {
                title: 'チェック表', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_check')
            },
            {
                title: '状況チェック表', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_check_in_term')
            },
            {
                title: '小学校資料', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_for_primary_school')
            },
            {
                title: '住所料', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_name_and_address')
            },
            {
                title: 'PTA連絡料', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_PTA_contact')
            },
            {
                title: 'PTA役員名簿', // Related to children's families.
                closable: false,
                html: this.makeContent('preschool/list_of_PTAEmployee')
            }
        ];
        this.callParent(arguments);
    }
});
