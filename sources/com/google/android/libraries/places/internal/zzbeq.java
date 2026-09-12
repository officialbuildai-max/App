package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzbeq {
    final /* synthetic */ zzbey zza;
    private final zzbbd zzb;
    private zzbbm zzc;
    private zzbbo zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbeq(zzbey zzbeyVar, zzbbd zzbbdVar) {
        this.zza = zzbeyVar;
        this.zzb = zzbbdVar;
        zzbbo zza = zzbey.zzb(zzbeyVar).zza(zzbey.zzd(zzbeyVar));
        this.zzd = zza;
        if (zza != null) {
            this.zzc = zza.zza(zzbbdVar);
            return;
        }
        throw new IllegalStateException("Could not find policy '" + zzbey.zzd(zzbeyVar) + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
    }

    public final zzbbm zza() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0059, code lost:
    
        if (r3.zza.zzd().equals(r5.zzd()) == false) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.libraries.places.internal.zzbdo zzb(com.google.android.libraries.places.internal.zzbbi r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 2
            r2 = 1
            java.lang.Object r3 = r9.zzd()
            com.google.android.libraries.places.internal.zzbqg r3 = (com.google.android.libraries.places.internal.zzbqg) r3
            r4 = 0
            if (r3 != 0) goto L47
            com.google.android.libraries.places.internal.zzbey r3 = r8.zza     // Catch: com.google.android.libraries.places.internal.zzbex -> L1f
            java.lang.String r5 = com.google.android.libraries.places.internal.zzbey.zzd(r3)     // Catch: com.google.android.libraries.places.internal.zzbex -> L1f
            java.lang.String r6 = "using default policy"
            com.google.android.libraries.places.internal.zzbbo r3 = com.google.android.libraries.places.internal.zzbey.zza(r3, r5, r6)     // Catch: com.google.android.libraries.places.internal.zzbex -> L1f
            com.google.android.libraries.places.internal.zzbqg r5 = new com.google.android.libraries.places.internal.zzbqg
            r5.<init>(r3, r4)
            r3 = r5
            goto L47
        L1f:
            r9 = move-exception
            com.google.android.libraries.places.internal.zzbdo r0 = com.google.android.libraries.places.internal.zzbdo.zzo
            java.lang.String r9 = r9.getMessage()
            com.google.android.libraries.places.internal.zzbdo r9 = r0.zzg(r9)
            com.google.android.libraries.places.internal.zzbbd r0 = r8.zzb
            com.google.android.libraries.places.internal.zzaze r1 = com.google.android.libraries.places.internal.zzaze.TRANSIENT_FAILURE
            com.google.android.libraries.places.internal.zzbet r2 = new com.google.android.libraries.places.internal.zzbet
            r2.<init>(r9)
            r0.zze(r1, r2)
            com.google.android.libraries.places.internal.zzbbm r9 = r8.zzc
            r9.zze()
            r8.zzd = r4
            com.google.android.libraries.places.internal.zzbev r9 = new com.google.android.libraries.places.internal.zzbev
            r9.<init>(r4)
            r8.zzc = r9
            com.google.android.libraries.places.internal.zzbdo r9 = com.google.android.libraries.places.internal.zzbdo.zza
            return r9
        L47:
            com.google.android.libraries.places.internal.zzbbo r5 = r8.zzd
            if (r5 == 0) goto L5b
            com.google.android.libraries.places.internal.zzbbo r6 = r3.zza
            java.lang.String r5 = r5.zzd()
            java.lang.String r6 = r6.zzd()
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto La1
        L5b:
            com.google.android.libraries.places.internal.zzbbd r5 = r8.zzb
            com.google.android.libraries.places.internal.zzaze r6 = com.google.android.libraries.places.internal.zzaze.CONNECTING
            com.google.android.libraries.places.internal.zzbes r7 = new com.google.android.libraries.places.internal.zzbes
            r7.<init>(r4)
            r5.zze(r6, r7)
            com.google.android.libraries.places.internal.zzbbm r4 = r8.zzc
            r4.zze()
            com.google.android.libraries.places.internal.zzbbo r4 = r3.zza
            r8.zzd = r4
            com.google.android.libraries.places.internal.zzbbm r5 = r8.zzc
            com.google.android.libraries.places.internal.zzbbd r6 = r8.zzb
            com.google.android.libraries.places.internal.zzbbm r4 = r4.zza(r6)
            r8.zzc = r4
            com.google.android.libraries.places.internal.zzbbd r4 = r8.zzb
            com.google.android.libraries.places.internal.zzblg r4 = (com.google.android.libraries.places.internal.zzblg) r4
            com.google.android.libraries.places.internal.zzbma r4 = r4.zzb
            com.google.android.libraries.places.internal.zzaym r4 = com.google.android.libraries.places.internal.zzbma.zzg(r4)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            com.google.android.libraries.places.internal.zzbbm r6 = r8.zzc
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getSimpleName()
            java.lang.Object[] r7 = new java.lang.Object[r1]
            r7[r0] = r5
            r7[r2] = r6
            java.lang.String r5 = "Load balancer changed from {0} to {1}"
            r4.zzb(r1, r5, r7)
        La1:
            java.lang.Object r1 = r3.zzb
            if (r1 == 0) goto Lb8
            com.google.android.libraries.places.internal.zzbbd r3 = r8.zzb
            com.google.android.libraries.places.internal.zzblg r3 = (com.google.android.libraries.places.internal.zzblg) r3
            com.google.android.libraries.places.internal.zzbma r3 = r3.zzb
            com.google.android.libraries.places.internal.zzaym r3 = com.google.android.libraries.places.internal.zzbma.zzg(r3)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r4[r0] = r1
            java.lang.String r0 = "Load-balancing config: {0}"
            r3.zzb(r2, r0, r4)
        Lb8:
            com.google.android.libraries.places.internal.zzbbm r0 = r8.zzc
            com.google.android.libraries.places.internal.zzbbg r2 = com.google.android.libraries.places.internal.zzbbi.zzb()
            java.util.List r3 = r9.zze()
            r2.zza(r3)
            com.google.android.libraries.places.internal.zzaye r9 = r9.zza()
            r2.zzb(r9)
            r2.zzc(r1)
            com.google.android.libraries.places.internal.zzbbi r9 = r2.zzd()
            com.google.android.libraries.places.internal.zzbdo r9 = r0.zza(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbeq.zzb(com.google.android.libraries.places.internal.zzbbi):com.google.android.libraries.places.internal.zzbdo");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        this.zzc.zze();
        this.zzc = null;
    }
}
