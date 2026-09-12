package com.apm.insight.l;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private Writer f19754a;

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f19755b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f19756a = new a("EMPTY_ARRAY", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final a f19757b = new a("NONEMPTY_ARRAY", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final a f19758c = new a("EMPTY_OBJECT", 2);

        /* renamed from: d, reason: collision with root package name */
        public static final a f19759d = new a("DANGLING_KEY", 3);

        /* renamed from: e, reason: collision with root package name */
        public static final a f19760e = new a("NONEMPTY_OBJECT", 4);

        /* renamed from: f, reason: collision with root package name */
        public static final a f19761f = new a("NULL", 5);

        private a(String str, int i11) {
        }
    }

    private h(Writer writer) {
        this.f19754a = writer;
    }

    private h a() throws JSONException, IOException {
        return a(a.f19756a, "[");
    }

    private h a(a aVar, String str) throws JSONException, IOException {
        f();
        this.f19755b.add(aVar);
        this.f19754a.write(str);
        return this;
    }

    private h a(Object obj) throws JSONException, IOException {
        if (obj instanceof JSONArray) {
            a((JSONArray) obj);
            return this;
        }
        if (obj instanceof JSONObject) {
            a((JSONObject) obj);
            return this;
        }
        f();
        if (obj == null || obj == JSONObject.NULL) {
            this.f19754a.write("null");
        } else if (obj instanceof Boolean) {
            this.f19754a.write(String.valueOf(obj));
        } else if (obj instanceof Number) {
            this.f19754a.write(JSONObject.numberToString((Number) obj));
        } else {
            b(obj.toString());
        }
        return this;
    }

    private h a(String str) throws JSONException, IOException {
        e();
        this.f19755b.remove(r0.size() - 1);
        this.f19754a.write(str);
        return this;
    }

    private void a(a aVar) {
        this.f19755b.set(r0.size() - 1, aVar);
    }

    private void a(JSONArray jSONArray) throws JSONException, IOException {
        a();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            a(jSONArray.get(i11));
        }
        b();
    }

    public static void a(JSONArray jSONArray, Writer writer) throws Throwable {
        new h(writer).a(jSONArray);
        writer.flush();
    }

    private void a(JSONObject jSONObject) throws JSONException, IOException {
        c();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            c(next).a(jSONObject.get(next));
        }
        d();
    }

    public static void a(JSONObject jSONObject, Writer writer) throws Throwable {
        new h(writer).a(jSONObject);
        writer.flush();
    }

    private h b() throws JSONException, IOException {
        a aVar = a.f19756a;
        return a("]");
    }

    private void b(String str) throws IOException {
        this.f19754a.write("\"");
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt == '\f') {
                this.f19754a.write("\\f");
            } else if (charAt != '\r') {
                if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                    switch (charAt) {
                        case '\b':
                            this.f19754a.write("\\b");
                            continue;
                        case '\t':
                            this.f19754a.write("\\t");
                            continue;
                        case '\n':
                            this.f19754a.write("\\n");
                            continue;
                        default:
                            if (charAt <= 31) {
                                this.f19754a.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                                break;
                            }
                            break;
                    }
                } else {
                    this.f19754a.write(92);
                }
                this.f19754a.write(charAt);
            } else {
                this.f19754a.write("\\r");
            }
        }
        this.f19754a.write("\"");
    }

    private h c() throws JSONException, IOException {
        return a(a.f19758c, "{");
    }

    private h c(String str) throws JSONException, IOException {
        a e11 = e();
        if (e11 == a.f19760e) {
            this.f19754a.write(44);
        } else if (e11 != a.f19758c) {
            throw new JSONException("Nesting problem");
        }
        a(a.f19759d);
        b(str);
        return this;
    }

    private h d() throws JSONException, IOException {
        a aVar = a.f19756a;
        return a("}");
    }

    private a e() throws JSONException {
        return this.f19755b.get(r0.size() - 1);
    }

    private void f() throws JSONException, IOException {
        if (this.f19755b.isEmpty()) {
            return;
        }
        a e11 = e();
        if (e11 == a.f19756a) {
            a(a.f19757b);
            return;
        }
        if (e11 == a.f19757b) {
            this.f19754a.write(44);
        } else if (e11 == a.f19759d) {
            this.f19754a.write(":");
            a(a.f19760e);
        } else if (e11 != a.f19761f) {
            throw new JSONException("Nesting problem");
        }
    }

    public final String toString() {
        return "";
    }
}
