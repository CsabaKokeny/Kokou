Ext.define('Kokou.view.teacher.edit.ContactList', {
    extend: 'Kokou.view.teacher.edit.RowEditPanelWithEditors',
    widgets: {},
    getNewRow: function () {
        return Ext.create('Kokou.model.TeacherContact',{});
    },
    initComponent: function () {
        var _this = this;
        _this.widgets.contact = function () {
            return _this.getStore();
        }
        _this.store = Ext.create('Kokou.store.TeacherContact', {});
        _this.columns = [
            {
                text: '連絡先氏名', 
                dataIndex: 'name', 
                menuDisabled: true,
                editor: {
                    allowBlank:false
                }
            },
            {
                text: '電話番号',
                dataIndex: 'phone',
                menuDisabled: true,
                editor: {
                    allowBlank:false
                }
            },
            {
                text: '本人との関係',
                dataIndex: 'relation',
                menuDisabled: true,
                editor: this.getRelationEditor()
            }
        ];
        _this.callParent(arguments);
    }
  }) ;