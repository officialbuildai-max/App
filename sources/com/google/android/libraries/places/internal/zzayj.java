package com.google.android.libraries.places.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzayj {
    public static final zzayj zza;
    private final zzazn zzb;
    private final Executor zzc;
    private final Object[][] zzd;
    private final List zze;
    private final Boolean zzf;
    private final Integer zzg;
    private final Integer zzh;

    static {
        zzayg zzaygVar = new zzayg();
        zzaygVar.zzc = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        zzaygVar.zzd = Collections.emptyList();
        zza = new zzayj(zzaygVar, null);
    }

    /* synthetic */ zzayj(zzayg zzaygVar, zzayi zzayiVar) {
        this.zzb = zzaygVar.zza;
        this.zzc = zzaygVar.zzb;
        this.zzd = zzaygVar.zzc;
        this.zze = zzaygVar.zzd;
        this.zzf = zzaygVar.zze;
        this.zzg = zzaygVar.zzf;
        this.zzh = zzaygVar.zzg;
    }

    private static zzayg zzp(zzayj zzayjVar) {
        zzayg zzaygVar = new zzayg();
        zzaygVar.zza = zzayjVar.zzb;
        zzaygVar.zzb = zzayjVar.zzc;
        zzaygVar.zzc = zzayjVar.zzd;
        zzaygVar.zzd = zzayjVar.zze;
        zzaygVar.zze = zzayjVar.zzf;
        zzaygVar.zzf = zzayjVar.zzg;
        zzaygVar.zzg = zzayjVar.zzh;
        return zzaygVar;
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzd("deadline", this.zzb);
        zzb.zzd("authority", null);
        zzb.zzd("callCredentials", null);
        Executor executor = this.zzc;
        zzb.zzd("executor", executor != null ? executor.getClass() : null);
        zzb.zzd("compressorName", null);
        zzb.zzd("customOptions", Arrays.deepToString(this.zzd));
        zzb.zze("waitForReady", zzo());
        zzb.zzd("maxInboundMessageSize", this.zzg);
        zzb.zzd("maxOutboundMessageSize", this.zzh);
        zzb.zzd("streamTracerFactories", this.zze);
        return zzb.toString();
    }

    public final zzayj zza(zzazn zzaznVar) {
        zzayg zzp = zzp(this);
        zzp.zza = zzaznVar;
        return new zzayj(zzp, null);
    }

    public final zzayj zzb(Executor executor) {
        zzayg zzp = zzp(this);
        zzp.zzb = executor;
        return new zzayj(zzp, null);
    }

    public final zzayj zzc(int i11) {
        zzmt.zzh(i11 >= 0, "invalid maxsize %s", i11);
        zzayg zzp = zzp(this);
        zzp.zzf = Integer.valueOf(i11);
        return new zzayj(zzp, null);
    }

    public final zzayj zzd(int i11) {
        zzmt.zzh(i11 >= 0, "invalid maxsize %s", i11);
        zzayg zzp = zzp(this);
        zzp.zzg = Integer.valueOf(i11);
        return new zzayj(zzp, null);
    }

    public final zzayj zze(zzayh zzayhVar, Object obj) {
        zzmt.zzc(zzayhVar, "key");
        zzmt.zzc(obj, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        zzayg zzp = zzp(this);
        int i11 = 0;
        while (true) {
            Object[][] objArr = this.zzd;
            if (i11 >= objArr.length) {
                i11 = -1;
                break;
            }
            if (zzayhVar.equals(objArr[i11][0])) {
                break;
            }
            i11++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.zzd.length + (i11 == -1 ? 1 : 0), 2);
        zzp.zzc = objArr2;
        Object[][] objArr3 = this.zzd;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i11 == -1) {
            Object[][] objArr4 = zzp.zzc;
            int length = this.zzd.length;
            Object[] objArr5 = new Object[2];
            objArr5[0] = zzayhVar;
            objArr5[1] = obj;
            objArr4[length] = objArr5;
        } else {
            Object[][] objArr6 = zzp.zzc;
            Object[] objArr7 = new Object[2];
            objArr7[0] = zzayhVar;
            objArr7[1] = obj;
            objArr6[i11] = objArr7;
        }
        return new zzayj(zzp, null);
    }

    public final zzayj zzf(zzayu zzayuVar) {
        ArrayList arrayList = new ArrayList(this.zze.size() + 1);
        arrayList.addAll(this.zze);
        arrayList.add(zzayuVar);
        zzayg zzp = zzp(this);
        zzp.zzd = Collections.unmodifiableList(arrayList);
        return new zzayj(zzp, null);
    }

    public final zzayj zzg() {
        zzayg zzp = zzp(this);
        zzp.zze = Boolean.TRUE;
        return new zzayj(zzp, null);
    }

    public final zzayj zzh() {
        zzayg zzp = zzp(this);
        zzp.zze = Boolean.FALSE;
        return new zzayj(zzp, null);
    }

    public final zzazn zzi() {
        return this.zzb;
    }

    public final Integer zzj() {
        return this.zzg;
    }

    public final Integer zzk() {
        return this.zzh;
    }

    public final Object zzl(zzayh zzayhVar) {
        zzmt.zzc(zzayhVar, "key");
        int i11 = 0;
        while (true) {
            Object[][] objArr = this.zzd;
            if (i11 >= objArr.length) {
                zzayh.zzb(zzayhVar);
                return null;
            }
            if (zzayhVar.equals(objArr[i11][0])) {
                return this.zzd[i11][1];
            }
            i11++;
        }
    }

    public final List zzm() {
        return this.zze;
    }

    public final Executor zzn() {
        return this.zzc;
    }

    public final boolean zzo() {
        return Boolean.TRUE.equals(this.zzf);
    }
}
