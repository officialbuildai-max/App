package vf;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.media3.common.PlaybackException;
import com.hisavana.common.bean.TAdErrorCode;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public SharePatchInfo f77430a;

    /* renamed from: b, reason: collision with root package name */
    public String f77431b;

    /* renamed from: c, reason: collision with root package name */
    public String f77432c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f77433d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f77434e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f77435f;

    /* renamed from: g, reason: collision with root package name */
    public File f77436g;

    /* renamed from: h, reason: collision with root package name */
    public File f77437h;

    /* renamed from: i, reason: collision with root package name */
    public File f77438i;

    /* renamed from: j, reason: collision with root package name */
    public File f77439j;

    /* renamed from: k, reason: collision with root package name */
    public File f77440k;

    /* renamed from: l, reason: collision with root package name */
    public File f77441l;

    /* renamed from: m, reason: collision with root package name */
    public HashMap f77442m;

    /* renamed from: n, reason: collision with root package name */
    public HashMap f77443n;

    /* renamed from: o, reason: collision with root package name */
    public HashMap f77444o;

    /* renamed from: p, reason: collision with root package name */
    public int f77445p;

    /* renamed from: q, reason: collision with root package name */
    public long f77446q;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:36:0x0196. Please report as an issue. */
    public boolean a(Context context, Intent intent) {
        File file;
        String str;
        String str2;
        String str3;
        int i11;
        boolean z10;
        boolean z11;
        int i12;
        a x10 = a.x(context);
        this.f77445p = ShareIntentUtil.getIntentReturnCode(intent);
        this.f77446q = ShareIntentUtil.getIntentPatchCostTime(intent);
        this.f77435f = ShareIntentUtil.getBooleanExtra(intent, "intent_patch_system_ota", false);
        String stringExtra = ShareIntentUtil.getStringExtra(intent, "intent_patch_oat_dir");
        this.f77432c = stringExtra;
        this.f77434e = "interpet".equals(stringExtra);
        boolean r11 = x10.r();
        Integer valueOf = Integer.valueOf(this.f77445p);
        String processName = ShareTinkerInternals.getProcessName(context);
        Boolean valueOf2 = Boolean.valueOf(r11);
        Boolean valueOf3 = Boolean.valueOf(this.f77435f);
        String str4 = Build.FINGERPRINT;
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", valueOf, processName, valueOf2, valueOf3, str4, this.f77432c, Boolean.valueOf(this.f77434e));
        String stringExtra2 = ShareIntentUtil.getStringExtra(intent, "intent_patch_old_version");
        String stringExtra3 = ShareIntentUtil.getStringExtra(intent, "intent_patch_new_version");
        File h11 = x10.h();
        File i13 = x10.i();
        if (stringExtra2 == null || stringExtra3 == null) {
            file = h11;
            str = stringExtra3;
            str2 = stringExtra2;
            str3 = "Tinker.TinkerLoadResult";
            i11 = 5;
        } else {
            if (r11) {
                this.f77431b = stringExtra3;
            } else {
                this.f77431b = stringExtra2;
            }
            ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", stringExtra2, stringExtra3, this.f77431b);
            String patchVersionDirectory = SharePatchFileUtil.getPatchVersionDirectory(this.f77431b);
            if (!ShareTinkerInternals.isNullOrNil(patchVersionDirectory)) {
                this.f77436g = new File(h11.getAbsolutePath() + "/" + patchVersionDirectory);
                this.f77437h = new File(this.f77436g.getAbsolutePath(), SharePatchFileUtil.getPatchVersionFile(this.f77431b));
                this.f77438i = new File(this.f77436g, "dex");
                this.f77439j = new File(this.f77436g, "lib");
                this.f77440k = new File(this.f77436g, "res");
                this.f77441l = new File(this.f77440k, "resources.apk");
            }
            file = h11;
            str2 = stringExtra2;
            str3 = "Tinker.TinkerLoadResult";
            i11 = 5;
            this.f77430a = new SharePatchInfo(stringExtra2, stringExtra3, ShareIntentUtil.getBooleanExtra(intent, "intent_is_protected_app", false), ShareIntentUtil.getBooleanExtra(intent, "intent_use_custom_patch", false), "", str4, this.f77432c, false);
            str = stringExtra3;
            this.f77433d = !str2.equals(str);
        }
        Throwable intentPatchException = ShareIntentUtil.getIntentPatchException(intent);
        if (intentPatchException != null) {
            ShareTinkerLog.i(str3, "Tinker load have exception loadCode:%d", Integer.valueOf(this.f77445p));
            int i14 = this.f77445p;
            if (i14 == -25) {
                i12 = -4;
            } else if (i14 != -23) {
                i12 = -1;
                if (i14 != -20 && i14 == -14) {
                    i12 = -2;
                }
            } else {
                i12 = -3;
            }
            x10.g().a(intentPatchException, i12);
            return false;
        }
        String str5 = str3;
        int i15 = this.f77445p;
        if (i15 == -10000) {
            ShareTinkerLog.e(str5, "can't get the right intent return code", new Object[0]);
            throw new TinkerRuntimeException("can't get the right intent return code");
        }
        if (i15 == -24) {
            File file2 = this.f77441l;
            if (file2 == null) {
                ShareTinkerLog.e(str5, "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                throw new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
            }
            ShareTinkerLog.e(str5, "patch resource file md5 is mismatch: %s", file2.getAbsolutePath());
            x10.g().f(this.f77441l, 6);
            return false;
        }
        if (i15 == -22) {
            if (this.f77436g == null) {
                ShareTinkerLog.e(str5, "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                throw new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
            }
            ShareTinkerLog.e(str5, "patch resource file not found:%s", this.f77441l.getAbsolutePath());
            x10.g().c(this.f77441l, 6, false);
            return false;
        }
        if (i15 == -21) {
            if (this.f77436g == null) {
                ShareTinkerLog.e(str5, "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                throw new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
            }
            ShareTinkerLog.e(str5, "patch resource file directory not found:%s", this.f77440k.getAbsolutePath());
            x10.g().c(this.f77440k, 6, true);
            return false;
        }
        switch (i15) {
            case -19:
                ShareTinkerLog.i(str5, "rewrite patch info file corrupted", new Object[0]);
                x10.g().g(str2, str, i13);
                return false;
            case -18:
                String stringExtra4 = ShareIntentUtil.getStringExtra(intent, "intent_patch_missing_lib_path");
                if (stringExtra4 == null) {
                    ShareTinkerLog.e(str5, "patch lib file not found, but path is null!!!!", new Object[0]);
                    throw new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                }
                ShareTinkerLog.e(str5, "patch lib file not found:%s", stringExtra4);
                x10.g().c(new File(stringExtra4), i11, false);
                return false;
            case -17:
                if (this.f77436g == null) {
                    ShareTinkerLog.e(str5, "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                    throw new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                }
                ShareTinkerLog.e(str5, "patch lib file directory not found:%s", this.f77439j.getAbsolutePath());
                x10.g().c(this.f77439j, i11, true);
                return false;
            case -16:
                x10.g().d(2, ShareIntentUtil.getIntentInterpretException(intent));
                return false;
            case -15:
                x10.g().d(1, ShareIntentUtil.getIntentInterpretException(intent));
                return false;
            default:
                switch (i15) {
                    case -13:
                        z10 = false;
                        String stringExtra5 = ShareIntentUtil.getStringExtra(intent, "intent_patch_mismatch_dex_path");
                        if (stringExtra5 == null) {
                            ShareTinkerLog.e(str5, "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                            throw new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                        }
                        ShareTinkerLog.e(str5, "patch dex file md5 is mismatch: %s", stringExtra5);
                        x10.g().f(new File(stringExtra5), 3);
                        return z10;
                    case -12:
                        z10 = false;
                        ShareTinkerLog.e(str5, "patch dex load fail, classloader is null", new Object[0]);
                        return z10;
                    case -11:
                        z10 = false;
                        String stringExtra6 = ShareIntentUtil.getStringExtra(intent, "intent_patch_missing_dex_path");
                        if (stringExtra6 == null) {
                            ShareTinkerLog.e(str5, "patch dex opt file not found, but path is null!!!!", new Object[0]);
                            throw new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                        }
                        ShareTinkerLog.e(str5, "patch dex opt file not found:%s", stringExtra6);
                        x10.g().c(new File(stringExtra6), 4, false);
                        return z10;
                    case -10:
                        z10 = false;
                        String stringExtra7 = ShareIntentUtil.getStringExtra(intent, "intent_patch_missing_dex_path");
                        if (stringExtra7 == null) {
                            ShareTinkerLog.e(str5, "patch dex file not found, but path is null!!!!", new Object[0]);
                            throw new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                        }
                        ShareTinkerLog.e(str5, "patch dex file not found:%s", stringExtra7);
                        x10.g().c(new File(stringExtra7), 3, false);
                        return z10;
                    case -9:
                        File file3 = this.f77438i;
                        if (file3 == null) {
                            ShareTinkerLog.e(str5, "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                            throw new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                        }
                        z10 = false;
                        ShareTinkerLog.e(str5, "patch dex file directory not found:%s", file3.getAbsolutePath());
                        x10.g().c(this.f77438i, 3, true);
                        return z10;
                    case -8:
                        ShareTinkerLog.i(str5, "patch package check fail", new Object[0]);
                        if (this.f77437h == null) {
                            throw new TinkerRuntimeException("error patch package check fail , but file is null");
                        }
                        x10.g().b(this.f77437h, intent.getIntExtra("intent_patch_package_patch_check", TAdErrorCode.CODE_UNKNOWN));
                        return false;
                    case -7:
                        z11 = false;
                        ShareTinkerLog.e(str5, "patch version file not found, current version:%s", this.f77431b);
                        if (this.f77437h == null) {
                            throw new TinkerRuntimeException("error load patch version file not exist, but file is null");
                        }
                        x10.g().c(this.f77437h, 1, false);
                        return z11;
                    case PlaybackException.ERROR_CODE_NOT_SUPPORTED /* -6 */:
                        z11 = false;
                        ShareTinkerLog.e(str5, "patch version directory not found, current version:%s", this.f77431b);
                        x10.g().c(this.f77436g, 1, true);
                        return z11;
                    case -5:
                        z11 = false;
                        ShareTinkerLog.e(str5, "path info blank, wait main process to restart", new Object[0]);
                        return z11;
                    case -4:
                        z11 = false;
                        ShareTinkerLog.e(str5, "path info corrupted", new Object[0]);
                        x10.g().g(str2, str, i13);
                        return z11;
                    case -3:
                    case -2:
                        z11 = false;
                        ShareTinkerLog.w(str5, "can't find patch file, is ok, just return", new Object[0]);
                        return z11;
                    case -1:
                        z11 = false;
                        ShareTinkerLog.w(str5, "tinker is disable, just return", new Object[0]);
                        return z11;
                    case 0:
                        ShareTinkerLog.i(str5, "oh yeah, tinker load all success", new Object[0]);
                        x10.w(true);
                        this.f77442m = ShareIntentUtil.getIntentPatchDexPaths(intent);
                        this.f77443n = ShareIntentUtil.getIntentPatchLibsPaths(intent);
                        this.f77444o = ShareIntentUtil.getIntentPackageConfig(intent);
                        if (this.f77434e) {
                            x10.g().d(0, null);
                        }
                        if (r11 && this.f77433d) {
                            x10.g().i(str2, str, file, this.f77436g.getName());
                        }
                        return true;
                    default:
                        return false;
                }
        }
    }
}
