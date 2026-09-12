package cm;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class i {
    public static File a(Context context) {
        return b(context, true);
    }

    public static File b(Context context, boolean z10) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
            str = "";
        }
        File c11 = (z10 && "mounted".equals(str) && d(context)) ? c(context) : null;
        if ((c11 == null || (!c11.exists() && !c11.mkdirs())) && ((c11 = com.transsion.core.utils.b.a(context.getApplicationContext())) == null || !c11.exists())) {
            c11 = context.getFilesDir();
        }
        if (c11 == null || !c11.exists()) {
            c11 = context.getCacheDir();
        }
        if (c11 != null) {
            return c11;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        Log.w("error", "Can't define system cache directory! '%s' will be used." + str2);
        return new File(str2);
    }

    private static File c(Context context) {
        File file = new File(new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "files"), "images");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.w("error", "Unable to create external cache directory");
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
            }
        }
        return file;
    }

    private static boolean d(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
