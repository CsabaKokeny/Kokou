Ext.define('Kokou.model.TeacherFamilyMember', {
    extend: 'Ext.data.Model',
    fields:[
        'relation',
        'name',
        {name:'birth', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
        'address',
        {name:'with', type:'boolean'},
        'note'
    ]
});