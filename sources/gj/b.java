package gj;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tencent.mmkv.MMKV;
import com.transsion.base.infras_config.model.ConfigInitData;
import com.transsion.base.infras_config.model.ConfigInitDataItem;
import com.transsion.base.infras_config.model.ConfigInitRspCode;
import com.transsion.base.infras_config.model.ConfigLocalState;
import com.transsion.base.infras_config.model.InfrasSourceType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f63746a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f63747b = LazyKt.b(new Function0() { // from class: gj.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV i11;
            i11 = b.i();
            return i11;
        }
    });

    private b() {
    }

    private final MMKV e() {
        return (MMKV) f63747b.getValue();
    }

    private final String f(InfrasSourceType infrasSourceType) {
        return "source_" + infrasSourceType.name() + "_code";
    }

    private final String g(InfrasSourceType infrasSourceType) {
        return "source_" + infrasSourceType.name() + "_configs";
    }

    private final String h(InfrasSourceType infrasSourceType) {
        return "source_" + infrasSourceType.name() + "_version";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV i() {
        MMKV I = MMKV.I("infras_init_config");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final ConfigInitData b(List sourceVersions) {
        Intrinsics.h(sourceVersions, "sourceVersions");
        if (sourceVersions.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = sourceVersions.iterator();
        while (it.hasNext()) {
            ConfigInitDataItem c11 = f63746a.c(((ConfigLocalState) it.next()).getSourceType());
            if (c11 != null) {
                arrayList.add(c11);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new ConfigInitData(e().getString("globalVersion", null), arrayList, null);
    }

    public final ConfigInitDataItem c(InfrasSourceType sourceType) {
        Object m1185constructorimpl;
        Intrinsics.h(sourceType, "sourceType");
        try {
            String string = e().getString(g(sourceType), null);
            if (string == null) {
                return null;
            }
            JsonElement parseString = JsonParser.parseString(string);
            Intrinsics.g(parseString, "parseString(...)");
            String string2 = e().getString(h(sourceType), null);
            String string3 = e().getString(f(sourceType), null);
            try {
                Result.Companion companion = Result.INSTANCE;
                if (string3 == null) {
                    string3 = "";
                }
                m1185constructorimpl = Result.m1185constructorimpl(ConfigInitRspCode.valueOf(string3));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (Result.m1191isFailureimpl(m1185constructorimpl)) {
                m1185constructorimpl = null;
            }
            return new ConfigInitDataItem(sourceType, string2, parseString, (ConfigInitRspCode) m1185constructorimpl);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final long d() {
        return e().getLong("lastInitTime", 0L);
    }

    public final void j(ConfigInitData data, long j11) {
        Intrinsics.h(data, "data");
        k(j11);
        String version = data.getVersion();
        if (version != null) {
            f63746a.e().putString("globalVersion", version);
        }
        new Gson();
        List<ConfigInitDataItem> items = data.getItems();
        if (items != null) {
            for (ConfigInitDataItem configInitDataItem : items) {
                InfrasSourceType sourceType = configInitDataItem.getSourceType();
                if (sourceType != null) {
                    JsonElement configs = configInitDataItem.getConfigs();
                    if (configs != null) {
                        b bVar = f63746a;
                        bVar.e().putString(bVar.g(sourceType), configs.toString());
                    }
                    String version2 = configInitDataItem.getVersion();
                    if (version2 != null) {
                        b bVar2 = f63746a;
                        bVar2.e().putString(bVar2.h(sourceType), version2);
                    }
                    ConfigInitRspCode code = configInitDataItem.getCode();
                    if (code != null) {
                        b bVar3 = f63746a;
                        bVar3.e().putString(bVar3.f(sourceType), code.name());
                    }
                }
            }
        }
    }

    public final void k(long j11) {
        e().putLong("lastInitTime", j11);
    }

    public final void l(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            e().M("localStates");
        } else {
            e().putString("localStates", new Gson().toJsonTree(list).toString());
        }
    }
}
