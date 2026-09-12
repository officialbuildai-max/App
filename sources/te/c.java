package te;

import android.view.View;
import com.iab.omid.library.vungle.adsession.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;
import te.a;
import ue.e;

/* loaded from: classes5.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final a f76323a;

    public c(a aVar) {
        this.f76323a = aVar;
    }

    @Override // te.a
    public JSONObject a(View view) {
        JSONObject b11 = ue.c.b(0, 0, 0, 0);
        ue.c.e(b11, e.a());
        return b11;
    }

    @Override // te.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0951a interfaceC0951a, boolean z10, boolean z11) {
        Iterator it = b().iterator();
        while (it.hasNext()) {
            interfaceC0951a.a((View) it.next(), this.f76323a, jSONObject, z11);
        }
    }

    ArrayList b() {
        View rootView;
        ArrayList arrayList = new ArrayList();
        com.iab.omid.library.vungle.internal.c e11 = com.iab.omid.library.vungle.internal.c.e();
        if (e11 != null) {
            Collection a11 = e11.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a11.size() * 2) + 3);
            Iterator it = a11.iterator();
            while (it.hasNext()) {
                View l11 = ((h) it.next()).l();
                if (l11 != null && ue.h.g(l11) && (rootView = l11.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float d11 = ue.h.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && ue.h.d((View) arrayList.get(size - 1)) > d11) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
