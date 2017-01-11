function isFunction(data) {
    return data!==null && data!==undefined && (typeof data)==='function';
}
function isObject(data) {
    return data!==null && data!==undefined && (typeof data)==='object';
}
function isString(data) {
    return data!==null && data!==undefined && (typeof data)==='string';
}
function isNumber(data) {
    return data!==null && data!==undefined && (typeof data)==='number';
}
function isBoolean(data) {
    return data!==null && data!==undefined && (typeof data)==='boolean';
}
function isArray(data) {
    return isObject(data)?isFunction(data.pop) && isFunction(data.push):false;
}
function isDate(data) {
    return isObject(data)?isFunction(data.getFullYear) && isFunction(data.getMonth) && isFunction(data.getDate):false;
}
Ext.define('Kokou.json.Unmarshaller', {
    
    unmarshallNormal: function (object, value) {
        if (value === null || value === undefined) value = '';
        if (isFunction(value)) value = value();
        object.setValue(value);
    },
    
    unmarshallExtStore: function (store, value) {
        if (isFunction(value)) value = value();
        if (value === null || value === undefined) value = {};
        if (value !== null && value !== undefined) {
            if (!!!value.push) {
                value = [value];
            }
        }else{
            value = [];
        }
        store.loadData(value, false);
    },
    
    unmarshallObject: function (object, value) {
        if (value === null || value === undefined) return;
        if (isFunction(object)) object = object();
        if (isFunction(value)) value = value();
        if (!!object.setValue) {
            this.unmarshallNormal(object, value);
        } else if (!!object.getStore) {
            this.unmarshallExtStore(object.getStore(), value);
        } else if (!!object.getProxy && !!object.getNewRecords) {
            this.unmarshallExtStore(object, value);
        } else if (isArray(object)){
            for (var i=0; i<object.length; i++) {
                var item = object[i];
                if (item === null || item === undefined) continue;
                if (isFunction(item)) item = item();
                if (isObject(item)) {
                    this.unmarshallObject(item,value);
                }
            }
        } else {
            for (var i in object) {
                var item = object[i];
                if (item === null || item === undefined) continue;
                if (isFunction(item)) item = item();
                if (isObject(item)) {
                    this.unmarshallObject(item,value[i]);
                }
            }
        }
    },
    
    unmarshall: function (objects, data) {
        if (isFunction(objects)) objects = objects();
        if (isFunction(data)) data = data();
        if (objects === null || objects === undefined) return;
        if (data === null || data === undefined) return;
        if (!isObject(objects)) return;
        this.unmarshallObject(objects, data);
    }
});