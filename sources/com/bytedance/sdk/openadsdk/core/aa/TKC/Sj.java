package com.bytedance.sdk.openadsdk.core.aa.TKC;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.Dq.Dq;
import com.bytedance.sdk.component.utils.HiB;
import com.bytedance.sdk.component.utils.Jcg;
import com.bytedance.sdk.component.utils.LD;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.core.uA;
import com.bytedance.sdk.openadsdk.sU.Sj.EjP;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.vungle.ads.internal.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Sj {
    private static volatile Sj Sj;
    private String sP;
    private final Map<sU, sP> TKC = new ConcurrentHashMap();
    private final Map<String, JSONObject> EjP = new ConcurrentHashMap();
    private final AtomicBoolean HiB = new AtomicBoolean(false);
    private final Set<String> vS = Collections.synchronizedSet(new HashSet());
    private final ConcurrentHashMap<String, com.bytedance.sdk.component.Jcg.sP.Sj> Jcg = new ConcurrentHashMap<>();
    private final Map<String, String> Dq = new ConcurrentHashMap();

    /* renamed from: com.bytedance.sdk.openadsdk.core.aa.TKC.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0281Sj {
    }

    /* loaded from: classes3.dex */
    private static class sP {
        long EjP;
        long Sj;
        long TKC;
        long sP;

        private sP() {
        }

        public sP EjP(long j11) {
            this.EjP = j11;
            return this;
        }

        public long Sj() {
            return this.sP - this.Sj;
        }

        public sP Sj(long j11) {
            this.Sj = j11;
            return this;
        }

        public sP TKC(long j11) {
            this.TKC = j11;
            return this;
        }

        public long sP() {
            return this.EjP - this.TKC;
        }

        public sP sP(long j11) {
            this.sP = j11;
            return this;
        }
    }

    private Sj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File EjP(File file) {
        File file2 = new File(file, "tt_open_ad_sdk_check_res.dat");
        return HiB(file2) ? file2 : new File(file, "tt_open_ad_sdk_check_res.dat");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String EjP() {
        File file = new File(HiB(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private String HiB() {
        if (TextUtils.isEmpty(this.sP)) {
            try {
                File file = new File(dNu.Sj().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.sP = file.getAbsolutePath();
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sU.sP("PlayableCache", "init root path error: ".concat(String.valueOf(th2)));
            }
        }
        return this.sP;
    }

    private boolean HiB(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead();
    }

    public static Sj Sj() {
        if (Sj == null) {
            synchronized (Sj.class) {
                try {
                    if (Sj == null) {
                        Sj = new Sj();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return Sj;
    }

    public static File Sj(File file) {
        File[] listFiles;
        if (file != null && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.isFile() && b.AD_INDEX_FILE_NAME.equals(file2.getName())) {
                    return file;
                }
            }
            for (File file3 : listFiles) {
                if (file3 != null && file3.isDirectory()) {
                    return Sj(file3);
                }
            }
        }
        return null;
    }

    private String Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        if (split != null && split.length == 2) {
            String str2 = split[0];
            if (str2 != null && str2.endsWith("/")) {
                str = str.substring(0, split.length - 1);
            }
            String str3 = split[0];
            if (str3 != null && str3.endsWith(b.AD_INDEX_FILE_NAME)) {
                str = split[0];
            }
        }
        return str.replace(b.AD_INDEX_FILE_NAME, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Sj(File file, boolean z10) {
        byte[] EjP;
        try {
            if (!HiB(file) || (EjP = Jcg.EjP(file)) == null || EjP.length <= 0) {
                return null;
            }
            String TKC = TextUtils.equals(file.getName(), "tt_open_ad_sdk_check_res.dat") ? com.bytedance.sdk.component.utils.Sj.TKC(new String(EjP)) : com.bytedance.sdk.component.EjP.Sj.sP(new String(EjP), com.bytedance.sdk.openadsdk.core.Sj.sP());
            if (TextUtils.isEmpty(TKC)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(TKC);
            if (z10 && jSONObject.length() > 0) {
                this.EjP.put(file.getParentFile().getName(), jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(final InterfaceC0281Sj interfaceC0281Sj, final boolean z10) {
        JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.3
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    private boolean Sj(String str, String str2, File file) {
        if (file != null && file.exists()) {
            JSONObject jSONObject = this.EjP.get(str);
            if (jSONObject == null) {
                return true;
            }
            String optString = jSONObject.optString(str2);
            if (optString != null && optString.equalsIgnoreCase(HiB.Sj(file))) {
                return true;
            }
        }
        return false;
    }

    public static void TKC(File file) {
        try {
            if (!file.exists() || file.setLastModified(System.currentTimeMillis())) {
                return;
            }
            file.renameTo(file);
            file.lastModified();
        } catch (Throwable unused) {
        }
    }

    public static void sP(File file) {
        TKC(file);
        try {
            uA.sP().uvD().Sj(file);
        } catch (Throwable unused) {
        }
    }

    public WebResourceResponse Sj(String str, String str2, String str3) {
        WebResourceResponse Sj2;
        String str4;
        File Sj3;
        try {
            Sj2 = com.bytedance.sdk.openadsdk.sU.Sj.TKC.Sj().Sj(str3);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.Sj("PlayableCache", "playable intercept error: ", th2);
        }
        if (Sj2 != null) {
            return Sj2;
        }
        if (this.HiB.get() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if ((str3.startsWith("http://") || str3.startsWith("https://")) && str3.contains(UrlUtils.QUESTION_MARK)) {
                    str3 = str3.split("\\?")[0];
                    if (str3.endsWith("/")) {
                        str3 = str3.substring(0, str3.length() - 1);
                    }
                }
                str4 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str3));
            } catch (Throwable unused) {
                str4 = null;
            }
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            String Sj4 = HiB.Sj(str);
            if (TextUtils.isEmpty(Sj4)) {
                return null;
            }
            String str5 = this.Dq.get(Sj4);
            if (TextUtils.isEmpty(str5)) {
                Sj3 = Sj(new File(EjP(), Sj4));
                if (Sj3 != null && Sj3.exists()) {
                    this.Dq.put(Sj4, Sj3.getAbsolutePath());
                }
            } else {
                Sj3 = new File(str5);
            }
            if (Sj3 != null && Sj3.exists()) {
                String Sj5 = Sj(str2);
                if (TextUtils.isEmpty(Sj5)) {
                    return null;
                }
                String replace = str3.replace(Sj5, "");
                if (!TextUtils.isEmpty(replace) && !replace.startsWith("https://") && !replace.startsWith("http://")) {
                    File file = new File(Sj3, replace);
                    if (file.exists() && Sj(Sj4, replace, file) && file.getCanonicalPath().startsWith(Sj3.getCanonicalPath())) {
                        return new WebResourceResponse(str4, "utf-8", new FileInputStream(file));
                    }
                }
            }
            return null;
        }
        return null;
    }

    @SuppressLint({"[ByDesign4.2]BadDomainNameVerifier"})
    public void Sj(final sU sUVar, final InterfaceC0281Sj interfaceC0281Sj) {
        File file;
        if (EjP.Sj().sP() && sUVar != null && uP.vS(sUVar) && sUVar.xD() != null && !TextUtils.isEmpty(sUVar.xD().getBidAdm())) {
            com.bytedance.sdk.openadsdk.core.aa.TKC.sP.Sj(sUVar, -705, "server bidding pre render");
            Sj(interfaceC0281Sj, false);
            return;
        }
        if (sUVar == null || sUVar.UHs() == null || TextUtils.isEmpty(sUVar.UHs().f())) {
            com.bytedance.sdk.openadsdk.core.aa.TKC.sP.Sj(sUVar, -701, (String) null);
            Sj(interfaceC0281Sj, false);
            return;
        }
        final String f11 = sUVar.UHs().f();
        if (this.vS.contains(f11)) {
            return;
        }
        this.TKC.put(sUVar, new sP().Sj(System.currentTimeMillis()));
        com.bytedance.sdk.openadsdk.core.aa.TKC.sP.Sj(sUVar);
        String Sj2 = HiB.Sj(f11);
        final File file2 = new File(EjP(), Sj2);
        String str = this.Dq.get(Sj2);
        if (TextUtils.isEmpty(str)) {
            file = Sj(file2);
            if (file != null && file.exists()) {
                this.Dq.put(Sj2, file.getAbsolutePath());
            }
        } else {
            file = new File(str);
        }
        if (file != null && file.exists()) {
            com.bytedance.sdk.openadsdk.core.aa.TKC.sP.Sj(sUVar, -702, (String) null);
            TKC(file2);
            this.TKC.remove(sUVar);
            Sj(interfaceC0281Sj, true);
            return;
        }
        try {
            Jcg.TKC(file2);
        } catch (Throwable unused) {
        }
        this.vS.add(f11);
        File file3 = new File(HiB(), Sj2 + ".zip");
        com.bytedance.sdk.component.Jcg.sP.Sj EjP = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().EjP();
        this.Jcg.put(f11, EjP);
        EjP.sP(f11);
        EjP.Sj(file3.getParent(), file3.getName());
        EjP.Sj(7);
        EjP.Sj("playable_download");
        EjP.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.2
            @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
            public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, final com.bytedance.sdk.component.Jcg.sP sPVar) {
                Sj.this.vS.remove(f11);
                Sj.this.Jcg.remove(f11);
                final sP sPVar2 = (sP) Sj.this.TKC.remove(sUVar);
                if (sPVar2 != null) {
                    sPVar2.sP(System.currentTimeMillis());
                }
                if (sPVar.vS() && sPVar.HiB() != null && sPVar.HiB().exists()) {
                    JcM.sP(new Dq("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z10;
                            long j11;
                            long j12;
                            try {
                                sP sPVar3 = sPVar2;
                                if (sPVar3 != null) {
                                    sPVar3.TKC(System.currentTimeMillis());
                                }
                                LD.Sj(sPVar.HiB().getAbsolutePath(), file2.getAbsolutePath());
                                sP sPVar4 = sPVar2;
                                if (sPVar4 != null) {
                                    sPVar4.EjP(System.currentTimeMillis());
                                }
                                sP sPVar5 = sPVar2;
                                if (sPVar5 != null) {
                                    j11 = sPVar5.Sj();
                                    j12 = sPVar2.sP();
                                } else {
                                    j11 = 0;
                                    j12 = 0;
                                }
                                com.bytedance.sdk.openadsdk.core.aa.TKC.sP.Sj(sUVar, j11, j12);
                                Sj.sP(file2);
                                z10 = true;
                                try {
                                    File Sj3 = Sj.Sj(file2);
                                    if (Sj3 != null && Sj3.exists()) {
                                        Sj.this.Dq.put(file2.getName(), Sj3.getAbsolutePath());
                                    }
                                    Sj.this.Sj(Sj.this.EjP(Sj3), true);
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable th2) {
                                com.bytedance.sdk.component.utils.sU.Sj("PlayableCache", "unzip error: ", th2);
                                com.bytedance.sdk.openadsdk.core.aa.TKC.sP.Sj(sUVar, -704, th2.getMessage());
                                z10 = false;
                            }
                            try {
                                sPVar.HiB().delete();
                            } catch (Throwable unused3) {
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            Sj.this.Sj(interfaceC0281Sj, z10);
                        }
                    });
                } else {
                    com.bytedance.sdk.openadsdk.core.aa.TKC.sP.Sj(sUVar, sPVar.Sj() != 0 ? sPVar.Sj() : -700, (String) null);
                    Sj.this.Sj(interfaceC0281Sj, false);
                }
            }

            @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
            public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
                Sj.this.vS.remove(f11);
                Sj.this.Jcg.remove(f11);
                Sj.this.TKC.remove(sUVar);
                com.bytedance.sdk.openadsdk.core.aa.TKC.sP.Sj(sUVar, -700, iOException.getMessage());
                Sj.this.Sj(interfaceC0281Sj, false);
            }
        });
    }

    public boolean Sj(sU sUVar) {
        if (this.HiB.get() && sUVar != null && sUVar.UHs() != null && sUVar.UHs().f() != null) {
            try {
                if (!TextUtils.isEmpty(this.Dq.get(HiB.Sj(sUVar.UHs().f())))) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public Map<String, String> TKC() {
        return this.Dq;
    }

    public void sP() {
        if (this.HiB.get()) {
            return;
        }
        JcM.Sj(new Dq("PlayableCache_init") { // from class: com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.1
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                try {
                    String EjP = Sj.this.EjP();
                    if (!TextUtils.isEmpty(EjP)) {
                        File file = new File(EjP);
                        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                            for (File file2 : listFiles) {
                                if (file2 != null) {
                                    try {
                                        File Sj2 = Sj.Sj(file2);
                                        if (Sj2 != null && Sj2.exists()) {
                                            Sj.this.Dq.put(file2.getName(), Sj2.getAbsolutePath());
                                        }
                                        Sj.this.Sj(Sj.this.EjP(Sj2), true);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
                com.bytedance.sdk.openadsdk.sU.Sj.TKC.Sj().Sj(Sj.this.Dq);
                Sj.this.HiB.set(true);
            }
        });
    }

    public void sP(sU sUVar) {
        if (sUVar == null || sUVar.UHs() == null || TextUtils.isEmpty(sUVar.UHs().f()) || !com.bytedance.sdk.openadsdk.dx.Sj.Sj("can_cancel_playable", false)) {
            return;
        }
        com.bytedance.sdk.component.Jcg.sP.Sj sj2 = this.Jcg.get(sUVar.UHs().f());
        if (sj2 != null) {
            sj2.sP();
        }
    }
}
