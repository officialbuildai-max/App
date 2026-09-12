package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzje {
    public static final zzje zza = new zzje(null, null, 100);
    private final EnumMap<zza, zzjh> zzb;
    private final int zzc;

    /* loaded from: classes4.dex */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");

        public final String zze;

        zza(String str) {
            this.zze = str;
        }
    }

    public zzje(Boolean bool, Boolean bool2, int i11) {
        EnumMap<zza, zzjh> enumMap = new EnumMap<>((Class<zza>) zza.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap<zza, zzjh>) zza.AD_STORAGE, (zza) zza((Boolean) null));
        enumMap.put((EnumMap<zza, zzjh>) zza.ANALYTICS_STORAGE, (zza) zza((Boolean) null));
        this.zzc = i11;
    }

    private zzje(EnumMap<zza, zzjh> enumMap, int i11) {
        EnumMap<zza, zzjh> enumMap2 = new EnumMap<>((Class<zza>) zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char zza(zzjh zzjhVar) {
        if (zzjhVar == null) {
            return '-';
        }
        int ordinal = zzjhVar.ordinal();
        if (ordinal == 1) {
            return '+';
        }
        if (ordinal != 2) {
            return ordinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static zzje zza(Bundle bundle, int i11) {
        zza[] zzaVarArr;
        if (bundle == null) {
            return new zzje(null, null, i11);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        zzaVarArr = zzjg.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            enumMap.put((EnumMap) zzaVar, (zza) zza(bundle.getString(zzaVar.zze)));
        }
        return new zzje(enumMap, i11);
    }

    public static zzje zza(zzjh zzjhVar, zzjh zzjhVar2, int i11) {
        EnumMap enumMap = new EnumMap(zza.class);
        enumMap.put((EnumMap) zza.AD_STORAGE, (zza) zzjhVar);
        enumMap.put((EnumMap) zza.ANALYTICS_STORAGE, (zza) zzjhVar2);
        return new zzje(enumMap, -10);
    }

    public static zzje zza(String str, int i11) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str == null) {
            str = "";
        }
        zza[] zza2 = zzjg.STORAGE.zza();
        for (int i12 = 0; i12 < zza2.length; i12++) {
            zza zzaVar = zza2[i12];
            int i13 = i12 + 2;
            if (i13 < str.length()) {
                enumMap.put((EnumMap) zzaVar, (zza) zza(str.charAt(i13)));
            } else {
                enumMap.put((EnumMap) zzaVar, (zza) zzjh.UNINITIALIZED);
            }
        }
        return new zzje(enumMap, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjh zza(char c11) {
        return c11 != '+' ? c11 != '0' ? c11 != '1' ? zzjh.UNINITIALIZED : zzjh.GRANTED : zzjh.DENIED : zzjh.POLICY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjh zza(Boolean bool) {
        return bool == null ? zzjh.UNINITIALIZED : bool.booleanValue() ? zzjh.GRANTED : zzjh.DENIED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjh zza(String str) {
        return str == null ? zzjh.UNINITIALIZED : str.equals("granted") ? zzjh.GRANTED : str.equals("denied") ? zzjh.DENIED : zzjh.UNINITIALIZED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(int i11) {
        return i11 != -30 ? i11 != -20 ? i11 != -10 ? i11 != 0 ? i11 != 30 ? i11 != 90 ? i11 != 100 ? "OTHER" : NetworkUtil.NETWORK_TYPE_UNKNOWN : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static String zza(Bundle bundle) {
        zza[] zzaVarArr;
        String string;
        zzaVarArr = zzjg.STORAGE.zzd;
        int length = zzaVarArr.length;
        int i11 = 0;
        while (true) {
            Boolean bool = null;
            if (i11 >= length) {
                return null;
            }
            zza zzaVar = zzaVarArr[i11];
            if (bundle.containsKey(zzaVar.zze) && (string = bundle.getString(zzaVar.zze)) != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
                if (bool == null) {
                    return string;
                }
            }
            i11++;
        }
    }

    public static boolean zza(int i11, int i12) {
        if (i11 == -20 && i12 == -30) {
            return true;
        }
        return (i11 == -30 && i12 == -20) || i11 == i12 || i11 < i12;
    }

    public static zzje zzb(String str) {
        return zza(str, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(zzjh zzjhVar) {
        int ordinal = zzjhVar.ordinal();
        if (ordinal == 2) {
            return "denied";
        }
        if (ordinal != 3) {
            return null;
        }
        return "granted";
    }

    public final boolean equals(Object obj) {
        zza[] zzaVarArr;
        if (!(obj instanceof zzje)) {
            return false;
        }
        zzje zzjeVar = (zzje) obj;
        zzaVarArr = zzjg.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            if (this.zzb.get(zzaVar) != zzjeVar.zzb.get(zzaVar)) {
                return false;
            }
        }
        return this.zzc == zzjeVar.zzc;
    }

    public final int hashCode() {
        int i11 = this.zzc * 17;
        Iterator<zzjh> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            i11 = (i11 * 31) + it.next().hashCode();
        }
        return i11;
    }

    public final String toString() {
        zza[] zzaVarArr;
        StringBuilder sb2 = new StringBuilder("source=");
        sb2.append(zza(this.zzc));
        zzaVarArr = zzjg.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            sb2.append(",");
            sb2.append(zzaVar.zze);
            sb2.append(UrlUtils.EQUAL_MARK);
            zzjh zzjhVar = this.zzb.get(zzaVar);
            if (zzjhVar == null) {
                zzjhVar = zzjh.UNINITIALIZED;
            }
            sb2.append(zzjhVar);
        }
        return sb2.toString();
    }

    public final int zza() {
        return this.zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzje zza(com.google.android.gms.measurement.internal.zzje r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zzje$zza> r1 = com.google.android.gms.measurement.internal.zzje.zza.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzjg r1 = com.google.android.gms.measurement.internal.zzjg.STORAGE
            com.google.android.gms.measurement.internal.zzje$zza[] r1 = com.google.android.gms.measurement.internal.zzjg.zza(r1)
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L4d
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzje$zza, com.google.android.gms.measurement.internal.zzjh> r5 = r8.zzb
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzjh r5 = (com.google.android.gms.measurement.internal.zzjh) r5
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzje$zza, com.google.android.gms.measurement.internal.zzjh> r6 = r9.zzb
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zzjh r6 = (com.google.android.gms.measurement.internal.zzjh) r6
            if (r5 != 0) goto L26
            goto L35
        L26:
            if (r6 != 0) goto L29
            goto L45
        L29:
            com.google.android.gms.measurement.internal.zzjh r7 = com.google.android.gms.measurement.internal.zzjh.UNINITIALIZED
            if (r5 != r7) goto L2e
            goto L35
        L2e:
            if (r6 != r7) goto L31
            goto L45
        L31:
            com.google.android.gms.measurement.internal.zzjh r7 = com.google.android.gms.measurement.internal.zzjh.POLICY
            if (r5 != r7) goto L37
        L35:
            r5 = r6
            goto L45
        L37:
            if (r6 != r7) goto L3a
            goto L45
        L3a:
            com.google.android.gms.measurement.internal.zzjh r7 = com.google.android.gms.measurement.internal.zzjh.DENIED
            if (r5 == r7) goto L44
            if (r6 != r7) goto L41
            goto L44
        L41:
            com.google.android.gms.measurement.internal.zzjh r5 = com.google.android.gms.measurement.internal.zzjh.GRANTED
            goto L45
        L44:
            r5 = r7
        L45:
            if (r5 == 0) goto L4a
            r0.put(r4, r5)
        L4a:
            int r3 = r3 + 1
            goto Lf
        L4d:
            com.google.android.gms.measurement.internal.zzje r9 = new com.google.android.gms.measurement.internal.zzje
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzje.zza(com.google.android.gms.measurement.internal.zzje):com.google.android.gms.measurement.internal.zzje");
    }

    public final boolean zza(zza zzaVar) {
        return this.zzb.get(zzaVar) != zzjh.DENIED;
    }

    public final boolean zza(zzje zzjeVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            if (!zzjeVar.zza(zzaVar) && zza(zzaVar)) {
                return true;
            }
        }
        return false;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry<zza, zzjh> entry : this.zzb.entrySet()) {
            String zzb = zzb(entry.getValue());
            if (zzb != null) {
                bundle.putString(entry.getKey().zze, zzb);
            }
        }
        return bundle;
    }

    public final zzje zzb(zzje zzjeVar) {
        zza[] zzaVarArr;
        EnumMap enumMap = new EnumMap(zza.class);
        zzaVarArr = zzjg.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            zzjh zzjhVar = this.zzb.get(zzaVar);
            if (zzjhVar == zzjh.UNINITIALIZED) {
                zzjhVar = zzjeVar.zzb.get(zzaVar);
            }
            if (zzjhVar != null) {
                enumMap.put((EnumMap) zzaVar, (zza) zzjhVar);
            }
        }
        return new zzje(enumMap, this.zzc);
    }

    public final boolean zzb(zzje zzjeVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            zzjh zzjhVar = this.zzb.get(zzaVar);
            zzjh zzjhVar2 = zzjeVar.zzb.get(zzaVar);
            zzjh zzjhVar3 = zzjh.DENIED;
            if (zzjhVar == zzjhVar3 && zzjhVar2 != zzjhVar3) {
                return true;
            }
        }
        return false;
    }

    public final zzjh zzc() {
        zzjh zzjhVar = this.zzb.get(zza.AD_STORAGE);
        return zzjhVar == null ? zzjh.UNINITIALIZED : zzjhVar;
    }

    public final boolean zzc(zzje zzjeVar) {
        return zzb(zzjeVar, (zza[]) this.zzb.keySet().toArray(new zza[0]));
    }

    public final zzjh zzd() {
        zzjh zzjhVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        return zzjhVar == null ? zzjh.UNINITIALIZED : zzjhVar;
    }

    public final String zze() {
        int ordinal;
        StringBuilder sb2 = new StringBuilder("G1");
        for (zza zzaVar : zzjg.STORAGE.zza()) {
            zzjh zzjhVar = this.zzb.get(zzaVar);
            char c11 = '-';
            if (zzjhVar != null && (ordinal = zzjhVar.ordinal()) != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c11 = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c11 = '1';
            }
            sb2.append(c11);
        }
        return sb2.toString();
    }

    public final String zzf() {
        StringBuilder sb2 = new StringBuilder("G1");
        for (zza zzaVar : zzjg.STORAGE.zza()) {
            sb2.append(zza(this.zzb.get(zzaVar)));
        }
        return sb2.toString();
    }

    public final boolean zzg() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zzh() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzi() {
        Iterator<zzjh> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            if (it.next() != zzjh.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }
}
