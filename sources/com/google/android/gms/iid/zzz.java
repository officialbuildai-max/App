package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes3.dex */
abstract class zzz<T> {
    final int what;
    final int zzcp;
    final TaskCompletionSource<T> zzcq = new TaskCompletionSource<>();
    final Bundle zzcr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(int i11, int i12, Bundle bundle) {
        this.zzcp = i11;
        this.what = i12;
        this.zzcr = bundle;
    }

    public String toString() {
        int i11 = this.what;
        int i12 = this.zzcp;
        zzw();
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("Request { what=");
        sb2.append(i11);
        sb2.append(" id=");
        sb2.append(i12);
        sb2.append(" oneWay=false}");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(zzaa zzaaVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzaaVar);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14 + valueOf2.length());
            sb2.append("Failing ");
            sb2.append(valueOf);
            sb2.append(" with ");
            sb2.append(valueOf2);
        }
        this.zzcq.setException(zzaaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzh(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzw();
}
