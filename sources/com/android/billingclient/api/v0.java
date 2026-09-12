package com.android.billingclient.api;

/* loaded from: classes2.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f19278a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v0(u0 u0Var) {
    }

    public final v0 a() {
        this.f19278a = true;
        return this;
    }

    public final x0 b() {
        if (this.f19278a) {
            return new x0(true, false, null);
        }
        throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
    }
}
