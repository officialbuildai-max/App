package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.view.Lifecycle;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f923a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.core.util.a f924b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque f925c;

    /* renamed from: d, reason: collision with root package name */
    private u f926d;

    /* renamed from: e, reason: collision with root package name */
    private OnBackInvokedCallback f927e;

    /* renamed from: f, reason: collision with root package name */
    private OnBackInvokedDispatcher f928f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f929g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f930h;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f931a = new a();

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function0 function0) {
            function0.invoke();
        }

        public final OnBackInvokedCallback b(final Function0 onBackInvoked) {
            Intrinsics.h(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.v
                public final void onBackInvoked() {
                    OnBackPressedDispatcher.a.c(Function0.this);
                }
            };
        }

        public final void d(Object dispatcher, int i11, Object callback) {
            Intrinsics.h(dispatcher, "dispatcher");
            Intrinsics.h(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i11, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            Intrinsics.h(dispatcher, "dispatcher");
            Intrinsics.h(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f932a = new b();

        /* loaded from: classes.dex */
        public static final class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function1 f933a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function1 f934b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Function0 f935c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function0 f936d;

            a(Function1 function1, Function1 function12, Function0 function0, Function0 function02) {
                this.f933a = function1;
                this.f934b = function12;
                this.f935c = function0;
                this.f936d = function02;
            }

            public void onBackCancelled() {
                this.f936d.invoke();
            }

            public void onBackInvoked() {
                this.f935c.invoke();
            }

            public void onBackProgressed(BackEvent backEvent) {
                Intrinsics.h(backEvent, "backEvent");
                this.f934b.invoke(new androidx.activity.b(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                Intrinsics.h(backEvent, "backEvent");
                this.f933a.invoke(new androidx.activity.b(backEvent));
            }
        }

        private b() {
        }

        public final OnBackInvokedCallback a(Function1 onBackStarted, Function1 onBackProgressed, Function0 onBackInvoked, Function0 onBackCancelled) {
            Intrinsics.h(onBackStarted, "onBackStarted");
            Intrinsics.h(onBackProgressed, "onBackProgressed");
            Intrinsics.h(onBackInvoked, "onBackInvoked");
            Intrinsics.h(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    /* loaded from: classes.dex */
    private final class c implements androidx.view.r, androidx.activity.c {

        /* renamed from: a, reason: collision with root package name */
        private final Lifecycle f937a;

        /* renamed from: b, reason: collision with root package name */
        private final u f938b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.activity.c f939c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f940d;

        public c(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, u onBackPressedCallback) {
            Intrinsics.h(lifecycle, "lifecycle");
            Intrinsics.h(onBackPressedCallback, "onBackPressedCallback");
            this.f940d = onBackPressedDispatcher;
            this.f937a = lifecycle;
            this.f938b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f937a.d(this);
            this.f938b.removeCancellable(this);
            androidx.activity.c cVar = this.f939c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f939c = null;
        }

        @Override // androidx.view.r
        public void onStateChanged(androidx.view.u source, Lifecycle.Event event) {
            Intrinsics.h(source, "source");
            Intrinsics.h(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f939c = this.f940d.j(this.f938b);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f939c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class d implements androidx.activity.c {

        /* renamed from: a, reason: collision with root package name */
        private final u f941a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f942b;

        public d(OnBackPressedDispatcher onBackPressedDispatcher, u onBackPressedCallback) {
            Intrinsics.h(onBackPressedCallback, "onBackPressedCallback");
            this.f942b = onBackPressedDispatcher;
            this.f941a = onBackPressedCallback;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f942b.f925c.remove(this.f941a);
            if (Intrinsics.c(this.f942b.f926d, this.f941a)) {
                this.f941a.handleOnBackCancelled();
                this.f942b.f926d = null;
            }
            this.f941a.removeCancellable(this);
            Function0<Unit> enabledChangedCallback$activity_release = this.f941a.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.f941a.setEnabledChangedCallback$activity_release(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable, androidx.core.util.a aVar) {
        this.f923a = runnable;
        this.f924b = aVar;
        this.f925c = new ArrayDeque();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            this.f927e = i11 >= 34 ? b.f932a.a(new Function1<androidx.activity.b, Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((androidx.activity.b) obj);
                    return Unit.f67184a;
                }

                public final void invoke(androidx.activity.b backEvent) {
                    Intrinsics.h(backEvent, "backEvent");
                    OnBackPressedDispatcher.this.n(backEvent);
                }
            }, new Function1<androidx.activity.b, Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((androidx.activity.b) obj);
                    return Unit.f67184a;
                }

                public final void invoke(androidx.activity.b backEvent) {
                    Intrinsics.h(backEvent, "backEvent");
                    OnBackPressedDispatcher.this.m(backEvent);
                }
            }, new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1invoke() {
                    OnBackPressedDispatcher.this.l();
                }
            }, new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.4
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2invoke() {
                    OnBackPressedDispatcher.this.k();
                }
            }) : a.f931a.b(new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m3invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m3invoke() {
                    OnBackPressedDispatcher.this.l();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void k() {
        u uVar;
        u uVar2 = this.f926d;
        if (uVar2 == null) {
            ArrayDeque arrayDeque = this.f925c;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    uVar = 0;
                    break;
                } else {
                    uVar = listIterator.previous();
                    if (((u) uVar).isEnabled()) {
                        break;
                    }
                }
            }
            uVar2 = uVar;
        }
        this.f926d = null;
        if (uVar2 != null) {
            uVar2.handleOnBackCancelled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    public final void m(androidx.activity.b bVar) {
        u uVar;
        u uVar2 = this.f926d;
        if (uVar2 == null) {
            ArrayDeque arrayDeque = this.f925c;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    uVar = 0;
                    break;
                } else {
                    uVar = listIterator.previous();
                    if (((u) uVar).isEnabled()) {
                        break;
                    }
                }
            }
            uVar2 = uVar;
        }
        if (uVar2 != null) {
            uVar2.handleOnBackProgressed(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(androidx.activity.b bVar) {
        Object obj;
        ArrayDeque arrayDeque = this.f925c;
        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            } else {
                obj = listIterator.previous();
                if (((u) obj).isEnabled()) {
                    break;
                }
            }
        }
        u uVar = (u) obj;
        if (this.f926d != null) {
            k();
        }
        this.f926d = uVar;
        if (uVar != null) {
            uVar.handleOnBackStarted(bVar);
        }
    }

    private final void p(boolean z10) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f928f;
        OnBackInvokedCallback onBackInvokedCallback = this.f927e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z10 && !this.f929g) {
            a.f931a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f929g = true;
        } else {
            if (z10 || !this.f929g) {
                return;
            }
            a.f931a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f929g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        boolean z10 = this.f930h;
        ArrayDeque arrayDeque = this.f925c;
        boolean z11 = false;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<E> it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((u) it.next()).isEnabled()) {
                    z11 = true;
                    break;
                }
            }
        }
        this.f930h = z11;
        if (z11 != z10) {
            androidx.core.util.a aVar = this.f924b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z11));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                p(z11);
            }
        }
    }

    public final void h(u onBackPressedCallback) {
        Intrinsics.h(onBackPressedCallback, "onBackPressedCallback");
        j(onBackPressedCallback);
    }

    public final void i(androidx.view.u owner, u onBackPressedCallback) {
        Intrinsics.h(owner, "owner");
        Intrinsics.h(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new c(this, lifecycle, onBackPressedCallback));
        q();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCallback$1(this));
    }

    public final androidx.activity.c j(u onBackPressedCallback) {
        Intrinsics.h(onBackPressedCallback, "onBackPressedCallback");
        this.f925c.add(onBackPressedCallback);
        d dVar = new d(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(dVar);
        q();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void l() {
        u uVar;
        u uVar2 = this.f926d;
        if (uVar2 == null) {
            ArrayDeque arrayDeque = this.f925c;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    uVar = 0;
                    break;
                } else {
                    uVar = listIterator.previous();
                    if (((u) uVar).isEnabled()) {
                        break;
                    }
                }
            }
            uVar2 = uVar;
        }
        this.f926d = null;
        if (uVar2 != null) {
            uVar2.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f923a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void o(OnBackInvokedDispatcher invoker) {
        Intrinsics.h(invoker, "invoker");
        this.f928f = invoker;
        p(this.f930h);
    }
}
