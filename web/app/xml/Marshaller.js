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
Ext.define('Kokou.xml.Marshaller', {
    
    marshallFunction: function (func, tag) {
        var value = func();
        if (isObject(value)) {
            return this.marshallObject(value, tag);
        } else {
            return this.marshallNormal(value, tag);
        }
    },
    marshallNormal: function (value, tag) {
        var content = '';
        content = value;
        if (content === null || content === undefined) return '';
        if (!!!tag || !isNaN(parseInt(tag))) tag = '';
        if (tag !== '') content = '<'+tag+'>'+content+'</'+tag+'>';
        return content;
        
    },
    marshallArray: function (array, tag) {
        var content = '';
        for (var i=0;i<array.length;i++) {
            var item = array[i];
            if (item === null || item === undefined) continue;
            if (isObject(item)) content += this.marshallObject(item, tag);
            else if (isFunction(item)) content += this.marshallFunction(item, tag);
            else content += this.marshallNormal(item, tag);
        }
        return content;
    },
    marshallDate: function(date, tag) {
        var content = '';
        content += date.getFullYear()+'/';
        if (date.getMonth()<9) {
            content+='0';
        }
        content+=(date.getMonth()+1)+'/';
        if (date.getDate()<9) {
            content+='0';
        }
        content+=date.getDate();
        if (!!!tag || !isNaN(parseInt(tag))) tag = '';
        if (tag !== '') content = '<'+tag+'>'+content+'</'+tag+'>';
        return content;
    },
    marshallExtStore: function(extStore, tag) {
        var content = '';
        var count = extStore.getCount();
        for (var i=0;i<count;i++) {
            var item = extStore.getAt(i);
            content += this.marshallObject(item.getData(true), tag);
        }
        return content;
    },
    marshallExtField: function (extField, tag) {
        var value = extField.getValue();
        if (isObject(value)) {
            return this.marshallObject(value, tag);
        } else {
            return this.marshallNormal(value, tag);
        }
    },
    
    marshallObject: function (object, tag) {
        var content = '';
        if (isArray(object)) {
            return this.marshallArray(object, tag);
        } else if (isDate(object)) {
            return this.marshallDate(object, tag);
        } else if (!!object.getValue){
            var value = object.getValue();
            if (isObject(value)) {
                return this.marshallObject(value, tag);
            } else {
                return this.marshallNormal(value, tag);
            }
        } else if (!!object.getStore) {
            return this.marshallExtStore(object.getStore(), tag);
        } else if (!!object.getNewRecords && !!object.getProxy) {
            return this.marshallExtStore(object, tag);
        } else {
            for (var i in object) {            
                var item = object[i];
                var key = isNaN(parseInt(i))?i:'';
                if (key === '') continue;
                if (isFunction(item)) {
                    content += this.marshallFunction(item, key);
                } else if (isObject(item)) {
                    content += this.marshallObject(item, key);
                } else {
                    content += this.marshallNormal(item, key);
                }
            }
        }
        if (!!!tag || !isNaN(parseInt(tag))) tag = '';
        if (tag !== '') content = '<'+tag+'>'+content+'</'+tag+'>';
        return content;
    },
    marshall: function (value, tag) {
        var tagWrapper = '';
        var content = '';
        if (value === null || value === undefined) return '';
        if (!!tag && isNaN(parseInt(tag))) tagWrapper = tag;
        if (isObject(value)) {
            if (!!value.tag && isNaN(parseInt(value.tag))) {
                var hasTag = false, hasData = false;
                for(var i in  value) {
                    if (i === 'tag') {
                        hasTag = true;
                    }
                    if (i === 'data') {
                        hasData = true;
                    }
                }
                if (hasTag && hasData) {
                    if (!!value.data) {
                        content += this.marshall(value.data, value.tag);
                    }
                } else {
                    content += this.marshallObject(value, value.tag);
                }
            } else {
                content += this.marshallObject(value);
            }
        } else if (isFunction(value)) {
            content += this.marshallFunction(value, tag);
            return content;
        } else {
            content += this.marshallNormal(value, tag);
            return content;
        }
        if (tagWrapper !== '') {
            content = '<'+tagWrapper+'>'+content+'</'+tagWrapper+'>';
        }
        return content;
    }
});