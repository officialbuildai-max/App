package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.AabEntity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.Campaign;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes5.dex */
public class e extends com.mbridge.msdk.foundation.db.a<Campaign> {

    /* renamed from: r, reason: collision with root package name */
    private static e f35126r;

    /* renamed from: a, reason: collision with root package name */
    private final String f35127a;

    /* renamed from: b, reason: collision with root package name */
    private final String f35128b;

    /* renamed from: c, reason: collision with root package name */
    private final String f35129c;

    /* renamed from: d, reason: collision with root package name */
    private final String f35130d;

    /* renamed from: e, reason: collision with root package name */
    private final String f35131e;

    /* renamed from: f, reason: collision with root package name */
    private final String f35132f;

    /* renamed from: g, reason: collision with root package name */
    private final String f35133g;

    /* renamed from: h, reason: collision with root package name */
    private final String f35134h;

    /* renamed from: i, reason: collision with root package name */
    private final String f35135i;

    /* renamed from: j, reason: collision with root package name */
    private final String f35136j;

    /* renamed from: k, reason: collision with root package name */
    private final String f35137k;

    /* renamed from: l, reason: collision with root package name */
    private final String f35138l;

    /* renamed from: m, reason: collision with root package name */
    private final String f35139m;

    /* renamed from: n, reason: collision with root package name */
    private final String f35140n;

    /* renamed from: o, reason: collision with root package name */
    private final String f35141o;

    /* renamed from: p, reason: collision with root package name */
    private final String f35142p;

    /* renamed from: q, reason: collision with root package name */
    private final String f35143q;

