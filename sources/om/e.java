package om;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f71160a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f71161b = LazyKt.b(new Function0() { // from class: om.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            e.a();
            return null;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f71162c = LazyKt.b(new Function0() { // from class: om.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV e11;
            e11 = e.e();
            return e11;
        }
    });

    private e() {
    }

    public static /* synthetic */ a a() {
        c();
        return null;
    }

    private static final a c() {
        android.support.v4.media.session.c.a(zg.c.f79537e.a().h(a.class));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV e() {
        return MMKV.I("mb_web_res");
    }

    public final void d() {
        b.f71159a.b();
    }
}
