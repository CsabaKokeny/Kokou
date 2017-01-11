Ext.define('Kokou.view.teacher.detail.ContactList', {
    extend: 'Kokou.view.teacher.edit.RowEditPanelWithEditors',
    readOnly: true,
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
                
            },
            {
                text: '電話番号',
                dataIndex: 'phone',
                menuDisabled: true,
                
            },
            {
                text: '本人との関係',
                dataIndex: 'relation',
                menuDisabled: true,
            }
        ];
        _this.callParent(arguments);
    }
  }) ;