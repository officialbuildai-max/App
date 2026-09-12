package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.e;
import retrofit2.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class l extends e.a {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f74599a;

    /* loaded from: classes7.dex */
    class a implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f74600a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f74601b;

        a(Type type, Executor executor) {
            this.f74600a = type;
            this.f74601b = executor;
        }

        @Override // retrofit2.e
        public Type a() {
            return this.f74600a;
        }

        @Override // retrofit2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d b(d dVar) {
            Executor executor = this.f74601b;
            return executor == null ? dVar : new b(executor, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final Executor f74603a;

        /* renamed from: b, reason: collision with root package name */
        final d f74604b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public class a implements f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ f f74605a;

            a(f fVar) {
                this.f74605a = fVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e(f fVar, Throwable th2) {
                fVar.a(b.this, th2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(f fVar, j0 j0Var) {
                if (b.this.f74604b.isCanceled()) {
                    fVar.a(b.this, new IOException("Canceled"));
                } else {
                    fVar.b(b.this, j0Var);
                }
            }

            @Override // retrofit2.f
            public void a(d dVar, final Throwable th2) {
                Executor executor = b.this.f74603a;
                final f fVar = this.f74605a;
                executor.execute(new Runnable() { // from class: retrofit2.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.b.a.this.e(fVar, th2);
                    }
                });
            }

            @Override // retrofit2.f
            public void b(d dVar, final j0 j0Var) {
                Executor executor = b.this.f74603a;
                final f fVar = this.f74605a;
                executor.execute(new Runnable() { // from class: retrofit2.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.b.a.this.f(fVar, j0Var);
                    }
                });
            }
        }

        b(Executor executor, d dVar) {
            this.f74603a = executor;
            this.f74604b = dVar;
        }

        @Override // retrofit2.d
        public void cancel() {
            this.f74604b.cancel();
        }

        @Override // retrofit2.d
        public d clone() {
            return new b(this.f74603a, this.f74604b.clone());
        }

        @Override // retrofit2.d
        public j0 execute() {
            return this.f74604b.execute();
        }

        @Override // retrofit2.d
        public void h(f fVar) {
            Objects.requireNonNull(fVar, "callback == null");
            this.f74604b.h(new a(fVar));
        }

        @Override // retrofit2.d
        public boolean isCanceled() {
            return this.f74604b.isCanceled();
        }

        @Override // retrofit2.d
        public Request request() {
            return this.f74604b.request();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Executor executor) {
        this.f74599a = executor;
    }

    @Override // retrofit2.e.a
    public e a(Type type, Annotation[] annotationArr, k0 k0Var) {
        if (e.a.c(type) != d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(o0.g(0, (ParameterizedType) type), o0.l(annotationArr, m0.class) ? null : this.f74599a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
