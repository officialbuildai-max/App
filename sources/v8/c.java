package v8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    private static final c f77213c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final String f77214a;

    /* renamed from: b, reason: collision with root package name */
    private final List f77215b;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f77216a = "";

        /* renamed from: b, reason: collision with root package name */
        private List f77217b = new ArrayList();

        a() {
        }

        public c a() {
            return new c(this.f77216a, Collections.unmodifiableList(this.f77217b));
        }

        public a b(List list) {
            this.f77217b = list;
            return this;
        }

        public a c(String str) {
            this.f77216a = str;
            return this;
        }
    }

    c(String str, List list) {
        this.f77214a = str;
        this.f77215b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f77215b;
    }

    public String b() {
        return this.f77214a;
    }
}
