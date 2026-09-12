package qq;

import com.tencent.mmkv.MMKV;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f73795a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f73796b = LazyKt.b(new Function0() { // from class: qq.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV e11;
            e11 = c.e();
            return e11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static List f73797c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return c.f73797c;
        }

        public final MMKV b() {
            return (MMKV) c.f73796b.getValue();
        }

        public final void c(List list) {
            c.f73797c = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV e() {
        MMKV I = MMKV.I("search_mmKv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }
}
