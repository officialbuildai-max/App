package com.cloud.hisavana.sdk.internal.agentpage;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.b0;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.q3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class b extends G {

    /* renamed from: i, reason: collision with root package name */
    private final String f22630i;

    /* renamed from: j, reason: collision with root package name */
    private final List f22631j;

    /* renamed from: k, reason: collision with root package name */
    private a f22632k;

    /* loaded from: classes3.dex */
    public interface a {
        void a(List list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(q3 fetchInfo) {
        super(fetchInfo);
        Intrinsics.h(fetchInfo, "fetchInfo");
        this.f22630i = "TranAgentPage";
        this.f22631j = new ArrayList();
    }

    public final void F(a adListener) {
        Intrinsics.h(adListener, "adListener");
        this.f22632k = adListener;
    }

    @Override // com.cloud.hisavana.sdk.G, com.cloud.hisavana.sdk.api.listener.f
    public void b(TaErrorCode taErrorCode, Bundle bundle) {
        a aVar = this.f22632k;
        if (aVar != null) {
            aVar.a(new ArrayList());
        }
        super.b(taErrorCode, bundle);
    }

    @Override // com.cloud.hisavana.sdk.G, com.cloud.hisavana.sdk.api.listener.f
    public void d(List list, Bundle bundle) {
        e4 b11 = e4.b();
        String str = this.f22630i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdLoadedStub ads size = ");
        sb2.append(list != null ? Integer.valueOf(list.size()) : null);
        b11.i(str, sb2.toString());
        if (list == null || list.size() == 0) {
            e4.b().d(this.f22630i, "onAdLoadedStub ads = null");
            a aVar = this.f22632k;
            if (aVar != null) {
                aVar.a(new ArrayList());
                return;
            }
            return;
        }
        IDiskCache g11 = DiskLruCacheUtil.g(4);
        if (g11 == null) {
            e4.b().e(this.f22630i, "get getDiskCache failed");
            return;
        }
        this.f22631j.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdsDTO adsDTO = (AdsDTO) it.next();
            String j11 = b0.f21765a.j(adsDTO);
            if (!TextUtils.isEmpty(j11) && g11.c(new ImageCacheURL(j11)) != null) {
                this.f22631j.add(adsDTO);
            }
        }
        a aVar2 = this.f22632k;
        if (aVar2 != null) {
            List mAdBeans = this.f22631j;
            Intrinsics.g(mAdBeans, "mAdBeans");
            aVar2.a(mAdBeans);
        }
    }

    @Override // com.cloud.hisavana.sdk.G
    public void m() {
        e4.b().d(this.f22630i, "TranAgentPage destroy");
        this.f22632k = null;
        this.f22631j.clear();
        super.m();
    }
}
