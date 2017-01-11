Ext.define('Kokou.store.TeacherTransport',{
    extends: 'Ext.data.Store',
    model: 'Kokou.model.TeacherTransport',
    data: [],
    proxy: {
        type: 'memory'
    },
    load: function (obj, records) {
        if (!!!records) return;
        var count = records.length;
        for(var i=0;i<count;i++) {
            var model = records.getAt(i);
            model.set("sector", "区間"+(i+1));
        }
    },
    autoLoad: true
});