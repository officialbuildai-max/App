package com.mbridge.msdk.foundation.same.net.wrapper;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.out.CustomInfoManager;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.setting.l;
import com.mbridge.msdk.tracker.network.k;
import com.meituan.android.walle.ChannelReader;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public class c {
    private static final String TAG = "c";
    protected Context mContext;

    public c(Context context) {
        if (context == null) {
            this.mContext = com.mbridge.msdk.foundation.controller.c.m().d();
        } else {
            this.mContext = context.getApplicationContext();
        }
    }

    private String asUrlParams(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb2 = new StringBuilder();
            try {
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = map.get(str);
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "";
                        }
                        sb2.append(UrlUtils.AND_MARK);
                        sb2.append(str);
                        sb2.append(UrlUtils.EQUAL_MARK);
                        sb2.append(str2);
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b(TAG, e11.getMessage());
                }
                sb2 = null;
            }
            if (sb2 != null && sb2.length() > 0) {
                return sb2.toString();
            }
        }
        return null;
    }

    private static com.mbridge.msdk.tracker.network.h<?> createRequest(int i11, int i12, String str, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j11) {
        if (i11 == 0) {
            return new k(i12, str, str2, j11, new i(bVar));
        }
        if (i11 != 1) {
            return null;
        }
        return new com.mbridge.msdk.tracker.network.i(i12, str, str2, j11, new i(bVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b0 A[Catch: Exception -> 0x00dc, TRY_ENTER, TryCatch #1 {Exception -> 0x00dc, blocks: (B:25:0x00b0, B:27:0x00b6, B:47:0x00c1, B:54:0x00e6, B:58:0x0103), top: B:23:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void post(int r14, java.lang.String r15, com.mbridge.msdk.foundation.same.net.wrapper.e r16, com.mbridge.msdk.foundation.same.net.b r17, boolean r18, boolean r19, java.lang.String r20, long r21) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.wrapper.c.post(int, java.lang.String, com.mbridge.msdk.foundation.same.net.wrapper.e, com.mbridge.msdk.foundation.same.net.b, boolean, boolean, java.lang.String, long):void");
    }

    public void addExtraParams(String str, e eVar) {
        if (eVar == null) {
            o0.b(TAG, "addExtraParams error, params is null,frame work error");
            return;
        }
        String a11 = Aa.a();
        if (a11 == null) {
            a11 = "";
        }
        eVar.a(ChannelReader.CHANNEL_KEY, a11);
        eVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.b().a() + "");
        eVar.a(MRAIDPresenter.OPEN, com.mbridge.msdk.foundation.same.a.S);
        if (com.mbridge.msdk.util.b.a() && !TextUtils.isEmpty(str) && str.contains("setting")) {
            String b11 = Aa.b();
            if (!TextUtils.isEmpty(b11)) {
                eVar.a("keyword", b11);
            }
        }
        String str2 = eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (str2 != null) {
            String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str2, str);
            if (!TextUtils.isEmpty(customInfoByUnitId)) {
                eVar.a("ch_info", customInfoByUnitId);
            }
            l e11 = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), str2);
            if (e11 != null && !TextUtils.isEmpty(e11.a())) {
                eVar.a("u_stid", e11.a());
            }
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
            eVar.a("dev_source", "2");
        }
        if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
            eVar.a("re_domain", "1");
        }
    }

    protected boolean canTrack() {
        return true;
    }

    public void choiceV3OrV5BySetting(int i11, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str, long j11) {
        e eVar2;
        com.mbridge.msdk.setting.g b11 = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
        int p02 = TextUtils.isEmpty(str) ? b11.p0() : b11.B();
        String a11 = com.mbridge.msdk.foundation.same.net.utils.d.h().a(str, p02);
        if (p02 < 2) {
            postV5(i11, a11, eVar, bVar, MBInterstitialActivity.INTENT_CAMAPIGN, j11);
            return;
        }
        if (p02 % 2 == 0) {
            eVar2 = eVar == null ? new e() : eVar;
            JSONArray b12 = com.mbridge.msdk.foundation.db.middle.b.a().b();
            if (b12 != null) {
                String jSONArray = b12.toString();
                int i12 = com.mbridge.msdk.foundation.same.net.utils.d.h().i();
                if (i12 > 0 && jSONArray.length() > i12) {
                    post(i11, a11, eVar2, bVar, MBInterstitialActivity.INTENT_CAMAPIGN, j11);
                    return;
                }
                eVar2.a(e.f35558k, jSONArray);
            }
        } else {
            eVar2 = eVar;
        }
        getLoadOrSetting(i11, a11, eVar2, bVar, MBInterstitialActivity.INTENT_CAMAPIGN, j11);
    }

    public void get(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j11) {
        get(i11, str, eVar, bVar, false, false, str2, j11);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void get(int r15, java.lang.String r16, com.mbridge.msdk.foundation.same.net.wrapper.e r17, com.mbridge.msdk.foundation.same.net.b r18, boolean r19, boolean r20, java.lang.String r21, long r22) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.wrapper.c.get(int, java.lang.String, com.mbridge.msdk.foundation.same.net.wrapper.e, com.mbridge.msdk.foundation.same.net.b, boolean, boolean, java.lang.String, long):void");
    }

    public void get(int i11, String str, Map<String, String> map, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j11) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("app_id", com.mbridge.msdk.foundation.controller.c.m().b());
        map.put("sdk_version", MBConfiguration.SDK_VERSION);
        map.put(TrackingKey.PLATFORM, "1");
        String asUrlParams = asUrlParams(map);
        if (!TextUtils.isEmpty(asUrlParams)) {
            str = str + UrlUtils.QUESTION_MARK + asUrlParams;
        }
        String str3 = str;
        if (MBridgeConstans.DEBUG) {
            o0.a("AppletsModel", "get wx scheme url = " + str3);
        }
        com.mbridge.msdk.tracker.network.h<?> createRequest = createRequest(i11, 0, str3, bVar, str2, j11);
        if (createRequest != null) {
            String str4 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            createRequest.a("local_id", str4);
            String str5 = map.get("ad_type");
            createRequest.a("ad_type", TextUtils.isEmpty(str5) ? "" : str5);
            createRequest.a(map);
            createRequest.d(canTrack());
            com.mbridge.msdk.tracker.network.l.a().b().a(createRequest);
        }
    }

    public void getCampaign(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, long j11) {
        e eVar2;
        try {
            com.mbridge.msdk.setting.g b11 = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
            int p02 = TextUtils.isEmpty(str) ? b11.p0() : b11.B();
            String a11 = com.mbridge.msdk.foundation.same.net.utils.d.h().a(str, p02);
            if (p02 < 2) {
                postV5(i11, a11, eVar, bVar, true, MBInterstitialActivity.INTENT_CAMAPIGN, j11);
                return;
            }
            if (p02 % 2 == 0) {
                eVar2 = eVar == null ? new e() : eVar;
                JSONArray b12 = com.mbridge.msdk.foundation.db.middle.b.a().b();
                if (b12 != null) {
                    String jSONArray = b12.toString();
                    int i12 = com.mbridge.msdk.foundation.same.net.utils.d.h().i();
                    if (i12 > 0 && jSONArray.length() > i12) {
                        post(i11, a11, eVar2, bVar, true, false, MBInterstitialActivity.INTENT_CAMAPIGN, j11);
                        return;
                    }
                    eVar2.a(e.f35558k, jSONArray);
                }
            } else {
                eVar2 = eVar;
            }
            get(i11, a11, eVar2, bVar, true, true, MBInterstitialActivity.INTENT_CAMAPIGN, j11);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b(TAG, e11.getMessage());
            }
        }
    }

    public void getLoadOrSetting(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j11) {
        getLoadOrSetting(i11, str, eVar, bVar, true, str2, j11);
    }

    public void getLoadOrSetting(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z10, String str2, long j11) {
        get(i11, str, eVar, bVar, z10, false, str2, j11);
    }

    public void post(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j11) {
        post(i11, str, eVar, bVar, false, false, str2, j11);
    }

    public void postFocusReport(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j11) {
        post(i11, str, eVar, bVar, false, true, str2, j11);
    }

    public void postV5(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j11) {
        String str3 = eVar.a().get(TmcConstants.EXTRA_APP_DEV_TOKEN);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        eVar.a("ts", currentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(currentTimeMillis + str3));
        post(i11, str, eVar, bVar, false, false, str2, j11);
    }

    public void postV5(int i11, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z10, String str2, long j11) {
        String str3 = eVar.a().get(TmcConstants.EXTRA_APP_DEV_TOKEN);
        if (str3 == null) {
            str3 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        eVar.a("ts", currentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(currentTimeMillis + str3));
        post(i11, str, eVar, bVar, z10, false, str2, j11);
    }
}
