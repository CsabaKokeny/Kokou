Ext.define('Kokou.model.Student', {
    extend: 'Ext.data.Model',
    fields: [
        {name:'id'},
        {name:'enterYear'},
        {name:'enterSchoolKind'},
        {name:'name'},
        {name:'nameKr'},
        {name:'birth', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
        {name:'sex'},
        {name:'sexLabel'},
        {name:'nation'},
        {name:'nationLabel'},
        {name:'department'}, 
        {name:'departmentLabel'}, 
        {name:'classLabel'},
        {name:'fullCode'},
        {name:'keeperJob'},
        'schoolYear',
        'className',
        'selected'
     ]
});