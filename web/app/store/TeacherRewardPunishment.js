Ext.define('Kokou.store.TeacherRewardPunishment',{
    extends: 'Ext.data.Store',
    model: 'Kokou.model.TeacherRewardPunishment',
    data: [],
    proxy: {
        type: 'memory'
    },
    autoLoad: true
});