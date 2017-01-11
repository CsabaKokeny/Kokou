Ext.application ({
    requires: [
        /*
        'Ext.container.Viewport',
        'Kokou.view.layout.Login',
        'Kokou.view.panel.LoginPanel'
            */
    ],
    name: 'Kokou',
    appFolder: 'app',
    launch: function () {
        Ext.create('Kokou.view.layout.Login', {});
    }
});