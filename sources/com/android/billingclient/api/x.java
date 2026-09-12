package com.android.billingclient.api;

/* loaded from: classes2.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final String f19285a;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f19286a;

        /* synthetic */ a(l1 l1Var) {
        }

        public x a() {
            if (this.f19286a != null) {
                return new x(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f19286a = str;
            return this;
        }
    }

    /* synthetic */ x(a aVar, m1 m1Var) {
        this.f19285a = aVar.f19286a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.f19285a;
    }
}
