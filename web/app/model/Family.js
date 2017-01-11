Ext.define('Kokou.model.Family', {
    extend: 'Ext.data.Model',
    fields:[
        'relation',
        'relationLabel',
        'name',
        { name:'birth', dateFormat: 'Y/m/d', dateReadFormat:'Y/m/d', dateWriteFormat:'Y/m/d'},
        'address',
        { name:'with', type:'boolean' },
        'note'
    ]
});