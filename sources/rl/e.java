package rl;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f74676a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f74677b = LazyKt.b(new Function0() { // from class: rl.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c11;
            c11 = e.c();
            return c11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public static final int f74678c = 8;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("home_mmkv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV b() {
        return (MMKV) f74677b.getValue();
    }
}
