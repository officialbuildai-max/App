package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzaf;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private boolean f19169a;

    /* renamed from: b, reason: collision with root package name */
    private String f19170b;

    /* renamed from: c, reason: collision with root package name */
    private String f19171c;

    /* renamed from: d, reason: collision with root package name */
    private c f19172d;

    /* renamed from: e, reason: collision with root package name */
    private zzaf f19173e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList f19174f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f19175g;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f19176a;

        /* renamed from: b, reason: collision with root package name */
        private String f19177b;

        /* renamed from: c, reason: collision with root package name */
        private List f19178c;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList f19179d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f19180e;

        /* renamed from: f, reason: collision with root package name */
        private c.a f19181f;

        /* synthetic */ a(g0 g0Var) {
            c.a a11 = c.a();
            c.a.b(a11);
            this.f19181f = a11;
        }

        public m a() {
            ArrayList arrayList = this.f19179d;
            boolean z10 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.f19178c;
            boolean z11 = (list == null || list.isEmpty()) ? false : true;
            if (!z10 && !z11) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z10 && z11) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            l0 l0Var = null;
            if (!z10) {
                b bVar = (b) this.f19178c.get(0);
                for (int i11 = 0; i11 < this.f19178c.size(); i11++) {
                    b bVar2 = (b) this.f19178c.get(i11);
                    if (bVar2 == null) {
                        throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                    }
                    if (i11 != 0 && !bVar2.b().c().equals(bVar.b().c()) && !bVar2.b().c().equals("play_pass_subs")) {
                        throw new IllegalArgumentException("All products should have same ProductType.");
                    }
                }
                String e11 = bVar.b().e();
                for (b bVar3 : this.f19178c) {
                    if (!bVar.b().c().equals("play_pass_subs") && !bVar3.b().c().equals("play_pass_subs") && !e11.equals(bVar3.b().e())) {
                        throw new IllegalArgumentException("All products must have the same package name.");
                    }
                }
            } else {
                if (this.f19179d.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.f19179d.size() > 1) {
                    android.support.v4.media.session.c.a(this.f19179d.get(0));
                    throw null;
                }
            }
            m mVar = new m(l0Var);
            if (z10) {
                android.support.v4.media.session.c.a(this.f19179d.get(0));
                throw null;
            }
            mVar.f19169a = z11 && !((b) this.f19178c.get(0)).b().e().isEmpty();
            mVar.f19170b = this.f19176a;
            mVar.f19171c = this.f19177b;
            mVar.f19172d = this.f19181f.a();
            ArrayList arrayList2 = this.f19179d;
            mVar.f19174f = arrayList2 != null ? new ArrayList(arrayList2) : new ArrayList();
            mVar.f19175g = this.f19180e;
            List list2 = this.f19178c;
            mVar.f19173e = list2 != null ? zzaf.zzj(list2) : zzaf.zzk();
            return mVar;
        }

        public a b(String str) {
            this.f19176a = str;
            return this;
        }

        public a c(List list) {
            this.f19178c = new ArrayList(list);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final r f19182a;

        /* renamed from: b, reason: collision with root package name */
        private final String f19183b;

        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private r f19184a;

            /* renamed from: b, reason: collision with root package name */
            private String f19185b;

            /* synthetic */ a(h0 h0Var) {
            }

            public b a() {
                com.google.android.gms.internal.play_billing.zzx.zzc(this.f19184a, "ProductDetails is required for constructing ProductDetailsParams.");
                com.google.android.gms.internal.play_billing.zzx.zzc(this.f19185b, "offerToken is required for constructing ProductDetailsParams.");
                return new b(this, null);
            }

            public a b(String str) {
                this.f19185b = str;
                return this;
            }

            public a c(r rVar) {
                this.f19184a = rVar;
                if (rVar.a() != null) {
                    rVar.a().getClass();
                    this.f19185b = rVar.a().a();
                }
                return this;
            }
        }

        /* synthetic */ b(a aVar, i0 i0Var) {
            this.f19182a = aVar.f19184a;
            this.f19183b = aVar.f19185b;
        }

        public static a a() {
            return new a(null);
        }

        public final r b() {
            return this.f19182a;
        }

        public final String c() {
            return this.f19183b;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f19186a;

        /* renamed from: b, reason: collision with root package name */
        private String f19187b;

        /* renamed from: c, reason: collision with root package name */
        private int f19188c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f19189d = 0;

        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private String f19190a;

            /* renamed from: b, reason: collision with root package name */
            private String f19191b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f19192c;

            /* renamed from: d, reason: collision with root package name */
            private int f19193d = 0;

            /* renamed from: e, reason: collision with root package name */
            private int f19194e = 0;

            /* synthetic */ a(j0 j0Var) {
            }

            static /* synthetic */ a b(a aVar) {
                aVar.f19192c = true;
                return aVar;
            }

            public c a() {
                boolean z10 = true;
                k0 k0Var = null;
                if (TextUtils.isEmpty(this.f19190a) && TextUtils.isEmpty(null)) {
                    z10 = false;
                }
                boolean isEmpty = TextUtils.isEmpty(this.f19191b);
                if (z10 && !isEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.f19192c && !z10 && isEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                c cVar = new c(k0Var);
                cVar.f19186a = this.f19190a;
                cVar.f19188c = this.f19193d;
                cVar.f19189d = this.f19194e;
                cVar.f19187b = this.f19191b;
                return cVar;
            }
        }

        /* synthetic */ c(k0 k0Var) {
        }

        public static a a() {
            return new a(null);
        }

        final int b() {
            return this.f19188c;
        }

        final int c() {
            return this.f19189d;
        }

        final String d() {
            return this.f19186a;
        }

        final String e() {
            return this.f19187b;
        }
    }

    /* synthetic */ m(l0 l0Var) {
    }

    public static a a() {
        return new a(null);
    }

    public final int b() {
        return this.f19172d.b();
    }

    public final int c() {
        return this.f19172d.c();
    }

    public final String d() {
        return this.f19170b;
    }

    public final String e() {
        return this.f19171c;
    }

    public final String f() {
        return this.f19172d.d();
    }

    public final String g() {
        return this.f19172d.e();
    }

    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f19174f);
        return arrayList;
    }

    public final List i() {
        return this.f19173e;
    }

    public final boolean q() {
        return this.f19175g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean r() {
        return (this.f19170b == null && this.f19171c == null && this.f19172d.e() == null && this.f19172d.b() == 0 && this.f19172d.c() == 0 && !this.f19169a && !this.f19175g) ? false : true;
    }
}
