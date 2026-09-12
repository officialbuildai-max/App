package retrofit2;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class a0 {

    /* loaded from: classes7.dex */
    class a extends a0 {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Iterable iterable) {
            if (iterable == null) {
                return;
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a0.this.a(h0Var, it.next());
            }
        }
    }

    /* loaded from: classes7.dex */
    class b extends a0 {
        b() {
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i11 = 0; i11 < length; i11++) {
                a0.this.a(h0Var, Array.get(obj, i11));
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class c extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final Method f74464a;

        /* renamed from: b, reason: collision with root package name */
        private final int f74465b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.k f74466c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Method method, int i11, retrofit2.k kVar) {
            this.f74464a = method;
            this.f74465b = i11;
            this.f74466c = kVar;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj == null) {
                throw o0.p(this.f74464a, this.f74465b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                h0Var.l((RequestBody) this.f74466c.convert(obj));
            } catch (IOException e11) {
                throw o0.q(this.f74464a, e11, this.f74465b, "Unable to convert " + obj + " to RequestBody", new Object[0]);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class d extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final String f74467a;

        /* renamed from: b, reason: collision with root package name */
        private final retrofit2.k f74468b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f74469c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(String str, retrofit2.k kVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f74467a = str;
            this.f74468b = kVar;
            this.f74469c = z10;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            String str;
            if (obj == null || (str = (String) this.f74468b.convert(obj)) == null) {
                return;
            }
            h0Var.a(this.f74467a, str, this.f74469c);
        }
    }

    /* loaded from: classes7.dex */
    static final class e extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final Method f74470a;

        /* renamed from: b, reason: collision with root package name */
        private final int f74471b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.k f74472c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f74473d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(Method method, int i11, retrofit2.k kVar, boolean z10) {
            this.f74470a = method;
            this.f74471b = i11;
            this.f74472c = kVar;
            this.f74473d = z10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Map map) {
            if (map == null) {
                throw o0.p(this.f74470a, this.f74471b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw o0.p(this.f74470a, this.f74471b, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw o0.p(this.f74470a, this.f74471b, "Field map contained null value for key '" + str + "'.", new Object[0]);
                }
                String str2 = (String) this.f74472c.convert(value);
                if (str2 == null) {
                    throw o0.p(this.f74470a, this.f74471b, "Field map value '" + value + "' converted to null by " + this.f74472c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                h0Var.a(str, str2, this.f74473d);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class f extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final String f74474a;

        /* renamed from: b, reason: collision with root package name */
        private final retrofit2.k f74475b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f74476c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(String str, retrofit2.k kVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f74474a = str;
            this.f74475b = kVar;
            this.f74476c = z10;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            String str;
            if (obj == null || (str = (String) this.f74475b.convert(obj)) == null) {
                return;
            }
            h0Var.b(this.f74474a, str, this.f74476c);
        }
    }

    /* loaded from: classes7.dex */
    static final class g extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final Method f74477a;

        /* renamed from: b, reason: collision with root package name */
        private final int f74478b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.k f74479c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f74480d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Method method, int i11, retrofit2.k kVar, boolean z10) {
            this.f74477a = method;
            this.f74478b = i11;
            this.f74479c = kVar;
            this.f74480d = z10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Map map) {
            if (map == null) {
                throw o0.p(this.f74477a, this.f74478b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw o0.p(this.f74477a, this.f74478b, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw o0.p(this.f74477a, this.f74478b, "Header map contained null value for key '" + str + "'.", new Object[0]);
                }
                h0Var.b(str, (String) this.f74479c.convert(value), this.f74480d);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class h extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final Method f74481a;

        /* renamed from: b, reason: collision with root package name */
        private final int f74482b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(Method method, int i11) {
            this.f74481a = method;
            this.f74482b = i11;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Headers headers) {
            if (headers == null) {
                throw o0.p(this.f74481a, this.f74482b, "Headers parameter must not be null.", new Object[0]);
            }
            h0Var.c(headers);
        }
    }

    /* loaded from: classes7.dex */
    static final class i extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final Method f74483a;

        /* renamed from: b, reason: collision with root package name */
        private final int f74484b;

        /* renamed from: c, reason: collision with root package name */
        private final Headers f74485c;

        /* renamed from: d, reason: collision with root package name */
        private final retrofit2.k f74486d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(Method method, int i11, Headers headers, retrofit2.k kVar) {
            this.f74483a = method;
            this.f74484b = i11;
            this.f74485c = headers;
            this.f74486d = kVar;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj == null) {
                return;
            }
            try {
                h0Var.d(this.f74485c, (RequestBody) this.f74486d.convert(obj));
            } catch (IOException e11) {
                throw o0.p(this.f74483a, this.f74484b, "Unable to convert " + obj + " to RequestBody", e11);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class j extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final Method f74487a;

        /* renamed from: b, reason: collision with root package name */
        private final int f74488b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.k f74489c;

        /* renamed from: d, reason: collision with root package name */
        private final String f74490d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(Method method, int i11, retrofit2.k kVar, String str) {
            this.f74487a = method;
            this.f74488b = i11;
            this.f74489c = kVar;
            this.f74490d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Map map) {
            if (map == null) {
                throw o0.p(this.f74487a, this.f74488b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw o0.p(this.f74487a, this.f74488b, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw o0.p(this.f74487a, this.f74488b, "Part map contained null value for key '" + str + "'.", new Object[0]);
                }
                h0Var.d(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.f74490d), (RequestBody) this.f74489c.convert(value));
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class k extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final Method f74491a;

        /* renamed from: b, reason: collision with root package name */
        private final int f74492b;

        /* renamed from: c, reason: collision with root package name */
        private final String f74493c;

        /* renamed from: d, reason: collision with root package name */
        private final retrofit2.k f74494d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f74495e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(Method method, int i11, String str, retrofit2.k kVar, boolean z10) {
            this.f74491a = method;
            this.f74492b = i11;
            Objects.requireNonNull(str, "name == null");
            this.f74493c = str;
            this.f74494d = kVar;
            this.f74495e = z10;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj != null) {
                h0Var.f(this.f74493c, (String) this.f74494d.convert(obj), this.f74495e);
                return;
            }
            throw o0.p(this.f74491a, this.f74492b, "Path parameter \"" + this.f74493c + "\" value must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes7.dex */
    static final class l extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final String f74496a;

        /* renamed from: b, reason: collision with root package name */
        private final retrofit2.k f74497b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f74498c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public l(String str, retrofit2.k kVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f74496a = str;
            this.f74497b = kVar;
            this.f74498c = z10;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            String str;
            if (obj == null || (str = (String) this.f74497b.convert(obj)) == null) {
                return;
            }
            h0Var.g(this.f74496a, str, this.f74498c);
        }
    }

    /* loaded from: classes7.dex */
    static final class m extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final Method f74499a;

        /* renamed from: b, reason: collision with root package name */
        private final int f74500b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.k f74501c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f74502d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(Method method, int i11, retrofit2.k kVar, boolean z10) {
            this.f74499a = method;
            this.f74500b = i11;
            this.f74501c = kVar;
            this.f74502d = z10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, Map map) {
            if (map == null) {
                throw o0.p(this.f74499a, this.f74500b, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw o0.p(this.f74499a, this.f74500b, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw o0.p(this.f74499a, this.f74500b, "Query map contained null value for key '" + str + "'.", new Object[0]);
                }
                String str2 = (String) this.f74501c.convert(value);
                if (str2 == null) {
                    throw o0.p(this.f74499a, this.f74500b, "Query map value '" + value + "' converted to null by " + this.f74501c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                h0Var.g(str, str2, this.f74502d);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class n extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final retrofit2.k f74503a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f74504b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public n(retrofit2.k kVar, boolean z10) {
            this.f74503a = kVar;
            this.f74504b = z10;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj == null) {
                return;
            }
            h0Var.g((String) this.f74503a.convert(obj), null, this.f74504b);
        }
    }

    /* loaded from: classes7.dex */
    static final class o extends a0 {

        /* renamed from: a, reason: collision with root package name */
        static final o f74505a = new o();

        private o() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, MultipartBody.Part part) {
            if (part != null) {
                h0Var.e(part);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class p extends a0 {

        /* renamed from: a, reason: collision with root package name */
        private final Method f74506a;

        /* renamed from: b, reason: collision with root package name */
        private final int f74507b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public p(Method method, int i11) {
            this.f74506a = method;
            this.f74507b = i11;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            if (obj == null) {
                throw o0.p(this.f74506a, this.f74507b, "@Url parameter is null.", new Object[0]);
            }
            h0Var.m(obj);
        }
    }

    /* loaded from: classes7.dex */
    static final class q extends a0 {

        /* renamed from: a, reason: collision with root package name */
        final Class f74508a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public q(Class cls) {
            this.f74508a = cls;
        }

        @Override // retrofit2.a0
        void a(h0 h0Var, Object obj) {
            h0Var.h(this.f74508a, obj);
        }
    }

    a0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(h0 h0Var, Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a0 b() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a0 c() {
        return new a();
    }
}
