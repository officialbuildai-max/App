package he;

import android.view.View;
import com.iab.omid.library.hisavana.adsession.h;
import he.a;
import ie.e;
import ie.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final a f64549a;

    public c(a aVar) {
        this.f64549a = aVar;
    }

    @Override // he.a
    public JSONObject a(View view) {
        JSONObject c11 = ie.c.c(0, 0, 0, 0);
        ie.c.e(c11, e.a());
        return c11;
    }

    @Override // he.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0805a interfaceC0805a, boolean z10, boolean z11) {
        Iterator it = b().iterator();
        while (it.hasNext()) {
            interfaceC0805a.a((View) it.next(), this.f64549a, jSONObject, z11);
        }
    }

    ArrayList b() {
        View rootView;
        ArrayList arrayList = new ArrayList();
        com.iab.omid.library.hisavana.internal.c e11 = com.iab.omid.library.hisavana.internal.c.e();
        if (e11 != null) {
            Collection a11 = e11.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a11.size() * 2) + 3);
            Iterator it = a11.iterator();
            while (it.hasNext()) {
                View m11 = ((h) it.next()).m();
                if (m11 != null && i.g(m11) && (rootView = m11.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float d11 = i.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && i.d((View) arrayList.get(size - 1)) > d11) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
