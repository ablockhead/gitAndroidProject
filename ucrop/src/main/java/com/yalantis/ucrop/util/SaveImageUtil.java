package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.yalantis.ucrop.model.CutInfo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ProjectName: gitAndroidProject$
 * @Package: com.yalantis.ucrop.util$
 * @ClassName: SaveImageUtil$
 * @Description: 类作用描述
 * @Author: xuliang
 * @CreateDate: 2019/7/19$ 15:33$
 * @Version: 1.0.0
 */
public class SaveImageUtil {

    private static final String FILE_PATH = "sdcard/Allimage_Theelderly/";

    /**
     * 获取Bitmap
     * @param cutInfo
     * @return
     */
    public static Bitmap getBitmap(CutInfo cutInfo){
        try {
            FileInputStream fileInputStream = new FileInputStream(cutInfo.getPath());
            Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
            return bitmap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 保存Bitmap并返回路径
     */
    public static String saveBitMap(Bitmap bm){
        String fileName = UUID.randomUUID().toString();
        File myCaptureFile = new File(FILE_PATH+fileName+".jpg");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
            bm.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            System.out.println( FILE_PATH+fileName+" FILE_PATH+fileName FILE_PATH+fileName");
            bos.flush();
            bos.close();
            return FILE_PATH+fileName;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e+"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        }
        return "错误";
    }
}
