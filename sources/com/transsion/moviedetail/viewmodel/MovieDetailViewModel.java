package com.transsion.moviedetail.viewmodel;

import android.app.Application;
import android.text.SpannableStringBuilder;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.u0;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.gson.JsonObject;
import com.transsion.baselib.locale.d;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.preload.MovieDetailDownloadListLoader;
import com.transsion.moviedetail.preload.MovieDetailResourcesSeasonLoader;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class MovieDetailViewModel extends androidx.view.b {

    /* renamed from: r */
    public static final a f47484r = new a(null);

    /* renamed from: b */
    private final Lazy f47485b;

    /* renamed from: c */
    private final Lazy f47486c;

    /* renamed from: d */
    private final Lazy f47487d;

    /* renamed from: e */
    private final Lazy f47488e;

    /* renamed from: f */
    private final Lazy f47489f;

    /* renamed from: g */
    private final Lazy f47490g;

    /* renamed from: h */
    private final Lazy f47491h;

    /* renamed from: i */
    private final Lazy f47492i;

    /* renamed from: j */
    private final b0 f47493j;

    /* renamed from: k */
    private final Lazy f47494k;

    /* renamed from: l */
    private final b0 f47495l;

    /* renamed from: m */
    private com.transsion.moviedetail.preload.b f47496m;

    /* renamed from: n */
    private MovieDetailDownloadListLoader f47497n;

    /* renamed from: o */
    private MovieDetailResourcesSeasonLoader f47498o;

    /* renamed from: p */
    private final Lazy f47499p;

    /* renamed from: q */
    private boolean f47500q;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieDetailViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f47485b = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 q11;
                q11 = MovieDetailViewModel.q();
                return q11;
            }
        });
        this.f47486c = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 Z;
                Z = MovieDetailViewModel.Z();
                return Z;
            }
        });
        this.f47487d = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 r11;
                r11 = MovieDetailViewModel.r();
                return r11;
            }
        });
        this.f47488e = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 X;
                X = MovieDetailViewModel.X();
                return X;
            }
        });
        this.f47489f = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.moviedetail.viewmodel.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                fn.a b02;
                b02 = MovieDetailViewModel.b0();
                return b02;
            }
        });
        this.f47490g = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qy.a a02;
                a02 = MovieDetailViewModel.a0();
                return a02;
            }
        });
        this.f47491h = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 U;
                U = MovieDetailViewModel.U();
                return U;
            }
        });
        this.f47492i = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 e02;
                e02 = MovieDetailViewModel.e0();
                return e02;
            }
        });
        this.f47493j = new b0();
        this.f47494k = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 Y;
                Y = MovieDetailViewModel.Y();
                return Y;
            }
        });
        this.f47495l = new b0();
        this.f47499p = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 c02;
                c02 = MovieDetailViewModel.c0();
                return c02;
            }
        });
    }

    private final Locale C(String str) {
        Locale locale = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    locale = Intrinsics.c(str, "in_id") ? new Locale("id") : new Locale(str);
                }
            } catch (Exception unused) {
            }
        }
        return locale;
    }

    public static /* synthetic */ void E(MovieDetailViewModel movieDetailViewModel, String str, Integer num, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        movieDetailViewModel.D(str, num, z10);
    }

    private final b0 G() {
        return (b0) this.f47491h.getValue();
    }

    private final void M(String str) {
        MovieDetailResourcesSeasonLoader movieDetailResourcesSeasonLoader = this.f47498o;
        if (movieDetailResourcesSeasonLoader != null) {
            if (str == null) {
                str = "";
            }
            movieDetailResourcesSeasonLoader.p(str);
        }
        MovieDetailResourcesSeasonLoader movieDetailResourcesSeasonLoader2 = this.f47498o;
        if (movieDetailResourcesSeasonLoader2 != null) {
            movieDetailResourcesSeasonLoader2.f(L());
        }
    }

    public final fn.a N() {
        return (fn.a) this.f47489f.getValue();
    }

    public final qy.a O() {
        return (qy.a) this.f47490g.getValue();
    }

    public final b0 R() {
        return (b0) this.f47492i.getValue();
    }

    public static /* synthetic */ void T(MovieDetailViewModel movieDetailViewModel, int i11, String str, Integer num, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            num = null;
        }
        movieDetailViewModel.S(i11, str, num);
    }

    public static final b0 U() {
        return new b0();
    }

    public static /* synthetic */ void W(MovieDetailViewModel movieDetailViewModel, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        movieDetailViewModel.V(str, z10);
    }

    public static final b0 X() {
        return new b0();
    }

    public static final b0 Y() {
        return new b0();
    }

    public static final b0 Z() {
        return new b0();
    }

    public static final qy.a a0() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    public static final fn.a b0() {
        return (fn.a) zg.c.f79537e.a().h(fn.a.class);
    }

    public static final b0 c0() {
        return new b0();
    }

    public static final b0 e0() {
        return new b0();
    }

    public static final b0 q() {
        return new b0();
    }

    public static final b0 r() {
        return new b0();
    }

    public static /* synthetic */ void u(MovieDetailViewModel movieDetailViewModel, String str, Integer num, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 1;
        }
        movieDetailViewModel.t(str, num, i11, z10);
    }

    public final LiveData A() {
        return this.f47493j;
    }

    public final boolean B() {
        return this.f47500q;
    }

    public final void D(String subjectId, Integer num, boolean z10) {
        Intrinsics.h(subjectId, "subjectId");
        com.transsion.moviedetail.preload.b bVar = this.f47496m;
        if (bVar != null) {
            bVar.q(subjectId);
        }
        com.transsion.moviedetail.preload.b bVar2 = this.f47496m;
        if (bVar2 != null) {
            bVar2.p(num);
        }
        com.transsion.moviedetail.preload.b bVar3 = this.f47496m;
        if (bVar3 != null) {
            bVar3.o(z10);
        }
        com.transsion.moviedetail.preload.b bVar4 = this.f47496m;
        if (bVar4 != null) {
            bVar4.f(G());
        }
    }

    public final LiveData F() {
        return G();
    }

    public final b0 H() {
        return this.f47495l;
    }

    public final b0 I() {
        return (b0) this.f47488e.getValue();
    }

    public final void J() {
        this.f47500q = true;
        kotlinx.coroutines.k.d(u0.a(this), null, null, new MovieDetailViewModel$getRoomPostEntrance$1(this, null), 3, null);
    }

    public final b0 K() {
        return (b0) this.f47494k.getValue();
    }

    public final b0 L() {
        return (b0) this.f47486c.getValue();
    }

    public final b0 P() {
        return (b0) this.f47499p.getValue();
    }

    public final LiveData Q() {
        return R();
    }

    public final void S(int i11, String subjectId, Integer num) {
        qm.b bVar;
        qm.b bVar2;
        Object obj;
        Object obj2;
        Intrinsics.h(subjectId, "subjectId");
        List a11 = qm.e.f73767a.a(i11);
        Object obj3 = null;
        if (a11 != null) {
            Iterator it = a11.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it.next();
                    if (((qm.b) obj2) instanceof com.transsion.moviedetail.preload.b) {
                        break;
                    }
                }
            }
            bVar = (qm.b) obj2;
        } else {
            bVar = null;
        }
        com.transsion.moviedetail.preload.b bVar3 = (com.transsion.moviedetail.preload.b) bVar;
        if (bVar3 == null) {
            bVar3 = new com.transsion.moviedetail.preload.b(subjectId, num, false, 4, null);
        }
        this.f47496m = bVar3;
        if (a11 != null) {
            Iterator it2 = a11.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it2.next();
                    if (((qm.b) obj) instanceof MovieDetailDownloadListLoader) {
                        break;
                    }
                }
            }
            bVar2 = (qm.b) obj;
        } else {
            bVar2 = null;
        }
        MovieDetailDownloadListLoader movieDetailDownloadListLoader = (MovieDetailDownloadListLoader) bVar2;
        if (movieDetailDownloadListLoader == null) {
            movieDetailDownloadListLoader = new MovieDetailDownloadListLoader(subjectId);
        }
        this.f47497n = movieDetailDownloadListLoader;
        if (a11 != null) {
            Iterator it3 = a11.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                if (((qm.b) next) instanceof MovieDetailResourcesSeasonLoader) {
                    obj3 = next;
                    break;
                }
            }
            obj3 = (qm.b) obj3;
        }
        MovieDetailResourcesSeasonLoader movieDetailResourcesSeasonLoader = (MovieDetailResourcesSeasonLoader) obj3;
        if (movieDetailResourcesSeasonLoader == null) {
            movieDetailResourcesSeasonLoader = new MovieDetailResourcesSeasonLoader(subjectId);
        }
        this.f47498o = movieDetailResourcesSeasonLoader;
        M(subjectId);
        z(subjectId);
    }

    public final void V(String str, boolean z10) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new MovieDetailViewModel$postRequestResource$1(str, z10, this, null), 3, null);
    }

    public final void d0(String subjectId, int i11) {
        Intrinsics.h(subjectId, "subjectId");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("subjectId", subjectId);
        jsonObject.addProperty(EventConstants.KEY_ACTION, Integer.valueOf(i11));
        kotlinx.coroutines.k.d(u0.a(this), null, null, new MovieDetailViewModel$wantToSee$1(jsonObject, this, null), 3, null);
    }

    public final void s(boolean z10, String str, Integer num, int i11, boolean z11) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new MovieDetailViewModel$fetchLocalRec$1(z10, str, num, i11, z11, this, null), 2, null);
    }

    public final void t(String str, Integer num, int i11, boolean z10) {
        if (str == null || str.length() == 0) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new MovieDetailViewModel$fetchRec$1(str, num, i11, z10, this, null), 2, null);
    }

    public final CharSequence v(String str) {
        List S0;
        List U0 = (str == null || (S0 = StringsKt.S0(str, new String[]{","}, false, 0, 6, null)) == null) ? null : CollectionsKt.U0(S0);
        List list = U0;
        if (list == null || list.isEmpty()) {
            return null;
        }
        d.b bVar = com.transsion.baselib.locale.d.f43351f;
        Locale l11 = bVar.e().l();
        Locale k11 = bVar.e().k();
        int i11 = -1;
        int i12 = 0;
        if (Intrinsics.c(l11, k11)) {
            Iterator it = U0.iterator();
            int i13 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Locale C = C((String) it.next());
                if (Intrinsics.c(C != null ? C.getLanguage() : null, l11 != null ? l11.getLanguage() : null)) {
                    i11 = i13;
                    break;
                }
                i13++;
            }
            if (i11 > 0) {
                U0.add(0, U0.remove(i11));
            }
        } else {
            Iterator it2 = U0.iterator();
            int i14 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i14 = -1;
                    break;
                }
                Locale C2 = C((String) it2.next());
                if (Intrinsics.c(C2 != null ? C2.getLanguage() : null, k11 != null ? k11.getLanguage() : null)) {
                    break;
                }
                i14++;
            }
            if (i14 > 0) {
                U0.add(0, U0.remove(i14));
            }
            Iterator it3 = U0.iterator();
            int i15 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Locale C3 = C((String) it3.next());
                if (Intrinsics.c(C3 != null ? C3.getLanguage() : null, l11 != null ? l11.getLanguage() : null)) {
                    i11 = i15;
                    break;
                }
                i15++;
            }
            if (i11 > 0) {
                U0.add(0, U0.remove(i11));
            }
        }
        Application b11 = b();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) b11.getString(R$string.movie_detail_subtitles));
        spannableStringBuilder.append((CharSequence) " ");
        for (Object obj : U0) {
            int i16 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            spannableStringBuilder.append((CharSequence) obj);
            if (i12 != U0.size() - 1) {
                spannableStringBuilder.append((CharSequence) ", ");
            }
            i12 = i16;
        }
        return spannableStringBuilder;
    }

    public final b0 w() {
        return (b0) this.f47487d.getValue();
    }

    public final void x(String str, int i11, int i12, int i13, int i14) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new MovieDetailViewModel$getDownloadList$1(this, str, i14, i11, i12, i13, null), 3, null);
    }

    public final b0 y() {
        return (b0) this.f47485b.getValue();
    }

    public final void z(String str) {
        MovieDetailDownloadListLoader movieDetailDownloadListLoader = this.f47497n;
        if (movieDetailDownloadListLoader != null) {
            if (str == null) {
                str = "";
            }
            movieDetailDownloadListLoader.p(str);
        }
        MovieDetailDownloadListLoader movieDetailDownloadListLoader2 = this.f47497n;
        if (movieDetailDownloadListLoader2 != null) {
            movieDetailDownloadListLoader2.f(y());
        }
    }
}
