package androidx.view;

import androidx.view.v0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import p1.a;

/* loaded from: classes.dex */
public final class ViewModelLazy implements Lazy {

    /* renamed from: a, reason: collision with root package name */
    private final KClass f9650a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f9651b;

    /* renamed from: c, reason: collision with root package name */
    private final Function0 f9652c;

    /* renamed from: d, reason: collision with root package name */
    private final Function0 f9653d;

    /* renamed from: e, reason: collision with root package name */
    private t0 f9654e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(KClass viewModelClass, Function0 storeProducer, Function0 factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        Intrinsics.h(viewModelClass, "viewModelClass");
        Intrinsics.h(storeProducer, "storeProducer");
        Intrinsics.h(factoryProducer, "factoryProducer");
    }

    public ViewModelLazy(KClass viewModelClass, Function0 storeProducer, Function0 factoryProducer, Function0 extrasProducer) {
        Intrinsics.h(viewModelClass, "viewModelClass");
        Intrinsics.h(storeProducer, "storeProducer");
        Intrinsics.h(factoryProducer, "factoryProducer");
        Intrinsics.h(extrasProducer, "extrasProducer");
        this.f9650a = viewModelClass;
        this.f9651b = storeProducer;
        this.f9652c = factoryProducer;
        this.f9653d = extrasProducer;
    }

    public /* synthetic */ ViewModelLazy(KClass kClass, Function0 function0, Function0 function02, Function0 function03, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, function0, function02, (i11 & 8) != 0 ? new Function0<a.C0908a>() { // from class: androidx.lifecycle.ViewModelLazy.1
            @Override // kotlin.jvm.functions.Function0
            public final a.C0908a invoke() {
                return a.C0908a.f72393b;
            }
        } : function03);
    }

    @Override // kotlin.Lazy
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public t0 getValue() {
        t0 t0Var = this.f9654e;
        if (t0Var != null) {
            return t0Var;
        }
        t0 c11 = v0.f9731b.a((x0) this.f9651b.invoke(), (v0.c) this.f9652c.invoke(), (a) this.f9653d.invoke()).c(this.f9650a);
        this.f9654e = c11;
        return c11;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.f9654e != null;
    }
}
