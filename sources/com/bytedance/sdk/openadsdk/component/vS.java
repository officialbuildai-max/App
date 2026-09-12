package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.Dq.Dq;
import com.bytedance.sdk.component.HiB.Ym;
import com.bytedance.sdk.component.HiB.uvD;
import com.bytedance.sdk.component.utils.TzV;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.common.Sj;
import com.bytedance.sdk.openadsdk.core.RiZ;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.ib;
import com.bytedance.sdk.openadsdk.core.model.ley;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.WMZ;
import com.bytedance.sdk.openadsdk.utils.uvD;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import v5.a;
import y5.b;

/* loaded from: classes3.dex */
public class vS {
    private static String Sj = "/openad_image_cache";
    private static volatile vS TKC = null;
    private static String sP = "openad_image_cache";
    private final com.bytedance.sdk.openadsdk.sP.sP EjP;
    private final RiZ<com.bytedance.sdk.openadsdk.EjP.Sj> HiB;
    private final Map<String, AtomicInteger> Jcg = new ConcurrentHashMap();
    private final Context vS;

    /* loaded from: classes2.dex */
    public interface EjP {
        void Sj(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class Sj extends Dq {
        private final com.bytedance.sdk.openadsdk.component.HiB.Sj sP;

        public Sj(com.bytedance.sdk.openadsdk.component.HiB.Sj sj2) {
            super("App Open Ad Write Cache");
            this.sP = sj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.bytedance.sdk.openadsdk.common.Sj.Sj()) {
                    com.bytedance.sdk.openadsdk.common.Sj.Sj("tt_openad_materialMeta").Sj(this.sP.sP().xD(), this.sP.TKC());
                    return;
                }
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad_materialMeta", "material" + this.sP.Sj(), com.bytedance.sdk.component.utils.Sj.Sj(this.sP.sP().SP()).toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface TKC {
        void Sj();

        void Sj(int i11, String str);
    }

    /* loaded from: classes2.dex */
    public interface sP {
        void Sj();

        void Sj(@Nullable com.bytedance.sdk.openadsdk.TzV.Sj.sP sPVar);
    }

    private vS(Context context) {
        if (context != null) {
            this.vS = context.getApplicationContext();
        } else {
            this.vS = dNu.Sj();
        }
        this.EjP = new com.bytedance.sdk.openadsdk.sP.sP(10, 8, true);
        this.HiB = dNu.TKC();
        if (com.bytedance.sdk.openadsdk.uA.EjP.sP()) {
            Sj += "_p";
            sP += "_p";
        }
        com.bytedance.sdk.openadsdk.common.Sj.Sj("tt_openad_materialMeta", new Sj.sP("tt_openad_materialMeta") { // from class: com.bytedance.sdk.openadsdk.component.vS.1
            @Override // com.bytedance.sdk.openadsdk.common.Sj.sP
            public String EjP(String str) {
                return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP("tt_openad_materialMeta", "ad_slot".concat(String.valueOf(str)), null);
            }

            @Override // com.bytedance.sdk.openadsdk.common.Sj.sP
            protected String Sj(String str) {
                return "tt_openad_materialMeta";
            }

            @Override // com.bytedance.sdk.openadsdk.common.Sj.sP
            public void Sj(AdSlot adSlot, String str, String str2) {
                String codeId = adSlot.getCodeId();
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad_materialMeta", "material".concat(String.valueOf(codeId)), str);
                com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad_materialMeta", "ad_slot".concat(String.valueOf(codeId)), adSlot.toJsonObj().toString());
            }

            @Override // com.bytedance.sdk.openadsdk.common.Sj.sP
            public String sP(String str) {
                return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP("tt_openad_materialMeta", "material".concat(String.valueOf(str)), null);
            }
        });
    }

    public static vS Sj(Context context) {
        if (TKC == null) {
            synchronized (vS.class) {
                try {
                    if (TKC == null) {
                        TKC = new vS(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return TKC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(@NonNull final sU sUVar, final AdSlot adSlot, final ley leyVar, final com.bytedance.sdk.openadsdk.core.model.Sj sj2) {
        final int If = sUVar.If();
        Sj(sUVar, adSlot, leyVar, new TKC() { // from class: com.bytedance.sdk.openadsdk.component.vS.5
            @Override // com.bytedance.sdk.openadsdk.component.vS.TKC
            public void Sj() {
                com.bytedance.sdk.openadsdk.component.HiB.Sj sj3 = new com.bytedance.sdk.openadsdk.component.HiB.Sj(If, sUVar, sj2);
                vS.this.Sj(sj3);
                com.bytedance.sdk.openadsdk.component.EjP.Sj.Sj(sj3.sP(), 1, leyVar);
                vS.this.sP(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.vS.TKC
            public void Sj(int i11, String str) {
                vS.this.sP(adSlot);
            }
        });
    }

    public static void Sj(sU sUVar, EjP ejP) {
        Sj(sUVar, ejP, 0);
    }

    public static void Sj(sU sUVar, final EjP ejP, final int i11) {
        String r11 = sUVar.UHs().r();
        if (TextUtils.isEmpty(r11)) {
            return;
        }
        com.bytedance.sdk.openadsdk.uA.EjP.Sj(r11).Sj(sUVar.UHs().t()).sP(sUVar.UHs().C()).HiB(FPG.HiB(dNu.Sj())).EjP(FPG.TKC(dNu.Sj())).TKC(2).Sj(new com.bytedance.sdk.component.HiB.Dq() { // from class: com.bytedance.sdk.openadsdk.component.vS.3
            @Override // com.bytedance.sdk.component.HiB.Dq
            public Bitmap Sj(Bitmap bitmap) {
                return i11 <= 0 ? bitmap : com.bytedance.sdk.component.adexpress.EjP.Sj.Sj(dNu.Sj(), bitmap, i11);
            }
        }).Sj(new com.bytedance.sdk.openadsdk.uA.sP(sUVar, r11, new uvD<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.component.vS.2
            @Override // com.bytedance.sdk.component.HiB.uvD
            public void Sj(int i12, String str, @Nullable Throwable th2) {
            }

            @Override // com.bytedance.sdk.component.HiB.uvD
            public void Sj(Ym<Bitmap> ym2) {
                EjP ejP2;
                if (ym2 == null || ym2.sP() == null || ym2.TKC() == null || (ejP2 = EjP.this) == null) {
                    return;
                }
                ejP2.Sj(ym2.sP());
            }
        }));
    }

    private int TKC(AdSlot adSlot) {
        StringBuilder sb2 = new StringBuilder("material_expiration_time");
        sb2.append(adSlot.getCodeId());
        return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad", sb2.toString(), -1L) == -1 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(AdSlot adSlot) {
        AtomicInteger atomicInteger = this.Jcg.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        } else {
            atomicInteger.decrementAndGet();
        }
        this.Jcg.put(adSlot.getCodeId(), atomicInteger);
    }

    private void sP(com.bytedance.sdk.openadsdk.component.HiB.Sj sj2) {
        JcM.Sj(new Sj(sj2), 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(@NonNull final sU sUVar, final AdSlot adSlot, final ley leyVar, final com.bytedance.sdk.openadsdk.core.model.Sj sj2) {
        final int If = sUVar.If();
        Sj(sUVar, leyVar, new sP() { // from class: com.bytedance.sdk.openadsdk.component.vS.6
            @Override // com.bytedance.sdk.openadsdk.component.vS.sP
            public void Sj() {
                vS.this.sP(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.vS.sP
            public void Sj(com.bytedance.sdk.openadsdk.TzV.Sj.sP sPVar) {
                com.bytedance.sdk.openadsdk.component.HiB.Sj sj3 = new com.bytedance.sdk.openadsdk.component.HiB.Sj(If, sUVar, sj2);
                vS.this.Sj(sj3);
                com.bytedance.sdk.openadsdk.component.EjP.Sj.Sj(sj3.sP(), 1, leyVar);
                vS.this.sP(adSlot);
            }
        });
    }

    public boolean EjP(int i11) {
        return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad", "image_has_cached".concat(String.valueOf(i11)), false);
    }

    @Nullable
    public sU HiB(int i11) {
        sU vS;
        if (com.bytedance.sdk.openadsdk.common.Sj.Sj()) {
            com.bytedance.sdk.openadsdk.core.model.Sj Sj2 = com.bytedance.sdk.openadsdk.common.Sj.Sj("tt_openad_materialMeta").Sj(String.valueOf(i11), false);
            vS = Sj2 != null ? Sj2.vS() : null;
        } else {
            vS = vS(i11);
        }
        long Sj3 = com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad", "material_expiration_time".concat(String.valueOf(i11)), -1L);
        if (System.currentTimeMillis() / 1000 < Sj3 && vS != null) {
            return vS;
        }
        if (vS != null || Sj3 != -1) {
            Jcg(i11);
            if (vS != null) {
                com.bytedance.sdk.openadsdk.component.EjP.Sj.Sj(vS);
            }
        }
        return null;
    }

    public void Jcg(int i11) {
        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad_materialMeta", "material".concat(String.valueOf(i11)));
        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad", "material_expiration_time".concat(String.valueOf(i11)));
        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad", "video_has_cached".concat(String.valueOf(i11)));
        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad", "image_has_cached".concat(String.valueOf(i11)));
    }

    @Nullable
    public String Sj(sU sUVar) {
        if (sUVar != null && sUVar.UHs() != null && !TextUtils.isEmpty(sUVar.UHs().x())) {
            String x10 = sUVar.UHs().x();
            String G = sUVar.UHs().G();
            if (TextUtils.isEmpty(G)) {
                G = com.bytedance.sdk.component.utils.HiB.Sj(x10);
            }
            File Sj2 = com.bytedance.sdk.openadsdk.component.Jcg.Sj.Sj(G);
            if (Sj2.exists() && Sj2.isFile()) {
                return Sj2.getAbsolutePath();
            }
        }
        return null;
    }

    public void Sj() {
        File[] listFiles;
        try {
            com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad_materialMeta");
            com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad");
        } catch (Throwable unused) {
        }
        try {
            File cacheDir = this.vS.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (listFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.vS.9
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file == null) {
                        return false;
                    }
                    String name = file.getName();
                    return name.contains(vS.sP) || name.contains("openad_video_cache");
                }
            })) == null) {
                return;
            }
            for (File file : listFiles) {
                try {
                    com.bytedance.sdk.component.utils.Jcg.TKC(file);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public void Sj(int i11) {
        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad", "video_has_cached".concat(String.valueOf(i11)), Boolean.TRUE);
    }

    public void Sj(final AdSlot adSlot) {
        if (adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        AtomicInteger atomicInteger = this.Jcg.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        }
        if (atomicInteger.get() + TKC(adSlot) > 0) {
            return;
        }
        atomicInteger.incrementAndGet();
        this.Jcg.put(adSlot.getCodeId(), atomicInteger);
        final ley leyVar = new ley();
        leyVar.Sj(WMZ.sP());
        ib ibVar = new ib();
        ibVar.TEQ = leyVar;
        ibVar.EjP = 2;
        ibVar.Dq = 2;
        this.HiB.Sj(adSlot, ibVar, 3, new RiZ.Sj() { // from class: com.bytedance.sdk.openadsdk.component.vS.4
            @Override // com.bytedance.sdk.openadsdk.core.RiZ.Sj
            public void Sj(int i11, String str) {
                vS.this.sP(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.core.RiZ.Sj
            public void Sj(com.bytedance.sdk.openadsdk.core.model.Sj sj2, com.bytedance.sdk.openadsdk.core.model.TKC tkc) {
                if (sj2 == null || sj2.EjP() == null || sj2.EjP().size() == 0) {
                    tkc.Sj(-3);
                    com.bytedance.sdk.openadsdk.core.model.TKC.Sj(tkc);
                    return;
                }
                sU sUVar = sj2.EjP().get(0);
                if (sUVar == null || !sUVar.yfI()) {
                    if (sU.HiB(sUVar)) {
                        vS.this.Sj(sUVar, adSlot, leyVar, sj2);
                        return;
                    } else {
                        vS.this.sP(sUVar, adSlot, leyVar, sj2);
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.component.HiB.Sj sj3 = new com.bytedance.sdk.openadsdk.component.HiB.Sj(sUVar.If(), sUVar, sj2);
                vS.this.Sj(sj3);
                com.bytedance.sdk.openadsdk.component.EjP.Sj.Sj(sj3.sP(), 1, leyVar);
                vS.this.sP(adSlot);
            }
        });
    }

    public void Sj(com.bytedance.sdk.openadsdk.component.HiB.Sj sj2) {
        if (sj2.sP() == null || sU.vS(sj2.sP()) || sj2.sP().ODI()) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad", "material_expiration_time" + sj2.Sj(), Long.valueOf(sj2.sP().TO()));
        sP(sj2);
    }

    public void Sj(@NonNull final sU sUVar, AdSlot adSlot, final ley leyVar, final TKC tkc) {
        final WMZ sP2 = WMZ.sP();
        final int If = sUVar.If();
        b UHs = sUVar.UHs();
        String x10 = UHs.x();
        String G = UHs.G();
        if (TextUtils.isEmpty(G)) {
            G = com.bytedance.sdk.component.utils.HiB.Sj(x10);
        }
        final File Sj2 = com.bytedance.sdk.openadsdk.component.Jcg.Sj.Sj(G);
        if (Sj2.exists()) {
            com.bytedance.sdk.openadsdk.component.Jcg.Sj.Sj(Sj2);
            Sj(If);
            long EjP2 = sP2.EjP();
            if (leyVar != null) {
                leyVar.Sj(EjP2);
                leyVar.Sj(1);
            }
            tkc.Sj();
            Sj(sUVar, (EjP) null);
            return;
        }
        if (dNu.EjP().wE(String.valueOf(If)) && !TzV.EjP(dNu.Sj())) {
            tkc.Sj(100, "OnlyWifi");
            return;
        }
        com.bytedance.sdk.openadsdk.core.aa.Sj.sP Sj3 = sU.Sj(Sj2.getParent(), sUVar);
        Sj3.Sj("material_meta", sUVar);
        Sj3.Sj("ad_slot", adSlot);
        com.bytedance.sdk.openadsdk.core.aa.HiB.Sj.Sj(Sj3, new a.InterfaceC0973a() { // from class: com.bytedance.sdk.openadsdk.component.vS.7
            @Override // v5.a.InterfaceC0973a
            public void Sj(com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC tkc2, int i11) {
                vS.this.Sj(If);
                long EjP3 = sP2.EjP();
                com.bytedance.sdk.openadsdk.component.EjP.Sj.sP(sUVar, EjP3, true);
                ley leyVar2 = leyVar;
                if (leyVar2 != null) {
                    leyVar2.Sj(EjP3);
                    leyVar.Sj(2);
                }
                tkc.Sj();
                vS.Sj(sUVar, (EjP) null);
            }

            @Override // v5.a.InterfaceC0973a
            public void Sj(com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC tkc2, int i11, String str) {
                long EjP3 = sP2.EjP();
                com.bytedance.sdk.openadsdk.component.EjP.Sj.sP(sUVar, EjP3, false);
                ley leyVar2 = leyVar;
                if (leyVar2 != null) {
                    leyVar2.Sj(EjP3);
                }
                tkc.Sj(i11, str);
                try {
                    if (Sj2.exists() && Sj2.isFile()) {
                        com.bytedance.sdk.component.utils.Jcg.TKC(Sj2);
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // v5.a.InterfaceC0973a
            public void sP(com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC tkc2, int i11) {
            }
        });
    }

    public void Sj(final sU sUVar, final ley leyVar, final sP sPVar) {
        final WMZ sP2 = WMZ.sP();
        final int If = sUVar.If();
        com.bytedance.sdk.openadsdk.core.model.uvD uvd = sUVar.Bml().get(0);
        String Jcg = uvd.Jcg();
        String Sj2 = uvd.Sj();
        int sP3 = uvd.sP();
        int TKC2 = uvd.TKC();
        String Sj3 = TextUtils.isEmpty(Jcg) ? com.bytedance.sdk.component.utils.HiB.Sj(Sj2) : Jcg;
        if (TextUtils.isEmpty(Sj3)) {
            if (sPVar != null) {
                sPVar.Sj();
                return;
            }
            return;
        }
        File sP4 = com.bytedance.sdk.openadsdk.component.Jcg.Sj.sP(Sj3);
        if (!Sj(Sj2, Jcg)) {
            com.bytedance.sdk.openadsdk.utils.uvD.Sj(new com.bytedance.sdk.openadsdk.TzV.Sj(Sj2, uvd.Jcg()), sP3, TKC2, new uvD.Sj() { // from class: com.bytedance.sdk.openadsdk.component.vS.8
                @Override // com.bytedance.sdk.openadsdk.utils.uvD.Sj
                public void Sj() {
                    com.bytedance.sdk.openadsdk.component.EjP.Sj.Sj(sUVar, sP2.EjP(), false);
                    sPVar.Sj();
                }

                @Override // com.bytedance.sdk.openadsdk.utils.uvD.Sj
                public void Sj(@NonNull com.bytedance.sdk.openadsdk.TzV.Sj.sP sPVar2) {
                    if (!sPVar2.EjP()) {
                        com.bytedance.sdk.openadsdk.component.EjP.Sj.Sj(sUVar, sP2.EjP(), false);
                        sPVar.Sj();
                        return;
                    }
                    vS.this.TKC(If);
                    long EjP2 = sP2.EjP();
                    com.bytedance.sdk.openadsdk.component.EjP.Sj.Sj(sUVar, EjP2, true);
                    ley leyVar2 = leyVar;
                    if (leyVar2 != null) {
                        leyVar2.Sj(EjP2);
                        leyVar.Sj(2);
                    }
                    sPVar.Sj(sPVar2);
                }
            }, sP4.getParent());
            return;
        }
        TKC(If);
        long EjP2 = sP2.EjP();
        if (leyVar != null) {
            leyVar.Sj(EjP2);
            leyVar.Sj(1);
        }
        sPVar.Sj(null);
    }

    public void Sj(File file) {
        try {
            this.EjP.Sj(file);
        } catch (IOException e11) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAppOpenAdCacheManager", "trimFileCache fail", e11);
        }
    }

    public boolean Sj(String str, String str2) {
        boolean z10;
        File file;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.HiB.Sj(str);
            }
            File sP2 = com.bytedance.sdk.openadsdk.component.Jcg.Sj.sP(str2);
            InputStream Sj2 = com.bytedance.sdk.openadsdk.uA.EjP.Sj(str, str2);
            if (Sj2 != null) {
                try {
                    Sj2.close();
                } catch (IOException e11) {
                    com.bytedance.sdk.component.utils.sU.sP("TTAppOpenAdCacheManager", e11.getMessage());
                }
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                if (com.bytedance.sdk.openadsdk.uA.EjP.Sj(str, str2, sP2.getParent())) {
                    return true;
                }
                if (com.bytedance.sdk.openadsdk.uA.EjP.sP()) {
                    file = new File(sP2.getPath());
                } else {
                    file = new File(sP2.getPath() + ".0");
                }
                if (file.exists()) {
                    return true;
                }
            }
            return z10;
        } catch (Exception e12) {
            com.bytedance.sdk.component.utils.sU.sP("TTAppOpenAdCacheManager", e12.getMessage());
            return false;
        }
    }

    public void TKC(int i11) {
        com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad", "image_has_cached".concat(String.valueOf(i11)), Boolean.TRUE);
    }

    public String sP() {
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            return name + "/" + sP + "/";
        }
        return name + "/" + Sj + "/";
    }

    public boolean sP(int i11) {
        return com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj("tt_openad", "video_has_cached".concat(String.valueOf(i11)), false);
    }

    public boolean sP(sU sUVar) {
        if (sUVar == null || sUVar.Bml() == null || sUVar.Bml().size() == 0 || TextUtils.isEmpty(sUVar.Bml().get(0).Sj())) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.uvD uvd = sUVar.Bml().get(0);
        return Sj(uvd.Sj(), uvd.Jcg());
    }

    @Nullable
    public sU vS(int i11) {
        String sP2 = com.bytedance.sdk.openadsdk.multipro.EjP.EjP.sP("tt_openad_materialMeta", "material".concat(String.valueOf(i11)), null);
        if (!TextUtils.isEmpty(sP2)) {
            try {
                JSONObject Sj2 = dNu.TKC().Sj(new JSONObject(sP2));
                return Sj2.has("creatives") ? com.bytedance.sdk.openadsdk.core.model.Sj.TKC(Sj2).vS() : com.bytedance.sdk.openadsdk.core.sP.Sj(Sj2);
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.sU.sP("TTAppOpenAdCacheManager", e11.getMessage());
            }
        }
        return null;
    }
}
