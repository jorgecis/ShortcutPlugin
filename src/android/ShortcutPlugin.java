package com.phonegap.plugins.shortcut;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;
import android.content.Context;
import android.os.Parcelable; 
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;

public class ShortcutPlugin extends CordovaPlugin {
    public static final String ACTION_ADD_SHORTCUT = "addShortcut"; 
    public static final String ACTION_DEL_SHORTCUT = "delShortcut"; 

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        try {
            if (ACTION_ADD_SHORTCUT.equals(action)) {

		//Get params
                JSONObject arg_object = args.getJSONObject(0);

                Context context=this.cordova.getActivity().getApplicationContext();
		PackageManager pm = context.getPackageManager();

		Intent shortcutIntent = new Intent();
		shortcutIntent.setClassName(this.cordova.getActivity().getPackageName(), this.cordova.getActivity().getClass().getName());
		shortcutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
		shortcutintent.putExtra("duplicate", false);
		shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, arg_object.getString("shortcuttext"));

		//Get Icon
		ResolveInfo ri = pm.resolveActivity(shortcutIntent, 0);
		int iconId = ri.activityInfo.applicationInfo.icon;
		Parcelable icon = Intent.ShortcutIconResource.fromContext(context, iconId);

		shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
		shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
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
