package sm;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transsion.base.report.athena.sampler.EventConfig;
import com.transsion.mb.config.manager.ConfigBean;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final a f75530c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f75531d = LazyKt.b(new Function0() { // from class: sm.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            f g11;
            g11 = f.g();
            return g11;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static HashSet f75532e = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f75533a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final HashSet f75534b = new HashSet();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a() {
            return (f) f.f75531d.getValue();
        }
    }

    public static /* synthetic */ ConfigBean d(f fVar, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        return fVar.c(str, z10);
    }

    private final String e() {
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().getTime());
        Intrinsics.g(format, "format(...)");
        return format;
    }

    private final ConfigBean f(String str) {
        d dVar = d.f75526a;
        String string = dVar.e().getString(str, "");
        if (string != null && string.length() != 0) {
            return (ConfigBean) o.d(string, ConfigBean.class);
        }
        String string2 = dVar.f().getString(str, "");
        int c11 = i.c(i.f75535a, str, 0, 2, null);
        if (c11 >= 0 && string2 != null && string2.length() != 0) {
            JsonArray asJsonArray = ((JsonObject) o.d(string2, JsonObject.class)).get(str).getAsJsonArray();
            if (asJsonArray.size() > c11) {
                String jsonElement = asJsonArray.get(c11).toString();
                Intrinsics.g(jsonElement, "toString(...)");
                ConfigBean configBean = (ConfigBean) o.d(jsonElement, ConfigBean.class);
                dVar.e().putString(str, jsonElement);
                return configBean;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f g() {
        return new f();
    }

    private final void h(ConfigBean configBean) {
        if (TextUtils.isEmpty(configBean.getOps())) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("key", configBean.getKey());
        hashMap.put("ops", configBean.getOps());
        hashMap.put("isFirebase", String.valueOf(configBean.isFirebase()));
        hj.i.f64628a.t("config_ab_result", hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        if (r0.getHasUpdate() == true) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.transsion.mb.config.manager.ConfigBean c(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.h(r4, r0)
            java.util.HashMap r0 = r3.f75533a
            boolean r0 = r0.containsKey(r4)
            r1 = 0
            if (r0 == 0) goto L21
            java.util.HashMap r0 = r3.f75533a
            java.lang.Object r0 = r0.get(r4)
            com.transsion.mb.config.manager.ConfigBean r0 = (com.transsion.mb.config.manager.ConfigBean) r0
            if (r5 == 0) goto L22
            if (r0 == 0) goto L22
            boolean r5 = r0.getHasUpdate()
            r2 = 1
            if (r5 != r2) goto L22
        L21:
            r0 = r1
        L22:
            if (r0 != 0) goto L58
            sm.d r5 = sm.d.f75526a
            com.tencent.mmkv.MMKV r5 = r5.g()
            java.lang.String r5 = r5.getString(r4, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L3e
            if (r1 != 0) goto L40
            java.lang.Class<com.transsion.mb.config.manager.ConfigBean> r1 = com.transsion.mb.config.manager.ConfigBean.class
            java.lang.Object r5 = com.blankj.utilcode.util.o.d(r5, r1)     // Catch: java.lang.Exception -> L3e
            com.transsion.mb.config.manager.ConfigBean r5 = (com.transsion.mb.config.manager.ConfigBean) r5     // Catch: java.lang.Exception -> L3e
            r0 = r5
            goto L40
        L3e:
            r5 = move-exception
            goto L50
        L40:
            if (r0 != 0) goto L53
            java.util.HashSet r5 = sm.f.f75532e     // Catch: java.lang.Exception -> L3e
            boolean r5 = r5.contains(r4)     // Catch: java.lang.Exception -> L3e
            if (r5 == 0) goto L53
            com.transsion.mb.config.manager.ConfigBean r5 = r3.f(r4)     // Catch: java.lang.Exception -> L3e
            r0 = r5
            goto L53
        L50:
            r5.printStackTrace()
        L53:
            java.util.HashMap r5 = r3.f75533a
            r5.put(r4, r0)
        L58:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = r3.e()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            if (r0 == 0) goto L7d
            java.util.HashSet r5 = r3.f75534b
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto L7d
            r3.h(r0)
            java.util.HashSet r5 = r3.f75534b
            r5.add(r4)
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sm.f.c(java.lang.String, boolean):com.transsion.mb.config.manager.ConfigBean");
    }

    public final void i(com.google.firebase.remoteconfig.a firebaseRemoteConfig) {
        Intrinsics.h(firebaseRemoteConfig, "firebaseRemoteConfig");
        Set<String> m11 = firebaseRemoteConfig.m("");
        Intrinsics.g(m11, "getKeysByPrefix(...)");
        for (String str : m11) {
            ConfigBean configBean = new ConfigBean();
            configBean.setKey(str);
            configBean.setValue(firebaseRemoteConfig.p(str));
            configBean.setFirebase(true);
            d.f75526a.g().putString(str, o.j(configBean));
        }
    }

    public final void j(JsonArray items) {
        Intrinsics.h(items, "items");
        Iterator<JsonElement> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JsonObject asJsonObject = it.next().getAsJsonObject();
            Intrinsics.g(asJsonObject, "getAsJsonObject(...)");
            String asString = asJsonObject.get("key").getAsString();
            d dVar = d.f75526a;
            String string = dVar.g().getString(asString, null);
            if (string == null || string.length() == 0 || !StringsKt.c0(string, "\"isFirebase\":true", false, 2, null)) {
                dVar.g().putString(asString, asJsonObject.toString());
            }
        }
        ConfigBean d11 = d(this, "point_config", false, 2, null);
        EventConfig.f43057a.j(d11 != null ? d11.getValue() : null);
        Iterator it2 = this.f75533a.entrySet().iterator();
        while (it2.hasNext()) {
            ConfigBean configBean = (ConfigBean) ((Map.Entry) it2.next()).getValue();
            if (configBean != null) {
                configBean.setHasUpdate(true);
            }
        }
    }
}
