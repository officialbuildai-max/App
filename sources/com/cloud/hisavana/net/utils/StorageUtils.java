package com.cloud.hisavana.net.utils;

import android.content.Context;
import android.os.Environment;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.e;
import java.io.File;

/* loaded from: classes.dex */
public final class StorageUtils {

    /* renamed from: a, reason: collision with root package name */
    private static volatile File f21511a;

    private StorageUtils() {
    }

    public static File a(Context context) {
        return b(context, true);
    }

    public static File b(Context context, boolean z10) {
        File file;
        if (z10) {
            file = e(context);
            if (file != null && file.exists()) {
                File file2 = new File(file.getPath() + File.separator + "hisavana_net_cache");
                if (!file2.exists() && !file2.mkdir()) {
                    c.Log().w("StorageUtils", "can't create cache file");
                }
                file = file2;
            }
        } else {
            file = null;
        }
        if ((file == null || (!file.exists() && !file.mkdirs())) && ((file = e.b(context.getApplicationContext())) == null || !file.exists())) {
            file = context.getFilesDir();
        }
        if (file == null || !file.exists()) {
            file = context.getCacheDir();
        }
        if (file != null) {
            return file;
        }
        String str = "/data/data/" + context.getPackageName() + File.separator + "hisavana_net_cache";
        c.Log().w("StorageUtils", "Can't define system cache directory! '%s' will be used." + str);
        return new File(str);
    }

    public static File c(Context context, boolean z10) {
        File file;
        if (z10) {
            file = e(context);
            if (file != null) {
                File file2 = new File(file.getPath() + File.separator + "hisavana_default_cache");
                if (!file2.exists() && !file2.mkdir()) {
                    c.Log().e("StorageUtils", "getOfflineCacheDirectory,storage cache is not ready");
                }
                file = file2;
            }
        } else {
            file = null;
        }
        if (file == null) {
            file = new File("/data/data/" + context.getPackageName() + File.separator + "hisavana_default_cache");
            if (!file.exists() && !file.mkdir()) {
                c.Log().e("StorageUtils", "getOfflineCacheDirectory,app cache path is not ready");
            }
        }
        return file;
    }

    public static File d(Context context, boolean z10) {
        File file;
        if (z10) {
            file = e(context);
            if (file != null) {
                File file2 = new File(file.getPath() + File.separator + "hisavana_video_cache");
                if (!file2.exists() && !file2.mkdir()) {
                    c.Log().e("StorageUtils", "getExoCacheDirectory,storage cache is not ready");
                }
                file = file2;
            }
        } else {
            file = null;
        }
        if (file == null) {
            file = new File("/data/data/" + context.getPackageName() + File.separator + "hisavana_video_cache");
            if (!file.exists() && !file.mkdir()) {
                c.Log().e("StorageUtils", "getExoCacheDirectory,app cache path is not ready");
            }
        }
        return file;
    }

    public static File e(Context context) {
        String str = "";
        if (f21511a != null) {
            return f21511a;
        }
        File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/" + context.getPackageName() + "/files");
        if (file.exists()) {
            f21511a = file;
        } else if (file.mkdir()) {
            f21511a = file;
        } else {
            c.Log().w("StorageUtils", "getExternalFileDir is not exists");
        }
        if (f21511a == null) {
            try {
                str = Environment.getExternalStorageState();
            } catch (IncompatibleClassChangeError | NullPointerException unused) {
            }
            if ("mounted".equals(str)) {
                f21511a = context.getExternalFilesDir(null);
            }
        }
        return f21511a;
    }

    public static File f(Context context, boolean z10) {
        File file;
        if (z10) {
            file = e(context);
            if (file != null) {
                File file2 = new File(file.getPath() + File.separator + "hisavana_normal_video_cache");
                if (!file2.exists() && !file2.mkdir()) {
                    c.Log().e("StorageUtils", "getVideoCacheDirectory,storage cache is not ready");
                }
                file = file2;
            }
        } else {
            file = null;
        }
        if (file == null) {
            file = new File("/data/data/" + context.getPackageName() + File.separator + "hisavana_normal_video_cache");
            if (!file.exists() && !file.mkdir()) {
                c.Log().e("StorageUtils", "getVideoCacheDirectory,app cache path is not ready");
            }
        }
        return file;
    }
}
