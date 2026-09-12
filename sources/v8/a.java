package v8;

import com.google.android.datatransport.runtime.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    private static final a f77201e = new C0974a().b();

    /* renamed from: a, reason: collision with root package name */
    private final e f77202a;

    /* renamed from: b, reason: collision with root package name */
    private final List f77203b;

    /* renamed from: c, reason: collision with root package name */
    private final b f77204c;

    /* renamed from: d, reason: collision with root package name */
    private final String f77205d;

    /* renamed from: v8.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0974a {

        /* renamed from: a, reason: collision with root package name */
        private e f77206a = null;

        /* renamed from: b, reason: collision with root package name */
        private List f77207b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private b f77208c = null;

        /* renamed from: d, reason: collision with root package name */
        private String f77209d = "";

        C0974a() {
        }

        public C0974a a(c cVar) {
            this.f77207b.add(cVar);
            return this;
        }

        public a b() {
            return new a(this.f77206a, Collections.unmodifiableList(this.f77207b), this.f77208c, this.f77209d);
        }

        public C0974a c(String str) {
            this.f77209d = str;
            return this;
        }

        public C0974a d(b bVar) {
            this.f77208c = bVar;
            return this;
        }

        public C0974a e(e eVar) {
            this.f77206a = eVar;
            return this;
        }
    }

    a(e eVar, List list, b bVar, String str) {
        this.f77202a = eVar;
        this.f77203b = list;
        this.f77204c = bVar;
        this.f77205d = str;
    }

    public static C0974a e() {
        return new C0974a();
    }

    public String a() {
        return this.f77205d;
    }

    public b b() {
        return this.f77204c;
    }

    public List c() {
        return this.f77203b;
    }

    public e d() {
        return this.f77202a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
