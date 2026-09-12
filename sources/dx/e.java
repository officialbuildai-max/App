package dx;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet f61582a = new HashSet();

    public final void a(String pageName, String moduleName, String str, Integer num, boolean z10) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        hashMap.put("subject_id", str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        hashMap.put(RequestParameters.POSITION, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z10);
        hashMap.put("has_resource", sb3.toString());
        com.transsion.baselib.helper.a.f43316a.i(pageName, hashMap);
    }
}
