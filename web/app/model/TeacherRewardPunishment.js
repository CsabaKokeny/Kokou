Ext.define('Kokou.model.TeacherRewardPunishment', {
    extend: 'Ext.data.Model',
    fields:[
        'content',
        {name:'date', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'}
    ]
});