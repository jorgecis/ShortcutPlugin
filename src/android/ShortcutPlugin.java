package com.phonegap.plugins.shortcut;
 
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;

public class ShortcutPlugin extends CordovaPlugin {
    public static final String ACTION_ADD_SHORTCUT = "addShortcut"; 
    public static final String ACTION_DEL_SHORTCUT = "delShortcut"; 

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        try {
            if (ACTION_ADD_SHORTCUT.equals(action)) {
                JSONObject arg_object = args.getJSONObject(0);

                Intent shortcutIntent = new Intent(getApplicationContext(),
                    MainActivity.class);
     
                shortcutIntent.setAction(Intent.ACTION_MAIN);
 
                Intent addIntent = new Intent();
                addIntent
                    .putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent)
                    .putExtra(Intent.EXTRA_SHORTCUT_NAME, arg_object.getLong("shortcuttext"))
                    .putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                    Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                    R.drawable.ic_launcher))
                    .setAction("com.android.launcher.action.INSTALL_SHORTCUT");
                getApplicationContext().sendBroadcast(addIntent);

                callbackContext.success();
                return true;
            } else if (ACTION_ADD_SHORTCUT.equals(action)) {
                Intent shortcutIntent = new Intent(getApplicationContext(),
                    MainActivity.class);
                shortcutIntent.setAction(Intent.ACTION_MAIN);
     
                Intent addIntent = new Intent();
                addIntent
                    .putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent)
                    .putExtra(Intent.EXTRA_SHORTCUT_NAME, arg_object.getLong("shortcuttext"))
                    .setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
                getApplicationContext().sendBroadcast(addIntent);

            } 
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        } 
    }
}
