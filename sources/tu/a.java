package tu;

import android.content.Context;
import com.hisavana.common.tracking.TrackingKey;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.Properties;
import ou.c;

/* loaded from: classes7.dex */
public class a extends sf.a {

    /* renamed from: c, reason: collision with root package name */
    private final long f76486c;

    /* renamed from: d, reason: collision with root package name */
    private final String f76487d;

    /* renamed from: e, reason: collision with root package name */
    private c f76488e;

    public a(Context context) {
        this(context, ou.a.s().D(), null);
    }

    public a(Context context, long j11, String str) {
        super(context);
        this.f76486c = j11 <= 0 ? 0L : j11;
        this.f76487d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sf.a
    public int d(String str, String str2) {
        String property;
        int d11 = super.d(str, str2);
        if (d11 != 0) {
            ShareTinkerLog.w("Tinker.CustomPatchListener", "base patchCheck rejected: code=%d, path=%s", Integer.valueOf(d11), str);
            return d11;
        }
        File file = new File(str);
        long fileOrDirectorySize = SharePatchFileUtil.getFileOrDirectorySize(file);
        ShareTinkerLog.i("Tinker.CustomPatchListener", "patch check: path=%s, size=%d", str, Long.valueOf(fileOrDirectorySize));
        long j11 = this.f76486c;
        if (j11 > 0 && fileOrDirectorySize > j11) {
            ShareTinkerLog.w("Tinker.CustomPatchListener", "patch size %d exceeds limit %d", Long.valueOf(fileOrDirectorySize), Long.valueOf(this.f76486c));
            return -101;
        }
        Properties fastGetPatchPackageMeta = ShareTinkerInternals.fastGetPatchPackageMeta(file);
        if (fastGetPatchPackageMeta == null) {
            ShareTinkerLog.w("Tinker.CustomPatchListener", "patch package meta not found", new Object[0]);
            return -100;
        }
        if (this.f76487d == null || ((property = fastGetPatchPackageMeta.getProperty(TrackingKey.PLATFORM)) != null && this.f76487d.equals(property))) {
            return 0;
        }
        ShareTinkerLog.w("Tinker.CustomPatchListener", "channel mismatch: expected=%s, platform=%s", this.f76487d, property);
        return -100;
    }

    public void f(c cVar) {
        this.f76488e = cVar;
    }
}
