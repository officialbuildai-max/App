package com.bykv.vk.openvk.preload.geckox.statistic;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import com.bykv.vk.openvk.preload.geckox.utils.e;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.meituan.android.walle.ChannelReader;
import com.transsion.mpush.core.config.MsgShowStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {
    private static Integer a(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return Integer.valueOf(list.size());
    }

    public static void a(com.bykv.vk.openvk.preload.geckox.b bVar, com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar) {
        IStatisticMonitor q11 = bVar.q();
        if (q11 != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("params_for_special", "gecko");
                jSONObject.put("device_id", bVar.r());
                jSONObject.put("os", 0);
                jSONObject.put("app_version", bVar.o());
                jSONObject.put("api_version", "v3");
                jSONObject.put("aid", bVar.k());
                jSONObject.put("x_tt_logid", aVar.f20718e);
                jSONObject.put("http_status", aVar.f20720g);
                jSONObject.put("err_msg", aVar.f20717d);
                if (TextUtils.isEmpty(aVar.f20718e)) {
                    jSONObject.put("deployments_info", aVar.f20715b);
                    jSONObject.put("local_info", aVar.f20714a);
                    jSONObject.put("custom_info", aVar.f20716c);
                } else {
                    jSONObject.put("deployments_info", "");
                    jSONObject.put("local_info", "");
                    jSONObject.put("custom_info", "");
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Build.VERSION.SDK_INT);
                jSONObject.put("os_version", sb2.toString());
                jSONObject.put("device_platform", "android");
                jSONObject.put("device_model", Build.MODEL);
                jSONObject.put(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, aVar.f20719f);
                q11.upload("geckosdk_query_pkgs", jSONObject);
            } catch (Throwable th2) {
                GeckoLogger.w("gecko-debug-tag", "UploadStatistic.upload:", th2);
            }
        }
    }

    public static void a(final com.bykv.vk.openvk.preload.geckox.b bVar, a aVar) {
        StatisticModel statisticModel;
        ArrayList arrayList = new ArrayList();
        for (com.bykv.vk.openvk.preload.geckox.statistic.model.a aVar2 : aVar.a()) {
            if (aVar2.f20812d != null || aVar2.f20814f != 0) {
                if (aVar2.f20816h && aVar2.f20817i) {
                    StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel);
                    packageStatisticModel.statsType = 100;
                    packageStatisticModel.groupName = aVar2.f20810b;
                    packageStatisticModel.accessKey = aVar2.f20809a;
                    packageStatisticModel.channel = aVar2.f20811c;
                    packageStatisticModel.f20807ac = aVar2.f20822n;
                    packageStatisticModel.f20808id = aVar2.f20824p;
                    packageStatisticModel.patchId = aVar2.f20823o;
                    packageStatisticModel.downloadRetryTimes = a(aVar2.f20813e);
                    packageStatisticModel.downloadUrl = aVar2.f20812d;
                    packageStatisticModel.downloadFailRecords = b(aVar2.f20813e);
                    packageStatisticModel.downloadDuration = Long.valueOf(aVar2.f20815g - aVar2.f20814f);
                    if (!aVar2.f20818j) {
                        StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel2);
                        packageStatisticModel2.statsType = 100;
                        packageStatisticModel2.channel = aVar2.f20811c;
                        packageStatisticModel2.errCode = "403";
                        packageStatisticModel2.errMsg = aVar2.f20826r;
                        packageStatisticModel2.f20807ac = aVar2.f20822n;
                        packageStatisticModel2.patchId = aVar2.f20823o;
                        packageStatisticModel2.f20808id = aVar2.f20824p;
                        packageStatisticModel2.downloadRetryTimes = a(aVar2.f20813e);
                        packageStatisticModel2.downloadUrl = aVar2.f20812d;
                        packageStatisticModel2.downloadFailRecords = b(aVar2.f20813e);
                    } else if (aVar2.f20819k) {
                        StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel3);
                        packageStatisticModel3.accessKey = aVar2.f20809a;
                        packageStatisticModel3.groupName = aVar2.f20810b;
                        packageStatisticModel3.statsType = 102;
                        packageStatisticModel3.patchId = aVar2.f20823o;
                        packageStatisticModel3.f20808id = aVar2.f20824p;
                        packageStatisticModel3.channel = aVar2.f20811c;
                        packageStatisticModel3.activeCheckDuration = Long.valueOf(aVar2.f20820l - aVar2.f20815g);
                        packageStatisticModel3.applyDuration = Long.valueOf(aVar2.f20821m - aVar2.f20820l);
                    } else {
                        StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel4);
                        packageStatisticModel4.accessKey = aVar2.f20809a;
                        packageStatisticModel4.groupName = aVar2.f20810b;
                        packageStatisticModel4.statsType = 103;
                        packageStatisticModel4.errCode = "501";
                        packageStatisticModel4.channel = aVar2.f20811c;
                        packageStatisticModel4.patchId = aVar2.f20823o;
                        packageStatisticModel4.f20808id = aVar2.f20824p;
                        packageStatisticModel4.errMsg = aVar2.f20827s;
                        a(aVar2, arrayList);
                    }
                } else {
                    StatisticModel.PackageStatisticModel packageStatisticModel5 = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel5);
                    packageStatisticModel5.statsType = 101;
                    packageStatisticModel5.accessKey = aVar2.f20809a;
                    packageStatisticModel5.groupName = aVar2.f20810b;
                    packageStatisticModel5.channel = aVar2.f20811c;
                    packageStatisticModel5.f20807ac = aVar2.f20822n;
                    packageStatisticModel5.patchId = aVar2.f20823o;
                    packageStatisticModel5.f20808id = aVar2.f20824p;
                    packageStatisticModel5.downloadRetryTimes = a(aVar2.f20813e);
                    packageStatisticModel5.downloadUrl = aVar2.f20812d;
                    packageStatisticModel5.downloadFailRecords = b(aVar2.f20813e);
                    if (!aVar2.f20816h) {
                        packageStatisticModel5.errCode = MsgShowStatus.STATUS_MSG_EMPTY;
                        List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list = aVar2.f20813e;
                        if (list != null && !list.isEmpty()) {
                            packageStatisticModel5.errMsg = aVar2.f20813e.get(0).reason;
                        }
                    } else if (!aVar2.f20817i) {
                        packageStatisticModel5.errCode = MsgShowStatus.STATUS_APP_ERROR;
                        packageStatisticModel5.errMsg = aVar2.f20825q;
                    }
                    a(aVar2, arrayList);
                }
            }
            a(aVar2, arrayList);
        }
        Context a11 = bVar.a();
        arrayList.addAll(com.bykv.vk.openvk.preload.geckox.a.a.a(a11));
        if (arrayList.isEmpty()) {
            statisticModel = null;
        } else {
            Common common = new Common(bVar.k(), bVar.o(), bVar.r(), com.bykv.vk.openvk.preload.geckox.utils.a.b(a11), e.a(a11), bVar.l(), bVar.m());
            StatisticModel statisticModel2 = new StatisticModel();
            statisticModel2.common = common;
            statisticModel2.packages = arrayList;
            String uuid = UUID.randomUUID().toString();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((StatisticModel.PackageStatisticModel) it.next()).logId = uuid;
            }
            statisticModel = statisticModel2;
        }
        if (statisticModel == null || statisticModel.packages == null) {
            return;
        }
        IStatisticMonitor q11 = bVar.q();
        if (q11 != null) {
            try {
                for (StatisticModel.PackageStatisticModel packageStatisticModel6 : statisticModel.packages) {
                    Common common2 = statisticModel.common;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("params_for_special", "gecko");
                    jSONObject.put(TtmlNode.TAG_REGION, common2.region);
                    jSONObject.put("err_code", packageStatisticModel6.errCode);
                    jSONObject.put("err_msg", packageStatisticModel6.errMsg);
                    jSONObject.put("sdk_version", common2.sdkVersion);
                    jSONObject.put("access_key", packageStatisticModel6.accessKey);
                    jSONObject.put("stats_type", packageStatisticModel6.statsType);
                    jSONObject.put("device_id", common2.deviceId);
                    Long l11 = packageStatisticModel6.patchId;
                    jSONObject.put("patch_id", l11 == null ? 0L : l11.longValue());
                    jSONObject.put("group_name", packageStatisticModel6.groupName);
                    jSONObject.put("os", common2.f20795os);
                    jSONObject.put("app_version", common2.appVersion);
                    jSONObject.put("device_model", common2.deviceModel);
                    jSONObject.put(ChannelReader.CHANNEL_KEY, packageStatisticModel6.channel);
                    Long l12 = packageStatisticModel6.f20808id;
                    jSONObject.put("id", l12 == null ? 0L : l12.longValue());
                    jSONObject.put(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, common2.f20794ac);
                    Integer num = packageStatisticModel6.downloadRetryTimes;
                    jSONObject.put("download_retry_times", num == null ? 0 : num.intValue());
                    String str = packageStatisticModel6.downloadUrl;
                    Object obj = "";
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put("download_url", str);
                    jSONObject.put("download_duration", packageStatisticModel6.downloadDuration);
                    List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list2 = packageStatisticModel6.downloadFailRecords;
                    if (list2 != null) {
                        obj = list2;
                    }
                    jSONObject.put("download_fail_records", obj);
                    jSONObject.put("log_id", packageStatisticModel6.logId);
                    Long l13 = packageStatisticModel6.activeCheckDuration;
                    jSONObject.put("active_check_duration", l13 == null ? 0L : l13.longValue());
                    Long l14 = packageStatisticModel6.applyDuration;
                    jSONObject.put("apply_duration", l14 == null ? 0L : l14.longValue());
                    q11.upload("geckosdk_update_stats", jSONObject);
                }
            } catch (Throwable th2) {
                GeckoLogger.w("gecko-debug-tag", "UploadStatistic.upload:", th2);
            }
        }
        if (bVar.c()) {
            try {
                final String a12 = com.bykv.vk.openvk.preload.geckox.c.b.a().b().a(statisticModel);
                if (TextUtils.isEmpty(a12)) {
                    return;
                }
                final String str2 = "https://" + bVar.j() + "/gecko/server/packages/stats";
                com.bykv.vk.openvk.preload.geckox.b.g().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Response doPost;
                        for (int i11 = 0; i11 < 3; i11++) {
                            try {
                                doPost = com.bykv.vk.openvk.preload.geckox.b.this.i().doPost(str2, a12);
                            } catch (Exception e11) {
                                GeckoLogger.w("gecko-debug-tag", "upload statistic:", e11);
                            }
                            if (doPost.code != 200) {
                                throw new NetworkErrorException("net work get failed, code: " + doPost.code + ", url:" + str2);
                                break;
                            }
                            if (new JSONObject(doPost.body).getInt(NotificationCompat.CATEGORY_STATUS) == 0) {
                                return;
                            }
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(com.bykv.vk.openvk.preload.geckox.statistic.model.a aVar, List<StatisticModel.PackageStatisticModel> list) {
        if (!aVar.f20834z || !aVar.A) {
            StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel);
            packageStatisticModel.statsType = 1;
            packageStatisticModel.accessKey = aVar.f20809a;
            packageStatisticModel.groupName = aVar.f20810b;
            packageStatisticModel.channel = aVar.f20811c;
            packageStatisticModel.f20807ac = aVar.f20822n;
            packageStatisticModel.f20808id = aVar.f20824p;
            packageStatisticModel.downloadRetryTimes = a(aVar.f20829u);
            packageStatisticModel.downloadUrl = aVar.f20828t;
            packageStatisticModel.downloadFailRecords = b(aVar.f20829u);
            if (aVar.f20834z) {
                if (aVar.A) {
                    return;
                }
                packageStatisticModel.errCode = "450";
                packageStatisticModel.errMsg = aVar.C;
                return;
            }
            packageStatisticModel.errCode = "300";
            List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list2 = aVar.f20829u;
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            packageStatisticModel.errMsg = aVar.f20829u.get(0).reason;
            return;
        }
        StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
        list.add(packageStatisticModel2);
        packageStatisticModel2.statsType = 0;
        packageStatisticModel2.accessKey = aVar.f20809a;
        packageStatisticModel2.groupName = aVar.f20810b;
        packageStatisticModel2.channel = aVar.f20811c;
        packageStatisticModel2.f20807ac = aVar.f20822n;
        packageStatisticModel2.f20808id = aVar.f20824p;
        packageStatisticModel2.downloadRetryTimes = a(aVar.f20829u);
        packageStatisticModel2.downloadUrl = aVar.f20828t;
        packageStatisticModel2.downloadFailRecords = b(aVar.f20829u);
        packageStatisticModel2.downloadDuration = Long.valueOf(aVar.f20831w - aVar.f20830v);
        if (aVar.B) {
            StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel3);
            packageStatisticModel3.accessKey = aVar.f20809a;
            packageStatisticModel3.groupName = aVar.f20810b;
            packageStatisticModel3.statsType = 2;
            packageStatisticModel3.f20808id = aVar.f20824p;
            packageStatisticModel3.channel = aVar.f20811c;
            packageStatisticModel3.activeCheckDuration = Long.valueOf(aVar.f20832x - aVar.f20831w);
            packageStatisticModel3.applyDuration = Long.valueOf(aVar.f20833y - aVar.f20832x);
            return;
        }
        StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
        list.add(packageStatisticModel4);
        packageStatisticModel4.statsType = 3;
        packageStatisticModel4.accessKey = aVar.f20809a;
        packageStatisticModel4.groupName = aVar.f20810b;
        packageStatisticModel4.errCode = "500";
        packageStatisticModel4.f20808id = aVar.f20824p;
        packageStatisticModel4.channel = aVar.f20811c;
        packageStatisticModel4.errMsg = aVar.D;
    }

    private static List<StatisticModel.PackageStatisticModel.DownloadFailRecords> b(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }
}
