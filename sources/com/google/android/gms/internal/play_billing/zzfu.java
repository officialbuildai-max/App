package com.google.android.gms.internal.play_billing;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzfu implements zzgn {
    private static final zzga zza = new zzfs();
    private final zzga zzb;

    public zzfu() {
        zzga zzgaVar;
        zzes zza2 = zzes.zza();
        try {
            zzgaVar = (zzga) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzgaVar = zza;
        }
        zzft zzftVar = new zzft(zza2, zzgaVar);
        byte[] bArr = zzfd.zzd;
        this.zzb = zzftVar;
    }

    private static boolean zzb(zzfz zzfzVar) {
        return zzfzVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgn
    public final zzgm zza(Class cls) {
        zzgo.zzq(cls);
        zzfz zzb = this.zzb.zzb(cls);
        return zzb.zzb() ? zzex.class.isAssignableFrom(cls) ? zzgg.zzc(zzgo.zzn(), zzem.zzb(), zzb.zza()) : zzgg.zzc(zzgo.zzm(), zzem.zza(), zzb.zza()) : zzex.class.isAssignableFrom(cls) ? zzb(zzb) ? zzgf.zzl(cls, zzb, zzgi.zzb(), zzfq.zzd(), zzgo.zzn(), zzem.zzb(), zzfy.zzb()) : zzgf.zzl(cls, zzb, zzgi.zzb(), zzfq.zzd(), zzgo.zzn(), null, zzfy.zzb()) : zzb(zzb) ? zzgf.zzl(cls, zzb, zzgi.zza(), zzfq.zzc(), zzgo.zzm(), zzem.zza(), zzfy.zza()) : zzgf.zzl(cls, zzb, zzgi.zza(), zzfq.zzc(), zzgo.zzm(), null, zzfy.zza());
    }
}
