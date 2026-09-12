package com.transsion.home.preload;

import android.app.Activity;
import android.view.View;
import androidx.view.Lifecycle;
import androidx.view.e;
import androidx.view.f;
import androidx.view.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes.dex */
public final class MainXMLPreloadControlImp implements b, f {

    /* renamed from: a, reason: collision with root package name */
    private View f45587a;

    /* renamed from: b, reason: collision with root package name */
    private View f45588b;

    /* renamed from: c, reason: collision with root package name */
    private View f45589c;

    /* renamed from: d, reason: collision with root package name */
    private View f45590d;

    /* renamed from: e, reason: collision with root package name */
    private View f45591e;

    /* renamed from: f, reason: collision with root package name */
    private View f45592f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f45593g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f45594h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f45595i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f45596j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f45597k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f45598l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f45599m;

    /* renamed from: n, reason: collision with root package name */
    private final n0 f45600n;

    /* renamed from: o, reason: collision with root package name */
    private final u f45601o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.home.preload.MainXMLPreloadControlImp$1", f = "MainXMLPreloadControlImp.kt", l = {71, 78, 85}, m = "invokeSuspend")
    /* renamed from: com.transsion.home.preload.MainXMLPreloadControlImp$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$activity, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0117  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 325
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.preload.MainXMLPreloadControlImp.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MainXMLPreloadControlImp(Activity activity) {
        Lifecycle lifecycle;
        Intrinsics.h(activity, "activity");
        n0 a11 = o0.a(l2.b(null, 1, null).plus(y0.a()));
        this.f45600n = a11;
        u uVar = activity instanceof u ? (u) activity : null;
        this.f45601o = uVar;
        if (uVar != null && (lifecycle = uVar.getLifecycle()) != null) {
            lifecycle.a(this);
        }
        k.d(a11, null, null, new AnonymousClass1(activity, null), 3, null);
    }

    @Override // com.transsion.home.preload.b
    public boolean a() {
        return this.f45599m;
    }

    @Override // com.transsion.home.preload.b
    public boolean b() {
        return this.f45596j;
    }

    @Override // com.transsion.home.preload.b
    public View c() {
        this.f45599m = true;
        return this.f45592f;
    }

    @Override // com.transsion.home.preload.b
    public View d() {
        this.f45596j = true;
        return this.f45591e;
    }

    @Override // com.transsion.home.preload.b
    public boolean e() {
        return this.f45593g;
    }

    @Override // com.transsion.home.preload.b
    public View f() {
        this.f45593g = true;
        return this.f45587a;
    }

    @Override // androidx.view.f
    public /* synthetic */ void onCreate(u uVar) {
        e.a(this, uVar);
    }

    @Override // androidx.view.f
    public void onDestroy(u owner) {
        Intrinsics.h(owner, "owner");
        e.b(this, owner);
        owner.getLifecycle().d(this);
        reset();
    }

    @Override // androidx.view.f
    public /* synthetic */ void onPause(u uVar) {
        e.c(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onResume(u uVar) {
        e.d(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onStart(u uVar) {
        e.e(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onStop(u uVar) {
        e.f(this, uVar);
    }

    @Override // com.transsion.home.preload.b
    public void reset() {
        o0.d(this.f45600n, null, 1, null);
        this.f45587a = null;
        this.f45590d = null;
        this.f45591e = null;
        this.f45588b = null;
        this.f45589c = null;
        this.f45592f = null;
        this.f45593g = false;
        this.f45597k = false;
        this.f45598l = false;
        this.f45594h = false;
        this.f45595i = false;
        this.f45596j = false;
        this.f45599m = false;
    }
}
