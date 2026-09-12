package com.transsnet.downloader;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes7.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f60368a = new y();

    private y() {
    }

    private final String b(String str) {
        try {
        } catch (Throwable th2) {
            lg.a.f68962a.c("resource_save", "是否有相同文件，报错， = " + th2, true);
            th2.printStackTrace();
        }
        if (!new File(str).exists()) {
            lg.a.f68962a.c("resource_save", "是否有相同文件，exists = false", true);
            return str;
        }
        lg.a.f68962a.c("resource_save", "是否有相同文件，exists = true", true);
        String str2 = "." + StringsKt.f1(StringsKt.h1(str, UrlUtils.QUESTION_MARK, null, 2, null), ".", null, 2, null);
        String str3 = "_" + new SimpleDateFormat("yyMMddHHmmss").format(Long.valueOf(System.currentTimeMillis())) + str2;
        lg.a.f68962a.c("resource_save", "有相同文件，加个后缀下载, fileSuffix = " + str2 + ", newFileSuffix = " + str3, true);
        return StringsKt.Q(str, str2, str3, false, 4, null);
    }

    private final void c(Context context, ContentResolver contentResolver, File file, Uri uri, Function2 function2) {
        if (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return;
        }
        Intrinsics.e(uri);
        OutputStream openOutputStream = contentResolver.openOutputStream(uri);
        FileInputStream fileInputStream = new FileInputStream(file);
        long length = file.length();
        byte[] bArr = new byte[65536];
        long j11 = 0;
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read <= 0) {
                break;
            }
            if (openOutputStream != null) {
                openOutputStream.write(bArr, 0, read);
            }
            j11 += read;
            function2.invoke(Long.valueOf(j11), Long.valueOf(length));
        }
        fileInputStream.close();
        if (openOutputStream != null) {
            openOutputStream.close();
        }
    }

    private final List f(Context context) {
        Set<String> externalVolumeNames;
        Uri contentUri;
        ArrayList arrayList = new ArrayList();
        externalVolumeNames = MediaStore.getExternalVolumeNames(context);
        Intrinsics.g(externalVolumeNames, "getExternalVolumeNames(...)");
        for (String str : externalVolumeNames) {
            if (!Intrinsics.c(str, "external_primary")) {
                Intrinsics.e(str);
                arrayList.add(0, str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            contentUri = MediaStore.Downloads.getContentUri((String) it.next());
            Intrinsics.g(contentUri, "getContentUri(...)");
            arrayList2.add(contentUri);
        }
        return arrayList2;
    }

    private final boolean j(Context context, String str, String str2, Function2 function2, Function1 function1) {
        ContentResolver contentResolver;
        String Q;
        try {
            contentResolver = context.getContentResolver();
            Q = StringsKt.Q(str, str2, lj.b.f68989a.a(), false, 4, null);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            String b11 = b(Q);
            lg.a.f68962a.c("resource_save", "saveVideoToAlbumAfterQ targetPath = " + Q + ", beforeRootPath = " + str2, true);
            String f12 = StringsKt.f1(b11, "/", null, 2, null);
            if (function1 != null) {
                function1.invoke(b11);
            }
            File file = new File(str);
            ContentValues h11 = h(context, file, f12, System.currentTimeMillis());
            Uri insert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, h11);
            Intrinsics.e(contentResolver);
            c(context, contentResolver, file, insert, function2);
            h11.clear();
            h11.put("is_pending", (Integer) 0);
            ContentResolver contentResolver2 = context.getContentResolver();
            Intrinsics.e(insert);
            contentResolver2.update(insert, h11, null, null);
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", insert));
            return true;
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            lg.a.f68962a.i("resource_save", "saveVideoToAlbumAfterQ error = " + th, true);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x017c A[Catch: all -> 0x0178, TRY_LEAVE, TryCatch #5 {all -> 0x0178, blocks: (B:74:0x0174, B:65:0x017c), top: B:73:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean k(android.content.Context r17, java.lang.String r18, kotlin.jvm.functions.Function2 r19, kotlin.jvm.functions.Function1 r20) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.y.k(android.content.Context, java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String path, Uri uri) {
        Intrinsics.h(path, "path");
        Intrinsics.h(uri, "uri");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("saveVideoToAlbum: ");
        sb2.append(path);
        sb2.append(" ");
        sb2.append(uri);
    }

    private final boolean n(Context context, String str, String str2, String str3, Function2 function2, Function1 function1) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String Q = StringsKt.Q(str, str2, str3, false, 4, null);
            a.C0856a.f(lg.a.f68962a, "resource_save", "saveVideoToSDCardAfterQ targetPath = " + Q + ", beforeRootPath = " + str2 + ", targetRootPath = " + str3, false, 4, null);
            try {
                String b11 = b(Q);
                String f12 = StringsKt.f1(b11, "/", null, 2, null);
                if (function1 != null) {
                    function1.invoke(b11);
                }
                File file = new File(str);
                ContentValues g11 = g(context, file, f12, System.currentTimeMillis());
                List f11 = f(context);
                if (f11 == null || !(!f11.isEmpty())) {
                    return false;
                }
                Uri insert = contentResolver.insert((Uri) f11.get(0), g11);
                Intrinsics.e(contentResolver);
                c(context, contentResolver, file, insert, function2);
                g11.clear();
                g11.put("is_pending", (Integer) 0);
                ContentResolver contentResolver2 = context.getContentResolver();
                Intrinsics.e(insert);
                contentResolver2.update(insert, g11, null, null);
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", insert));
                return true;
            } catch (Throwable th2) {
                th = th2;
                lg.a.f68962a.i("resource_save", "saveVideoToSDCardAfterQ error = " + th, true);
                th.printStackTrace();
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0164 A[Catch: all -> 0x0160, TRY_LEAVE, TryCatch #0 {all -> 0x0160, blocks: (B:51:0x015c, B:43:0x0164), top: B:50:0x015c }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean o(android.content.Context r18, java.lang.String r19, java.lang.String r20, kotlin.jvm.functions.Function2 r21, kotlin.jvm.functions.Function1 r22) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.y.o(android.content.Context, java.lang.String, java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1):boolean");
    }

    public final boolean d(Context context, String oldPath) {
        Intrinsics.h(context, "context");
        Intrinsics.h(oldPath, "oldPath");
        try {
            ContentResolver contentResolver = context.getContentResolver();
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "resource_save", "deleteAlbumAfterQ oldPath = " + oldPath + "， where = _data=?", false, 4, null);
            int delete = contentResolver.delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[]{oldPath});
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deleteAlbumAfterQ row = ");
            sb2.append(delete);
            c0856a.c("resource_save", sb2.toString(), true);
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public final boolean e(Context context, String oldPath) {
        Intrinsics.h(context, "context");
        Intrinsics.h(oldPath, "oldPath");
        try {
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "resource_save", "deleteSDCardAfterQ oldPath = " + oldPath, false, 4, null);
            ContentResolver contentResolver = context.getContentResolver();
            List f11 = f(context);
            if (f11 != null && (!f11.isEmpty())) {
                c0856a.c("resource_save", "deleteSDCardAfterQ row = " + contentResolver.delete((Uri) f11.get(0), "_data=?", new String[]{oldPath}), true);
                return true;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return false;
    }

    public final ContentValues g(Context context, File paramFile, String newName, long j11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(paramFile, "paramFile");
        Intrinsics.h(newName, "newName");
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", lj.b.f68989a.f());
        }
        if (newName.length() == 0) {
            newName = paramFile.getName();
        }
        contentValues.put(CampaignEx.JSON_KEY_TITLE, newName);
        contentValues.put("_display_name", newName);
        contentValues.put("mime_type", MimeTypes.VIDEO_MP4);
        contentValues.put("datetaken", Long.valueOf(j11));
        contentValues.put("date_modified", Long.valueOf(j11));
        contentValues.put("date_added", Long.valueOf(j11));
        contentValues.put("_size", Long.valueOf(paramFile.length()));
        return contentValues;
    }

    public final ContentValues h(Context context, File paramFile, String newName, long j11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(paramFile, "paramFile");
        Intrinsics.h(newName, "newName");
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM + File.separator + context.getResources().getString(com.transsion.baseui.R$string.base_app_name));
        }
        if (newName.length() == 0) {
            newName = paramFile.getName();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getVideoContentValues title = ");
        sb2.append(newName);
        contentValues.put(CampaignEx.JSON_KEY_TITLE, newName);
        contentValues.put("_display_name", newName);
        contentValues.put("mime_type", MimeTypes.VIDEO_MP4);
        contentValues.put("datetaken", Long.valueOf(j11));
        contentValues.put("date_modified", Long.valueOf(j11));
        contentValues.put("date_added", Long.valueOf(j11));
        contentValues.put("_size", Long.valueOf(paramFile.length()));
        return contentValues;
    }

    public final boolean i(Context context, String videoFile, String beforeRootPath, Function2 callback, Function1 function1) {
        Intrinsics.h(context, "context");
        Intrinsics.h(videoFile, "videoFile");
        Intrinsics.h(beforeRootPath, "beforeRootPath");
        Intrinsics.h(callback, "callback");
        lg.a.f68962a.c("resource_save", "saveVideoToAlbum() videoFile = [" + videoFile + "]", true);
        return Build.VERSION.SDK_INT < 29 ? k(context, videoFile, callback, function1) : j(context, videoFile, beforeRootPath, callback, function1);
    }

    public final boolean m(Context context, String videoFile, String beforeRootPath, String targetRootPath, Function2 callback, Function1 function1) {
        Intrinsics.h(context, "context");
        Intrinsics.h(videoFile, "videoFile");
        Intrinsics.h(beforeRootPath, "beforeRootPath");
        Intrinsics.h(targetRootPath, "targetRootPath");
        Intrinsics.h(callback, "callback");
        lg.a.f68962a.c("resource_save", "saveVideoToSDCard() videoFile = [" + videoFile + "]", true);
        return Build.VERSION.SDK_INT < 29 ? o(context, videoFile, targetRootPath, callback, function1) : n(context, videoFile, beforeRootPath, targetRootPath, callback, function1);
    }
}
