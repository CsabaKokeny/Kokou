Ext.define('Kokou.view.panel.LoginPanel', {
    extend:  'Ext.window.Window',
    alias: 'widget.loginpanel',
    title: '使用者認証',
    layout: 'hbox',
    autoShow: true,
    modal: true,
    listeners: {
        keyup: function () {
            alert("abc");
        }
    },
    initComponent: function () {
        var _this = this;
        this.items = [
            {
                xtype: 'form',
                frame: true,
                collapsible: false,
                bodyPadding: '10,20',
                defaults: {
                    anchor: '50%'
                },
                items: [
                    {
                        id: 'txtUsername',
                        xtype: 'textfield',
                        name: 'username',
                        fieldLabel: '使用者',
                        enableKeyEvents: true,
                        listeners : {
                            keyup: function (obj, e, eOpts) {
                                if (e.getKey() === 13) {
                                    _this.fireLoginEvent();
                                }
                            }
                        }
                    },
                    {
                        id: 'txtPassword',
                        xtype: 'textfield',
                        inputType: 'password',
                        name: 'password',
                        fieldLabel: '暗号',
                        enableKeyEvents: true,
                        listeners : {
                            keyup: function (obj, e, eOpts) {
                                if (e.getKey() === 13) {
                                    _this.fireLoginEvent();
                                }
                            }
                        }
                    }
                ]
            }
        ];
        this.addEvents(
            'login'
        );
        this.buttons = [
            {
                text: '加入',
                listeners: {
                    scope: this,
                    click: this.fireLoginEvent
                }
            }
        ];
        this.callParent(arguments);
    },
    fireLoginEvent: function () {
        this.fireEvent('login', this);
    }
});