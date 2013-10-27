package com.phonegap.plugins.shortcut;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;
import android.content.Context;
import android.os.Parcelable; 

public class ShortcutPlugin extends CordovaPlugin {
    public static final String ACTION_ADD_SHORTCUT = "addShortcut"; 
    public static final String ACTION_DEL_SHORTCUT = "delShortcut"; 

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        try {
            if (ACTION_ADD_SHORTCUT.equals(action)) {
                JSONObject arg_object = args.getJSONObject(0);
                Context context=this.cordova.getActivity().getApplicationContext();

		Intent i = new Intent();
		i.setClassName(context.getPackageName(), context.getPackageName());
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
		//repeat to create is forbidden
		shortcutintent.putExtra("duplicate", false);
		//set the name of shortCut
		shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, arg_object.getString("shortcuttext"));
		//set icon
		Parcelable icon = Intent.ShortcutIconResource.fromContext(context, R.drawable.ic_launcher);
		shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
		//set the application to lunch when you click the icon
		shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, i);
		//sendBroadcast,done
		context.sendBroadcast(shortcutintent);

                callbackContext.success();
                return true;
            } else if (ACTION_ADD_SHORTCUT.equals(action)) {
                JSONObject arg_object = args.getJSONObject(0);
                Context context=this.cordova.getActivity().getApplicationContext();
                /* Intent shortcutIntent = new Intent(context,
                    MainActivity.class);
                shortcutIntent.setAction(Intent.ACTION_MAIN);
     
                Intent addIntent = new Intent();
                addIntent
                    .putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent)
                    .putExtra(Intent.EXTRA_SHORTCUT_NAME, arg_object.getLong("shortcuttext"))
                    .setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
                context.sendBroadcast(addIntent);
                */
                callbackContext.success();

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
