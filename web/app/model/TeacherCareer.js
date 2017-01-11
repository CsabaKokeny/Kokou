Ext.define('Kokou.model.TeacherCareer', {
    extend: 'Ext.data.Model',
    fields:[
        'place',
        {name:'enterDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
        {name:'retireDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
        'job'
    ]
});