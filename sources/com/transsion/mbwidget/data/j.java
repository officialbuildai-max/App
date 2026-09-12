package com.transsion.mbwidget.data;

import com.transsion.mbwidget.R$mipmap;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f46323a = new j();

    /* renamed from: b, reason: collision with root package name */
    private static final Map f46324b = MapsKt.l(TuplesKt.a("img_default_1", Integer.valueOf(R$mipmap.img_widget_subject_default_1)), TuplesKt.a("img_default_2", Integer.valueOf(R$mipmap.img_widget_subject_default_2)), TuplesKt.a("img_default_3", Integer.valueOf(R$mipmap.img_widget_subject_default_3)), TuplesKt.a("img_default_4", Integer.valueOf(R$mipmap.img_widget_subject_default_4)));

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f46325c = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Subject e11;
            e11 = j.e();
            return e11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f46326d = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Subject f11;
            f11 = j.f();
            return f11;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f46327e = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Subject g11;
            g11 = j.g();
            return g11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy f46328f = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Subject h11;
            h11 = j.h();
            return h11;
        }
    });

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Subject e() {
        return new Subject("8906247916759695608", null, "Avatar", null, new Cover(null, null, null, "img_default_1", null, null, null, null, null, 503, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -22, 134217727, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Subject f() {
        return new Subject("4191963760367656968", null, "Avengers: Endgame", null, new Cover(null, null, null, "img_default_2", null, null, null, null, null, 503, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -22, 134217727, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Subject g() {
        return new Subject("5390197429792821032", null, "Titanic", null, new Cover(null, null, null, "img_default_3", null, null, null, null, null, 503, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -22, 134217727, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Subject h() {
        return new Subject("9155478106520576008", null, "The Lion King", null, new Cover(null, null, null, "img_default_4", null, null, null, null, null, 503, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -22, 134217727, null);
    }

    private final Subject i() {
        return (Subject) f46325c.getValue();
    }

    private final Subject j() {
        return (Subject) f46326d.getValue();
    }

    private final Subject k() {
        return (Subject) f46327e.getValue();
    }

    private final Subject l() {
        return (Subject) f46328f.getValue();
    }

    public final List m() {
        return CollectionsKt.q(i(), j(), k(), l());
    }

    public final Integer n(String str) {
        return (Integer) f46324b.get(str);
    }
}
