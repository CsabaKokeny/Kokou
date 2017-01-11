Ext.application ({
    models: [
        'Family',
        'Career',
        'Contact',
        'Transport',
        
        'TeacherCareer',
        'TeacherContact',
        'TeacherFamilyMember',
        'TeacherRewardPunishment',
        'TeacherTransport'
    ],
    stores: [
        'Feeds',
        'Teachers',
        'Classes',
        'Students',
        'Lessons',
        'Marks',
        
        'TeacherCareer',
        'TeacherContact',
        'TeacherEnterKind',
        'TeacherFamilyMember',
        'TeacherGraduationSchoolKind',
        'TeacherPhoneType',
        'TeacherRelation',
        'TeacherResidence',
        'TeacherRewardPunishment',
        'TeacherSchoolResult',
        'TeacherSex',
        'TeacherTransport'
    ],
    requires: [
        /*
        'Ext.container.Viewport',
        'Kokou.view.layout.Borders',
        'Kokou.view.panel.FeedPanel',
        'Kokou.view.panel.TabPanel',
        'Kokou.view.teacher.List',
        'Kokou.view.teacher.Edit',
        'Kokou.view.class.List',
        'Kokou.view.class.Edit',
        'Kokou.view.student.List',
        'Kokou.view.student.Edit',
        'Kokou.view.lesson.List',
        'Kokou.view.lesson.Edit',
        'Kokou.view.mark.List',
        'Kokou.view.mark.Edit',
        'Kokou.view.print.TabPanel'
        */
       'Kokou.store.Departments',
       'Kokou.store.Sexs',
       'Kokou.store.Nations',
    ],
            /*
    controllers: [
        'Users'
    ], */
    name: 'Kokou',
    appFolder: 'app',
    launch: function () {
        Ext.create('Kokou.view.layout.Borders', {});
    }
});