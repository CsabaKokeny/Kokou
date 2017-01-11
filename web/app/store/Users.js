Ext.define('Kokou.store.Users', {
    extend: 'Ext.data.Store',
    //fields: ['name', 'email'],
    model: 'Kokou.model.User',
    autoLoad: true,
    /*	
    data: [
        {
            name: 'Ed',
            email: 'ed@sencha.com'
        },
        {
            name: 'Tommy',
            email: 'tommy@sencha.com'
        }
    ],
    */
    /*
    proxy: {
        type: 'ajax',
        //url: 'app/data/users.json',
        api: {
            read: 'app/data/users.json',
            update: 'app/data/updateUsers.json'
        },
        reader: {
            type:'json',
            root:'users',
            successProperty:'success'
        }
    }
    */
});