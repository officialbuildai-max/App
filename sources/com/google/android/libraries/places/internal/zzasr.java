package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
final class zzasr implements zzavs {
    private final zzasq zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzasr(zzasq zzasqVar) {
        byte[] bArr = zzaud.zzd;
        this.zza = zzasqVar;
        zzasqVar.zzd = this;
    }

    private final void zzP(Object obj, zzavt zzavtVar, zzatf zzatfVar) throws IOException {
        int i11 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzavtVar.zzf(obj, this, zzatfVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzauf.zzg();
            }
        } finally {
            this.zzc = i11;
        }
    }

    private final void zzQ(Object obj, zzavt zzavtVar, zzatf zzatfVar) throws IOException {
        zzasq zzasqVar = this.zza;
        int zzn = zzasqVar.zzn();
        if (zzasqVar.zza >= zzasqVar.zzb) {
            throw new zzauf("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zze = this.zza.zze(zzn);
        this.zza.zza++;
        zzavtVar.zzf(obj, this, zzatfVar);
        this.zza.zzz(0);
        r4.zza--;
        this.zza.zzA(zze);
    }

    private final void zzR(int i11) throws IOException {
        if (this.zza.zzd() != i11) {
            throw zzauf.zzj();
        }
    }

    private final void zzS(int i11) throws IOException {
        if ((this.zzb & 7) != i11) {
            throw zzauf.zza();
        }
    }

    private static final void zzT(int i11) throws IOException {
        if ((i11 & 3) != 0) {
            throw zzauf.zzg();
        }
    }

    private static final void zzU(int i11) throws IOException {
        if ((i11 & 7) != 0) {
            throw zzauf.zzg();
        }
    }

    public static zzasr zzq(zzasq zzasqVar) {
        zzasr zzasrVar = zzasqVar.zzd;
        return zzasrVar != null ? zzasrVar : new zzasr(zzasqVar);
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzA(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzauu) {
            zzauu zzauuVar = (zzauu) list;
            int i12 = this.zzb & 7;
            if (i12 != 1) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzauuVar.zzg(this.zza.zzo());
                } while (this.zza.zzd() < zzd);
                return;
            }
            do {
                zzauuVar.zzg(this.zza.zzo());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 1) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzB(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzatm) {
            zzatm zzatmVar = (zzatm) list;
            int i12 = this.zzb & 7;
            if (i12 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzatmVar.zze(this.zza.zzc());
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i12 != 5) {
                throw zzauf.zza();
            }
            do {
                zzatmVar.zze(this.zza.zzc());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            if (i13 != 5) {
                throw zzauf.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzc()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    @Deprecated
    public final void zzC(List list, zzavt zzavtVar, zzatf zzatfVar) throws IOException {
        int zzm;
        int i11 = this.zzb;
        if ((i11 & 7) != 3) {
            throw zzauf.zza();
        }
        do {
            Object zzc = zzavtVar.zzc();
            zzP(zzc, zzavtVar, zzatfVar);
            zzavtVar.zzd(zzc);
            list.add(zzc);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == i11);
        this.zzd = zzm;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzD(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar = this.zza;
                int zzd = zzasqVar.zzd() + zzasqVar.zzn();
                do {
                    zzatvVar.zzh(this.zza.zzh());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzatvVar.zzh(this.zza.zzh());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 0) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar2 = this.zza;
                int zzd2 = zzasqVar2.zzd() + zzasqVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzE(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzauu) {
            zzauu zzauuVar = (zzauu) list;
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar = this.zza;
                int zzd = zzasqVar.zzd() + zzasqVar.zzn();
                do {
                    zzauuVar.zzg(this.zza.zzp());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzauuVar.zzg(this.zza.zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 0) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar2 = this.zza;
                int zzd2 = zzasqVar2.zzd() + zzasqVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzF(List list, zzavt zzavtVar, zzatf zzatfVar) throws IOException {
        int zzm;
        int i11 = this.zzb;
        if ((i11 & 7) != 2) {
            throw zzauf.zza();
        }
        do {
            Object zzc = zzavtVar.zzc();
            zzQ(zzc, zzavtVar, zzatfVar);
            zzavtVar.zzd(zzc);
            list.add(zzc);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == i11);
        this.zzd = zzm;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzG(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            int i12 = this.zzb & 7;
            if (i12 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzatvVar.zzh(this.zza.zzk());
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i12 != 5) {
                throw zzauf.zza();
            }
            do {
                zzatvVar.zzh(this.zza.zzk());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            if (i13 != 5) {
                throw zzauf.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzk()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzH(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzauu) {
            zzauu zzauuVar = (zzauu) list;
            int i12 = this.zzb & 7;
            if (i12 != 1) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzauuVar.zzg(this.zza.zzt());
                } while (this.zza.zzd() < zzd);
                return;
            }
            do {
                zzauuVar.zzg(this.zza.zzt());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 1) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzt()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzI(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar = this.zza;
                int zzd = zzasqVar.zzd() + zzasqVar.zzn();
                do {
                    zzatvVar.zzh(this.zza.zzl());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzatvVar.zzh(this.zza.zzl());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 0) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar2 = this.zza;
                int zzd2 = zzasqVar2.zzd() + zzasqVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzl()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzJ(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzauu) {
            zzauu zzauuVar = (zzauu) list;
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar = this.zza;
                int zzd = zzasqVar.zzd() + zzasqVar.zzn();
                do {
                    zzauuVar.zzg(this.zza.zzu());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzauuVar.zzg(this.zza.zzu());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 0) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar2 = this.zza;
                int zzd2 = zzasqVar2.zzd() + zzasqVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzu()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    public final void zzK(List list, boolean z10) throws IOException {
        int zzm;
        int i11;
        if ((this.zzb & 7) != 2) {
            throw zzauf.zza();
        }
        if ((list instanceof zzaun) && !z10) {
            zzaun zzaunVar = (zzaun) list;
            do {
                zzaunVar.zzi(zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            do {
                list.add(z10 ? zzs() : zzr());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzL(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar = this.zza;
                int zzd = zzasqVar.zzd() + zzasqVar.zzn();
                do {
                    zzatvVar.zzh(this.zza.zzn());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzatvVar.zzh(this.zza.zzn());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 0) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar2 = this.zza;
                int zzd2 = zzasqVar2.zzd() + zzasqVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzM(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzauu) {
            zzauu zzauuVar = (zzauu) list;
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar = this.zza;
                int zzd = zzasqVar.zzd() + zzasqVar.zzn();
                do {
                    zzauuVar.zzg(this.zza.zzv());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzauuVar.zzg(this.zza.zzv());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 0) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar2 = this.zza;
                int zzd2 = zzasqVar2.zzd() + zzasqVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzv()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final boolean zzO() throws IOException {
        int i11;
        if (this.zza.zzC() || (i11 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i11);
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final int zzc() throws IOException {
        int i11 = this.zzd;
        if (i11 != 0) {
            this.zzb = i11;
            this.zzd = 0;
        } else {
            i11 = this.zza.zzm();
            this.zzb = i11;
        }
        if (i11 == 0 || i11 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i11 >>> 3;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final zzask zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzt(Object obj, zzavt zzavtVar, zzatf zzatfVar) throws IOException {
        zzS(3);
        zzP(obj, zzavtVar, zzatfVar);
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzu(Object obj, zzavt zzavtVar, zzatf zzatfVar) throws IOException {
        zzS(2);
        zzQ(obj, zzavtVar, zzatfVar);
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzv(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzary) {
            zzary zzaryVar = (zzary) list;
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar = this.zza;
                int zzd = zzasqVar.zzd() + zzasqVar.zzn();
                do {
                    zzaryVar.zze(this.zza.zzD());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzaryVar.zze(this.zza.zzD());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 0) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar2 = this.zza;
                int zzd2 = zzasqVar2.zzd() + zzasqVar2.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzD()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzw(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) != 2) {
            throw zzauf.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzx(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzasz) {
            zzasz zzaszVar = (zzasz) list;
            int i12 = this.zzb & 7;
            if (i12 != 1) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzaszVar.zze(this.zza.zzb());
                } while (this.zza.zzd() < zzd);
                return;
            }
            do {
                zzaszVar.zze(this.zza.zzb());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 1) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            do {
                list.add(Double.valueOf(this.zza.zzb()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzy(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar = this.zza;
                int zzd = zzasqVar.zzd() + zzasqVar.zzn();
                do {
                    zzatvVar.zzh(this.zza.zzf());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzatvVar.zzh(this.zza.zzf());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 != 0) {
                if (i13 != 2) {
                    throw zzauf.zza();
                }
                zzasq zzasqVar2 = this.zza;
                int zzd2 = zzasqVar2.zzd() + zzasqVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzavs
    public final void zzz(List list) throws IOException {
        int zzm;
        int i11;
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            int i12 = this.zzb & 7;
            if (i12 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzatvVar.zzh(this.zza.zzg());
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i12 != 5) {
                throw zzauf.zza();
            }
            do {
                zzatvVar.zzh(this.zza.zzg());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i11 = this.zza.zzm();
                }
            } while (i11 == this.zzb);
        } else {
            int i13 = this.zzb & 7;
            if (i13 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            if (i13 != 5) {
                throw zzauf.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i11 = zzm;
        }
        this.zzd = i11;
    }
}
