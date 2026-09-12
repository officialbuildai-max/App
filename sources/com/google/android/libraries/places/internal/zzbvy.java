package com.google.android.libraries.places.internal;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes4.dex */
public final class zzbvy implements zzbws {
    final /* synthetic */ zzbvz zza;
    final /* synthetic */ zzbws zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvy(zzbvz zzbvzVar, zzbws zzbwsVar) {
        this.zza = zzbvzVar;
        this.zzb = zzbwsVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbws, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        zzbvz zzbvzVar = this.zza;
        try {
            this.zzb.close();
            Unit unit = Unit.f67184a;
        } catch (IOException e11) {
            throw e11;
        } finally {
            zzbvw.zza(zzbvz.zza, zzbvzVar);
        }
    }

    public final String toString() {
        return "AsyncTimeout.source(" + this.zzb + ")";
    }

    @Override // com.google.android.libraries.places.internal.zzbws
    public final long zza(zzbwb sink, long j11) {
        Intrinsics.h(sink, "sink");
        zzbvz zzbvzVar = this.zza;
        try {
            return this.zzb.zza(sink, j11);
        } catch (IOException e11) {
            throw e11;
        } finally {
            zzbvw.zza(zzbvz.zza, zzbvzVar);
        }
    }
}
