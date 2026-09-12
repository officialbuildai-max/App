package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f1008a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f1009b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f1010c;

    /* renamed from: d, reason: collision with root package name */
    private int f1011d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1012e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1013f;

    /* renamed from: g, reason: collision with root package name */
    private final List f1014g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f1015h;

    public s(Executor executor, Function0 reportFullyDrawn) {
        Intrinsics.h(executor, "executor");
        Intrinsics.h(reportFullyDrawn, "reportFullyDrawn");
        this.f1008a = executor;
        this.f1009b = reportFullyDrawn;
        this.f1010c = new Object();
        this.f1014g = new ArrayList();
        this.f1015h = new Runnable() { // from class: androidx.activity.r
            @Override // java.lang.Runnable
            public final void run() {
                s.d(s.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(s sVar) {
        synchronized (sVar.f1010c) {
            try {
                sVar.f1012e = false;
                if (sVar.f1011d == 0 && !sVar.f1013f) {
                    sVar.f1009b.invoke();
                    sVar.b();
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b() {
        synchronized (this.f1010c) {
            try {
                this.f1013f = true;
                Iterator it = this.f1014g.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f1014g.clear();
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean c() {
        boolean z10;
        synchronized (this.f1010c) {
            z10 = this.f1013f;
        }
        return z10;
    }
}
