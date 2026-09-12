package qi;

import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.c;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.meituan.android.walle.ChannelReader;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.ps.activate.PsActivateDto;
import com.transsion.ad.ps.model.PsLinkDto;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import nh.m;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lqi/a;", "", "Lokhttp3/RequestBody;", "request", "", "url", "Lcom/transsion/ad/ps/model/PsLinkDto;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lokhttp3/RequestBody;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/transsion/ad/ps/activate/PsActivateDto;", "a", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f73756a;

    /* renamed from: qi.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f73756a = new Companion();

        private Companion() {
        }

        public final Map a(long j11) {
            String str;
            String string;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String a11 = lh.a.f68965a.a("Transsion" + j11);
            linkedHashMap.put("curClientVersionCode", Long.valueOf(b.f73757a.i()));
            linkedHashMap.put(ChannelReader.CHANNEL_KEY, "Transsion");
            linkedHashMap.put("brand", Build.BRAND);
            linkedHashMap.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(j11));
            linkedHashMap.put(TmcConstants.EXTRA_APP_DEV_TOKEN, a11);
            ih.b bVar = ih.b.f65364a;
            linkedHashMap.put(UrlKt.KEY_MINI_GAID, bVar.i());
            linkedHashMap.put("systemVersionCode", Integer.valueOf(Build.VERSION.SDK_INT));
            linkedHashMap.put("netType", m.f70597a.d());
            linkedHashMap.put("lan", bVar.j());
            MMKV c11 = bh.a.f16551a.c();
            String str2 = null;
            if (c11 == null || (string = c11.getString("custom_local_iso", "")) == null) {
                str = null;
            } else {
                str = string.toUpperCase(Locale.ROOT);
                Intrinsics.g(str, "toUpperCase(...)");
            }
            if (TextUtils.isEmpty(str)) {
                String g11 = bVar.g();
                if (g11 != null) {
                    str2 = g11.toUpperCase(Locale.ROOT);
                    Intrinsics.g(str2, "toUpperCase(...)");
                }
                str = str2;
            }
            if (str == null) {
                str = "";
            }
            linkedHashMap.put("countyrCode", str);
            linkedHashMap.put("ua", Build.MODEL);
            linkedHashMap.put("curVersionName", c.h());
            linkedHashMap.put("cpu", bVar.e());
            linkedHashMap.put("android_version", bVar.n());
            linkedHashMap.put("imei", "");
            linkedHashMap.put("imsi", "");
            linkedHashMap.put("sessionID", "");
            linkedHashMap.put("lastPage", "");
            linkedHashMap.put("curPage", "");
            linkedHashMap.put("shareChannel", "");
            linkedHashMap.put(TrackingKey.PLATFORM, "");
            return linkedHashMap;
        }
    }

    @POST("/distribute/active/mb")
    Object a(@Body RequestBody requestBody, @Header("multiple_base_url") String str, Continuation<? super PsActivateDto> continuation);

    @POST("/distribute/candidate")
    Object b(@Body RequestBody requestBody, @Header("multiple_base_url") String str, Continuation<? super PsLinkDto> continuation);
}
