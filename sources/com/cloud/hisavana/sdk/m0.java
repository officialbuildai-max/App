package com.cloud.hisavana.sdk;

import android.view.ViewGroup;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes3.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f22726a = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(J0 j02, AdsDTO adsDTO, ViewGroup viewGroup, List list) {
            if (j02 != null) {
                j02.b(adsDTO, viewGroup, list);
            }
        }
    }

    public static final void a(J0 j02, AdsDTO adsDTO, ViewGroup viewGroup, List list) {
        f22726a.a(j02, adsDTO, viewGroup, list);
    }
}
