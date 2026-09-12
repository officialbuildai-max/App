package com.google.android.libraries.places.internal;

import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbun implements zzbci {
    private static final ThreadLocal zza = new ThreadLocal();
    private final zzavn zzb;
    private final zzavf zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbun(zzavf zzavfVar, int i11) {
        zzmt.zzc(zzavfVar, "defaultInstance cannot be null");
        this.zzc = zzavfVar;
        this.zzb = zzavfVar.zzaz();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.places.internal.zzbci
    public final /* bridge */ /* synthetic */ InputStream zza(Object obj) {
        return new zzbum(obj, this.zzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b A[Catch: IOException -> 0x003b, TryCatch #3 {IOException -> 0x003b, blocks: (B:12:0x0015, B:14:0x001b, B:18:0x0025, B:20:0x002f, B:22:0x0037, B:27:0x004b, B:29:0x0055, B:33:0x0059, B:50:0x005e, B:51:0x007e, B:53:0x003e, B:55:0x0081), top: B:11:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0059 A[Catch: IOException -> 0x003b, TryCatch #3 {IOException -> 0x003b, blocks: (B:12:0x0015, B:14:0x001b, B:18:0x0025, B:20:0x002f, B:22:0x0037, B:27:0x004b, B:29:0x0055, B:33:0x0059, B:50:0x005e, B:51:0x007e, B:53:0x003e, B:55:0x0081), top: B:11:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x005e A[Catch: IOException -> 0x003b, TryCatch #3 {IOException -> 0x003b, blocks: (B:12:0x0015, B:14:0x001b, B:18:0x0025, B:20:0x002f, B:22:0x0037, B:27:0x004b, B:29:0x0055, B:33:0x0059, B:50:0x005e, B:51:0x007e, B:53:0x003e, B:55:0x0081), top: B:11:0x0015 }] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.lang.Object, com.google.android.libraries.places.internal.zzavf] */
    @Override // com.google.android.libraries.places.internal.zzbci
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* bridge */ /* synthetic */ java.lang.Object zzb(java.io.InputStream r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.google.android.libraries.places.internal.zzbum
            if (r0 == 0) goto L15
            r0 = r8
            com.google.android.libraries.places.internal.zzbum r0 = (com.google.android.libraries.places.internal.zzbum) r0
            com.google.android.libraries.places.internal.zzavn r1 = r0.zzc()
            com.google.android.libraries.places.internal.zzavn r2 = r7.zzb
            if (r1 != r2) goto L15
            com.google.android.libraries.places.internal.zzavf r8 = r0.zzb()     // Catch: java.lang.IllegalStateException -> L15
            goto L9e
        L15:
            boolean r0 = r8 instanceof com.google.android.libraries.places.internal.zzbav     // Catch: java.io.IOException -> L3b
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L84
            int r0 = r8.available()     // Catch: java.io.IOException -> L3b
            if (r0 <= 0) goto L7f
            r3 = 4194304(0x400000, float:5.877472E-39)
            if (r0 > r3) goto L7f
            java.lang.ThreadLocal r3 = com.google.android.libraries.places.internal.zzbun.zza     // Catch: java.io.IOException -> L3b
            java.lang.Object r4 = r3.get()     // Catch: java.io.IOException -> L3b
            java.lang.ref.Reference r4 = (java.lang.ref.Reference) r4     // Catch: java.io.IOException -> L3b
            if (r4 == 0) goto L3e
            java.lang.Object r4 = r4.get()     // Catch: java.io.IOException -> L3b
            byte[] r4 = (byte[]) r4     // Catch: java.io.IOException -> L3b
            if (r4 == 0) goto L3e
            int r5 = r4.length     // Catch: java.io.IOException -> L3b
            if (r5 >= r0) goto L48
            goto L3e
        L3b:
            r8 = move-exception
            goto Lb7
        L3e:
            byte[] r4 = new byte[r0]     // Catch: java.io.IOException -> L3b
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch: java.io.IOException -> L3b
            r5.<init>(r4)     // Catch: java.io.IOException -> L3b
            r3.set(r5)     // Catch: java.io.IOException -> L3b
        L48:
            r3 = r0
        L49:
            if (r3 <= 0) goto L57
            int r5 = r0 - r3
            int r5 = r8.read(r4, r5, r3)     // Catch: java.io.IOException -> L3b
            r6 = -1
            if (r5 != r6) goto L55
            goto L57
        L55:
            int r3 = r3 - r5
            goto L49
        L57:
            if (r3 != 0) goto L5e
            com.google.android.libraries.places.internal.zzasq r0 = com.google.android.libraries.places.internal.zzasq.zzJ(r4, r1, r0)     // Catch: java.io.IOException -> L3b
            goto L85
        L5e:
            int r8 = r0 - r3
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.io.IOException -> L3b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L3b
            r2.<init>()     // Catch: java.io.IOException -> L3b
            java.lang.String r3 = "size inaccurate: "
            r2.append(r3)     // Catch: java.io.IOException -> L3b
            r2.append(r0)     // Catch: java.io.IOException -> L3b
            java.lang.String r0 = " != "
            r2.append(r0)     // Catch: java.io.IOException -> L3b
            r2.append(r8)     // Catch: java.io.IOException -> L3b
            java.lang.String r8 = r2.toString()     // Catch: java.io.IOException -> L3b
            r1.<init>(r8)     // Catch: java.io.IOException -> L3b
            throw r1     // Catch: java.io.IOException -> L3b
        L7f:
            if (r0 != 0) goto L84
            com.google.android.libraries.places.internal.zzavf r8 = r7.zzc     // Catch: java.io.IOException -> L3b
            goto L9e
        L84:
            r0 = r2
        L85:
            if (r0 != 0) goto L8d
            r0 = 4096(0x1000, float:5.74E-42)
            com.google.android.libraries.places.internal.zzasq r0 = com.google.android.libraries.places.internal.zzasq.zzI(r8, r0)
        L8d:
            r8 = 2147483647(0x7fffffff, float:NaN)
            r0.zzG(r8)
            com.google.android.libraries.places.internal.zzavn r8 = r7.zzb     // Catch: com.google.android.libraries.places.internal.zzauf -> La4
            com.google.android.libraries.places.internal.zzatf r3 = com.google.android.libraries.places.internal.zzbuo.zza     // Catch: com.google.android.libraries.places.internal.zzauf -> La4
            java.lang.Object r8 = r8.zza(r0, r3)     // Catch: com.google.android.libraries.places.internal.zzauf -> La4
            r0.zzz(r1)     // Catch: com.google.android.libraries.places.internal.zzauf -> L9f
        L9e:
            return r8
        L9f:
            r0 = move-exception
            r0.zzh(r8)     // Catch: com.google.android.libraries.places.internal.zzauf -> La4
            throw r0     // Catch: com.google.android.libraries.places.internal.zzauf -> La4
        La4:
            r8 = move-exception
            com.google.android.libraries.places.internal.zzbdo r0 = com.google.android.libraries.places.internal.zzbdo.zzo
            java.lang.String r1 = "Invalid protobuf byte sequence"
            com.google.android.libraries.places.internal.zzbdo r0 = r0.zzg(r1)
            com.google.android.libraries.places.internal.zzbdo r8 = r0.zzf(r8)
            com.google.android.libraries.places.internal.zzbdq r0 = new com.google.android.libraries.places.internal.zzbdq
            r0.<init>(r8, r2)
            throw r0
        Lb7:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbun.zzb(java.io.InputStream):java.lang.Object");
    }
}
