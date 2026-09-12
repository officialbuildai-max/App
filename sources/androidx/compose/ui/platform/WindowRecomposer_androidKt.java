package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.R$id;
import androidx.view.Lifecycle;
import androidx.view.ViewTreeLifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.g1;

/* loaded from: classes.dex */
public abstract class WindowRecomposer_androidKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f5786a = new LinkedHashMap();

    /* loaded from: classes.dex */
    public static final class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5787a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Recomposer f5788b;

        a(View view, Recomposer recomposer) {
            this.f5787a = view;
            this.f5788b = recomposer;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f5787a.removeOnAttachStateChangeListener(this);
            this.f5788b.Y();
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.d f5789a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlinx.coroutines.channels.d dVar, Handler handler) {
            super(handler);
            this.f5789a = dVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            this.f5789a.c(Unit.f67184a);
        }
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [T, androidx.compose.ui.platform.e1] */
    public static final Recomposer b(final View view, CoroutineContext coroutineContext, Lifecycle lifecycle) {
        final PausableMonotonicFrameClock pausableMonotonicFrameClock;
        if (coroutineContext.get(ContinuationInterceptor.INSTANCE) == null || coroutineContext.get(androidx.compose.runtime.u0.Z0) == null) {
            coroutineContext = AndroidUiDispatcher.f5662k.a().plus(coroutineContext);
        }
        androidx.compose.runtime.u0 u0Var = (androidx.compose.runtime.u0) coroutineContext.get(androidx.compose.runtime.u0.Z0);
        if (u0Var != null) {
            PausableMonotonicFrameClock pausableMonotonicFrameClock2 = new PausableMonotonicFrameClock(u0Var);
            pausableMonotonicFrameClock2.a();
            pausableMonotonicFrameClock = pausableMonotonicFrameClock2;
        } else {
            pausableMonotonicFrameClock = null;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        androidx.compose.ui.j jVar = (androidx.compose.ui.j) coroutineContext.get(androidx.compose.ui.j.f5167a1);
        androidx.compose.ui.j jVar2 = jVar;
        if (jVar == null) {
            ?? e1Var = new e1();
            objectRef.element = e1Var;
            jVar2 = e1Var;
        }
        CoroutineContext plus = coroutineContext.plus(pausableMonotonicFrameClock != null ? pausableMonotonicFrameClock : EmptyCoroutineContext.INSTANCE).plus(jVar2);
        final Recomposer recomposer = new Recomposer(plus);
        recomposer.l0();
        final kotlinx.coroutines.n0 a11 = kotlinx.coroutines.o0.a(plus);
        if (lifecycle == null) {
            androidx.view.u a12 = ViewTreeLifecycleOwner.a(view);
            lifecycle = a12 != null ? a12.getLifecycle() : null;
        }
        if (lifecycle != null) {
            view.addOnAttachStateChangeListener(new a(view, recomposer));
            lifecycle.a(new androidx.view.r() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2

                /* loaded from: classes.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f5795a;

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
                            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
                        } catch (NoSuchFieldError unused5) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
                        } catch (NoSuchFieldError unused6) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
                        } catch (NoSuchFieldError unused7) {
                        }
                        f5795a = iArr;
                    }
                }

                @Override // androidx.view.r
                public void onStateChanged(androidx.view.u uVar, Lifecycle.Event event) {
                    int i11 = a.f5795a[event.ordinal()];
                    if (i11 == 1) {
                        kotlinx.coroutines.k.d(kotlinx.coroutines.n0.this, null, CoroutineStart.UNDISPATCHED, new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(objectRef, recomposer, uVar, this, view, null), 1, null);
                        return;
                    }
                    if (i11 == 2) {
                        PausableMonotonicFrameClock pausableMonotonicFrameClock3 = pausableMonotonicFrameClock;
                        if (pausableMonotonicFrameClock3 != null) {
                            pausableMonotonicFrameClock3.c();
                        }
                        recomposer.y0();
                        return;
                    }
                    if (i11 == 3) {
                        recomposer.l0();
                    } else {
                        if (i11 != 4) {
                            return;
                        }
                        recomposer.Y();
                    }
                }
            });
            return recomposer;
        }
        g0.a.c("ViewTreeLifecycleOwner not found from " + view);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Recomposer c(View view, CoroutineContext coroutineContext, Lifecycle lifecycle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            lifecycle = null;
        }
        return b(view, coroutineContext, lifecycle);
    }

    public static final androidx.compose.runtime.m d(View view) {
        androidx.compose.runtime.m f11 = f(view);
        if (f11 != null) {
            return f11;
        }
        for (ViewParent parent = view.getParent(); f11 == null && (parent instanceof View); parent = parent.getParent()) {
            f11 = f((View) parent);
        }
        return f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlinx.coroutines.flow.i1 e(Context context) {
        kotlinx.coroutines.flow.i1 i1Var;
        Map map = f5786a;
        synchronized (map) {
            try {
                Object obj = map.get(context);
                if (obj == null) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                    kotlinx.coroutines.channels.d b11 = kotlinx.coroutines.channels.g.b(-1, null, null, 6, null);
                    obj = kotlinx.coroutines.flow.d.F(kotlinx.coroutines.flow.d.s(new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(contentResolver, uriFor, new b(b11, androidx.core.os.h.a(Looper.getMainLooper())), b11, context, null)), kotlinx.coroutines.o0.b(), g1.a.b(kotlinx.coroutines.flow.g1.f67906a, 0L, 0L, 3, null), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                    map.put(context, obj);
                }
                i1Var = (kotlinx.coroutines.flow.i1) obj;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i1Var;
    }

    public static final androidx.compose.runtime.m f(View view) {
        Object tag = view.getTag(R$id.androidx_compose_ui_view_composition_context);
        if (tag instanceof androidx.compose.runtime.m) {
            return (androidx.compose.runtime.m) tag;
        }
        return null;
    }

    private static final View g(View view) {
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getId() == 16908290) {
                return view;
            }
            parent = view2.getParent();
            view = view2;
        }
        return view;
    }

    public static final Recomposer h(View view) {
        if (!view.isAttachedToWindow()) {
            g0.a.b("Cannot locate windowRecomposer; View " + view + " is not attached to a window");
        }
        View g11 = g(view);
        androidx.compose.runtime.m f11 = f(g11);
        if (f11 == null) {
            return WindowRecomposerPolicy.f5782a.a(g11);
        }
        if (f11 instanceof Recomposer) {
            return (Recomposer) f11;
        }
        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer");
    }

    public static final void i(View view, androidx.compose.runtime.m mVar) {
        view.setTag(R$id.androidx_compose_ui_view_composition_context, mVar);
    }
}
