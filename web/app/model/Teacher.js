Ext.define('Kokou.model.Teacher', {
    extend: 'Ext.data.Model',
    fields: [
        {name:'id'},
        {name: 'enterDate'},
        {name: 'enterKind'},
        {name: 'currentPosition', mapping:'positionInformation.currentPosition'},
        {name: 'name'},
        {name: 'nameKr'},
        {name: 'sex'},
        {name: 'nation'},
        {name: 'nationLabel'},
        {name: 'birth', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'}
    ]
});