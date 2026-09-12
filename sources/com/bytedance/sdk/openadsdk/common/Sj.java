package com.bytedance.sdk.openadsdk.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.dx;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.utils.Mts;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Sj {
    private static final HashMap<String, Sj> Sj = new HashMap<>();
    private static final HashMap<String, sP> sP = new HashMap<>();
    private final sP EjP;
    private final String HiB;

    @SuppressLint({"StaticFieldLeak"})
    private final Context TKC;
    private final Map<sU, Long> vS = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.bytedance.sdk.openadsdk.common.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0255Sj<T> {
        void Sj(boolean z10, T t11);
    }

    /* loaded from: classes2.dex */
    public static class sP {
        protected final String Sj;
        private final HashSet<String> Dq = new HashSet<>();
        String sP = "material_data";
        String TKC = "has_played";
        String EjP = "create_time";
        String HiB = "in_use_process";
        String vS = "req_id";
        String Jcg = "ad_slot";

        public sP(String str) {
            this.Sj = TextUtils.isEmpty(str) ? "" : str;
        }

        public boolean Dq(String str) {
            String Sj;
            String sP;
            try {
                Sj = Sj(str);
                sP = com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP(Sj, this.HiB, "");
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(sP)) {
                return false;
            }
            if (sP.equals(dx.sP(com.bytedance.sdk.openadsdk.core.dNu.Sj())) && !this.Dq.contains(str)) {
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj, this.HiB, "");
                return false;
            }
            return true;
        }

        public String EjP(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP(Sj(str), this.Jcg, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public long HiB(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj(str), this.EjP, 0L);
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public void Jcg(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj(str), this.HiB, dx.sP(com.bytedance.sdk.openadsdk.core.dNu.Sj()));
                this.Dq.add(str);
            } catch (Throwable unused) {
            }
        }

        protected String Sj(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.Sj + "_cache_" + str;
        }

        public void Sj(AdSlot adSlot, String str, String str2) {
            try {
                String codeId = adSlot.getCodeId();
                String Sj = Sj(codeId);
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj, this.TKC, Boolean.FALSE);
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj, this.EjP, Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj, this.sP, str);
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj, this.HiB, "");
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj, this.vS, str2);
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj, this.Jcg, adSlot.toJsonObj().toString());
                this.Dq.remove(codeId);
            } catch (Throwable unused) {
            }
        }

        public String TKC(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP(Sj(str), this.vS, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public String sP(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP(Sj(str), this.sP, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public void uA(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj(str));
                this.Dq.remove(str);
            } catch (Throwable unused) {
            }
        }

        public boolean vS(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(Sj(str), this.TKC, true);
            } catch (Throwable unused) {
                return true;
            }
        }
    }

    private Sj(Context context, String str) {
        this.TKC = context;
        sP sPVar = sP.get(str);
        this.EjP = sPVar == null ? new sP(str) : sPVar;
        this.HiB = str;
    }

    public static Sj Sj(String str) {
        Sj sj2;
        HashMap<String, Sj> hashMap = Sj;
        Sj sj3 = hashMap.get(str);
        if (sj3 != null) {
            return sj3;
        }
        synchronized (Sj.class) {
            try {
                sj2 = hashMap.get(str);
                if (sj2 == null) {
                    sj2 = new Sj(com.bytedance.sdk.openadsdk.core.dNu.Sj(), str);
                    hashMap.put(str, sj2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return sj2;
    }

    private File Sj(String str, int i11) {
        return new File(CacheDirFactory.getICacheDir(i11).Sj(), str);
    }

    public static void Sj(String str, sP sPVar) {
        sP.put(str, sPVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(final boolean z10, final sU sUVar, final long j11, String str) {
        Long remove = this.vS.remove(sUVar);
        final long elapsedRealtime = remove == null ? 0L : SystemClock.elapsedRealtime() - remove.longValue();
        final String str2 = z10 ? "load_video_success" : "load_video_error";
        final String str3 = (z10 || str == null) ? null : str;
        com.bytedance.sdk.openadsdk.Zq.TKC.Sj(str2, false, new com.bytedance.sdk.openadsdk.Zq.sP() { // from class: com.bytedance.sdk.openadsdk.common.Sj.2
            @Override // com.bytedance.sdk.openadsdk.Zq.sP
            @Nullable
            public com.bytedance.sdk.openadsdk.Zq.Sj.TKC getLogStats() throws Exception {
                return com.bytedance.sdk.openadsdk.Zq.Sj.EjP.sP().Sj(str2).sP(Mts.Sj(z10, sUVar, elapsedRealtime, j11, str3).toString());
            }
        });
    }

    public static boolean Sj() {
        return com.bytedance.sdk.openadsdk.dx.Sj.Sj("material_cache_disk_format", 0) == 1;
    }

    private String TKC() {
        return CacheDirFactory.getICacheDir(0).Sj();
    }

    private boolean sP(sU sUVar) {
        if (sUVar != null) {
            return uP.TzV(sUVar) || sUVar.UHs() != null;
        }
        return false;
    }

    public com.bytedance.sdk.openadsdk.core.model.Sj Sj(String str, long j11) {
        long HiB = this.EjP.HiB(str);
        boolean vS = this.EjP.vS(str);
        if (System.currentTimeMillis() - HiB >= j11 || vS) {
            return null;
        }
        return Sj(str, true);
    }

    public com.bytedance.sdk.openadsdk.core.model.Sj Sj(String str, boolean z10) {
        com.bytedance.sdk.openadsdk.core.model.Sj sj2;
        AdSlot sP2;
        sU vS;
        try {
            String sP3 = this.EjP.sP(str);
            if (!TextUtils.isEmpty(sP3)) {
                JSONObject jSONObject = new JSONObject(sP3);
                if (jSONObject.has("cypher")) {
                    jSONObject = com.bytedance.sdk.openadsdk.core.dNu.TKC().Sj(jSONObject);
                }
                if (jSONObject.has("creatives")) {
                    sj2 = com.bytedance.sdk.openadsdk.core.model.Sj.TKC(jSONObject);
                } else {
                    sU Sj2 = com.bytedance.sdk.openadsdk.core.sP.Sj(jSONObject);
                    com.bytedance.sdk.openadsdk.core.model.Sj sj3 = new com.bytedance.sdk.openadsdk.core.model.Sj();
                    sj3.Sj(Sj2);
                    sj2 = sj3;
                }
                if (sj2 != null && sj2.HiB()) {
                    if (z10) {
                        Iterator<sU> it = sj2.EjP().iterator();
                        while (it.hasNext()) {
                            if (!sP(it.next())) {
                                it.remove();
                            }
                        }
                    }
                    if (sj2.HiB()) {
                        String EjP = this.EjP.EjP(str);
                        if (!TextUtils.isEmpty(EjP) && (sP2 = com.bytedance.sdk.openadsdk.core.sP.sP(new JSONObject(EjP))) != null && (vS = sj2.vS()) != null) {
                            vS.Sj(sP2);
                        }
                        return sj2;
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public String Sj(sU sUVar) {
        if (sUVar == null || sUVar.UHs() == null || TextUtils.isEmpty(sUVar.UHs().x())) {
            return null;
        }
        return Sj(sUVar.UHs().x(), sUVar.UHs().G(), sUVar.Gn());
    }

    public String Sj(String str, String str2, int i11) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.component.utils.HiB.Sj(str);
        }
        File Sj2 = Sj(str2, i11);
        if (Sj2 == null || !Sj2.exists() || !Sj2.isFile() || Sj2.length() <= 0) {
            return null;
        }
        return Sj2.getAbsolutePath();
    }

    public void Sj(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Sj sj2) {
        sU vS;
        if ((sj2 != null && sj2.vS() != null && sj2.vS().ODI()) || sj2 == null || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (vS = sj2.vS()) == null || vS.DSn() == 2) {
            return;
        }
        try {
            this.EjP.Sj(adSlot, sj2.sef(), sj2.sP());
        } catch (Throwable unused) {
        }
    }

    public void Sj(final sU sUVar, final InterfaceC0255Sj<Object> interfaceC0255Sj) {
        this.vS.put(sUVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (sUVar.UHs() == null || TextUtils.isEmpty(sUVar.UHs().x())) {
            if (interfaceC0255Sj != null) {
                interfaceC0255Sj.Sj(false, null);
            }
            Sj(false, sUVar, -1L, null);
        } else {
            String x10 = sUVar.UHs().x();
            File Sj2 = Sj(sUVar.UHs().G(), sUVar.Gn());
            com.bytedance.sdk.component.Jcg.sP.Sj EjP = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().EjP();
            EjP.sP(x10);
            EjP.Sj(Sj2.getParent(), Sj2.getName());
            EjP.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.common.Sj.3
                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, com.bytedance.sdk.component.Jcg.sP sPVar) {
                    if (sPVar.vS() && sPVar.HiB() != null && sPVar.HiB().exists()) {
                        InterfaceC0255Sj interfaceC0255Sj2 = interfaceC0255Sj;
                        if (interfaceC0255Sj2 != null) {
                            interfaceC0255Sj2.Sj(true, null);
                        }
                        Sj.this.Sj(true, sUVar, sPVar.Sj(), sPVar.sP());
                        return;
                    }
                    InterfaceC0255Sj interfaceC0255Sj3 = interfaceC0255Sj;
                    if (interfaceC0255Sj3 != null) {
                        interfaceC0255Sj3.Sj(false, null);
                    }
                    Sj.this.Sj(false, sUVar, sPVar.Sj(), sPVar.sP());
                }

                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
                    InterfaceC0255Sj interfaceC0255Sj2 = interfaceC0255Sj;
                    if (interfaceC0255Sj2 != null) {
                        interfaceC0255Sj2.Sj(false, null);
                    }
                    Sj.this.Sj(false, sUVar, -2L, iOException.getMessage());
                }
            });
        }
    }

    public void Sj(String str, sU sUVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String TKC = this.EjP.TKC(str);
        String cKW = sUVar != null ? sUVar.cKW() : "";
        if (TextUtils.isEmpty(TKC) || TextUtils.isEmpty(cKW) || TKC.equals(cKW)) {
            this.EjP.uA(str);
        }
    }

    public boolean TKC(String str) {
        return this.EjP.Dq(str);
    }

    public void sP() {
        File file;
        File[] listFiles;
        File dataDir;
        try {
            int i11 = Build.VERSION.SDK_INT;
            boolean Jcg = com.bytedance.sdk.openadsdk.core.uA.Jcg(this.HiB);
            String str = Jcg ? "files" : "shared_prefs";
            if (i11 >= 24) {
                dataDir = this.TKC.getDataDir();
                file = new File(dataDir, str);
            } else {
                file = new File(this.TKC.getDatabasePath("1").getParentFile().getParentFile(), str);
            }
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.common.Sj.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains(Sj.this.HiB);
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : listFiles) {
                    if (Jcg) {
                        try {
                            com.bytedance.sdk.component.utils.Jcg.TKC(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        String replace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.TKC.deleteSharedPreferences(replace);
                        } else {
                            this.TKC.getSharedPreferences(replace, 0).edit().clear().apply();
                            com.bytedance.sdk.component.utils.Jcg.TKC(file2);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File file3 = new File(TKC());
            if (file3.exists() && file3.isDirectory()) {
                com.bytedance.sdk.component.utils.Jcg.TKC(file3);
            }
        } catch (Throwable unused3) {
        }
    }

    public void sP(String str) {
        this.EjP.Jcg(str);
    }
}
