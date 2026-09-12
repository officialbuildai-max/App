package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzjf implements zznb {
    private final zzjc zza;

    private zzjf(zzjc zzjcVar) {
        zzjc zzjcVar2 = (zzjc) zzjv.zza(zzjcVar, "output");
        this.zza = zzjcVar2;
        zzjcVar2.zza = this;
    }

    public static zzjf zza(zzjc zzjcVar) {
        zzjf zzjfVar = zzjcVar.zza;
        return zzjfVar != null ? zzjfVar : new zzjf(zzjcVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    @Deprecated
    public final void zza(int i11) throws IOException {
        this.zza.zzc(i11, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, double d11) throws IOException {
        this.zza.zzb(i11, d11);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, float f11) throws IOException {
        this.zza.zzb(i11, f11);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, int i12) throws IOException {
        this.zza.zzb(i11, i12);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, long j11) throws IOException {
        this.zza.zza(i11, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, zzik zzikVar) throws IOException {
        this.zza.zza(i11, zzikVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final <K, V> void zza(int i11, zzkt<K, V> zzktVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzc(i11, 2);
            this.zza.zzc(zzku.zza(zzktVar, entry.getKey(), entry.getValue()));
            zzku.zza(this.zza, zzktVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, Object obj) throws IOException {
        if (obj instanceof zzik) {
            this.zza.zzb(i11, (zzik) obj);
        } else {
            this.zza.zza(i11, (zzlc) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, Object obj, zzlu zzluVar) throws IOException {
        zzjc zzjcVar = this.zza;
        zzjcVar.zzc(i11, 3);
        zzluVar.zza((zzlu) obj, (zznb) zzjcVar.zza);
        zzjcVar.zzc(i11, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, String str) throws IOException {
        this.zza.zza(i11, str);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, List<zzik> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.zza.zza(i11, list.get(i12));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, List<?> list, zzlu zzluVar) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            zza(i11, list.get(i12), zzluVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, List<Boolean> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzii)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zza(i11, list.get(i12).booleanValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zza(list.get(i14).booleanValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zzb(list.get(i12).booleanValue());
                i12++;
            }
            return;
        }
        zzii zziiVar = (zzii) list;
        if (!z10) {
            while (i12 < zziiVar.size()) {
                this.zza.zza(i11, zziiVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zziiVar.size(); i16++) {
            i15 += zzjc.zza(zziiVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zziiVar.size()) {
            this.zza.zzb(zziiVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zza(int i11, boolean z10) throws IOException {
        this.zza.zza(i11, z10);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    @Deprecated
    public final void zzb(int i11) throws IOException {
        this.zza.zzc(i11, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzb(int i11, int i12) throws IOException {
        this.zza.zza(i11, i12);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzb(int i11, long j11) throws IOException {
        this.zza.zzb(i11, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzb(int i11, Object obj, zzlu zzluVar) throws IOException {
        this.zza.zza(i11, (zzlc) obj, zzluVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzb(int i11, List<String> list) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzkj)) {
            while (i12 < list.size()) {
                this.zza.zza(i11, list.get(i12));
                i12++;
            }
            return;
        }
        zzkj zzkjVar = (zzkj) list;
        while (i12 < list.size()) {
            Object zza = zzkjVar.zza(i12);
            if (zza instanceof String) {
                this.zza.zza(i11, (String) zza);
            } else {
                this.zza.zza(i11, (zzik) zza);
            }
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzb(int i11, List<?> list, zzlu zzluVar) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzb(i11, list.get(i12), zzluVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzb(int i11, List<Double> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzje)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zzb(i11, list.get(i12).doubleValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zza(list.get(i14).doubleValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zzb(list.get(i12).doubleValue());
                i12++;
            }
            return;
        }
        zzje zzjeVar = (zzje) list;
        if (!z10) {
            while (i12 < zzjeVar.size()) {
                this.zza.zzb(i11, zzjeVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzjeVar.size(); i16++) {
            i15 += zzjc.zza(zzjeVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzjeVar.size()) {
            this.zza.zzb(zzjeVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzc(int i11, int i12) throws IOException {
        this.zza.zzb(i11, i12);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzc(int i11, long j11) throws IOException {
        this.zza.zza(i11, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzc(int i11, List<Integer> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzjw)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zzb(i11, list.get(i12).intValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zzd(list.get(i14).intValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zzb(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        if (!z10) {
            while (i12 < zzjwVar.size()) {
                this.zza.zzb(i11, zzjwVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzjwVar.size(); i16++) {
            i15 += zzjc.zzd(zzjwVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzjwVar.size()) {
            this.zza.zzb(zzjwVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzd(int i11, int i12) throws IOException {
        this.zza.zza(i11, i12);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzd(int i11, long j11) throws IOException {
        this.zza.zzh(i11, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzd(int i11, List<Integer> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzjw)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zza(i11, list.get(i12).intValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zze(list.get(i14).intValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zza(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        if (!z10) {
            while (i12 < zzjwVar.size()) {
                this.zza.zza(i11, zzjwVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzjwVar.size(); i16++) {
            i15 += zzjc.zze(zzjwVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzjwVar.size()) {
            this.zza.zza(zzjwVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zze(int i11, int i12) throws IOException {
        this.zza.zzk(i11, i12);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zze(int i11, long j11) throws IOException {
        this.zza.zzb(i11, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zze(int i11, List<Long> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzkn)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zza(i11, list.get(i12).longValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zzc(list.get(i14).longValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zza(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        zzkn zzknVar = (zzkn) list;
        if (!z10) {
            while (i12 < zzknVar.size()) {
                this.zza.zza(i11, zzknVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzknVar.size(); i16++) {
            i15 += zzjc.zzc(zzknVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzknVar.size()) {
            this.zza.zza(zzknVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzf(int i11, int i12) throws IOException {
        this.zza.zzd(i11, i12);
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzf(int i11, List<Float> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzjs)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zzb(i11, list.get(i12).floatValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zza(list.get(i14).floatValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zzb(list.get(i12).floatValue());
                i12++;
            }
            return;
        }
        zzjs zzjsVar = (zzjs) list;
        if (!z10) {
            while (i12 < zzjsVar.size()) {
                this.zza.zzb(i11, zzjsVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzjsVar.size(); i16++) {
            i15 += zzjc.zza(zzjsVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzjsVar.size()) {
            this.zza.zzb(zzjsVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzg(int i11, List<Integer> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzjw)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zzb(i11, list.get(i12).intValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zzf(list.get(i14).intValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zzb(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        if (!z10) {
            while (i12 < zzjwVar.size()) {
                this.zza.zzb(i11, zzjwVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzjwVar.size(); i16++) {
            i15 += zzjc.zzf(zzjwVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzjwVar.size()) {
            this.zza.zzb(zzjwVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzh(int i11, List<Long> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzkn)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zzb(i11, list.get(i12).longValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zzd(list.get(i14).longValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zzb(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        zzkn zzknVar = (zzkn) list;
        if (!z10) {
            while (i12 < zzknVar.size()) {
                this.zza.zzb(i11, zzknVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzknVar.size(); i16++) {
            i15 += zzjc.zzd(zzknVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzknVar.size()) {
            this.zza.zzb(zzknVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzi(int i11, List<Integer> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzjw)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zza(i11, list.get(i12).intValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zzg(list.get(i14).intValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zza(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        if (!z10) {
            while (i12 < zzjwVar.size()) {
                this.zza.zza(i11, zzjwVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzjwVar.size(); i16++) {
            i15 += zzjc.zzg(zzjwVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzjwVar.size()) {
            this.zza.zza(zzjwVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzj(int i11, List<Long> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzkn)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zza(i11, list.get(i12).longValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zze(list.get(i14).longValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zza(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        zzkn zzknVar = (zzkn) list;
        if (!z10) {
            while (i12 < zzknVar.size()) {
                this.zza.zza(i11, zzknVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzknVar.size(); i16++) {
            i15 += zzjc.zze(zzknVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzknVar.size()) {
            this.zza.zza(zzknVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzk(int i11, List<Integer> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzjw)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zzk(i11, list.get(i12).intValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zzh(list.get(i14).intValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zzk(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        if (!z10) {
            while (i12 < zzjwVar.size()) {
                this.zza.zzk(i11, zzjwVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzjwVar.size(); i16++) {
            i15 += zzjc.zzh(zzjwVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzjwVar.size()) {
            this.zza.zzk(zzjwVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzl(int i11, List<Long> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzkn)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zzh(i11, list.get(i12).longValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zzf(list.get(i14).longValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zzh(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        zzkn zzknVar = (zzkn) list;
        if (!z10) {
            while (i12 < zzknVar.size()) {
                this.zza.zzh(i11, zzknVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzknVar.size(); i16++) {
            i15 += zzjc.zzf(zzknVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzknVar.size()) {
            this.zza.zzh(zzknVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzm(int i11, List<Integer> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzjw)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zzd(i11, list.get(i12).intValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zzj(list.get(i14).intValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zzc(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        zzjw zzjwVar = (zzjw) list;
        if (!z10) {
            while (i12 < zzjwVar.size()) {
                this.zza.zzd(i11, zzjwVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzjwVar.size(); i16++) {
            i15 += zzjc.zzj(zzjwVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzjwVar.size()) {
            this.zza.zzc(zzjwVar.zzb(i12));
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final void zzn(int i11, List<Long> list, boolean z10) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzkn)) {
            if (!z10) {
                while (i12 < list.size()) {
                    this.zza.zzb(i11, list.get(i12).longValue());
                    i12++;
                }
                return;
            }
            this.zza.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzjc.zzg(list.get(i14).longValue());
            }
            this.zza.zzc(i13);
            while (i12 < list.size()) {
                this.zza.zzb(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        zzkn zzknVar = (zzkn) list;
        if (!z10) {
            while (i12 < zzknVar.size()) {
                this.zza.zzb(i11, zzknVar.zzb(i12));
                i12++;
            }
            return;
        }
        this.zza.zzc(i11, 2);
        int i15 = 0;
        for (int i16 = 0; i16 < zzknVar.size(); i16++) {
            i15 += zzjc.zzg(zzknVar.zzb(i16));
        }
        this.zza.zzc(i15);
        while (i12 < zzknVar.size()) {
            this.zza.zzb(zzknVar.zzb(i12));
            i12++;
        }
    }
}
