package com.bytedance.sdk.component.adexpress.Sj.sP;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.EjP.uA;
import com.bytedance.sdk.component.adexpress.Sj.TKC.Sj;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class sP {
    static Object Sj = new Object();

    public static com.bytedance.sdk.component.adexpress.Sj.TKC.Sj EjP() {
        return HiB.sP().vS();
    }

    public static String EjP(String str) {
        com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2;
        com.bytedance.sdk.component.adexpress.Sj.TKC.Sj EjP = EjP();
        if (EjP == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return vS();
        }
        Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> Sj2 = EjP.Sj();
        if (Sj2 == null || Sj2.size() <= 0 || (sj2 = Sj2.get(str)) == null) {
            return null;
        }
        return sj2.EjP();
    }

    public static boolean HiB() {
        return HiB.sP().HiB();
    }

    private static boolean HiB(String str) {
        com.bytedance.sdk.component.adexpress.Sj.TKC.Sj EjP;
        List<Sj.C0225Sj> vS;
        if (!HiB() || (EjP = EjP()) == null || (vS = EjP.vS()) == null) {
            return false;
        }
        for (Sj.C0225Sj c0225Sj : vS) {
            if (c0225Sj != null && TextUtils.equals(str, c0225Sj.Sj())) {
                return true;
            }
        }
        return false;
    }

    private static File Jcg(String str) {
        List<Pair<String, String>> sP;
        Sj.sP HiB = EjP().HiB();
        if (HiB == null || (sP = HiB.sP()) == null || sP.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : sP) {
            Object obj = pair.second;
            if (obj != null && ((String) obj).equals(str)) {
                return new File(HiB.Dq(), (String) pair.first);
            }
        }
        return null;
    }

    public static com.bytedance.sdk.component.adexpress.Sj.TKC.sP Sj(String str) {
        return Jcg.Sj().Sj(str);
    }

    public static Sj Sj(String str, uA.Sj sj2, String str2, String str3) {
        File file;
        Sj sj3 = new Sj();
        if (TextUtils.isEmpty(str3)) {
            file = null;
        } else {
            file = sP(str3, str);
            if (file != null) {
                sj3.Sj(1);
            }
        }
        if (file == null && (file = Jcg(str)) != null) {
            sj3.Sj(3);
        }
        if (file == null && (file = vS(str)) != null) {
            sj3.Sj(2);
        }
        if (TextUtils.isEmpty(str3)) {
            if (!HiB(str)) {
                sj3.Sj(6);
            }
        } else if (!Sj(str, str3)) {
            sj3.Sj(4);
        }
        sj3.sP();
        if (file != null) {
            try {
                sj3.Sj(new WebResourceResponse(sj2.Sj(), "utf-8", new FileInputStream(file)));
            } catch (Throwable unused) {
            }
        }
        return sj3;
    }

    public static void Sj() {
        HiB.sP();
    }

    public static void Sj(com.bytedance.sdk.component.adexpress.Sj.TKC.EjP ejP) {
        Jcg.Sj().Sj(ejP, ejP.vS);
    }

    private static void Sj(final com.bytedance.sdk.component.adexpress.Sj.TKC.sP sPVar) {
        com.bytedance.sdk.component.adexpress.EjP.EjP.Sj(new com.bytedance.sdk.component.Dq.Dq("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.Sj.sP.sP.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (sP.Sj) {
                    vS.Sj().Sj(sPVar, true);
                }
            }
        }, 10);
    }

    private static boolean Sj(String str, String str2) {
        com.bytedance.sdk.component.adexpress.Sj.TKC.Sj EjP;
        com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2;
        if (!HiB() || (EjP = EjP()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> Sj2 = EjP.Sj();
        if (Sj2.size() == 0 || (sj2 = Sj2.get(str2)) == null) {
            return false;
        }
        for (Sj.C0225Sj c0225Sj : sj2.vS()) {
            if (c0225Sj != null && TextUtils.equals(str, c0225Sj.Sj())) {
                return true;
            }
        }
        return false;
    }

    public static boolean Sj(JSONObject jSONObject) {
        Object opt;
        return (jSONObject == null || (opt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(opt.toString())) ? false : true;
    }

    public static com.bytedance.sdk.component.adexpress.Sj.TKC.sP TKC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.Sj.TKC.sP Sj2 = Jcg.Sj().Sj(str);
        if (Sj2 != null) {
            Sj2.Sj(Long.valueOf(System.currentTimeMillis()));
            Sj(Sj2);
        }
        return Sj2;
    }

    public static String TKC() {
        return vS.TKC();
    }

    public static boolean TKC(JSONObject jSONObject) {
        Object opt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                    if (optJSONObject == null || (opt = optJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(opt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static File sP(String str, String str2) {
        com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2;
        com.bytedance.sdk.component.adexpress.Sj.TKC.Sj EjP = EjP();
        if (EjP == null || !HiB()) {
            return null;
        }
        Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> Sj2 = EjP.Sj();
        if (Sj2.size() == 0 || (sj2 = Sj2.get(str)) == null) {
            return null;
        }
        for (Sj.C0225Sj c0225Sj : sj2.vS()) {
            if (c0225Sj.Sj() != null && c0225Sj.Sj().equals(str2)) {
                File file = new File(HiB.Dq(), com.bytedance.sdk.component.utils.HiB.Sj(c0225Sj.Sj()));
                String Sj3 = com.bytedance.sdk.component.utils.HiB.Sj(file);
                if (c0225Sj.sP() == null || !c0225Sj.sP().equals(Sj3)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static Set<String> sP(String str) {
        return Jcg.Sj().sP(str);
    }

    public static void sP() {
        try {
            Dq.EjP();
            File Dq = HiB.Dq();
            if (Dq == null || !Dq.exists()) {
                return;
            }
            if (Dq.getParentFile() != null) {
                com.bytedance.sdk.component.utils.Jcg.TKC(Dq.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.Jcg.TKC(Dq);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean sP(JSONObject jSONObject) {
        Object opt;
        return (jSONObject == null || (opt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(opt.toString())) ? false : true;
    }

    private static File vS(String str) {
        if (!HiB()) {
            return null;
        }
        for (Sj.C0225Sj c0225Sj : EjP().vS()) {
            if (c0225Sj.Sj() != null && c0225Sj.Sj().equals(str)) {
                File file = new File(HiB.Dq(), com.bytedance.sdk.component.utils.HiB.Sj(c0225Sj.Sj()));
                String Sj2 = com.bytedance.sdk.component.utils.HiB.Sj(file);
                if (c0225Sj.sP() == null || !c0225Sj.sP().equals(Sj2)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    @Deprecated
    private static String vS() {
        com.bytedance.sdk.component.adexpress.Sj.TKC.Sj EjP = EjP();
        if (EjP == null) {
            return null;
        }
        return EjP.EjP();
    }
}
