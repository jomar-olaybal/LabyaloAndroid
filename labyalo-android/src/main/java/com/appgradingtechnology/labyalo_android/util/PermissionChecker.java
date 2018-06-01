package com.appgradingtechnology.labyalo_android.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Labyalo on 8/3/2017.
 */

public class PermissionChecker {
    public static final int REQUEST_PERMISSION = 123;

    public static boolean checkPermissions(Context context, String permission){
        return checkPermissions(context, permission, REQUEST_PERMISSION);
    }

    public static boolean checkPermissions(Context context, String permission, int requestCode){
        Activity activity = (Activity) context;
        if (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(activity,  new String[]{permission}, requestCode);
            return false;
        }
        return true;
    }

    public static boolean checkPermissions(Context context, String[] permissions){
        return checkPermissions(context, permissions, REQUEST_PERMISSION);
    }

    public static boolean checkPermissions(Context context, String[] permissions, int requestCode){
        Activity activity = (Activity) context;
        List<String> newPermissions = new ArrayList<>();
        for (String permission : permissions){
            if (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_DENIED) {
                newPermissions.add(permission);
            }
        }

        if(newPermissions.size() > 0){
            ActivityCompat.requestPermissions(activity,  newPermissions.toArray(new String[0]), requestCode);
            return false;
        }
        return true;
    }

    public static boolean checkPermissions(FragmentActivity activity, String[] permissions, int requestCode){
        List<String> newPermissions = new ArrayList<>();
        for (String permission : permissions){
            if (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_DENIED) {
                newPermissions.add(permission);
            }
        }

        if(newPermissions.size() > 0){
            ActivityCompat.requestPermissions(activity,  newPermissions.toArray(new String[0]), requestCode);
            return false;
        }
        return true;
    }
}
