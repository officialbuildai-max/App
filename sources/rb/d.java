package rb;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final Map f74366a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final int f74367b;

    /* renamed from: c, reason: collision with root package name */
    private final int f74368c;

    public d(int i11, int i12) {
        this.f74367b = i11;
        this.f74368c = i12;
    }

    private String b(String str) {
        if (str != null) {
            return c(str, this.f74368c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String c(String str, int i11) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > i11 ? trim.substring(0, i11) : trim;
    }

    public synchronized Map a() {
        return Collections.unmodifiableMap(new HashMap(this.f74366a));
    }

    public synchronized boolean d(String str, String str2) {
        String b11 = b(str);
        if (this.f74366a.size() >= this.f74367b && !this.f74366a.containsKey(b11)) {
            ob.g.f().k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f74367b);
            return false;
        }
        String c11 = c(str2, this.f74368c);
        if (CommonUtils.y((String) this.f74366a.get(b11), c11)) {
            return false;
        }
        Map map = this.f74366a;
        if (str2 == null) {
            c11 = "";
        }
        map.put(b11, c11);
        return true;
    }

    public synchronized void e(Map map) {
        try {
            int i11 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String b11 = b((String) entry.getKey());
                if (this.f74366a.size() >= this.f74367b && !this.f74366a.containsKey(b11)) {
                    i11++;
                }
                String str = (String) entry.getValue();
                this.f74366a.put(b11, str == null ? "" : c(str, this.f74368c));
            }
            if (i11 > 0) {
                ob.g.f().k("Ignored " + i11 + " entries when adding custom keys. Maximum allowable: " + this.f74367b);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
