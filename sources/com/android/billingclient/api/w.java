package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzaf;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final zzaf f19279a;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private zzaf f19280a;

        /* synthetic */ a(h1 h1Var) {
        }

        public w a() {
            return new w(this, null);
        }

        public a b(List list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (!"play_pass_subs".equals(bVar.c())) {
                    hashSet.add(bVar.c());
                }
            }
            if (hashSet.size() > 1) {
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            this.f19280a = zzaf.zzj(list);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f19281a;

        /* renamed from: b, reason: collision with root package name */
        private final String f19282b;

        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private String f19283a;

            /* renamed from: b, reason: collision with root package name */
            private String f19284b;

            /* synthetic */ a(i1 i1Var) {
            }

            public b a() {
                if ("first_party".equals(this.f19284b)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                }
                if (this.f19283a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if (this.f19284b != null) {
                    return new b(this, null);
                }
                throw new IllegalArgumentException("Product type must be provided.");
            }

            public a b(String str) {
                this.f19283a = str;
                return this;
            }

            public a c(String str) {
                this.f19284b = str;
                return this;
            }
        }

        /* synthetic */ b(a aVar, j1 j1Var) {
            this.f19281a = aVar.f19283a;
            this.f19282b = aVar.f19284b;
        }

        public static a a() {
            return new a(null);
        }

        public final String b() {
            return this.f19281a;
        }

        public final String c() {
            return this.f19282b;
        }
    }

    /* synthetic */ w(a aVar, k1 k1Var) {
        this.f19279a = aVar.f19280a;
    }

    public static a a() {
        return new a(null);
    }

    public final zzaf b() {
        return this.f19279a;
    }

    public final String c() {
        return ((b) this.f19279a.get(0)).c();
    }
}
