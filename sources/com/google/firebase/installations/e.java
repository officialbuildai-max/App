package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
class e implements g {

    /* renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f31957a;

    public e(TaskCompletionSource taskCompletionSource) {
        this.f31957a = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.g
    public boolean a(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.g
    public boolean b(com.google.firebase.installations.local.b bVar) {
        if (!bVar.l() && !bVar.k() && !bVar.i()) {
            return false;
        }
        this.f31957a.trySetResult(bVar.d());
        return true;
    }
}
