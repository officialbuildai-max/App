package com.bytedance.sdk.component.adexpress.Sj.sP;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Jcg {
    private static volatile Jcg Sj;
    private AtomicBoolean sP = new AtomicBoolean(false);

    private Jcg() {
    }

    public static Jcg Sj() {
        if (Sj == null) {
            synchronized (Jcg.class) {
                try {
                    if (Sj == null) {
                        Sj = new Jcg();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return Sj;
    }

    private void Sj(String str, String str2, String str3) {
        JSONObject TKC;
        if (TextUtils.isEmpty(str) || (TKC = TKC(str)) == null) {
            return;
        }
        String optString = TKC.optString("md5");
        String optString2 = TKC.optString("version");
        String optString3 = TKC.optString("data");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.Sj.TKC.sP Sj2 = new com.bytedance.sdk.component.adexpress.Sj.TKC.sP().Sj(str2).sP(str3).TKC(optString).EjP(str).HiB(optString3).vS(optString2).Sj(Long.valueOf(System.currentTimeMillis()));
        vS.Sj().Sj(Sj2, false);
        sP();
        if (Dq.Sj(optString2)) {
            Sj2.vS(optString2);
            HiB.sP().Sj(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sj(String str, String str2, String str3, String str4, String str5, String str6) {
        if (Sj(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                sP(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4)) {
            Sj(str2, str6, str);
        } else if (TextUtils.isEmpty(str3)) {
            Sj(str2, str6, str);
        } else {
            sP(str6, str, str3, str2, str4, str5);
        }
        boolean Sj2 = Dq.Sj(str5);
        if (!sP.HiB() || Sj2) {
            HiB.sP().Sj(true);
        }
    }

    private JSONObject TKC(String str) {
        com.bytedance.sdk.component.adexpress.Sj.Sj.TKC TKC = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC();
        if (TKC == null) {
            return null;
        }
        com.bytedance.sdk.component.Jcg.sP.sP Jcg = TKC.Jcg();
        Jcg.sP(str);
        com.bytedance.sdk.component.Jcg.sP Sj2 = Jcg.Sj();
        if (Sj2 != null) {
            try {
                if (Sj2.vS() && Sj2.EjP() != null) {
                    return new JSONObject(Sj2.EjP());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private void sP() {
        if (com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC() == null) {
            return;
        }
        int Sj2 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().Sj();
        if (Sj2 <= 0) {
            Sj2 = 100;
        }
        List<com.bytedance.sdk.component.adexpress.Sj.TKC.sP> sP = vS.Sj().sP();
        if (sP == null || sP.isEmpty() || Sj2 >= sP.size()) {
            if (sP == null) {
                return;
            }
            sP.size();
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.Sj.TKC.sP sPVar : sP) {
            treeMap.put(sPVar.Jcg(), sPVar);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (sP.size() - (Sj2 * 0.75f));
        int i11 = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i11 < size) {
                i11++;
                ((Long) entry.getKey()).longValue();
                com.bytedance.sdk.component.adexpress.Sj.TKC.sP sPVar2 = (com.bytedance.sdk.component.adexpress.Sj.TKC.sP) entry.getValue();
                if (sPVar2 != null) {
                    hashSet.add(sPVar2.sP());
                }
            }
        }
        Sj(hashSet);
        this.sP.set(false);
    }

    private void sP(String str, String str2, String str3, String str4, String str5, String str6) {
        vS.Sj().Sj(new com.bytedance.sdk.component.adexpress.Sj.TKC.sP().Sj(str).sP(str2).TKC(str3).EjP(str4).HiB(str5).vS(str6).Sj(Long.valueOf(System.currentTimeMillis())), false);
        sP();
    }

    public com.bytedance.sdk.component.adexpress.Sj.TKC.sP Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return vS.Sj().Sj(str);
    }

    public void Sj(com.bytedance.sdk.component.adexpress.Sj.TKC.EjP ejP, String str) {
        if (ejP == null) {
            return;
        }
        final String str2 = ejP.Sj;
        final String str3 = ejP.TKC;
        final String str4 = ejP.sP;
        final String str5 = ejP.EjP;
        final String str6 = ejP.HiB;
        final String Dq = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC() != null ? com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().Dq() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.EjP.EjP.Sj(new com.bytedance.sdk.component.Dq.Dq("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.Sj.sP.Jcg.1
            @Override // java.lang.Runnable
            public void run() {
                Jcg.this.Sj(str2, str3, str4, str5, str6, Dq);
            }
        }, 10);
    }

    public void Sj(Set<String> set) {
        try {
            vS.Sj().Sj(set);
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    public Set<String> sP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return vS.Sj().sP(str);
    }
}
