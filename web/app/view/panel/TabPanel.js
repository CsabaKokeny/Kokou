Ext.define('Kokou.view.panel.TabPanel', {
    extend: 'Ext.tab.Panel',
    activeTab: 0,
    layout: 'fit',
    defaults: {
            autoScroll: true,
            bodyPadding: 0
    },
    initComponent: function () {
            this.addEvents([
                'tabselect'
            ]);
            this.callParent(arguments);
    },
    showTeacherManager: function () {
        var _this = this;
        if (!this.teacherTab) {
        }else {
            this.setActiveTab('teacherMngTab');
            return;
        }
        Ext.Msg.show({
            title: "暗号",
            msg: "暗号を入力します。",
            width: 300,
            buttons:Ext.Msg.OK,
            prompt: true,
            closable: true,
            buttonText: {
                ok:"確認"
            },
            fn: function (buttonId, text, opt) {
                if (buttonId === 'ok' || buttonId === 'yes') {
                    if (text === 'admin'){
                        _this.teacherTab = _this.add(Ext.create('Kokou.view.teacher.List', {
                            id: 'teacherMngTab',
                            closable: true,
                            title: '教職員管理',
                            width: '80%',
                            listeners: {
                                scope: _this,
                                activate: _this.onTabActivate,
                                close: function () {
                                    _this.teacherTab = undefined;
                                }
                            }
                        }));
                        _this.teacherTab.show();
                    }
                }
            }
        });
    },
    showStudentManager: function () {
        if (!this.studentTab) {
                this.studentTab = this.add(Ext.create('Kokou.view.student.List', {
                        id: 'studentMngTab',
                        closable: false,
                        title: '学生管理',
                        listeners: {
                                scope: this,
                                activate: this.onTabActivate
                        }
                }));
                this.studentTab.show();
        } else {
                this.setActiveTab('studentMngTab');
        }
    },
    showClassManager: function () {
            if (!this.classTab) {
                    this.classTab = this.add(Ext.create('Kokou.view.class.List', {
                            id: 'classMngTab',
                            closable: false,
                            title: 'クラス管理',
                            listeners: {
                                    scope: this,
                                    activate: this.onTabActivate
                            }
                    }));
                    this.classTab.show();
            } else {
                    this.setActiveTab('classMngTab');
            }
    },
    showLessonManager: function () {
            if (!this.lessonTab) {
                    this.lessonTab = this.add(Ext.create('Kokou.view.lesson.List', {
                            id: 'lessonMngTab',
                            closable: false,
                            title: '科目管理',
                            listeners: {
                                    scope: this,
                                    activate: this.onTabActivate
                            }
                    }));
                    this.lessonTab.show();
            } else {
                    this.setActiveTab('lessonMngTab');
            }
    },
    showMarkManager: function () {
            if (!this.markTab) {
                    this.markTab = this.add(Ext.create('Kokou.view.mark.List', {
                            id: 'markMngTab',
                            closable: false,
                            title: '成績管理',
                            listeners: {
                                    scope: this,
                                    activate: this.onTabActivate
                            }

                    }));
                    this.markTab.show();
            } else {
                    this.setActiveTab('markMngTab');
            }
    },
    showPrinter: function () {
            if (!this.printerTab) {
                    this.printerTab = this.add(Ext.create('Kokou.view.print.TabPanel', {
                            id: 'printMngTab',
                            closable: false,
                            title: '帳票印刷',
                            listeners: {
                                    scope: this,
                            }
                    }));
            }
    },
    onTabActivate: function (tab) {
            this.fireEvent('tabselect', tab, tab.getId());
    }
});