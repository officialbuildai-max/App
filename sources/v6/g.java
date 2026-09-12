package v6;

import android.util.Log;
import com.cloud.hisavana.abtestkit.bean.ABLayerInfo;
import com.cloud.hisavana.abtestkit.bean.ABSubExpInfo;
import com.cloud.hisavana.abtestkit.bean.ABVariant;
import com.cloud.hisavana.abtestkit.bean.ABVariantState;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final com.google.common.hash.d f77179a;

    static {
        com.google.common.hash.d b11 = com.google.common.hash.f.b(0);
        Intrinsics.g(b11, "murmur3_128(...)");
        f77179a = b11;
    }

    public static final ABVariantState a(ABLayerInfo aBLayerInfo) {
        List<ABSubExpInfo> subExps;
        List<Long> buckets;
        String e11 = DeviceUtil.e();
        if (e11 == null || e11.length() == 0) {
            com.cloud.sdk.commonutil.util.c.Log().d("ABTEST", "ABChecker check fail, gaid is empty");
            return new ABVariantState.Closed(2);
        }
        if (aBLayerInfo == null || (subExps = aBLayerInfo.getSubExps()) == null || subExps.isEmpty()) {
            com.cloud.sdk.commonutil.util.c.Log().d("ABTEST", "ABChecker check fail, abLayerInfo is null or subExps is empty");
            return new ABVariantState.Closed(3);
        }
        Map<String, Long> whiteList = aBLayerInfo.getWhiteList();
        boolean containsKey = whiteList != null ? whiteList.containsKey(DeviceUtil.e()) : false;
        if (Log.isLoggable("ADSDK", 3)) {
            com.cloud.sdk.commonutil.util.c.Log().i("ABTEST", "ABChecker check, whiteResult = " + containsKey);
        }
        if (containsKey) {
            Map<String, Long> whiteList2 = aBLayerInfo.getWhiteList();
            Long l11 = whiteList2 != null ? whiteList2.get(DeviceUtil.e()) : null;
            if (Log.isLoggable("ADSDK", 3)) {
                com.cloud.sdk.commonutil.util.c.Log().i("ABTEST", "ABChecker check, whiteValue = " + l11);
            }
            for (ABSubExpInfo aBSubExpInfo : aBLayerInfo.getSubExps()) {
                if (aBSubExpInfo != null && aBSubExpInfo.getVarId() != null && Intrinsics.c(aBSubExpInfo.getVarId(), l11)) {
                    return new ABVariantState.Open(ABVariant.INSTANCE.initFromSubExpInfo(aBLayerInfo.getLayerId(), aBSubExpInfo));
                }
            }
        }
        if (aBLayerInfo.getProjectId() == null || aBLayerInfo.getLayerId() == null) {
            com.cloud.sdk.commonutil.util.c.Log().d("ABTEST", "ABChecker check fail, projectId is null or layerId is null");
            return new ABVariantState.Closed(4);
        }
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format("%s_%s_%s", Arrays.copyOf(new Object[]{aBLayerInfo.getProjectId(), aBLayerInfo.getLayerId(), DeviceUtil.e()}, 3));
            Intrinsics.g(format, "format(...)");
            long a11 = f.a(f77179a.hashString(format, StandardCharsets.UTF_8).asLong(), 1000L);
            if (Log.isLoggable("ADSDK", 3)) {
                com.cloud.sdk.commonutil.util.c.Log().i("ABTEST", "ABChecker check, hashStr = " + format + " and hashVal = " + a11);
            }
            for (ABSubExpInfo aBSubExpInfo2 : aBLayerInfo.getSubExps()) {
                if (aBSubExpInfo2 != null && (buckets = aBSubExpInfo2.getBuckets()) != null && !buckets.isEmpty() && aBSubExpInfo2.getBuckets().contains(Long.valueOf(a11))) {
                    return new ABVariantState.Open(ABVariant.INSTANCE.initFromSubExpInfo(aBLayerInfo.getLayerId(), aBSubExpInfo2));
                }
            }
            return new ABVariantState.Closed(6);
        } catch (Exception e12) {
            com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABChecker check fail, hashStr =  and reason = " + e12.getMessage());
            return new ABVariantState.Closed(5);
        }
    }
}
