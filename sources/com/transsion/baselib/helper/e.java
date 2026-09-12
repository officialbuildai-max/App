package com.transsion.baselib.helper;

import android.content.Context;
import android.os.Build;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f43321a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f43322b;

    static {
        f43322b = Build.VERSION.SDK_INT < 33 ? new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"} : new String[]{"android.permission.READ_MEDIA_VIDEO"};
    }

    private e() {
    }

    public final String[] a() {
        return f43322b;
    }

    public final boolean b(Context context, String[] strArr) {
        if (context == null || strArr == null) {
            return false;
        }
        Iterator a11 = ArrayIteratorKt.a(strArr);
        while (a11.hasNext()) {
            if (androidx.core.content.b.checkSelfPermission(context, (String) a11.next()) != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean c(Context context) {
        return b(context, f43322b);
    }
}
