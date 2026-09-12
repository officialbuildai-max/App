package com.bytedance.sdk.component.vS.Sj.vS;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.vS.Sj.Dq;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TKC implements sP {
    private final Context Sj;
    private final HiB sP;

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    /* loaded from: classes2.dex */
    public class Sj extends com.bytedance.sdk.component.vS.Sj.HiB.HiB {
        private final Map<String, String> EjP;
        private final String TKC;
        private final EjP sP;

        private Sj(EjP ejP, String str, Map<String, String> map) {
            super("AdsStats");
            this.sP = ejP;
            this.TKC = str;
            this.EjP = map;
        }

        private String TKC(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.TKC)) ? str.replace("{UID}", this.TKC).replace("__UID__", this.TKC) : str;
        }

        boolean Sj(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.vS.Sj.HiB.EjP ejP;
            com.bytedance.sdk.component.vS.Sj.HiB uvD = Dq.Jcg().uvD();
            if (uvD == null || Dq.Jcg().vS() == null || !uvD.TKC() || !Sj(this.sP.sP())) {
                return;
            }
            if (this.sP.EjP() >= uvD.TKC(this.sP.vS())) {
                TKC.this.sP.TKC(this.sP);
                return;
            }
            try {
                uvD.Fmk();
                if (this.sP.Ym()) {
                    TKC.this.sP.Sj(this.sP);
                }
                if (uvD.Sj(TKC.this.Sj())) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String sP = this.sP.sP();
                    if (uvD.vS() == 0) {
                        sP = TKC(this.sP.sP());
                        if (this.sP.TKC()) {
                            sP = sP(sP);
                        }
                    }
                    com.bytedance.sdk.component.vS.Sj.HiB.TKC TEQ = uvD.TEQ();
                    if (TEQ == null) {
                        return;
                    }
                    TEQ.Sj("User-Agent", uvD.uA());
                    TEQ.Sj("csj_client_source_from", "1");
                    if (this.EjP != null) {
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry<String, String> entry : this.EjP.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                        TEQ.Sj("csj_extra_info", jSONObject.toString());
                    }
                    TEQ.Sj(sP);
                    try {
                        ejP = TEQ.Sj();
                        try {
                            uvD.Sj(ejP.Sj());
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        ejP = null;
                    }
                    EjP ejP2 = this.sP;
                    ejP2.Sj(ejP2.EjP() + 1);
                    if (ejP != null && ejP.Sj()) {
                        TKC.this.sP.TKC(this.sP);
                        this.sP.sP();
                        uvD.Sj(true, 200, System.currentTimeMillis() - currentTimeMillis, this.sP);
                        return;
                    }
                    if (ejP != null) {
                        this.sP.sP(ejP.sP());
                        this.sP.TKC(ejP.TKC());
                    }
                    if (ejP == null || ejP.sP() != 8848) {
                        this.sP.sP();
                        if (this.sP.EjP() >= uvD.TKC(this.sP.vS())) {
                            TKC.this.sP.TKC(this.sP);
                            this.sP.sP();
                        } else {
                            TKC.this.sP.sP(this.sP);
                        }
                    } else {
                        ejP.TKC();
                        TKC.this.sP.TKC(this.sP);
                    }
                    uvD.Sj(false, this.sP.Dq(), System.currentTimeMillis() - currentTimeMillis, this.sP);
                }
            } catch (Throwable unused3) {
            }
        }

        String sP(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(TKC.sP().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception unused) {
                return str;
            }
        }
    }

    public TKC(Context context, HiB hiB) {
        this.Sj = context;
        this.sP = hiB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(List<EjP> list, String str, boolean z10) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.vS.Sj.HiB uvD = Dq.Jcg().uvD();
        for (EjP ejP : list) {
            if (uvD != null && uvD.EjP() != null) {
                ejP.Sj(z10);
                uvD.EjP().execute(new Sj(ejP, str, null));
            }
        }
    }

    private static Random TKC() {
        SecureRandom instanceStrong;
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
            return instanceStrong;
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    static /* synthetic */ Random sP() {
        return TKC();
    }

    public Context Sj() {
        Context context = this.Sj;
        return context == null ? Dq.Jcg().vS() : context;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.vS.sP
    public Runnable Sj(final EjP ejP, final String str, final Map<String, String> map) {
        if (ejP == null || TextUtils.isEmpty(ejP.Sj())) {
            return null;
        }
        return new Runnable() { // from class: com.bytedance.sdk.component.vS.Sj.vS.TKC.1
            @Override // java.lang.Runnable
            public void run() {
                if (TKC.this.sP.Sj(ejP.Sj()) != null) {
                    new Sj(ejP, str, map).run();
                }
            }
        };
    }

    @Override // com.bytedance.sdk.component.vS.Sj.vS.sP
    public void Sj(String str, List<String> list, boolean z10, Map<String, String> map, int i11, String str2) {
        com.bytedance.sdk.component.vS.Sj.HiB uvD = Dq.Jcg().uvD();
        if (uvD == null || Dq.Jcg().vS() == null || uvD.EjP() == null || !uvD.TKC() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            uvD.EjP().execute(new Sj(new EjP(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z10, i11, str2), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.vS.sP
    public void Sj(final String str, final boolean z10) {
        com.bytedance.sdk.component.vS.Sj.HiB uvD = Dq.Jcg().uvD();
        if (uvD == null || Dq.Jcg().vS() == null || !uvD.TKC()) {
            return;
        }
        com.bytedance.sdk.component.vS.Sj.HiB.HiB hiB = new com.bytedance.sdk.component.vS.Sj.HiB.HiB("trackFailedUrls") { // from class: com.bytedance.sdk.component.vS.Sj.vS.TKC.2
            @Override // java.lang.Runnable
            public void run() {
                TKC.this.Sj(TKC.this.sP.Sj(), str, z10);
            }
        };
        hiB.Sj(1);
        if (uvD.EjP() != null) {
            uvD.EjP().execute(hiB);
        }
    }
}
