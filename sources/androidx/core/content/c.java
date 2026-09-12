package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.i;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f8216a;

    /* renamed from: b, reason: collision with root package name */
    private final LocusId f8217b;

    /* loaded from: classes.dex */
    private static class a {
        static LocusId a(String str) {
            return new LocusId(str);
        }

        static String b(LocusId locusId) {
            return locusId.getId();
        }
    }

    public c(String str) {
        this.f8216a = (String) i.j(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f8217b = a.a(str);
        } else {
            this.f8217b = null;
        }
    }

    private String a() {
        return this.f8216a.length() + "_chars";
    }

    public static c c(LocusId locusId) {
        i.h(locusId, "locusId cannot be null");
        return new c((String) i.j(a.b(locusId), "id cannot be empty"));
    }

    public LocusId b() {
        return this.f8217b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.f8216a;
        return str == null ? cVar.f8216a == null : str.equals(cVar.f8216a);
    }

    public int hashCode() {
        String str = this.f8216a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + a() + "]";
    }
}
