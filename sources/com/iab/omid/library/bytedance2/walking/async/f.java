package com.iab.omid.library.bytedance2.walking.async;

import android.text.TextUtils;
import com.iab.omid.library.bytedance2.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f extends a {
    public f(b.InterfaceC0459b interfaceC0459b, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0459b, hashSet, jSONObject, j11);
    }

    private void b(String str) {
        com.iab.omid.library.bytedance2.internal.c c11 = com.iab.omid.library.bytedance2.internal.c.c();
        if (c11 != null) {
            for (com.iab.omid.library.bytedance2.adsession.a aVar : c11.b()) {
                if (this.f33574c.contains(aVar.getAdSessionId())) {
                    aVar.getAdSessionStatePublisher().b(str, this.f33576e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        if (com.iab.omid.library.bytedance2.utils.c.h(this.f33575d, this.f33578b.a())) {
            return null;
        }
        this.f33578b.a(this.f33575d);
        return this.f33575d.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iab.omid.library.bytedance2.walking.async.b, android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        }
        super.onPostExecute(str);
    }
}
