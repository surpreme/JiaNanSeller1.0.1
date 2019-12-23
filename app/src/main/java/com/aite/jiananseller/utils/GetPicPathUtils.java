package com.aite.jiananseller.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;

public class GetPicPathUtils {
    //获取图片路径
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getPath(Context context, Uri uri) {
        String path = "";
        //content：//com.adnroid.providers.media.documents/image:840
        String[] columns = {MediaStore.Images.Media.DATA};
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String idStr = DocumentsContract.getDocumentId(uri);//image:840
            //裁剪
            String id = idStr.split(":")[1];//840
            //查询绝对路径
            Cursor c = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns
                    , MediaStore.Images.Media._ID + "=?", new String[]{id}, null);
            if (c.moveToFirst()) {
                path = c.getString(0);
            }
            c.close();
        } else {
            String s = uri.toString();
            if (s.startsWith("file://")) {
                path = s;
            } else {
                //content://com.adnroid.providers.media/image/840
                Cursor c = context.getContentResolver().query(uri, columns, null, null, null);
                if (c.moveToFirst()) {
                    path = c.getString(0);
                }
                c.close();
            }
        }
        return path;
    }
}
