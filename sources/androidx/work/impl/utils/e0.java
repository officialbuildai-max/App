package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ListenableFutureKt;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.j0;
import androidx.work.impl.model.k0;
import androidx.work.impl.model.s1;
import java.util.UUID;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public class e0 implements androidx.work.j {

    /* renamed from: d, reason: collision with root package name */
    private static final String f16038d = androidx.work.t.i("WMFgUpdater");

    /* renamed from: a, reason: collision with root package name */
    private final j4.c f16039a;

    /* renamed from: b, reason: collision with root package name */
    final androidx.work.impl.foreground.a f16040b;

    /* renamed from: c, reason: collision with root package name */
    final k0 f16041c;

    public e0(WorkDatabase workDatabase, androidx.work.impl.foreground.a aVar, j4.c cVar) {
        this.f16040b = aVar;
        this.f16039a = cVar;
        this.f16041c = workDatabase.l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void c(UUID uuid, androidx.work.i iVar, Context context) {
        String uuid2 = uuid.toString();
        j0 j11 = this.f16041c.j(uuid2);
        if (j11 == null || j11.f15847b.isFinished()) {
            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
        }
        this.f16040b.a(uuid2, iVar);
        context.startService(SystemForegroundDispatcher.d(context, s1.a(j11), iVar));
        return null;
    }

    @Override // androidx.work.j
    public com.google.common.util.concurrent.r a(final Context context, final UUID uuid, final androidx.work.i iVar) {
        return ListenableFutureKt.f(this.f16039a.c(), "setForegroundAsync", new Function0() { // from class: androidx.work.impl.utils.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Void c11;
                c11 = e0.this.c(uuid, iVar, context);
                return c11;
            }
        });
    }
}
