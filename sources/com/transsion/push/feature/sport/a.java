package com.transsion.push.feature.sport;

import com.tn.lib.net.bean.BaseDto;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/transsion/push/feature/sport/a;", "", "", "host", "id", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/push/feature/sport/ServerMatchListItemData;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: com.transsion.push.feature.sport.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0647a {
        public static /* synthetic */ Object a(a aVar, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMatchDetail");
            }
            if ((i11 & 1) != 0) {
                str = vg.a.f77447a.a();
            }
            return aVar.a(str, str2, continuation);
        }
    }

    @GET("/wefeed-mobile-bff/live/match-detail")
    Object a(@Query("host") String str, @Query("id") String str2, Continuation<? super BaseDto<ServerMatchListItemData>> continuation);
}
