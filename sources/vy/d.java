package vy;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f77603a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f77604b = LazyKt.b(new Function0() { // from class: vy.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c11;
            c11 = d.c();
            return c11;
        }
    });

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV J = MMKV.J("kv_login", 2);
        Intrinsics.g(J, "mmkvWithID(...)");
        return J;
    }

    public final MMKV b() {
        return (MMKV) f77604b.getValue();
    }
}
