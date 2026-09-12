package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzaux implements zzavu {
    private static final zzavd zza = new zzauv();
    private final zzavd zzb;

    public zzaux() {
        zzavd zzavdVar;
        zzatn zza2 = zzatn.zza();
        try {
            zzavdVar = (zzavd) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzavdVar = zza;
        }
        zzauw zzauwVar = new zzauw(zza2, zzavdVar);
        byte[] bArr = zzaud.zzd;
        this.zzb = zzauwVar;
    }

    private static boolean zzb(zzavc zzavcVar) {
        return zzavcVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.libraries.places.internal.zzavu
    public final zzavt zza(Class cls) {
        zzavv.zzs(cls);
        zzavc zzb = this.zzb.zzb(cls);
        return zzb.zzb() ? zzatu.class.isAssignableFrom(cls) ? zzavj.zzi(zzavv.zzn(), zzati.zzb(), zzb.zza()) : zzavj.zzi(zzavv.zzm(), zzati.zza(), zzb.zza()) : zzatu.class.isAssignableFrom(cls) ? zzb(zzb) ? zzavi.zzi(cls, zzb, zzavm.zzb(), zzaut.zze(), zzavv.zzn(), zzati.zzb(), zzavb.zzb()) : zzavi.zzi(cls, zzb, zzavm.zzb(), zzaut.zze(), zzavv.zzn(), null, zzavb.zzb()) : zzb(zzb) ? zzavi.zzi(cls, zzb, zzavm.zza(), zzaut.zzd(), zzavv.zzm(), zzati.zza(), zzavb.zza()) : zzavi.zzi(cls, zzb, zzavm.zza(), zzaut.zzd(), zzavv.zzm(), null, zzavb.zza());
    }
}
