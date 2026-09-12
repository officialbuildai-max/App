package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements g {

    /* renamed from: a, reason: collision with root package name */
    private final h f31955a;

    /* renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource f31956b;

    public d(h hVar, TaskCompletionSource taskCompletionSource) {
        this.f31955a = hVar;
        this.f31956b = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.g
    public boolean a(Exception exc) {
        this.f31956b.trySetException(exc);
        return true;
    }

    @Override // com.google.firebase.installations.g
    public boolean b(com.google.firebase.installations.local.b bVar) {
        if (!bVar.k() || this.f31955a.f(bVar)) {
            return false;
        }
        this.f31956b.setResult(f.a().b(bVar.b()).d(bVar.c()).c(bVar.h()).a());
        return true;
    }
}
