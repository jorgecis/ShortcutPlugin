//Copyright 2013 Jorge Cisneros jorgecis@gmail.com

var ShortcutPlugin = function() {}; 

ShortcutPlugin.prototype.CreateShortcut = function (shortcut_text, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'ShortcutPlugin',
            'addShortcut',
            [{ 
                "shortcuttext": shortcut_text
            }]
        );
};
ShortcutPlugin.prototype.RemoveShortcut = function(shortcut_text, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'ShortcutPlugin',
            'delShortcut',
            [{ 
                "shortcuttext": shortcut_text
            }]
        );
};

if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.Shortcut) {
    window.plugins.Shortcut = new ShortcutPlugin();
}
