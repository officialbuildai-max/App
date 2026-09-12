package i0;

import android.content.res.Configuration;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f64974a = new HashMap();

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.compose.ui.graphics.vector.c f64975a;

        /* renamed from: b, reason: collision with root package name */
        private final int f64976b;

        public a(androidx.compose.ui.graphics.vector.c cVar, int i11) {
            this.f64975a = cVar;
            this.f64976b = i11;
        }

        public final int a() {
            return this.f64976b;
        }

        public final androidx.compose.ui.graphics.vector.c b() {
            return this.f64975a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f64975a, aVar.f64975a) && this.f64976b == aVar.f64976b;
        }

        public int hashCode() {
            return (this.f64975a.hashCode() * 31) + this.f64976b;
        }

        public String toString() {
            return "ImageVectorEntry(imageVector=" + this.f64975a + ", configFlags=" + this.f64976b + ')';
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Resources.Theme f64977a;

        /* renamed from: b, reason: collision with root package name */
        private final int f64978b;

        public b(Resources.Theme theme, int i11) {
            this.f64977a = theme;
            this.f64978b = i11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.f64977a, bVar.f64977a) && this.f64978b == bVar.f64978b;
        }

        public int hashCode() {
            return (this.f64977a.hashCode() * 31) + this.f64978b;
        }

        public String toString() {
            return "Key(theme=" + this.f64977a + ", id=" + this.f64978b + ')';
        }
    }

    public final void a() {
        this.f64974a.clear();
    }

    public final a b(b bVar) {
        WeakReference weakReference = (WeakReference) this.f64974a.get(bVar);
        if (weakReference != null) {
            return (a) weakReference.get();
        }
        return null;
    }

    public final void c(int i11) {
        Iterator it = this.f64974a.entrySet().iterator();
        while (it.hasNext()) {
            a aVar = (a) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
            if (aVar == null || Configuration.needNewResources(i11, aVar.a())) {
                it.remove();
            }
        }
    }

    public final void d(b bVar, a aVar) {
        this.f64974a.put(bVar, new WeakReference(aVar));
    }
}
