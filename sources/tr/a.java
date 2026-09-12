package tr;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import hj.i;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet f76470a = new HashSet();

    public final void a(String pageName, String str, String str2, Integer num, String str3, boolean z10, String str4) {
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", str);
        hashMap.put("ops", str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        hashMap.put(RequestParameters.POSITION, sb2.toString());
        hashMap.put("item_type", str3);
        if (str != null) {
            boolean contains = this.f76470a.contains(str);
            this.f76470a.add(str);
            if (contains) {
                return;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z10);
        hashMap.put("has_resource", sb3.toString());
        hashMap.put("category_type", str4);
        i.f64628a.D(pageName, hashMap);
    }

    public final void b(String pageName, String moduleName, String str, String str2, Integer num, String str3, boolean z10, String str4) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        hashMap.put("subject_id", str);
        hashMap.put("ops", str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        hashMap.put(RequestParameters.POSITION, sb2.toString());
        hashMap.put("item_type", str3);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z10);
        hashMap.put("has_resource", sb3.toString());
        hashMap.put("category_type", str4);
        i.f64628a.p(pageName, hashMap);
    }
}
