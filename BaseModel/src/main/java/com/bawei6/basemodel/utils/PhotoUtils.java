package com.bawei6.basemodel.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.provider.MediaStore;

/**
 * @author fengchen
 * @date 2020/1/15.
 * @description：打开本地相册
 */
public class PhotoUtils {
   public static void img(Activity activity){
       //打开本地相册
       Intent intent = new Intent();
       if (Build.VERSION.SDK_INT < 19) {
           intent.setAction(Intent.ACTION_GET_CONTENT);
           intent.setType("image/*");
       } else {
           intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
           intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
           activity.startActivityForResult(intent, NumberPool.MSGFRIST);
       }
   }
}
