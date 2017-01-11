Ext.define('Kokou.view.print.PrimaryschoolTabPanel', {
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
            this._prefix = 'frmPrimary';
        }
        this._count ++ ;
        var name = this._prefix+(this._count);
        content += '<iframe width="100%" height="100" style="" src="print/panel?report='+report+'&type='+type+'&frameName='+name+'&schoolKind=P"></iframe>';
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
                title: '納付名簿金',//Children's detail infomation List
                closable: false,
                html: this.makeContent('primaryschool/list_of_fee')
            },
            {
                title: '作品専用(韓/横)',//Children's detail infomation List
                closable: false,
                html: this.makeContent('primaryschool/list_of_name_kr_row')
            },
            {
                title: '作品専用(韓/縦)', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('primaryschool/list_of_name_kr_col')
            },
            {
                title: '作品専用(日/横)', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('primaryschool/list_of_name_jp_row')
            },
            {
                title: '作品専用(日/縦)', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('primaryschool/list_of_name_jp_col')
            },
            {
                title: '学年児童名簿', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('primaryschool/list_of_name')
            },
            {
                title: '個人番号', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('primaryschool/personalno')
            },
            {
                title: '学科テスト', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('primaryschool/studytest')
            },
            {
                title: '図工作品検事表', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('primaryschool/makingtest')
            },
            {
                title: '窉珥堮袢', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('primaryschool/emergencycontact')
            },
            {
                title: '忘小物', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('primaryschool/mangsomul')
            },
            {
                title: '行動観察', // Just only name within the selected classes
                closable: false,
                html: this.makeContent('primaryschool/action_research')
            },
            {
                title: '在職証明書(日)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/work_idcard_jp', 'rtf')
            },
            {
                title: '在職証明書(韓)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/work_idcard_kr')
            },
            {
                title: '卒業予定証明書(日)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/graduation_pre_jp')
            },
            {
                title: '卒業予定証明書(韓)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/graduation_pre_kr')
            },
            {
                title: '生活記録部(日)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/life_record_jp')
            },
            {
                title: '生活記録部(韓)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/life_record_kr')
            },
            {
                title: '在学事実証明書(日)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/studying_real_Idcard_jp')
            },
            {
                title: '在学事実証明書(韓)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/studying_real_Idcard_kr')
            },
            {
                title: '卒業証明書(日)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/graduation_card_jp')
            },
            {
                title: '卒業証明書(韓)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/graduation_card_kr')
            },
            {
                title: '在学証明書(日)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/beinginschoolcard_jp')
            },
            {
                title: '退学証明書(日)', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/retirecard')
            },
            {
                title: '感状1', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/maraton_kr')
            },
            {
                title: '感状2', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/perfect_attendance_6_kr')
            },
            {
                title: '感状3', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/perfect_attendance_1_kr')
            },
            {
                title: '辞令', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/appointment_kr')
            },
            
            {
                title: '賞状1', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/bonus_amsong_card_kr')
            },
            {
                title: '賞状2', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/effort_amsong_card_kr')
            },
            {
                title: '認定証', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/certification_kr')
            },
            {
                title: '卒業証書', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/graduation_certification_kr')
            },
            {
                title: 'PTA会員名簿', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/pta_employee_list')
            },
            {
                title: 'PTAクラス委員名簿', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/pta_employee_list')
            },
            {
                title: '名札1', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/name_1')
            },
            {
                title: '名札2', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/name_2')
            },
            {
                title: '名札3', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/name_3')
            },
            {
                title: '名札4', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/name_4')
            },
            {
                title: '名札5', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/name_5')
            },
            {
                title: '名札6', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/name_6')
            },
            {
                title: '名札7', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/name_7')
            },
            {
                title: '名札8', // Related to children's families.
                closable: false,
                html: this.makeContent('primaryschool/name_8')
            }
        ];
        this.callParent(arguments);
    }
});
