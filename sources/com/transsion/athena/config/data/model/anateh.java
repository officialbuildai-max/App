package com.transsion.athena.config.data.model;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class anateh {

    /* renamed from: a, reason: collision with root package name */
    private enatha f42641a = new enatha();

    /* renamed from: b, reason: collision with root package name */
    private List<athena> f42642b = new CopyOnWriteArrayList();

    @Nullable
    public static anateh a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            anateh anatehVar = new anateh();
            enatha a11 = enatha.a(jSONObject.getJSONObject("global_config"));
            if (a11 != null) {
                anatehVar.f42641a = a11;
            }
            return anatehVar;
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            com.transsion.ga.anateh.a("fromJSON", e11);
            return null;
        }
    }

    public athena a(int i11) {
        if (!anehat.b(this.f42642b)) {
            return null;
        }
        for (athena athenaVar : this.f42642b) {
            if (athenaVar.b() == i11) {
                return athenaVar;
            }
        }
        return null;
    }

    public String a(long j11) {
        return this.f42641a.a(j11);
    }

    public List<athena> a() {
        return this.f42642b;
    }

    public void a(List<athena> list) {
        this.f42642b.clear();
        this.f42642b.addAll(list);
    }

    public enatha b() {
        return this.f42641a;
    }

    public List<TidConfigBean> c() {
        ArrayList arrayList = new ArrayList();
        Iterator<athena> it = this.f42642b.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().j());
        }
        return arrayList;
    }

    public void d() {
        for (athena athenaVar : this.f42642b) {
            athenaVar.c(0L);
            athenaVar.b(-1L);
        }
        this.f42641a.f(0L);
        this.f42641a.c(-1L);
    }

    public String e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("global_config", this.f42641a.j());
            return jSONObject.toString();
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            com.transsion.ga.anateh.a("toJSON", e11);
            return "";
        }
    }
}
