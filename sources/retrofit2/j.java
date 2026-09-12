package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import retrofit2.e;

/* loaded from: classes7.dex */
final class j extends e.a {

    /* loaded from: classes7.dex */
    private static final class a implements e {

        /* renamed from: a, reason: collision with root package name */
        private final Type f74571a;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: retrofit2.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0934a implements f {

            /* renamed from: a, reason: collision with root package name */
            private final CompletableFuture f74572a;

            public C0934a(CompletableFuture completableFuture) {
                this.f74572a = completableFuture;
            }

            @Override // retrofit2.f
            public void a(d dVar, Throwable th2) {
                this.f74572a.completeExceptionally(th2);
            }

            @Override // retrofit2.f
            public void b(d dVar, j0 j0Var) {
                if (j0Var.e()) {
                    this.f74572a.complete(j0Var.a());
                } else {
                    this.f74572a.completeExceptionally(new HttpException(j0Var));
                }
            }
        }

        a(Type type) {
            this.f74571a = type;
        }

        @Override // retrofit2.e
        public Type a() {
            return this.f74571a;
        }

        @Override // retrofit2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture b(d dVar) {
            b bVar = new b(dVar);
            dVar.h(new C0934a(bVar));
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b extends CompletableFuture {

        /* renamed from: a, reason: collision with root package name */
        private final d f74574a;

        b(d dVar) {
            this.f74574a = dVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            if (z10) {
                this.f74574a.cancel();
            }
            return super.cancel(z10);
        }
    }

    /* loaded from: classes7.dex */
    private static final class c implements e {

        /* renamed from: a, reason: collision with root package name */
        private final Type f74575a;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes7.dex */
        public class a implements f {

            /* renamed from: a, reason: collision with root package name */
            private final CompletableFuture f74576a;

            public a(CompletableFuture completableFuture) {
                this.f74576a = completableFuture;
            }

            @Override // retrofit2.f
            public void a(d dVar, Throwable th2) {
                this.f74576a.completeExceptionally(th2);
            }

            @Override // retrofit2.f
            public void b(d dVar, j0 j0Var) {
                this.f74576a.complete(j0Var);
            }
        }

        c(Type type) {
            this.f74575a = type;
        }

        @Override // retrofit2.e
        public Type a() {
            return this.f74575a;
        }

        @Override // retrofit2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture b(d dVar) {
            b bVar = new b(dVar);
            dVar.h(new a(bVar));
            return bVar;
        }
    }

    @Override // retrofit2.e.a
    public e a(Type type, Annotation[] annotationArr, k0 k0Var) {
        if (e.a.c(type) != g.a()) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type b11 = e.a.b(0, (ParameterizedType) type);
        if (e.a.c(b11) != j0.class) {
            return new a(b11);
        }
        if (b11 instanceof ParameterizedType) {
            return new c(e.a.b(0, (ParameterizedType) b11));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
