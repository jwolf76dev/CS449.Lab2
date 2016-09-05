# CS449.Lab2
UMKC Fall 2016, Eddie Burris

The purpose of labs 1 and 2 is to give you practice with Android features you are likely to use this semester as you implement your project idea. Lab 1 gave you practice with Activities, UI components, event handlers and dialog boxes. Lab 2 adds:
* Application icons
*	Menus (action/tool bar and contextual menus)
*	Starting a new Activity
*	Persistent storage (saving state between sessions)
*	Screen Rotation (switching back and forth between portrait and landscape) 
*	Preferences (PreferenceActivity)

## Part 1 – Application Icon
Create a custom application launch icon for your application.

Hints: 
1. Create an image using an image editing program such as Gimp. Make it square. Save it as a .png with a transparent background. Make sure file name is all lower case characters with no special symbols.
2. If you want your application icon (or other image) to look great no matter the screen resolution of the device, you will want to create and save images at different resolutions. One option is to use Asset Studio. (ref: http://developer.android.com/tools/help/image-asset-studio.html) The manual way is to copy images at different resolutions to mipmap res subfolders. [May have to switch to Project View. If you have only one image, copy to any one of the subfolders.]
3. Reference the image in the manifest file under application/icon.

For more information about drawable images in Android, see: http://developer.android.com/design/style/iconography.html

The app name on the home screen and the label on the main activity are specified in the AndroidManifest.xml file. The default name for both of these is the name of your app. You might want to change these to something more descriptive.

Note, you can specify an icon for both the application and main activity. If you do, the icon on the home screen for the application will be the activity icon.

## Part 2 - Menus
Add a menu to the main activity of the application. Include two options, one for resetting the count (“Reset”) and another for displaying information about the application (“About”). Place the reset menu option icon on the action bar with text “Reset” if there is room. Make sure the About menu option always stays in the overflow area.

Note, you may have to rotate the screen to create enough room on the action/tool bar for the text “Reset” to display.

Selecting the Reset menu option should reset the count. Selecting the About menu option should display a new activity with information about the application. Be sure to include your name in the new activity.

You can use Android Stuidio’s Image Asset program to create the icon for your reset menu. You will find a suitable reset icon under clipart.

An alternative to creating your own drawable is to copy existing system drawables from the SDK. You can find these files at: C:\Users\<user name>\AppData\Local\Android\sdk\platforms\android-23\data\res\drawable-hdpi

Another option is to reference one of the system icon images. Example: `icon=”@android:drawable/ic_menu_add”`. However, these aren’t consistent across devices.

**[Extra Credit]** Provide a contextual menu using the contextual action mode on the background  of the main activity (or any UI component of your choosing) such that when the user long clicks a menu pops up that offers the ball and strike options.

References:  
http://developer.android.com/guide/topics/ui/menus.html
http://developer.android.com/guide/topics/resources/menu-resource.html
http://developer.android.com/training/basics/firstapp/starting-activity.html

## Part 3 – Persistent Storage
Add a field which counts total outs. The value should persist between sessions (even when user exits the app by pressing the back key). The only way to reset the value is by clearing the data for the app through settings.

## Part 4 – Rotations [Extra Credit]
Define a layout to be used in landscape mode that positions the buttons side-by-side when device is in landscape mode. The strike and ball count should remain unchanged when flipping between portrait and landscape.

## Part 5 – Preferences [Extra credit]
Add a menu option for application settings. Selecting settings should bring up a settings activity (Consider using new style Preference Fragments ) that allows the user to select whether or not to announce “out” and “walk” audibly using Android’s support for text-to-speech (tts). Preferences should of course persist between sessions. The setting should work. Great the user with an audible “Out” or “Walk” when appropriate.
