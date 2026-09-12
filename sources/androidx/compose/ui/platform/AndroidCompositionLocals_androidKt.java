package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.i;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.view.InterfaceC1015e;
import androidx.view.compose.LocalLifecycleOwnerKt;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public abstract class AndroidCompositionLocals_androidKt {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.compose.runtime.s1 f5644a = CompositionLocalKt.d(null, new Function0<Configuration>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalConfiguration$1
        @Override // kotlin.jvm.functions.Function0
        public final Configuration invoke() {
            AndroidCompositionLocals_androidKt.k("LocalConfiguration");
            throw new KotlinNothingValueException();
        }
    }, 1, null);

    /* renamed from: b, reason: collision with root package name */
    private static final androidx.compose.runtime.s1 f5645b = CompositionLocalKt.f(new Function0<Context>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalContext$1
        @Override // kotlin.jvm.functions.Function0
        public final Context invoke() {
            AndroidCompositionLocals_androidKt.k("LocalContext");
            throw new KotlinNothingValueException();
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final androidx.compose.runtime.s1 f5646c = CompositionLocalKt.f(new Function0<i0.d>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalImageVectorCache$1
        @Override // kotlin.jvm.functions.Function0
        public final i0.d invoke() {
            AndroidCompositionLocals_androidKt.k("LocalImageVectorCache");
            throw new KotlinNothingValueException();
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final androidx.compose.runtime.s1 f5647d = CompositionLocalKt.f(new Function0<i0.f>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalResourceIdCache$1
        @Override // kotlin.jvm.functions.Function0
        public final i0.f invoke() {
            AndroidCompositionLocals_androidKt.k("LocalResourceIdCache");
            throw new KotlinNothingValueException();
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final androidx.compose.runtime.s1 f5648e = CompositionLocalKt.f(new Function0<InterfaceC1015e>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalSavedStateRegistryOwner$1
        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC1015e invoke() {
            AndroidCompositionLocals_androidKt.k("LocalSavedStateRegistryOwner");
            throw new KotlinNothingValueException();
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static final androidx.compose.runtime.s1 f5649f = CompositionLocalKt.f(new Function0<View>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalView$1
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            AndroidCompositionLocals_androidKt.k("LocalView");
            throw new KotlinNothingValueException();
        }
    });

    /* loaded from: classes.dex */
    public static final class a implements ComponentCallbacks2 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Configuration f5651a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i0.d f5652b;

        a(Configuration configuration, i0.d dVar) {
            this.f5651a = configuration;
            this.f5652b = dVar;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            this.f5652b.c(this.f5651a.updateFrom(configuration));
            this.f5651a.setTo(configuration);
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            this.f5652b.a();
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i11) {
            this.f5652b.a();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements ComponentCallbacks2 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i0.f f5653a;

        b(i0.f fVar) {
            this.f5653a = fVar;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            this.f5653a.a();
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            this.f5653a.a();
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i11) {
            this.f5653a.a();
        }
    }

    public static final void a(final AndroidComposeView androidComposeView, final Function2 function2, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i g11 = iVar.g(1396852028);
        if ((i11 & 6) == 0) {
            i12 = (g11.A(androidComposeView) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= g11.A(function2) ? 32 : 16;
        }
        if ((i12 & 19) == 18 && g11.h()) {
            g11.G();
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(1396852028, i12, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals (AndroidCompositionLocals.android.kt:91)");
            }
            Context context = androidComposeView.getContext();
            Object y10 = g11.y();
            i.a aVar = androidx.compose.runtime.i.f3811a;
            if (y10 == aVar.a()) {
                y10 = androidx.compose.runtime.u2.c(new Configuration(context.getResources().getConfiguration()), null, 2, null);
                g11.p(y10);
            }
            final androidx.compose.runtime.i1 i1Var = (androidx.compose.runtime.i1) y10;
            Object y11 = g11.y();
            if (y11 == aVar.a()) {
                y11 = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Configuration) obj);
                        return Unit.f67184a;
                    }

                    public final void invoke(Configuration configuration) {
                        AndroidCompositionLocals_androidKt.c(androidx.compose.runtime.i1.this, new Configuration(configuration));
                    }
                };
                g11.p(y11);
            }
            androidComposeView.setConfigurationChangeObserver((Function1) y11);
            Object y12 = g11.y();
            if (y12 == aVar.a()) {
                y12 = new k0(context);
                g11.p(y12);
            }
            final k0 k0Var = (k0) y12;
            AndroidComposeView.b viewTreeOwners = androidComposeView.getViewTreeOwners();
            if (viewTreeOwners == null) {
                throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
            }
            Object y13 = g11.y();
            if (y13 == aVar.a()) {
                y13 = DisposableSaveableStateRegistry_androidKt.b(androidComposeView, viewTreeOwners.b());
                g11.p(y13);
            }
            final u0 u0Var = (u0) y13;
            Unit unit = Unit.f67184a;
            boolean A = g11.A(u0Var);
            Object y14 = g11.y();
            if (A || y14 == aVar.a()) {
                y14 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2$1

                    /* loaded from: classes.dex */
                    public static final class a implements androidx.compose.runtime.c0 {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ u0 f5650a;

                        public a(u0 u0Var) {
                            this.f5650a = u0Var;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f5650a.c();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                        return new a(u0.this);
                    }
                };
                g11.p(y14);
            }
            androidx.compose.runtime.g0.a(unit, (Function1) y14, g11, 6);
            CompositionLocalKt.b(new androidx.compose.runtime.t1[]{f5644a.d(b(i1Var)), f5645b.d(context), LocalLifecycleOwnerKt.a().d(viewTreeOwners.a()), f5648e.d(viewTreeOwners.b()), SaveableStateRegistryKt.d().d(u0Var), f5649f.d(androidComposeView.getView()), f5646c.d(l(context, b(i1Var), g11, 0)), f5647d.d(m(context, g11, 0)), CompositionLocalsKt.h().d(Boolean.valueOf(((Boolean) g11.l(CompositionLocalsKt.i())).booleanValue() | androidComposeView.getScrollCaptureInProgress$ui_release()))}, androidx.compose.runtime.internal.b.d(1471621628, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i13) {
                    if ((i13 & 3) == 2 && iVar2.h()) {
                        iVar2.G();
                        return;
                    }
                    if (androidx.compose.runtime.k.H()) {
                        androidx.compose.runtime.k.Q(1471621628, i13, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals.<anonymous> (AndroidCompositionLocals.android.kt:131)");
                    }
                    CompositionLocalsKt.a(AndroidComposeView.this, k0Var, function2, iVar2, 0);
                    if (androidx.compose.runtime.k.H()) {
                        androidx.compose.runtime.k.P();
                    }
                }
            }, g11, 54), g11, androidx.compose.runtime.t1.f4116i | 48);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        androidx.compose.runtime.g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i13) {
                    AndroidCompositionLocals_androidKt.a(AndroidComposeView.this, function2, iVar2, androidx.compose.runtime.v1.a(i11 | 1));
                }
            });
        }
    }

    private static final Configuration b(androidx.compose.runtime.i1 i1Var) {
        return (Configuration) i1Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(androidx.compose.runtime.i1 i1Var, Configuration configuration) {
        i1Var.setValue(configuration);
    }

    public static final androidx.compose.runtime.s1 f() {
        return f5644a;
    }

    public static final androidx.compose.runtime.s1 g() {
        return f5645b;
    }

    public static final androidx.compose.runtime.s1 h() {
        return f5646c;
    }

    public static final androidx.compose.runtime.s1 i() {
        return f5647d;
    }

    public static final androidx.compose.runtime.s1 j() {
        return f5649f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void k(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }

    private static final i0.d l(final Context context, Configuration configuration, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-485908294, i11, -1, "androidx.compose.ui.platform.obtainImageVectorCache (AndroidCompositionLocals.android.kt:172)");
        }
        Object y10 = iVar.y();
        i.a aVar = androidx.compose.runtime.i.f3811a;
        if (y10 == aVar.a()) {
            y10 = new i0.d();
            iVar.p(y10);
        }
        i0.d dVar = (i0.d) y10;
        Object y11 = iVar.y();
        Object obj = y11;
        if (y11 == aVar.a()) {
            Configuration configuration2 = new Configuration();
            if (configuration != null) {
                configuration2.setTo(configuration);
            }
            iVar.p(configuration2);
            obj = configuration2;
        }
        Configuration configuration3 = (Configuration) obj;
        Object y12 = iVar.y();
        if (y12 == aVar.a()) {
            y12 = new a(configuration3, dVar);
            iVar.p(y12);
        }
        final a aVar2 = (a) y12;
        boolean A = iVar.A(context);
        Object y13 = iVar.y();
        if (A || y13 == aVar.a()) {
            y13 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$1

                /* loaded from: classes.dex */
                public static final class a implements androidx.compose.runtime.c0 {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Context f5654a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ AndroidCompositionLocals_androidKt.a f5655b;

                    public a(Context context, AndroidCompositionLocals_androidKt.a aVar) {
                        this.f5654a = context;
                        this.f5655b = aVar;
                    }

                    @Override // androidx.compose.runtime.c0
                    public void dispose() {
                        this.f5654a.getApplicationContext().unregisterComponentCallbacks(this.f5655b);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                    context.getApplicationContext().registerComponentCallbacks(aVar2);
                    return new a(context, aVar2);
                }
            };
            iVar.p(y13);
        }
        androidx.compose.runtime.g0.a(dVar, (Function1) y13, iVar, 0);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return dVar;
    }

    private static final i0.f m(final Context context, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-1348507246, i11, -1, "androidx.compose.ui.platform.obtainResourceIdCache (AndroidCompositionLocals.android.kt:141)");
        }
        Object y10 = iVar.y();
        i.a aVar = androidx.compose.runtime.i.f3811a;
        if (y10 == aVar.a()) {
            y10 = new i0.f();
            iVar.p(y10);
        }
        i0.f fVar = (i0.f) y10;
        Object y11 = iVar.y();
        if (y11 == aVar.a()) {
            y11 = new b(fVar);
            iVar.p(y11);
        }
        final b bVar = (b) y11;
        boolean A = iVar.A(context);
        Object y12 = iVar.y();
        if (A || y12 == aVar.a()) {
            y12 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainResourceIdCache$1$1

                /* loaded from: classes.dex */
                public static final class a implements androidx.compose.runtime.c0 {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Context f5656a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ AndroidCompositionLocals_androidKt.b f5657b;

                    public a(Context context, AndroidCompositionLocals_androidKt.b bVar) {
                        this.f5656a = context;
                        this.f5657b = bVar;
                    }

                    @Override // androidx.compose.runtime.c0
                    public void dispose() {
                        this.f5656a.getApplicationContext().unregisterComponentCallbacks(this.f5657b);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                    context.getApplicationContext().registerComponentCallbacks(bVar);
                    return new a(context, bVar);
                }
            };
            iVar.p(y12);
        }
        androidx.compose.runtime.g0.a(fVar, (Function1) y12, iVar, 0);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return fVar;
    }
}
