package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzaf;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c0 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f19126a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ u f19127b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ i f19128c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(i iVar, String str, u uVar) {
        this.f19128c = iVar;
        this.f19126a = str;
        this.f19127b = uVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        e1 E = i.E(this.f19128c, this.f19126a, 9);
        if (E.b() != null) {
            this.f19127b.a(E.a(), E.b());
            return null;
        }
        this.f19127b.a(E.a(), zzaf.zzk());
        return null;
    }
}
