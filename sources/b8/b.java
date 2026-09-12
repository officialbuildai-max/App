package b8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f16328a = d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends b {

        /* renamed from: b, reason: collision with root package name */
        private static final Map f16329b;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put(Bundle.class, new v7.a());
            hashMap.put(Intent.class, new v7.b());
            f16329b = Collections.unmodifiableMap(hashMap);
        }

        a() {
        }

        @Override // b8.b
        Map a() {
            return f16329b;
        }

        @Override // b8.b
        e8.c b() {
            return new e8.a();
        }

        @Override // b8.b
        public void c(String str) {
            Log.e("XLog", str);
        }

        @Override // b8.b
        String f() {
            return System.lineSeparator();
        }

        @Override // b8.b
        public void g(String str) {
            Log.w("XLog", str);
        }
    }

    private static b d() {
        try {
            Class.forName("android.os.Build");
            return new a();
        } catch (ClassNotFoundException unused) {
            return new b();
        }
    }

    public static b e() {
        return f16328a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map a() {
        return Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e8.c b() {
        return new e8.b();
    }

    public void c(String str) {
        System.out.println(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return System.lineSeparator();
    }

    public void g(String str) {
        System.out.println(str);
    }
}
