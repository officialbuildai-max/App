package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzfr implements Continuation {
    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        ApiException apiException;
        Exception exception = task.getException();
        if (exception == null) {
            return task;
        }
        if (exception instanceof ApiException) {
            apiException = (ApiException) exception;
        } else if (exception instanceof zzbdq) {
            zzbdo zze = zzbdo.zze((zzbdq) exception);
            zzbdj zzbdjVar = zzbdj.OK;
            int ordinal = zze.zza().ordinal();
            apiException = ordinal != 3 ? ordinal != 4 ? ordinal != 5 ? ordinal != 7 ? ordinal != 13 ? ordinal != 14 ? new ApiException(new Status(13, zze.zzi())) : new ApiException(new Status(7, zze.zzi())) : new ApiException(new Status(8, zze.zzi())) : new ApiException(new Status(PlacesStatusCodes.REQUEST_DENIED, zze.zzi())) : new ApiException(new Status(9013, zze.zzi())) : new ApiException(new Status(15, zze.zzi())) : new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, zze.zzi()));
        } else {
            apiException = new ApiException(new Status(13, exception.toString()));
        }
        return Tasks.forException(apiException);
    }
}
