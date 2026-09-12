package w6;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f77720a = 10;

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f77721b = new AtomicInteger(0);

    public final boolean a() {
        return this.f77721b.get() >= this.f77720a;
    }

    public final void b() {
        this.f77721b.set(0);
    }

    public final void c(Function0 downCallBack) {
        Intrinsics.h(downCallBack, "downCallBack");
        if (this.f77721b.incrementAndGet() >= this.f77720a) {
            downCallBack.invoke();
        }
    }
}
