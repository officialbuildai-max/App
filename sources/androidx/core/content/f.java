package androidx.core.content;

import android.content.Context;
import android.os.Process;

/* loaded from: classes.dex */
public abstract class f {
    public static int a(Context context, String str, int i11, int i12, String str2) {
        if (context.checkPermission(str, i11, i12) == -1) {
            return -1;
        }
        String c11 = androidx.core.app.e.c(str);
        if (c11 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i12);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return ((Process.myUid() != i12 || !androidx.core.util.d.a(context.getPackageName(), str2)) ? androidx.core.app.e.b(context, c11, str2) : androidx.core.app.e.a(context, i12, c11, str2)) == 0 ? 0 : -2;
    }

    public static int b(Context context, String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
