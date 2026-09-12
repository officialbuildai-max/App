package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.common.util.BiConsumer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class m {

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f32584e = Charset.forName("UTF-8");

    /* renamed from: f, reason: collision with root package name */
    static final Pattern f32585f = Pattern.compile("^(1|true|t|yes|y|on)$", 2);

    /* renamed from: g, reason: collision with root package name */
    static final Pattern f32586g = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* renamed from: a, reason: collision with root package name */
    private final Set f32587a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private final Executor f32588b;

    /* renamed from: c, reason: collision with root package name */
    private final e f32589c;

    /* renamed from: d, reason: collision with root package name */
    private final e f32590d;

    public m(Executor executor, e eVar, e eVar2) {
        this.f32588b = executor;
        this.f32589c = eVar;
        this.f32590d = eVar2;
    }

    private void c(final String str, final f fVar) {
        if (fVar == null) {
            return;
        }
        synchronized (this.f32587a) {
            try {
                for (final BiConsumer biConsumer : this.f32587a) {
                    this.f32588b.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            BiConsumer.this.accept(str, fVar);
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static f e(e eVar) {
        return eVar.f();
    }

    private static Set f(e eVar) {
        HashSet hashSet = new HashSet();
        f e11 = e(eVar);
        if (e11 == null) {
            return hashSet;
        }
        Iterator<String> keys = e11.g().keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    private static TreeSet h(String str, f fVar) {
        TreeSet treeSet = new TreeSet();
        Iterator<String> keys = fVar.g().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.startsWith(str)) {
                treeSet.add(next);
            }
        }
        return treeSet;
    }

    private static Long j(e eVar, String str) {
        f e11 = e(eVar);
        if (e11 == null) {
            return null;
        }
        try {
            return Long.valueOf(e11.g().getLong(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static String l(e eVar, String str) {
        f e11 = e(eVar);
        if (e11 == null) {
            return null;
        }
        try {
            return e11.g().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static void o(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }

    public void b(BiConsumer biConsumer) {
        synchronized (this.f32587a) {
            this.f32587a.add(biConsumer);
        }
    }

    public Map d() {
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(f(this.f32589c));
        hashSet.addAll(f(this.f32590d));
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            hashMap.put(str, m(str));
        }
        return hashMap;
    }

    public Set g(String str) {
        if (str == null) {
            str = "";
        }
        TreeSet treeSet = new TreeSet();
        f e11 = e(this.f32589c);
        if (e11 != null) {
            treeSet.addAll(h(str, e11));
        }
        f e12 = e(this.f32590d);
        if (e12 != null) {
            treeSet.addAll(h(str, e12));
        }
        return treeSet;
    }

    public long i(String str) {
        Long j11 = j(this.f32589c, str);
        if (j11 != null) {
            c(str, e(this.f32589c));
            return j11.longValue();
        }
        Long j12 = j(this.f32590d, str);
        if (j12 != null) {
            return j12.longValue();
        }
        o(str, "Long");
        return 0L;
    }

    public String k(String str) {
        String l11 = l(this.f32589c, str);
        if (l11 != null) {
            c(str, e(this.f32589c));
            return l11;
        }
        String l12 = l(this.f32590d, str);
        if (l12 != null) {
            return l12;
        }
        o(str, "String");
        return "";
    }

    public yc.k m(String str) {
        String l11 = l(this.f32589c, str);
        if (l11 != null) {
            c(str, e(this.f32589c));
            return new t(l11, 2);
        }
        String l12 = l(this.f32590d, str);
        if (l12 != null) {
            return new t(l12, 1);
        }
        o(str, "FirebaseRemoteConfigValue");
        return new t("", 0);
    }
}
