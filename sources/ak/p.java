package ak;

import java.util.HashMap;

/* loaded from: classes5.dex */
public abstract class p {
    public static final void a(String str, String str2, String str3, Float f11) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "long_pressed");
        hashMap.put("subject_id", str2);
        hashMap.put("ops", str3);
        hashMap.put("speed", String.valueOf(f11));
        hj.i iVar = hj.i.f64628a;
        if (str == null) {
            return;
        }
        iVar.p(str, hashMap);
    }

    public static final void b(String str, long j11, String str2, String str3, Float f11) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "long_pressed");
        hashMap.put("subject_id", str2);
        hashMap.put("ops", str3);
        hashMap.put("speed", String.valueOf(f11));
        hashMap.put("duration", String.valueOf(j11));
        hj.i iVar = hj.i.f64628a;
        if (str == null) {
            return;
        }
        iVar.D(str, hashMap);
    }
}
