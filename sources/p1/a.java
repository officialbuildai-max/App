package p1;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map f72392a = new LinkedHashMap();

    /* renamed from: p1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0908a extends a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0908a f72393b = new C0908a();

        private C0908a() {
        }

        @Override // p1.a
        public Object a(b key) {
            Intrinsics.h(key, "key");
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f72392a;
    }
}
