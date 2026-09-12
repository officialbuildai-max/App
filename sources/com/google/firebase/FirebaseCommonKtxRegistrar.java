package com.google.firebase;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m1;
import mb.b0;
import mb.r;

@Keep
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/FirebaseCommonKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "", "Lmb/c;", "getComponents", "()Ljava/util/List;", "com.google.firebase-firebase-common"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    /* loaded from: classes4.dex */
    public static final class a implements mb.h {

        /* renamed from: a, reason: collision with root package name */
        public static final a f31092a = new a();

        @Override // mb.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i0 a(mb.e eVar) {
            Object c11 = eVar.c(b0.a(lb.a.class, Executor.class));
            Intrinsics.g(c11, "get(...)");
            return m1.b((Executor) c11);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements mb.h {

        /* renamed from: a, reason: collision with root package name */
        public static final b f31093a = new b();

        @Override // mb.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i0 a(mb.e eVar) {
            Object c11 = eVar.c(b0.a(lb.c.class, Executor.class));
            Intrinsics.g(c11, "get(...)");
            return m1.b((Executor) c11);
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements mb.h {

        /* renamed from: a, reason: collision with root package name */
        public static final c f31094a = new c();

        @Override // mb.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i0 a(mb.e eVar) {
            Object c11 = eVar.c(b0.a(lb.b.class, Executor.class));
            Intrinsics.g(c11, "get(...)");
            return m1.b((Executor) c11);
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements mb.h {

        /* renamed from: a, reason: collision with root package name */
        public static final d f31095a = new d();

        @Override // mb.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i0 a(mb.e eVar) {
            Object c11 = eVar.c(b0.a(lb.d.class, Executor.class));
            Intrinsics.g(c11, "get(...)");
            return m1.b((Executor) c11);
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<mb.c> getComponents() {
        mb.c d11 = mb.c.e(b0.a(lb.a.class, i0.class)).b(r.l(b0.a(lb.a.class, Executor.class))).f(a.f31092a).d();
        Intrinsics.g(d11, "build(...)");
        mb.c d12 = mb.c.e(b0.a(lb.c.class, i0.class)).b(r.l(b0.a(lb.c.class, Executor.class))).f(b.f31093a).d();
        Intrinsics.g(d12, "build(...)");
        mb.c d13 = mb.c.e(b0.a(lb.b.class, i0.class)).b(r.l(b0.a(lb.b.class, Executor.class))).f(c.f31094a).d();
        Intrinsics.g(d13, "build(...)");
        mb.c d14 = mb.c.e(b0.a(lb.d.class, i0.class)).b(r.l(b0.a(lb.d.class, Executor.class))).f(d.f31095a).d();
        Intrinsics.g(d14, "build(...)");
        return CollectionsKt.o(d11, d12, d13, d14);
    }
}
