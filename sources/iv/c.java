package iv;

import com.google.gson.Gson;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.server.q;
import com.transsion.transfer.impl.i;
import com.transsion.transfer.impl.server.service.NotifyFileErrorService;
import com.transsion.transfer.impl.server.service.NotifyFileFinishService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f65742d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final String f65743e = c.class.getName();

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy f65744f = LazyKt.b(new Function0() { // from class: iv.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Gson f11;
            f11 = c.f();
            return f11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final com.transsion.transfer.impl.g f65745a;

    /* renamed from: b, reason: collision with root package name */
    private i f65746b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f65747c;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Gson b() {
            return (Gson) c.f65744f.getValue();
        }

        public final String a(int i11, String errorMsg, Object obj) {
            Intrinsics.h(errorMsg, "errorMsg");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("code", Integer.valueOf(i11));
            linkedHashMap.put("errorMsg", errorMsg);
            if (obj == null) {
                linkedHashMap.put("data", "");
            } else {
                linkedHashMap.put("data", obj);
            }
            String json = b().toJson(linkedHashMap);
            Intrinsics.e(json);
            return json;
        }

        public final Triple c(Headers headers) {
            String str;
            String c11;
            String c12;
            String str2 = "";
            if (headers == null || (str = headers.c("transferId")) == null) {
                str = "";
            }
            int parseInt = (headers == null || (c12 = headers.c("transferProtocolVersion")) == null) ? 1 : Integer.parseInt(c12);
            if (headers != null && (c11 = headers.c("clientIp")) != null) {
                str2 = c11;
            }
            return new Triple(str, Integer.valueOf(parseInt), str2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        public static final a f65748d = new a(null);

        /* renamed from: a, reason: collision with root package name */
        private final String f65749a;

        /* renamed from: b, reason: collision with root package name */
        private final String f65750b;

        /* renamed from: c, reason: collision with root package name */
        private final q f65751c;

        /* loaded from: classes7.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(String method, String path, q requestCallback) {
            Intrinsics.h(method, "method");
            Intrinsics.h(path, "path");
            Intrinsics.h(requestCallback, "requestCallback");
            this.f65749a = method;
            this.f65750b = path;
            this.f65751c = requestCallback;
        }

        public final String a() {
            return this.f65749a;
        }

        public final String b() {
            return this.f65750b;
        }

        public final q c() {
            return this.f65751c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.f65749a, bVar.f65749a) && Intrinsics.c(this.f65750b, bVar.f65750b) && Intrinsics.c(this.f65751c, bVar.f65751c);
        }

        public int hashCode() {
            return (((this.f65749a.hashCode() * 31) + this.f65750b.hashCode()) * 31) + this.f65751c.hashCode();
        }

        public String toString() {
            return "Service(method=" + this.f65749a + ", path=" + this.f65750b + ", requestCallback=" + this.f65751c + ")";
        }
    }

    public c(com.transsion.transfer.impl.g fileHandler, i listener) {
        Intrinsics.h(fileHandler, "fileHandler");
        Intrinsics.h(listener, "listener");
        this.f65745a = fileHandler;
        this.f65746b = listener;
        this.f65747c = LazyKt.b(new Function0() { // from class: iv.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List g11;
                g11 = c.g(c.this);
                return g11;
            }
        });
    }

    private final List d() {
        return (List) this.f65747c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson f() {
        return new Gson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g(c cVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b("get", "/client/getTransferFilesList", new com.transsion.transfer.impl.server.service.b(cVar.f65745a, cVar.f65746b)));
        arrayList.add(new b("get", "/client/fetchFile*", new com.transsion.transfer.impl.server.service.a(cVar.f65745a, cVar.f65746b)));
        arrayList.add(new b("get", "/client/notifyServerCreate", new com.transsion.transfer.impl.server.service.d(cVar.f65745a, cVar.f65746b)));
        arrayList.add(new b("get", "/client/notifyClientClose", new com.transsion.transfer.impl.server.service.c(cVar.f65745a, cVar.f65746b)));
        arrayList.add(new b("get", "/client/notifyServerSendComplete", new com.transsion.transfer.impl.server.service.g(cVar.f65745a, cVar.f65746b)));
        arrayList.add(new b("post", "/client/notifyFileTaskFinish", new NotifyFileFinishService(cVar.f65745a, cVar.f65746b)));
        arrayList.add(new b("post", "/client/notifyFileTaskError", new NotifyFileErrorService(cVar.f65745a, cVar.f65746b)));
        return arrayList;
    }

    public final List e() {
        return d();
    }
}
