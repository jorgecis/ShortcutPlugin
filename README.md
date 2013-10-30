# Cordova Home Shortcut Plugin for Android 

---

## DESCRIPTION

This plugin is for use with [Cordova](http://incubator.apache.org/cordova/), and allows your application to add or remove shortcuts in the android home. 

Note: This plugin is for phonegap 3.x


## LICENSE

	The MIT License

	Copyright (c) 2013 Adobe Systems, inc.
	portions Copyright (c) 2013 Jorge Cisneros jorgecis@gmail.com

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in
	all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.


## To install this plugin using the cli

  cordova plugins add https://github.com/jorgecis/ShortcutPlugin.git

## To used in the build phonegap service 

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

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/jorgecis/shortcutplugin/trend.png)](https://bitdeli.com/free "Bitdeli Badge")
