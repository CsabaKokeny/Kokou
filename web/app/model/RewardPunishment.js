Ext.define('Kokou.model.RewardPunishment', {
    extend: 'Ext.data.Model',
    fields:[
        'content',
        {name:'takeDate', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'}
        
    ]
});