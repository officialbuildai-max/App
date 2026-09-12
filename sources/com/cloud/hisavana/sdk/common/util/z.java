package com.cloud.hisavana.sdk.common.util;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final z f22292a = new z();

    private z() {
    }

    private final void d(final AdsDTO adsDTO, final String str, final String str2, final n nVar) {
        if (nVar == null || adsDTO == null) {
            return;
        }
        HSScopeHelper.f23249a.g(new Runnable() { // from class: com.cloud.hisavana.sdk.common.util.w
            @Override // java.lang.Runnable
            public final void run() {
                z.e(str, str2, adsDTO, nVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String zipPath, String outPutPath, AdsDTO adsDTO, final n nVar) {
        File[] listFiles;
        Intrinsics.h(zipPath, "$zipPath");
        Intrinsics.h(outPutPath, "$outPutPath");
        String str = m.b(com.cloud.sdk.commonutil.util.e.a()) + File.separator + "interactive_zip";
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length >= 50) {
                int length = listFiles.length - 25;
                for (int i11 = 0; i11 < length; i11++) {
                    File file2 = listFiles[i11];
                    if (file2 != null) {
                        m.a(file2);
                    }
                }
            }
        }
        if (s0.b(zipPath, outPutPath)) {
            adsDTO.setIndexLocation(m.f(outPutPath));
            Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.common.util.x
                @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                public final void onRun() {
                    z.f(n.this);
                }
            });
        } else {
            AthenaTracker.S(adsDTO, 2);
            Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.common.util.y
                @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                public final void onRun() {
                    z.g(n.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(n nVar) {
        nVar.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(n nVar) {
        nVar.a(false);
    }

    public final void h(AdsDTO adsDTO, String zipPath, n listener) {
        Intrinsics.h(zipPath, "zipPath");
        Intrinsics.h(listener, "listener");
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m.b(com.cloud.sdk.commonutil.util.e.a()));
        String str = File.separator;
        sb2.append(str);
        sb2.append("interactive_zip");
        sb2.append(str);
        sb2.append(currentTimeMillis);
        String sb3 = sb2.toString();
        if (new File(sb3).exists()) {
            if (!TextUtils.isEmpty(adsDTO != null ? adsDTO.getIndexLocation() : null)) {
                listener.a(true);
                return;
            }
        }
        d(adsDTO, zipPath, sb3, listener);
    }
}
