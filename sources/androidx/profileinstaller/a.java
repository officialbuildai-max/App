package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* loaded from: classes2.dex */
abstract class a {

    /* renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0118a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        static Context a(Context context) {
            Context createDeviceProtectedStorageContext;
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            return createDeviceProtectedStorageContext;
        }
    }

    static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z10 = true;
        for (File file2 : listFiles) {
            z10 = a(file2) && z10;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, ProfileInstallReceiver.a aVar) {
        int i11 = Build.VERSION.SDK_INT;
        if (a(i11 >= 34 ? b.a(context).getCacheDir() : i11 >= 24 ? C0118a.a(b.a(context)) : i11 == 23 ? C0118a.a(context) : context.getCacheDir())) {
            aVar.a(14, null);
        } else {
            aVar.a(15, null);
        }
    }
}
