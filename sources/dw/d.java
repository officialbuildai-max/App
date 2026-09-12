package dw;

import android.text.TextUtils;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.blankj.utilcode.util.Utils;
import com.transsion.upload.bean.TstTokenEntity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d extends dw.a {

    /* renamed from: b, reason: collision with root package name */
    private TransferUtility f61569b;

    /* renamed from: c, reason: collision with root package name */
    private String f61570c = "";

    /* renamed from: d, reason: collision with root package name */
    private LinkedHashMap f61571d = new LinkedHashMap();

    /* loaded from: classes7.dex */
    public static final class a implements TransferListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f61573b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ cw.a f61574c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f61575d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TransferObserver f61576e;

        /* renamed from: dw.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public /* synthetic */ class C0760a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f61577a;

            static {
                int[] iArr = new int[TransferState.values().length];
                try {
                    iArr[TransferState.COMPLETED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TransferState.FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TransferState.CANCELED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f61577a = iArr;
            }
        }

        a(String str, cw.a aVar, String str2, TransferObserver transferObserver) {
            this.f61573b = str;
            this.f61574c = aVar;
            this.f61575d = str2;
            this.f61576e = transferObserver;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void a(int i11, TransferState transferState) {
            int i12 = transferState == null ? -1 : C0760a.f61577a[transferState.ordinal()];
            if (i12 == 1) {
                ew.a.f62155a.b(d.this.d() + " --> onStateChanged() --> COMPLETED --> file path == " + this.f61573b + " --> id = " + i11);
                cw.a aVar = this.f61574c;
                if (aVar != null) {
                    String str = this.f61575d;
                    String str2 = this.f61573b;
                    String e11 = this.f61576e.e();
                    Intrinsics.g(e11, "transferObserver.bucket");
                    aVar.b(str, str2, e11);
                    return;
                }
                return;
            }
            if (i12 == 2) {
                ew.a.f62155a.c(d.this.d() + " --> onStateChanged() --> FAILED");
                cw.a aVar2 = this.f61574c;
                if (aVar2 != null) {
                    aVar2.c(this.f61575d, "failed", "", d.this.f());
                    return;
                }
                return;
            }
            if (i12 != 3) {
                return;
            }
            ew.a.f62155a.b(d.this.d() + " --> onStateChanged() --> CANCELED --> 取消了");
            cw.a aVar3 = this.f61574c;
            if (aVar3 != null) {
                aVar3.c(this.f61575d, "canceled", "", d.this.f());
            }
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void b(int i11, long j11, long j12) {
            ew.a.f62155a.b(d.this.d() + " --> onProgressChanged() --> id = " + i11 + " --> bytesCurrent = " + j11 + " --> bytesTotal = " + j12);
            cw.a aVar = this.f61574c;
            if (aVar != null) {
                aVar.a(this.f61575d, j11, j12);
            }
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void c(int i11, Exception exc) {
            ew.a.f62155a.b(d.this.d() + " --> onError() --> id = " + i11 + " --> ex = " + (exc != null ? exc.getMessage() : null));
            cw.a aVar = this.f61574c;
            if (aVar != null) {
                aVar.c(this.f61575d, exc != null ? exc.getMessage() : null, "", d.this.f());
            }
        }
    }

    private final void j(boolean z10, TransferObserver transferObserver) {
        if (z10) {
            if (!this.f61571d.containsKey(this.f61569b)) {
                this.f61571d.put(this.f61569b, CollectionsKt.q(transferObserver));
                return;
            }
            List list = (List) this.f61571d.get(this.f61569b);
            if (list != null) {
                list.add(transferObserver);
            }
        }
    }

    private final void k(TstTokenEntity tstTokenEntity) {
        AmazonS3Client amazonS3Client = new AmazonS3Client(new BasicSessionCredentials(tstTokenEntity.getAccessKeyId(), tstTokenEntity.getAccessKeySecret(), tstTokenEntity.getSecurityToken()), Region.e(Regions.fromName(tstTokenEntity.getRegionId())));
        amazonS3Client.d0(S3ClientOptions.a().b(false).c(true).a());
        this.f61569b = TransferUtility.c().c(amazonS3Client).b(Utils.a()).a();
    }

    private final void l(TstTokenEntity tstTokenEntity, String str, UploadFileType uploadFileType, boolean z10, cw.a aVar) {
        String a11 = a(uploadFileType, str);
        TransferUtility transferUtility = this.f61569b;
        TransferObserver i11 = transferUtility != null ? transferUtility.i(tstTokenEntity.getBucket(), a11, new File(str)) : null;
        j(z10, i11);
        if (i11 != null) {
            i11.g(new a(a11, aVar, str, i11));
        }
    }

    @Override // dw.a
    public void b() {
        for (Map.Entry entry : this.f61571d.entrySet()) {
            for (TransferObserver transferObserver : (Iterable) entry.getValue()) {
                TransferUtility transferUtility = (TransferUtility) entry.getKey();
                if (transferUtility != null) {
                    transferUtility.d(transferObserver != null ? transferObserver.f() : 0);
                }
                if (transferObserver != null) {
                    transferObserver.d();
                }
            }
        }
        this.f61571d.clear();
        ew.a.f62155a.b(d() + " --> cancel() --> end");
    }

    @Override // dw.a
    public void c(TstTokenEntity tstToken, String localFilePath, UploadFileType uploadFileType, boolean z10, cw.a aVar) {
        Intrinsics.h(tstToken, "tstToken");
        Intrinsics.h(localFilePath, "localFilePath");
        Intrinsics.h(uploadFileType, "uploadFileType");
        l(tstToken, localFilePath, uploadFileType, z10, aVar);
    }

    @Override // dw.a
    public UploadTstTokenStorageType f() {
        return UploadTstTokenStorageType.TST_TOKEN_STORAGE_S3;
    }

    @Override // dw.a
    public void h(TstTokenEntity tstToken) {
        Intrinsics.h(tstToken, "tstToken");
        if (TextUtils.equals(this.f61570c, tstToken.getAccessKeyId())) {
            return;
        }
        String accessKeyId = tstToken.getAccessKeyId();
        if (accessKeyId == null) {
            accessKeyId = "";
        }
        this.f61570c = accessKeyId;
        k(tstToken);
    }
}
