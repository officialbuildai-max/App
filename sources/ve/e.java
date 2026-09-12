package ve;

import com.iab.omid.library.vungle.adsession.h;
import java.util.HashSet;
import org.json.JSONObject;
import ve.b;

/* loaded from: classes5.dex */
public class e extends a {
    public e(b.InterfaceC0975b interfaceC0975b, HashSet hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0975b, hashSet, jSONObject, j11);
    }

    private void e(String str) {
        com.iab.omid.library.vungle.internal.c e11 = com.iab.omid.library.vungle.internal.c.e();
        if (e11 != null) {
            for (h hVar : e11.c()) {
                if (this.f77393c.contains(hVar.j())) {
                    hVar.k().h(str, this.f77395e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ve.b, android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        e(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        return this.f77394d.toString();
    }
}
