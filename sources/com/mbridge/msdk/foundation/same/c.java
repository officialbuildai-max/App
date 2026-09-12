package com.mbridge.msdk.foundation.same;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c {

    /* loaded from: classes5.dex */
    public static abstract class a {
        public abstract void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar);
    }

    public static long a(long j11, long j12) {
        return j11 >= 0 ? j11 : j12;
    }

    public static String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return sb2.toString();
                }
                sb2.append(new String(bArr, 0, read));
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(List<CampaignEx> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < list.size(); i11++) {
                try {
                    CampaignEx campaignEx = list.get(i11);
                    if (campaignEx != null) {
                        String id2 = campaignEx.getId();
                        if (i11 == list.size() - 1) {
                            sb2.append(id2);
                        } else {
                            sb2.append(id2);
                            sb2.append(",");
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return sb2.toString();
        }
        return "";
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : str.split(UrlUtils.AND_MARK)) {
                String[] split = str2.split(UrlUtils.EQUAL_MARK);
                String str3 = "";
                if (split.length == 2) {
                    String str4 = split[0];
                    if (!TextUtils.isEmpty(str4)) {
                        String str5 = split[1];
                        if (str5 != null) {
                            str3 = str5;
                        }
                        jSONObject.put(str4, str3);
                    }
                } else if (split.length == 1) {
                    String str6 = split[0];
                    if (!TextUtils.isEmpty(str6)) {
                        jSONObject.put(str6, "");
                    }
                }
            }
            return jSONObject;
        } catch (Exception e11) {
            o0.a("SameCommon", "coverReportMessage", e11);
            return null;
        } catch (Throwable th2) {
            o0.a("SameCommon", "coverReportMessage", th2);
            return null;
        }
    }

    public static void a(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.c cVar, a aVar) {
        a(campaignEx, context, cVar, aVar, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(com.mbridge.msdk.foundation.entity.CampaignEx r9, android.content.Context r10, com.mbridge.msdk.foundation.same.report.metrics.c r11, com.mbridge.msdk.foundation.same.c.a r12, int r13) {
        /*
            java.lang.String r0 = "m_campaign_ind_unretarget"
            java.lang.String r1 = "m_campaign_ind_retarget"
            if (r9 == 0) goto Lae
            if (r12 == 0) goto Lae
            if (r11 != 0) goto L13
            com.mbridge.msdk.foundation.same.report.metrics.c r11 = new com.mbridge.msdk.foundation.same.report.metrics.c     // Catch: java.lang.Exception -> L10
            r11.<init>()     // Catch: java.lang.Exception -> L10
            goto L13
        L10:
            r9 = move-exception
            goto La7
        L13:
            boolean r2 = com.mbridge.msdk.foundation.tools.t0.c(r9)     // Catch: java.lang.Exception -> L10
            java.lang.String r3 = r9.getPackageName()     // Catch: java.lang.Exception -> L10
            int r3 = com.mbridge.msdk.foundation.tools.t0.d(r10, r3)     // Catch: java.lang.Exception -> L10
            r4 = 0
            r5 = 1
            if (r10 == 0) goto L37
            boolean r10 = com.mbridge.msdk.foundation.tools.f.b(r10)     // Catch: java.lang.Exception -> L2d
            if (r10 == 0) goto L2b
            r10 = r5
            goto L38
        L2b:
            r10 = 2
            goto L38
        L2d:
            r10 = move-exception
            java.lang.String r6 = "SameCommon"
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Exception -> L10
            com.mbridge.msdk.foundation.tools.o0.b(r6, r10)     // Catch: java.lang.Exception -> L10
        L37:
            r10 = r4
        L38:
            com.mbridge.msdk.foundation.same.report.metrics.e r6 = new com.mbridge.msdk.foundation.same.report.metrics.e     // Catch: java.lang.Exception -> L10
            r6.<init>()     // Catch: java.lang.Exception -> L10
            java.lang.String r7 = "cid"
            java.lang.String r8 = r9.getId()     // Catch: java.lang.Exception -> L10
            r6.a(r7, r8)     // Catch: java.lang.Exception -> L10
            java.lang.String r7 = "wtick"
            int r8 = r9.getWtick()     // Catch: java.lang.Exception -> L10
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Exception -> L10
            r6.a(r7, r8)     // Catch: java.lang.Exception -> L10
            java.lang.String r7 = "retarget_offer"
            int r9 = r9.getRetarget_offer()     // Catch: java.lang.Exception -> L10
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Exception -> L10
            r6.a(r7, r9)     // Catch: java.lang.Exception -> L10
            java.lang.String r9 = "ind"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> L10
            r6.a(r9, r7)     // Catch: java.lang.Exception -> L10
            java.lang.String r9 = "stage"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch: java.lang.Exception -> L10
            r6.a(r9, r13)     // Catch: java.lang.Exception -> L10
            java.lang.String r9 = "ac"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> L10
            r6.a(r9, r13)     // Catch: java.lang.Exception -> L10
            java.lang.String r9 = "per"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Exception -> L10
            r6.a(r9, r10)     // Catch: java.lang.Exception -> L10
            java.lang.String r9 = "m_campaign_filtered"
            if (r2 == 0) goto L97
            if (r3 == r5) goto L90
            r11.a(r9, r6)     // Catch: java.lang.Exception -> L10
            r12.a(r9, r11)     // Catch: java.lang.Exception -> L10
        L90:
            r11.a(r1, r6)     // Catch: java.lang.Exception -> L10
            r12.a(r1, r11)     // Catch: java.lang.Exception -> L10
            goto Lae
        L97:
            if (r3 == r5) goto L9a
            goto La0
        L9a:
            r11.a(r9, r6)     // Catch: java.lang.Exception -> L10
            r12.a(r9, r11)     // Catch: java.lang.Exception -> L10
        La0:
            r11.a(r0, r6)     // Catch: java.lang.Exception -> L10
            r12.a(r0, r11)     // Catch: java.lang.Exception -> L10
            goto Lae
        La7:
            boolean r10 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r10 == 0) goto Lae
            r9.printStackTrace()
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.c.a(com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, com.mbridge.msdk.foundation.same.report.metrics.c, com.mbridge.msdk.foundation.same.c$a, int):void");
    }

    public static boolean a(Context context, CampaignEx campaignEx) {
        if (context != null && campaignEx != null) {
            boolean c11 = t0.c(context, campaignEx.getPackageName());
            boolean c12 = t0.c(campaignEx);
            if (campaignEx.getWtick() == 1) {
                return true;
            }
            if (c12 && c11) {
                return true;
            }
            if (!c12 && !c11) {
                return true;
            }
        }
        return false;
    }

    public static String b(List<CampaignEx> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null && campaignEx.getCreativeId() != 0) {
                arrayList.add(campaignEx);
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            try {
                CampaignEx campaignEx2 = (CampaignEx) arrayList.get(i11);
                if (campaignEx2 != null) {
                    long creativeId = campaignEx2.getCreativeId();
                    if (i11 == arrayList.size() - 1) {
                        sb2.append(creativeId);
                    } else {
                        sb2.append(creativeId);
                        sb2.append(",");
                    }
                }
            } catch (Exception e11) {
                o0.b("SameCommon", "getCreativeID", e11);
            }
        }
        return sb2.toString();
    }

    public static boolean b(Context context, CampaignEx campaignEx) {
        if (context != null && campaignEx != null) {
            boolean c11 = t0.c(context, campaignEx.getPackageName());
            if (t0.c(campaignEx) || campaignEx.getWtick() == 1 || !c11) {
                return true;
            }
        }
        return false;
    }

    public static byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split("\\.");
            if (split.length != 4) {
                return null;
            }
            byte[] bArr = new byte[4];
            for (int i11 = 0; i11 < 4; i11++) {
                int parseInt = Integer.parseInt(split[i11]);
                if (parseInt >= 0 && parseInt <= 255) {
                    bArr[i11] = (byte) parseInt;
                }
                return null;
            }
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }
}
