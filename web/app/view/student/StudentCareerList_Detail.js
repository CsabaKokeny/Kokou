Ext.define('Kokou.view.student.StudentCareerList_Detail', {
    extend: 'Ext.grid.Panel',
    rowEditing:null,
    loadData: function (data) {
        if (data !== null && data !== undefined) {
            if (!!!data.push) {
                data = [data];
            }
        }else{
            data = [];
        }
        this.getStore().loadData(data, false);
        return this;
    },
    
    initComponent: function () {
        var _this= this;
        this.store = Ext.create('Ext.data.Store', {
            fields:[
                'schoolName',
                'schoolState',
                'schoolStateLabel',
                'preSchoolName',
                {name:'enterDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
                {name:'admitDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
                {name:'explusionDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'}
            ],            
            data: [],
            proxy: {
                type: 'memory'
            }
        });
        
        this.columns = [
            {
                text: '学校名', 
                dataIndex: 'schoolName', 
                menuDisabled: true,
                flex:1,
                editor: {
                    allowBlank:false
                }
            },
            {
                text: '種別',
                dataIndex: 'schoolStateLabel',
                menuDisabled: true,
               
            },
            {
                text: '入学年月日',
                dataIndex: 'enterDate',
                menuDisabled: true,
                xtype:'datecolumn',
                format:'Y/m/d',
                editor: {
                    xtype: 'datefield',
                    format:'Y/m/d'
                }
            },
            {
                text: '転出先の学校名',
                dataIndex: 'preSchoolName',
                menuDisabled: true,
                editor: {
                }
            },
            {
                text: '転学年月日',
                dataIndex: 'admitDate',
                menuDisabled: true,
                xtype:'datecolumn',
                format:'Y/m/d',
                editor: {
                    xtype: 'datefield',
                    format:'Y/m/d'
                }
            },
            {
                text: '卒業年月日',
                dataIndex: 'explusionDate',
                menuDisabled: true,
                xtype:'datecolumn',
                format:'Y/m/d',
                editor: {
                    xtype: 'datefield',
                    format:'Y/m/d'
                }
            }
        ];
        this.callParent(arguments);
    }
  }) ;