package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class AndroidUiDispatcher extends kotlinx.coroutines.i0 {

    /* renamed from: k, reason: collision with root package name */
    public static final b f5662k = new b(null);

    /* renamed from: l, reason: collision with root package name */
    public static final int f5663l = 8;

    /* renamed from: m, reason: collision with root package name */
    private static final Lazy f5664m = LazyKt.b(new Function0<CoroutineContext>() { // from class: androidx.compose.ui.platform.AndroidUiDispatcher$Companion$Main$2
        @Override // kotlin.jvm.functions.Function0
        public final CoroutineContext invoke() {
            boolean b11;
            b11 = j0.b();
            AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(b11 ? Choreographer.getInstance() : (Choreographer) kotlinx.coroutines.i.e(kotlinx.coroutines.y0.c(), new AndroidUiDispatcher$Companion$Main$2$dispatcher$1(null)), androidx.core.os.h.a(Looper.getMainLooper()), null);
            return androidUiDispatcher.plus(androidUiDispatcher.T());
        }
    });

    /* renamed from: n, reason: collision with root package name */
    private static final ThreadLocal f5665n = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Choreographer f5666a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f5667b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f5668c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayDeque f5669d;

    /* renamed from: e, reason: collision with root package name */
    private List f5670e;

    /* renamed from: f, reason: collision with root package name */
    private List f5671f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5672g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5673h;

    /* renamed from: i, reason: collision with root package name */
    private final AndroidUiDispatcher$dispatchCallback$1 f5674i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.compose.runtime.u0 f5675j;

    /* loaded from: classes.dex */
    public static final class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoroutineContext initialValue() {
            Choreographer choreographer = Choreographer.getInstance();
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                throw new IllegalStateException("no Looper on this thread");
            }
            AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, androidx.core.os.h.a(myLooper), null);
            return androidUiDispatcher.plus(androidUiDispatcher.T());
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CoroutineContext a() {
            boolean b11;
            b11 = j0.b();
            if (b11) {
                return b();
            }
            CoroutineContext coroutineContext = (CoroutineContext) AndroidUiDispatcher.f5665n.get();
            if (coroutineContext != null) {
                return coroutineContext;
            }
            throw new IllegalStateException("no AndroidUiDispatcher for this thread");
        }

        public final CoroutineContext b() {
            return (CoroutineContext) AndroidUiDispatcher.f5664m.getValue();
        }
    }

    private AndroidUiDispatcher(Choreographer choreographer, Handler handler) {
        this.f5666a = choreographer;
        this.f5667b = handler;
        this.f5668c = new Object();
        this.f5669d = new ArrayDeque();
        this.f5670e = new ArrayList();
        this.f5671f = new ArrayList();
        this.f5674i = new AndroidUiDispatcher$dispatchCallback$1(this);
        this.f5675j = new AndroidUiFrameClock(choreographer, this);
    }

    public /* synthetic */ AndroidUiDispatcher(Choreographer choreographer, Handler handler, DefaultConstructorMarker defaultConstructorMarker) {
        this(choreographer, handler);
    }

    private final Runnable U() {
        Runnable runnable;
        synchronized (this.f5668c) {
            runnable = (Runnable) this.f5669d.p();
        }
        return runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(long j11) {
        synchronized (this.f5668c) {
            if (this.f5673h) {
                this.f5673h = false;
                List list = this.f5670e;
                this.f5670e = this.f5671f;
                this.f5671f = list;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((Choreographer.FrameCallback) list.get(i11)).doFrame(j11);
                }
                list.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        boolean z10;
        do {
            Runnable U = U();
            while (U != null) {
                U.run();
                U = U();
            }
            synchronized (this.f5668c) {
                if (this.f5669d.isEmpty()) {
                    z10 = false;
                    this.f5672g = false;
                } else {
                    z10 = true;
                }
            }
        } while (z10);
    }

    public final androidx.compose.runtime.u0 T() {
        return this.f5675j;
    }

    public final void a0(Choreographer.FrameCallback frameCallback) {
        synchronized (this.f5668c) {
            try {
                this.f5670e.add(frameCallback);
                if (!this.f5673h) {
                    this.f5673h = true;
                    this.f5666a.postFrameCallback(this.f5674i);
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c0(Choreographer.FrameCallback frameCallback) {
        synchronized (this.f5668c) {
            this.f5670e.remove(frameCallback);
        }
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        synchronized (this.f5668c) {
            try {
                this.f5669d.addLast(runnable);
                if (!this.f5672g) {
                    this.f5672g = true;
                    this.f5667b.post(this.f5674i);
                    if (!this.f5673h) {
                        this.f5673h = true;
                        this.f5666a.postFrameCallback(this.f5674i);
                    }
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Choreographer x() {
        return this.f5666a;
    }
}
