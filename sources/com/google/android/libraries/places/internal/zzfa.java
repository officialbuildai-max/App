package com.google.android.libraries.places.internal;

import com.android.volley.VolleyError;
import com.android.volley.h;
import com.android.volley.i;
import com.android.volley.toolbox.j;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfa {
    private final h zza;
    private final zzij zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfa(h hVar, zzij zzijVar) {
        this.zza = hVar;
        this.zzb = zzijVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(TaskCompletionSource taskCompletionSource, VolleyError volleyError) {
        try {
            taskCompletionSource.trySetException(zzeu.zza(volleyError));
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    public final Task zza(zzfi zzfiVar, final Class cls) {
        String zzc = zzfiVar.zzc();
        Map zzd = zzfiVar.zzd();
        CancellationToken zza = zzfiVar.zza();
        final TaskCompletionSource taskCompletionSource = zza != null ? new TaskCompletionSource(zza) : new TaskCompletionSource();
        final zzez zzezVar = new zzez(this, 0, zzc, null, new i.b() { // from class: com.google.android.libraries.places.internal.zzew
            @Override // com.android.volley.i.b
            public final void onResponse(Object obj) {
                zzfa.this.zzb(cls, taskCompletionSource, (JSONObject) obj);
            }
        }, new i.a() { // from class: com.google.android.libraries.places.internal.zzex
            @Override // com.android.volley.i.a
            public final void onErrorResponse(VolleyError volleyError) {
                zzfa.zzc(TaskCompletionSource.this, volleyError);
            }
        }, zzd);
        if (zza != null) {
            zza.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzey
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    j.this.cancel();
                }
            });
        }
        this.zza.a(zzezVar);
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Class cls, TaskCompletionSource taskCompletionSource, JSONObject jSONObject) {
        try {
            try {
                taskCompletionSource.trySetResult((zzfj) this.zzb.zza(jSONObject.toString(), cls));
            } catch (zzfk e11) {
                taskCompletionSource.trySetException(new ApiException(new Status(8, e11.getMessage())));
            }
        } catch (Error | RuntimeException e12) {
            zzkd.zzb(e12);
            throw e12;
        }
    }
}
