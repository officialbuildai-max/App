package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.Response;
import retrofit2.o0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class u extends l0 {

    /* renamed from: a, reason: collision with root package name */
    private final i0 f74623a;

    /* renamed from: b, reason: collision with root package name */
    private final Call.Factory f74624b;

    /* renamed from: c, reason: collision with root package name */
    private final k f74625c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a extends u {

        /* renamed from: d, reason: collision with root package name */
        private final e f74626d;

        a(i0 i0Var, Call.Factory factory, k kVar, e eVar) {
            super(i0Var, factory, kVar);
            this.f74626d = eVar;
        }

        @Override // retrofit2.u
        protected Object c(d dVar, Object[] objArr) {
            return this.f74626d.b(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b extends u {

        /* renamed from: d, reason: collision with root package name */
        private final e f74627d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f74628e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f74629f;

        b(i0 i0Var, Call.Factory factory, k kVar, e eVar, boolean z10, boolean z11) {
            super(i0Var, factory, kVar);
            this.f74627d = eVar;
            this.f74628e = z10;
            this.f74629f = z11;
        }

        @Override // retrofit2.u
        protected Object c(d dVar, Object[] objArr) {
            d dVar2 = (d) this.f74627d.b(dVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return this.f74629f ? KotlinExtensions.d(dVar2, continuation) : this.f74628e ? KotlinExtensions.b(dVar2, continuation) : KotlinExtensions.a(dVar2, continuation);
            } catch (LinkageError e11) {
                throw e11;
            } catch (ThreadDeath e12) {
                throw e12;
            } catch (VirtualMachineError e13) {
                throw e13;
            } catch (Throwable th2) {
                return KotlinExtensions.e(th2, continuation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends u {

        /* renamed from: d, reason: collision with root package name */
        private final e f74630d;

        c(i0 i0Var, Call.Factory factory, k kVar, e eVar) {
            super(i0Var, factory, kVar);
            this.f74630d = eVar;
        }

        @Override // retrofit2.u
        protected Object c(d dVar, Object[] objArr) {
            d dVar2 = (d) this.f74630d.b(dVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.c(dVar2, continuation);
            } catch (Exception e11) {
                return KotlinExtensions.e(e11, continuation);
            }
        }
    }

    u(i0 i0Var, Call.Factory factory, k kVar) {
        this.f74623a = i0Var;
        this.f74624b = factory;
        this.f74625c = kVar;
    }

    private static e d(k0 k0Var, Method method, Type type, Annotation[] annotationArr) {
        try {
            return k0Var.a(type, annotationArr);
        } catch (RuntimeException e11) {
            throw o0.o(method, e11, "Unable to create call adapter for %s", type);
        }
    }

    private static k e(k0 k0Var, Method method, Type type) {
        try {
            return k0Var.h(type, method.getAnnotations());
        } catch (RuntimeException e11) {
            throw o0.o(method, e11, "Unable to create converter for %s", type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u f(k0 k0Var, Method method, i0 i0Var) {
        Type genericReturnType;
        boolean z10;
        boolean z11;
        boolean m11;
        boolean z12 = i0Var.f74544l;
        Annotation[] annotations = method.getAnnotations();
        if (z12) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type f11 = o0.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (o0.h(f11) == j0.class && (f11 instanceof ParameterizedType)) {
                f11 = o0.g(0, (ParameterizedType) f11);
                z10 = true;
                m11 = false;
            } else {
                if (o0.h(f11) == d.class) {
                    throw o0.n(method, "Suspend functions should not return Call, as they already execute asynchronously.\nChange its return type to %s", o0.g(0, (ParameterizedType) f11));
                }
                m11 = o0.m(f11);
                z10 = false;
            }
            genericReturnType = new o0.b(null, d.class, f11);
            annotations = n0.a(annotations);
            z11 = m11;
        } else {
            genericReturnType = method.getGenericReturnType();
            z10 = false;
            z11 = false;
        }
        e d11 = d(k0Var, method, genericReturnType, annotations);
        Type a11 = d11.a();
        if (a11 == Response.class) {
            throw o0.n(method, "'" + o0.h(a11).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (a11 == j0.class) {
            throw o0.n(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (i0Var.f74536d.equals("HEAD") && !Void.class.equals(a11) && !o0.m(a11)) {
            throw o0.n(method, "HEAD method must use Void or Unit as response type.", new Object[0]);
        }
        k e11 = e(k0Var, method, a11);
        Call.Factory factory = k0Var.f74582b;
        return !z12 ? new a(i0Var, factory, e11, d11) : z10 ? new c(i0Var, factory, e11, d11) : new b(i0Var, factory, e11, d11, false, z11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // retrofit2.l0
    public final Object a(Object obj, Object[] objArr) {
        return c(new w(this.f74623a, obj, objArr, this.f74624b, this.f74625c), objArr);
    }

    protected abstract Object c(d dVar, Object[] objArr);
}
