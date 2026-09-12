package com.airbnb.lottie;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class PerformanceTracker {

    /* renamed from: a, reason: collision with root package name */
    private boolean f17780a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Set f17781b = new androidx.collection.b();

    /* renamed from: c, reason: collision with root package name */
    private final Map f17782c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Comparator f17783d = new Comparator<androidx.core.util.e>() { // from class: com.airbnb.lottie.PerformanceTracker.1
        @Override // java.util.Comparator
        public int compare(androidx.core.util.e eVar, androidx.core.util.e eVar2) {
            float floatValue = ((Float) eVar.f8348b).floatValue();
            float floatValue2 = ((Float) eVar2.f8348b).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    public void a(String str, float f11) {
        if (this.f17780a) {
            v4.j jVar = (v4.j) this.f17782c.get(str);
            if (jVar == null) {
                jVar = new v4.j();
                this.f17782c.put(str, jVar);
            }
            jVar.a(f11);
            if (str.equals("__container")) {
                Iterator it = this.f17781b.iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.c.a(it.next());
                    throw null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z10) {
        this.f17780a = z10;
    }
}
