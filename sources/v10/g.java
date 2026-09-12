package v10;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.p;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.e;
import retrofit2.j0;
import retrofit2.k0;

/* loaded from: classes7.dex */
public final class g extends e.a {

    /* renamed from: a, reason: collision with root package name */
    private final Scheduler f77136a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f77137b;

    private g(Scheduler scheduler, boolean z10) {
        this.f77136a = scheduler;
        this.f77137b = z10;
    }

    public static g d() {
        return new g(null, true);
    }

    public static g e(Scheduler scheduler) {
        if (scheduler != null) {
            return new g(scheduler, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.e.a
    public retrofit2.e a(Type type, Annotation[] annotationArr, k0 k0Var) {
        Type type2;
        boolean z10;
        boolean z11;
        Class c11 = e.a.c(type);
        if (c11 == io.reactivex.rxjava3.core.a.class) {
            return new f(Void.class, this.f77136a, this.f77137b, false, true, false, false, false, true);
        }
        boolean z12 = c11 == io.reactivex.rxjava3.core.e.class;
        boolean z13 = c11 == p.class;
        boolean z14 = c11 == io.reactivex.rxjava3.core.g.class;
        if (c11 != j.class && !z12 && !z13 && !z14) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z12 ? !z13 ? z14 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type b11 = e.a.b(0, (ParameterizedType) type);
        Class c12 = e.a.c(b11);
        if (c12 == j0.class) {
            if (!(b11 instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            type2 = e.a.b(0, (ParameterizedType) b11);
            z11 = false;
            z10 = false;
        } else if (c12 != d.class) {
            type2 = b11;
            z10 = true;
            z11 = false;
        } else {
            if (!(b11 instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            type2 = e.a.b(0, (ParameterizedType) b11);
            z11 = true;
            z10 = false;
        }
        return new f(type2, this.f77136a, this.f77137b, z11, z10, z12, z13, z14, false);
    }
}
