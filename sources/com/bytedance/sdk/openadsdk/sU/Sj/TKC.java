package com.bytedance.sdk.openadsdk.sU.Sj;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.Dq.Dq;
import com.bytedance.sdk.component.utils.LD;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.component.utils.uvD;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.sef;
import com.bytedance.sdk.openadsdk.core.settings.uA;
import com.bytedance.sdk.openadsdk.sU.sP.Sj;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.miniutils.constant.TimeConstants;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class TKC {
    private static volatile TKC Sj;
    private String EjP;
    private final Set<String> HiB = Collections.synchronizedSet(new HashSet());
    private String TKC;
    private String sP;

    private String EjP() {
        if (TextUtils.isEmpty(this.sP)) {
            try {
                File file = new File(dNu.Sj().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.sP = file.getAbsolutePath();
            } catch (Throwable th2) {
                sU.sP("PlayableResManager", "init root path error: ".concat(String.valueOf(th2)));
            }
        }
        return this.sP;
    }

    private String HiB() {
        if (TextUtils.isEmpty(this.TKC)) {
            String str = EjP() + File.separator + "common";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.TKC = str;
        }
        return this.TKC;
    }

    public static TKC Sj() {
        if (Sj == null) {
            synchronized (TKC.class) {
                try {
                    if (Sj == null) {
                        Sj = new TKC();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return Sj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sj(com.bytedance.sdk.openadsdk.sU.sP.Sj sj2, @Nullable com.bytedance.sdk.openadsdk.sU.sP.Sj sj3, int i11) {
        List<Sj.C0297Sj> list = null;
        Sj(sj2.sP(), sj3 == null ? null : sj3.sP(), 1, i11);
        List<Sj.C0297Sj> TKC = sj2.TKC();
        if (sj3 != null) {
            list = sj3.TKC();
        }
        Sj(TKC, list, 2, i11);
    }

    private void Sj(final String str, final String str2, final String str3, final int i11, final File file, final boolean z10) {
        String concat;
        if (this.HiB.contains(str)) {
            return;
        }
        if (i11 == 2) {
            concat = str3 + ".zip";
        } else {
            concat = z10 ? "tmp".concat(String.valueOf(str3)) : str3;
        }
        this.HiB.add(str);
        com.bytedance.sdk.component.Jcg.sP.Sj EjP = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().EjP();
        EjP.sP(str);
        EjP.Sj(str2, concat);
        final com.bytedance.sdk.component.Jcg.sP Sj2 = EjP.Sj();
        this.HiB.remove(str);
        if (Sj2 != null && Sj2.vS() && Sj2.HiB() != null && Sj2.HiB().exists()) {
            if (i11 == 2) {
                JcM.sP(new Dq("downloadZip") { // from class: com.bytedance.sdk.openadsdk.sU.Sj.TKC.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (z10) {
                                file.delete();
                            }
                            String str4 = str2 + File.separator + str3;
                            LD.Sj(Sj2.HiB().getAbsolutePath(), str4);
                            File file2 = new File(str4);
                            File Sj3 = com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.Sj(file2);
                            if (Sj3 != null && Sj3.exists()) {
                                com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.Sj().TKC().put(file2.getName(), Sj3.getAbsolutePath());
                            }
                            com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.sP(file2);
                        } catch (Throwable th2) {
                            sU.sP("PlayableResManager", "unzip error: ", th2, "tp=", Integer.valueOf(i11), ", url=", str);
                        }
                        try {
                            Sj2.HiB().delete();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            } else {
                if (z10) {
                    file.delete();
                    Sj2.HiB().renameTo(file);
                    return;
                }
                return;
            }
        }
        File file2 = new File(str2 + File.separator + str3 + ".tmp");
        if (file2.exists()) {
            try {
                file2.delete();
            } catch (Throwable unused) {
            }
        }
    }

    private void Sj(@Nullable List<Sj.C0297Sj> list, @Nullable List<Sj.C0297Sj> list2, int i11, int i12) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String HiB = i11 == 1 ? HiB() : vS();
        for (Sj.C0297Sj c0297Sj : list) {
            String Sj2 = c0297Sj.Sj();
            String Sj3 = uvD.Sj(Sj2);
            if (!TextUtils.isEmpty(Sj3)) {
                if (i11 == 1) {
                    Sj3 = Sj3 + TKC(Sj2);
                }
                String str = Sj3;
                File file = new File(HiB, str);
                boolean exists = file.exists();
                if (i12 == 1) {
                    if (exists && list2 != null && list2.contains(c0297Sj)) {
                        com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.TKC(file);
                    }
                    Sj(Sj2, HiB, str, i11, file, exists);
                } else if (!exists) {
                    Sj(Sj2, HiB, str, i11, file, exists);
                }
            }
        }
    }

    private static String TKC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(UrlUtils.QUESTION_MARK);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return "." + str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TKC() {
        JcM.Sj(new Dq("pag_plb_res_check") { // from class: com.bytedance.sdk.openadsdk.sU.Sj.TKC.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.sU.sP.Sj sP = com.bytedance.sdk.openadsdk.sU.sP.Sj.sP(com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP("pag_plb_config", "model", ""));
                if (sP != null) {
                    TKC.this.Sj(sP, null, 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(final String str) {
        JcM.Sj(new Dq("pag_plb_update_config") { // from class: com.bytedance.sdk.openadsdk.sU.Sj.TKC.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.Jcg.sP.sP TKC = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().TKC();
                try {
                    TKC.sP(com.bytedance.sdk.openadsdk.Dq.EjP.Sj(TKC, str));
                    com.bytedance.sdk.component.Jcg.sP Sj2 = TKC.Sj();
                    if (Sj2 == null || !Sj2.vS()) {
                        return;
                    }
                    String EjP = Sj2.EjP();
                    com.bytedance.sdk.openadsdk.sU.sP.Sj sP = com.bytedance.sdk.openadsdk.sU.sP.Sj.sP(EjP);
                    com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("pag_plb_config", "last_update_time", Long.valueOf(System.currentTimeMillis()));
                    if (sP != null) {
                        com.bytedance.sdk.openadsdk.sU.sP.Sj sP2 = com.bytedance.sdk.openadsdk.sU.sP.Sj.sP(com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP("pag_plb_config", "model", ""));
                        if (sP2 != null && sP.Sj().equals(sP2.Sj())) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("pag_plb_config", "model", EjP);
                        TKC.this.Sj(sP, sP2, 1);
                    }
                } catch (Exception e11) {
                    sU.sP("PlayableResManager", e11.getMessage());
                }
            }
        });
    }

    private String vS() {
        if (TextUtils.isEmpty(this.EjP)) {
            String str = EjP() + File.separator + "pregames";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.EjP = str;
        }
        return this.EjP;
    }

    public WebResourceResponse Sj(String str) {
        if (uA.Sj() && com.bytedance.sdk.openadsdk.dx.Sj.Sj("plb_res_enable", 0) == 1) {
            String Sj2 = uvD.Sj(str);
            if (TextUtils.isEmpty(Sj2)) {
                return null;
            }
            File file = new File(HiB(), Sj2 + TKC(str));
            if (file.exists()) {
                try {
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
                    if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                        return null;
                    }
                    return new WebResourceResponse(mimeTypeFromExtension, "UTF-8", new FileInputStream(file));
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    public void Sj(Map<String, String> map) {
        File[] listFiles;
        if (uA.Sj() && com.bytedance.sdk.openadsdk.dx.Sj.Sj("plb_res_enable", 0) == 1) {
            String vS = vS();
            if (!TextUtils.isEmpty(vS)) {
                File file = new File(vS);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            try {
                                File Sj2 = com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.Sj(file2);
                                if (Sj2 != null && Sj2.exists()) {
                                    map.put(file2.getName(), Sj2.getAbsolutePath());
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            int Sj3 = com.bytedance.sdk.openadsdk.dx.Sj.Sj("plb_res_delay_fetch_time", 0);
            if (Sj3 <= 0) {
                TKC();
            } else {
                sef.sP().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sU.Sj.TKC.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TKC.this.TKC();
                    }
                }, Sj3);
            }
        }
    }

    public void sP() {
        if (uA.Sj() && com.bytedance.sdk.openadsdk.dx.Sj.Sj("plb_res_enable", 0) == 1) {
            long currentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("pag_plb_config", "last_update_time", 0L);
            final String Sj2 = com.bytedance.sdk.openadsdk.dx.Sj.Sj("plb_res", "");
            long Sj3 = com.bytedance.sdk.openadsdk.dx.Sj.Sj("plb_res_fetch_interval", TimeConstants.HOUR);
            if (Sj3 <= 0 || Sj3 > TmcConstants.MINIAPP_TIME_DIFF) {
                Sj3 = 3600000;
            }
            if (currentTimeMillis < Sj3 || TextUtils.isEmpty(Sj2)) {
                return;
            }
            int Sj4 = com.bytedance.sdk.openadsdk.dx.Sj.Sj("plb_res_delay_fetch_time", 0);
            if (Sj4 <= 0) {
                sP(Sj2);
            } else {
                sef.sP().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sU.Sj.TKC.3
                    @Override // java.lang.Runnable
                    public void run() {
                        TKC.this.sP(Sj2);
                    }
                }, Sj4);
            }
        }
    }
}
