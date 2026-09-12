package com.transsion.shorttv.order;

import com.google.gson.JsonObject;
import com.transsion.shorttv.order.a;
import com.transsion.shorttv.order.bean.CreatePaynicornOrderReqBean;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f53104a = new g();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f53105b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.order.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a e11;
            e11 = g.e();
            return e11;
        }
    });

    private g() {
    }

    private final a d() {
        return (a) f53105b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a e() {
        return (a) zg.c.f79537e.a().h(a.class);
    }

    public final Object b(CreatePaynicornOrderReqBean createPaynicornOrderReqBean, Continuation continuation) {
        Map<String, String> extStrJson;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("project_name", createPaynicornOrderReqBean != null ? createPaynicornOrderReqBean.getProjectName() : null);
        jsonObject.addProperty("sku_id", createPaynicornOrderReqBean != null ? createPaynicornOrderReqBean.getSkuId() : null);
        jsonObject.addProperty("user_id", createPaynicornOrderReqBean != null ? createPaynicornOrderReqBean.getUserId() : null);
        jsonObject.addProperty("cp_front_page", createPaynicornOrderReqBean != null ? createPaynicornOrderReqBean.getCpFrontPage() : null);
        if (createPaynicornOrderReqBean != null && (extStrJson = createPaynicornOrderReqBean.getExtStrJson()) != null) {
            String jSONObject = new JSONObject(extStrJson).toString();
            Intrinsics.g(jSONObject, "toString(...)");
            jsonObject.addProperty("ext", jSONObject);
        }
        RequestBody.Companion companion = RequestBody.INSTANCE;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        return a.C0656a.a(d(), null, companion.create(jsonElement, MediaType.INSTANCE.parse("application/json")), e.f53103a.a(createPaynicornOrderReqBean != null ? Boxing.a(createPaynicornOrderReqBean.isDebug()) : null), continuation, 1, null);
    }

    public final Object c(String str, String str2, boolean z10, Continuation continuation) {
        return a.C0656a.b(d(), null, str == null ? "" : str, str2 == null ? "" : str2, e.f53103a.a(Boxing.a(z10)), continuation, 1, null);
    }
}
