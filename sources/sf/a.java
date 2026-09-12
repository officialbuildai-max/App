package sf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tinker.lib.service.TinkerPatchForeService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import vf.c;

/* loaded from: classes5.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f75466a;

    /* renamed from: b, reason: collision with root package name */
    private ServiceConnection f75467b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: sf.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class ServiceConnectionC0942a implements ServiceConnection {
        ServiceConnectionC0942a() {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a aVar = a.this;
            if (aVar.f75466a == null || aVar.f75467b == null) {
                return;
            }
            try {
                a aVar2 = a.this;
                aVar2.f75466a.unbindService(aVar2.f75467b);
            } catch (Throwable unused) {
            }
        }
    }

    public a(Context context) {
        this.f75466a = context;
    }

    private void e() {
        try {
            this.f75467b = new ServiceConnectionC0942a();
            this.f75466a.bindService(new Intent(this.f75466a, (Class<?>) TinkerPatchForeService.class), this.f75467b, 1);
        } catch (Throwable unused) {
        }
    }

    @Override // sf.b
    public int a(String str) {
        return c(str, false);
    }

    protected int c(String str, boolean z10) {
        int d11 = d(str, SharePatchFileUtil.getMD5(new File(str)));
        if (d11 == 0) {
            e();
            TinkerPatchService.j(this.f75466a, str, z10);
        } else {
            vf.a.x(this.f75466a).g().h(new File(str), d11);
        }
        return d11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(String str, String str2) {
        vf.a x10 = vf.a.x(this.f75466a);
        if (!x10.t() || !ShareTinkerInternals.isTinkerEnableWithSharedPreferences(this.f75466a)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2) || !SharePatchFileUtil.isLegalFile(new File(str))) {
            return -2;
        }
        if (x10.s()) {
            return -4;
        }
        if (wf.b.d(this.f75466a)) {
            return -3;
        }
        if (ShareTinkerInternals.isVmJit()) {
            return -5;
        }
        c m11 = x10.m();
        if (!x10.r() || m11 == null || !m11.f77434e) {
            String absolutePath = x10.h().getAbsolutePath();
            try {
                SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(SharePatchFileUtil.getPatchInfoFile(absolutePath), SharePatchFileUtil.getPatchInfoLockFile(absolutePath));
                if (readAndCheckPropertyWithLock != null && !ShareTinkerInternals.isNullOrNil(readAndCheckPropertyWithLock.newVersion) && !readAndCheckPropertyWithLock.newVersion.equals(readAndCheckPropertyWithLock.versionToRemove)) {
                    if (str2.equals(readAndCheckPropertyWithLock.newVersion)) {
                        return -6;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return !wf.c.b(this.f75466a).c(str2) ? -7 : 0;
    }
}
