var ShortcutPlugin = {
    CreateShortcut: function(shortcut_text, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'ShortcutPlugin',
            'addShortcut',
            [{ 
                "shortcuttext": shortcut_text
            }]
        );
    }
    DeleteShortcut: function(shortcut_text, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'ShortcutPlugin',
            'delShortcut',
            [{ 
                "shortcuttext": shortcut_text
            }]
        );
    }


}
