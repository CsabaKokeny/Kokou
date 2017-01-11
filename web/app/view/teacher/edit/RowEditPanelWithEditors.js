Ext.define('Kokou.view.teacher.edit.RowEditPanelWithEditors', {
    extend: 'Kokou.grid.RowEditPanelWithEditors',
    getRelationEditor: function () {
        if (this.relationEditor === null || this.relationEditor === undefined) {
            this.relationEditor =  Ext.create('Kokou.form.field.teacher.RelationComboBox',{fieldLabel:''});
        }
        return this.relationEditor;
    }
});