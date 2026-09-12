package com.cloud.hisavana.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.s0;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.iab.omid.library.hisavana.adsession.CreativeType;
import com.iab.omid.library.hisavana.adsession.ImpressionType;
import com.iab.omid.library.hisavana.adsession.Owner;
import com.iab.omid.library.hisavana.adsession.g;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f23013a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static volatile String f23014b = "";

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List c(AdsDTO adsDTO) {
            List<AdsProtocolBean.OmIdData> omIdVerifications;
            g a11;
            String str;
            ArrayList arrayList = new ArrayList();
            if (adsDTO != null && (omIdVerifications = adsDTO.getOmIdVerifications()) != null) {
                Intrinsics.e(omIdVerifications);
                Iterator<AdsProtocolBean.OmIdData> it = omIdVerifications.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AdsProtocolBean.OmIdData next = it.next();
                    if (!com.cloud.hisavana.sdk.common.util.p0.f(next != null ? next.url : null)) {
                        e4.b().w("OmSdk", "omid data.vendorUrl is not valid");
                    } else {
                        if (arrayList.size() >= 5) {
                            e4.b().w("OmSdk", "omid verification scripts num is bigger than 5");
                            break;
                        }
                        if (next != null && (str = next.verification_parameters) != null) {
                            Intrinsics.e(str);
                            if (str.length() == 0) {
                                a11 = g.b(new URL(next.url));
                                Intrinsics.e(a11);
                                arrayList.add(a11);
                            }
                        }
                        a11 = g.a(next.vendorKey, new URL(next.url), next.verification_parameters);
                        Intrinsics.e(a11);
                        arrayList.add(a11);
                    }
                }
            }
            return arrayList;
        }

        private final void d(Context context) {
            if (fe.a.c()) {
                return;
            }
            fe.a.a(context.getApplicationContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Context context) {
            Intrinsics.h(context, "$context");
            try {
                InputStream openRawResource = context.getResources().openRawResource(R$raw.omsdk_v1);
                try {
                    byte[] bArr = new byte[openRawResource.available()];
                    int read = openRawResource.read(bArr);
                    a aVar = s0.f23013a;
                    Charset forName = Charset.forName("UTF-8");
                    Intrinsics.g(forName, "forName(...)");
                    s0.f23014b = new String(bArr, 0, read, forName);
                    Unit unit = Unit.f67184a;
                    CloseableKt.a(openRawResource, null);
                    e4.b().d("OmSdk", "omid js loaded");
                } finally {
                }
            } catch (IOException e11) {
                e4.b().e("OmSdk", "Omid resource not found: " + e11.getMessage());
            }
        }

        public final com.iab.omid.library.hisavana.adsession.b b(Context context, CreativeType creativeType, AdsDTO adsDTO) {
            List<AdsProtocolBean.OmIdData> omIdVerifications;
            Owner owner;
            if (k1.o().r() && context != null && creativeType != null) {
                if (TextUtils.isEmpty(s0.f23014b)) {
                    e4.b().w("OmSdk", "omid js is not ready");
                    f(context);
                    return null;
                }
                if (adsDTO != null && ((omIdVerifications = adsDTO.getOmIdVerifications()) == null || !omIdVerifications.isEmpty())) {
                    try {
                        List c11 = c(adsDTO);
                        if (c11.isEmpty()) {
                            return null;
                        }
                        e4.b().d("OmSdk", "omid valid resource count : " + c11.size());
                        d(context);
                        ImpressionType impressionType = creativeType == CreativeType.AUDIO ? ImpressionType.AUDIBLE : ImpressionType.VIEWABLE;
                        Owner owner2 = Owner.NATIVE;
                        if (creativeType != CreativeType.HTML_DISPLAY && creativeType != CreativeType.NATIVE_DISPLAY) {
                            owner = owner2;
                            return com.iab.omid.library.hisavana.adsession.b.b(com.iab.omid.library.hisavana.adsession.c.a(creativeType, impressionType, owner2, owner, false), com.iab.omid.library.hisavana.adsession.d.a(com.iab.omid.library.hisavana.adsession.f.a("hisavana", "3.3.8.0"), s0.f23014b, c11, null, "{\"partner\":\"hisavana\"}"));
                        }
                        owner = Owner.NONE;
                        return com.iab.omid.library.hisavana.adsession.b.b(com.iab.omid.library.hisavana.adsession.c.a(creativeType, impressionType, owner2, owner, false), com.iab.omid.library.hisavana.adsession.d.a(com.iab.omid.library.hisavana.adsession.f.a("hisavana", "3.3.8.0"), s0.f23014b, c11, null, "{\"partner\":\"hisavana\"}"));
                    } catch (Throwable th2) {
                        e4.b().e("OmSdk", "get adSession error: " + th2.getMessage());
                    }
                }
            }
            return null;
        }

        public final void e(final Context context, boolean z10) {
            Intrinsics.h(context, "context");
            if (z10 && TextUtils.isEmpty(s0.f23014b)) {
                HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.q0
                    @Override // java.lang.Runnable
                    public final void run() {
                        s0.a.g(context);
                    }
                });
            }
        }

        public final void f(Context context) {
            Intrinsics.h(context, "context");
            e(context, k1.o().r());
        }
    }

    public static final void b(Context context) {
        f23013a.f(context);
    }

    public static final void c(Context context, boolean z10) {
        f23013a.e(context, z10);
    }
}
