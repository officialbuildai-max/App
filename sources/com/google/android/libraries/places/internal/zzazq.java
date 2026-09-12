package com.google.android.libraries.places.internal;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzazq {
    static final zzmh zza = zzmh.zzb(',');
    private static final zzazq zzb = new zzazq(zzaza.zza, false, new zzazq(new zzayz(), true, new zzazq()));
    private final Map zzc;
    private final byte[] zzd;

    private zzazq() {
        this.zzc = new LinkedHashMap(0);
        this.zzd = new byte[0];
    }

    private zzazq(zzazo zzazoVar, boolean z10, zzazq zzazqVar) {
        String zzb2 = zzazoVar.zzb();
        zzmt.zzf(!zzb2.contains(","), "Comma is currently not allowed in message encoding");
        int size = zzazqVar.zzc.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(zzazqVar.zzc.containsKey(zzazoVar.zzb()) ? size : size + 1);
        for (zzazp zzazpVar : zzazqVar.zzc.values()) {
            String zzb3 = zzazpVar.zza.zzb();
            if (!zzb3.equals(zzb2)) {
                linkedHashMap.put(zzb3, new zzazp(zzazpVar.zza, zzazpVar.zzb));
            }
        }
        linkedHashMap.put(zzb2, new zzazp(zzazoVar, z10));
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.zzc = unmodifiableMap;
        zzmh zzmhVar = zza;
        HashSet hashSet = new HashSet(unmodifiableMap.size());
        for (Map.Entry entry : unmodifiableMap.entrySet()) {
            if (((zzazp) entry.getValue()).zzb) {
                hashSet.add((String) entry.getKey());
            }
        }
        this.zzd = zzmhVar.zzf(Collections.unmodifiableSet(hashSet)).getBytes(Charset.forName(C.ASCII_NAME));
    }

    public static zzazq zzb() {
        return zzb;
    }

    public final zzazo zza(String str) {
        zzazp zzazpVar = (zzazp) this.zzc.get(str);
        if (zzazpVar != null) {
            return zzazpVar.zza;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzc() {
        return this.zzd;
    }
}
