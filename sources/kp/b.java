package kp;

import com.blankj.utilcode.util.o;
import com.transsion.publish.api.bean.RequestPostEntity;
import io.reactivex.rxjava3.core.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import zg.c;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f68491a = LazyKt.b(new Function0() { // from class: kp.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            lp.a g11;
            g11 = b.g();
            return g11;
        }
    });

    private final String b() {
        return vg.a.f77447a.a();
    }

    private final RequestBody c(String str) {
        return RequestBody.INSTANCE.create(str, MediaType.INSTANCE.parse("application/json"));
    }

    private final lp.a d() {
        return (lp.a) this.f68491a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lp.a g() {
        return (lp.a) c.f79537e.a().h(lp.a.class);
    }

    public final j e(RequestPostEntity entity) {
        Intrinsics.h(entity, "entity");
        String j11 = o.j(entity);
        Intrinsics.g(j11, "toJson(...)");
        return d().b(b(), c(j11));
    }

    public final j f(RequestPostEntity entity) {
        Intrinsics.h(entity, "entity");
        String j11 = o.j(entity);
        Intrinsics.g(j11, "toJson(...)");
        return d().c(b(), c(j11));
    }
}
