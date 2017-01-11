(function () {
	function hasOption(opt) {
        var s = window.location.search;
        var re = new RegExp('(?:^|[&?])' + opt + '(?:[=]([^&]*))?(?:$|[&])', 'i');
        var m = re.exec(s);
        return m ? (m[1] === undefined ? true : m[1]) : false;
    }
    
    Ext.themeName = AppConfig.themeName;
    Ext.defaultThemeName = AppConfig.defaultThemeName;
    if (Ext.isIE6) {
		if (Ext.themeName === 'neptune') {
			Ext.themeName = Ext.defaultThemeName;
		}
	}
    
    Ext.onReady(function () {
		Ext.getBody().addCls(Ext.baseCSSPrefix+'theme-'+Ext.themeName);
		if (hasOption('nocss3')) {
			Ext.supports.CSS3BorderRadius = false;
			Ext.getBody().addCls('x-nbr x-nlg');
		}
	});	
})();

