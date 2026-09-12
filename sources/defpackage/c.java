package defpackage;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f17040a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f17041b = LazyKt.b(new Function0() { // from class: b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c11;
            c11 = c.c();
            return c11;
        }
    });

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        return MMKV.I("palm_pay_kv");
    }

    public final MMKV b() {
        return (MMKV) f17041b.getValue();
    }
}
