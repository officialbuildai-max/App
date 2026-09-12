package ye;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.core.app.t;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f79116a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f79117b = LazyKt.b(new Function0() { // from class: ye.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV g11;
            g11 = c.g();
            return g11;
        }
    });

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV g() {
        MMKV I = MMKV.I("kv_permission_x");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final boolean b(Context context) {
        Intrinsics.h(context, "context");
        return t.d(context).a();
    }

    public final boolean c(Context context) {
        Intrinsics.h(context, "context");
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Object systemService = context.getSystemService("appops");
        AppOpsManager appOpsManager = systemService instanceof AppOpsManager ? (AppOpsManager) systemService : null;
        Integer valueOf = appOpsManager != null ? Integer.valueOf(appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), context.getPackageName())) : null;
        return valueOf != null && valueOf.intValue() == 0;
    }

    public final MMKV d() {
        return (MMKV) f79117b.getValue();
    }

    public final a e(FragmentActivity activity) {
        Intrinsics.h(activity, "activity");
        return new a(activity);
    }

    public final boolean f(Context context, String permission) {
        Intrinsics.h(context, "context");
        Intrinsics.h(permission, "permission");
        return androidx.core.content.b.checkSelfPermission(context, permission) == 0;
    }
}
