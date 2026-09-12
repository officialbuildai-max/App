package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzatk {
    private static final zzatk zzb = new zzatk(true);
    final zzawg zza = new zzavw(16);
    private boolean zzc;
    private boolean zzd;

    private zzatk() {
    }

    private zzatk(boolean z10) {
        zzg();
        zzg();
    }

    static int zza(zzaxd zzaxdVar, int i11, Object obj) {
        zzasx.zzB(i11 << 3);
        if (zzaxd.zzj == null) {
            byte[] bArr = zzaud.zzd;
            if (((zzavf) obj) instanceof zzaru) {
                throw null;
            }
        }
        zzaxe zzaxeVar = zzaxe.INT;
        throw null;
    }

    public static int zzb(zzatj zzatjVar, Object obj) {
        zzaxd zzd = zzatjVar.zzd();
        int zza = zzatjVar.zza();
        if (!zzatjVar.zzg()) {
            return zza(zzd, zza, obj);
        }
        List list = (List) obj;
        int i11 = 0;
        if (!zzatjVar.zzf()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i11 += zza(zzd, zza, it.next());
            }
            return i11;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        if (!it2.hasNext()) {
            return zzasx.zzB(zza << 3) + zzasx.zzB(0);
        }
        it2.next();
        zzaxd zzaxdVar = zzaxd.zza;
        zzaxe zzaxeVar = zzaxe.INT;
        throw null;
    }

    public static zzatk zzd() {
        return zzb;
    }

    private static Object zzk(Object obj) {
        if (obj instanceof zzavk) {
            return ((zzavk) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzl(Map.Entry entry) {
        zzatj zzatjVar = (zzatj) entry.getKey();
        Object value = entry.getValue();
        boolean z10 = value instanceof zzauk;
        if (zzatjVar.zzg()) {
            if (z10) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object zze = zze(zzatjVar);
            if (zze == null) {
                zze = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) zze).add(zzk(it.next()));
            }
            this.zza.put(zzatjVar, zze);
            return;
        }
        if (zzatjVar.zze() != zzaxe.MESSAGE) {
            if (z10) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(zzatjVar, zzk(value));
            return;
        }
        Object zze2 = zze(zzatjVar);
        if (zze2 != null) {
            if (z10) {
                throw null;
            }
            this.zza.put(zzatjVar, zze2 instanceof zzavk ? zzatjVar.zzc((zzavk) zze2, (zzavk) value) : zzatjVar.zzb(((zzavf) zze2).zzaJ(), (zzavf) value).zzt());
        } else {
            this.zza.put(zzatjVar, zzk(value));
            if (z10) {
                this.zzd = true;
            }
        }
    }

    private static boolean zzm(Map.Entry entry) {
        zzatj zzatjVar = (zzatj) entry.getKey();
        if (zzatjVar.zze() != zzaxe.MESSAGE) {
            return true;
        }
        if (!zzatjVar.zzg()) {
            return zzn(entry.getValue());
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!zzn(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzn(Object obj) {
        if (obj instanceof zzavg) {
            return ((zzavg) obj).zzaM();
        }
        if (obj instanceof zzauk) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        int i11;
        int zzB;
        int zzB2;
        int zzaq;
        int zzB3;
        zzatj zzatjVar = (zzatj) entry.getKey();
        Object value = entry.getValue();
        if (zzatjVar.zze() != zzaxe.MESSAGE || zzatjVar.zzg() || zzatjVar.zzf()) {
            return zzb(zzatjVar, value);
        }
        if (value instanceof zzauk) {
            int zza = ((zzatj) entry.getKey()).zza();
            int zzB4 = zzasx.zzB(8);
            i11 = zzB4 + zzB4;
            zzB = zzasx.zzB(16) + zzasx.zzB(zza);
            zzB2 = zzasx.zzB(24);
            zzaq = ((zzauk) value).zza();
            zzB3 = zzasx.zzB(zzaq);
        } else {
            int zza2 = ((zzatj) entry.getKey()).zza();
            int zzB5 = zzasx.zzB(8);
            i11 = zzB5 + zzB5;
            zzB = zzasx.zzB(16) + zzasx.zzB(zza2);
            zzB2 = zzasx.zzB(24);
            zzaq = ((zzavf) value).zzaq();
            zzB3 = zzasx.zzB(zzaq);
        }
        return i11 + zzB + zzB2 + zzB3 + zzaq;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzp(com.google.android.libraries.places.internal.zzatj r4, java.lang.Object r5) {
        /*
            com.google.android.libraries.places.internal.zzaxd r0 = r4.zzd()
            byte[] r1 = com.google.android.libraries.places.internal.zzaud.zzd
            r5.getClass()
            com.google.android.libraries.places.internal.zzaxd r1 = com.google.android.libraries.places.internal.zzaxd.zza
            com.google.android.libraries.places.internal.zzaxe r1 = com.google.android.libraries.places.internal.zzaxe.INT
            com.google.android.libraries.places.internal.zzaxe r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r5 instanceof com.google.android.libraries.places.internal.zzavf
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.libraries.places.internal.zzauk
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.libraries.places.internal.zzatw
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r5 instanceof com.google.android.libraries.places.internal.zzask
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r5 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r5 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r5 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r5 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r5 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r4.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.libraries.places.internal.zzaxd r4 = r4.zzd()
            com.google.android.libraries.places.internal.zzaxe r4 = r4.zza()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            r1 = 1
            r2[r1] = r4
            r4 = 2
            r2[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r2)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzatk.zzp(com.google.android.libraries.places.internal.zzatj, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzatk zzatkVar = new zzatk();
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry zzg = this.zza.zzg(i11);
            zzatkVar.zzi((zzatj) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzatkVar.zzi((zzatj) entry.getKey(), entry.getValue());
        }
        zzatkVar.zzd = this.zzd;
        return zzatkVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzatk) {
            return this.zza.equals(((zzatk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.zza.zzb(); i12++) {
            i11 += zzo(this.zza.zzg(i12));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            i11 += zzo((Map.Entry) it.next());
        }
        return i11;
    }

    public final Object zze(zzatj zzatjVar) {
        Object obj = this.zza.get(zzatjVar);
        if (obj instanceof zzauk) {
            throw null;
        }
        return obj;
    }

    public final Iterator zzf() {
        return this.zzd ? new zzauj(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry zzg = this.zza.zzg(i11);
            if (zzg.getValue() instanceof zzatu) {
                ((zzatu) zzg.getValue()).zzaC();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzatk zzatkVar) {
        for (int i11 = 0; i11 < zzatkVar.zza.zzb(); i11++) {
            zzl(zzatkVar.zza.zzg(i11));
        }
        Iterator it = zzatkVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzl((Map.Entry) it.next());
        }
    }

    public final void zzi(zzatj zzatjVar, Object obj) {
        if (!zzatjVar.zzg()) {
            zzp(zzatjVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                zzp(zzatjVar, arrayList.get(i11));
            }
            obj = arrayList;
        }
        if (obj instanceof zzauk) {
            this.zzd = true;
        }
        this.zza.put(zzatjVar, obj);
    }

    public final boolean zzj() {
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            if (!zzm(this.zza.zzg(i11))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzm((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }
}
