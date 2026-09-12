package androidx.datastore.core;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class v implements CoroutineContext.Element {

    /* renamed from: c, reason: collision with root package name */
    public static final a f8709c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final String f8710d = "Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.";

    /* renamed from: a, reason: collision with root package name */
    private final v f8711a;

    /* renamed from: b, reason: collision with root package name */
    private final DataStoreImpl f8712b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: androidx.datastore.core.v$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0081a implements CoroutineContext.Key {

            /* renamed from: a, reason: collision with root package name */
            public static final C0081a f8713a = new C0081a();

            private C0081a() {
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public v(v vVar, DataStoreImpl instance) {
        Intrinsics.h(instance, "instance");
        this.f8711a = vVar;
        this.f8712b = instance;
    }

    public final void a(f candidate) {
        Intrinsics.h(candidate, "candidate");
        if (this.f8712b == candidate) {
            throw new IllegalStateException(f8710d.toString());
        }
        v vVar = this.f8711a;
        if (vVar != null) {
            vVar.a(candidate);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return CoroutineContext.Element.DefaultImpls.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key getKey() {
        return a.C0081a.f8713a;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.d(this, coroutineContext);
    }
}
