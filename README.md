# Cordova Home Shortcut Plugin for Android 

---

## DESCRIPTION

This plugin is for use with [Cordova](http://incubator.apache.org/cordova/), and allows your application to add or remove shortcuts in the android home. 

Note: This plugin is for phonegap 3.x


## To install this plugin using the cli

  cordova plugins add https://github.com/jorgecis/ShortcutPlugin.git

## To used in the build phonegap service (Not aproved at this moment)

  add com.plugins.shortcut to your config.xml

```
  <gap:plugin name="com.plugins.shortcut" />
```

## How to use it

  Insert the js file, something like this 
```
  <script type="text/javascript" src="js/ShortcutPlugin.js"></script>
```
  To add a shotcut is very easy, just do the following.
```
  <script>
     window.plugins.Shortcut.CreateShortcut("Text to show", successfunc, failfunc );
  </script>
```
