package androidx.compose.ui.platform;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class GlobalSnapshotManager {

    /* renamed from: a, reason: collision with root package name */
    public static final GlobalSnapshotManager f5714a = new GlobalSnapshotManager();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f5715b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f5716c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public static final int f5717d = 8;

    private GlobalSnapshotManager() {
    }

    public final void b() {
        if (f5715b.compareAndSet(false, true)) {
            final kotlinx.coroutines.channels.d b11 = kotlinx.coroutines.channels.g.b(1, null, null, 6, null);
            kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(AndroidUiDispatcher.f5662k.b()), null, null, new GlobalSnapshotManager$ensureStarted$1(b11, null), 3, null);
            androidx.compose.runtime.snapshots.j.f4079e.k(new Function1<Object, Unit>() { // from class: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m161invoke(obj);
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m161invoke(Object obj) {
                    AtomicBoolean atomicBoolean;
                    atomicBoolean = GlobalSnapshotManager.f5716c;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        kotlinx.coroutines.channels.d.this.c(Unit.f67184a);
                    }
                }
            });
        }
    }
}
