package com.google.android.libraries.places.internal;

import java.nio.charset.Charset;
import java.util.Locale;
import okhttp3.internal.http2.Header;

/* loaded from: classes4.dex */
public abstract class zzbjg extends zzbee {
    private static final zzbaq zza;
    private static final zzbca zzb;
    private zzbdo zzc;
    private zzbcf zzd;
    private Charset zze;
    private boolean zzf;

    static {
        zzbjf zzbjfVar = new zzbjf();
        zza = zzbjfVar;
        zzb = zzbar.zzb(Header.RESPONSE_STATUS_UTF8, zzbjfVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbjg(int i11, zzbqo zzbqoVar, zzbqz zzbqzVar, zzayj zzayjVar) {
        super(i11, zzbqoVar, zzbqzVar, zzayjVar);
        this.zze = zzmb.zzc;
    }

    private static Charset zzG(zzbcf zzbcfVar) {
        String str = (String) zzbcfVar.zzb(zzbjd.zzh);
        if (str != null) {
            try {
                return Charset.forName(str.split("charset=", 2)[r2.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return zzmb.zzc;
    }

    private static void zzH(zzbcf zzbcfVar) {
        zzbcfVar.zzd(zzb);
        zzbcfVar.zzd(zzbat.zzb);
        zzbcfVar.zzd(zzbat.zza);
    }

    private static final zzbdo zzI(zzbcf zzbcfVar) {
        char charAt;
        Integer num = (Integer) zzbcfVar.zzb(zzb);
        if (num == null) {
            return zzbdo.zzo.zzg("Missing HTTP status code");
        }
        String str = (String) zzbcfVar.zzb(zzbjd.zzh);
        if (str != null && str.length() >= 16) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.startsWith("application/grpc") && (lowerCase.length() == 16 || (charAt = lowerCase.charAt(16)) == '+' || charAt == ';')) {
                return null;
            }
        }
        return zzbjd.zza(num.intValue()).zzc("invalid content-type: ".concat(String.valueOf(str)));
    }

    protected abstract void zzA(zzbdo zzbdoVar, boolean z10, zzbcf zzbcfVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzB(zzbnv zzbnvVar, boolean z10) {
        zzbdo zzbdoVar = this.zzc;
        if (zzbdoVar != null) {
            Charset charset = this.zze;
            zzmt.zzc(charset, "charset");
            int zzf = zzbnvVar.zzf();
            byte[] bArr = new byte[zzf];
            zzbnvVar.zzk(bArr, 0, zzf);
            this.zzc = zzbdoVar.zzc("DATA-----------------------------\n".concat(new String(bArr, charset)));
            zzbnvVar.close();
            if (this.zzc.zzi().length() > 1000 || z10) {
                zzA(this.zzc, false, this.zzd);
                return;
            }
            return;
        }
        if (!this.zzf) {
            zzA(zzbdo.zzo.zzg("headers not received before payload"), false, new zzbcf());
            return;
        }
        int zzf2 = zzbnvVar.zzf();
        zzf(zzbnvVar);
        if (z10) {
            if (zzf2 > 0) {
                this.zzc = zzbdo.zzo.zzg("Received unexpected EOS on non-empty DATA frame from server");
            } else {
                this.zzc = zzbdo.zzo.zzg("Received unexpected EOS on empty DATA frame from server");
            }
            zzbcf zzbcfVar = new zzbcf();
            this.zzd = zzbcfVar;
            zzj(this.zzc, zzbfs.PROCESSED, false, zzbcfVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzC(zzbcf zzbcfVar) {
        zzbdo zzbdoVar = this.zzc;
        if (zzbdoVar != null) {
            this.zzc = zzbdoVar.zzc("headers: ".concat(zzbcfVar.toString()));
            return;
        }
        try {
            if (this.zzf) {
                this.zzc = zzbdo.zzo.zzg("Received headers twice");
            } else {
                Integer num = (Integer) zzbcfVar.zzb(zzb);
                if (num == null || num.intValue() < 100 || num.intValue() >= 200) {
                    this.zzf = true;
                    zzbdo zzI = zzI(zzbcfVar);
                    this.zzc = zzI;
                    if (zzI != null) {
                        this.zzc = zzI.zzc("headers: ".concat(zzbcfVar.toString()));
                        this.zzd = zzbcfVar;
                        this.zze = zzG(zzbcfVar);
                        return;
                    }
                    zzH(zzbcfVar);
                    zzg(zzbcfVar);
                }
            }
            zzbdo zzbdoVar2 = this.zzc;
            if (zzbdoVar2 != null) {
                this.zzc = zzbdoVar2.zzc("headers: ".concat(zzbcfVar.toString()));
                this.zzd = zzbcfVar;
                this.zze = zzG(zzbcfVar);
            }
        } catch (Throwable th2) {
            zzbdo zzbdoVar3 = this.zzc;
            if (zzbdoVar3 != null) {
                this.zzc = zzbdoVar3.zzc("headers: ".concat(zzbcfVar.toString()));
                this.zzd = zzbcfVar;
                this.zze = zzG(zzbcfVar);
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzD(zzbcf zzbcfVar) {
        zzbdo zzc;
        zzbdo zzbdoVar = this.zzc;
        if (zzbdoVar == null && !this.zzf) {
            zzbdoVar = zzI(zzbcfVar);
            this.zzc = zzbdoVar;
            if (zzbdoVar != null) {
                this.zzd = zzbcfVar;
            }
        }
        if (zzbdoVar != null) {
            zzbdo zzc2 = zzbdoVar.zzc("trailers: ".concat(zzbcfVar.toString()));
            this.zzc = zzc2;
            zzA(zzc2, false, this.zzd);
            return;
        }
        zzbdo zzbdoVar2 = (zzbdo) zzbcfVar.zzb(zzbat.zzb);
        if (zzbdoVar2 != null) {
            zzc = zzbdoVar2.zzg((String) zzbcfVar.zzb(zzbat.zza));
        } else if (this.zzf) {
            zzc = zzbdo.zzc.zzg("missing GRPC status in response");
        } else {
            Integer num = (Integer) zzbcfVar.zzb(zzb);
            zzc = (num != null ? zzbjd.zza(num.intValue()) : zzbdo.zzo.zzg("missing HTTP status code")).zzc("missing GRPC status, inferred error from HTTP status code");
        }
        zzH(zzbcfVar);
        zzh(zzbcfVar, zzc);
    }
}
