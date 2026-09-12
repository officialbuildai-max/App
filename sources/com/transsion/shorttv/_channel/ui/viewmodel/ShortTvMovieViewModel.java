package com.transsion.shorttv._channel.ui.viewmodel;

import android.app.Application;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.u0;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class ShortTvMovieViewModel extends androidx.view.b {

    /* renamed from: f, reason: collision with root package name */
    public static final a f52691f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f52692b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f52693c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f52694d;

    /* renamed from: e, reason: collision with root package name */
    private final nr.a f52695e;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvMovieViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f52692b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv._channel.ui.viewmodel.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 g11;
                g11 = ShortTvMovieViewModel.g();
                return g11;
            }
        });
        this.f52693c = LazyKt.b(new Function0() { // from class: com.transsion.shorttv._channel.ui.viewmodel.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 n11;
                n11 = ShortTvMovieViewModel.n();
                return n11;
            }
        });
        this.f52694d = LazyKt.b(new Function0() { // from class: com.transsion.shorttv._channel.ui.viewmodel.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 o11;
                o11 = ShortTvMovieViewModel.o();
                return o11;
            }
        });
        this.f52695e = (nr.a) zg.c.f79537e.a().h(nr.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 g() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 n() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 o() {
        return new b0();
    }

    public final void h(String version) {
        Intrinsics.h(version, "version");
        k.d(u0.a(this), y0.b(), null, new ShortTvMovieViewModel$getFilterItems$1(this, version, null), 2, null);
    }

    public final LiveData i() {
        return j();
    }

    public final b0 j() {
        return (b0) this.f52692b.getValue();
    }

    public final void k(int i11, int i12, String str, Map map, boolean z10) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", Integer.valueOf(i11));
        jsonObject.addProperty("perPage", Integer.valueOf(i12));
        jsonObject.addProperty(TmcStartParams.KEY_CHANNEL_ID, str);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (StringsKt.c0((CharSequence) entry.getValue(), ",", false, 2, null)) {
                    JsonArray jsonArray = new JsonArray();
                    Iterator it = StringsKt.S0((CharSequence) entry.getValue(), new String[]{","}, false, 0, 6, null).iterator();
                    while (it.hasNext()) {
                        jsonArray.add((String) it.next());
                    }
                    jsonObject.add((String) entry.getKey(), jsonArray);
                } else {
                    jsonObject.addProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        k.d(u0.a(this), y0.b(), null, new ShortTvMovieViewModel$getMovieList$2(jsonObject, this, z10, str, map, null), 2, null);
    }

    public final LiveData l() {
        return m();
    }

    public final b0 m() {
        return (b0) this.f52693c.getValue();
    }
}
