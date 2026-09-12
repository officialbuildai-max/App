package com.mbridge.msdk.setting;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f37367a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, f> f37368b;

    /* loaded from: classes5.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final e f37369a = new e();
    }

    private e() {
        this.f37367a = 6;
        this.f37368b = new HashMap<>();
    }

    public static e a() {
        return b.f37369a;
    }

    public int a(String str) {
        HashMap<String, f> hashMap;
        f fVar;
        if (TextUtils.isEmpty(str) || (hashMap = this.f37368b) == null || !hashMap.containsKey(str) || (fVar = this.f37368b.get(str)) == null) {
            return 0;
        }
        int i11 = fVar.b() ? 1 : fVar.a() >= this.f37367a ? 2 : 0;
        fVar.a(false);
        return i11;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (this.f37368b == null) {
                this.f37368b = new HashMap<>();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                f fVar = new f();
                fVar.a(next);
                fVar.b(string);
                this.f37368b.put(next, fVar);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
