package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* loaded from: classes4.dex */
public final class zzbge extends zzbeg {
    private static final zzbgc zza = new zzbfx();
    private static final zzbgc zzb = new zzbfy();
    private static final zzbgc zzc = new zzbfz();
    private static final zzbgc zzd = new zzbga();
    private static final zzbgd zze = new zzbgb();
    private final Deque zzf;
    private Deque zzg;
    private int zzh;
    private final Queue zzi;
    private boolean zzj;

    public zzbge() {
        this.zzi = new ArrayDeque(2);
        this.zzf = new ArrayDeque();
    }

    public zzbge(int i11) {
        this.zzi = new ArrayDeque(2);
        this.zzf = new ArrayDeque(i11);
    }

    private final int zzm(zzbgd zzbgdVar, int i11, Object obj, int i12) throws IOException {
        zza(i11);
        if (!this.zzf.isEmpty()) {
            zzp();
        }
        while (i11 > 0 && !this.zzf.isEmpty()) {
            zzbnv zzbnvVar = (zzbnv) this.zzf.peek();
            int min = Math.min(i11, zzbnvVar.zzf());
            i12 = zzbgdVar.zza(zzbnvVar, min, obj, i12);
            i11 -= min;
            this.zzh -= min;
            zzp();
        }
        if (i11 <= 0) {
            return i12;
        }
        throw new AssertionError("Failed executing read operation");
    }

    private final int zzn(zzbgc zzbgcVar, int i11, Object obj, int i12) {
        try {
            return zzm(zzbgcVar, i11, obj, i12);
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    private final void zzo() {
        if (!this.zzj) {
            ((zzbnv) this.zzf.remove()).close();
            return;
        }
        this.zzg.add((zzbnv) this.zzf.remove());
        zzbnv zzbnvVar = (zzbnv) this.zzf.peek();
        if (zzbnvVar != null) {
            zzbnvVar.zzb();
        }
    }

    private final void zzp() {
        if (((zzbnv) this.zzf.peek()).zzf() == 0) {
            zzo();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbeg, com.google.android.libraries.places.internal.zzbnv, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        while (!this.zzf.isEmpty()) {
            ((zzbnv) this.zzf.remove()).close();
        }
        if (this.zzg != null) {
            while (!this.zzg.isEmpty()) {
                ((zzbnv) this.zzg.remove()).close();
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbeg, com.google.android.libraries.places.internal.zzbnv
    public final void zzb() {
        if (this.zzg == null) {
            this.zzg = new ArrayDeque(Math.min(this.zzf.size(), 16));
        }
        while (!this.zzg.isEmpty()) {
            ((zzbnv) this.zzg.remove()).close();
        }
        this.zzj = true;
        zzbnv zzbnvVar = (zzbnv) this.zzf.peek();
        if (zzbnvVar != null) {
            zzbnvVar.zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbeg, com.google.android.libraries.places.internal.zzbnv
    public final void zzc() {
        if (!this.zzj) {
            throw new InvalidMarkException();
        }
        zzbnv zzbnvVar = (zzbnv) this.zzf.peek();
        if (zzbnvVar != null) {
            int zzf = zzbnvVar.zzf();
            zzbnvVar.zzc();
            this.zzh += zzbnvVar.zzf() - zzf;
        }
        while (true) {
            zzbnv zzbnvVar2 = (zzbnv) this.zzg.pollLast();
            if (zzbnvVar2 == null) {
                return;
            }
            zzbnvVar2.zzc();
            this.zzf.addFirst(zzbnvVar2);
            this.zzh += zzbnvVar2.zzf();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbeg, com.google.android.libraries.places.internal.zzbnv
    public final boolean zzd() {
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            if (!((zzbnv) it.next()).zzd()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final int zze() {
        return zzn(zza, 1, null, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final int zzf() {
        return this.zzh;
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final zzbnv zzg(int i11) {
        zzbnv zzbnvVar;
        int i12;
        zzbnv zzbnvVar2;
        if (i11 <= 0) {
            return zzbny.zza();
        }
        zza(i11);
        this.zzh -= i11;
        zzbnv zzbnvVar3 = null;
        zzbge zzbgeVar = null;
        while (true) {
            zzbnv zzbnvVar4 = (zzbnv) this.zzf.peek();
            int zzf = zzbnvVar4.zzf();
            if (zzf > i11) {
                zzbnvVar2 = zzbnvVar4.zzg(i11);
                i12 = 0;
            } else {
                if (this.zzj) {
                    zzbnvVar = zzbnvVar4.zzg(zzf);
                    zzo();
                } else {
                    zzbnvVar = (zzbnv) this.zzf.poll();
                }
                zzbnv zzbnvVar5 = zzbnvVar;
                i12 = i11 - zzf;
                zzbnvVar2 = zzbnvVar5;
            }
            if (zzbnvVar3 == null) {
                zzbnvVar3 = zzbnvVar2;
            } else {
                if (zzbgeVar == null) {
                    zzbgeVar = new zzbge(i12 != 0 ? Math.min(this.zzf.size() + 2, 16) : 2);
                    zzbgeVar.zzh(zzbnvVar3);
                    zzbnvVar3 = zzbgeVar;
                }
                zzbgeVar.zzh(zzbnvVar2);
            }
            if (i12 <= 0) {
                return zzbnvVar3;
            }
            i11 = i12;
        }
    }

    public final void zzh(zzbnv zzbnvVar) {
        boolean z10 = this.zzj && this.zzf.isEmpty();
        if (zzbnvVar instanceof zzbge) {
            zzbge zzbgeVar = (zzbge) zzbnvVar;
            while (!zzbgeVar.zzf.isEmpty()) {
                this.zzf.add((zzbnv) zzbgeVar.zzf.remove());
            }
            this.zzh += zzbgeVar.zzh;
            zzbgeVar.zzh = 0;
            zzbgeVar.close();
        } else {
            this.zzf.add(zzbnvVar);
            this.zzh += zzbnvVar.zzf();
        }
        if (z10) {
            ((zzbnv) this.zzf.peek()).zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzi(ByteBuffer byteBuffer) {
        zzn(zzd, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzj(OutputStream outputStream, int i11) throws IOException {
        zzm(zze, i11, outputStream, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzk(byte[] bArr, int i11, int i12) {
        zzn(zzc, i12, bArr, i11);
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzl(int i11) {
        zzn(zzb, i11, null, 0);
    }
}
