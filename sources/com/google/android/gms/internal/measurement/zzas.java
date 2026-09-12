package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzas implements zzaq, Iterable<zzaq> {
    private final String zza;

    public zzas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzas) {
            return this.zza.equals(((zzas) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator<zzaq> iterator() {
        return new zzau(this);
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0317  */
    @Override // com.google.android.gms.internal.measurement.zzaq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.zzaq zza(java.lang.String r22, com.google.android.gms.internal.measurement.zzh r23, java.util.List<com.google.android.gms.internal.measurement.zzaq> r24) {
        /*
            Method dump skipped, instructions count: 1790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzas.zza(java.lang.String, com.google.android.gms.internal.measurement.zzh, java.util.List):com.google.android.gms.internal.measurement.zzaq");
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zzc() {
        return new zzas(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Boolean zzd() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Double zze() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final String zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Iterator<zzaq> zzh() {
        return new zzav(this);
    }
}
