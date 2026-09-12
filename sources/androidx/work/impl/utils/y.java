package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: classes2.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16082a = androidx.work.t.i("PackageManagerHelper");

    private static int a(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str));
    }

    private static boolean b(int i11, boolean z10) {
        return i11 == 0 ? z10 : i11 == 1;
    }

    public static void c(Context context, Class cls, boolean z10) {
        try {
            if (z10 == b(a(context, cls.getName()), false)) {
                androidx.work.t.e().a(f16082a, "Skipping component enablement for " + cls.getName());
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z10 ? 1 : 2, 1);
            androidx.work.t e11 = androidx.work.t.e();
            String str = f16082a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append(" ");
            sb2.append(z10 ? "enabled" : "disabled");
            e11.a(str, sb2.toString());
        } catch (Exception e12) {
            androidx.work.t e13 = androidx.work.t.e();
            String str2 = f16082a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cls.getName());
            sb3.append("could not be ");
            sb3.append(z10 ? "enabled" : "disabled");
            e13.b(str2, sb3.toString(), e12);
        }
    }
}
