package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.common.Sj;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.utils.Mts;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class EjP {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile EjP Sj;
    private final Map<sU, Long> EjP = Collections.synchronizedMap(new HashMap());
    private final Sj.sP TKC;
    private final Context sP;

    private EjP(Context context) {
        this.sP = context == null ? dNu.Sj() : context.getApplicationContext();
        this.TKC = new Sj.sP("sp_full_screen_video");
    }

    public static EjP Sj(Context context) {
        if (Sj == null) {
            synchronized (EjP.class) {
                try {
                    if (Sj == null) {
                        Sj = new EjP(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return Sj;
    }

    private File Sj(String str, int i11) {
        return new File(CacheDirFactory.getICacheDir(i11).Sj(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(final boolean z10, final sU sUVar, final long j11, String str) {
        Long remove = this.EjP.remove(sUVar);
        final long elapsedRealtime = remove == null ? 0L : SystemClock.elapsedRealtime() - remove.longValue();
        final String str2 = z10 ? "load_video_success" : "load_video_error";
        final String str3 = (z10 || str == null) ? null : str;
        com.bytedance.sdk.openadsdk.Zq.TKC.Sj(str2, false, new com.bytedance.sdk.openadsdk.Zq.sP() { // from class: com.bytedance.sdk.openadsdk.component.reward.EjP.3
            @Override // com.bytedance.sdk.openadsdk.Zq.sP
            @Nullable
            public com.bytedance.sdk.openadsdk.Zq.Sj.TKC getLogStats() throws Exception {
                return com.bytedance.sdk.openadsdk.Zq.Sj.EjP.sP().Sj(str2).sP(Mts.Sj(z10, sUVar, elapsedRealtime, j11, str3).toString());
            }
        });
    }

    private boolean sP(sU sUVar) {
        if (sUVar != null) {
            return uP.TKC(sUVar) || sUVar.UHs() != null;
        }
        return false;
    }

    public com.bytedance.sdk.openadsdk.core.model.Sj Sj(String str, boolean z10) {
        com.bytedance.sdk.openadsdk.core.model.Sj sj2;
        if (com.bytedance.sdk.openadsdk.common.Sj.Sj()) {
            com.bytedance.sdk.openadsdk.common.Sj Sj2 = com.bytedance.sdk.openadsdk.common.Sj.Sj("sp_full_screen_video");
            com.bytedance.sdk.openadsdk.core.model.Sj Sj3 = Sj2.Sj(str, 10500000L);
            if (z10 && Sj3 != null && HiB.sP() == 2 && Sj2.TKC(str)) {
                return null;
            }
            return Sj3;
        }
        long HiB = this.TKC.HiB(str);
        boolean vS = this.TKC.vS(str);
        boolean Dq = this.TKC.Dq(str);
        int sP = HiB.sP();
        if (System.currentTimeMillis() - HiB < 10500000 && !vS && (!z10 || sP != 2 || !Dq)) {
            try {
                String sP2 = this.TKC.sP(str);
                if (!TextUtils.isEmpty(sP2)) {
                    JSONObject jSONObject = new JSONObject(sP2);
                    if (jSONObject.has("cypher")) {
                        jSONObject = dNu.TKC().Sj(jSONObject);
                    }
                    if (jSONObject.has("creatives")) {
                        sj2 = com.bytedance.sdk.openadsdk.core.model.Sj.TKC(jSONObject);
                    } else {
                        sU Sj4 = com.bytedance.sdk.openadsdk.core.sP.Sj(jSONObject);
                        com.bytedance.sdk.openadsdk.core.model.Sj sj3 = new com.bytedance.sdk.openadsdk.core.model.Sj();
                        sj3.Sj(Sj4);
                        sj2 = sj3;
                    }
                    if (sj2 != null && sj2.HiB()) {
                        Iterator<sU> it = sj2.EjP().iterator();
                        while (it.hasNext()) {
                            if (!sP(it.next())) {
                                it.remove();
                            }
                        }
                        if (sj2.HiB()) {
                            return sj2;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String Sj(sU sUVar) {
        if (com.bytedance.sdk.openadsdk.common.Sj.Sj()) {
            return com.bytedance.sdk.openadsdk.common.Sj.Sj("sp_full_screen_video").Sj(sUVar);
        }
        if (sUVar == null || sUVar.UHs() == null || TextUtils.isEmpty(sUVar.UHs().x())) {
            return null;
        }
        return Sj(sUVar.UHs().x(), sUVar.UHs().G(), sUVar.Gn());
    }

    public String Sj(String str, String str2, int i11) {
        if (com.bytedance.sdk.openadsdk.common.Sj.Sj()) {
            return com.bytedance.sdk.openadsdk.common.Sj.Sj("sp_full_screen_video").Sj(str, str2, i11);
        }
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

    public void Sj() {
        File[] listFiles;
        File file;
        File[] listFiles2;
        File dataDir;
        if (com.bytedance.sdk.openadsdk.common.Sj.Sj()) {
            com.bytedance.sdk.openadsdk.common.Sj.Sj("sp_full_screen_video").sP();
            return;
        }
        try {
            int i11 = Build.VERSION.SDK_INT;
            boolean Jcg = com.bytedance.sdk.openadsdk.core.uA.Jcg("sp_full_screen_video");
            String str = Jcg ? "files" : "shared_prefs";
            if (i11 >= 24) {
                dataDir = this.sP.getDataDir();
                file = new File(dataDir, str);
            } else {
                file = new File(this.sP.getDatabasePath("1").getParentFile().getParentFile(), str);
            }
            if (file.exists() && file.isDirectory() && (listFiles2 = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.EjP.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains("sp_full_screen_video");
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : listFiles2) {
                    if (Jcg) {
                        try {
                            com.bytedance.sdk.component.utils.Jcg.TKC(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        String replace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.sP.deleteSharedPreferences(replace);
                        } else {
                            this.sP.getSharedPreferences(replace, 0).edit().clear().apply();
                            com.bytedance.sdk.component.utils.Jcg.TKC(file2);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File cacheDir = this.sP.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (listFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.EjP.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3 != null) {
                        return file3.getName().contains("full_screen_video_cache");
                    }
                    return false;
                }
            })) == null) {
                return;
            }
            for (File file3 : listFiles) {
                try {
                    com.bytedance.sdk.component.utils.Jcg.TKC(file3);
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public void Sj(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Sj sj2) {
        sU vS;
        if (sj2 == null || sj2.vS() == null || !sj2.vS().ODI()) {
            if (com.bytedance.sdk.openadsdk.common.Sj.Sj()) {
                com.bytedance.sdk.openadsdk.common.Sj.Sj("sp_full_screen_video").Sj(adSlot, sj2);
                return;
            }
            if (sj2 == null || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (vS = sj2.vS()) == null || vS.DSn() == 2) {
                return;
            }
            try {
                this.TKC.Sj(adSlot, sj2.Fmk().toString(), sj2.sP());
            } catch (Throwable unused) {
            }
        }
    }

    public void Sj(final sU sUVar, final Sj.InterfaceC0255Sj<Object> interfaceC0255Sj) {
        if (!com.bytedance.sdk.openadsdk.core.aa.HiB.Sj.Sj()) {
            interfaceC0255Sj.Sj(true, null);
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.Sj.Sj()) {
            com.bytedance.sdk.openadsdk.common.Sj.Sj("sp_full_screen_video").Sj(sUVar, interfaceC0255Sj);
            return;
        }
        this.EjP.put(sUVar, Long.valueOf(SystemClock.elapsedRealtime()));
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
            EjP.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.component.reward.EjP.4
                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, com.bytedance.sdk.component.Jcg.sP sPVar) {
                    if (sPVar.vS() && sPVar.HiB() != null && sPVar.HiB().exists()) {
                        Sj.InterfaceC0255Sj interfaceC0255Sj2 = interfaceC0255Sj;
                        if (interfaceC0255Sj2 != null) {
                            interfaceC0255Sj2.Sj(true, null);
                        }
                        EjP.this.Sj(true, sUVar, sPVar.Sj(), sPVar.sP());
                        return;
                    }
                    Sj.InterfaceC0255Sj interfaceC0255Sj3 = interfaceC0255Sj;
                    if (interfaceC0255Sj3 != null) {
                        interfaceC0255Sj3.Sj(false, null);
                    }
                    EjP.this.Sj(false, sUVar, sPVar.Sj(), sPVar.sP());
                }

                @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
                    Sj.InterfaceC0255Sj interfaceC0255Sj2 = interfaceC0255Sj;
                    if (interfaceC0255Sj2 != null) {
                        interfaceC0255Sj2.Sj(false, null);
                    }
                    EjP.this.Sj(false, sUVar, -2L, iOException.getMessage());
                }
            });
        }
    }

    public void Sj(String str) {
        if (com.bytedance.sdk.openadsdk.common.Sj.Sj()) {
            com.bytedance.sdk.openadsdk.common.Sj.Sj("sp_full_screen_video").sP(str);
        } else {
            this.TKC.Jcg(str);
        }
    }

    public void Sj(String str, sU sUVar) {
        if (com.bytedance.sdk.openadsdk.common.Sj.Sj()) {
            com.bytedance.sdk.openadsdk.common.Sj.Sj("sp_full_screen_video").Sj(str, sUVar);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String TKC = this.TKC.TKC(str);
        String cKW = sUVar != null ? sUVar.cKW() : "";
        if (TextUtils.isEmpty(TKC) || TextUtils.isEmpty(cKW) || TKC.equals(cKW)) {
            this.TKC.uA(str);
        }
    }
}
