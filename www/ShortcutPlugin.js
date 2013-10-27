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
}
