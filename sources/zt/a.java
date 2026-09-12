package zt;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f79580a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final C1008a f79581b;

    /* renamed from: c, reason: collision with root package name */
    private static final wu.g f79582c;

    /* renamed from: zt.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1008a implements ou.b {
        C1008a() {
        }

        @Override // ou.b
        public void a(String eventName, Map fields) {
            Intrinsics.h(eventName, "eventName");
            Intrinsics.h(fields, "fields");
            hj.i.f64628a.x(eventName, fields, 2337);
        }
    }

    static {
        C1008a c1008a = new C1008a();
        f79581b = c1008a;
        f79582c = new wu.g(c1008a);
    }

    private a() {
    }

    public final wu.g a() {
        return f79582c;
    }
}
