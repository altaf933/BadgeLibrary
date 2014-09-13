BadgeLibrary
============
This is library create while i going to trying more than one badge image.

Steps :
 First you need to add your root layout 
 "xmlns:badge_style="http://schemas.android.com/apk/res-auto""
 
Example:

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:badge_style="http://schemas.android.com/apk/res-auto"
    android:id="@+id/container"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">

    <badgecustomview.CustomBadge
        android:id="@+id/customebadge"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        badge_style:background_badgecolor="#F5A9F2"
        badge_style:badgeSize_Height="20"
        badge_style:badgeSize_Width="20"
        badge_style:badgeTextColor="#298A08"
        badge_style:icon_main="@android:drawable/ic_menu_delete"></badgecustomview.CustomBadge>


</LinearLayout>

-->Here libraray also handle click listener and settext again when you get badge again
-->I am still trying to putting effort and more user freindly.

