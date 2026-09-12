package com.google.android.libraries.places.internal;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes4.dex */
public final class zzbcl {
    private final zzbcj zza;
    private final String zzb;
    private final String zzc;
    private final zzbci zzd;
    private final zzbci zze;
    private final boolean zzf;
    private final AtomicReferenceArray zzg = new AtomicReferenceArray(2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbcl(zzbcj zzbcjVar, String str, zzbci zzbciVar, zzbci zzbciVar2, Object obj, boolean z10, boolean z11, boolean z12, zzbck zzbckVar) {
        zzmt.zzc(zzbcjVar, NativeComponentConstants.KEY_COMPONENT_TYPE);
        this.zza = zzbcjVar;
        zzmt.zzc(str, "fullMethodName");
        this.zzb = str;
        zzmt.zzc(str, "fullMethodName");
        int lastIndexOf = str.lastIndexOf(47);
        this.zzc = lastIndexOf == -1 ? null : str.substring(0, lastIndexOf);
        zzmt.zzc(zzbciVar, "requestMarshaller");
        this.zzd = zzbciVar;
        zzmt.zzc(zzbciVar2, "responseMarshaller");
        this.zze = zzbciVar2;
        this.zzf = z12;
    }

    public static zzbch zza(zzbci zzbciVar, zzbci zzbciVar2) {
        zzbch zzbchVar = new zzbch(null);
        zzbchVar.zzb(null);
        zzbchVar.zzc(null);
        return zzbchVar;
    }

    public static String zze(String str, String str2) {
        zzmt.zzc(str, "fullServiceName");
        zzmt.zzc(str2, "methodName");
        return str + "/" + str2;
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("fullMethodName", this.zzb);
        zzb.zzd(NativeComponentConstants.KEY_COMPONENT_TYPE, this.zza);
        zzb.zze("idempotent", false);
        zzb.zze("safe", false);
        zzb.zze("sampledToLocalTracing", this.zzf);
        zzb.zzd("requestMarshaller", this.zzd);
        zzb.zzd("responseMarshaller", this.zze);
        zzb.zzd("schemaDescriptor", null);
        zzb.zzg();
        return zzb.toString();
    }

    public final zzbcj zzb() {
        return this.zza;
    }

    public final InputStream zzc(Object obj) {
        return this.zzd.zza(obj);
    }

    public final Object zzd(InputStream inputStream) {
        return this.zze.zzb(inputStream);
    }

    public final String zzf() {
        return this.zzb;
    }

    public final String zzg() {
        return this.zzc;
    }
}
