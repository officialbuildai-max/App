package com.bytedance.sdk.openadsdk.EjP;

import com.bytedance.sdk.openadsdk.EjP.TKC.Sj;
import com.transsion.push.PushConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class sP {
    public static final String Sj = Sj.InterfaceC0245Sj.Sj;
    public static final String sP = Sj.InterfaceC0245Sj.sP;
    public static final String TKC = Sj.InterfaceC0245Sj.TKC;
    public static final String EjP = Sj.InterfaceC0245Sj.EjP;
    public static final String HiB = Sj.InterfaceC0245Sj.HiB;
    public static final String vS = Sj.InterfaceC0245Sj.vS;
    public static final Set<String> Jcg = new HashSet(Arrays.asList("click", PushConstants.PUSH_SERVICE_TYPE_SHOW, "insight_log"));

    /* loaded from: classes2.dex */
    public static class Sj {
        public static String EjP = "saLandingPageLinks";
        public static String Sj = "openDetailPage";
        public static String TKC = "direct";
        public static String sP = "openAdLandPageLinks";
    }

    /* renamed from: com.bytedance.sdk.openadsdk.EjP.sP$sP, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0246sP {
        public static int Sj = 1;
        public static int TKC = 100;
        public static int sP = 2;
    }

    public static boolean Sj(String str) {
        return "embeded_ad".equals(str) || "banner_ad".equals(str) || "interaction".equals(str) || "slide_banner_ad".equals(str);
    }
}
