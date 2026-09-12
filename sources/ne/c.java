package ne;

import android.view.View;
import com.iab.omid.library.mmadbridge.adsession.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import ne.a;
import oe.e;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final a f70447a;

    public c(a aVar) {
        this.f70447a = aVar;
    }

    @Override // ne.a
    public JSONObject a(View view) {
        JSONObject c11 = oe.c.c(0, 0, 0, 0);
        oe.c.e(c11, e.a());
        return c11;
    }

    @Override // ne.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0877a interfaceC0877a, boolean z10, boolean z11) {
        Iterator it = b().iterator();
        while (it.hasNext()) {
            interfaceC0877a.a((View) it.next(), this.f70447a, jSONObject, z11);
        }
    }

    ArrayList b() {
        View rootView;
        ArrayList arrayList = new ArrayList();
        com.iab.omid.library.mmadbridge.internal.c e11 = com.iab.omid.library.mmadbridge.internal.c.e();
        if (e11 != null) {
            Collection a11 = e11.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a11.size() * 2) + 3);
            Iterator it = a11.iterator();
            while (it.hasNext()) {
                View n11 = ((h) it.next()).n();
                if (n11 != null && oe.h.g(n11) && (rootView = n11.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float d11 = oe.h.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && oe.h.d((View) arrayList.get(size - 1)) > d11) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
