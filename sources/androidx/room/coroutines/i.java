package androidx.room.coroutines;

import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements z3.b, kotlinx.coroutines.sync.a {

    /* renamed from: a, reason: collision with root package name */
    private final z3.b f14729a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.sync.a f14730b;

    /* renamed from: c, reason: collision with root package name */
    private CoroutineContext f14731c;

    /* renamed from: d, reason: collision with root package name */
    private Throwable f14732d;

    public i(z3.b delegate, kotlinx.coroutines.sync.a lock) {
        Intrinsics.h(delegate, "delegate");
        Intrinsics.h(lock, "lock");
        this.f14729a = delegate;
        this.f14730b = lock;
    }

    public /* synthetic */ i(z3.b bVar, kotlinx.coroutines.sync.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i11 & 2) != 0 ? kotlinx.coroutines.sync.g.b(false, 1, null) : aVar);
    }

    @Override // z3.b
    public z3.e D0(String sql) {
        Intrinsics.h(sql, "sql");
        return this.f14729a.D0(sql);
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean b(Object obj) {
        return this.f14730b.b(obj);
    }

    @Override // z3.b, java.lang.AutoCloseable
    public void close() {
        this.f14729a.close();
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean d() {
        return this.f14730b.d();
    }

    @Override // kotlinx.coroutines.sync.a
    public Object h(Object obj, Continuation continuation) {
        return this.f14730b.h(obj, continuation);
    }

    public final void i(StringBuilder builder) {
        Intrinsics.h(builder, "builder");
        if (this.f14731c == null && this.f14732d == null) {
            builder.append("\t\tStatus: Free connection");
            builder.append('\n');
            return;
        }
        builder.append("\t\tStatus: Acquired connection");
        builder.append('\n');
        CoroutineContext coroutineContext = this.f14731c;
        if (coroutineContext != null) {
            builder.append("\t\tCoroutine: " + coroutineContext);
            builder.append('\n');
        }
        Throwable th2 = this.f14732d;
        if (th2 != null) {
            builder.append("\t\tAcquired:");
            builder.append('\n');
            Iterator it = CollectionsKt.d0(StringsKt.y0(ExceptionsKt.b(th2)), 1).iterator();
            while (it.hasNext()) {
                builder.append("\t\t" + ((String) it.next()));
                builder.append('\n');
            }
        }
    }

    public final i k(CoroutineContext context) {
        Intrinsics.h(context, "context");
        this.f14731c = context;
        this.f14732d = new Throwable();
        return this;
    }

    public final i l() {
        this.f14731c = null;
        this.f14732d = null;
        return this;
    }

    public String toString() {
        return this.f14729a.toString();
    }

    @Override // kotlinx.coroutines.sync.a
    public void unlock(Object obj) {
        this.f14730b.unlock(obj);
    }
}
