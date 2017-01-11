Ext.define('Kokou.model.Career', {
    extend: 'Ext.data.Model',
    fields:[
        'schoolName',
        'schoolState',
        'schoolStateLabel',
        'preSchoolName',
        {name:'enterDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
        {name:'admitDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
        {name:'explusionDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'}
    ]
});