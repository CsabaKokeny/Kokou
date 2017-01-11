var AppConfig = {};
AppConfig.themeName = 'neptune';
AppConfig.defaultThemeName = 'classic';
AppConfig.isRTL = false;
AppConfig.isDebug = true;
AppConfig.isDev = false;

(function() {
var css_suffix = '';
var js_suffix = '';
if (AppConfig.themeName !== undefined && AppConfig.themeName !== '') {
	css_suffix += '-' + AppConfig.themeName;
}
if (AppConfig.isRTL === true) {
	css_suffix += '-rtl';
	js_suffix += '-rtl';
}
if (AppConfig.isDebug === true) {
	css_suffix += '-debug';
}
if (AppConfig.isDev === true) {
	js_suffix += '-dev';
} else {
	if (AppConfig.isDebug === true) {
		js_suffix += '-debug';
	}
}
var path = '';
document.write('<link rel="stylesheet" type="text/css" href="'+path+'extjs/resources/css/ext-all'+css_suffix+'.css"/>');
document.write('<script type="text/javascript" src="'+path+'extjs/ext-all'+js_suffix+'.js"></script>');
if (AppConfig.themeName === 'neptune') {
	document.write('<script type="text/javascript" src="'+path+'extjs/ext-theme-neptune.js" defer></script>');
}
})();