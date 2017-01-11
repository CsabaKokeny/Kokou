Ext.define('Kokou.view.student.StudentMainEditPanel',{
    extend: 'Ext.form.FieldContainer',
    border: 0,
    layout:'anchor',
    frame: false,
    collapsible: false,
    bodyPadding: '10,20',
    defaults: {
        anchor: '100%'
    },
    userConfig: {
        labelWidth: 120
    },
    initComponent: function () {
        var _this = this;
        _this.factory = Ext.create('Kokou.view.base.FieldFactory', {
            userConfig: _this.userConfig
        });
        _this.items = [
            _this.factory.createHidden({name:'id'}),
            {
                xtype: 'fieldset',
                border:0,
                layout: 'column',
                items: [
                    _this.factory.createEnterDate({id:"dtEnterDate",name: 'enterDate', columnWidth:0.3, labelWidth: 70,
                        listeners: {
                            change: function (thisObject, newValue, oldValue, eOpts) {
                                var val = newValue.getFullYear();
                                val += _this.down('#cbxEnterSchoolKind').getValue();
                                _this.down('#widgetStudentCodeEditor').setPrefix(val);
                            }
                        }
                    }),
                    {columnWidth:0.1, html:'&nbsp;'},
                    _this.factory.createSchoolKindComboBox({id:'cbxEnterSchoolKind', name: 'enterSchoolKind', columnWidth:0.25, labelWidth: 70, value: 'H',
                        tag: 'enterSchoolKind',
                        listeners: {
                            change: function (thisObject, newValue, oldValue, eOpts) {
                                var val = _this.down('#dtEnterDate').getValue().getFullYear();
                                val += newValue;
                                _this.down('#widgetStudentCodeEditor').setPrefix(val);
                            }
                        }
                    }),
                    {columnWidth:0.1, html:'&nbsp;'},
                    _this.factory.createText({id:"txtSchoolYear", name: 'schoolYear',fieldLabel: '学年', columnWidth:0.25, labelWidth: 50, tag: 'enterSchoolYear'})
                ]
            },
            {
                xtype: 'fieldset',
                layout: 'column',
                border: 0,
                items: [
                    (this.studentCodeEditor = Ext.create('Kokou.view.form.field.StudentCodeEditor', {
                        id: 'widgetStudentCodeEditor',
                        labelWidth: 70,
                        columnWidth: 0.3
                    }))  
                ]
            },
            {
                xtype:'fieldset',
                layout: 'column',
                border: 1,
                title:'■【生徒情報】',
                items: [
                    {
                        xtype: 'fieldset',
                        columnWidth: 0.5,
                        layout:'form',
                        border: 0,
                        items: [
                            _this.factory.createText({id:'txtStudentName', name: 'name', fieldLabel: '氏名', tag:'name'}),
                            _this.factory.createText({id:'txtStudentNameKr', name: 'nameKr', fieldLabel: 'ハングル名', tag:'nameKr'}),
                            _this.factory.createDate({id:'dtStudentBirth', name: 'birth',fieldLabel: '生年月日（西暦）', tag:'birth'}),
                            _this.factory.createText({id:'txtStudentAddress', name: 'address', fieldLabel: '現住所', tag:'address'}),
                            _this.factory.createText({id:'txtStudentPhone', name: 'phone', fieldLabel: 'ＴＥＬ', tag:'phone'}),
                            _this.factory.createNationComboBox({id:'cbxStudentNation', name: 'nation', fieldLabel: '本籍', tag:'nation'})
                        ]
                    },
                    {
                        xtype: 'fieldset',
                        columnWidth: 0.5,

                        layout:'form',
                        border:0,
                        items: [
                            _this.factory.createText({id:'txtStudentNameNick', name: 'nameNick', fieldLabel: '通称名', tag:'nameNick'}),
                            _this.factory.createSexComboBox({id:'cbxStudentSex', name: 'sex', fieldLabel: '性別', tag:'sex'}),
                            {html:'<div style="height:24px;">&nbsp;</div>'},
                            _this.factory.createText({id:'txtStudentAddress2', name: 'address2', fieldLabel: '変更住所', tag:'address2'}),
                            _this.factory.createText({id:'txtStudentFax', name: 'fax', fieldLabel: 'ＦＡＸ', tag:'fax'}),
                            {html:'&nbsp;'}
                        ]
                    }
                ]
            }
        ];
        this.callParent(arguments);
    },
    toDate: function (year, month ,date) {
        if (year === null || month === null || date === null || year === undefined || month === undefined || date === undefined) {
            return new Date();
        }
        year = parseInt(year);
        month = parseInt(month);
        date = parseInt(date);
        if (isNaN(year) || isNaN(month) || isNaN(date)) return new Date();
        if (year<1) return new Date();
        if (month<1 || month >12) return new Date();
        if (date<1 || date > 31) return new Date();
        var value = new Date(month+"/"+date+"/"+year);
        return value;
    },
    setData: function (selector, value) {
        if (value === null || value === undefined) {
            value = '';
        }
        var _this = this;
        var _widget = _this.down(selector);
        if (_widget === null || _widget === undefined) return _this;
        _widget.setValue(value);
        return _this;
    },
    loadData : function (data) {
        var _this = this;        
        _this.setData('#dtEnterDate', _this.toDate(data.enterYear,data.enterMonth, data.enterDay));
        _this.setData('#cbxEnterSchoolKind', data.enterSchoolKind);
        _this.setData('#txtSchoolYear', data.enterSchoolYear);
        _this.down('#widgetStudentCodeEditor').setNo(data.code);
        _this.setData('#txtStudentName', data.name);
        _this.setData('#txtStudentNameKr', data.nameKr);
        _this.setData('#txtStudentNameNick', data.nameNick);
        _this.setData('#cbxStudentSex', data.sex);
        _this.setData('#cbxStudentRelation', data.relation);
        _this.setData('#dtStudentBirth', data.birth);
        _this.setData('#txtStudentAddress', data.address);
        _this.setData('#txtStudentAddress2', data.address2);
        _this.setData('#txtStudentPhone', data.phone);
        _this.setData('#txtStudentFax', data.fax);        
        _this.setData('#cbxStudentNation', data.nation);       
        return _this;
    },
    getXmlData : function () {
        var _this = this;
        var marshaller = new Ext.create('Kokou.xml.Marshaller');
        var content = '';
        var dt = _this.down('#dtEnterDate').getValue();
        if (!!dt) {
            content += '<enterYear>'+dt.getFullYear()+'</enterYear>';
            content += '<enterMonth>'+(dt.getMonth()+1)+'</enterMonth>';
            content += '<enterDay>'+dt.getDate()+'</enterDay>';
        }
        content += '<code>' + _this.down('#widgetStudentCodeEditor').getNo() + '</code>';
        content += marshaller.marshall(_this.down('#cbxEnterSchoolKind'));
        content += marshaller.marshall(_this.down('#txtSchoolYear'));
        content += marshaller.marshall(_this.down('#txtStudentName'));
        content += marshaller.marshall(_this.down('#txtStudentNameNick'));
        content += marshaller.marshall(_this.down('#txtStudentNameKr'));
        content += marshaller.marshall(_this.down('#cbxStudentRelation'));
        content += marshaller.marshall(_this.down('#cbxStudentSex'));
        content += marshaller.marshall(_this.down('#dtStudentBirth'));
        content += marshaller.marshall(_this.down('#txtStudentAddress'));
        content += marshaller.marshall(_this.down('#txtStudentAddress2'));
        content += marshaller.marshall(_this.down('#txtStudentPhone'));
        content += marshaller.marshall(_this.down('#cbxStudentPhoneType'));
        content += marshaller.marshall(_this.down('#txtStudentFax'));
        content += marshaller.marshall(_this.down('#cbxStudentNation'));
        return content;
    }
});