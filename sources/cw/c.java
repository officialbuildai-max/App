package cw;

import android.text.TextUtils;
import com.transsion.upload.auth.AuthCheckManager;
import com.transsion.upload.bean.TstTokenEntity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import cw.a;
import dw.d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f61054a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final Map f61055b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static b f61056c;

    /* loaded from: classes7.dex */
    private static final class a implements com.transsion.upload.auth.a {

        /* renamed from: a, reason: collision with root package name */
        private final String f61057a;

        /* renamed from: b, reason: collision with root package name */
        private final UploadFileType f61058b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f61059c;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference f61060d;

        public a(String localFilePath, UploadFileType uploadFileType, boolean z10, WeakReference callbackRef) {
            Intrinsics.h(localFilePath, "localFilePath");
            Intrinsics.h(uploadFileType, "uploadFileType");
            Intrinsics.h(callbackRef, "callbackRef");
            this.f61057a = localFilePath;
            this.f61058b = uploadFileType;
            this.f61059c = z10;
            this.f61060d = callbackRef;
        }

        @Override // com.transsion.upload.auth.a
        public void a(TstTokenEntity tstTokenEntity) {
            cw.a aVar = (cw.a) this.f61060d.get();
            if (aVar != null) {
                if (tstTokenEntity == null) {
                    aVar.c(this.f61057a, "TstTokenEntity is empty", "", null);
                    return;
                }
                dw.a d11 = c.f61054a.d(tstTokenEntity.getStorage());
                if (d11 != null) {
                    d11.i(tstTokenEntity, this.f61057a, this.f61058b, this.f61059c, (cw.a) this.f61060d.get());
                }
            }
        }

        @Override // com.transsion.upload.auth.a
        public void onFail(String str) {
            cw.a aVar = (cw.a) this.f61060d.get();
            if (aVar != null) {
                a.C0748a.a(aVar, this.f61057a, "client authorization failed", null, null, 12, null);
            }
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final dw.a d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = f61055b;
        if (!map.containsKey(str)) {
            UploadTstTokenStorageType uploadTstTokenStorageType = UploadTstTokenStorageType.TST_TOKEN_STORAGE_OSS;
            if (Intrinsics.c(str, uploadTstTokenStorageType.getType())) {
                map.put(uploadTstTokenStorageType.getType(), new dw.c());
            } else {
                UploadTstTokenStorageType uploadTstTokenStorageType2 = UploadTstTokenStorageType.TST_TOKEN_STORAGE_S3;
                if (Intrinsics.c(str, uploadTstTokenStorageType2.getType())) {
                    map.put(uploadTstTokenStorageType2.getType(), new d());
                }
            }
        }
        return (dw.a) map.get(str);
    }

    public final void b() {
        Iterator it = f61055b.entrySet().iterator();
        while (it.hasNext()) {
            ((dw.a) ((Map.Entry) it.next()).getValue()).b();
        }
    }

    public final b c() {
        return f61056c;
    }

    public final void e(b config) {
        Intrinsics.h(config, "config");
        f61056c = config;
    }

    public final void f(String localFilePath, UploadFileType uploadFileType, boolean z10, cw.a aVar) {
        Intrinsics.h(localFilePath, "localFilePath");
        Intrinsics.h(uploadFileType, "uploadFileType");
        AuthCheckManager.f56755a.f(new a(localFilePath, uploadFileType, z10, new WeakReference(aVar)));
    }
}
