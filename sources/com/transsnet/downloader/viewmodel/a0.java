package com.transsnet.downloader.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsnet.downloader.R$string;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.mvel2.ast.ASTNode;

/* loaded from: classes7.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f60208a = new a0();

    /* renamed from: b, reason: collision with root package name */
    private static final ContentResolver f60209b = Utils.a().getContentResolver();

    private a0() {
    }

    private final boolean b(File file) {
        boolean z10 = true;
        if (file == null || file.exists()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            return b(parentFile);
        }
        if (!file.mkdirs() && !file.exists()) {
            z10 = false;
        }
        if (!z10) {
            Log.e("FileUtil", "createFileDir fail " + file);
        }
        return z10;
    }

    private final void c(File file) {
        b(file);
        if (file.exists() && file.isDirectory()) {
            file.delete();
        }
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                return;
            }
            t("create file failure --> file.path = " + file.getAbsolutePath());
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    private final File g(Context context) {
        File filesDir = Utils.a().getFilesDir();
        if (filesDir == null) {
            return null;
        }
        File file = new File(filesDir, "outside");
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    private final File h(String str) {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        File g11 = g(a11);
        File file = new File(i(g11 != null ? g11.getAbsolutePath() : null, str));
        c(file);
        return file;
    }

    private final String i(String str, String str2) {
        return str + File.separator + str2 + ".jpg";
    }

    private final String[] l() {
        return Build.VERSION.SDK_INT < 33 ? new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"} : new String[]{"android.permission.READ_MEDIA_VIDEO"};
    }

    private final boolean q(long j11, String str) {
        Date date = new Date(j11);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        String format = simpleDateFormat.format(date);
        Intrinsics.g(format, "format(...)");
        String format2 = simpleDateFormat.format(new Date());
        Intrinsics.g(format2, "format(...)");
        return Intrinsics.c(format, format2);
    }

    private final boolean r(long j11) {
        return q(j11, "yyyy-MM-dd");
    }

    private final boolean s(long j11) {
        Date k11 = com.blankj.utilcode.util.c0.k(com.blankj.utilcode.util.c0.h(j11));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(simpleDateFormat.format(date));
        if (parse == null) {
            return false;
        }
        long time = parse.getTime() - k11.getTime();
        return 1 <= time && time < 86400000;
    }

    private final String v(String str) {
        int hashCode = str.hashCode();
        switch (hashCode) {
            case 1537:
                return !str.equals("01") ? str : "Jan";
            case 1538:
                return !str.equals("02") ? str : "Feb";
            case 1539:
                return !str.equals("03") ? str : "Mar";
            case 1540:
                return !str.equals("04") ? str : "Apr";
            case 1541:
                return !str.equals("05") ? str : "May";
            case 1542:
                return !str.equals("06") ? str : "Jun";
            case 1543:
                return !str.equals("07") ? str : "Jul";
            case 1544:
                return !str.equals("08") ? str : "Aug";
            case 1545:
                return !str.equals("09") ? str : "Sept";
            default:
                switch (hashCode) {
                    case 1567:
                        return !str.equals("10") ? str : "Oct";
                    case 1568:
                        return !str.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY) ? str : "Nov";
                    case 1569:
                        return !str.equals("12") ? str : "Dec";
                    default:
                        return str;
                }
        }
    }

    public final boolean a() {
        return (Build.VERSION.SDK_INT < 33 ? androidx.core.content.f.b(Utils.a(), "android.permission.WRITE_EXTERNAL_STORAGE") : androidx.core.content.b.checkSelfPermission(Utils.a(), "android.permission.READ_MEDIA_VIDEO")) == 0;
    }

    public final Bitmap d(String path) {
        Intrinsics.h(path, "path");
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return BitmapFactory.decodeFile(path);
    }

    public final long e(String filePath) {
        Intrinsics.h(filePath, "filePath");
        return com.blankj.utilcode.util.c0.a(new Date(new File(filePath).lastModified()));
    }

    public final long f(String path) {
        Intrinsics.h(path, "path");
        return new File(path).length();
    }

    public final String j(j0 video) {
        Intrinsics.h(video, "video");
        try {
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            File g11 = g(a11);
            String absolutePath = g11 != null ? g11.getAbsolutePath() : null;
            String e11 = video.e();
            if (e11 == null) {
                e11 = "";
            }
            File file = new File(i(absolutePath, k(e11)));
            if (file.exists() && file.isFile()) {
                String absolutePath2 = file.getAbsolutePath();
                Intrinsics.g(absolutePath2, "getAbsolutePath(...)");
                return absolutePath2;
            }
        } catch (Exception e12) {
            t("getLocalVideoCover e = " + Log.getStackTraceString(e12));
        }
        return "";
    }

    public final String k(String filePath) {
        Intrinsics.h(filePath, "filePath");
        if (TextUtils.isEmpty(filePath)) {
            return "";
        }
        String name = new File(filePath).getName();
        Intrinsics.g(name, "getName(...)");
        return name;
    }

    public final Bitmap m(j0 video) {
        Intrinsics.h(video, "video");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(f60209b, video.c(), 1, options);
        u("getVideoThumbnail --- name = " + video.d() + " ----  bitmap = " + thumbnail);
        return thumbnail;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bc, code lost:
    
        if (r1 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List n() {
        /*
            r15 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.ContentResolver r2 = com.transsnet.downloader.viewmodel.a0.f60209b     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            android.net.Uri r3 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r7 = "title"
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
        L13:
            kotlin.jvm.internal.Intrinsics.e(r1)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            if (r2 == 0) goto L9d
            java.lang.String r2 = "_data"
            int r2 = r1.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            boolean r2 = r15.o(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            if (r2 != 0) goto L2d
            goto L13
        L2d:
            java.lang.String r2 = "_id"
            int r2 = r1.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            int r4 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r2 = "_display_name"
            int r2 = r1.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r6 = r1.getString(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r2 = "resolution"
            int r2 = r1.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r7 = r1.getString(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r2 = "_size"
            int r2 = r1.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            long r2 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r8 = "duration"
            int r8 = r1.getColumnIndexOrThrow(r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            long r8 = r1.getLong(r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r10 = "date_modified"
            int r10 = r1.getColumnIndexOrThrow(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            long r10 = r1.getLong(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r12 = "width"
            int r12 = r1.getColumnIndexOrThrow(r12)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            int r12 = r1.getInt(r12)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r13 = "height"
            int r13 = r1.getColumnIndexOrThrow(r13)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            com.transsnet.downloader.viewmodel.j0 r14 = new com.transsnet.downloader.viewmodel.j0     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.Long r11 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r3 = r14
            r8 = r2
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r0.add(r14)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            goto L13
        L99:
            r0 = move-exception
            goto Lc0
        L9b:
            r2 = move-exception
            goto La1
        L9d:
            r1.close()
            goto Lbf
        La1:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = android.util.Log.getStackTraceString(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r3.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = "出问题了 --- "
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            r3.append(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L99
            r15.u(r2)     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto Lbf
            goto L9d
        Lbf:
            return r0
        Lc0:
            if (r1 == 0) goto Lc5
            r1.close()
        Lc5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.a0.n():java.util.List");
    }

    public final boolean o(String str) {
        if (str != null) {
            return new File(str).exists();
        }
        return false;
    }

    public final boolean p(Activity activity) {
        Intrinsics.h(activity, "activity");
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        if (bVar.b().getBoolean("download_local_permission_first", true)) {
            bVar.b().putBoolean("download_local_permission_first", false);
            return false;
        }
        boolean z10 = false;
        for (String str : l()) {
            if (!ActivityCompat.j(activity, str)) {
                z10 = true;
            }
        }
        return z10;
    }

    public final void t(String msg) {
        Intrinsics.h(msg, "msg");
    }

    public final void u(String msg) {
        Intrinsics.h(msg, "msg");
        Log.e("zxb_log_historical", msg);
    }

    public final String w(String str, Bitmap bm2) {
        String absolutePath;
        Intrinsics.h(bm2, "bm");
        String str2 = "";
        File h11 = h(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(h11);
            bm2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            absolutePath = h11.getAbsolutePath();
            Intrinsics.g(absolutePath, "getAbsolutePath(...)");
        } catch (IOException e11) {
            e = e11;
        }
        try {
            t("the picture is save to your phone! --- coverPath = " + absolutePath);
            return absolutePath;
        } catch (IOException e12) {
            e = e12;
            str2 = absolutePath;
            e.printStackTrace();
            t("保存图片出现了异常 --- ex = " + Log.getStackTraceString(e));
            return str2;
        }
    }

    public final void x() {
        try {
            Intent intent = new Intent(Utils.a().getPackageName());
            intent.setFlags(ASTNode.DEOP);
            intent.setComponent(new ComponentName("com.google.android.permissioncontroller", "com.android.permissioncontroller.permission.ui.ManagePermissionsActivity"));
            Utils.a().startActivity(intent);
        } catch (Exception e11) {
            u("跳转应用权限设置界面失败 e = " + Log.getStackTraceString(e11));
            y();
        }
    }

    public final void y() {
        Intent intent = new Intent();
        intent.addFlags(ASTNode.DEOP);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", Utils.a().getPackageName(), null));
        Utils.a().startActivity(intent);
    }

    public final String z(long j11) {
        if (r(j11)) {
            String string = Utils.a().getString(R$string.download_today);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (s(j11)) {
            String string2 = Utils.a().getString(R$string.download_yesterday);
            Intrinsics.g(string2, "getString(...)");
            return string2;
        }
        String k11 = TimeUtilKt.k(j11);
        if (k11.length() != 5) {
            return k11;
        }
        List S0 = StringsKt.S0(k11, new String[]{"-"}, false, 0, 6, null);
        return v((String) S0.get(0)) + "." + S0.get(1);
    }
}
