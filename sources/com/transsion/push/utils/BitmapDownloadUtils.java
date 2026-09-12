package com.transsion.push.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.utils.m;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class BitmapDownloadUtils {

    /* loaded from: classes6.dex */
    public interface a {
        void a(PushMessage pushMessage, HashMap hashMap);
    }

    public static boolean a(PushMessage pushMessage) {
        return (!TextUtils.isEmpty(pushMessage.notiIcon) && URLUtil.isValidUrl(pushMessage.notiIcon)) || (!TextUtils.isEmpty(pushMessage.notiSmallIcon) && URLUtil.isValidUrl(pushMessage.notiSmallIcon)) || (!TextUtils.isEmpty(pushMessage.notiImgEx) && URLUtil.isValidUrl(pushMessage.notiImgEx));
    }

    public static void b(final PushMessage pushMessage, final a aVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.transsion.push.utils.BitmapDownloadUtils.1

            /* renamed from: com.transsion.push.utils.BitmapDownloadUtils$1$a */
            /* loaded from: classes6.dex */
            class a implements m.d {
                a() {
                }

                @Override // com.transsion.push.utils.m.d
                public void a(HashMap hashMap) {
                    PushLogUtils.LOG.g("images download complete");
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(PushMessage.this, hashMap);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(PushMessage.this.notiIcon)) {
                    arrayList.add(PushMessage.this.notiIcon);
                }
                if (!TextUtils.isEmpty(PushMessage.this.notiImgEx)) {
                    arrayList.add(PushMessage.this.notiImgEx);
                }
                if (!TextUtils.isEmpty(PushMessage.this.notiSmallIcon)) {
                    arrayList.add(PushMessage.this.notiSmallIcon);
                }
                if (!TextUtils.isEmpty(PushMessage.this.notiOptionalIcon)) {
                    arrayList.add(PushMessage.this.notiOptionalIcon);
                }
                if (arrayList.size() > 0) {
                    m.b(PushMessage.this.notiType, arrayList, new a());
                    return;
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(PushMessage.this, null);
                }
            }
        });
    }
}
