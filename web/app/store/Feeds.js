Ext.define('Kokou.store.Feeds', {
    extend: 'Ext.data.Store',
    model: 'Kokou.model.Feed',
    autoLoad: true,
    data: [
        {"title":"教職員管理", "url":"showTeacherManager"},
        {"title":"クラス管理", "url":"showClassManager"},
        {"title":"学生管理", "url":"showStudentManager"},
        {"title":"科目管理", "url":"showLessonManager"},
        //{"title":"成績管理", "url":"showMarkManager"},
        {"title":"帳票印刷", "url":"showPrinter"}
    ]
    /*
    proxy: {
        type: 'ajax',
        url: 'app/data/datas.json',
        reader: {
                type:'json',
                root:'feeds',
                successProperty:'success';
        }
    } */
});