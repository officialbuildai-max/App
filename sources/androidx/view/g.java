package androidx.view;

import androidx.view.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class g implements r {

    /* renamed from: a, reason: collision with root package name */
    private final f f9671a;

    /* renamed from: b, reason: collision with root package name */
    private final r f9672b;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9673a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f9673a = iArr;
        }
    }

    public g(f defaultLifecycleObserver, r rVar) {
        Intrinsics.h(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f9671a = defaultLifecycleObserver;
        this.f9672b = rVar;
    }

    @Override // androidx.view.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        switch (a.f9673a[event.ordinal()]) {
            case 1:
                this.f9671a.onCreate(source);
                break;
            case 2:
                this.f9671a.onStart(source);
                break;
            case 3:
                this.f9671a.onResume(source);
                break;
            case 4:
                this.f9671a.onPause(source);
                break;
            case 5:
                this.f9671a.onStop(source);
                break;
            case 6:
                this.f9671a.onDestroy(source);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        r rVar = this.f9672b;
        if (rVar != null) {
            rVar.onStateChanged(source, event);
        }
    }
}
