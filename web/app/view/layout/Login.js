Ext.define('Kokou.view.layout.Login', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.layoutlogin',
    layout: 'fit',
    defaults: {
        split: true
    },
    initComponent: function () {
        Ext.apply(this, {
            items: [
                this.createLoginPanel()
            ]
        });
        this.callParent(arguments);
    },
    createLoginPanel: function () {
        this.loginPanel = Ext.create('Kokou.view.panel.LoginPanel', {
            minHeight: 50,
            closable: false,
            listeners: {
                scope: this,
                login: this.onLogin,
                submit: this.onLogin
            }
        });
        return this.loginPanel;
    },
    onLogin: function () {
        var form = this.down("form");
        var username = form.down("#txtUsername").getValue();
        var password = form.down("#txtPassword").getValue();
        Ext.Ajax.request({
            url: 'loginAction',
            params: {
                username: username,
                password: password
            },
            success: function(response) {
                eval("result=" + response.responseText);
                if (result.error === 0) {
                    document.location.href="start";
                } else {
                    Ext.Msg.alert("加入失敗", "加入が失敗しました。");
                }
            }
        });
    }
});