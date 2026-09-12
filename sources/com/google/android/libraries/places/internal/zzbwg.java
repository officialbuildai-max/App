package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: Access modifiers changed from: package-private */
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class zzbwg implements zzbws {
    private final InputStream zza;
    private final zzbwv zzb;

    public zzbwg(InputStream input, zzbwv timeout) {
        Intrinsics.h(input, "input");
        Intrinsics.h(timeout, "timeout");
        this.zza = input;
        this.zzb = timeout;
    }

    @Override // com.google.android.libraries.places.internal.zzbws, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zza.close();
    }

    public final String toString() {
        return "source(" + this.zza + ")";
    }

    @Override // com.google.android.libraries.places.internal.zzbws
    public final long zza(zzbwb sink, long j11) {
        Intrinsics.h(sink, "sink");
        try {
            zzbwv.zzb();
            zzbwn zzB = sink.zzB(1);
            int read = this.zza.read(zzB.zzb, zzB.zzd, (int) Math.min(j11, 8192 - zzB.zzd));
            if (read != -1) {
                zzB.zzd += read;
                long j12 = read;
                sink.zzE(sink.zzg() + j12);
                return j12;
            }
            if (zzB.zzc != zzB.zzd) {
                return -1L;
            }
            sink.zza = zzB.zza();
            zzbwo.zzb(zzB);
            return -1L;
        } catch (AssertionError e11) {
            if (zzbwi.zza(e11)) {
                throw new IOException(e11);
            }
            throw e11;
        }
    }
}
