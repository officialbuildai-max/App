package com.google.android.libraries.places.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzln extends t0 {
    private final zzla zza;
    private final zzlq zzb;
    private final zzlr zzc;
    private Runnable zze;
    private final Handler zzd = new Handler(Looper.getMainLooper());
    private final b0 zzf = new b0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzln(zzla zzlaVar, zzlq zzlqVar, zzlr zzlrVar, zzlm zzlmVar) {
        this.zza = zzlaVar;
        this.zzb = zzlqVar;
        this.zzc = zzlrVar;
    }

    private static Status zzn(Exception exc) {
        return exc instanceof ApiException ? ((ApiException) exc).getStatus() : new Status(13, exc.getMessage());
    }

    private final void zzo(zzkv zzkvVar) {
        if (zzkvVar.equals(this.zzf.f())) {
            return;
        }
        this.zzf.q(zzkvVar);
    }

    private static boolean zzp(Status status) {
        return status.isCanceled() || status.getStatusCode() == 9012 || status.getStatusCode() == 9011;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.t0
    public final void onCleared() {
        try {
            this.zza.zzc();
            this.zzd.removeCallbacks(this.zze);
            this.zzb.zzo();
            this.zzc.zza(this.zzb);
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    public final LiveData zza() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str, Task task) {
        if (task.isCanceled()) {
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            this.zzb.zzp();
            List<AutocompletePrediction> autocompletePredictions = ((FindAutocompletePredictionsResponse) task.getResult()).getAutocompletePredictions();
            if (autocompletePredictions.isEmpty()) {
                zzo(zzkv.zzh(str));
                return;
            } else {
                zzo(zzkv.zzj(autocompletePredictions));
                return;
            }
        }
        this.zzb.zzr();
        Status zzn = zzn(exception);
        if (zzp(zzn)) {
            zzo(zzkv.zzq(zzn));
        } else {
            zzo(zzkv.zzi(str, zzn));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(AutocompletePrediction autocompletePrediction, Task task) {
        if (task.isCanceled()) {
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            this.zzb.zzq();
            zzo(zzkv.zzn(((FetchPlaceResponse) task.getResult()).getPlace()));
            return;
        }
        this.zzb.zzs();
        Status zzn = zzn(exception);
        if (zzp(zzn)) {
            zzo(zzkv.zzq(zzn));
        } else {
            zzo(zzkv.zzm(autocompletePrediction, zzn));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(final String str, int i11) {
        this.zza.zzb(str, i11).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.libraries.places.internal.zzlj
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzln.this.zzb(str, task);
            }
        });
    }

    public final void zze(@Nullable Bundle bundle) {
        if (bundle == null) {
            this.zzf.q(zzkv.zzo());
        }
    }

    public final void zzf(final AutocompletePrediction autocompletePrediction, int i11) {
        this.zzb.zzu(i11);
        Task zza = this.zza.zza(autocompletePrediction);
        if (!zza.isComplete()) {
            zzo(zzkv.zzg());
        }
        zza.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.libraries.places.internal.zzli
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzln.this.zzc(autocompletePrediction, task);
            }
        });
    }

    public final void zzg() {
        this.zzb.zzv();
    }

    public final void zzh() {
        this.zzb.zzl();
    }

    public final void zzi() {
        this.zzb.zzm();
    }

    public final void zzj() {
        this.zzb.zzn();
        zzo(zzkv.zzl());
    }

    public final void zzk() {
        this.zzb.zzw();
        zzm("", 0);
    }

    public final void zzl(String str, int i11) {
        this.zza.zzc();
        zzm(str, i11);
        zzo(zzkv.zzp());
    }

    public final void zzm(final String str, final int i11) {
        this.zzb.zzt(str);
        Runnable runnable = this.zze;
        if (runnable != null) {
            this.zzd.removeCallbacks(runnable);
        }
        if (str.isEmpty()) {
            this.zza.zzc();
            zzo(zzkv.zzk());
        } else {
            Runnable runnable2 = new Runnable() { // from class: com.google.android.libraries.places.internal.zzlk
                @Override // java.lang.Runnable
                public final void run() {
                    zzln.this.zzd(str, i11);
                }
            };
            this.zze = runnable2;
            this.zzd.postDelayed(runnable2, 100L);
            zzo(zzkv.zzg());
        }
    }
}
