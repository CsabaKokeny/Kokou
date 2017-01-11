Ext.define('Kokou.store.Marks', {
    extend: 'Ext.data.Store',
    model: 'Kokou.model.Mark',
    autoLoad: true,
    data: [
        {"id":1, "name":'Lesson1', "schoolid": "", "schoollevel":""},
        {"id":2, "name":'Lesson2', "schoolid": "", "schoollevel":""},
        {"id":3, "name":'Lesson3', "schoolid": "", "schoollevel":""},
    ]
            /*
    proxy: {
        type: 'ajax',
        url: 'app/data/datas.json',
        reader: {
            type:'json',
            root:'marks',
            successProperty:'success'
        }
    } */
});