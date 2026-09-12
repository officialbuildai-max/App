package sm;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f75526a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f75527b = LazyKt.b(new Function0() { // from class: sm.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV i11;
            i11 = d.i();
            return i11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f75528c = LazyKt.b(new Function0() { // from class: sm.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV h11;
            h11 = d.h();
            return h11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f75529d = LazyKt.b(new Function0() { // from class: sm.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV d11;
            d11 = d.d();
            return d11;
        }
    });

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        MMKV I = MMKV.I("kv_bucket_config");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV h() {
        MMKV I = MMKV.I("kv_local_config");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV i() {
        MMKV I = MMKV.I("kv_app_config");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV e() {
        return (MMKV) f75529d.getValue();
    }

    public final MMKV f() {
        return (MMKV) f75528c.getValue();
    }

    public final MMKV g() {
        return (MMKV) f75527b.getValue();
    }
}
