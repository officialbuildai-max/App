package com.bytedance.sdk.openadsdk.Ym.Sj;

import com.bytedance.sdk.component.Sj.dNu;
import com.bytedance.sdk.openadsdk.core.Yf;
import com.bytedance.sdk.openadsdk.core.model.sU;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Fmk extends com.bytedance.sdk.component.Sj.HiB<JSONObject, JSONObject> {
    private sU EjP;
    private com.bytedance.sdk.component.uA.vS Sj;
    private Yf TKC;
    private String sP;

    public Fmk(com.bytedance.sdk.component.uA.vS vSVar, String str, Yf yf2, sU sUVar) {
        this.Sj = vSVar;
        this.sP = str;
        this.TKC = yf2;
        this.EjP = sUVar;
    }

    public static void Sj(dNu dnu, com.bytedance.sdk.component.uA.vS vSVar, Yf yf2, sU sUVar) {
        dnu.Sj("closeWebview", new Fmk(vSVar, "closeWebview", yf2, sUVar));
        dnu.Sj("makeVisible", new Fmk(vSVar, "makeVisible", yf2, sUVar));
        dnu.Sj("getCurrentVisibleState", new Fmk(vSVar, "getCurrentVisibleState", yf2, sUVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
    
        return r7;
     */
    @Override // com.bytedance.sdk.component.Sj.HiB
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject Sj(org.json.JSONObject r6, com.bytedance.sdk.component.Sj.vS r7) throws java.lang.Exception {
        /*
            r5 = this;
            r6 = 0
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r0 = r5.sP
            r0.hashCode()
            r1 = 1
            java.lang.String r2 = "success"
            r3 = -1
            int r4 = r0.hashCode()
            switch(r4) {
                case -1516905438: goto L2d;
                case -120664351: goto L22;
                case 1756338852: goto L17;
                default: goto L16;
            }
        L16:
            goto L37
        L17:
            java.lang.String r4 = "makeVisible"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L20
            goto L37
        L20:
            r3 = 2
            goto L37
        L22:
            java.lang.String r4 = "closeWebview"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L2b
            goto L37
        L2b:
            r3 = r1
            goto L37
        L2d:
            java.lang.String r4 = "getCurrentVisibleState"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L36
            goto L37
        L36:
            r3 = r6
        L37:
            switch(r3) {
                case 0: goto L5b;
                case 1: goto L4f;
                case 2: goto L3b;
                default: goto L3a;
            }
        L3a:
            goto L71
        L3b:
            com.bytedance.sdk.component.uA.vS r0 = r5.Sj
            if (r0 == 0) goto L4b
            r7.put(r2, r1)
            com.bytedance.sdk.openadsdk.Ym.Sj.Fmk$2 r6 = new com.bytedance.sdk.openadsdk.Ym.Sj.Fmk$2
            r6.<init>()
            com.bytedance.sdk.openadsdk.utils.JcM.Sj(r6)
            goto L71
        L4b:
            r7.put(r2, r6)
            goto L71
        L4f:
            com.bytedance.sdk.openadsdk.Ym.Sj.Fmk$1 r6 = new com.bytedance.sdk.openadsdk.Ym.Sj.Fmk$1
            r6.<init>()
            com.bytedance.sdk.openadsdk.utils.JcM.Sj(r6)
            r7.put(r2, r1)
            goto L71
        L5b:
            com.bytedance.sdk.openadsdk.core.model.sU r6 = r5.EjP
            if (r6 == 0) goto L71
            com.bytedance.sdk.component.uA.vS r0 = r5.Sj
            r2 = 20
            int r6 = r6.DKj()
            boolean r6 = com.bytedance.sdk.openadsdk.core.LD.Sj(r0, r2, r6)
            r6 = r6 ^ r1
            java.lang.String r0 = "visibleState"
            r7.put(r0, r6)
        L71:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.Ym.Sj.Fmk.Sj(org.json.JSONObject, com.bytedance.sdk.component.Sj.vS):org.json.JSONObject");
    }
}
