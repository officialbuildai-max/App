package mh;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0867a f69688a = new C0867a(null);

    /* renamed from: mh.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0867a {
        private C0867a() {
        }

        public /* synthetic */ C0867a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MMKV a() {
            MMKV J = MMKV.J("vshow", 2);
            Intrinsics.g(J, "mmkvWithID(...)");
            return J;
        }
    }
}
