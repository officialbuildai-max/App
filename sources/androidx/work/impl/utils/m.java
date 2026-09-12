package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final WorkDatabase f16074a;

    public m(WorkDatabase workDatabase) {
        Intrinsics.h(workDatabase, "workDatabase");
        this.f16074a = workDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer c(m mVar, int i11, int i12) {
        int d11;
        d11 = n.d(mVar.f16074a, "next_job_scheduler_id");
        if (i11 > d11 || d11 > i12) {
            n.e(mVar.f16074a, "next_job_scheduler_id", i11 + 1);
        } else {
            i11 = d11;
        }
        return Integer.valueOf(i11);
    }

    public final int b(final int i11, final int i12) {
        Object Y = this.f16074a.Y(new Callable() { // from class: androidx.work.impl.utils.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer c11;
                c11 = m.c(m.this, i11, i12);
                return c11;
            }
        });
        Intrinsics.g(Y, "runInTransaction(...)");
        return ((Number) Y).intValue();
    }
}
