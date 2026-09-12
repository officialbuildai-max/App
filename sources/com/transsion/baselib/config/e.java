package com.transsion.baselib.config;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yc.j;
import yc.n;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final a f43073c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f43074d = LazyKt.b(new Function0() { // from class: com.transsion.baselib.config.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            e h11;
            h11 = e.h();
            return h11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private com.google.firebase.remoteconfig.a f43075a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f43076b;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return (e) e.f43074d.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(j.b remoteConfigSettings) {
        Intrinsics.h(remoteConfigSettings, "$this$remoteConfigSettings");
        remoteConfigSettings.e(3600L);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e eVar, Function2 function2, Task task) {
        Intrinsics.h(task, "task");
        boolean isSuccessful = task.isSuccessful();
        eVar.f43076b = isSuccessful;
        Boolean valueOf = Boolean.valueOf(isSuccessful);
        com.google.firebase.remoteconfig.a aVar = eVar.f43075a;
        if (aVar == null) {
            Intrinsics.z("remoteConfig");
            aVar = null;
        }
        function2.invoke(valueOf, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e h() {
        return new e();
    }

    public final void e(final Function2 callback) {
        Intrinsics.h(callback, "callback");
        com.google.firebase.remoteconfig.a a11 = n.a(com.google.firebase.c.f31123a);
        this.f43075a = a11;
        com.google.firebase.remoteconfig.a aVar = null;
        if (a11 == null) {
            Intrinsics.z("remoteConfig");
            a11 = null;
        }
        a11.w(n.b(new Function1() { // from class: com.transsion.baselib.config.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f11;
                f11 = e.f((j.b) obj);
                return f11;
            }
        }));
        com.google.firebase.remoteconfig.a aVar2 = this.f43075a;
        if (aVar2 == null) {
            Intrinsics.z("remoteConfig");
        } else {
            aVar = aVar2;
        }
        aVar.h().addOnCompleteListener(new OnCompleteListener() { // from class: com.transsion.baselib.config.d
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                e.g(e.this, callback, task);
            }
        });
    }
}
