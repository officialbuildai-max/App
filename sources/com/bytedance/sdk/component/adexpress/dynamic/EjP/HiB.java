package com.bytedance.sdk.component.adexpress.dynamic.EjP;

import android.text.TextUtils;
import com.cloud.tmc.integration.event.EventConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class HiB {
    public static final Map<String, Integer> Sj;
    private vS EjP;
    private vS HiB;
    private String TKC;
    private String sP;
    private String vS;

    static {
        HashMap hashMap = new HashMap();
        Sj = hashMap;
        hashMap.put("root", 8);
        hashMap.put("footer", 6);
        hashMap.put("empty", 6);
        hashMap.put(CampaignEx.JSON_KEY_TITLE, 0);
        hashMap.put("subtitle", 0);
        hashMap.put(EventConstants.KEY_SOURCE, 0);
        hashMap.put("score-count", 0);
        hashMap.put("text_star", 0);
        hashMap.put(MimeTypes.BASE_TYPE_TEXT, 0);
        hashMap.put("tag-group", 17);
        hashMap.put("app-version", 0);
        hashMap.put("development-name", 0);
        hashMap.put("privacy-detail", 23);
        hashMap.put("image", 1);
        hashMap.put("image-wide", 1);
        hashMap.put("image-square", 1);
        hashMap.put("image-long", 1);
        hashMap.put("image-splash", 1);
        hashMap.put("image-cover", 1);
        hashMap.put("app-icon", 1);
        hashMap.put("icon-download", 1);
        hashMap.put("logoad", 4);
        hashMap.put("logounion", 5);
        hashMap.put("logo-union", 9);
        hashMap.put("dislike", 3);
        hashMap.put("close", 3);
        hashMap.put("close-fill", 3);
        hashMap.put("webview-close", 22);
        hashMap.put("feedback-dislike", 12);
        hashMap.put("button", 2);
        hashMap.put("downloadWithIcon", 2);
        hashMap.put("downloadButton", 2);
        hashMap.put("fillButton", 2);
        hashMap.put("laceButton", 2);
        hashMap.put("cardButton", 2);
        hashMap.put("colourMixtureButton", 2);
        hashMap.put("arrowButton", 1);
        hashMap.put("download-progress-button", 2);
        hashMap.put("vessel", 6);
        hashMap.put("image-group", 6);
        hashMap.put("custom-component-vessel", 6);
        hashMap.put("carousel", 24);
        hashMap.put("carousel-vessel", 26);
        hashMap.put("leisure-interact", 25);
        hashMap.put("video-hd", 7);
        hashMap.put("video", 7);
        hashMap.put("video-vd", 7);
        hashMap.put("video-sq", 7);
        hashMap.put("muted", 10);
        hashMap.put("star", 11);
        hashMap.put("skip-countdowns", 19);
        hashMap.put("skip-with-countdowns-skip-btn", 21);
        hashMap.put("skip-with-countdowns-video-countdown", 13);
        hashMap.put("skip-with-countdowns-skip-countdown", 20);
        hashMap.put("skip-with-time", 14);
        hashMap.put("skip-with-time-countdown", 13);
        hashMap.put("skip-with-time-skip-btn", 15);
        hashMap.put("skip", 27);
        hashMap.put("timedown", 13);
        hashMap.put(RewardPlus.ICON, 16);
        hashMap.put("scoreCountWithIcon", 6);
        hashMap.put("split-line", 18);
        hashMap.put("creative-playable-bait", 0);
        hashMap.put("score-count-type-2", 0);
        hashMap.put("lottie", 28);
    }

    public String EjP() {
        return this.vS;
    }

    public vS HiB() {
        return this.EjP;
    }

    public vS Jcg() {
        return this.HiB;
    }

    public int Sj() {
        if (TextUtils.isEmpty(this.sP)) {
            return 0;
        }
        if (this.sP.equals("logo")) {
            String str = this.sP + this.TKC;
            this.sP = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.sP.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = Sj;
        if (map.get(this.sP) != null) {
            return map.get(this.sP).intValue();
        }
        return -1;
    }

    public void Sj(vS vSVar) {
        this.EjP = vSVar;
    }

    public void Sj(String str) {
        this.sP = str;
    }

    public String TKC() {
        return this.TKC;
    }

    public void TKC(String str) {
        this.vS = str;
    }

    public String sP() {
        return this.sP;
    }

    public void sP(vS vSVar) {
        this.HiB = vSVar;
    }

    public void sP(String str) {
        this.TKC = str;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.sP + "', data='" + this.TKC + "', value=" + this.EjP + ", themeValue=" + this.HiB + ", dataExtraInfo='" + this.vS + "'}";
    }

    public int vS() {
        return this.EjP.TFd();
    }
}
