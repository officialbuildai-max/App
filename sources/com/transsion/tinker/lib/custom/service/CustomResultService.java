package com.transsion.tinker.lib.custom.service;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.transsion.tinker.lib.custom.api.PatchState;
import java.io.File;
import xu.b;
import yu.a;

/* loaded from: classes6.dex */
public class CustomResultService extends DefaultTinkerResultService {
    private void e(PatchResult patchResult, String str, String str2) {
        try {
            Intent intent = new Intent("com.tencent.tinker.custom.action.PATCH_RESULT");
            intent.setPackage(getPackageName());
            intent.putExtra("patch_result", patchResult);
            if (patchResult != null) {
                intent.putExtra("install_cost_ms", patchResult.totalCostTime);
            }
            if (str != null) {
                intent.putExtra("rollback_reason", str);
            }
            if (str2 != null) {
                intent.putExtra("blacklist_reason", str2);
            }
            ShareTinkerLog.i("Tinker.CustomResultService", "sendPatchResultBroadcast: success=%s pkg=%s", Boolean.valueOf(patchResult != null && patchResult.isSuccess), getPackageName());
            sendBroadcast(intent);
        } catch (Throwable th2) {
            ShareTinkerLog.e("Tinker.CustomResultService", "sendPatchResultBroadcast failed: %s", th2.getMessage());
        }
    }

    @Override // com.tencent.tinker.lib.service.DefaultTinkerResultService, com.tencent.tinker.lib.service.AbstractResultService
    public void a(PatchResult patchResult) {
        String str;
        if (patchResult == null) {
            ShareTinkerLog.e("Tinker.CustomResultService", "received null result", new Object[0]);
            return;
        }
        ShareTinkerLog.i("Tinker.CustomResultService", "onPatchResult: %s", patchResult.toString());
        b f11 = a.f(getApplicationContext());
        String d11 = a.d(getApplicationContext());
        if (d11 == null || d11.isEmpty()) {
            d11 = patchResult.patchVersion;
        }
        String str2 = null;
        if (patchResult.isSuccess) {
            a.o(getApplicationContext(), PatchState.INSTALLED, d11, null);
            a.h(getApplicationContext());
            d(new File(patchResult.rawPatchFilePath));
            e(patchResult, null, null);
            if (!c(patchResult)) {
                ShareTinkerLog.i("Tinker.CustomResultService", "already on new patch version, no need restart", new Object[0]);
                return;
            } else {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException unused) {
                }
                Process.killProcess(Process.myPid());
                return;
            }
        }
        Context applicationContext = getApplicationContext();
        PatchState patchState = PatchState.NONE;
        Throwable th2 = patchResult.f40747e;
        a.o(applicationContext, patchState, d11, th2 != null ? th2.getMessage() : "install_fail");
        if (f11.f78561a && f11.f78564d) {
            xu.a.a(getApplicationContext(), d11, "install_fail", null);
            PatchState e11 = a.e(getApplicationContext());
            String b11 = a.b(getApplicationContext());
            if (e11 == PatchState.BLACKLISTED) {
                str = a.c(getApplicationContext());
            } else if (b11 == null || !b11.equals(d11)) {
                str = null;
                str2 = "install_fail";
            } else {
                str = "install_fail";
                str2 = str;
            }
        } else {
            str = null;
        }
        e(patchResult, str2, str);
    }
}
