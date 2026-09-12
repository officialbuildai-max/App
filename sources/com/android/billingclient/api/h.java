package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes2.dex */
public abstract class h {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private volatile x0 f19139a;

        /* renamed from: b, reason: collision with root package name */
        private final Context f19140b;

        /* renamed from: c, reason: collision with root package name */
        private volatile v f19141c;

        /* renamed from: d, reason: collision with root package name */
        private volatile boolean f19142d;

        /* synthetic */ a(Context context, r1 r1Var) {
            this.f19140b = context;
        }

        public h a() {
            if (this.f19140b == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.f19141c == null) {
                if (this.f19142d) {
                    return new i(null, this.f19140b, null, null);
                }
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            if (this.f19139a != null) {
                return this.f19141c != null ? new i(null, this.f19139a, this.f19140b, this.f19141c, null, null, null) : new i(null, this.f19139a, this.f19140b, null, null, null);
            }
            throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
        }

        public a b() {
            v0 v0Var = new v0(null);
            v0Var.a();
            this.f19139a = v0Var.b();
            return this;
        }

        public a c(v vVar) {
            this.f19141c = vVar;
            return this;
        }
    }

    public static a c(Context context) {
        return new a(context, null);
    }

    public abstract boolean a();

    public abstract n b(Activity activity, m mVar);

    public abstract void d(w wVar, s sVar);

    public abstract void e(x xVar, u uVar);

    public abstract void f(j jVar);
}
