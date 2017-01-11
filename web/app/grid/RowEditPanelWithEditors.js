Ext.define('Kokou.grid.RowEditPanelWithEditors', {
    extend: 'Kokou.grid.RowEditPanel',
    getRelationEditor: function () {
        if (this.relationEditor === null || this.relationEditor === undefined) {
            this.relationEditor =  Ext.create('Kokou.view.form.field.EmployeeRelationTypeComboBox',{fieldLabel:''});
        }
        return this.relationEditor;
    },
    onRowBeforeEdit: function (editor, context, eOpts) {
        this.callParent(arguments);
        var data = this.getSelectionModel().getSelection();
        if (!!data[0] && !!data[0].get) {
            if (!!this.relationEditor) {
                this.relationEditor.setValue(data[0].get('relation'));
            }
        }
    },
    onRowEdit: function (editor, context, eOpts) {
        this.callParent(arguments);
        var data = this.getSelectionModel().getSelection();
        if (!!this.relationEditor) {
            data[0].set('relation', this.relationEditor.getValue());
            data[0].set('relationLabel', this.relationEditor.getDisplayValue());
        }
    }
  }) ;