    /* loaded from: classes5.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f35144a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f35145b;

        a(List list, String str) {
            this.f35144a = list;
            this.f35145b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f35144a.iterator();
            while (it.hasNext()) {
                e.this.a((CampaignEx) it.next(), this.f35145b, 0);
            }
        }
    }

    protected e(f fVar) {
        super(fVar);
        this.f35127a = "rid";
        this.f35128b = "lrid";
        this.f35129c = BidResponsedEx.KEY_CID;
        this.f35130d = CampaignEx.JSON_KEY_PLCT;
        this.f35131e = CampaignEx.JSON_KEY_PLCTB;
        this.f35132f = CampaignEx.JSON_KEY_TIMESTAMP;
        this.f35133g = "ridCount";
        this.f35134h = " WHERE ";
        this.f35135i = " AND ";
        this.f35136j = "SELECT ";
        this.f35137k = "*";
        this.f35138l = " FROM ";
        this.f35139m = " AND readyState = '0'";
        this.f35140n = " AND is_bid_campaign = 1";
        this.f35141o = " order by ts ASC";
        this.f35142p = " group by request_id";
        this.f35143q = " group by bid_token";
    }

    public static synchronized e a(f fVar) {
        e eVar;
        synchronized (e.class) {
            try {
                if (f35126r == null) {
                    f35126r = new e(fVar);
                }
                eVar = f35126r;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    private CampaignEx a(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        try {
            String string = cursor.getString(cursor.getColumnIndex("pv_urls"));
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    arrayList.add(jSONArray.getString(i11));
                }
                campaignEx.setPv_urls(arrayList);
            }
        } catch (JSONException e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
        campaignEx.setId(cursor.getString(cursor.getColumnIndex("id")));
        campaignEx.setTab(cursor.getInt(cursor.getColumnIndex("tab")));
        campaignEx.setPackageName(cursor.getString(cursor.getColumnIndex("package_name")));
        campaignEx.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
        campaignEx.setAppDesc(cursor.getString(cursor.getColumnIndex("app_desc")));
        campaignEx.setSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_APP_SIZE)));
        campaignEx.setImageSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_SIZE)));
        campaignEx.setIconUrl(cursor.getString(cursor.getColumnIndex("icon_url")));
        campaignEx.setImageUrl(cursor.getString(cursor.getColumnIndex("image_url")));
        campaignEx.setImpressionURL(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMPRESSION_URL)));
        campaignEx.setNoticeUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_NOTICE_URL)));
        campaignEx.setClickURL(cursor.getString(cursor.getColumnIndex("download_url")));
        campaignEx.setWtick(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
        campaignEx.setDeepLinkUrl(cursor.getString(cursor.getColumnIndex("deeplink_url")));
        campaignEx.setUserActivation(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_USER_ACTIVATION))));
        campaignEx.setOnlyImpressionURL(cursor.getString(cursor.getColumnIndex("only_impression")));
        campaignEx.setNetAddress(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I)));
        campaignEx.setAc(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME)));
        campaignEx.setAc_s(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH)));
        campaignEx.setTemplate(cursor.getInt(cursor.getColumnIndex("template")));
        campaignEx.setLandingType(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)));
        campaignEx.setLinkType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)));
        campaignEx.setClick_mode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_CLICK_MODE)));
        campaignEx.setRating(Double.parseDouble(cursor.getString(cursor.getColumnIndex("star"))));
        campaignEx.setNumberRating(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NUMBER_RATING)));
        campaignEx.setClickInterval(cursor.getInt(cursor.getColumnIndex("cti")));
        campaignEx.setTimestamp(cursor.getLong(cursor.getColumnIndex("ts")));
        campaignEx.setCacheLevel(cursor.getInt(cursor.getColumnIndex(PermissionConstant.level)));
        campaignEx.setAdCall(cursor.getString(cursor.getColumnIndex("ad_call")));
        campaignEx.setFcb(cursor.getInt(cursor.getColumnIndex("fc_b")));
        campaignEx.setAd_url_list(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_URL_LIST)));
        campaignEx.setVideoLength(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
        campaignEx.setVideoSize(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_SIZE)));
        campaignEx.setVideoResolution(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
        campaignEx.setEndcard_click_result(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_ENDCARD_CLICK)));
        campaignEx.setVideoUrlEncode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_URL)));
        campaignEx.setWatchMile(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WATCH_MILE)));
        campaignEx.setTImp(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_T_IMP)));
        campaignEx.setBty(cursor.getInt(cursor.getColumnIndex("bty")));
        campaignEx.setAdvImp(cursor.getString(cursor.getColumnIndex("advImp")));
        campaignEx.setLocalRequestId(cursor.getString(cursor.getColumnIndex("local_request_id")));
        campaignEx.setNRid(cursor.getString(cursor.getColumnIndex("n_request_id")));
        campaignEx.setNLRid(cursor.getString(cursor.getColumnIndex("n_local_request_id")));
        campaignEx.setTyped(cursor.getInt(cursor.getColumnIndex("err_type_default_ad")));
        campaignEx.setReasond(cursor.getString(cursor.getColumnIndex("err_reason_default_ad")));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setOfferType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_OFFER_TYPE)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL)));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL)));
        campaignEx.setEndScreenUrl(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_END_SCREEN_URL)));
        campaignEx.setRewardName(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_NAME)));
        campaignEx.setRewardAmount(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_AMOUNT)));
        campaignEx.setRewardPlayStatus(cursor.getInt(cursor.getColumnIndex("reward_play_status")));
        campaignEx.setRetarget_offer(cursor.getInt(cursor.getColumnIndex("retarget")));
        campaignEx.setCampaignUnitId(cursor.getString(cursor.getColumnIndex("unitid")));
        campaignEx.setNativeVideoTracking(CampaignEx.TrackingStr2Object(cursor.getString(cursor.getColumnIndex("native_ad_tracking"))));
        campaignEx.setNativeVideoTrackingString(cursor.getString(cursor.getColumnIndex("native_ad_tracking")));
        campaignEx.setVideo_end_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.VIDEO_END_TYPE)));
        campaignEx.setendcard_url(cursor.getString(cursor.getColumnIndex("endcard_url")));
        campaignEx.setPlayable_ads_without_video(cursor.getInt(cursor.getColumnIndex(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
        campaignEx.setMof_template_url(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TEMPLATE_URL)));
        campaignEx.setMof_tplid(cursor.getInt(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TPLID)));
        campaignEx.setRewardTemplateMode(CampaignEx.c.a(cursor.getString(cursor.getColumnIndex("reward_teamplate"))));
        campaignEx.setVideoMD5Value(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
        campaignEx.setGifUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GIF_URL)));
        campaignEx.setNvT2(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NV_T2)));
        campaignEx.setClickTimeOutInterval(cursor.getInt(cursor.getColumnIndex("c_coi")));
        campaignEx.setcUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_UA)));
        campaignEx.setImpUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_UA)));
        campaignEx.setJmPd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_JM_PD)));
        campaignEx.setIsDeleted(cursor.getInt(cursor.getColumnIndex("is_deleted")));
        campaignEx.setIsClick(cursor.getInt(cursor.getColumnIndex("is_click")));
        campaignEx.setIsAddSuccesful(cursor.getInt(cursor.getColumnIndex("is_add_sucesful")));
        campaignEx.setIsDownLoadZip(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_IS_DOWNLOAD)));
        campaignEx.setInteractiveCache(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_CACHE)));
        campaignEx.setKeyIaOri(cursor.getInt(cursor.getColumnIndex("ia_ori")));
        campaignEx.setAdType(cursor.getInt(cursor.getColumnIndex("ad_type")));
        campaignEx.setFac(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FAC)));
        campaignEx.setTpOffer(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_TP_OFFER)));
        campaignEx.setIa_ext1(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT1)));
        campaignEx.setIa_ext2(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT2)));
        campaignEx.setKeyIaRst(cursor.getInt(cursor.getColumnIndex("ia_rst")));
        campaignEx.setKeyIaUrl(cursor.getString(cursor.getColumnIndex("ia_url")));
        campaignEx.setKeyIaIcon(cursor.getString(cursor.getColumnIndex("ia_icon")));
        campaignEx.setOc_time(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TIME)));
        campaignEx.setOc_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TYPE)));
        campaignEx.setT_list(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_T_LIST)));
        campaignEx.setGhId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_ID)));
        campaignEx.setGhPath(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_PATH)));
        campaignEx.setBindId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_BIND_ID)));
        String string2 = cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ADCHOICE));
        if (!TextUtils.isEmpty(string2)) {
            campaignEx.setAdchoice(CampaignEx.a.c(string2));
        }
        campaignEx.setAdchoiceSizeHeight(cursor.getInt(cursor.getColumnIndex("adchoice_size_height")));
        campaignEx.setAdchoiceSizeWidth(cursor.getInt(cursor.getColumnIndex("adchoice_size_width")));
        campaignEx.setPlct(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCT)));
        campaignEx.setPlctb(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCTB)));
        campaignEx.setCandidateCacheTime(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_C_TIME)));
        campaignEx.setAdZip(cursor.getString(cursor.getColumnIndex("ad_zip")));
        campaignEx.setAdHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_HTML)));
        campaignEx.setBannerUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_URL)));
        campaignEx.setBannerHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_HTML)));
        campaignEx.setCreativeId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_CREATIVE_ID)));
        campaignEx.setVidCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID)));
        campaignEx.setEcCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_CREATIVE_ID)));
        campaignEx.setEcTemplateId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_TEMP_ID)));
        campaignEx.setIsBidCampaign(cursor.getInt(cursor.getColumnIndex("is_bid_campaign")) == 1);
        campaignEx.setBidToken(cursor.getString(cursor.getColumnIndex("bid_token")));
        campaignEx.setMraid(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MRAID)));
        campaignEx.setIsMraid(cursor.getInt(cursor.getColumnIndex("is_mraid_campaign")) == 1);
        campaignEx.setOmid(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_OMID)));
        campaignEx.setReady_rate(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_READY_RATE)));
        campaignEx.setExt_data(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_EXT_DATA)));
        campaignEx.setNscpt(cursor.getInt(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_NSCPT)));
        campaignEx.setReq_ext_data(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_REQ_EXT_DATA)));
        campaignEx.setReadyState(cursor.getInt(cursor.getColumnIndex("readyState")));
        campaignEx.setLoadTimeoutState(cursor.getInt(cursor.getColumnIndex("load_timeout")));
        campaignEx.setPlacementId(cursor.getString(cursor.getColumnIndex("placement_id")));
        campaignEx.setMaitve(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVE)));
        campaignEx.setMaitve_src(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVESRC)));
        campaignEx.setFlb(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB)));
        campaignEx.setFlbSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
        campaignEx.setCbd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
        campaignEx.setVst(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
        campaignEx.setUseSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_USE_SKIP_TIME)));
        campaignEx.setProgressBarShow(cursor.getColumnIndex(CampaignEx.JSON_KEY_PROG_BAR));
        campaignEx.setAdSpaceT(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
        campaignEx.setVcn(cursor.getInt(cursor.getColumnIndex("vcn")));
        campaignEx.setTokenRule(cursor.getInt(cursor.getColumnIndex("token_r")));
        campaignEx.setEncryptPrice(cursor.getString(cursor.getColumnIndex("encrypt_p")));
        campaignEx.setVideoCheckType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE)));
        campaignEx.setVideoCtnType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE)));
        campaignEx.setRsIgnoreCheckRuleByString(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE)));
        campaignEx.setVideoCompleteTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
        campaignEx.setAabEntity(AabEntity.parser(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AAB))));
        campaignEx.setPrivacyUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_PRIVACY_URL)));
        campaignEx.setPrivacyButtonTemplateVisibility(cursor.getInt(cursor.getColumnIndex("privacy_button_video")));
        campaignEx.setImpReportType(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_REPORT_TYPE));
        campaignEx.setAutoShowStoreMiniCard(cursor.getInt(cursor.getColumnIndex("auto_minicard")));
        campaignEx.setShowStoreMiniCardDelayTime(cursor.getInt(cursor.getColumnIndex("mincard_trigger_time")));
        campaignEx.setFilterAdsVideoCallState(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_SECOND_FILTER_AD_VIDEO_CALL_STATE)));
        campaignEx.setSecondRequestIndex(cursor.getInt(cursor.getColumnIndex("r_index")));
        campaignEx.setSecondShowIndex(cursor.getInt(cursor.getColumnIndex("s_show_index")));
        campaignEx.setFilterCallBackState(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE)));
        campaignEx.setFilterAdsShowCallState(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_SECOND_FILTER_AD_SHOW_CALL_STATE)));
        return campaignEx;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x074d, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x074b, code lost:
    
        if (r8 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0737, code lost:
    
        if (r8 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0751, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0754 A[Catch: all -> 0x0735, TRY_ENTER, TryCatch #1 {, blocks: (B:39:0x0730, B:10:0x074d, B:53:0x0754, B:54:0x0757), top: B:3:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> a(java.lang.String r8, java.lang.String[] r9) {
        /*
            Method dump skipped, instructions count: 1882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, java.lang.String[]):java.util.List");
    }

    public synchronized int a(String str, long j11) {
        try {
            com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d11 == null) {
                d11 = com.mbridge.msdk.setting.h.b().a();
            }
            long a02 = d11.a0() * 1000;
            b(a02, str);
            List<CampaignEx> a11 = a(str, 0, 0, 1, false);
            if (a11 != null && !a11.isEmpty()) {
                Iterator<CampaignEx> it = a11.iterator();
                while (it.hasNext()) {
                    if (!it.next().isSpareOffer(j11, a02)) {
                        return 0;
                    }
                }
                return 1;
            }
            return -1;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
            return 0;
        } finally {
        }
    }

    public synchronized long a(CampaignEx campaignEx, String str, int i11) {
        String[] strArr;
        String str2;
        if (campaignEx == null) {
            return 0L;
        }
        try {
            try {
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", campaignEx.getId());
                if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<String> it = campaignEx.getPv_urls().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    contentValues.put("pv_urls", jSONArray.toString());
                }
                contentValues.put("unitid", str);
                contentValues.put(TrackingKey.REQUEST_ID, campaignEx.getRequestId());
                contentValues.put("n_request_id", campaignEx.getNRid());
                contentValues.put("local_request_id", campaignEx.getLocalRequestId());
                contentValues.put("n_local_request_id", campaignEx.getNLRid());
                contentValues.put("err_type_default_ad", Integer.valueOf(campaignEx.getTyped()));
                contentValues.put("err_reason_default_ad", campaignEx.getReasond());
                contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
                contentValues.put("package_name", campaignEx.getPackageName());
                contentValues.put("app_name", campaignEx.getAppName());
                contentValues.put("app_desc", campaignEx.getAppDesc());
                contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
                contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
                contentValues.put("icon_url", campaignEx.getIconUrl());
                contentValues.put("image_url", campaignEx.getImageUrl());
                contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
                contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
                contentValues.put("download_url", campaignEx.getClickURL());
                contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
                contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
                contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
                contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I, campaignEx.getNetAddress());
                contentValues.put(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, Integer.valueOf(campaignEx.getAc_s()));
                contentValues.put(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, campaignEx.getAc());
                contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
                contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
                contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
                contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
                contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
                contentValues.put("star", Double.valueOf(campaignEx.getRating()));
                contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
                contentValues.put(PermissionConstant.level, Integer.valueOf(campaignEx.getCacheLevel()));
                contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
                contentValues.put("ad_call", campaignEx.getAdCall());
                contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
                contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
                contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
                contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
                contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
                contentValues.put("advImp", campaignEx.getAdvImp());
                contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
                contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
                contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
                contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
                contentValues.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, Integer.valueOf(campaignEx.getRewardAmount()));
                contentValues.put(CampaignEx.JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
                contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
                contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
                contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
                contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
                contentValues.put("endcard_url", campaignEx.getendcard_url());
                contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
                contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
                contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
                contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
                if (campaignEx.getRewardTemplateMode() != null) {
                    contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().d());
                }
                contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
                contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
                contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
                contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
                contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
                contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
                contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
                contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
                contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
                contentValues.put("ia_url", campaignEx.getKeyIaUrl());
                contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
                contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
                contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
                contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
                contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
                contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
                contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
                contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
                contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
                contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
                CampaignEx.a adchoice = campaignEx.getAdchoice();
                if (adchoice != null) {
                    contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.a());
                    contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.e()));
                    contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.f()));
                }
                contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
                contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
                contentValues.put(CampaignEx.JSON_KEY_C_C_TIME, Long.valueOf(campaignEx.getCandidateCacheTime()));
                contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
                contentValues.put("ad_zip", campaignEx.getAdZip());
                contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
                contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
                contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID, Long.valueOf(campaignEx.getVidCrtvId()));
                contentValues.put(CampaignEx.JSON_KEY_EC_CREATIVE_ID, Long.valueOf(campaignEx.getEcCrtvId()));
                contentValues.put(CampaignEx.JSON_KEY_EC_TEMP_ID, Long.valueOf(campaignEx.getEcTemplateId()));
                contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
                contentValues.put("bid_token", campaignEx.getBidToken());
                contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
                contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
                contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
                contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
                contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
                contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
                contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
                contentValues.put("placement_id", campaignEx.getPlacementId());
                contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
                contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
                contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
                contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
                contentValues.put(CampaignEx.JSON_KEY_USE_SKIP_TIME, Integer.valueOf(campaignEx.getUseSkipTime()));
                contentValues.put(CampaignEx.JSON_KEY_PROG_BAR, Integer.valueOf(campaignEx.getProgressBarShow()));
                contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
                contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
                contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
                contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
                contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
                contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
                contentValues.put(CampaignEx.JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
                contentValues.put("privacy_button_video", Integer.valueOf(campaignEx.getPrivacyButtonTemplateVisibility()));
                contentValues.put(CampaignEx.JSON_KEY_IMP_REPORT_TYPE, Integer.valueOf(campaignEx.getImpReportType()));
                if (campaignEx.getAabEntity() != null) {
                    contentValues.put(CampaignEx.JSON_KEY_AAB, campaignEx.getAabEntity().toJson().toString());
                }
                contentValues.put("auto_minicard", Integer.valueOf(campaignEx.getAutoShowStoreMiniCard()));
                contentValues.put("mincard_trigger_time", Integer.valueOf(campaignEx.getShowStoreMiniCardDelayTime()));
                contentValues.put(CampaignEx.KEY_SECOND_FILTER_AD_SHOW_CALL_STATE, Integer.valueOf(campaignEx.getFilterAdsShowCallState()));
                contentValues.put(CampaignEx.KEY_SECOND_FILTER_AD_VIDEO_CALL_STATE, Integer.valueOf(campaignEx.getFilterAdsVideoCallState()));
                contentValues.put(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(campaignEx.getFilterCallBackState()));
                contentValues.put("r_index", Integer.valueOf(campaignEx.getSecondRequestIndex()));
                contentValues.put("s_show_index", Integer.valueOf(campaignEx.getSecondShowIndex()));
                if (!a(campaignEx.getId(), campaignEx.getTab(), str, i11, campaignEx.getType(), campaignEx.isBidCampaign())) {
                    return getWritableDatabase().insert(MBInterstitialActivity.INTENT_CAMAPIGN, null, contentValues);
                }
                if (campaignEx.isBidCampaign()) {
                    str2 = "unitid = ? AND is_bid_campaign = 1";
                    strArr = new String[]{str};
                } else {
                    strArr = new String[]{campaignEx.getId(), str};
                    str2 = "id = ? AND unitid = ? AND is_bid_campaign = 0";
                }
                return getWritableDatabase().update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, str2, strArr);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CampaignDao", e11.getLocalizedMessage());
                }
                return -1L;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long a(CampaignEx campaignEx, String str, String str2, int i11) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            try {
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<String> it = campaignEx.getPv_urls().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    contentValues.put("pv_urls", jSONArray.toString());
                }
                contentValues.put("id", campaignEx.getId());
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                contentValues.put("placement_id", str);
                contentValues.put("unitid", str2);
                contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
                contentValues.put("package_name", campaignEx.getPackageName());
                contentValues.put("app_name", campaignEx.getAppName());
                contentValues.put("app_desc", campaignEx.getAppDesc());
                contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
                contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
                contentValues.put("icon_url", campaignEx.getIconUrl());
                contentValues.put("image_url", campaignEx.getImageUrl());
                contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
                contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
                contentValues.put("download_url", campaignEx.getClickURL());
                contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
                contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
                contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
                contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I, campaignEx.getNetAddress());
                contentValues.put(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, Integer.valueOf(campaignEx.getAc_s()));
                contentValues.put(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, campaignEx.getAc());
                contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
                contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
                contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
                contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
                contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
                contentValues.put("star", Double.valueOf(campaignEx.getRating()));
                contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
                contentValues.put(PermissionConstant.level, Integer.valueOf(campaignEx.getCacheLevel()));
                contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
                contentValues.put("ad_call", campaignEx.getAdCall());
                contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
                contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
                contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
                contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
                contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
                contentValues.put("advImp", campaignEx.getAdvImp());
                contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
                contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
                contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
                contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
                contentValues.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, Integer.valueOf(campaignEx.getRewardAmount()));
                contentValues.put(CampaignEx.JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
                contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
                contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
                contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
                contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
                contentValues.put("endcard_url", campaignEx.getendcard_url());
                contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
                contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
                contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
                contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
                if (campaignEx.getRewardTemplateMode() != null) {
                    contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().d());
                }
                contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
                contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
                contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
                contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
                contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
                contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
                contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
                contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
                contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
                contentValues.put("ia_url", campaignEx.getKeyIaUrl());
                contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
                contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
                contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
                contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
                contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
                contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
                contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
                contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
                contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
                contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
                CampaignEx.a adchoice = campaignEx.getAdchoice();
                if (adchoice != null) {
                    contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.a());
                    contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.e()));
                    contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.f()));
                }
                contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
                contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
                contentValues.put(CampaignEx.JSON_KEY_C_C_TIME, Long.valueOf(campaignEx.getCandidateCacheTime()));
                contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
                contentValues.put("ad_zip", campaignEx.getAdZip());
                contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
                contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
                contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID, Long.valueOf(campaignEx.getVidCrtvId()));
                contentValues.put(CampaignEx.JSON_KEY_EC_CREATIVE_ID, Long.valueOf(campaignEx.getEcCrtvId()));
                contentValues.put(CampaignEx.JSON_KEY_EC_TEMP_ID, Long.valueOf(campaignEx.getEcTemplateId()));
                contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
                contentValues.put("bid_token", campaignEx.getBidToken());
                contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
                contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
                contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
                contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
                contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
                contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
                contentValues.put(TrackingKey.REQUEST_ID, campaignEx.getRequestId());
                contentValues.put("n_request_id", campaignEx.getNRid());
                contentValues.put("local_request_id", campaignEx.getLocalRequestId());
                contentValues.put("n_local_request_id", campaignEx.getNLRid());
                contentValues.put("err_type_default_ad", Integer.valueOf(campaignEx.getTyped()));
                contentValues.put("err_reason_default_ad", campaignEx.getReasond());
                contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
                contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
                contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
                contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
                contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
                contentValues.put(CampaignEx.JSON_KEY_USE_SKIP_TIME, Integer.valueOf(campaignEx.getUseSkipTime()));
                contentValues.put(CampaignEx.JSON_KEY_PROG_BAR, Integer.valueOf(campaignEx.getProgressBarShow()));
                contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
                contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
                contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
                contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
                contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
                contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
                if (campaignEx.getAabEntity() != null) {
                    contentValues.put(CampaignEx.JSON_KEY_AAB, campaignEx.getAabEntity().toJson().toString());
                }
                contentValues.put(CampaignEx.JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
                contentValues.put("privacy_button_video", Integer.valueOf(campaignEx.getPrivacyButtonTemplateVisibility()));
                contentValues.put(CampaignEx.JSON_KEY_IMP_REPORT_TYPE, Integer.valueOf(campaignEx.getImpReportType()));
                contentValues.put("auto_minicard", Integer.valueOf(campaignEx.getAutoShowStoreMiniCard()));
                contentValues.put("mincard_trigger_time", Integer.valueOf(campaignEx.getShowStoreMiniCardDelayTime()));
                contentValues.put(CampaignEx.KEY_SECOND_FILTER_AD_SHOW_CALL_STATE, Integer.valueOf(campaignEx.getFilterAdsShowCallState()));
                contentValues.put(CampaignEx.KEY_SECOND_FILTER_AD_VIDEO_CALL_STATE, Integer.valueOf(campaignEx.getFilterAdsVideoCallState()));
                contentValues.put(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(campaignEx.getFilterCallBackState()));
                contentValues.put("r_index", Integer.valueOf(campaignEx.getSecondRequestIndex()));
                contentValues.put("s_show_index", Integer.valueOf(campaignEx.getSecondShowIndex()));
                return getWritableDatabase().insert(MBInterstitialActivity.INTENT_CAMAPIGN, null, contentValues);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CampaignDao", e11.getLocalizedMessage());
                }
                return -1L;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public List<CampaignEx> a(String str, int i11, int i12, int i13) {
        String str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(String.valueOf(i12));
        arrayList.add(String.valueOf(i13));
        if (i11 > 0) {
            arrayList.add(String.valueOf(i11));
            str2 = " LIMIT ?";
        } else {
            str2 = "";
        }
        return a("SELECT * FROM campaign WHERE unitid = ? AND level = ? AND adSource = ?" + str2, (String[]) arrayList.toArray(new String[0]));
    }

    public synchronized List<CampaignEx> a(String str, int i11, int i12, int i13, String str2) {
        String str3;
        ArrayList arrayList;
        String str4;
        try {
            str3 = (" WHERE unitid = ?  AND level = ?  AND adSource = ?  AND is_bid_campaign = 1") + " AND readyState = '0'";
            arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(String.valueOf(i12));
            arrayList.add(String.valueOf(i13));
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + " AND request_id = ? ";
                arrayList.add(str2);
            }
            str4 = "";
            if (i11 > 0) {
                str4 = " LIMIT ?";
                arrayList.add(String.valueOf(i11));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return a("SELECT * FROM campaign" + (str3 + " order by ts ASC") + str4, (String[]) arrayList.toArray(new String[0]));
    }

    public synchronized List<CampaignEx> a(String str, int i11, int i12, int i13, boolean z10) {
        ArrayList arrayList;
        String str2;
        String str3;
        try {
            arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(String.valueOf(i12));
            arrayList.add(String.valueOf(i13));
            if (z10) {
                str2 = " WHERE unitid = ? AND level = ? AND adSource = ? AND is_bid_campaign = 1";
            } else {
                str2 = " WHERE unitid = ? AND level = ? AND adSource = ? AND is_bid_campaign = 0";
            }
            str3 = "";
            if (i11 > 0) {
                str3 = " LIMIT ?";
                arrayList.add(String.valueOf(i11));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return a("SELECT * FROM campaign" + str2 + str3, (String[]) arrayList.toArray(new String[0]));
    }

    public synchronized void a() {
        try {
            String[] strArr = {String.valueOf(System.currentTimeMillis() - 3600000)};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(MBInterstitialActivity.INTENT_CAMAPIGN, "ts< ? AND ts>0", strArr);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
    }

    public synchronized void a(long j11, String str) {
        try {
            String[] strArr = {String.valueOf(System.currentTimeMillis() - j11), str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(MBInterstitialActivity.INTENT_CAMAPIGN, "ts< ? and unitid= ? ", strArr);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
    }

    public synchronized void a(String str) {
        String[] strArr;
        try {
            strArr = new String[]{str};
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete(MBInterstitialActivity.INTENT_CAMAPIGN, "unitid = ? ", strArr);
    }

    public synchronized void a(String str, int i11, int i12) {
        String[] strArr;
        try {
            strArr = new String[]{str, String.valueOf(i11), String.valueOf(i12)};
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete(MBInterstitialActivity.INTENT_CAMAPIGN, "unitid = ? AND level = ? AND adSource = ? ", strArr);
    }

    public synchronized void a(String str, int i11, int i12, boolean z10) {
        String str2;
        String[] strArr;
        try {
            str2 = "unitid = ? AND level = ? AND adSource = ?  AND is_bid_campaign = ? ";
            strArr = new String[]{str, String.valueOf(i11), String.valueOf(i12), String.valueOf(z10 ? 1 : 0)};
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete(MBInterstitialActivity.INTENT_CAMAPIGN, str2, strArr);
    }

    public synchronized void a(String str, int i11, boolean z10) {
        String str2;
        String[] strArr;
        try {
            try {
                if (z10) {
                    str2 = "placement_id = ? AND ad_type = ? ";
                    strArr = new String[]{str, String.valueOf(i11)};
                } else {
                    str2 = "ad_type = " + i11;
                    strArr = new String[]{String.valueOf(i11)};
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CampaignDao", e11.getLocalizedMessage());
                }
            }
            if (getWritableDatabase() == null) {
                return;
            }
            getWritableDatabase().delete(MBInterstitialActivity.INTENT_CAMAPIGN, str2, strArr);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(String str, CampaignEx campaignEx, boolean z10, String str2) {
        try {
            try {
                StringBuilder sb2 = new StringBuilder();
                if (campaignEx == null && !TextUtils.isEmpty(str2)) {
                    sb2.append("unitid");
                    sb2.append(" = ? AND ");
                    sb2.append(TrackingKey.REQUEST_ID);
                    sb2.append(" = ?");
                } else if (campaignEx != null && campaignEx.getLoadTimeoutState() == 0) {
                    sb2.append("unitid");
                    sb2.append(" = ? AND ");
                    sb2.append("id");
                    sb2.append(" = ? AND ");
                    sb2.append(TrackingKey.REQUEST_ID);
                    sb2.append(" = ?");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                if (campaignEx == null || campaignEx.getLoadTimeoutState() != 0) {
                    arrayList.add(str2);
                } else {
                    arrayList.add(String.valueOf(campaignEx.getId()));
                    arrayList.add(campaignEx.getRequestId());
                }
                if (!TextUtils.isEmpty(sb2)) {
                    if (q0.a().a("c_n_c_s", true)) {
                        sb2.append(" AND readyState");
                        sb2.append(" != 0");
                    }
                    if (z10) {
                        sb2.append(" AND is_bid_campaign = 1");
                    } else {
                        sb2.append(" AND is_bid_campaign = 0");
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("readyState", (Integer) 2);
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    if (writableDatabase != null) {
                        writableDatabase.update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, sb2.toString(), strArr);
                    }
                }
            } catch (SQLException e11) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(String str, String str2) {
        try {
        } catch (Exception e11) {
            o0.b("CampaignDao", e11.getLocalizedMessage());
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String[] strArr = {str, str2};
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            getWritableDatabase().update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, "unitid = ? AND bid_token = ? AND bid_token IS NOT NULL", strArr);
        }
    }

    public synchronized void a(String str, String str2, int i11, int i12, boolean z10) {
        String[] strArr;
        String str3;
        try {
            try {
                strArr = new String[]{str, str2, String.valueOf(i11), String.valueOf(i12)};
                if (z10) {
                    str3 = "id = ? AND unitid = ? AND level = ? AND adSource = ?  AND is_bid_campaign = 1";
                } else {
                    str3 = "id = ? AND unitid = ? AND level = ? AND adSource = ?  AND is_bid_campaign = 0";
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CampaignDao", e11.getLocalizedMessage());
                }
            }
            if (getWritableDatabase() == null) {
                return;
            }
            getWritableDatabase().delete(MBInterstitialActivity.INTENT_CAMAPIGN, str3, strArr);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(String str, String str2, String str3) {
        try {
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete(MBInterstitialActivity.INTENT_CAMAPIGN, "unitid = ? AND (local_request_id = ?  OR local_request_id = ? )", new String[]{str, str2, str3});
    }

    public synchronized void a(String str, String str2, boolean z10, String str3) {
        String[] strArr;
        try {
            try {
                strArr = new String[]{str, str2, z10 ? "1" : "0", str3};
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CampaignDao", e11.getLocalizedMessage());
                }
            }
            if (getWritableDatabase() == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            getWritableDatabase().update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, "id = ? AND unitid = ? AND is_bid_campaign = ? AND request_id = ? ", strArr);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(String str, List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (CampaignEx campaignEx : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", (Integer) 2);
                        String str2 = "id = ? AND unitid = ? AND request_id = ?  AND is_bid_campaign = ? ";
                        String[] strArr = {campaignEx.getId(), str, campaignEx.getRequestId(), campaignEx.isBidCampaign() ? "1" : "0"};
                        try {
                            SQLiteDatabase writableDatabase = getWritableDatabase();
                            if (writableDatabase != null) {
                                writableDatabase.update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, str2, strArr);
                            }
                        } catch (SQLException e11) {
                            if (MBridgeConstans.DEBUG) {
                                o0.b("CampaignDao", e11.getLocalizedMessage());
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized void a(String str, List<CampaignEx> list, String str2) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("local_request_id", str2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, "unitid = ? AND id = ? AND request_id = ? ", new String[]{str, campaignEx.getId(), campaignEx.getRequestId()});
                        }
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("CampaignDao", e11.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    public synchronized void a(String str, List<CampaignEx> list, String str2, int i11) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && !TextUtils.isEmpty(str2)) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            try {
                for (CampaignEx campaignEx : list) {
                    if (campaignEx != null) {
                        String[] strArr = {str, campaignEx.getId(), campaignEx.getRequestId()};
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(str2, Integer.valueOf(i11));
                        writableDatabase.update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, "unitid = ? AND id = ? AND request_id = ? ", strArr);
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CampaignDao", e11.getLocalizedMessage());
                }
            }
        }
    }

    public synchronized void a(String str, List<CampaignEx> list, List<CampaignEx> list2, boolean z10) {
        if (getWritableDatabase() == null) {
            return;
        }
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (CampaignEx campaignEx : list) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("readyState", (Integer) 0);
                            String[] strArr = {str, campaignEx.getId(), campaignEx.getRequestId()};
                            getWritableDatabase().update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, z10 ? "unitid = ? AND id = ? AND request_id = ?  AND is_bid_campaign = 1" : "unitid = ? AND id = ? AND request_id = ?  AND is_bid_campaign = 0", strArr);
                        } catch (Exception e11) {
                            if (MBridgeConstans.DEBUG) {
                                o0.b("CampaignDao", e11.getLocalizedMessage());
                            }
                        }
                    }
                }
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CampaignDao", e12.getLocalizedMessage());
                }
            } finally {
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (CampaignEx campaignEx2 : list2) {
                try {
                    if (campaignEx2.getLoadTimeoutState() == 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("unitid");
                        sb2.append(" = ? AND ");
                        sb2.append("id");
                        sb2.append(" = ? AND ");
                        sb2.append(TrackingKey.REQUEST_ID);
                        sb2.append(" = ? ");
                        String[] strArr2 = {str, campaignEx2.getId(), campaignEx2.getRequestId()};
                        if (z10) {
                            sb2.append(" AND is_bid_campaign = 1");
                        } else {
                            sb2.append(" AND is_bid_campaign = 0");
                        }
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("readyState", (Integer) 2);
                        getWritableDatabase().update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues2, sb2.toString(), strArr2);
                    }
                } catch (SQLException e13) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("CampaignDao", e13.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public synchronized void a(String str, List<CampaignEx> list, boolean z10) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    a(str, campaignEx, z10, campaignEx.getRequestId());
                }
            }
        }
    }

    public synchronized void a(List<CampaignEx> list, String str) {
        if (list != null) {
            if (list.size() != 0) {
                new Thread(new a(list, str)).start();
            }
        }
    }

    public synchronized void a(List<CampaignEx> list, String str, String str2, int i11) {
        if (list != null) {
            if (list.size() != 0) {
                if (getWritableDatabase() == null) {
                    return;
                }
                Iterator<CampaignEx> it = list.iterator();
                while (it.hasNext()) {
                    a(it.next(), str, str2, i11);
                }
            }
        }
    }

    public synchronized boolean a(String str, int i11, String str2, int i12, int i13, boolean z10) {
        String[] strArr;
        String str3;
        try {
            if (z10) {
                str3 = "SELECT id FROM campaign WHERE unitid = ? AND is_bid_campaign = 1";
                strArr = new String[]{str2};
            } else {
                strArr = new String[]{str, String.valueOf(i11), str2, String.valueOf(i12), String.valueOf(i13)};
                str3 = "SELECT id FROM campaign WHERE id= ? AND tab= ? AND unitid = ? AND level = ? AND adSource = ? AND is_bid_campaign = 0";
            }
            Cursor rawQuery = getReadableDatabase().rawQuery(str3, strArr);
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.close();
                return true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized List<CampaignEx> b(String str, int i11, int i12, int i13) {
        ArrayList arrayList;
        String str2;
        try {
            arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(String.valueOf(i12));
            arrayList.add(String.valueOf(i13));
            str2 = "";
            if (i11 > 0) {
                str2 = " LIMIT ?";
                arrayList.add(String.valueOf(i11));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return a("SELECT * FROM campaign WHERE unitid = ? AND level = ? AND adSource = ?" + str2, (String[]) arrayList.toArray(new String[0]));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> b(java.lang.String r4, int r5, boolean r6) {
        /*
            r3 = this;
            r0 = 0
            if (r6 == 0) goto L14
            java.lang.String r6 = "placement_id = ? AND ad_type = ? "
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            goto L1e
        Le:
            r4 = move-exception
            goto L7b
        L11:
            r4 = move-exception
            r5 = r0
            goto L64
        L14:
            java.lang.String r6 = "ad_type = ? "
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
        L1e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            r5.<init>()     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            java.lang.String r1 = "SELECT * FROM campaign WHERE "
            r5.append(r1)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            r5.append(r6)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            android.database.sqlite.SQLiteDatabase r6 = r3.getReadableDatabase()     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            android.database.Cursor r4 = r6.rawQuery(r5, r4)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
            if (r4 == 0) goto L61
            int r5 = r4.getCount()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5c
            if (r5 <= 0) goto L61
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5c
            r5.<init>()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L5c
        L44:
            boolean r6 = r4.moveToNext()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            if (r6 == 0) goto L58
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r3.a(r4)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            r5.add(r6)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            goto L44
        L52:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L7b
        L56:
            r6 = move-exception
            goto L5a
        L58:
            r0 = r5
            goto L61
        L5a:
            r0 = r4
            goto L68
        L5c:
            r5 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
            goto L64
        L61:
            if (r4 == 0) goto L7a
            goto L75
        L64:
            r6 = r4
            r2 = r0
            r0 = r5
            r5 = r2
        L68:
            java.lang.String r4 = "CampaignDao"
            java.lang.String r6 = r6.getLocalizedMessage()     // Catch: java.lang.Throwable -> Le
            com.mbridge.msdk.foundation.tools.o0.b(r4, r6)     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L79
            r4 = r0
            r0 = r5
        L75:
            r4.close()
            goto L7a
        L79:
            r0 = r5
        L7a:
            return r0
        L7b:
            if (r0 == 0) goto L80
            r0.close()
        L80:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.b(java.lang.String, int, boolean):java.util.List");
    }

    public synchronized void b(long j11, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = "(plctb>0 and (plctb* 1000+ts)< " + currentTimeMillis + " ) or (" + CampaignEx.JSON_KEY_PLCTB + "<=0 and ts< " + (currentTimeMillis - j11) + " ) and unitid=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(MBInterstitialActivity.INTENT_CAMAPIGN, str2, strArr);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
    }

    public synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArr = {str};
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete(MBInterstitialActivity.INTENT_CAMAPIGN, "unitid = ? AND readyState = 2", strArr);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
    }

    public synchronized void b(String str, String str2) {
        try {
            try {
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CampaignDao", e11.getLocalizedMessage());
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str3 = "unitid = ?";
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            if (!TextUtils.isEmpty(str2)) {
                str3 = "unitid = ? AND bid_token != ?";
                arrayList.add(str2);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            getWritableDatabase().update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, (str3 + " AND is_bid_campaign = 1") + " AND bid_token IS NOT NULL", (String[]) arrayList.toArray(new String[0]));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void b(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", (Integer) 0);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, "unitid = ? AND id = ? AND request_id = ? ", new String[]{str, campaignEx.getId(), campaignEx.getRequestId()});
                        }
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("CampaignDao", e11.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    public synchronized void b(List<CampaignEx> list, String str) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        String[] strArr = {str, campaignEx.getId(), campaignEx.getRequestId()};
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", (Integer) 2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, "unitid = ? AND id = ? AND " + TrackingKey.REQUEST_ID + " = ? ", strArr);
                        }
                    } catch (SQLException e11) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("CampaignDao", e11.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    public synchronized List<CampaignEx> c(String str) {
        try {
            try {
                Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM " + MBInterstitialActivity.INTENT_CAMAPIGN + " WHERE unitid = ? AND readyState = 2", new String[]{str});
                if (rawQuery == null || rawQuery.getCount() <= 0) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    arrayList.add(a(rawQuery));
                }
                rawQuery.close();
                return arrayList;
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CampaignDao", th2.getLocalizedMessage());
                }
                return null;
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
            return null;
        }
    }

    public synchronized void c(String str, String str2) {
        try {
            try {
            } catch (Exception e11) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String str3 = "";
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                str3 = "unitid = ? AND ";
                arrayList.add(str);
            }
            arrayList.add(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            getWritableDatabase().update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, str3 + "n_local_request_id = ? AND bid_token IS NOT NULL AND n_local_request_id IS NOT NULL", (String[]) arrayList.toArray(new String[0]));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00fb, code lost:
    
        if (r2 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0113, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0110, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010e, code lost:
    
        if (0 != 0) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.mbridge.msdk.foundation.entity.c> d(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.d(java.lang.String):java.util.List");
    }

    public synchronized void d(String str, String str2) {
        try {
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        String[] strArr = {str, str2};
        ContentValues contentValues = new ContentValues();
        contentValues.put("readyState", (Integer) 2);
        getWritableDatabase().update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, "id = ? AND request_id = ? ", strArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
    
        if (r2 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009b, code lost:
    
        if (0 == 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<java.lang.String> e(java.lang.String r7) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto Lc
            return r0
        Lc:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SELECT "
            r1.append(r2)
            java.lang.String r2 = "local_request_id"
            r1.append(r2)
            java.lang.String r2 = " as "
            r1.append(r2)
            java.lang.String r2 = "lrid"
            r1.append(r2)
            java.lang.String r2 = " FROM "
            r1.append(r2)
            java.lang.String r2 = "campaign"
            r1.append(r2)
            java.lang.String r2 = " WHERE "
            r1.append(r2)
            java.lang.String r2 = "unitid"
            r1.append(r2)
            java.lang.String r2 = " = ? AND "
            r1.append(r2)
            java.lang.String r2 = "readyState"
            r1.append(r2)
            java.lang.String r2 = " = ?"
            r1.append(r2)
            r2 = 0
            java.lang.Object r3 = new java.lang.Object     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
            r3.<init>()     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
            android.database.sqlite.SQLiteDatabase r4 = r6.getReadableDatabase()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8f
            r5 = 2
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L8f
            java.lang.String[] r7 = new java.lang.String[]{r7, r5}     // Catch: java.lang.Throwable -> L8f
            android.database.Cursor r2 = r4.rawQuery(r1, r7)     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L8c
            int r7 = r2.getCount()     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
            if (r7 <= 0) goto L8c
        L6d:
            boolean r7 = r2.moveToNext()     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
            if (r7 == 0) goto L8c
            java.lang.String r7 = "lrid"
            int r7 = r2.getColumnIndex(r7)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
            java.lang.String r7 = r2.getString(r7)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
            if (r1 == 0) goto L84
            goto L6d
        L84:
            r0.add(r7)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
            goto L6d
        L88:
            r7 = move-exception
            goto La1
        L8a:
            r7 = move-exception
            goto L92
        L8c:
            if (r2 == 0) goto La0
            goto L9d
        L8f:
            r7 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L8f
            throw r7     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
        L92:
            java.lang.String r1 = "CampaignDao"
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch: java.lang.Throwable -> L88
            com.mbridge.msdk.foundation.tools.o0.b(r1, r7)     // Catch: java.lang.Throwable -> L88
            if (r2 == 0) goto La0
        L9d:
            r2.close()
        La0:
            return r0
        La1:
            if (r2 == 0) goto La6
            r2.close()
        La6:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.e(java.lang.String):java.util.List");
    }

    public synchronized void e(String str, String str2) {
        String[] strArr;
        try {
            strArr = new String[]{str, str2};
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDao", e11.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete(MBInterstitialActivity.INTENT_CAMAPIGN, "id = ? AND unitid = ? ", strArr);
    }

    public int f(String str, String str2) {
        String[] strArr;
        String str3;
        if (TextUtils.isEmpty(str)) {
            strArr = new String[]{str2};
            str3 = "unitid = ?  AND is_bid_campaign = 1";
        } else {
            strArr = new String[]{str2, str};
            str3 = "unitid = ?  AND request_id = ?  AND is_bid_campaign = 1";
        }
        String str4 = str3 + " AND readyState = '0'";
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            return getWritableDatabase().update(MBInterstitialActivity.INTENT_CAMAPIGN, contentValues, str4, strArr);
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return 0;
            }
            o0.b("CampaignDao", e11.getLocalizedMessage());
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00db, code lost:
    
        if (r2 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f3, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f0, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ee, code lost:
    
        if (0 != 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.entity.c> f(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String[] r11 = new java.lang.String[]{r11}
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " WHERE unitid = ? AND level = 0 AND adSource = 1"
            r0.append(r1)
            java.lang.String r1 = " AND is_bid_campaign = 1"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " AND readyState = '0'"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SELECT request_id as rid, id as cid, plct as plct, plctb as plctb, ts as timestamp FROM campaign"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap
            r1.<init>()
            r2 = 0
            java.lang.Object r3 = new java.lang.Object     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r3.<init>()     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            monitor-enter(r3)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            android.database.sqlite.SQLiteDatabase r4 = r10.getReadableDatabase()     // Catch: java.lang.Throwable -> Lde
            android.database.Cursor r2 = r4.rawQuery(r0, r11)     // Catch: java.lang.Throwable -> Lde
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lde
            if (r2 == 0) goto Ldb
            int r11 = r2.getCount()     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            if (r11 <= 0) goto Ldb
        L56:
            boolean r11 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            if (r11 == 0) goto Ldb
            java.lang.String r11 = "rid"
            int r11 = r2.getColumnIndex(r11)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            java.lang.String r11 = r2.getString(r11)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            java.lang.String r0 = "cid"
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            java.lang.String r3 = "plct"
            int r3 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            long r3 = r2.getLong(r3)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            java.lang.String r5 = "plctb"
            int r5 = r2.getColumnIndex(r5)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            long r5 = r2.getLong(r5)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            java.lang.String r7 = "timestamp"
            int r7 = r2.getColumnIndex(r7)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            long r7 = r2.getLong(r7)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            boolean r9 = r1.containsKey(r11)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            if (r9 == 0) goto Lba
            java.lang.Object r9 = r1.get(r11)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            com.mbridge.msdk.foundation.entity.c r9 = (com.mbridge.msdk.foundation.entity.c) r9     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            if (r9 == 0) goto L56
            r9.a(r11)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r9.a(r3)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r9.b(r5)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r9.c(r7)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            java.util.List r11 = r9.c()     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            if (r11 == 0) goto L56
            java.util.List r11 = r9.c()     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r11.add(r0)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            goto L56
        Lb6:
            r11 = move-exception
            goto Lf4
        Lb8:
            r11 = move-exception
            goto Le1
        Lba:
            com.mbridge.msdk.foundation.entity.c r9 = new com.mbridge.msdk.foundation.entity.c     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r9.<init>()     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r9.a(r11)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r9.a(r3)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r9.b(r5)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r9.c(r7)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r3.<init>()     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r3.add(r0)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r9.a(r3)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            r1.put(r11, r9)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
            goto L56
        Ldb:
            if (r2 == 0) goto Lf3
            goto Lf0
        Lde:
            r11 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lde
            throw r11     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lb8
        Le1:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Throwable -> Lb6
            if (r0 == 0) goto Lee
            java.lang.String r0 = "CampaignDao"
            java.lang.String r11 = r11.getLocalizedMessage()     // Catch: java.lang.Throwable -> Lb6
            com.mbridge.msdk.foundation.tools.o0.b(r0, r11)     // Catch: java.lang.Throwable -> Lb6
        Lee:
            if (r2 == 0) goto Lf3
        Lf0:
            r2.close()
        Lf3:
            return r1
        Lf4:
            if (r2 == 0) goto Lf9
            r2.close()
        Lf9:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.f(java.lang.String):java.util.concurrent.ConcurrentHashMap");
    }
}
