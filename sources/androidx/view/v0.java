package androidx.view;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import p1.a;
import q1.g;

/* loaded from: classes.dex */
public class v0 {

    /* renamed from: b, reason: collision with root package name */
    public static final b f9731b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final a.b f9732c = g.a.f73175a;

    /* renamed from: a, reason: collision with root package name */
    private final p1.c f9733a;

    /* loaded from: classes.dex */
    public static class a extends d {

        /* renamed from: f, reason: collision with root package name */
        private static a f9735f;

        /* renamed from: d, reason: collision with root package name */
        private final Application f9737d;

        /* renamed from: e, reason: collision with root package name */
        public static final b f9734e = new b(null);

        /* renamed from: g, reason: collision with root package name */
        public static final a.b f9736g = new C0091a();

        /* renamed from: androidx.lifecycle.v0$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0091a implements a.b {
            C0091a() {
            }
        }

        /* loaded from: classes.dex */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a(Application application) {
                Intrinsics.h(application, "application");
                if (a.f9735f == null) {
                    a.f9735f = new a(application);
                }
                a aVar = a.f9735f;
                Intrinsics.e(aVar);
                return aVar;
            }
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            Intrinsics.h(application, "application");
        }

        private a(Application application, int i11) {
            this.f9737d = application;
        }

        private final t0 e(Class cls, Application application) {
            if (!androidx.view.b.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                t0 t0Var = (t0) cls.getConstructor(Application.class).newInstance(application);
                Intrinsics.g(t0Var, "{\n                try {\n…          }\n            }");
                return t0Var;
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (InstantiationException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (NoSuchMethodException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            } catch (InvocationTargetException e14) {
                throw new RuntimeException("Cannot create an instance of " + cls, e14);
            }
        }

        @Override // androidx.lifecycle.v0.d, androidx.lifecycle.v0.c
        public t0 create(Class modelClass) {
            Intrinsics.h(modelClass, "modelClass");
            Application application = this.f9737d;
            if (application != null) {
                return e(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.v0.d, androidx.lifecycle.v0.c
        public t0 create(Class modelClass, p1.a extras) {
            Intrinsics.h(modelClass, "modelClass");
            Intrinsics.h(extras, "extras");
            if (this.f9737d != null) {
                return create(modelClass);
            }
            Application application = (Application) extras.a(f9736g);
            if (application != null) {
                return e(modelClass, application);
            }
            if (androidx.view.b.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.create(modelClass);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final v0 a(x0 store, c factory, p1.a extras) {
            Intrinsics.h(store, "store");
            Intrinsics.h(factory, "factory");
            Intrinsics.h(extras, "extras");
            return new v0(store, factory, extras);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        t0 create(Class cls);

        t0 create(Class cls, p1.a aVar);

        t0 create(KClass kClass, p1.a aVar);
    }

    /* loaded from: classes.dex */
    public static class d implements c {

        /* renamed from: b, reason: collision with root package name */
        private static d f9739b;

        /* renamed from: a, reason: collision with root package name */
        public static final a f9738a = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final a.b f9740c = g.a.f73175a;

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final d a() {
                if (d.f9739b == null) {
                    d.f9739b = new d();
                }
                d dVar = d.f9739b;
                Intrinsics.e(dVar);
                return dVar;
            }
        }

        @Override // androidx.lifecycle.v0.c
        public t0 create(Class modelClass) {
            Intrinsics.h(modelClass, "modelClass");
            return q1.d.f73169a.a(modelClass);
        }

        @Override // androidx.lifecycle.v0.c
        public t0 create(Class modelClass, p1.a extras) {
            Intrinsics.h(modelClass, "modelClass");
            Intrinsics.h(extras, "extras");
            return create(modelClass);
        }

        @Override // androidx.lifecycle.v0.c
        public t0 create(KClass modelClass, p1.a extras) {
            Intrinsics.h(modelClass, "modelClass");
            Intrinsics.h(extras, "extras");
            return create(JvmClassMappingKt.a(modelClass), extras);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public void a(t0 viewModel) {
            Intrinsics.h(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v0(x0 store, c factory) {
        this(store, factory, null, 4, null);
        Intrinsics.h(store, "store");
        Intrinsics.h(factory, "factory");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v0(x0 store, c factory, p1.a defaultCreationExtras) {
        this(new p1.c(store, factory, defaultCreationExtras));
        Intrinsics.h(store, "store");
        Intrinsics.h(factory, "factory");
        Intrinsics.h(defaultCreationExtras, "defaultCreationExtras");
    }

    public /* synthetic */ v0(x0 x0Var, c cVar, p1.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(x0Var, cVar, (i11 & 4) != 0 ? a.C0908a.f72393b : aVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v0(androidx.view.y0 r4) {
        /*
            r3 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.Intrinsics.h(r4, r0)
            androidx.lifecycle.x0 r0 = r4.getViewModelStore()
            q1.g r1 = q1.g.f73174a
            androidx.lifecycle.v0$c r2 = r1.b(r4)
            p1.a r4 = r1.a(r4)
            r3.<init>(r0, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.v0.<init>(androidx.lifecycle.y0):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v0(y0 owner, c factory) {
        this(owner.getViewModelStore(), factory, g.f73174a.a(owner));
        Intrinsics.h(owner, "owner");
        Intrinsics.h(factory, "factory");
    }

    private v0(p1.c cVar) {
        this.f9733a = cVar;
    }

    public t0 a(Class modelClass) {
        Intrinsics.h(modelClass, "modelClass");
        return c(JvmClassMappingKt.c(modelClass));
    }

    public t0 b(String key, Class modelClass) {
        Intrinsics.h(key, "key");
        Intrinsics.h(modelClass, "modelClass");
        return this.f9733a.a(JvmClassMappingKt.c(modelClass), key);
    }

    public final t0 c(KClass modelClass) {
        Intrinsics.h(modelClass, "modelClass");
        return p1.c.b(this.f9733a, modelClass, null, 2, null);
    }
}
