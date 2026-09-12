package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class n {

    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract n a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a b(r8.c cVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a c(r8.d dVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a d(r8.g gVar);

        public abstract a e(o oVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new c.b();
    }

    public abstract r8.c b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract r8.d c();

    public byte[] d() {
        return (byte[]) e().apply(c().c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract r8.g e();

    public abstract o f();

    public abstract String g();
}
