package com.cloud.hisavana.protocol.okhttptransport;

/* loaded from: classes3.dex */
public abstract class c {

    /* loaded from: classes3.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f21548a = new a();

        /* loaded from: classes3.dex */
        class a extends c {
            a() {
                super();
            }

            @Override // com.cloud.hisavana.protocol.okhttptransport.c
            boolean b() {
                return true;
            }

            @Override // com.cloud.hisavana.protocol.okhttptransport.c
            int c() {
                return 16;
            }
        }
    }

    private c() {
    }

    public static c a() {
        return b.f21548a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int c();
}
