package com.transsion.publish;

import android.text.TextUtils;
import com.transsion.publish.api.LinkEntity;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import org.jsoup.nodes.Document;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f50499a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f50500b = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.publish.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            c c11;
            c11 = c.c();
            return c11;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return (c) c.f50500b.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c c() {
        return new c();
    }

    private final void e(Runnable runnable) {
        p.f50512b.a().d(runnable);
    }

    private final void f(String str, String str2, String str3, boolean z10) {
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setTitle(str);
        linkEntity.setCover(str2);
        linkEntity.setUrl(str3);
        linkEntity.setType(4);
        linkEntity.setLoading(z10);
        fp.a aVar = new fp.a();
        aVar.o(4);
        aVar.n(1);
        aVar.p(linkEntity);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = fp.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(c cVar, String str) {
        try {
            cVar.f(str == null ? "" : str, "", str == null ? "" : str, false);
            if (str != null) {
                cVar.i(str);
            }
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message != null) {
                a.C0856a.f(lg.a.f68962a, "LinkParseManager", message, false, 4, null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str2 = str == null ? "" : str;
            if (str == null) {
                str = "";
            }
            cVar.f(str2, "", str, true);
        }
    }

    private final void i(String str) {
        Document document = d10.a.a(str).a(true).get();
        Intrinsics.g(document, "get(...)");
        String j12 = document.j1();
        Intrinsics.g(j12, "title(...)");
        a.C0856a.f(lg.a.f68962a, "LinkParseManager", "title:" + j12, false, 4, null);
        f(j12, "", str, true);
    }

    public final void g(final String str) {
        if (TextUtils.isEmpty(str)) {
            uh.b.f76876a.e("Not a valid link");
        } else {
            e(new Runnable() { // from class: com.transsion.publish.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.h(c.this, str);
                }
            });
        }
    }
}
