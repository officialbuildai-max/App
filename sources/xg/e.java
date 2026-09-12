package xg;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import okhttp3.Interceptor;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f78426a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayList f78427b = new ArrayList();

    private e() {
    }

    public final void a(Interceptor interceptor) {
        Intrinsics.h(interceptor, "interceptor");
        ArrayList arrayList = f78427b;
        if (!arrayList.contains(interceptor)) {
            arrayList.add(interceptor);
            return;
        }
        a.C0856a.z(lg.a.f68962a, "InterceptorsManager", "add dump interceptor " + interceptor, false, 4, null);
    }

    public final ArrayList b() {
        return f78427b;
    }
}
