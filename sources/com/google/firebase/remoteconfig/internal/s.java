package com.google.firebase.remoteconfig.internal;

/* loaded from: classes4.dex */
public class s implements yc.i {

    /* renamed from: a, reason: collision with root package name */
    private final long f32619a;

    /* renamed from: b, reason: collision with root package name */
    private final int f32620b;

    /* renamed from: c, reason: collision with root package name */
    private final yc.j f32621c;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private long f32622a;

        /* renamed from: b, reason: collision with root package name */
        private int f32623b;

        /* renamed from: c, reason: collision with root package name */
        private yc.j f32624c;

        private b() {
        }

        public s a() {
            return new s(this.f32622a, this.f32623b, this.f32624c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b b(yc.j jVar) {
            this.f32624c = jVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b c(int i11) {
            this.f32623b = i11;
            return this;
        }

        public b d(long j11) {
            this.f32622a = j11;
            return this;
        }
    }

    private s(long j11, int i11, yc.j jVar) {
        this.f32619a = j11;
        this.f32620b = i11;
        this.f32621c = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b b() {
        return new b();
    }

    @Override // yc.i
    public int a() {
        return this.f32620b;
    }
}
