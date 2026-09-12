package androidx.work.impl;

import a4.e;
import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.v1;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/work/impl/WorkDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Landroidx/work/impl/model/k0;", "l0", "()Landroidx/work/impl/model/k0;", "Landroidx/work/impl/model/b;", "g0", "()Landroidx/work/impl/model/b;", "Landroidx/work/impl/model/v1;", "m0", "()Landroidx/work/impl/model/v1;", "Landroidx/work/impl/model/q;", "i0", "()Landroidx/work/impl/model/q;", "Landroidx/work/impl/model/z;", "j0", "()Landroidx/work/impl/model/z;", "Landroidx/work/impl/model/e0;", "k0", "()Landroidx/work/impl/model/e0;", "Landroidx/work/impl/model/i;", "h0", "()Landroidx/work/impl/model/i;", TtmlNode.TAG_P, "a", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: androidx.work.impl.WorkDatabase$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final a4.e c(Context context, e.b configuration) {
            Intrinsics.h(configuration, "configuration");
            e.b.a a11 = e.b.f230f.a(context);
            a11.d(configuration.f232b).c(configuration.f233c).e(true).a(true);
            return new b4.h().a(a11.b());
        }

        public final WorkDatabase b(final Context context, Executor queryExecutor, androidx.work.a clock, boolean z10) {
            Intrinsics.h(context, "context");
            Intrinsics.h(queryExecutor, "queryExecutor");
            Intrinsics.h(clock, "clock");
            return (WorkDatabase) (z10 ? androidx.room.q.b(context, WorkDatabase.class).c() : androidx.room.q.a(context, WorkDatabase.class, "androidx.work.workdb").h(new e.c() { // from class: androidx.work.impl.f0
                @Override // a4.e.c
                public final a4.e a(e.b bVar) {
                    a4.e c11;
                    c11 = WorkDatabase.Companion.c(context, bVar);
                    return c11;
                }
            })).i(queryExecutor).a(new c(clock)).b(j.f15776c).b(new t(context, 2, 3)).b(k.f15780c).b(l.f15782c).b(new t(context, 5, 6)).b(m.f15790c).b(n.f15972c).b(o.f15974c).b(new h1(context)).b(new t(context, 10, 11)).b(f.f15731c).b(g.f15765c).b(h.f15767c).b(i.f15770c).b(new t(context, 21, 22)).f(true).d();
        }
    }

    public abstract androidx.work.impl.model.b g0();

    public abstract androidx.work.impl.model.i h0();

    public abstract androidx.work.impl.model.q i0();

    public abstract androidx.work.impl.model.z j0();

    public abstract androidx.work.impl.model.e0 k0();

    public abstract androidx.work.impl.model.k0 l0();

    public abstract v1 m0();
}
