package com.cloud.hisavana.sdk;

import android.view.View;
import android.view.ViewGroup;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.iab.omid.library.hisavana.adsession.CreativeType;
import com.iab.omid.library.hisavana.adsession.FriendlyObstructionPurpose;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class J0 {

    /* renamed from: a, reason: collision with root package name */
    private final Map f21592a = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Lkotlin/Unit;"}, k = 3, mv = {1, 9, 0})
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<Unit> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<View> f21593a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List<View> list) {
            super(0);
            this.f21593a = list;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Unit invoke() {
            e4.b().d("OmSdk", "omid setupAdSession failed");
            List<View> list = this.f21593a;
            if (list == null) {
                return null;
            }
            list.clear();
            return Unit.f67184a;
        }
    }

    public final void a() {
        Iterator it = this.f21592a.entrySet().iterator();
        while (it.hasNext()) {
            ((com.iab.omid.library.hisavana.adsession.b) ((Map.Entry) it.next()).getValue()).c();
            e4.b().d("OmSdk", "omid session finish");
        }
        this.f21592a.clear();
    }

    public final void b(AdsDTO adsDTO, ViewGroup viewGroup, List list) {
        Object obj;
        if (this.f21592a.containsKey(adsDTO != null ? adsDTO.getUuid() : null)) {
            return;
        }
        if (adsDTO == null || viewGroup == null) {
            e4.b().d("OmSdk", "omid adSession == null");
            if (list != null) {
                list.clear();
                return;
            }
            return;
        }
        com.iab.omid.library.hisavana.adsession.b b11 = s0.f23013a.b(com.cloud.sdk.commonutil.util.e.a(), CreativeType.NATIVE_DISPLAY, adsDTO);
        if (b11 != null) {
            try {
                b11.d(viewGroup);
                if (list != null && !list.isEmpty()) {
                    Iterator it = CollectionsKt.f0(list).iterator();
                    while (it.hasNext()) {
                        b11.a((View) it.next(), FriendlyObstructionPurpose.OTHER, null);
                    }
                    list.clear();
                }
                b11.e();
                com.iab.omid.library.hisavana.adsession.a a11 = com.iab.omid.library.hisavana.adsession.a.a(b11);
                a11.c();
                a11.b();
                e4.b().d("OmSdk", "omid adEvents impressionOccurred");
                Map map = this.f21592a;
                String uuid = adsDTO.getUuid();
                Intrinsics.g(uuid, "getUuid(...)");
                obj = map.put(uuid, b11);
            } catch (Exception e11) {
                e4.b().e("setup omid native failed : " + e11.getMessage());
                obj = Unit.f67184a;
            }
            if (obj != null) {
                return;
            }
        }
        new a(list);
    }
}
