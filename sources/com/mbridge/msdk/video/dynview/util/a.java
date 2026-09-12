package com.mbridge.msdk.video.dynview.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;

/* loaded from: classes5.dex */
public class a {
    public static int a(CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return 1;
        }
        return campaignEx.getRewardTemplateMode().b();
    }

    public static String a(long j11, Context context) {
        String p11 = k0.p(context);
        if (p11.startsWith("zh")) {
            if (p11.contains("TW") || p11.contains("HK")) {
                return j11 + " 秒後自動播放";
            }
            return j11 + " 秒后自动播放";
        }
        if (p11.startsWith("ja")) {
            return j11 + " 秒後自動的に再生 ";
        }
        if (p11.startsWith(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR)) {
            return "Automatische Wiedergabe nach " + j11 + " Sekunden";
        }
        if (p11.startsWith("ko")) {
            return j11 + " 초 후 자동 재생 ";
        }
        if (p11.startsWith("fr")) {
            return "Lecture de vidéo dans " + j11 + " secondes";
        }
        if (p11.startsWith("ar")) {
            return " ثوان" + j11 + "لعب تلقائيا بعد ";
        }
        if (p11.startsWith("ru")) {
            return "Автовоспроизведение через " + j11 + " секунд";
        }
        return "Auto play after " + j11 + " s";
    }

    public static String a(Context context, int i11) {
        String str = i11 == 1 ? "_por" : "_land";
        String p11 = k0.p(context);
        if (p11.startsWith("zh")) {
            return (p11.contains("TW") || p11.contains("HK")) ? "mbridge_reward_two_title_zh_trad" : "mbridge_reward_two_title_zh";
        }
        if (p11.startsWith("ja")) {
            return "mbridge_reward_two_title_japan" + str;
        }
        if (p11.startsWith(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR)) {
            return "mbridge_reward_two_title_germany" + str;
        }
        if (p11.startsWith("ko")) {
            return "mbridge_reward_two_title_korea" + str;
        }
        if (p11.startsWith("fr")) {
            return "mbridge_reward_two_title_france" + str;
        }
        if (p11.startsWith("ar")) {
            return "mbridge_reward_two_title_arabia" + str;
        }
        if (p11.startsWith("ru")) {
            return "mbridge_reward_two_title_russian" + str;
        }
        return "mbridge_reward_two_title_en" + str;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter;
                }
            }
            return "";
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
            return "";
        }
    }

    public static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            String queryParameter = parse.getQueryParameter("alecfc");
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("1");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int b(CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
            int f11 = campaignEx.getRewardTemplateMode().f();
            if (f11 != 302 && f11 != 802 && f11 != 902) {
                if (f11 == 904) {
                    if (!a(campaignEx.getRewardTemplateMode().e())) {
                        return -1;
                    }
                }
            }
            return -3;
        }
        return 100;
    }
}
