package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;

/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private int f19195a;

    /* renamed from: b, reason: collision with root package name */
    private String f19196b;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f19197a;

        /* renamed from: b, reason: collision with root package name */
        private String f19198b = "";

        /* synthetic */ a(o0 o0Var) {
        }

        public n a() {
            n nVar = new n();
            nVar.f19195a = this.f19197a;
            nVar.f19196b = this.f19198b;
            return nVar;
        }

        public a b(String str) {
            this.f19198b = str;
            return this;
        }

        public a c(int i11) {
            this.f19197a = i11;
            return this;
        }
    }

    public static a c() {
        return new a(null);
    }

    public String a() {
        return this.f19196b;
    }

    public int b() {
        return this.f19195a;
    }

    public String toString() {
        return "Response Code: " + zzb.zzh(this.f19195a) + ", Debug Message: " + this.f19196b;
    }
}
