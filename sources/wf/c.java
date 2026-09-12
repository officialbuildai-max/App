package wf;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    private static c f77786f;

    /* renamed from: b, reason: collision with root package name */
    private File f77788b;

    /* renamed from: c, reason: collision with root package name */
    private File f77789c;

    /* renamed from: d, reason: collision with root package name */
    private Context f77790d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f77787a = true;

    /* renamed from: e, reason: collision with root package name */
    private int f77791e = 20;

    /* loaded from: classes5.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        String f77792a;

        /* renamed from: b, reason: collision with root package name */
        String f77793b;

        a(String str, String str2) {
            this.f77792a = str;
            this.f77793b = str2;
        }

        static a a(File file) {
            String str;
            InputStream inputStream;
            Properties properties = new Properties();
            String str2 = null;
            try {
                inputStream = new FileInputStream(file);
                try {
                    try {
                        properties.load(inputStream);
                        str = properties.getProperty("md5");
                    } catch (IOException e11) {
                        e = e11;
                        str = null;
                    }
                    try {
                        str2 = properties.getProperty("times");
                    } catch (IOException e12) {
                        e = e12;
                        ShareTinkerLog.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:" + e, new Object[0]);
                        pf.b.a(inputStream);
                        return new a(str, str2);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = inputStream;
                    pf.b.a(str2);
                    throw th;
                }
            } catch (IOException e13) {
                e = e13;
                str = null;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                pf.b.a(str2);
                throw th;
            }
            pf.b.a(inputStream);
            return new a(str, str2);
        }

        static void b(File file, a aVar) {
            FileOutputStream fileOutputStream;
            if (aVar == null) {
                return;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Properties properties = new Properties();
            properties.put("md5", aVar.f77792a);
            properties.put("times", aVar.f77793b);
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                properties.store(fileOutputStream, (String) null);
                pf.b.a(fileOutputStream);
            } catch (Exception e12) {
                e = e12;
                fileOutputStream2 = fileOutputStream;
                ShareTinkerLog.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                pf.b.a(fileOutputStream2);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                pf.b.a(fileOutputStream2);
                throw th;
            }
        }
    }

    public c(Context context) {
        this.f77788b = null;
        this.f77789c = null;
        this.f77790d = context;
        this.f77788b = new File(SharePatchFileUtil.getPatchTempDirectory(context), "patch.retry");
        this.f77789c = new File(SharePatchFileUtil.getPatchTempDirectory(context), "temp.apk");
    }

    private void a(File file) {
        if (file.getAbsolutePath().equals(this.f77789c.getAbsolutePath())) {
            return;
        }
        ShareTinkerLog.w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", file.getAbsolutePath(), this.f77789c.getAbsolutePath());
        try {
            SharePatchFileUtil.copyFileUsingStream(file, this.f77789c);
        } catch (IOException unused) {
            ShareTinkerLog.e("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", file.getAbsolutePath(), this.f77789c.getAbsolutePath());
        }
    }

    public static c b(Context context) {
        if (f77786f == null) {
            f77786f = new c(context);
        }
        return f77786f;
    }

    public boolean c(String str) {
        int parseInt;
        if (!this.f77787a) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
            return true;
        }
        if (!this.f77788b.exists()) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
            return true;
        }
        if (str == null) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
            return true;
        }
        a a11 = a.a(this.f77788b);
        if (!str.equals(a11.f77792a) || (parseInt = Integer.parseInt(a11.f77793b)) < this.f77791e) {
            return true;
        }
        ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", Integer.valueOf(parseInt));
        SharePatchFileUtil.safeDeleteFile(this.f77789c);
        return false;
    }

    public boolean d(String str) {
        if (!this.f77787a) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry disabled, just return", new Object[0]);
            return true;
        }
        if (!this.f77788b.exists()) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry file is not exist, just return", new Object[0]);
            return true;
        }
        if (str == null) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck md5 is null, just return", new Object[0]);
            return true;
        }
        a a11 = a.a(this.f77788b);
        if (str.equals(a11.f77792a)) {
            ShareTinkerLog.i("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck, reset max check to 1", new Object[0]);
            a11.f77793b = "1";
            a.b(this.f77788b, a11);
        }
        return true;
    }

    public void e() {
        if (!this.f77787a) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
        } else if (this.f77789c.exists()) {
            SharePatchFileUtil.safeDeleteFile(this.f77789c);
        }
    }

    public void f(Intent intent) {
        a aVar;
        if (!this.f77787a) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
            return;
        }
        if (intent == null) {
            ShareTinkerLog.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
            return;
        }
        String c11 = TinkerPatchService.c(intent);
        if (c11 == null) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
            return;
        }
        File file = new File(c11);
        String md5 = SharePatchFileUtil.getMD5(file);
        if (md5 == null) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
            return;
        }
        if (this.f77788b.exists()) {
            aVar = a.a(this.f77788b);
            String str = aVar.f77792a;
            if (str == null || aVar.f77793b == null || !md5.equals(str)) {
                a(file);
                aVar.f77792a = md5;
                aVar.f77793b = "1";
            } else {
                int parseInt = Integer.parseInt(aVar.f77793b);
                if (parseInt >= this.f77791e) {
                    SharePatchFileUtil.safeDeleteFile(this.f77789c);
                    ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                    return;
                }
                aVar.f77793b = String.valueOf(parseInt + 1);
            }
        } else {
            a(file);
            aVar = new a(md5, "1");
        }
        a.b(this.f77788b, aVar);
    }
}
