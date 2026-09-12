package wu;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.tencent.tinker.lib.service.PatchResult;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes7.dex */
public final class g implements ou.c {

    /* renamed from: a, reason: collision with root package name */
    private final ou.b f78101a;

    public g(ou.b bVar) {
        this.f78101a = bVar;
    }

    @Override // ou.c
    public void a(Throwable th2, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "load_exception");
        hashMap.put("error_code", String.valueOf(i11));
        if (th2 != null) {
            hashMap.put("exception", th2.getClass().getSimpleName());
            if (th2.getMessage() != null) {
                hashMap.put("message", th2.getMessage());
            }
        }
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "patch_upgraded");
        if (str != null) {
            hashMap.put("from_patch_id", str);
        }
        if (str2 != null) {
            hashMap.put("to_patch_id", str2);
        }
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void c(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "blacklisted");
        if (str != null) {
            hashMap.put("patch_id", str);
        }
        if (str2 != null) {
            hashMap.put("reason", str2);
        }
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void d(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "download_start");
        if (str != null) {
            hashMap.put("patch_id", str);
        }
        if (str2 != null) {
            hashMap.put("url", str2);
        }
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void e(File file, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "patch_listener_receive_fail");
        hashMap.put("error_code", String.valueOf(i11));
        if (file != null) {
            hashMap.put("patch_file", file.getName());
        }
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void f() {
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "patch_service_start");
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void g(String str, Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "patch_install_exception");
        if (str != null) {
            hashMap.put("patch_id", str);
        }
        if (th2 != null) {
            hashMap.put("exception", th2.getClass().getSimpleName());
            if (th2.getMessage() != null) {
                hashMap.put("message", th2.getMessage());
            }
        }
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void h(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "rollback");
        if (str != null) {
            hashMap.put("patch_id", str);
        }
        if (str2 != null) {
            hashMap.put("reason", str2);
        }
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void i(String str, boolean z10, long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "patch_install_result");
        if (str != null) {
            hashMap.put("patch_id", str);
        }
        hashMap.put(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, String.valueOf(z10));
        hashMap.put("cost_ms", String.valueOf(j11));
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void j(PatchResult patchResult) {
        if (patchResult == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "patch_result_report");
        hashMap.put(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, String.valueOf(patchResult.isSuccess));
        String str = patchResult.patchVersion;
        if (str != null) {
            hashMap.put("patch_id", str);
        }
        Throwable th2 = patchResult.f40747e;
        if (th2 != null) {
            hashMap.put("exception", th2.getClass().getSimpleName());
        }
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void k(int i11, long j11) {
        if (i11 == -1 || i11 == -2) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "load_result");
        hashMap.put("load_code", String.valueOf(i11));
        hashMap.put("load_result", i11 == 0 ? NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS : "fail");
        hashMap.put("cost_ms", String.valueOf(j11));
        this.f78101a.a("hotfix_event", hashMap);
    }

    @Override // ou.c
    public void l(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sub_type", "download_blocked");
        if (str != null) {
            hashMap.put("patch_id", str);
        }
        if (str2 != null) {
            hashMap.put("reason", str2);
        }
        this.f78101a.a("hotfix_event", hashMap);
    }
}
